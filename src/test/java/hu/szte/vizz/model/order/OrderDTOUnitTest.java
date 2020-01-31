package hu.szte.vizz.model.order;

import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

import static org.junit.Assert.*;

public class OrderDTOUnitTest {

    @Test
    public void When_getId_Expect_correctIdReturned() {
        UUID id = UUID.randomUUID();
        OrderDTO order = new OrderDTO()
                .setId(id);

        assertEquals(id, order.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        OrderDTO order = new OrderDTO()
                .setId(UUID.randomUUID());

        assertNotEquals(id, order.getId());
        order.setId(id);
        assertEquals(id, order.getId());
    }

    @Test
    public void When_getUserId_Expect_correctUserIdReturned() {
        User user = new User()
                .setId(UUID.randomUUID());
        OrderDTO order = new OrderDTO()
                .setUserId(user.getId());

        assertEquals(user.getId(), order.getUserId());
    }

    @Test
    public void When_setUserId_Expect_correctUserIdSetted() {
        User user1 = new User()
                .setId(UUID.randomUUID());
        User user2 = new User()
                .setId(UUID.randomUUID());
        OrderDTO order = new OrderDTO()
                .setUserId(user2.getId());

        assertNotEquals(user1.getId(), order.getUserId());
        order.setUserId(user1.getId());
        assertEquals(user1.getId(), order.getUserId());
    }

    @Test
    public void When_getIpAddress_Expect_correctIpAddressReturned() {
        OrderDTO order = new OrderDTO()
                .setIpAddress("0.0.0.0");

        assertEquals("0.0.0.0", order.getIpAddress());
    }

    @Test
    public void When_setIpAddress_Expect_correctIpAddressSetted() {
        OrderDTO order = new OrderDTO()
                .setIpAddress("0.0.0.0");

        assertNotEquals("10.0.0.0", order.getIpAddress());
        order.setIpAddress("10.0.0.0");
        assertEquals("10.0.0.0", order.getIpAddress());
    }

    @Test
    public void When_getName_Expect_correctNameReturned() {
        OrderDTO order = new OrderDTO()
                .setName("name");

        assertEquals("name", order.getName());
    }

    @Test
    public void When_setName_Expect_correctNameSetted() {
        OrderDTO order = new OrderDTO()
                .setName("notname");

        assertNotEquals("name", order.getName());
        order.setName("name");
        assertEquals("name", order.getName());
    }

    @Test
    public void When_getSum_Expect_correctSumReturned() {
        BigDecimal sum = BigDecimal.valueOf(1000);
        OrderDTO order = new OrderDTO()
                .setSum(sum.toPlainString());

        assertEquals(sum.toPlainString(), order.getSum());
    }

    @Test
    public void When_setSum_Expect_correctSumSetted() {
        BigDecimal sum1 = BigDecimal.valueOf(1000);
        BigDecimal sum2 = BigDecimal.valueOf(2000);
        OrderDTO order = new OrderDTO()
                .setSum(sum2.toPlainString());

        assertNotEquals(sum1.toPlainString(), order.getSum());
        order.setSum(sum1.toPlainString());
        assertEquals(sum1.toPlainString(), order.getSum());
    }

    @Test
    public void When_getPaymentMethod_Expect_correctPaymentMethodReturned() {
        OrderDTO order = new OrderDTO()
                .setPaymentMethod(PaymentMethod.COD);
        assertEquals(PaymentMethod.COD, order.getPaymentMethod());
    }

    @Test
    public void When_setPaymentMethod_Expect_correctPaymentMethodSetted() {
        OrderDTO order = new OrderDTO()
                .setPaymentMethod(PaymentMethod.WIRE_TRANSFER);

        assertNotEquals(PaymentMethod.COD, order.getPaymentMethod());
        order.setPaymentMethod(PaymentMethod.COD);
        assertEquals(PaymentMethod.COD, order.getPaymentMethod());
    }

    @Test
    public void When_getOrderStatus_Expect_correctOrderStatusReturned() {
        OrderDTO order = new OrderDTO()
                .setOrderStatus(OrderStatus.AWAITING_PAYMENT);
        assertEquals(OrderStatus.AWAITING_PAYMENT, order.getOrderStatus());
    }

    @Test
    public void When_setOrderStatus_Expect_correctOrderStatusSetted() {
        OrderDTO order = new OrderDTO()
                .setOrderStatus(OrderStatus.AWAITING_SHIPMENT);

        assertNotEquals(OrderStatus.AWAITING_PAYMENT, order.getOrderStatus());
        order.setOrderStatus(OrderStatus.AWAITING_PAYMENT);
        assertEquals(OrderStatus.AWAITING_PAYMENT, order.getOrderStatus());
    }

    @Test
    public void When_getZip_Expect_correctZipReturned() {
        OrderDTO order = new OrderDTO()
                .setZip("zip");
        assertEquals("zip", order.getZip());
    }

    @Test
    public void When_setZip_Expect_correctZipSetted() {
        OrderDTO order = new OrderDTO()
                .setZip("notzip");
        assertNotEquals("zip", order.getZip());
        order.setZip("zip");
        assertEquals("zip", order.getZip());
    }

    @Test
    public void When_getCity_Expect_correctCityReturned() {
        OrderDTO order = new OrderDTO()
                .setCity("city");
        assertEquals("city", order.getCity());
    }

    @Test
    public void When_setCity_Expect_correctCitySetted() {
        OrderDTO order = new OrderDTO()
                .setCity("notcity");
        assertNotEquals("city", order.getCity());
        order.setCity("city");
        assertEquals("city", order.getCity());
    }

    @Test
    public void When_getStreet_Expect_correctStreetReturned() {
        OrderDTO order = new OrderDTO()
                .setStreet("street");
        assertEquals("street", order.getStreet());
    }

    @Test
    public void When_setStreet_Expect_correctStreetSetted() {
        OrderDTO order = new OrderDTO()
                .setStreet("notstreet");
        assertNotEquals("street", order.getStreet());
        order.setStreet("street");
        assertEquals("street", order.getStreet());
    }

    @Test
    public void When_getAddress_Expect_correctAddressReturned() {
        OrderDTO order = new OrderDTO()
                .setAddress("address");
        assertEquals("address", order.getAddress());
    }

    @Test
    public void When_setAddress_Expect_correctAddressSetted() {
        OrderDTO order = new OrderDTO()
                .setAddress("notaddress");
        assertNotEquals("address", order.getAddress());
        order.setAddress("address");
        assertEquals("address", order.getAddress());
    }

    @Test
    public void When_getOrderDate_Expect_correctOrderDateReturned() {
        Date date = new Date();
        OrderDTO order = new OrderDTO()
                .setOrderDate(date);

        assertEquals(date, order.getOrderDate());
    }

    @Test
    public void When_setOrderDate_Expect_correctOrderDateSetted() {
        Date date1 = new Date();
        Date date2 = new Date();
        date2.setTime(1000);

        OrderDTO order = new OrderDTO()
                .setOrderDate(date2);

        assertNotEquals(date1, order.getOrderDate());
        order.setOrderDate(date1);
        assertEquals(date1, order.getOrderDate());
    }

    @Test
    public void When_getItems_Expect_correctItemsReturned() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3");
        List<OrderItemDTO> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        OrderDTO order = new OrderDTO()
                .setItems(items);

        assertEquals(items, order.getItems());
    }

