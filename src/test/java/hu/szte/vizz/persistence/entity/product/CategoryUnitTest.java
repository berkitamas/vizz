package hu.szte.vizz.persistence.entity.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CategoryUnitTest {

    @Test
    public void When_getId_Expect_correctId() {
        UUID id = UUID.randomUUID();
        Category category = new Category()
                .setId(id);
        assertEquals(category.getId(), id);
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        Category category = new Category()
                .setId(UUID.randomUUID());
        assertNotEquals(category.getId(), id);
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    public void When_getName_Expect_correctName() {
        Category category = new Category()
                .setName("Name");
        assertEquals("Name", category.getName());
    }

    @Test
    public void When_setName_Expect_correctNameSetted() {
        Category category = new Category()
                .setName("NotName");
        assertNotEquals("Name", category.getName());
        category.setName("Name");
        assertEquals("Name", category.getName());
    }

    @Test
    public void When_getProducts_Expect_correctProducts() {
        Product product1 = new Product()
                .setId(UUID.randomUUID());
        Product product2 = new Product()
                .setId(UUID.randomUUID());
        Product product3 = new Product()
                .setId(UUID.randomUUID());
        List<Product> products = new ArrayList <>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        Category category = new Category()
                .setProducts(products);
        assertEquals(products, category.getProducts());
    }

    @Test
    public void When_setProducts_Expect_correctProductsSetted() {
        Product product1 = new Product()
                .setId(UUID.randomUUID());
        Product product2 = new Product()
                .setId(UUID.randomUUID());
        Product product3 = new Product()
                .setId(UUID.randomUUID());
        Product product4 = new Product()
                .setId(UUID.randomUUID());
        Product product5 = new Product()
                .setId(UUID.randomUUID());
        Product product6 = new Product()
                .setId(UUID.randomUUID());
        List<Product> products1 = new ArrayList <>();
        List<Product> products2 = new ArrayList <>();
        products1.add(product1);
        products1.add(product2);
        products1.add(product3);
        products2.add(product4);
        products2.add(product5);
        products2.add(product6);
        Category category = new Category()
                .setProducts(products2);
        assertNotEquals(products1, category.getProducts());
        category.setProducts(products1);
        assertEquals(products1, category.getProducts());
    }

    @Test
    public void When_categoryEqualsSame_Expect_equal() {
        Category category = new Category()
                .setId(UUID.randomUUID());

        assertEquals(category, category);
    }

    @Test
    public void When_categoryEqualsIdentical_Expect_equal() {
        UUID id = UUID.randomUUID();
        Category category1 = new Category()
                .setId(id);
        Category category2 = new Category()
                .setId(id);

        assertEquals(category1, category2);
    }

    @Test
    public void When_categorEqualsDifferent_Expect_different() {
        Category category1 = new Category()
                .setId(UUID.randomUUID());
        Category category2 = new Category()
                .setId(UUID.randomUUID());
        assertNotEquals(category1, category2);
    }

    @Test
    public void When_categoryEqualsDifferentObject_Expect_different() {
        Category category = new Category()
                .setId(UUID.randomUUID());
        assertNotEquals(category, "notcategory");
    }

    @Test
    public void When_categoryEqualsNullObject_Expect_different() {
        Category category1 = new Category()
                .setId(UUID.randomUUID());
        assertNotEquals(category1, null);
    }

    @Test
    public void When_categoryHashCodeEquals_Expect_equal() {
        UUID id = UUID.randomUUID();
        Category category1 = new Category()
                .setId(id);
        Category category2 = new Category()
                .setId(id);
        assertEquals(category1.hashCode(), category2.hashCode());
    }

    @Test
    public void When_categoryHashCodeNotEquals_Expect_different() {
        Category category1 = new Category()
                .setId(UUID.randomUUID());
        Category category2 = new Category()
                .setId(UUID.randomUUID());
        assertNotEquals(category1.hashCode(), category2.hashCode());
    }
}