package hu.szte.vizz.persistence.entity.user;

import hu.szte.vizz.persistence.entity.order.Order;
import hu.szte.vizz.persistence.entity.user.Location;
import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserUnitTest {

    @Test
    public void When_getId_Expect_correctId() {
        UUID id = UUID.randomUUID();
        User user = new User()
                .setId(id);

        assertEquals(id, user.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        User user = new User()
                .setId(UUID.randomUUID());
        assertNotEquals(id, user.getId());
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    public void When_getUsername_Expect_correctUsername() {
        User user = new User()
                .setUsername("user");

        assertEquals("user", user.getUsername());
    }

    @Test
    public void When_setUsername_Expect_correctUsernameSetted() {
        User user = new User()
                .setUsername("notuser");

        assertNotEquals("user", user.getUsername());
        user.setUsername("UsEr");
        assertEquals("user", user.getUsername());
    }

    @Test
    public void When_getEmail_Expect_correctEmail() {
        User user = new User()
                .setEmail("email");

        assertEquals("email", user.getEmail());
    }

    @Test
    public void When_setEmail_Expect_correctEmailSetted() {
        User user = new User()
                .setEmail("notemail");

        assertNotEquals("email",user.getEmail());
        user.setEmail("email");
        assertEquals("email", user.getEmail());
    }

    @Test
    public void When_getPassword_Expect_correctPassword() {
        User user = new User()
                .setPassword("hash");

        assertEquals("hash", user.getPassword());
    }

    @Test
    public void When_setPassword_Expect_correctPasswordSetted() {
        User user = new User()
                .setPassword("nothash");

        assertNotEquals("hash", user.getPassword());
        user.setPassword("hash");
        assertEquals("hash", user.getPassword());
    }

    @Test
    public void When_isActivatedOnDefault_Expect_false() {
        User user = new User();
        assertFalse(user.isActivated());

    }

    @Test
    public void When_isActivated_expect_correctValue() {
        User user = new User()
                .setActivated(true);
        assertTrue(user.isActivated());
    }

    @Test
    public void When_setActivated_Expect_correctValueSetted() {
        User user = new User()
                .setActivated(true);
        assertTrue(user.isActivated());
        user.setActivated(false);
        assertFalse(user.isActivated());
    }

    @Test
    public void When_getFirstName_Expect_correctFirstName() {
        User user = new User()
                .setFirstName("John");

        assertEquals("John", user.getFirstName());
    }

    @Test
    public void When_setFirstName_Expect_correctFirstNameSetted() {
        User user = new User()
                .setFirstName("notJohn");
        assertNotEquals("John", user.getFirstName());
        user.setFirstName("John");
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void When_getLastName_Expect_correctLastName() {
        User user = new User()
                .setLastName("Doe");

        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void When_setLastName_Expect_correctLastNameSetted() {
        User user = new User()
                .setLastName("notDoe");
        assertNotEquals("Doe", user.getLastName());
        user.setLastName("Doe");
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void When_getPhone_Expect_correctPhone() {
        User user = new User()
                .setPhone("+12341523a112");
        assertEquals("12341523112", user.getPhone());
    }

    @Test
    public void When_setPhone_Expect_correctPhoneSetted() {
        User user = new User()
                .setPhone("+4321");
        assertNotEquals("1234", user.getPhone());
        user.setPhone("+1234onetwothreefour");
        assertEquals("1234", user.getPhone());
    }

    @Test
    public void When_isAdminByDefault_Expect_false() {
        User user = new User();
        assertFalse(user.isAdmin());
    }

    @Test
    public void When_isAdmin_Expect_correctValue() {
        User user = new User()
                .setAdmin(true);
        assertTrue(user.isAdmin());
    }

    @Test
    public void When_setAdmin_Expect_correctValueSetted() {
        User user = new User()
                .setAdmin(true);
        assertTrue(user.isAdmin());
        user.setAdmin(false);
        assertFalse(user.isAdmin());
    }

    @Test
    public void When_getLocations_Expect_correctLocations() {
        Location location1 = new Location()
                .setId(UUID.randomUUID());
        Location location2 = new Location()
                .setId(UUID.randomUUID());
        Location location3 = new Location()
                .setId(UUID.randomUUID());
        List<Location> locations = new ArrayList <>();
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        User user = new User()
                .setLocations(locations);

        assertEquals(locations, user.getLocations());
    }

    @Test
    public void When_setLocations_Expect_correctLocationsSetted() {
        Location location1 = new Location()
                .setId(UUID.randomUUID());
        Location location2 = new Location()
                .setId(UUID.randomUUID());
        Location location3 = new Location()
                .setId(UUID.randomUUID());
        List<Location> locations1 = new ArrayList <>();
        locations1.add(location1);
        locations1.add(location2);
        locations1.add(location3);
        Location location4 = new Location()
                .setId(UUID.randomUUID());
        Location location5 = new Location()
                .setId(UUID.randomUUID());
        Location location6 = new Location()
                .setId(UUID.randomUUID());
        List<Location> locations2 = new ArrayList <>();
        locations2.add(location4);
        locations2.add(location5);
        locations2.add(location6);

        User user = new User()
                .setLocations(locations2);
        assertNotEquals(locations1, user.getLocations());
        user.setLocations(locations1);
        assertEquals(locations1, user.getLocations());
    }

    @Test
    public void When_getOrders_Expect_correctOrders() {
        Order order1 = new Order()
                .setId(UUID.randomUUID());
        Order order2 = new Order()
                .setId(UUID.randomUUID());
        Order order3 = new Order()
                .setId(UUID.randomUUID());
        List<Order> orders = new ArrayList <>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        User user = new User()
                .setOrders(orders);
        assertEquals(orders, user.getOrders());
    }

    @Test
    public void When_setOrders_Expect_correctOrdersSetted() {
        Order order1 = new Order()
                .setId(UUID.randomUUID());
        Order order2 = new Order()
                .setId(UUID.randomUUID());
        Order order3 = new Order()
                .setId(UUID.randomUUID());
        List<Order> orders1 = new ArrayList <>();
        orders1.add(order1);
        orders1.add(order2);
        orders1.add(order3);
        Order order4 = new Order()
                .setId(UUID.randomUUID());
        Order order5 = new Order()
                .setId(UUID.randomUUID());
        Order order6 = new Order()
                .setId(UUID.randomUUID());
        List<Order> orders2 = new ArrayList <>();
        orders2.add(order4);
        orders2.add(order5);
        orders2.add(order6);
        User user = new User()
                .setOrders(orders2);
        assertNotEquals(orders1, user.getOrders());
        user.setOrders(orders1);
        assertEquals(orders1, user.getOrders());
    }

    @Test
    public void When_userEqualsSame_Expect_equal() {
        User user = new User()
                .setId(UUID.randomUUID());
        assertEquals(user, user);
    }

    @Test
    public void When_userEqualsIdentical_Expect_equal() {
        UUID id = UUID.randomUUID();
        User user1 = new User()
                .setId(id);
        User user2 = new User()
                .setId(id);

        assertEquals(user1, user2);
    }

    @Test
    public void When_userEqualsDifferent_Expect_different() {
        User user1 = new User()
                .setId(UUID.randomUUID());
        User user2 = new User()
                .setId(UUID.randomUUID());

        assertNotEquals(user1, user2);
    }

    @Test
    public void When_userEqualsDifferentObject_Expect_different() {
        User user = new User()
                .setId(UUID.randomUUID());

        assertNotEquals(user, "notuser");
    }

    @Test
    public void When_userEqualsNullObject_Expect_different() {
        User user = new User()
                .setId(UUID.randomUUID());

        assertNotEquals(user, null);
    }

    @Test
    public void When_userHashCodeEquals_Expect_equal() {
        UUID id = UUID.randomUUID();
        User user1 = new User()
                .setId(id);
        User user2 = new User()
                .setId(id);

        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void When_emptyUserHashCodeEquals_Expect_equal() {
        assertEquals(new User().hashCode(), new User().hashCode());
    }

    @Test
    public void When_userHashCodeNotEquals_Expect_different() {
        User user1 = new User()
                .setId(UUID.randomUUID());
        User user2 = new User()
                .setId(UUID.randomUUID());

        assertNotEquals(user1.hashCode(), user2.hashCode());
    }
}