package hu.szte.vizz.persistence.repository.user;

import hu.szte.vizz.persistence.entity.user.ForgottenPasswordToken;
import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ForgottenPasswordTokenRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ForgottenPasswordTokenRepository tokenRepository;

    private User user1, user2;

    private ForgottenPasswordToken token1, token2, token3;

    @Before
    public void setUp() {
        user1 = new User()
                .setUsername("alex1")
                .setEmail("alex1@email.com")
                .setPassword(BCrypt.hashpw("passw0rd", BCrypt.gensalt()))
                .setFirstName("Alex")
                .setLastName("Doe");
        user2 = new User()
                .setUsername("eva1")
                .setEmail("eva1@email.com")
                .setPassword(BCrypt.hashpw("M0nkey!", BCrypt.gensalt()))
                .setFirstName("Eva")
                .setLastName("Doe")
                .setAdmin(true);
        entityManager.persist(user1);
        entityManager.persist(user2);
        token1 = new ForgottenPasswordToken()
                .setUser(user1)
                .setToken(createRandomString())
                .setExpiryDate(Date.from(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.UTC)));
        token2 = new ForgottenPasswordToken()
                .setUser(user1)
                .setToken(createRandomString())
                .setExpiryDate(Date.from(LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC)));
        token3 = new ForgottenPasswordToken()
                .setUser(user2)
                .setToken(createRandomString())
                .setExpiryDate(Date.from(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.UTC)));
        entityManager.persist(token1);
        entityManager.persist(token2);
        entityManager.persist(token3);
        entityManager.flush();
    }

    @Test
    public void When_existsByTokenAndUserAndExpiryDateIsAfter_Expect_correctValue() {
        assertTrue(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token1.getToken(), user1, new Date()));
        assertFalse(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token2.getToken(), user1, new Date()));
        assertFalse(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token1.getToken(), user2, new Date()));
    }

    @Test
    public void When_deleteAllByUser_Expect_deletedCorrectTokens() {
        User user3 = new User()
                .setUsername("jane1")
                .setEmail("janedoe@email.com")
                .setPassword(BCrypt.hashpw("Sup3rS4fe", BCrypt.gensalt()))
                .setFirstName("Jane")
                .setLastName("Doe")
                .setAdmin(true);
        entityManager.persist(user3);
        ForgottenPasswordToken token4 = new ForgottenPasswordToken()
                .setUser(user3)
                .setToken(createRandomString())
                .setExpiryDate(Date.from(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.UTC)));
        ForgottenPasswordToken token5 = new ForgottenPasswordToken()
                .setUser(user3)
                .setToken(createRandomString())
                .setExpiryDate(Date.from(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.UTC)));
        entityManager.persist(token4);
        entityManager.persist(token5);
        entityManager.flush();
        assertTrue(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token4.getToken(), user3, new Date()));
        assertTrue(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token5.getToken(), user3, new Date()));
        tokenRepository.deleteAllByUser(user3);
        assertFalse(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token4.getToken(), user3, new Date()));
        assertFalse(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token5.getToken(), user3, new Date()));
        assertTrue(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token1.getToken(), user1, new Date()));
    }

    @Test
    public void When_deleteAllByExpiryDateBefore_Expect_correctValuesDeleted() {
        ForgottenPasswordToken token4 = new ForgottenPasswordToken()
                .setUser(user1)
                .setToken(createRandomString())
                .setExpiryDate(Date.from(LocalDateTime.now().minusDays(10).toInstant(ZoneOffset.UTC)));
        ForgottenPasswordToken token5 = new ForgottenPasswordToken()
                .setUser(user1)
                .setToken(createRandomString())
                .setExpiryDate(Date.from(LocalDateTime.now().minusDays(10).toInstant(ZoneOffset.UTC)));
        entityManager.persist(token4);
        entityManager.persist(token5);
        entityManager.flush();
        assertTrue(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token4.getToken(), user1, Date.from(LocalDateTime.now().minusDays(20).toInstant(ZoneOffset.UTC))));
        assertTrue(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token5.getToken(), user1, Date.from(LocalDateTime.now().minusDays(20).toInstant(ZoneOffset.UTC))));
        tokenRepository.deleteAllByExpiryDateBefore(Date.from(LocalDateTime.now().minusDays(5).toInstant(ZoneOffset.UTC)));
        assertFalse(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token4.getToken(), user1, Date.from(LocalDateTime.now().minusDays(20).toInstant(ZoneOffset.UTC))));
        assertFalse(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token5.getToken(), user1, Date.from(LocalDateTime.now().minusDays(10).toInstant(ZoneOffset.UTC))));
        assertTrue(tokenRepository.existsByTokenAndUserAndExpiryDateIsAfter(token1.getToken(), user1, new Date()));
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