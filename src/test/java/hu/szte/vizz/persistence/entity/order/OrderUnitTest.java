package hu.szte.vizz.persistence.entity.order;

import hu.szte.vizz.model.order.OrderStatus;
import hu.szte.vizz.model.order.PaymentMethod;
import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class OrderUnitTest {

    @Test
    public void When_newOrderWithUser_Expect_newOrderWithCorrectUser() {
        User user = new User()
                .setId(UUID.randomUUID());
        Order order = new Order(user);

        assertEquals(user, order.getUser());
    }

    @Test
    public void When_getId_Expect_correctId() {
        UUID id = UUID.randomUUID();
        Order order = new Order()
                .setId(id);

        assertEquals(id, order.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        Order order = new Order()
                .setId(UUID.randomUUID());

        assertNotEquals(id, order.getId());
        order.setId(id);
        assertEquals(id, order.getId());
    }

    @Test
    public void When_getUser_Expect_correctUser() {
        User user = new User()
                .setId(UUID.randomUUID());
        Order order = new Order()
                .setUser(user);

        assertEquals(user, order.getUser());
    }

    @Test
    public void When_setUser_Expect_correctUserSetted() {
        User user1 = new User()
                .setId(UUID.randomUUID());
        User user2 = new User()
                .setId(UUID.randomUUID());
        Order order = new Order()
                .setUser(user2);

        assertNotEquals(user1, order.getUser());
        order.setUser(user1);
        assertEquals(user1, order.getUser());
    }

    @Test
    public void When_getIpAddress_Expect_correctIpAddress() {
        Order order = new Order()
                .setIpAddress("0.0.0.0");

        assertEquals("0.0.0.0", order.getIpAddress());
    }

    @Test
    public void When_setIpAddress_Expect_correctIpAddressSetted() {
        Order order = new Order()
                .setIpAddress("0.0.0.0");

        assertNotEquals("10.0.0.0", order.getIpAddress());
        order.setIpAddress("10.0.0.0");
        assertEquals("10.0.0.0", order.getIpAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void When_setInvalidIpAddressChar_Expect_exception() {
        new Order()
                .setIpAddress("0.0.0.0a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void When_setIpAddressOutOfBounds_Expect_exception() {
        new Order()
                .setIpAddress("255.255.255.256");
    }

    @Test
    public void When_getName_Expect_correctName() {
        Order order = new Order()
                .setName("name");

        assertEquals("name", order.getName());
    }

    @Test
    public void When_setName_Expect_correntNameSetted() {
        Order order = new Order()
                .setName("notname");

        assertNotEquals("name", order.getName());
        order.setName("name");
        assertEquals("name", order.getName());
    }

    @Test
    public void When_getSum_Expect_correctSum() {
        BigDecimal sum = BigDecimal.valueOf(1000);
        Order order = new Order()
                .setSum(sum);

        assertEquals(sum, order.getSum());
    }

    @Test
    public void When_setSum_Expect_correctSumSetted() {
        BigDecimal sum1 = BigDecimal.valueOf(1000);
        BigDecimal sum2 = BigDecimal.valueOf(2000);
        Order order = new Order()
                .setSum(sum2);

        assertNotEquals(sum1, order.getSum());
        order.setSum(sum1);
        assertEquals(sum1, order.getSum());
    }

    @Test
    public void When_getPaymentMethod_Expect_correctPaymentMethod() {
        Order order = new Order()
                .setPaymentMethod(PaymentMethod.COD);
        assertEquals(PaymentMethod.COD, order.getPaymentMethod());
    }

    @Test
    public void When_setPaymentMethod_Expect_correctPaymentMethodSetted() {
        Order order = new Order()
                .setPaymentMethod(PaymentMethod.WIRE_TRANSFER);

        assertNotEquals(PaymentMethod.COD, order.getPaymentMethod());
        order.setPaymentMethod(PaymentMethod.COD);
        assertEquals(PaymentMethod.COD, order.getPaymentMethod());
    }

    @Test
    public void When_getOrderStatusOnDefault_Expect_pendingState() {
        Order order = new Order();
        assertEquals(OrderStatus.PENDING, order.getOrderStatus());
    }

    @Test
    public void When_getOrderStatus_Expect_correctState() {
        Order order = new Order()
                .setOrderStatus(OrderStatus.AWAITING_PAYMENT);
        assertEquals(OrderStatus.AWAITING_PAYMENT, order.getOrderStatus());
    }

    @Test
    public void When_setOrderStatus_Expect_correctStateSetted() {
        Order order = new Order()
                .setOrderStatus(OrderStatus.AWAITING_SHIPMENT);

        assertNotEquals(OrderStatus.AWAITING_PAYMENT, order.getOrderStatus());
        order.setOrderStatus(OrderStatus.AWAITING_PAYMENT);
        assertEquals(OrderStatus.AWAITING_PAYMENT, order.getOrderStatus());
    }

    @Test
    public void When_getZip_Expect_correctZip() {
        Order order = new Order()
                .setZip("zip");
        assertEquals("zip", order.getZip());
    }

    @Test
    public void When_setZip_Expect_correctZipSetted() {
        Order order = new Order()
                .setZip("notzip");
        assertNotEquals("zip", order.getZip());
        order.setZip("zip");
        assertEquals("zip", order.getZip());
    }

    @Test
    public void When_getCity_Expect_correctCity() {
        Order order = new Order()
                .setCity("city");
        assertEquals("city", order.getCity());
    }

    @Test
    public void When_setCity_Expect_correctCitySetted() {
        Order order = new Order()
                .setCity("notcity");
        assertNotEquals("city", order.getCity());
        order.setCity("city");
        assertEquals("city", order.getCity());
    }

    @Test
    public void When_getStreet_Expect_correctStreet() {
        Order order = new Order()
                .setStreet("street");
        assertEquals("street", order.getStreet());
    }

    @Test
    public void When_setStreet_Expect_correctStreetSetted() {
        Order order = new Order()
                .setStreet("notstreet");
        assertNotEquals("street", order.getStreet());
        order.setStreet("street");
        assertEquals("street", order.getStreet());
    }

    @Test
    public void When_getAddress_Expect_correctAddress() {
        Order order = new Order()
                .setAddress("address");
        assertEquals("address", order.getAddress());
    }

    @Test
    public void When_setAddress_Expect_correctAddressSetted() {
        Order order = new Order()
                .setAddress("notaddress");
        assertNotEquals("address", order.getAddress());
        order.setAddress("address");
        assertEquals("address", order.getAddress());
    }

    @Test
    public void When_getOrderDate_Expect_correctDate() {
        Date date = new Date();
        Order order = new Order()
                .setOrderDate(date);

        assertEquals(date, order.getOrderDate());
    }

    @Test
    public void When_setOrderDate_Expect_correctDateSetted() {
        Date date1 = new Date();
        Date date2 = new Date();
        date2.setTime(1000);

        Order order = new Order()
                .setOrderDate(date2);

        assertNotEquals(date1, order.getOrderDate());
        order.setOrderDate(date1);
        assertEquals(date1, order.getOrderDate());
    }

    @Test
    public void When_getOrderItems_Expect_correctItems() {
        OrderItem item1 = new OrderItem()
                .setId(UUID.randomUUID());
        OrderItem item2 = new OrderItem()
                .setId(UUID.randomUUID());
        OrderItem item3 = new OrderItem()
                .setId(UUID.randomUUID());
        List<OrderItem> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Order order = new Order()
                .setOrderItems(items);

        assertEquals(items, order.getOrderItems());
    }

    @Test
    public void When_setOrderItems_Expect_correctItemsSetted() {
        OrderItem item1 = new OrderItem()
                .setId(UUID.randomUUID());
        OrderItem item2 = new OrderItem()
                .setId(UUID.randomUUID());
        OrderItem item3 = new OrderItem()
                .setId(UUID.randomUUID());
        List<OrderItem> items1 = new ArrayList <>();
        items1.add(item1);
        items1.add(item2);
        items1.add(item3);
        OrderItem item4 = new OrderItem()
                .setId(UUID.randomUUID());
        OrderItem item5 = new OrderItem()
                .setId(UUID.randomUUID());
        OrderItem item6 = new OrderItem()
                .setId(UUID.randomUUID());
        List<OrderItem> items2 = new ArrayList <>();
        items2.add(item4);
        items2.add(item5);
        items2.add(item6);

        Order order = new Order()
                .setOrderItems(items2);

        assertNotEquals(items1, order.getOrderItems());
        order.setOrderItems(items1);
        assertEquals(items1, order.getOrderItems());
    }

    @Test
    public void When_orderEqualsSame_Expect_equal() {
        Order order = new Order()
                .setId(UUID.randomUUID());

        assertEquals(order, order);
    }

    @Test
    public void When_orderEqualsIdentical_Expect_equal() {
        UUID id = UUID.randomUUID();
        Order order1 = new Order()
                .setId(id);
        Order order2 = new Order()
                .setId(id);

        assertEquals(order1, order2);
    }

    @Test
    public void When_orderEqualsDifferent_Expect_different() {
        Order order1 = new Order()
                .setId(UUID.randomUUID());
        Order order2 = new Order()
                .setId(UUID.randomUUID());
        assertNotEquals(order1, order2);
    }

    @Test
    public void When_orderEqualsDifferentObject_Expect_different() {
        Order order = new Order()
                .setId(UUID.randomUUID());
        assertNotEquals(order, "notorder");
    }

    @Test
    public void When_orderEqualsNullObject_Expect_different() {
        Order order = new Order()
                .setId(UUID.randomUUID());
        assertNotEquals(order, null);
    }

    @Test
    public void When_orderHashCodeEquals_Expect_equal() {
        UUID id = UUID.randomUUID();
        Order order1 = new Order()
                .setId(id);
        Order order2 = new Order()
                .setId(id);

        assertEquals(order1.hashCode(), order2.hashCode());
    }

    @Test
    public void When_orderHashCodeNotEquals_Expect_different() {
        Order order1 = new Order()
                .setId(UUID.randomUUID());
        Order order2 = new Order()
                .setId(UUID.randomUUID());
        assertNotEquals(order1.hashCode(), order2.hashCode());
    }
}