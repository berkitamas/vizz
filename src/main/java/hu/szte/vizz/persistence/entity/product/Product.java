package hu.szte.vizz.persistence.entity.product;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

/**
 * Represents a product entity.
 *
 * Product can be any type of cloth.
 * Every product has a category.
 * It has a name, a photo (optional), price, vat, and some details (also optional).
 *
 * Users can put these product into {@link hu.szte.vizz.model.cart.Cart} with a quantity.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 *
 */
@Entity
public class Product {
    /**
     * Identifier of the product.
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
     * Category of the product
     *
     * @see Category
     */
    @ManyToOne
    private Category category;

    /**
     * Name of the product.
     * It must be unique and it is a required field.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Picture URL of the product.
     */
    private String pictureUrl;

    /**
     * Net price of the product.
     *
     * Gross price is always calculated from this and {@link #vat}.
     */
    @Column(nullable = false)
    private BigDecimal priceNet;

    /**
     * VAT (Value Added Tax) of the product.
     *
     * It is in percent format.
     */
    @Column(nullable = false)
    private int vat;

    /**
     * Details of the product.
     *
     * It is in HTML format. It can be maximum of 65536 characters.
     */
    @Column(columnDefinition = "TEXT")
    @Lob
    private String details;

    /**
     * Toggles the visibility of the product.
     *
     * If this is true, the product will show in the search.
     */
    private boolean active;

    /**
     * Reviews of the product.
     *
     * @see Review
     */
    @OneToMany
    private Collection<Review> reviews;

    /**
     * Returns the identifier of the product.
     *
     * @return {@link #id}
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the identifier of the product.
     *
     * @param id Identifier of the product.
     * @return Current instance of {@link Product}.
     */
    public Product setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the category of the product.
     *
     * @return {@link #category}
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     *
     * @param category The {@link Category} of the product.
     * @return Current instance of {@link Product}.
     */
    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    /**
     * Returns the name of the product.
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name of the product.
     * @return Current instance of {@link Product}.
     */
    public Product setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Returns the picture URL of the product.
     *
     * @return {@link #pictureUrl}
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * Sets the picture URL of the product.
     *
     * @param pictureUrl URL of the picture. (HTTP format)
     * @return Current instance of {@link Product}.
     */
    public Product setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    /**
     * Returns the net price of the product.
     *
     * @return {@link #priceNet}
     */
    public BigDecimal getPriceNet() {
        return priceNet;
    }

    /**
     * Sets the net price of the product.
     * @param priceNet Net price of the product ({@link BigDecimal} format).
     * @return Current instance of {@link Product}.
     */
    public Product setPriceNet(BigDecimal priceNet) {
        this.priceNet = priceNet;
        return this;
    }

    /**
     * Returns the VAT (Value Added Tax) of the product.
     *
     * @return {@link #vat}
     */
    public int getVat() {
        return vat;
    }

    /**
     * Sets the VAT (Value Added Tax) of the product.
     *
     * @param vat VAT (Value Added Tax) of the product (percentage).
     * @return Current instance of {@link Product}.
     */
    public Product setVat(int vat) {
        this.vat = vat;
        return this;
    }

    /**
     * Returns the details of the product.
     *
     * @return {@link #details}
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the details of the product.
     * @param details The details of the product (HTML format).
     * @return Current instance of {@link Product}.
     */
    public Product setDetails(String details) {
        this.details = details;
        return this;
    }

    /**
     * Returns the state of the product.
     *
     * @return {@link #active}
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the state of the product.
     * @param active State of the product. See: {@link #active}
     * @return Current instance of {@link Product}.
     */
    public Product setActive(boolean active) {
        this.active = active;
        return this;
    }

    /**
     * Returns the reviews of the product.
     * @return Collection of {@link Review}.
     */
    public Collection <Review> getReviews() {
        return reviews;
    }

    /**
     * Sets the reviews of the product.
     *
     * @param reviews Reviews of the product.
     * @return Current instance of {@link Product}.
     */
    public Product setReviews(Collection <Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
