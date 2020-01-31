package hu.szte.vizz.service.user;

import hu.szte.vizz.exception.TokenNotFoundException;
import hu.szte.vizz.exception.UserActivatedException;
import hu.szte.vizz.exception.UserExistsException;
import hu.szte.vizz.exception.UserNotFoundException;
import hu.szte.vizz.model.user.RegisterDTO;
import hu.szte.vizz.model.user.TokenDTO;
import hu.szte.vizz.model.user.UserDTO;
import hu.szte.vizz.persistence.entity.user.User;
import hu.szte.vizz.persistence.repository.user.EmailActivationTokenRepository;
import hu.szte.vizz.persistence.repository.user.ForgottenPasswordTokenRepository;
import hu.szte.vizz.persistence.repository.user.LocationRepository;
import hu.szte.vizz.persistence.repository.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.*;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserServiceImplIntegrationTest {
    @MockBean
    private UserRepository userRepository;

    @MockBean
    private LocationRepository locationRepository;

    @MockBean
    private EmailActivationTokenRepository emailActivationTokenRepository;

    @MockBean
    private ForgottenPasswordTokenRepository forgottenPasswordTokenRepository;

    @TestConfiguration
    static class UserServiceImplIntegrationTestContextConfiguration {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private LocationRepository locationRepository;

        @Autowired
        private EmailActivationTokenRepository emailActivationTokenRepository;

        @Autowired
        private ForgottenPasswordTokenRepository forgottenPasswordTokenRepository;

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder(11);
        }

        @Bean
        public MailSender mailSender() {
            return new JavaMailSenderImpl();
        }

        @Bean
        public UserService userService() {
            return new UserServiceImpl(
                    userRepository,
                    locationRepository,
                    passwordEncoder(),
                    mailSender(),
                    emailActivationTokenRepository,
                    forgottenPasswordTokenRepository
            );
        }
    }

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private MailSender mailSender;

    @Autowired
    private UserService userService;

    User user1, user2, user3, regUser, regUserReturn;

    UserDTO user1DTO, user2DTO, user3DTO, regUserReturnDTO;

    RegisterDTO regDTO;

    @Before
    public void setUp() {
        user1 = new User()
                .setId(UUID.randomUUID())
                .setUsername("alex1")
                .setEmail("alex1@email.com")
                .setPassword(BCrypt.hashpw("passw0rd", BCrypt.gensalt()))
                .setFirstName("Alex")
                .setLastName("Doe")
                .setActivated(true);
        user2 = new User()
                .setId(UUID.randomUUID())
                .setUsername("eva1")
                .setEmail("eva1@email.com")
                .setPassword(BCrypt.hashpw("M0nkey!", BCrypt.gensalt()))
                .setFirstName("Eva")
                .setLastName("Doe")
                .setAdmin(true)
                .setActivated(true);
        user3 = new User()
                .setId(UUID.randomUUID())
                .setUsername("jane1")
                .setEmail("janedoe@email.com")
                .setPassword(BCrypt.hashpw("Sup3rS4fe", BCrypt.gensalt()))
                .setFirstName("Jane")
                .setLastName("Doe")
                .setAdmin(true)
                .setActivated(false);

        regDTO = new RegisterDTO()
                .setEmail("example@example.com")
                .setUsername("adam")
                .setFirstName("Adam")
                .setLastName("Doe")
                .setPassword("adam1234")
                .setPasswordAgain("adam1234")
                .setZip("2312")
                .setCity("Nowhereville")
                .setStreet("Main str.")
                .setAddress("23")
                .setPhone("1221334304");

        Mockito.when(passwordEncoder.encode("adam1234")).thenReturn("$2a$11$MOCHtySsZAWrpkYMZLbdbuVzu9keFHcI0C/WsQzotADd7.JmYR4d6");

        regUser = new User()
                .setEmail("example@example.com")
                .setUsername("adam")
                .setPhone("1221334304")
                .setFirstName("Adam")
                .setLastName("Doe")
                .setPassword(passwordEncoder.encode("adam1234"));

        regUserReturn = new User()
                .setId(UUID.randomUUID())
                .setActivated(false)
                .setEmail("example@example.com")
                .setUsername("adam")
                .setPhone("1221334304")
                .setFirstName("Adam")
                .setLastName("Doe")
                .setPassword(passwordEncoder.encode("adam1234"))
                .setAdmin(false);

        user1DTO = UserServiceImpl.fromUserEntity(user1);
        user2DTO = UserServiceImpl.fromUserEntity(user2);
        user3DTO = UserServiceImpl.fromUserEntity(user3);
        regUserReturnDTO = UserServiceImpl.fromUserEntity(regUserReturn);

        Mockito.when(userRepository.findById(user1.getId()))
                .thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findById(user3.getId()))
                .thenReturn(Optional.of(user3));
        Mockito.when(userRepository.findById(UUID.fromString("4428431F-8DBD-4F17-BDE5-71073112A1A9")))
                .thenReturn(Optional.empty());
        Mockito.when(userRepository.findByUsername(user1.getUsername())).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findByUsername("notuser")).thenReturn(Optional.empty());
        Mockito.when(userRepository.findByEmail(user1.getEmail())).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findByEmail("notemail")).thenReturn(Optional.empty());
        Mockito.doNothing().when(userRepository).deleteById(user1.getId());
        Mockito.doNothing().when(emailActivationTokenRepository).deleteAllByUser(any(User.class));
        Mockito.doNothing().when(forgottenPasswordTokenRepository).deleteAllByUser(any(User.class));
        Mockito.when(emailActivationTokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(any(), any(), any()))
                .thenReturn(false);
        Mockito.when(emailActivationTokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(eq("df617ccaa0073290debc62ca0c988f52"), eq(user3), any(Date.class)))
                .thenReturn(true);
        Mockito.doNothing().when(mailSender).send(any(SimpleMailMessage.class));

        Mockito.when(userRepository.save(regUser)).thenReturn(regUserReturn);
    }

    @Test
    public void When_getUserById_Expect_correctUserReturned() {
        UserDTO user = userService.getUserById(user1DTO.getId());
        assertEquals(user1DTO, user);
    }

    @Test(expected = UserNotFoundException.class)
    public void When_getUnknownUserById_Expect_UserNotFoundException() {
        userService.getUserById(UUID.fromString("4428431F-8DBD-4F17-BDE5-71073112A1A9"));
    }

    @Test
    public void When_registerUser_Expect_correctUserRegistered() {
        UserDTO expectedUser = new UserDTO()
                .setId(regUserReturnDTO.getId())
                .setUsername(regDTO.getUsername())
                .setEmail(regDTO.getEmail())
                .setFirstName(regDTO.getFirstName())
                .setLastName(regDTO.getLastName())
                .setPhone(regDTO.getPhone())
                .setAdmin(false);
        UserDTO user = userService.registerUser(regDTO);

        assertEquals(expectedUser, user);
    }

    @Test(expected = UserExistsException.class)
    public void When_registerUsernameExistsUser_Expect_UserExistsException() {
        RegisterDTO register = new RegisterDTO()
                .setUsername(user1.getUsername());
        userService.registerUser(register);
    }

    @Test(expected = UserExistsException.class)
    public void When_registerEmailExistsUser_Expect_UserExistsException() {
        RegisterDTO register = new RegisterDTO()
                .setEmail(user1.getEmail());
        userService.registerUser(register);
    }

    @Test
    public void When_deleteUser_Expect_NoErrors() {
        userService.deleteUser(user1DTO);
    }

    @Test(expected = UserNotFoundException.class)
    public void When_deleteUnknownUser_Expect_UserNotFoundException() {
        userService.deleteUser(new UserDTO().setId(UUID.randomUUID()));
    }

    @Test
    public void When_usernameExists_Expect_True() {
        assertTrue(userService.usernameExists(user1.getUsername()));
    }

    @Test
    public void When_usernameNotExists_Expect_False() {
        assertFalse(userService.usernameExists("notuser"));
    }

    @Test
    public void When_emailExists_Expect_True() {
        assertTrue(userService.emailExists(user1.getEmail()));
    }

    @Test
    public void When_emailNotExists_Expect_False() {
        assertFalse(userService.emailExists("notemail"));
    }

    @Test
    public void When_sendActivationMail_Expect_NoErrors() {
        userService.sendActivationMail(user3DTO);
    }

    @Test(expected = UserActivatedException.class)
    public void When_sendAlreadyActivatedActivationMail_Expect_UserActivatedException() {
        userService.sendActivationMail(user1DTO);
    }

    @Test(expected = UserNotFoundException.class)
    public void When_sendUnknownUserActivationMail_Expect_UserNotFoundException() {
        userService.sendActivationMail(new UserDTO().setId(UUID.randomUUID()));
    }

    @Test
    public void When_confirmEmailActivation_Expect_NoErrorsReturned() {
        TokenDTO tokenDTO = new TokenDTO()
                .setUserId(user3.getId())
                .setToken("df617ccaa0073290debc62ca0c988f52");
        userService.confirmEmailActivation(tokenDTO);
    }

    @Test(expected = UserNotFoundException.class)
    public void When_confirmUnknownUserEmailActivation_Expect_UserNotFoundException() {
        TokenDTO tokenDTO = new TokenDTO()
                .setUserId(UUID.randomUUID())
                .setToken("token");
        userService.confirmEmailActivation(tokenDTO);
    }

    @Test(expected = TokenNotFoundException.class)
    public void When_confirmUnknownTokenEmailActivation_Expect_TokenNotFoundException() {
        TokenDTO tokenDTO = new TokenDTO()
                .setUserId(user3.getId())
                .setToken("token");
        userService.confirmEmailActivation(tokenDTO);
    }

    @Test(expected = UserActivatedException.class)
    public void When_confirmActivatedUserEmailActivation_Expect_UserActivatedException() {
        TokenDTO tokenDTO = new TokenDTO()
                .setUserId(user1.getId())
                .setToken("token");
        userService.confirmEmailActivation(tokenDTO);
    }

    @Test
    public void When_fromUserEntity_Expect_correctlyConverted() {
        UserDTO expectedUser = new UserDTO()
                .setId(user1.getId())
                .setUsername(user1.getUsername())
                .setEmail(user1.getEmail())
                .setPhone(user1.getPhone())
                .setFirstName(user1.getFirstName())
                .setLastName(user1.getLastName())
                .setAdmin(user1.isAdmin());

        assertEquals(expectedUser, user1DTO);
    }
}