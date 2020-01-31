package hu.szte.vizz.model.product;

import hu.szte.vizz.persistence.entity.product.Product;
import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ReviewDTOUnitTest {

    @Test
    public void When_getId_Expect_correctIdReturned() {
        UUID id = UUID.randomUUID();
        ReviewDTO review = new ReviewDTO()
                .setId(id);

        assertEquals(id, review.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        ReviewDTO review = new ReviewDTO()
                .setId(UUID.randomUUID());
        assertNotEquals(id, review.getId());
        review.setId(id);
        assertEquals(id, review.getId());
    }

    @Test
    public void When_getProductId_Expect_correctProductIdReturned() {
        Product product = new Product()
                .setId(UUID.randomUUID());
        ReviewDTO review = new ReviewDTO()
                .setProductId(product.getId());

        assertEquals(product.getId(), review.getProductId());
    }

    @Test
    public void When_setProductId_Expect_correctProductIdSetted() {
        Product product1 = new Product()
                .setId(UUID.randomUUID());
        Product product2 = new Product()
                .setId(UUID.randomUUID());
        ReviewDTO review = new ReviewDTO()
                .setProductId(product2.getId());
        assertNotEquals(product1.getId(), review.getProductId());
        review.setProductId(product1.getId());
        assertEquals(product1.getId(), review.getProductId());
    }

    @Test
    public void When_getUserId_Expect_correctUserIdReturned() {
        User user = new User()
                .setId(UUID.randomUUID());
        ReviewDTO review = new ReviewDTO()
                .setUserId(user.getId());
        assertEquals(user.getId(), review.getUserId());
    }

    @Test
    public void When_setUserId_Expect_correctUserIdSetted() {
        User user1 = new User()
                .setId(UUID.randomUUID());
        User user2 = new User()
                .setId(UUID.randomUUID());
        ReviewDTO review = new ReviewDTO()
                .setUserId(user2.getId());
        assertNotEquals(user1.getId(), review.getUserId());
        review.setUserId(user1.getId());
        assertEquals(user1.getId(), review.getUserId());
    }

    @Test
    public void When_getDetails_Expect_correctDetailsReturned() {
        ReviewDTO review = new ReviewDTO()
                .setDetails("review");
        assertEquals("review", review.getDetails());
    }

    @Test
    public void When_setDetails_Expect_correctDetailsSetted() {
        ReviewDTO review = new ReviewDTO()
                .setDetails("notreview");
        assertNotEquals("review", review.getDetails());
        review.setDetails("review");
        assertEquals("review", review.getDetails());
    }

    @Test
    public void When_getStars_Expect_correctStarsReturned() {
        ReviewDTO review = new ReviewDTO()
                .setStars(3);
        assertEquals(3, review.getStars());
    }

    @Test
    public void When_setStars_Expect_correctStarsSetted() {
        ReviewDTO review = new ReviewDTO()
                .setStars(3);
        assertNotEquals(5, review.getStars());
        review.setStars(5);
        assertEquals(5, review.getStars());
    }

    @Test
    public void When_getPublishDate_Expect_correctPublishDateReturned() {
        Date date = new Date();
        ReviewDTO review = new ReviewDTO()
                .setPublishDate(date);
        assertEquals(date, review.getPublishDate());
    }

    @Test
    public void When_setPublishDate_Expect_correctPublishDateSetted() {
        Date date = new Date();
        Date date2 = new Date();
        date2.setTime(1000);
        ReviewDTO review = new ReviewDTO()
                .setPublishDate(date2);
        assertNotEquals(date, review.getPublishDate());
        review.setPublishDate(date);
        assertEquals(date, review.getPublishDate());
    }

    @Test
    public void When_equalsSame_Expect_true() {
        ReviewDTO review = new ReviewDTO();
        assertEquals(review, review);
    }

    @Test
    public void When_equalsIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)

                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertEquals(review1, review2);
    }

    @Test
    public void When_equalsWithNull_Expect_false() {
        ReviewDTO review = new ReviewDTO();
        assertNotEquals(review, null);
    }

    @Test
    public void When_equalsWithDifferentObjectType_Expect_false() {
        ReviewDTO review = new ReviewDTO();
        assertNotEquals(review, "Hello");
    }

    @Test
    public void When_equalsDifferent_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setDetails("Details2")
                .setStars(3)
                .setPublishDate(now);
        assertNotEquals(review1, review2);
    }

    @Test
    public void When_equalsWithDifferentlId_Expect_false() {
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(UUID.randomUUID())
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(UUID.randomUUID())
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertNotEquals(review1, review2);
    }

    @Test
    public void When_equalsWithNullId_Expect_false() {
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(UUID.randomUUID())
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertNotEquals(review1, review2);
    }

    @Test
    public void When_equalsWithNullIdBoth_Expect_true() {
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertEquals(review1, review2);
    }

    @Test
    public void When_equalsWithDifferentProductId_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setProductId(UUID.randomUUID())
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setProductId(UUID.randomUUID())
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertNotEquals(review1, review2);
    }

    @Test
    public void When_equalsWithNullProductId_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setProductId(UUID.randomUUID())
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertNotEquals(review1, review2);
    }

    @Test
    public void When_equalsWithNullProductIdBoth_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertEquals(review1, review2);
    }

    @Test
    public void When_equalsWithDifferentUserId_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setUserId(UUID.randomUUID())
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setUserId(UUID.randomUUID())
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertNotEquals(review1, review2);
    }

    @Test
    public void When_equalsWithNullUserId_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setUserId(UUID.randomUUID())
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertNotEquals(review1, review2);
    }

    @Test
    public void When_equalsWithNullUserIdBoth_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertEquals(review1, review2);
    }

    @Test
    public void When_equalsWithNullPublishDate_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertNotEquals(review1, review2);
    }

    @Test
    public void When_equalsWithNullPublishDateBoth_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3);
        assertEquals(review1, review2);
    }

    @Test
    public void When_equalsWithDifferentStars_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(5)
                .setPublishDate(now);
        assertNotEquals(review1, review2);
    }

    @Test
    public void When_equalsWithDifferentDetails_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setProductId(prodId)
                .setDetails("Details2")
                .setStars(3)
                .setPublishDate(now);
        assertNotEquals(review1, review2);
    }

    @Test
    public void When_hashCodeIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)

                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertEquals(review1.hashCode(), review2.hashCode());
    }

    @Test
    public void When_hashCodeDifferent_Expect_false() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setDetails("Details2")
                .setStars(3)
                .setPublishDate(now);
        assertNotEquals(review1.hashCode(), review2.hashCode());
    }

    @Test
    public void When_hashCodeWithNullIdIdentical_Expect_true() {
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setProductId(prodId)
                .setUserId(userId)

                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertEquals(review1.hashCode(), review2.hashCode());
    }

    @Test
    public void When_hashCodeWithNullProductIdIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertEquals(review1.hashCode(), review2.hashCode());
    }

    @Test
    public void When_hashCodeWithNullUserIdIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        Date now = Date.from(Instant.now());
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setDetails("Details")
                .setStars(3)
                .setPublishDate(now);
        assertEquals(review1.hashCode(), review2.hashCode());
    }

    @Test
    public void When_hashCodeWithNullPublishDateIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        UUID prodId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        ReviewDTO review1 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3);
        ReviewDTO review2 = new ReviewDTO()
                .setId(id)
                .setProductId(prodId)
                .setUserId(userId)
                .setDetails("Details")
                .setStars(3);
        assertEquals(review1.hashCode(), review2.hashCode());
    }
}