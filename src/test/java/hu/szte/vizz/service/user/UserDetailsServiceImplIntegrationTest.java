package hu.szte.vizz.service.user;

import hu.szte.vizz.persistence.entity.user.User;
import hu.szte.vizz.persistence.repository.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class UserDetailsServiceImplIntegrationTest {

    @TestConfiguration
    static class UserDetailsServiceImplIntegrationTestContextConfiguration {

        @Autowired
        private UserRepository userRepository;

        @Bean
        public UserDetailsService userDetailsService() {
            return new UserDetailsServiceImpl(userRepository);
        }
    }

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    private User user1, user2;

    @Before
    public void setUp() {
        user1 = new User()
                .setId(UUID.randomUUID())
                .setUsername("alex1")
                .setEmail("alex1@email.com")
                .setPassword("passw0rd")
                .setFirstName("Alex")
                .setLastName("Doe")
                .setActivated(true);
        user2 = new User()
                .setId(UUID.randomUUID())
                .setUsername("eva1")
                .setEmail("eva1@email.com")
                .setPassword("M0nkey!")
                .setFirstName("Eva")
                .setLastName("Doe")
                .setAdmin(true)
                .setActivated(true);

        Mockito.when(userRepository.findByUsername(any(String.class))).thenReturn(Optional.empty());
        Mockito.when(userRepository.findByUsername(user1.getUsername())).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findByUsername(user2.getUsername())).thenReturn(Optional.of(user2));
    }

    @Test
    public void When_loadUserByUsername_Expect_correctUser() {
        UserDetails expect = new org.springframework.security.core.userdetails.User(
                user1.getUsername().toLowerCase(),
                user1.getPassword(),
                user1.isActivated(),
                true,
                true,
                true,
                new ArrayList<>()
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(user1.getUsername());
        assertEquals(expect, userDetails);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void When_loadUnknownUserByUsername_Expect_Exception() {
        userDetailsService.loadUserByUsername("NotUser");
    }

    @Test
    public void When_loadUserAdminByUsername() {
        UserDetails expect = new org.springframework.security.core.userdetails.User(
                user2.getUsername().toLowerCase(),
                user2.getPassword(),
                user2.isActivated(),
                true,
                true,
                true,
                Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(user2.getUsername());
        assertEquals(expect, userDetails);
    }
}