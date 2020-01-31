package hu.szte.vizz.model.user;

import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class TokenDTOUnitTest {
    @Test
    public void When_getToken_Expect_correctTokenReturned() {
        TokenDTO token = new TokenDTO()
                .setToken("token");

        assertEquals("token", token.getToken());
    }

    @Test
    public void When_setToken_Expect_correctTokenSetted() {
        TokenDTO token = new TokenDTO()
                .setToken("token");

        assertEquals("token", token.getToken());
    }

    @Test
    public void When_getUserId_Expect_correctUserIdReturned() {
        User user = new User()
                .setId(UUID.randomUUID());
        TokenDTO token = new TokenDTO()
                .setUserId(user.getId());

        assertEquals(user.getId(), token.getUserId());
    }

    @Test
    public void When_setUserId_Expect_correctUserIdSetted() {
        User user1 = new User()
                .setId(UUID.randomUUID());
        User user2 = new User()
                .setId(UUID.randomUUID());
        TokenDTO token = new TokenDTO()
                .setUserId(user2.getId());

        assertNotEquals(user1.getId(), token.getUserId());
        token.setUserId(user1.getId());
        assertEquals(user1.getId(), token.getUserId());
    }

    @Test
    public void When_equalsSame_Expect_true() {
        TokenDTO token = new TokenDTO();
        assertEquals(token, token);
    }

    @Test
    public void When_equalsIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        TokenDTO token1 = new TokenDTO()
                .setUserId(id)
                .setToken("token");
        TokenDTO token2 = new TokenDTO()
                .setUserId(id)
                .setToken("token");
        assertEquals(token1, token2);
    }

    @Test
    public void When_equalsWithNull_Expect_false() {
        TokenDTO token = new TokenDTO();
        assertNotEquals(token, null);
    }

    @Test
    public void When_equalsWithDifferentObject_Expect_false() {
        TokenDTO token = new TokenDTO();
        assertNotEquals(token, "Hello");
    }

    @Test
    public void When_equalsDifferentUserId_Expect_false() {
        TokenDTO token1 = new TokenDTO()
                .setUserId(UUID.randomUUID())
                .setToken("token");
        TokenDTO token2 = new TokenDTO()
                .setUserId(UUID.randomUUID())
                .setToken("token");
        assertNotEquals(token1, token2);
    }

    @Test
    public void When_equalsDifferentToken_Expect_false() {
        UUID id = UUID.randomUUID();
        TokenDTO token1 = new TokenDTO()
                .setUserId(id)
                .setToken("token");
        TokenDTO token2 = new TokenDTO()
                .setUserId(id)
                .setToken("token2");
        assertNotEquals(token1, token2);
    }

    @Test
    public void When_hashCodeIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        TokenDTO token1 = new TokenDTO()
                .setUserId(id)
                .setToken("token");
        TokenDTO token2 = new TokenDTO()
                .setUserId(id)
                .setToken("token");
        assertEquals(token1.hashCode(), token2.hashCode());
    }

    @Test
    public void When_hashCodeDifferent_Expect_false() {
        UUID id = UUID.randomUUID();
        TokenDTO token1 = new TokenDTO()
                .setUserId(id)
                .setToken("token");
        TokenDTO token2 = new TokenDTO()
                .setUserId(id)
                .setToken("token2");
        assertNotEquals(token1.hashCode(), token2.hashCode());
    }
}