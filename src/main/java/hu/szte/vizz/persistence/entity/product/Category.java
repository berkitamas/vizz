package hu.szte.vizz.persistence.entity.product;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

/**
 * Represents the categoryentity  of the products.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Entity
public class Category {
    /**
     * Identifier of the category.
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
     * Name of the category.
     */
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * All products in the category.
     */
    @OneToMany
    private Collection<Product> products;

    /**
     * Returns the identifier of the category.
     *
     * @return {@link #id}
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the identifier of the category.
     *
     * @param id Identifier of the category.
     * @return Current instance of {@link Category}
     */
    public Category setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the name of the category.
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the category.
     *
     * @param name Name of the category.
     * @return Current instance of {@link Category}
     */
    public Category setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Returns all products in the category.
     *
     * @return {@link #products}
     */
    public Collection <Product> getProducts() {
        return products;
    }

    /**
     * Sets all products in the category.
     *
     * @param products All products in the category.
     * @return Current instance of {@link Category}
     */
    public Category setProducts(Collection <Product> products) {
        this.products = products;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return id.equals(category.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
