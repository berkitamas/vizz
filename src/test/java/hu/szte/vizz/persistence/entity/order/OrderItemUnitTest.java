package hu.szte.vizz.persistence.entity.order;

import hu.szte.vizz.persistence.entity.order.Order;
import hu.szte.vizz.persistence.entity.order.OrderItem;
import hu.szte.vizz.persistence.entity.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class OrderItemUnitTest {
    @Test
    public void When_newItemWithOrderAndProduct_Expect_itemIsCreatedWithProduct() {
        Product product = new Product()
                .setId(UUID.randomUUID());
        Order order = new Order()
                .setId(UUID.randomUUID());
        OrderItem item = new OrderItem(order, product);
        assertEquals(product, item.getProduct());
        assertEquals(order, item.getOrder());
    }

    @Test
    public void When_getId_Expect_correctId() {
        UUID id = UUID.randomUUID();
        OrderItem item = new OrderItem()
                .setId(id);

        assertEquals(id, item.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        OrderItem item = new OrderItem()
                .setId(UUID.randomUUID());
        assertNotEquals(id, item.getId());
        item.setId(id);
        assertEquals(id, item.getId());
    }

    @Test
    public void whenGetOrder_thenReturnsOrder() {
        Order order = new Order();
        OrderItem item = new OrderItem()
                .setOrder(order);

        assertEquals(order, item.getOrder());
    }

    @Test
    public void When_setOrder_Expect_correctOrderSetted() {
        Order order1 = new Order()
                .setId(UUID.randomUUID());
        Order order2 = new Order()
                .setId(UUID.randomUUID());
        OrderItem item = new OrderItem()
                .setOrder(order2);
        assertNotEquals(order1, item.getOrder());
        item.setOrder(order1);
        assertEquals(order1, item.getOrder());
    }

    @Test
    public void When_getProduct_Expect_correctProduct() {
        Product product = new Product();
        OrderItem item = new OrderItem()
                .setProduct(product);
        assertEquals(product, item.getProduct());
    }

    @Test
    public void When_setProduct_Expect_correctProductSetted() {
        Product product1 = new Product()
                .setId(UUID.randomUUID());
        Product product2 = new Product()
                .setId(UUID.randomUUID());
        OrderItem item = new OrderItem()
                .setProduct(product2);
        assertNotEquals(product1, item.getProduct());
        item.setProduct(product1);
        assertEquals(product1, item.getProduct());
    }

    @Test
    public void When_getName_Expect_correctName() {
        OrderItem item = new OrderItem()
                .setName("name");

        assertEquals("name", item.getName());
    }

    @Test
    public void When_setName_Expect_correctNameSetted() {
        OrderItem item = new OrderItem()
                .setName("notname");
        assertNotEquals("name", item.getName());
        item.setName("name");
        assertEquals("name", item.getName());
    }

    @Test
    public void When_getQuantity_Expect_correctQuantity() {
        OrderItem item = new OrderItem()
                .setQuantity(10);
        assertEquals(10, item.getQuantity());
    }

    @Test
    public void When_setQuantity_Expect_correctQuantitySetted() {
        OrderItem item = new OrderItem()
                .setQuantity(20);
        assertNotEquals(10, item.getQuantity());
        item.setQuantity(10);
        assertEquals(10, item.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void When_setQuantityNegative_Expect_exception() {
        new OrderItem()
                .setQuantity(-1);
    }

    @Test
    public void When_getPriceNet_Expect_correctNetPrice() {
        BigDecimal value = BigDecimal.valueOf(100);
        OrderItem item = new OrderItem()
                .setPriceNet(value);

        assertEquals(value, item.getPriceNet());
    }

    @Test
    public void When_setPriceNet_Expect_correctNetPriceSetted() {
        BigDecimal value1 = BigDecimal.valueOf(100);
        BigDecimal value2 = BigDecimal.valueOf(200);
        OrderItem item = new OrderItem()
                .setPriceNet(value2);
        assertNotEquals(value1, item.getPriceNet());
        item.setPriceNet(value1);
        assertEquals(value1, item.getPriceNet());
    }

    @Test
    public void When_getVat_Expect_correctVat() {
        OrderItem item = new OrderItem()
                .setVat(10);

        assertEquals(10, item.getVat());
    }

    @Test
    public void When_setVat_Expect_correctVatSetted() {
        OrderItem item = new OrderItem()
                .setVat(20);

        assertNotEquals(10, item.getVat());
        item.setVat(10);
        assertEquals(10, item.getVat());
    }

    @Test(expected = IllegalArgumentException.class)
    public void When_setVatNegative_Expect_exception() {
        new OrderItem()
                .setVat(-20);
    }

    @Test
    public void When_orderItemEqualsSame_Expect_equal() {
        OrderItem item = new OrderItem()
                .setId(UUID.randomUUID());

        assertEquals(item, item);
    }

    @Test
    public void When_orderItemEqualsIdentical_Expect_equal() {
        UUID id = UUID.randomUUID();
        OrderItem item1 = new OrderItem()
                .setId(id);
        OrderItem item2 = new OrderItem()
                .setId(id);

        assertEquals(item1, item2);
    }

    @Test
    public void When_orderItemEqualsDifferent_Expect_different() {
        OrderItem location1 = new OrderItem()
                .setId(UUID.randomUUID());
        OrderItem location2 = new OrderItem()
                .setId(UUID.randomUUID());
        assertNotEquals(location1, location2);
    }

    @Test
    public void When_orderItemEqualsDifferentObject_Expect_different() {
        OrderItem location = new OrderItem()
                .setId(UUID.randomUUID());
        assertNotEquals(location, "notitem");
    }

    @Test
    public void When_orderItemEqualsNullObject_Expect_different() {
        OrderItem location1 = new OrderItem()
                .setId(UUID.randomUUID());
        assertNotEquals(location1, null);
    }

    @Test
    public void When_orderItemHashCodeEquals_Expect_equal() {
        UUID id = UUID.randomUUID();
        OrderItem item1 = new OrderItem()
                .setId(id);
        OrderItem item2 = new OrderItem()
                .setId(id);

        assertEquals(item1.hashCode(), item2.hashCode());
    }

    @Test
    public void When_orderItemHashCodeNotEquals_Expect_different() {
        OrderItem item1 = new OrderItem()
                .setId(UUID.randomUUID());
        OrderItem item2 = new OrderItem()
                .setId(UUID.randomUUID());
        assertNotEquals(item1.hashCode(), item2.hashCode());
    }
}