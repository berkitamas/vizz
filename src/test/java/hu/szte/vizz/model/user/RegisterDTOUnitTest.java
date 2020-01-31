package hu.szte.vizz.model.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class RegisterDTOUnitTest {

    @Test
    public void When_getUsername_Expect_correctUsernameReturned() {
        RegisterDTO user = new RegisterDTO()
                .setUsername("user");

        assertEquals("user", user.getUsername());
    }

    @Test
    public void When_setUsername_Expect_correctUsernameSetted() {
        RegisterDTO user = new RegisterDTO()
                .setUsername("notuser");

        assertNotEquals("user", user.getUsername());
        user.setUsername("user");
        assertEquals("user", user.getUsername());
    }

    @Test
    public void When_getPassword_Expect_correctPasswordReturned() {
        RegisterDTO user = new RegisterDTO()
                .setPassword("hash");

        assertEquals("hash", user.getPassword());
    }

    @Test
    public void When_setPassword_Expect_correctPasswordSetted() {
        RegisterDTO user = new RegisterDTO()
                .setPassword("nothash");

        assertNotEquals("hash", user.getPassword());
        user.setPassword("hash");
        assertEquals("hash", user.getPassword());
    }

    @Test
    public void When_getPasswordAgain_Expect_correctPasswordAgainReturned() {
        RegisterDTO user = new RegisterDTO()
                .setPasswordAgain("hash");

        assertEquals("hash", user.getPasswordAgain());
    }

    @Test
    public void When_passwordsMatchSame_Expect_same() {
        RegisterDTO user = new RegisterDTO()
                .setPassword("hash")
                .setPasswordAgain("hash");

        assertTrue(user.passwordsMatch());
    }

    @Test
    public void When_passwordsMatchDifferent_Expect_different() {
        RegisterDTO user = new RegisterDTO()
                .setPassword("hash1")
                .setPasswordAgain("hash2");

        assertFalse(user.passwordsMatch());
    }

    @Test
    public void When_setPasswordAgain_Expect_correctPasswordAgainSetted() {
        RegisterDTO user = new RegisterDTO()
                .setPasswordAgain("nothash");

        assertNotEquals("hash", user.getPasswordAgain());
        user.setPasswordAgain("hash");
        assertEquals("hash", user.getPasswordAgain());
    }

    @Test
    public void When_getEmail_Expect_correctEmailReturned() {
        RegisterDTO user = new RegisterDTO()
                .setEmail("email");

        assertEquals("email", user.getEmail());
    }

    @Test
    public void When_setEmail_Expect_correctEmailSetted() {
        RegisterDTO user = new RegisterDTO()
                .setEmail("notemail");

        assertNotEquals("email",user.getEmail());
        user.setEmail("email");
        assertEquals("email", user.getEmail());
    }

    @Test
    public void When_getFirstName_Expect_correctFirstNameReturned() {
        RegisterDTO user = new RegisterDTO()
                .setFirstName("John");

        assertEquals("John", user.getFirstName());
    }

    @Test
    public void When_setFirstName_Expect_correctFirstNameSetted() {
        RegisterDTO user = new RegisterDTO()
                .setFirstName("notJohn");
        assertNotEquals("John", user.getFirstName());
        user.setFirstName("John");
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void When_getLastName_Expect_correctLastNameReturned() {
        RegisterDTO user = new RegisterDTO()
                .setLastName("Doe");

        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void When_setLastName_Expect_correctLastNameSetted() {
        RegisterDTO user = new RegisterDTO()
                .setLastName("notDoe");
        assertNotEquals("Doe", user.getLastName());
        user.setLastName("Doe");
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void When_getPhone_Expect_correctPhoneReturned() {
        RegisterDTO user = new RegisterDTO()
                .setPhone("12341523112");
        assertEquals("12341523112", user.getPhone());
    }

    @Test
    public void When_setPhone_Expect_correctPhoneSetted() {
        RegisterDTO user = new RegisterDTO()
                .setPhone("4321");
        assertNotEquals("1234", user.getPhone());
        user.setPhone("1234");
        assertEquals("1234", user.getPhone());
    }

    @Test
    public void When_getZip_Expect_correctZipReturned() {
        RegisterDTO registerDTO = new RegisterDTO()
                .setZip("zip");
        assertEquals("zip", registerDTO.getZip());
    }

    @Test
    public void When_setZip_Expect_correctZipSetted() {
        RegisterDTO registerDTO = new RegisterDTO()
                .setZip("notzip");
        assertNotEquals("zip", registerDTO.getZip());
        registerDTO.setZip("zip");
        assertEquals("zip", registerDTO.getZip());
    }

    @Test
    public void When_getCity_Expect_correctCityReturned() {
        RegisterDTO registerDTO = new RegisterDTO()
                .setCity("city");
        assertEquals("city", registerDTO.getCity());
    }

    @Test
    public void When_setCity_Expect_correctCitySetted() {
        RegisterDTO registerDTO = new RegisterDTO()
                .setCity("notcity");
        assertNotEquals("city", registerDTO.getCity());
        registerDTO.setCity("city");
        assertEquals("city", registerDTO.getCity());
    }

    @Test
    public void When_getStreet_Expect_correctStreetReturned() {
        RegisterDTO registerDTO = new RegisterDTO()
                .setStreet("street");
        assertEquals("street", registerDTO.getStreet());
    }

    @Test
    public void When_setStreet_Expect_correctStreetSetted() {
        RegisterDTO registerDTO = new RegisterDTO()
                .setStreet("notstreet");
        assertNotEquals("street", registerDTO.getStreet());
        registerDTO.setStreet("street");
        assertEquals("street", registerDTO.getStreet());
    }

    @Test
    public void When_getAddress_Expect_correctAddressReturned() {
        RegisterDTO registerDTO = new RegisterDTO()
                .setAddress("address");
        assertEquals("address", registerDTO.getAddress());
    }

    @Test
    public void When_setAddress_Expect_correctAddressSetted() {
        RegisterDTO registerDTO = new RegisterDTO()
                .setAddress("notaddress");
        assertNotEquals("address", registerDTO.getAddress());
        registerDTO.setAddress("address");
        assertEquals("address", registerDTO.getAddress());
    }

    @Test
    public void When_equalsSame_Expect_true() {
        RegisterDTO user = new RegisterDTO();
        assertEquals(user, user);
    }

    @Test
    public void When_equalsIdentical_Expect_true() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertEquals(user1, user2);
    }

    @Test
    public void When_equalsWithNull_Expect_false() {
        RegisterDTO user = new RegisterDTO();
        assertNotEquals(user, null);
    }

    @Test
    public void When_equalsWithDifferentObject_Expect_false() {
        RegisterDTO user = new RegisterDTO();
        assertNotEquals(user, "hello");
    }

    @Test
    public void When_equalsDifferentUsername_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user2")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentEmail_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email2")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentPassword_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass2")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentPasswordAgain_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass2")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentFirstName_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John2")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentLastName_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe2")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentPhone_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone2")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsWithNullPhone_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone2")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsWithNullPhoneBoth_Expect_true() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentZip_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("10002")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentCity_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city2")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentStreet_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("stree3t")
                .setAddress("address");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_equalsDifferentAddress_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("addr3ess");
        assertNotEquals(user1, user2);
    }

    @Test
    public void When_hashCodeIdentical_Expect_true() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void When_hashCodeDifferent_Expect_false() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user2")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhone("phone")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void When_hashCodeIdenticalWithNullPhone_Expect_true() {
        RegisterDTO user1 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        RegisterDTO user2 = new RegisterDTO()
                .setUsername("user")
                .setEmail("email")
                .setPassword("pass")
                .setPasswordAgain("pass")
                .setFirstName("John")
                .setLastName("Doe")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertEquals(user1.hashCode(), user2.hashCode());
    }
}