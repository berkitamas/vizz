package hu.szte.vizz.persistence.entity.user;

import hu.szte.vizz.persistence.entity.user.EmailActivationToken;
import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class EmailActivationTokenUnitTest {
    @Test
    public void When_newWithUser_Expect_newTokenCreatedWithCorrectUser() {
        User user = new User()
                .setId(UUID.randomUUID());
        EmailActivationToken token = new EmailActivationToken(user);

        assertEquals(user, token.getUser());
    }


    @Test
    public void When_getId_Expect_correctId() {
        UUID id = UUID.randomUUID();
        EmailActivationToken token = new EmailActivationToken()
                .setId(id);

        assertEquals(id, token.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        EmailActivationToken token = new EmailActivationToken()
                .setId(UUID.randomUUID());
        assertNotEquals(id, token.getId());
        token.setId(id);
        assertEquals(id, token.getId());
    }

    @Test
    public void When_getUser_Expect_correctUser() {
        User user = new User()
                .setId(UUID.randomUUID());
        EmailActivationToken token = new EmailActivationToken()
                .setUser(user);

        assertEquals(user, token.getUser());
    }

    @Test
    public void When_setUser_Expect_correctUserSetted() {
        User user1 = new User()
                .setId(UUID.randomUUID());
        User user2 = new User()
                .setId(UUID.randomUUID());
        EmailActivationToken token = new EmailActivationToken()
                .setUser(user2);
        assertNotEquals(user1, token.getUser());
        token.setUser(user1);
        assertEquals(user1, token.getUser());
    }

    @Test
    public void When_getToken_Expect_correctToken() {
        EmailActivationToken token = new EmailActivationToken()
                .setToken("token");
        assertEquals("token", token.getToken());
    }

    @Test
    public void When_setToken_Expect_correctTokenSetted() {
        EmailActivationToken token = new EmailActivationToken()
                .setToken("nottoken");
        assertNotEquals("token", token.getToken());
        token.setToken("token");
        assertEquals("token", token.getToken());
    }

    @Test
    public void When_getExpiryDate_Expect_correctDate() {
        Date date = new Date();
        EmailActivationToken token = new EmailActivationToken()
                .setExpiryDate(date);
        assertEquals(date, token.getExpiryDate());
    }

    @Test
    public void When_setExpiryDate_Expect_correctDateSetted() {
        Date date1 = new Date();
        Date date2 = new Date();
        date2.setTime(1000);
        EmailActivationToken token = new EmailActivationToken()
                .setExpiryDate(date2);
        assertNotEquals(date1, token.getExpiryDate());
        token.setExpiryDate(date1);
        assertEquals(date1, token.getExpiryDate());
    }

    @Test
    public void When_tokenEqualsSame_Expect_equal() {
        EmailActivationToken token = new EmailActivationToken()
                .setId(UUID.randomUUID());
        assertEquals(token, token);
    }

    @Test
    public void When_tokenEqualsIdentical_Expect_equal() {
        UUID id = UUID.randomUUID();
        EmailActivationToken token1 = new EmailActivationToken()
                .setId(id);
        EmailActivationToken token2 = new EmailActivationToken()
                .setId(id);

        assertEquals(token1, token2);
    }

    @Test
    public void When_tokenEqualsDifferent_Expect_different() {
        EmailActivationToken token1 = new EmailActivationToken()
                .setId(UUID.randomUUID());
        EmailActivationToken token2 = new EmailActivationToken()
                .setId(UUID.randomUUID());

        assertNotEquals(token1, token2);
    }

    @Test
    public void When_tokenEqualsDifferentObject_Expect_different() {
        EmailActivationToken token = new EmailActivationToken()
                .setId(UUID.randomUUID());

        assertNotEquals(token, "nottoken");
    }

    @Test
    public void When_tokenEqualsNullObject_Expect_different() {
        EmailActivationToken token = new EmailActivationToken()
                .setId(UUID.randomUUID());

        assertNotEquals(token, null);
    }

    @Test
    public void When_tokenHashCodeEquals_Expect_equal() {
        UUID id = UUID.randomUUID();
        EmailActivationToken token1 = new EmailActivationToken()
                .setId(id);
        EmailActivationToken token2 = new EmailActivationToken()
                .setId(id);

        assertEquals(token1.hashCode(), token2.hashCode());
    }

    @Test
    public void When_tokenHashCodeNotEquals_Expect_different() {
        EmailActivationToken token1 = new EmailActivationToken()
                .setId(UUID.randomUUID());
        EmailActivationToken token2 = new EmailActivationToken()
                .setId(UUID.randomUUID());

        assertNotEquals(token1.hashCode(), token2.hashCode());
    }
}