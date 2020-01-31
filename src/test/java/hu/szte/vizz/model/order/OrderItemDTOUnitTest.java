package hu.szte.vizz.model.order;

import hu.szte.vizz.persistence.entity.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class OrderItemDTOUnitTest {

    @Test
    public void When_getProductId_Expect_correctProductIdReturned() {
        Product product = new Product();
        OrderItemDTO item = new OrderItemDTO()
                .setProductId(product.getId());
        assertEquals(product.getId(), item.getProductId());
    }

    @Test
    public void When_setProductId_Expect_correctProductIdSetted() {
        Product product1 = new Product()
                .setId(UUID.randomUUID());
        Product product2 = new Product()
                .setId(UUID.randomUUID());
        OrderItemDTO item = new OrderItemDTO()
                .setProductId(product2.getId());
        assertNotEquals(product1.getId(), item.getProductId());
        item.setProductId(product1.getId());
        assertEquals(product1.getId(), item.getProductId());
    }

    @Test
    public void When_getName_Expect_correctNameReturned() {
        OrderItemDTO item = new OrderItemDTO()
                .setName("name");

        assertEquals("name", item.getName());
    }

    @Test
    public void When_setName_Expect_correctNameSetted() {
        OrderItemDTO item = new OrderItemDTO()
                .setName("notname");
        assertNotEquals("name", item.getName());
        item.setName("name");
        assertEquals("name", item.getName());
    }

    @Test
    public void When_getQuantity_Expect_correctQuantityReturned() {
        OrderItemDTO item = new OrderItemDTO()
                .setQuantity(10);
        assertEquals(10, item.getQuantity());
    }

    @Test
    public void When_setQuantity_Expect_correctQuantitySetted() {
        OrderItemDTO item = new OrderItemDTO()
                .setQuantity(20);
        assertNotEquals(10, item.getQuantity());
        item.setQuantity(10);
        assertEquals(10, item.getQuantity());
    }

    @Test
    public void When_getPriceNet_Expect_correctPriceNetReturned() {
        BigDecimal value = BigDecimal.valueOf(100);
        OrderItemDTO item = new OrderItemDTO()
                .setPriceNet(value.toPlainString());

        assertEquals(value.toPlainString(), item.getPriceNet());
    }

    @Test
    public void When_setPriceNet_Expect_correctPriceNetSetted() {
        BigDecimal value1 = BigDecimal.valueOf(100);
        BigDecimal value2 = BigDecimal.valueOf(200);
        OrderItemDTO item = new OrderItemDTO()
                .setPriceNet(value2.toPlainString());
        assertNotEquals(value1, item.getPriceNet());
        item.setPriceNet(value1.toPlainString());
        assertEquals(value1.toPlainString(), item.getPriceNet());
    }

    @Test
    public void When_getVat_Expect_correctVatReturned() {
        OrderItemDTO item = new OrderItemDTO()
                .setVat(10);

        assertEquals(10, item.getVat());
    }

    @Test
    public void When_setVat_Expect_correctVatSetted() {
        OrderItemDTO item = new OrderItemDTO()
                .setVat(20);

        assertNotEquals(10, item.getVat());
        item.setVat(10);
        assertEquals(10, item.getVat());
    }

    @Test
    public void When_getPriceGross_Expect_correctPriceGrossReturned() {
        BigDecimal value = BigDecimal.valueOf(100);
        OrderItemDTO item = new OrderItemDTO()
                .setPriceGross(value.toPlainString());

        assertEquals(value.toPlainString(), item.getPriceGross());
    }

    @Test
    public void When_setPriceGross_Expect_correctPriceGrossSetted() {
        BigDecimal value1 = BigDecimal.valueOf(100);
        BigDecimal value2 = BigDecimal.valueOf(200);
        OrderItemDTO item = new OrderItemDTO()
                .setPriceNet(value2.toPlainString());
        assertNotEquals(value1.toPlainString(), item.getPriceGross());
        item.setPriceGross(value1.toPlainString());
        assertEquals(value1.toPlainString(), item.getPriceGross());
    }

    @Test
    public void When_equalsSame_Expect_true() {
        OrderItemDTO orderItem = new OrderItemDTO();
        assertEquals(orderItem, orderItem);
    }


    @Test
    public void When_equalsDifferentType_Expect_false() {
        OrderItemDTO orderItem = new OrderItemDTO();
        assertNotEquals(orderItem, "Hello");
    }


    @Test
    public void When_equalsWithNull_Expect_false() {
        OrderItemDTO orderItem = new OrderItemDTO();
        assertNotEquals(orderItem, null);
    }

    @Test
    public void When_equalsIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        OrderItemDTO item1 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        assertEquals(item1, item2);
    }

    @Test
    public void When_equalsDifferentQuantity_Expect_false() {
        UUID id = UUID.randomUUID();
        OrderItemDTO item1 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setQuantity(20)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        assertNotEquals(item1, item2);
    }

    @Test
    public void When_equalsDifferentVat_Expect_false() {
        UUID id = UUID.randomUUID();
        OrderItemDTO item1 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(18)
                .setPriceGross("1270");
        assertNotEquals(item1, item2);
    }

    @Test
    public void When_equalsDifferentProductId_Expect_false() {
        OrderItemDTO item1 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(UUID.randomUUID())
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(UUID.randomUUID())
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        assertNotEquals(item1, item2);
    }

    @Test
    public void When_equalsDifferentName_Expect_false() {
        UUID id = UUID.randomUUID();
        OrderItemDTO item1 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product2")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        assertNotEquals(item1, item2);
    }

    @Test
    public void When_equalsDifferentPriceNet_Expect_false() {
        UUID id = UUID.randomUUID();
        OrderItemDTO item1 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1200")
                .setVat(27)
                .setPriceGross("1270");
        assertNotEquals(item1, item2);
    }

    @Test
    public void When_equalsDifferentPriceGross_Expect_false() {
        UUID id = UUID.randomUUID();
        OrderItemDTO item1 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1370");
        assertNotEquals(item1, item2);
    }

    @Test
    public void When_hashCodeIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        OrderItemDTO item1 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        assertEquals(item1.hashCode(), item2.hashCode());
    }

    @Test
    public void When_hashCodeDifferent_Expect_false() {
        UUID id = UUID.randomUUID();
        OrderItemDTO item1 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        OrderItemDTO item2 = new OrderItemDTO()
                .setQuantity(10)
                .setVat(10)
                .setProductId(id)
                .setName("Product2")
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270");
        assertNotEquals(item1.hashCode(), item2.hashCode());
    }
}