package hu.szte.vizz.model.product;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

/**
 * Represents a review entity for ta rpoduct.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public class ReviewDTO {
    /**
     * Identifier of the review.
     */
    private UUID id;

    /**
     * ID of the product where the review is in.
     */
    private UUID productId;

    /**
     * ID of the author.
     */
    private UUID userId;

    /**
     * Content of the review.
     */
    @NotNull
    @Size(max = 65535)
    private String details;

    /**
     * Numerical rating of the review.
     */
    @Min(1)
    @Max(5)
    @NotNull
    private int stars;

    /**
     * Date when the review was created.
     */
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
     * @return Current instance of {@link ReviewDTO}.
     */
    public ReviewDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the ID of the product where the review is in.
     *
     * @return {@link #productId}
     */
    public UUID getProductId() {
        return productId;
    }

    /**
     * Sets the ID of the product where the review is in.
     *
     * @param productId ID of the product where the review is in.
     * @return Current instance of {@link ReviewDTO}.
     */
    public ReviewDTO setProductId(UUID productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Returns the ID of the author.
     *
     * @return {@link #userId}
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the author.
     *
     * @param userId ID of the author.
     * @return Current instance of {@link ReviewDTO}.
     */
    public ReviewDTO setUserId(UUID userId) {
        this.userId = userId;
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
     * @return Current instance of {@link ReviewDTO}.
     */
    public ReviewDTO setDetails(String details) {
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
     * @return Current instance of {@link ReviewDTO}.
     */
    public ReviewDTO setStars(int stars) {
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
     * @return Current instance of {@link ReviewDTO}.
     */
    public ReviewDTO setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewDTO reviewDTO = (ReviewDTO) o;

        if (stars != reviewDTO.stars) return false;
        if (id != null ? !id.equals(reviewDTO.id) : reviewDTO.id != null) return false;
        if (productId != null ? !productId.equals(reviewDTO.productId) : reviewDTO.productId != null) return false;
        if (userId != null ? !userId.equals(reviewDTO.userId) : reviewDTO.userId != null) return false;
        if (!details.equals(reviewDTO.details)) return false;
        return publishDate != null ? publishDate.equals(reviewDTO.publishDate) : reviewDTO.publishDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + details.hashCode();
        result = 31 * result + stars;
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        return result;
    }
}
