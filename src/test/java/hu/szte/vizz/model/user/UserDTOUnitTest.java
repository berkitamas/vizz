package hu.szte.vizz.model.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserDTOUnitTest {

    @Test
    public void When_getId_Expect_correctIdReturned() {
        UUID id = UUID.randomUUID();
        UserDTO user = new UserDTO()
                .setId(id);

        assertEquals(id, user.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        UserDTO user = new UserDTO()
                .setId(UUID.randomUUID());
        assertNotEquals(id, user.getId());
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    public void When_getUsername_Expect_correctUsernameReturned() {
        UserDTO user = new UserDTO()
                .setUsername("user");

        assertEquals("user", user.getUsername());
    }

    @Test
    public void When_setUsername_Expect_correctUsernameSetted() {
        UserDTO user = new UserDTO()
                .setUsername("notuser");

        assertNotEquals("user", user.getUsername());
        user.setUsername("user");
        assertEquals("user", user.getUsername());
    }

    @Test
    public void When_getEmail_Expect_correctEmailReturned() {
        UserDTO user = new UserDTO()
                .setEmail("email");

        assertEquals("email", user.getEmail());
    }

    @Test
    public void When_setEmail_Expect_correctEmailSetted() {
        UserDTO user = new UserDTO()
                .setEmail("notemail");

        assertNotEquals("email",user.getEmail());
        user.setEmail("email");
        assertEquals("email", user.getEmail());
    }

    @Test
    public void When_getFirstName_Expect_correctFirstNameReturned() {
        UserDTO user = new UserDTO()
                .setFirstName("John");

        assertEquals("John", user.getFirstName());
    }

    @Test
    public void When_setFirstName_Expect_correctFirstNameSetted() {
        UserDTO user = new UserDTO()
                .setFirstName("notJohn");
        assertNotEquals("John", user.getFirstName());
        user.setFirstName("John");
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void When_getLastName_Expect_correctLastNameReturned() {
        UserDTO user = new UserDTO()
                .setLastName("Doe");

        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void When_setLastName_Expect_correctLastNameSetted() {
        UserDTO user = new UserDTO()
                .setLastName("notDoe");
        assertNotEquals("Doe", user.getLastName());
        user.setLastName("Doe");
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void When_getPhone_Expect_correctPhoneReturned() {
        UserDTO user = new UserDTO()
                .setPhone("12341523112");
        assertEquals("12341523112", user.getPhone());
    }

    @Test
    public void When_setPhone_Expect_correctPhoneSetted() {
        UserDTO user = new UserDTO()
                .setPhone("4321");
        assertNotEquals("1234", user.getPhone());
        user.setPhone("1234");
        assertEquals("1234", user.getPhone());
    }

    @Test
    public void When_isAdmin_Expect_correctAdminReturned() {
        UserDTO user = new UserDTO()
                .setAdmin(true);
        assertTrue(user.isAdmin());
    }

    @Test
    public void When_setAdmin_Expect_correctAdminSetted() {
        UserDTO user = new UserDTO()
                .setAdmin(true);
        assertTrue(user.isAdmin());
        user.setAdmin(false);
        assertFalse(user.isAdmin());
    }

    @Test
    public void When_equalsSame_Expect_true() {
        UserDTO user = new UserDTO();
        assertEquals(user, user);
    }

    @Test
    public void When_equalsIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        assertEquals(user1, user2);
    }

    @Test
    public void When_equalsWithNull_Expect_false() {
        UserDTO user = new UserDTO();
        assertNotEquals(user, null);
    }

    @Test
    public void When_equalsWithDifferentObject_Expect_false() {
        UserDTO user = new UserDTO();
        assertNotEquals(user, "Hello");
    }

    @Test
    public void When_equalsDifferentId_Expect_false() {
        UserDTO user1 = new UserDTO()
                .setId(UUID.randomUUID())
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(UUID.randomUUID())
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentUsername_Expect_false() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user2")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentEmail_Expect_false() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email2")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentFirstName_Expect_false() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John2")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentLastName_Expect_false() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe3")
                .setPhone("12345678")
                .setAdmin(true);
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentPhone_Expect_false() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("123456789")
                .setAdmin(true);
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsWithNullPhone_Expect_false() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("123456789")
                .setAdmin(true);
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsWithNullPhoneBoth_Expect_true() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setAdmin(true);
        assertEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentAdmin_Expect_false() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(false);
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_hashCodeIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void When_hashCodeDifferent_Expect_false() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user2")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("12345678")
                .setAdmin(true);
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void When_hashCodeIdenticalWithNullPhone_Expect_true() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setAdmin(true);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void When_hashCodeDiffernetWithDifferentAdmin_Expect_false() {
        UUID id = UUID.randomUUID();
        UserDTO user1 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setAdmin(true);
        UserDTO user2 = new UserDTO()
                .setId(id)
                .setUsername("user")
                .setEmail("email")
                .setFirstName("John")
                .setLastName("Doe")
                .setAdmin(false);
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }
}