    @Test
    public void When_setItems_Expect_correctItemsSetted() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items1 = new ArrayList <>();
        items1.add(item1);
        items1.add(item2);
        items1.add(item3);
        OrderItemDTO item4 = new OrderItemDTO()
                .setName("Item4")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item5 = new OrderItemDTO()
                .setName("Item5")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item6 = new OrderItemDTO()
                .setName("Item6")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items2 = new ArrayList <>();
        items2.add(item4);
        items2.add(item5);
        items2.add(item6);

        OrderDTO order = new OrderDTO()
                .setItems(items2);

        assertNotEquals(items1, order.getItems());
        order.setItems(items1);
        assertEquals(items1, order.getItems());
    }

    @Test
    public void When_getVatSummary_Expect_correctVatSummaryReturned() {
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        OrderDTO order = new OrderDTO()
                .setVatSummary(summary);

        assertEquals(summary, order.getVatSummary());
    }

    @Test
    public void When_setVatSummary_Expect_correctVatSummarySetted() {
        Map<Integer, String> summary1 = new TreeMap <>();
        summary1.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary1.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary1.put(5, BigDecimal.valueOf(3200).toPlainString());
        Map<Integer, String> summary2 = new TreeMap <>();
        summary2.put(27, BigDecimal.valueOf(6300).toPlainString());
        summary2.put(18, BigDecimal.valueOf(6200).toPlainString());
        summary2.put(5, BigDecimal.valueOf(73300).toPlainString());
        OrderDTO order = new OrderDTO()
                .setVatSummary(summary2);

        assertNotEquals(summary1, order.getVatSummary());
        order.setVatSummary(summary1);
        assertEquals(summary1, order.getVatSummary());
    }

    @Test
    public void When_EqualsSame_Expect_true() {
        OrderDTO order = new OrderDTO()
                .setId(UUID.randomUUID());
        assertEquals(order, order);
    }

    @Test
    public void When_equalsNull_Expect_false() {
        OrderDTO order = new OrderDTO();
        assertNotEquals(order, null);
    }

    @Test
    public void When_EqualsDifferentType_Expect_false() {
        OrderDTO order = new OrderDTO()
                .setId(UUID.randomUUID());
        assertNotEquals(order, "Hello");
    }

    @Test
    public void When_EqualsIdentical_Expect_true() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertEquals(order1, order2);
    }

    @Test
    public void When_EqualsIdDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(UUID.randomUUID())
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }

    @Test
    public void When_EqualsuserIdDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(UUID.randomUUID())
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(UUID.randomUUID())
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }



    @Test
    public void When_EqualsIpDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.1")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }



    @Test
    public void When_EqualsNameDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Adam Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }



    @Test
    public void When_EqualsSumDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1400")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1100")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }



    @Test
    public void When_EqualsPaymentMethodDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.WIRE_TRANSFER)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }



    @Test
    public void When_EqualsOrderStatusDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.AWAITING_PAYMENT)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }



    @Test
    public void When_EqualsZipDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("2000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }



    @Test
    public void When_EqualsCityDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("Gotham")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }



    @Test
    public void When_EqualsStreetDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Main str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }



    @Test
    public void When_EqualsAddressDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("15.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }



    @Test
    public void When_Equals_ExpectOrderDateDifferent_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(Date.from(Instant.now()))
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(Date.from(LocalDateTime.now().minusDays(2).toInstant(ZoneOffset.UTC)))
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }

    @Test
    public void When_EqualsItemsDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items1 = new ArrayList <>();
        items1.add(item1);
        items1.add(item2);
        items1.add(item3);
        OrderItemDTO item4 = new OrderItemDTO()
                .setName("Item4")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item5 = new OrderItemDTO()
                .setName("Item5")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item6 = new OrderItemDTO()
                .setName("Item6")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items2 = new ArrayList <>();
        items2.add(item4);
        items2.add(item5);
        items2.add(item6);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items1)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items2)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }

    @Test
    public void When_EqualsNullWithItems_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }

    @Test
    public void When_EqualsNullWithItemsBoth_Expect_true() {
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setVatSummary(summary);

        assertEquals(order1, order2);
    }

    @Test
    public void When_EqualsVatSummaryDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary1 = new TreeMap <>();
        summary1.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary1.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary1.put(5, BigDecimal.valueOf(3200).toPlainString());
        Map<Integer, String> summary2 = new TreeMap <>();
        summary2.put(27, BigDecimal.valueOf(5234).toPlainString());
        summary2.put(18, BigDecimal.valueOf(623524).toPlainString());
        summary2.put(5, BigDecimal.valueOf(341431).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary1);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary2);

        assertNotEquals(order1, order2);
    }

    @Test
    public void When_EqualsVatSummaryNull_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1, order2);
    }

    @Test
    public void When_EqualsVatSummaryNullBoth_Expect_true() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items);
        assertEquals(order1, order2);
    }

    @Test
    public void When_hashCodeIdentical_Expect_true() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertEquals(order1.hashCode(), order2.hashCode());
    }

    @Test
    public void When_hashCodeIdenticalWithNullItems_Expect_true() {
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setVatSummary(summary);

        assertEquals(order1.hashCode(), order2.hashCode());
    }

    @Test
    public void When_hashCodeIdenticalWithNullSummary_Expect_true() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items);

        assertEquals(order1.hashCode(), order2.hashCode());
    }

    @Test
    public void When_hashCodeDifferent_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setName("Item1")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setName("Item2")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item3 = new OrderItemDTO()
                .setName("Item3")
                .setProductId(UUID.randomUUID())
                .setPriceNet("1000")
                .setQuantity(10)
                .setVat(27)
                .setPriceGross("1270");
        List<OrderItemDTO> items = new ArrayList <>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Map<Integer, String> summary = new TreeMap <>();
        summary.put(27, BigDecimal.valueOf(2000).toPlainString());
        summary.put(18, BigDecimal.valueOf(7000).toPlainString());
        summary.put(5, BigDecimal.valueOf(3200).toPlainString());
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        OrderDTO order1 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Kiss")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);
        OrderDTO order2 = new OrderDTO()
                .setId(id)
                .setUserId(userId)
                .setIpAddress("10.0.0.0")
                .setName("Bela Nagy")
                .setSum("1000")
                .setPaymentMethod(PaymentMethod.COD)
                .setOrderStatus(OrderStatus.PENDING)
                .setZip("1000")
                .setCity("City")
                .setStreet("Street str.")
                .setAddress("12.")
                .setOrderDate(now)
                .setItems(items)
                .setVatSummary(summary);

        assertNotEquals(order1.hashCode(), order2.hashCode());
    }


}