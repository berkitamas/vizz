package hu.szte.vizz.task;

import hu.szte.vizz.persistence.repository.user.EmailActivationTokenRepository;
import hu.szte.vizz.persistence.repository.user.ForgottenPasswordTokenRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class TokensPurgeTaskIntegrationTest {

    @TestConfiguration
    static class TokensPurgeTaskIntegrationTestContextConfiguration {
        @Autowired
        private EmailActivationTokenRepository emailActivationTokenRepository;

        @Autowired
        private ForgottenPasswordTokenRepository forgottenPasswordTokenRepository;

        @Bean
        public TokensPurgeTask tokensPurgeTask() {
            return new TokensPurgeTask(
                    emailActivationTokenRepository,
                    forgottenPasswordTokenRepository
            );
        }
    }

    @MockBean
    private EmailActivationTokenRepository emailActivationTokenRepository;

    @MockBean
    private ForgottenPasswordTokenRepository forgottenPasswordTokenRepository;

    @Autowired
    private TokensPurgeTask purgeTask;


    @Before
    public void setUp() {
        Mockito.doNothing().when(emailActivationTokenRepository).deleteAllByExpiryDateBefore(any(Date.class));
        Mockito.doNothing().when(forgottenPasswordTokenRepository).deleteAllByExpiryDateBefore(any(Date.class));
    }

    @Test
    public void When_purgeExpired_Expect_noErrors() {
        purgeTask.purgeExpired();
    }
}