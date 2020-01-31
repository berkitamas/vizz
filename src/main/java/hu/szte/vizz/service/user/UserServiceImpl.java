package hu.szte.vizz.service.user;

import hu.szte.vizz.exception.TokenNotFoundException;
import hu.szte.vizz.exception.UserActivatedException;
import hu.szte.vizz.exception.UserExistsException;
import hu.szte.vizz.exception.UserNotFoundException;
import hu.szte.vizz.model.user.RegisterDTO;
import hu.szte.vizz.model.user.TokenDTO;
import hu.szte.vizz.model.user.UserDTO;
import hu.szte.vizz.persistence.entity.user.EmailActivationToken;
import hu.szte.vizz.persistence.entity.user.Location;
import hu.szte.vizz.persistence.entity.user.User;
import hu.szte.vizz.persistence.repository.user.EmailActivationTokenRepository;
import hu.szte.vizz.persistence.repository.user.ForgottenPasswordTokenRepository;
import hu.szte.vizz.persistence.repository.user.LocationRepository;
import hu.szte.vizz.persistence.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Value("${spring.application.url}")
    private String appUrl;

    private final UserRepository userRepository;

    private final LocationRepository locationRepository;

    private final PasswordEncoder passwordEncoder;

    private final MailSender mailSender;

    private final EmailActivationTokenRepository emailActivationTokenRepository;

    private final ForgottenPasswordTokenRepository forgottenPasswordTokenRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, LocationRepository locationRepository, PasswordEncoder passwordEncoder, MailSender mailSender, EmailActivationTokenRepository emailActivationTokenRepository, ForgottenPasswordTokenRepository forgottenPasswordTokenRepository) {
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
        this.emailActivationTokenRepository = emailActivationTokenRepository;
        this.forgottenPasswordTokenRepository = forgottenPasswordTokenRepository;
    }

    @Override
    public UserDTO getUserById(UUID id) {
        return userRepository.findById(id).map(UserServiceImpl::fromUserEntity)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserDTO registerUser(RegisterDTO requestUser) throws UserExistsException {
        if (usernameExists(requestUser.getUsername()) || emailExists(requestUser.getEmail())) {
            throw new UserExistsException();
        }
        User user = new User()
                .setUsername(requestUser.getUsername())
                .setPassword(passwordEncoder.encode(requestUser.getPassword()))
                .setEmail(requestUser.getEmail())
                .setFirstName(requestUser.getFirstName())
                .setLastName(requestUser.getLastName())
                .setPhone(requestUser.getPhone());
        Location location = new Location()
                .setTitle("Home")
                .setZip(requestUser.getZip())
                .setCity(requestUser.getCity())
                .setStreet(requestUser.getStreet())
                .setAddress(requestUser.getAddress())
                .setDefault(true);
        user = userRepository.save(user);
        location.setUser(user);
        locationRepository.save(location);
        return fromUserEntity(user);
    }

    @Override
    public void deleteUser(UserDTO userDTO) {
        Optional<User> user = userRepository.findById(userDTO.getId());
        if (!user.isPresent()) {
            throw new UserNotFoundException();
        }
        userRepository.deleteById(user.get().getId());
        emailActivationTokenRepository.deleteAllByUser(user.get());
        forgottenPasswordTokenRepository.deleteAllByUser(user.get());
        // All locations will be deleted
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public void sendActivationMail(UserDTO userDTO) {

        User user = userRepository.findById(userDTO.getId())
                .orElseThrow(UserNotFoundException::new);
        if (user.isActivated()) {
            throw new UserActivatedException();
        }
        EmailActivationToken token = new EmailActivationToken()
                .setUser(user)
                .setToken(createRandomString())
                .setExpiryDate(Date.from(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.UTC)));
        String recipentAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String message = "Confirm registration: " + appUrl + "/confirmRegistration?token=" + token.getToken() + "&user=" + token.getUser().getId();
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipentAddress);
        email.setSubject(subject);
        email.setText(message);
        mailSender.send(email);
    }

    @Override
    public void confirmEmailActivation(TokenDTO token) {
        Date now = Date.from(Instant.now());
        User user = userRepository.findById(token.getUserId())
                .orElseThrow(UserNotFoundException::new);
        if (user.isActivated()) {
            throw new UserActivatedException();
        }
        if (emailActivationTokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token.getToken(), user, now)) {
            user.setActivated(true);
            user = userRepository.save(user);
            emailActivationTokenRepository.deleteAllByUser(user);
        } else {
            throw new TokenNotFoundException();
        }
    }

    static UserDTO fromUserEntity(User user) {
        return new UserDTO()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPhone(user.getPhone())
                .setAdmin(user.isAdmin());
    }

    private String createRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 16) {
            sb.append(Integer.toHexString(random.nextInt()));
        }
        return sb.toString();
    }
}
