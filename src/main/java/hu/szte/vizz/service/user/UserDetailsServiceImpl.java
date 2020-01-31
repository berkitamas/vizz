package hu.szte.vizz.service.user;

import hu.szte.vizz.persistence.entity.user.User;
import hu.szte.vizz.persistence.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService  {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username.toLowerCase())
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username.toLowerCase()));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername().toLowerCase(),
                user.getPassword(),
                user.isActivated(),
                true,
                true,
                true,
                (user.isAdmin())
                        ? Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
                        : new ArrayList <>()
        );
    }

}
