package hu.szte.vizz.persistence.entity.user;

import hu.szte.vizz.persistence.entity.user.Location;
import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class LocationUnitTest {

    @Test
    public void When_newWithUser_Expect_newLocationCreatedWithUser() {
        User user = new User()
                .setId(UUID.randomUUID());
        Location location = new Location(user);

        assertEquals(user, location.getUser());
    }

    @Test
    public void When_getId_Expect_correctId() {
        UUID id = UUID.randomUUID();
        Location location = new Location()
                .setId(id);

        assertEquals(id, location.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        Location location = new Location()
                .setId(UUID.randomUUID());
        assertNotEquals(id, location.getId());
        location.setId(id);
        assertEquals(id, location.getId());
    }

    @Test
    public void When_getUser_Expect_correctUser() {
        User user = new User()
                .setId(UUID.randomUUID());
        Location location = new Location()
                .setUser(user);

        assertEquals(user, location.getUser());
    }

    @Test
    public void When_setUser_Expect_correctUserSetted() {
        User user1 = new User()
                .setId(UUID.randomUUID());
        User user2 = new User()
                .setId(UUID.randomUUID());
        Location location = new Location()
                .setUser(user2);

        assertNotEquals(user1, location.getUser());
        location.setUser(user1);
        assertEquals(user1, location.getUser());
    }

    @Test
    public void When_getTitle_Expect_correctTitle() {
        Location location = new Location()
                .setTitle("title");
        assertEquals("title", location.getTitle());
    }

    @Test
    public void When_setTitle_Expect_correctTitleSetted() {
        Location location = new Location()
                .setTitle("nottitle");
        assertNotEquals("title", location.getTitle());
        location.setTitle("title");
        assertEquals("title", location.getTitle());
    }

    @Test
    public void When_getZip_Expect_correctZip() {
        Location location = new Location()
                .setZip("zip");
        assertEquals("zip", location.getZip());
    }

    @Test
    public void When_setZip_Expect_correctZipSetted() {
        Location location = new Location()
                .setZip("notzip");
        assertNotEquals("zip", location.getZip());
        location.setZip("zip");
        assertEquals("zip", location.getZip());
    }

    @Test
    public void When_getCity_Expect_correctCity() {
        Location location = new Location()
                .setCity("city");
        assertEquals("city", location.getCity());
    }

    @Test
    public void When_setCity_Expect_correctCitySetted() {
        Location location = new Location()
                .setCity("notcity");
        assertNotEquals("city", location.getCity());
        location.setCity("city");
        assertEquals("city", location.getCity());
    }

    @Test
    public void When_getStreet_Expect_correctStreet() {
        Location location = new Location()
                .setStreet("street");
        assertEquals("street", location.getStreet());
    }

    @Test
    public void When_setStreet_Expect_correctStreetSetted() {
        Location location = new Location()
                .setStreet("notstreet");
        assertNotEquals("street", location.getStreet());
        location.setStreet("street");
        assertEquals("street", location.getStreet());
    }

    @Test
    public void When_getAddress_Expect_correctAddress() {
        Location location = new Location()
                .setAddress("address");
        assertEquals("address", location.getAddress());
    }

    @Test
    public void When_setAddress_Expect_correctAddressSetted() {
        Location location = new Location()
                .setAddress("notaddress");
        assertNotEquals("address", location.getAddress());
        location.setAddress("address");
        assertEquals("address", location.getAddress());
    }

    @Test
    public void When_isDefaultOnDefault_Expect_false() {
        Location location = new Location();
        assertFalse(location.isDefault());
    }

    @Test
    public void When_isDefault_Expect_correct() {
        Location location = new Location()
                .setDefault(true);
        assertTrue(location.isDefault());
    }

    @Test
    public void When_setDefault_Expect_settedCorrectly() {
        Location location = new Location();
        assertFalse(location.isDefault());
        location.setDefault(true);
        assertTrue(location.isDefault());
    }

    @Test
    public void When_locationEqualsSame_Expect_equal() {
        Location location = new Location()
                .setId(UUID.randomUUID());

        assertEquals(location, location);
    }

    @Test
    public void When_locationEqualsIdentical_Expect_equal() {
        UUID id = UUID.randomUUID();
        Location location1 = new Location()
                .setId(id);
        Location location2 = new Location()
                .setId(id);

        assertEquals(location1, location2);
    }

    @Test
    public void When_locationEqualsDifferent_Expect_different() {
        Location location = new Location()
                .setId(UUID.randomUUID());

        assertNotEquals(location, "notlocation");
    }

    @Test
    public void When_locationEqualsDifferentObject_Expect_different() {
        Location location = new Location()
                .setId(UUID.randomUUID());

        assertNotEquals(location, null);
    }

    @Test
    public void When_locationEqualsNullObject_Expect_different() {
        Location location1 = new Location()
                .setId(UUID.randomUUID());
        Location location2 = new Location()
                .setId(UUID.randomUUID());
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_locationHashCodeEquals_Expect_equal() {
        UUID id = UUID.randomUUID();
        Location location1 = new Location()
                .setId(id);
        Location location2 = new Location()
                .setId(id);

        assertEquals(location1.hashCode(), location2.hashCode());
    }

    @Test
    public void When_locationHashCodeNotEquals_Expect_different() {
        Location location1 = new Location()
                .setId(UUID.randomUUID());
        Location location2 = new Location()
                .setId(UUID.randomUUID());
        assertNotEquals(location1.hashCode(), location2.hashCode());
    }
}