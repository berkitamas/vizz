package hu.szte.vizz.persistence.repository.product;

import hu.szte.vizz.persistence.entity.product.Category;
import hu.szte.vizz.persistence.entity.product.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    private Category category1, category2;

    private Product product1, product2, product3;

    @Before
    public void setUp() {
        category1 = new Category()
                .setName("Category1");
        category2 = new Category()
                .setName("Category2");
        entityManager.persist(category1);
        entityManager.persist(category2);
        product1 = new Product()
                .setName("Awesome product")
                .setCategory(category1)
                .setPriceNet(BigDecimal.valueOf(1000))
                .setVat(27)
                .setDetails("Lorem Ipsum Dolor Sit Amet");
        product2 = new Product()
                .setName("Wonderful product")
                .setCategory(category1)
                .setPriceNet(BigDecimal.valueOf(10000))
                .setVat(18)
                .setDetails("Another longer text");
        product3 = new Product()
                .setName("New product")
                .setCategory(category2)
                .setPriceNet(BigDecimal.valueOf(50000))
                .setVat(5)
                .setDetails("Very long text");
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.persist(product3);
        entityManager.flush();
    }

    @Test
    public void When_findAllByCategory_Expect_filteredProducts() {
        Collection<Product> expectedProducts = new ArrayList <>();
        expectedProducts.add(product1);
        expectedProducts.add(product2);
        Collection<Product> actualProducts = productRepository.findAllByCategory(category1, PageRequest.of(0, 5)).getContent();

        assertTrue(expectedProducts.containsAll(actualProducts) && actualProducts.containsAll(expectedProducts));
    }
}