package hu.szte.vizz.model.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class LoginDTOUnitTest {

    @Test
    public void When_getUsername_Expect_correctUsernameReturned() {
        LoginDTO user = new LoginDTO()
                .setUsername("user");

        assertEquals("user", user.getUsername());
    }

    @Test
    public void When_setUsername_Expect_correctUsernameSetted() {
        LoginDTO user = new LoginDTO()
                .setUsername("notuser");

        assertNotEquals("user", user.getUsername());
        user.setUsername("user");
        assertEquals("user", user.getUsername());
    }

    @Test
    public void When_getPassword_Expect_correctPasswordReturned() {
        LoginDTO user = new LoginDTO()
                .setPassword("hash");

        assertEquals("hash", user.getPassword());
    }

    @Test
    public void When_setPassword_Expect_correctPasswordSetted() {
        LoginDTO user = new LoginDTO()
                .setPassword("nothash");

        assertNotEquals("hash", user.getPassword());
        user.setPassword("hash");
        assertEquals("hash", user.getPassword());
    }

    @Test
    public void When_equalsSame_Expect_true() {
        LoginDTO user = new LoginDTO();
        assertEquals(user, user);
    }

    @Test
    public void When_equalsIdentical_Expect_true() {
        LoginDTO user1 = new LoginDTO()
                .setUsername("user")
                .setPassword("pass");
        LoginDTO user2 = new LoginDTO()
                .setUsername("user")
                .setPassword("pass");
        assertEquals(user1, user2);
    }

    @Test
    public void When_equalsWithNull_Expect_false() {
        LoginDTO user = new LoginDTO();
        assertNotEquals(user, null);
    }

    @Test
    public void When_equalsWithDifferentObjectType_Expect_false() {
        LoginDTO user = new LoginDTO();
        assertNotEquals(user, "hello");
    }

    @Test
    public void When_equalsDifferentUsername_Expect_false() {
        LoginDTO user1 = new LoginDTO()
                .setUsername("user")
                .setPassword("pass");
        LoginDTO user2 = new LoginDTO()
                .setUsername("user2")
                .setPassword("pass");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentPassword_Expect_false() {
        LoginDTO user1 = new LoginDTO()
                .setUsername("user")
                .setPassword("pass");
        LoginDTO user2 = new LoginDTO()
                .setUsername("user")
                .setPassword("pass2");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_hashCodeIdentical_Expect_true() {
        LoginDTO user1 = new LoginDTO()
                .setUsername("user")
                .setPassword("pass");
        LoginDTO user2 = new LoginDTO()
                .setUsername("user")
                .setPassword("pass");
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void When_hashCodeDifferent_Expect_false() {
        LoginDTO user1 = new LoginDTO()
                .setUsername("user")
                .setPassword("pass");
        LoginDTO user2 = new LoginDTO()
                .setUsername("user")
                .setPassword("pass2");
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }
}