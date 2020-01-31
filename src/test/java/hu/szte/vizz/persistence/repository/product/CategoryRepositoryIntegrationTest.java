package hu.szte.vizz.persistence.repository.product;

import hu.szte.vizz.persistence.entity.product.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepository;

    private Category category1;

    @Before
    public void setUp() {
        category1 = new Category()
                .setName("Category1");
        Category category2 = new Category()
                .setName("Category2");
        entityManager.persist(category1);
        entityManager.persist(category2);
        entityManager.flush();
    }

    @Test
    public void When_findByName_Expect_correctValues() {
        Category category = categoryRepository.findByName(category1.getName()).orElse(null);
        assertEquals(category1, category);

        category = categoryRepository.findByName("nothinglikethis").orElse(null);
        assertNull(category);
    }
}