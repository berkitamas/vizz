package hu.szte.vizz.persistence.entity.product;

import hu.szte.vizz.persistence.entity.product.Category;
import hu.szte.vizz.persistence.entity.product.Product;
import hu.szte.vizz.persistence.entity.product.Review;
import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ProductUnitTest {
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
    public void When_getId_Expect_correctId() {
        UUID id = UUID.randomUUID();
        Product product = new Product()
                .setId(id);
        assertEquals(id, product.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        Product product = new Product()
                .setId(UUID.randomUUID());
        assertNotEquals(id, product.getId());
        product.setId(id);
        assertEquals(id, product.getId());
    }

    @Test
    public void When_getCategory_Expect_correctCategory() {
        Product product = new Product()
                .setCategory(category1);
        assertEquals(category1, product.getCategory());
    }

    @Test
    public void When_setCategory_Expect_correctCategorySetted() {
        Product product = new Product()
                .setCategory(category2);
        assertNotEquals(category1, product.getCategory());
        product.setCategory(category1);
        assertEquals(category1, product.getCategory());
    }

    @Test
    public void When_getName_Expect_correctName() {
        Product product = new Product()
                .setName("Name");
        assertEquals("Name", product.getName());
    }

    @Test
    public void When_setName_Expect_correctNameSetted() {
        Product product = new Product()
                .setName("Awesome name");
        assertNotEquals("Name", product.getName());
        product.setName("Name");
        assertEquals("Name", product.getName());
    }

    @Test
    public void When_getPictureUrl_Expect_correctURL() {
        Product product = new Product()
                .setPictureUrl("picture");
        assertEquals("picture", product.getPictureUrl());
    }

    @Test
    public void When_setPictureUrl_Expect_correctURLSetted() {
        Product product = new Product()
                .setPictureUrl("picture2");
        assertNotEquals("picture", product.getPictureUrl());
        product.setPictureUrl("picture");
        assertEquals("picture", product.getPictureUrl());
    }

    @Test
    public void When_getPriceNet_Expect_correctNetPrice() {
        BigDecimal value1 = BigDecimal.valueOf(100);
        Product product = new Product()
                .setPriceNet(value1);
        assertEquals(value1, product.getPriceNet());
    }

    @Test
    public void When_setPriceNet_Expect_correctNetPriceSetted() {
        BigDecimal value1 = BigDecimal.valueOf(100);
        BigDecimal value2 = BigDecimal.valueOf(120);
        Product product = new Product()
                .setPriceNet(value2);
        assertNotEquals(value1, product.getPriceNet());
        product.setPriceNet(value1);
        assertEquals(value1, product.getPriceNet());
    }

    @Test
    public void When_getVat_Expect_correctVat() {
        Product product = new Product()
                .setVat(27);
        assertEquals(27, product.getVat());
    }

    @Test
    public void When_setVat_Expect_correctVatSetted() {
        Product product = new Product()
                .setVat(18);
        assertNotEquals(27, product.getVat());
        product.setVat(27);
        assertEquals(27, product.getVat());
    }

    @Test
    public void When_getDetails_Expect_correctDetails() {
        Product product = new Product()
                .setDetails("details");
        assertEquals("details", product.getDetails());
    }

    @Test
    public void When_setDetails_Expect_correctDetailsSetted() {
        Product product = new Product()
                .setDetails("details2");
        assertNotEquals("details", product.getDetails());
        product.setDetails("details");
        assertEquals("details", product.getDetails());
    }

    @Test
    public void When_isActiveDefault_Expect_NotActive() {
        Product product = new Product();
        assertFalse(product.isActive());
    }

    @Test
    public void When_isActive_Expect_Active() {
        Product product = new Product()
                .setActive(true);
        assertTrue(product.isActive());
    }

    @Test
    public void When_setActive_Expect_Active() {
        Product product = new Product();
        assertFalse(product.isActive());
        product.setActive(true);
        assertTrue(product.isActive());
    }

    @Test
    public void When_getReviews_Expect_correctReviews() {
        Product product = new Product()
                .setId(UUID.randomUUID());
        User user = new User()
                .setId(UUID.randomUUID());
        Review review1 = new Review()
                .setId(UUID.randomUUID())
                .setProduct(product)
                .setUser(user)
                .setDetails("details");
        Review review2 = new Review()
                .setId(UUID.randomUUID())
                .setProduct(product)
                .setUser(user)
                .setDetails("details");
        Review review3 = new Review()
                .setId(UUID.randomUUID())
                .setProduct(product)
                .setUser(user)
                .setDetails("details");
        List<Review> reviews = new ArrayList <>();
        reviews.add(review1);
        reviews.add(review2);
        reviews.add(review3);
        product.setReviews(reviews);
        assertEquals(reviews, product.getReviews());
    }

    @Test
    public void When_setReviews_Expect_correctReviewsSetted() {
        Product product = new Product()
                .setId(UUID.randomUUID());
        User user = new User()
                .setId(UUID.randomUUID());
        Review review1 = new Review()
                .setId(UUID.randomUUID())
                .setProduct(product)
                .setUser(user)
                .setDetails("details");
        Review review2 = new Review()
                .setId(UUID.randomUUID())
                .setProduct(product)
                .setUser(user)
                .setDetails("details");
        List<Review> reviews1 = new ArrayList <>();
        List<Review> reviews2 = new ArrayList <>();
        reviews1.add(review1);
        reviews2.add(review2);
        product.setReviews(reviews2);
        assertNotEquals(reviews1, product.getReviews());
        product.setReviews(reviews1);
        assertEquals(reviews1, product.getReviews());
    }

    @Test
    public void When_productEqualsSame_Expect_equal() {
        Product product1 = new Product()
                .setId(UUID.randomUUID());
        assertEquals(product1, product1);
    }

    @Test
    public void When_productEqualsIdentical_Expect_equal() {
        UUID id = UUID.randomUUID();
        Product product1 = new Product()
                .setId(id);
        Product product2 = new Product()
                .setId(id);
        assertEquals(product1, product2);
    }

    @Test
    public void When_productNotEqualsSameObject_Expect_different() {
        Product product1 = new Product()
                .setId(UUID.randomUUID());
        Product product2 = new Product()
                .setId(UUID.randomUUID());
        assertNotEquals(product1, product2);
    }

    @Test
    public void When_productNotEqualsDifferentObject_Expect_different() {
        Product product = new Product()
                .setId(UUID.randomUUID());
        assertNotEquals(product, "notproduct");
    }

    @Test
    public void When_productNotEqualsNullObject_Expect_different() {
        Product product = new Product()
                .setId(UUID.randomUUID());
        assertNotEquals(product, null);
    }

    @Test
    public void When_productSameHashCode_Expect_equal() {
        UUID id = UUID.randomUUID();
        Product product1 = new Product()
                .setId(id);
        Product product2 = new Product()
                .setId(id);

        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    public void When_productDifferentHashCode_Expect_different() {
        Product product1 = new Product()
                .setId(UUID.randomUUID());
        Product product2 = new Product()
                .setId(UUID.randomUUID());

        assertNotEquals(product1.hashCode(), product2.hashCode());
    }
}