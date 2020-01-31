package hu.szte.vizz.model.user;

import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class LocationDTOUnitTest {

    @Test
    public void When_getId_Expect_correctIdReturned() {
        UUID id = UUID.randomUUID();
        LocationDTO location = new LocationDTO()
                .setId(id);

        assertEquals(id, location.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        LocationDTO location = new LocationDTO()
                .setId(UUID.randomUUID());
        assertNotEquals(id, location.getId());
        location.setId(id);
        assertEquals(id, location.getId());
    }

    @Test
    public void When_getUserId_Expect_correctUserIdReturned() {
        User user = new User()
                .setId(UUID.randomUUID());
        LocationDTO location = new LocationDTO()
                .setUserId(user.getId());

        assertEquals(user.getId(), location.getUserId());
    }

    @Test
    public void When_setUserId_Expect_correctUserIdSetted() {
        User user1 = new User()
                .setId(UUID.randomUUID());
        User user2 = new User()
                .setId(UUID.randomUUID());
        LocationDTO location = new LocationDTO()
                .setUserId(user2.getId());

        assertNotEquals(user1.getId(), location.getUserId());
        location.setUserId(user1.getId());
        assertEquals(user1.getId(), location.getUserId());
    }

    @Test
    public void When_getTitle_Expect_correctTitleReturned() {
        LocationDTO location = new LocationDTO()
                .setTitle("title");
        assertEquals("title", location.getTitle());
    }

    @Test
    public void When_setTitle_Expect_correctTitleSetted() {
        LocationDTO location = new LocationDTO()
                .setTitle("nottitle");
        assertNotEquals("title", location.getTitle());
        location.setTitle("title");
        assertEquals("title", location.getTitle());
    }

    @Test
    public void When_getZip_Expect_correctZipReturned() {
        LocationDTO location = new LocationDTO()
                .setZip("zip");
        assertEquals("zip", location.getZip());
    }

    @Test
    public void When_setZip_Expect_correctZipSetted() {
        LocationDTO location = new LocationDTO()
                .setZip("notzip");
        assertNotEquals("zip", location.getZip());
        location.setZip("zip");
        assertEquals("zip", location.getZip());
    }

    @Test
    public void When_getCity_Expect_correctCityReturned() {
        LocationDTO location = new LocationDTO()
                .setCity("city");
        assertEquals("city", location.getCity());
    }

    @Test
    public void When_setCity_Expect_correctCitySetted() {
        LocationDTO location = new LocationDTO()
                .setCity("notcity");
        assertNotEquals("city", location.getCity());
        location.setCity("city");
        assertEquals("city", location.getCity());
    }

    @Test
    public void When_getStreet_Expect_correctStreetReturned() {
        LocationDTO location = new LocationDTO()
                .setStreet("street");
        assertEquals("street", location.getStreet());
    }

    @Test
    public void When_setStreet_Expect_correctStreetSetted() {
        LocationDTO location = new LocationDTO()
                .setStreet("notstreet");
        assertNotEquals("street", location.getStreet());
        location.setStreet("street");
        assertEquals("street", location.getStreet());
    }

    @Test
    public void When_getAddress_Expect_correctAddressReturned() {
        LocationDTO location = new LocationDTO()
                .setAddress("address");
        assertEquals("address", location.getAddress());
    }

    @Test
    public void When_setAddress_Expect_correctAddressSetted() {
        LocationDTO location = new LocationDTO()
                .setAddress("notaddress");
        assertNotEquals("address", location.getAddress());
        location.setAddress("address");
        assertEquals("address", location.getAddress());
    }

    @Test
    public void When_isDefault_Expect_correctValueReturned() {
        LocationDTO location = new LocationDTO()
                .setDefault(true);
        assertTrue(location.isDefault());
    }

    @Test
    public void When_setDefault_Expect_correctValueSetted() {
        LocationDTO location = new LocationDTO();
        assertFalse(location.isDefault());
        location.setDefault(true);
        assertTrue(location.isDefault());
    }

    @Test
    public void When_equalsSame_Expect_true() {
        LocationDTO location = new LocationDTO();
        assertEquals(location, location);
    }

    @Test
    public void When_equalsIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertEquals(location1, location2);
    }

    @Test
    public void When_equalsWithNull_Expect_false() {
        LocationDTO location = new LocationDTO();
        assertNotEquals(location, null);
    }

    @Test
    public void When_equalsWithDifferentObjectType_Expect_false() {
        LocationDTO location = new LocationDTO();
        assertNotEquals(location, "Hello");
    }

    @Test
    public void When_equalsWithDifferentId_Expect_false() {
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(UUID.randomUUID())
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(UUID.randomUUID())
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_equalsWithNullId_Expect_false() {
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(UUID.randomUUID())
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_equalsWithNullIdBoth_Expect_true() {
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertEquals(location1, location2);
    }

    @Test
    public void When_equalsWithDifferentUserId_Expect_false() {
        UUID id = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setUserId(UUID.randomUUID())
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setUserId(UUID.randomUUID())
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_equalsWithNullUserId_Expect_false() {
        UUID id = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setUserId(UUID.randomUUID())
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_equalsWithNullUserIdBoth_Expect_true() {
        UUID id = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertEquals(location1, location2);
    }

    @Test
    public void When_equalsWithDifferentTitle_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title2")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_equalsWithDifferentZip_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1001")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_equalsWithDifferentCity_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city3")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_equalsWithDifferentStreet_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street2")
                .setAddress("address")
                .setDefault(true);
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_equalsWithDifferentAddress_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address2")
                .setDefault(true);
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_equalsWithDifferentDefaultState_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_hashCodeIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertEquals(location1.hashCode(), location2.hashCode());
    }


    @Test
    public void When_hashCodeIdenticalWithNullId_Expect_true() {
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertEquals(location1.hashCode(), location2.hashCode());
    }


    @Test
    public void When_hashCodeIdenticalWithNullUserId_Expect_true() {
        UUID id = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        assertEquals(location1.hashCode(), location2.hashCode());
    }

    @Test
    public void When_hashCodeDifferent_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocationDTO location1 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address")
                .setDefault(true);
        LocationDTO location2 = new LocationDTO()
                .setId(id)
                .setUserId(userId)
                .setTitle("title")
                .setZip("1000")
                .setCity("city")
                .setStreet("street")
                .setAddress("address");
        assertNotEquals(location1.hashCode(), location2.hashCode());
    }
}