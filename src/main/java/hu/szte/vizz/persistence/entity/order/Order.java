package hu.szte.vizz.persistence.entity.order;

import hu.szte.vizz.model.order.OrderStatus;
import hu.szte.vizz.model.order.PaymentMethod;
import hu.szte.vizz.persistence.entity.user.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Represents an order entity.
 *
 * The order must be preserved and readable, even if the user or product becomes unreachable.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Entity
@Table(name = "orders") // Order is a function in MySQL
public class Order {
    /**
     * Identifier of the order.
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
     * Customer of the order.
     *
     * @see User
     */
    @ManyToOne(optional = false)
    private User user;

    /**
     * IP address of the customer.
     *
     * The IP address when the order was placed. It is in dot-decimal notation.
     */
    @Column(nullable = false)
    private String ipAddress;

    /**
     * Name of the customer.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Total amount of gross price of the items.
     *
     * It is needed because of redundancy.
     */
    @Column(nullable = false)
    private BigDecimal sum;

    /**
     * Method of the payment.
     *
     * @see PaymentMethod
     */
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    /**
     * Status of the order.
     *
     * Default value is {@link OrderStatus#PENDING}.
     *
     * @see OrderStatus
     */
    @Column(nullable = false)
    private OrderStatus orderStatus = OrderStatus.PENDING;

    /**
     * Zip of the billing/shipping address.
     */
    @Column(nullable = false)
    private String zip;

    /**
     * City of the billing/shipping address.
     */
    @Column(nullable = false)
    private String city;

    /**
     * Street of the billing/shipping address.
     */
    @Column(nullable = false)
    private String street;

    /**
     * Address of the billing/shipping address.
     */
    @Column(nullable = false)
    private String address;

    /**
     * Date when the order was placed.
     */
    @Column(nullable = false)
    private Date orderDate;

    /**
     * Items of the order.
     *
     * @see OrderItem
     */
    @OneToMany(orphanRemoval = true)
    private Collection<OrderItem> orderItems;

    /**
     * Default constructor of the {@link Order}.
     *
     * It is needed because of the JPA.
     */
    public Order() {
    }

    /**
     * Constructor of the {@link Order} with a specified {@link User}.
     *
     * @param user {@link #user}
     */
    public Order(User user) {
        this.user = user;
    }

    /**
     * Returns the identifier of the {@link Order}.
     *
     * @return {@link #id}
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the identifier of the {@link Order}.
     *
     * @param id Identifier of the {@link Order}.
     * @return Current instance of {@link Order}
     */
    public Order setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the customer of the {@link Order}.
     *
     * @return {@link #user}
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the customer of the {@link Order}.
     *
     * @param user Customer of the {@link Order}.
     * @return Current instance of {@link Order}
     */
    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    /**
     * Returns the IP address of the {@link User}.
     *
     * @return {@link #ipAddress}
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Sets the IP address of the {@link User}.
     *
     * @param ipAddress IP address of the user (Dot-decimal notation).
     * @return Current instance of {@link Order}
     * @throws IllegalArgumentException if the IP address has invalid format
     */
    public Order setIpAddress(String ipAddress) {
        boolean matches = Pattern.compile(
                "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$")
                .matcher(ipAddress).matches();
        if (!matches) {
            throw new IllegalArgumentException("Input must be IP Address (Dot-decimal notation)");
        }
        this.ipAddress = ipAddress;
        return this;
    }

    /**
     * Return the name of the customer.
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name Name of the customer (First Name first).
     * @return Current instance of {@link Order}.
     */
    public Order setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Returns the gross price summary of the order.
     *
     * @return {@link #sum}
     */
    public BigDecimal getSum() {
        return sum;
    }

    /**
     * Sets the gross price summary of the order.
     *
     * @param sum Gross price summary of the order.
     * @return Current instance of {@link Order}.
     */
    public Order setSum(BigDecimal sum) {
        this.sum = sum;
        return this;
    }

    /**
     * Returns the payment method of the order.
     *
     * @return {@link #paymentMethod}
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method of the order.
     *
     * @param paymentMethod Payment method of the order.
     * @return Current instance of {@link Order}.
     */
    public Order setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    /**
     * Returns the status of the order.
     *
     * @return {@link #orderStatus}
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the status of the order.
     *
     * @param orderStatus Status of the order.
     * @return Current instance of {@link Order}.
     */
    public Order setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    /**
     * Returns the zip address of the billing/shipping address.
     *
     * @return {@link #zip}
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the zip address of the billing/shipping address.
     *
     * @param zip Zip address of the billing/shipping address.
     * @return Current instance of {@link Order}.
     */
    public Order setZip(String zip) {
        this.zip = zip;
        return this;
    }

    /**
     * Returns the city of the billing/shipping address.
     *
     * @return {@link #city}
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the billing/shipping address.
     *
     * @param city City of the billing/shipping address.
     * @return Current instance of {@link Order}.
     */
    public Order setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Returns the street of the billing/shipping address.
     *
     * @return {@link #street}
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street of the billing/shipping address.
     *
     * @param street Street of the billing/shipping address.
     * @return Current instance of {@link Order}.
     */
    public Order setStreet(String street) {
        this.street = street;
        return this;
    }

    /**
     * Returns the address of the billing/shipping address.
     *
     * @return {@link #address}
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the billing/shipping address.
     *
     * @param address Address of the billing/shipping address.
     * @return Current instance of {@link Order}.
     */
    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Returns the date when the order was placed.
     *
     * @return {@link #orderDate}
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the date when the order was placed.
     *
     * @param orderDate Date when the order was placed.
     * @return Current instance of {@link Order}.
     */
    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    /**
     * Returns the items of the order.
     *
     * @return {@link #orderItems}
     */
    public Collection <OrderItem> getOrderItems() {
        return orderItems;
    }

    /**
     * Sets the items of the order.
     *
     * @param orderItems Items of the order.
     * @return Current instance of {@link Order}.
     */
    public Order setOrderItems(Collection <OrderItem> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
