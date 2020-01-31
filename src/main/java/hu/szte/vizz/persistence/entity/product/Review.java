package hu.szte.vizz.persistence.entity.product;

import hu.szte.vizz.persistence.entity.user.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Represents a review entity for the {@link Product}.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Entity
public class Review {
    /**
     * Identifier of the review.
     */
    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(columnDefinition = "VARCHAR(36)")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    /**
     * Product where the review is in.
     */
    @ManyToOne(optional = false)
    private Product product;

    /**
     * Author of the review.
     */
    @ManyToOne(optional = false)
    private User user;

    /**
     * Content of the review.
     */
    @Column(columnDefinition = "TEXT NOT NULL")
    @Lob
    private String details;

    /**
     * Numerical rating of the review.
     *
     * It is between 1 and 5.
     */
    @Column(nullable = false)
    private int stars;

    /**
     * Date when the review was created.
     */
    @Column(nullable = false)
    private Date publishDate;

    /**
     * Returns the identifier of the review.
     *
     * @return {@link #id}
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the identifier of the review.
     *
     * @param id Identifier of the review.
     * @return Current instance of {@link Review}.
     */
    public Review setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the product where the review is in.
     *
     * @return {@link #product}
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product where the review is in.
     *
     * @param product Product where the review is in.
     * @return Current instance of {@link Review}.
     */
    public Review setProduct(Product product) {
        this.product = product;
        return this;
    }

    /**
     * Returns the author of the review.
     *
     * @return {@link #user}
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the author of the review.
     *
     * @param user Author of the review.
     * @return Current instance of {@link Review}.
     */
    public Review setUser(User user) {
        this.user = user;
        return this;
    }

    /**
     * Returns the content of the review.
     *
     * @return {@link #details}
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the content of the review.
     *
     * @param details Content of the review.
     * @return Current instance of {@link Review}.
     */
    public Review setDetails(String details) {
        this.details = details;
        return this;
    }

    /**
     * Returns the numerical rating of the review.
     *
     * @return {@link #stars}
     */
    public int getStars() {
        return stars;
    }

    /**
     * Sets the rating of the review.
     *
     * It must be between 1 and 5.
     *
     * @param stars Numerical rating of the review.
     * @return Current instance of {@link Review}.
     */
    public Review setStars(int stars) {
        if (stars < 1 || stars > 5) {
            throw new IllegalArgumentException("Stars must be between 1 and 5");
        }
        this.stars = stars;
        return this;
    }

    /**
     * Returns the date when the review was created.
     *
     * @return {@link #publishDate}
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * Sets the date when the review was created.
     * @param publishDate Date when the review was created.
     * @return Current instance of {@link Review}.
     */
    public Review setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        return id.equals(review.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
