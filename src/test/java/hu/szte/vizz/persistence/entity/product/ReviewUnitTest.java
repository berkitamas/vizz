package hu.szte.vizz.persistence.entity.product;

import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ReviewUnitTest {

    @Test
    public void When_getId_Expect_correctId() {
        UUID id = UUID.randomUUID();
        Review review = new Review()
                .setId(id);

        assertEquals(id, review.getId());
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        Review review = new Review()
                .setId(UUID.randomUUID());
        assertNotEquals(id, review.getId());
        review.setId(id);
        assertEquals(id, review.getId());
    }

    @Test
    public void When_getProduct_Expect_correctProduct() {
        Product product = new Product()
                .setId(UUID.randomUUID());
        Review review = new Review()
                .setProduct(product);

        assertEquals(product, review.getProduct());
    }

    @Test
    public void When_setProduct_Expect_correctProductSetted() {
        Product product1 = new Product()
                .setId(UUID.randomUUID());
        Product product2 = new Product()
                .setId(UUID.randomUUID());
        Review review = new Review()
                .setProduct(product2);
        assertNotEquals(product1, review.getProduct());
        review.setProduct(product1);
        assertEquals(product1, review.getProduct());
    }

    @Test
    public void When_getUser_Expect_correctUser() {
        User user = new User()
                .setId(UUID.randomUUID());
        Review review = new Review()
                .setUser(user);
        assertEquals(user, review.getUser());
    }

    @Test
    public void When_setUser_Expect_correctUserSetted() {
        User user1 = new User()
                .setId(UUID.randomUUID());
        User user2 = new User()
                .setId(UUID.randomUUID());
        Review review = new Review()
                .setUser(user2);
        assertNotEquals(user1, review.getUser());
        review.setUser(user1);
        assertEquals(user1, review.getUser());
    }

    @Test
    public void When_getDetails_Expect_correctDetails() {
        Review review = new Review()
                .setDetails("review");
        assertEquals("review", review.getDetails());
    }

    @Test
    public void When_setDetails_Expect_correctDetailsSetted() {
        Review review = new Review()
                .setDetails("notreview");
        assertNotEquals("review", review.getDetails());
        review.setDetails("review");
        assertEquals("review", review.getDetails());
    }

    @Test
    public void When_getStars_Expect_correctAmount() {
        Review review = new Review()
                .setStars(3);
        assertEquals(3, review.getStars());
    }

    @Test
    public void When_setStars_Expect_correctAmountSetted() {
        Review review = new Review()
                .setStars(3);
        assertNotEquals(5, review.getStars());
        review.setStars(5);
        assertEquals(5, review.getStars());
    }

    @Test(expected = IllegalArgumentException.class)
    public void When_setMoreStars_Expect_exception() {
        new Review()
                .setStars(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void When_setNegativeStars_Expect_exception() {
        new Review()
                .setStars(0);
    }

    @Test
    public void When_getPublishDate_Expect_correctDate() {
        Date date = new Date();
        Review review = new Review()
                .setPublishDate(date);
        assertEquals(date, review.getPublishDate());
    }

    @Test
    public void When_setPublishDate_Expect_correctDateSetted() {
        Date date = new Date();
        Date date2 = new Date();
        date2.setTime(1000);
        Review review = new Review()
                .setPublishDate(date2);
        assertNotEquals(date, review.getPublishDate());
        review.setPublishDate(date);
        assertEquals(date, review.getPublishDate());
    }

    @Test
    public void When_reviewEqualsSame_Expect_equal() {
        Review review = new Review()
                .setId(UUID.randomUUID());
        assertEquals(review, review);
    }

    @Test
    public void When_reviewEqualsIdentical_Expect_equal() {
        UUID id = UUID.randomUUID();
        Review review1 = new Review()
                .setId(id);
        Review review2 = new Review()
                .setId(id);

        assertEquals(review1, review2);
    }

    @Test
    public void When_reviewEqualsDifferent_Expect_different() {
        Review review1 = new Review()
                .setId(UUID.randomUUID());
        Review review2 = new Review()
                .setId(UUID.randomUUID());

        assertNotEquals(review1, review2);
    }

    @Test
    public void When_reviewEqualsDifferentObject_Expect_different() {
        Review review = new Review()
                .setId(UUID.randomUUID());

        assertNotEquals(review, "notreview");
    }

    @Test
    public void When_reviewEqualsNullObject_Expect_different() {
        Review review = new Review()
                .setId(UUID.randomUUID());

        assertNotEquals(review, null);
    }

    @Test
    public void When_reviewHashCodeEquals_Expect_equal() {
        UUID id = UUID.randomUUID();
        Review review1 = new Review()
                .setId(id);
        Review review2 = new Review()
                .setId(id);

        assertEquals(review1.hashCode(), review2.hashCode());
    }

    @Test
    public void When_reviewHashCodeNotEquals_Expect_different() {
        Review review1 = new Review()
                .setId(UUID.randomUUID());
        Review review2 = new Review()
                .setId(UUID.randomUUID());

        assertNotEquals(review1.hashCode(), review2.hashCode());
    }
}