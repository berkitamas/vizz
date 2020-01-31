package hu.szte.vizz.persistence.repository.product;

import hu.szte.vizz.persistence.entity.product.Product;
import hu.szte.vizz.persistence.entity.product.Review;
import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReviewRepository reviewRepository;

    private User user1, user2;

    private Product product1, product2;

    private Review review1, review2, review3, review4;

    @Before
    public void setUp() {
        user1 = new User()
                .setUsername("alex1")
                .setEmail("alex1@email.com")
                .setPassword(BCrypt.hashpw("passw0rd", BCrypt.gensalt()))
                .setFirstName("Alex")
                .setLastName("Doe");
        user2 = new User()
                .setUsername("eva1")
                .setEmail("eva1@email.com")
                .setPassword(BCrypt.hashpw("M0nkey!", BCrypt.gensalt()))
                .setFirstName("Eva")
                .setLastName("Doe")
                .setAdmin(true);
        entityManager.persist(user1);
        entityManager.persist(user2);
        product1 = new Product()
                .setName("Awesome product")
                .setPriceNet(BigDecimal.valueOf(1000))
                .setVat(27)
                .setDetails("Lorem Ipsum Dolor Sit Amet");
        product2 = new Product()
                .setName("Wonderful product")
                .setPriceNet(BigDecimal.valueOf(10000))
                .setVat(18)
                .setDetails("Another longer text");
        entityManager.persist(product1);
        entityManager.persist(product2);
        review1 = new Review()
                .setUser(user1)
                .setProduct(product1)
                .setDetails("It was awesome")
                .setStars(4)
                .setPublishDate(new Date());
        review2 = new Review()
                .setUser(user2)
                .setProduct(product1)
                .setDetails("It was shit")
                .setStars(1)
                .setPublishDate(new Date());
        review3 = new Review()
                .setUser(user1)
                .setProduct(product2)
                .setDetails("It was shit")
                .setStars(1)
                .setPublishDate(new Date());
        review4 = new Review()
                .setUser(user2)
                .setProduct(product2)
                .setDetails("It was awesome")
                .setStars(4)
                .setPublishDate(Date.from(LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC)));
        entityManager.persist(review1);
        entityManager.persist(review2);
        entityManager.persist(review3);
        entityManager.persist(review4);
        entityManager.flush();
    }

    @Test
    public void When_findAllByProductAndPublishDateBetween_Expect_filteredValues() {
        Collection<Review> expectedValues = new ArrayList <>();
        expectedValues.add(review4);
        Collection<Review> currentValues = reviewRepository.findAllByProductAndPublishDateBetween(
                review4.getProduct(),
                Date.from(
                        review4.getPublishDate()
                            .toInstant()
                            .atZone(ZoneId.of("UTC"))
                            .toLocalDateTime()
                            .minusHours(1)
                            .toInstant(ZoneOffset.UTC)
                ),
                Date.from(
                        review4.getPublishDate()
                                .toInstant()
                                .atZone(ZoneId.of("UTC"))
                                .toLocalDateTime()
                                .plusHours(1)
                                .toInstant(ZoneOffset.UTC)
                ),
                PageRequest.of(0, 5)
        ).getContent();

        assertTrue(expectedValues.containsAll(currentValues) && currentValues.containsAll(expectedValues));
    }

    @Test
    public void When_findAllByProduct_Expect_correctReviews() {
        Collection<Review> expectedValues = new ArrayList <>();
        expectedValues.add(review1);
        expectedValues.add(review2);
        Collection<Review> currentValues = reviewRepository.findAllByProduct(product1, PageRequest.of(0, 5)).getContent();

        assertTrue(expectedValues.containsAll(currentValues) && currentValues.containsAll(expectedValues));
    }

    @Test
    public void When_findAllByUser_correctReviews() {
        Collection<Review> expectedValues = new ArrayList <>();
        expectedValues.add(review1);
        expectedValues.add(review3);
        Collection<Review> currentValues = reviewRepository.findAllByUser(user1, PageRequest.of(0, 5)).getContent();

        assertTrue(expectedValues.containsAll(currentValues) && currentValues.containsAll(expectedValues));
    }
}