package hu.szte.vizz.event.listener;

import hu.szte.vizz.event.OnRegistrationCompleteEvent;
import hu.szte.vizz.model.user.UserDTO;
import hu.szte.vizz.service.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class RegistrationListenerIntegrationTest {
    @TestConfiguration
    static class RegistrationListenerIntegrationTestContextConfiguration {
        @Autowired
        private UserService userService;

        @Bean
        public RegistrationListener registrationListener() {
            return new RegistrationListener(userService);
        }
    }

    @Autowired
    private RegistrationListener registrationListener;

    @MockBean
    private UserService userService;

    @Before
    public void setUp() {
        Mockito.doNothing().when(userService).sendActivationMail(any());
    }

    @Test
    public void When_onApplicationEvent_Expect_noErrors() {
        UserDTO user1 = new UserDTO()
                .setId(UUID.randomUUID())
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setAdmin(true);
        OnRegistrationCompleteEvent event = new OnRegistrationCompleteEvent(user1);
        registrationListener.onApplicationEvent(event);
    }
}