package hu.szte.vizz.model.product;

import hu.szte.vizz.persistence.entity.product.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ProductDTOUnitTest {
    private Category category1, category2;

    @Before
    public void setUp() {
        category1 = new Category()
                .setId(UUID.randomUUID())
                .setName("Super Category");
        category2 = new Category()
                .setId(UUID.randomUUID())
                .setName("Another Category");
    }

    @Test
    public void When_getId_Expect_correctIdReturned() {
        UUID id = UUID.randomUUID();
        ProductDTO product = new ProductDTO()
                .setId(id);
        assertEquals(id, product.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        ProductDTO product = new ProductDTO()
                .setId(UUID.randomUUID());
        assertNotEquals(id, product.getId());
        product.setId(id);
        assertEquals(id, product.getId());
    }

    @Test
    public void When_getCategoryId_Expect_correctCategoryIdReturned() {
        ProductDTO product = new ProductDTO()
                .setCategoryId(category1.getId());
        assertEquals(category1.getId(), product.getCategoryId());
    }

    @Test
    public void When_setCategoryId_Expect_correctCategoryIdSetted() {
        ProductDTO product = new ProductDTO()
                .setCategoryId(category2.getId());
        assertNotEquals(category1.getId(), product.getCategoryId());
        product.setCategoryId(category1.getId());
        assertEquals(category1.getId(), product.getCategoryId());
    }

    @Test
    public void When_getName_Expect_correctNameReturned() {
        ProductDTO product = new ProductDTO()
                .setName("Name");
        assertEquals("Name", product.getName());
    }

    @Test
    public void When_setName_Expect_correctNameSetted() {
        ProductDTO product = new ProductDTO()
                .setName("Awesome name");
        assertNotEquals("Name", product.getName());
        product.setName("Name");
        assertEquals("Name", product.getName());
    }

    @Test
    public void When_getPictureUrl_Expect_correctPictureUrlReturned() {
        ProductDTO product = new ProductDTO()
                .setPictureUrl("picture");
        assertEquals("picture", product.getPictureUrl());
    }

    @Test
    public void When_setPictureUrl_Expect_correctPictureUrlSetted() {
        ProductDTO product = new ProductDTO()
                .setPictureUrl("picture2");
        assertNotEquals("picture", product.getPictureUrl());
        product.setPictureUrl("picture");
        assertEquals("picture", product.getPictureUrl());
    }

    @Test
    public void When_getPriceNet_Expect_correctPriceNetReturned() {
        BigDecimal value1 = BigDecimal.valueOf(100);
        ProductDTO product = new ProductDTO()
                .setPriceNet(value1.toPlainString());
        assertEquals(value1.toPlainString(), product.getPriceNet());
    }

    @Test
    public void When_setPriceNet_Expect_correctPriceNetSetted() {
        BigDecimal value1 = BigDecimal.valueOf(100);
        BigDecimal value2 = BigDecimal.valueOf(120);
        ProductDTO product = new ProductDTO()
                .setPriceNet(value2.toPlainString());
        assertNotEquals(value1.toPlainString(), product.getPriceNet());
        product.setPriceNet(value1.toPlainString());
        assertEquals(value1.toPlainString(), product.getPriceNet());
    }

    @Test
    public void When_getVat_Expect_correctVatReturned() {
        ProductDTO product = new ProductDTO()
                .setVat(27);
        assertEquals(27, product.getVat());
    }

    @Test
    public void When_setVat_Expect_correctVatSetted() {
        ProductDTO product = new ProductDTO()
                .setVat(18);
        assertNotEquals(27, product.getVat());
        product.setVat(27);
        assertEquals(27, product.getVat());
    }

    @Test
    public void When_getPriceGross_Expect_correctPriceGrossReturned() {
        BigDecimal value = BigDecimal.valueOf(100);
        ProductDTO product = new ProductDTO()
                .setPriceGross(value.toPlainString());
        assertEquals(value.toPlainString(), product.getPriceGross());
    }

    @Test
    public void When_setPriceGross_Expect_correctPriceGrossSetted() {
        BigDecimal value1 = BigDecimal.valueOf(100);
        BigDecimal value2 = BigDecimal.valueOf(120);
        ProductDTO product = new ProductDTO()
                .setPriceGross(value2.toPlainString());
        assertNotEquals(value1.toPlainString(), product.getPriceGross());
        product.setPriceGross(value1.toPlainString());
        assertEquals(value1.toPlainString(), product.getPriceGross());
    }

    @Test
    public void When_getDetails_Expect_correctDetailsReturned() {
        ProductDTO product = new ProductDTO()
                .setDetails("details");
        assertEquals("details", product.getDetails());
    }

    @Test
    public void When_setDetails_Expect_correctDetailsSetted() {
        ProductDTO product = new ProductDTO()
                .setDetails("details2");
        assertNotEquals("details", product.getDetails());
        product.setDetails("details");
        assertEquals("details", product.getDetails());
    }

    @Test
    public void When_equalsSame_Expect_true() {
        ProductDTO product = new ProductDTO();
        assertEquals(product, product);
    }

    @Test
    public void When_equalsIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertEquals(product1, product2);
    }

    @Test
    public void When_equalsDifferentObjectType_Expect_false() {
        ProductDTO product = new ProductDTO();
        assertNotEquals(product, "Hello");
    }

    @Test
    public void When_equalsWithNull_Expect_false() {
        ProductDTO product = new ProductDTO();
        assertNotEquals(product, null);
    }

    @Test
    public void When_equalsDifferentId_Expect_false() {
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(UUID.randomUUID())
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(UUID.randomUUID())
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsNullWithId_Expect_false() {
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(UUID.randomUUID())
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsNullWithIdBoth_Expect_true() {
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertEquals(product1, product2);
    }

    @Test
    public void When_equalsDifferentCategoryId_Expect_false() {
        UUID id = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(UUID.randomUUID())
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(UUID.randomUUID())
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsNullWithCategoryId_Expect_false() {
        UUID id = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(UUID.randomUUID())
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsNullWithCategoryIdBoth_Expect_true() {
        UUID id = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertEquals(product1, product2);
    }

    @Test
    public void When_equalsDifferentVat_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(27)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsDifferentName_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product1")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsDifferentPictureUrl_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pi2x")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsNullWithPictureUrl_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pi2x")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsNullWithPictureUrlBoth_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertEquals(product1, product2);
    }

    @Test
    public void When_equalsDifferentNetPrice_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1300")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsDifferentGrossPrice_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1400")
                .setDetails("Teszt");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsWithNullGrossPrice_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1400")
                .setDetails("Teszt");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsWithNullGrossPriceBoth_Expect_truee() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setDetails("Teszt");
        assertEquals(product1, product2);
    }

    @Test
    public void When_equalsDifferentDetails_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt2");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsWithNullDetails_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt2");
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_equalsWithNullDetails_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100");
        assertEquals(product1, product2);
    }

    @Test
    public void When_hashCodeIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    public void When_hashCodeDifferent_Expect_fale() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt2");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertNotEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    public void When_hashCodeIdenticalWithNullId_Expect_true() {
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    public void When_hashCodeIdenticalWithNullCategoryId_Expect_true() {
        UUID id = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    public void When_hashCodeIdenticalWithNullPictureUrl_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPriceNet("1000")
                .setPriceGross("1100")
                .setDetails("Teszt");
        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    public void When_hashCodeIdenticalWithNullPriceGross_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setDetails("Teszt");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setDetails("Teszt");
        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    public void When_hashCodeIdenticalWithNullDetails_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID catId = UUID.randomUUID();
        ProductDTO product1 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100");
        ProductDTO product2 = new ProductDTO()
                .setId(id)
                .setVat(18)
                .setCategoryId(catId)
                .setName("Product")
                .setPictureUrl("pix")
                .setPriceNet("1000")
                .setPriceGross("1100");
        assertEquals(product1.hashCode(), product2.hashCode());
    }
}