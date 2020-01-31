package hu.szte.vizz.persistence.entity.order;

import hu.szte.vizz.persistence.entity.product.Product;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents an item entity in the {@link Order} entity.
 *
 * The order item must be preserved and readable, even if the product becomes unreachable.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"order_id", "product_id"})
})
public class OrderItem {
    /**
     * Identifier of the order item.
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
     * Order where the item is in.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    /**
     * Related product of the order item.
     */
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    /**
     * Name of the product.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Quantity of the product.
     */
    @Column(nullable = false)
    private int quantity;

    /**
     * Net price of the product.
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
     * Default constructor of the {@link OrderItem}.
     *
     * It is needed because of the JPA.
     */
    public OrderItem() { }

    /**
     * Constructor of the {@link OrderItem} with a specified {@link Order} and {@link Product}.
     * @param order Order where the item is in.
     * @param product Related product of the order item.
     */
    public OrderItem(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    /**
     * Returns the identifier of the order item.
     * @return {@link #id}
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the identifier of the order item.
     *
     * @param id Identifier of the order item.
     * @return Current instance of {@link OrderItem}.
     */
    public OrderItem setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the order where the item is in.
     *
     * @return {@link #order}
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order where the item is in.
     *
     * @param order Order where the item is in.
     * @return Current instance of {@link OrderItem}.
     */
    public OrderItem setOrder(Order order) {
        this.order = order;
        return this;
    }

    /**
     * Returns the related product of the order item.
     *
     * @return {@link #product}
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the related product of the order item.
     *
     * @param product Product of the order item.
     * @return Current instance of {@link OrderItem}.
     */
    public OrderItem setProduct(Product product) {
        this.product = product;
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
     * @param name Name of the product. (It should match with {@link Product#name})
     * @return Current instance of {@link OrderItem}.
     */
    public OrderItem setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Returns the quantity of the product.
     *
     * @return {@link #quantity}
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product.
     *
     * @param quantity Quantity of the product.
     * @return Current instance of {@link OrderItem}.
     * @throws IllegalArgumentException if the quantity is lesser than 1.
     */
    public OrderItem setQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        this.quantity = quantity;
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
     *
     * @param priceNet Net price of the product.
     * @return Current instance of {@link OrderItem}.
     */
    public OrderItem setPriceNet(BigDecimal priceNet) {
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
     * @param vat VAT (Value Added Tax) of the product.
     * @return Current instance of {@link OrderItem}.
     * @throws IllegalArgumentException if the vat is negative.
     */
    public OrderItem setVat(int vat) {
        if (vat < 0) {
            throw new IllegalArgumentException("VAT must be positive");
        }
        this.vat = vat;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        return id.equals(orderItem.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
