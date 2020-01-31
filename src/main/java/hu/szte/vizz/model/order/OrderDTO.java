package hu.szte.vizz.model.order;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Represents an order.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public class OrderDTO {
    /**
     * Identifier of the order.
     */
    private UUID id;

    /**
     * ID of the customer.
     *
     * @see hu.szte.vizz.persistence.entity.user.User
     */
    private UUID userId;

    /**
     * IP address of the customer.
     */
    private String ipAddress;

    /**
     * Name of the customer.
     */
    private String name;

    /**
     * Total amount of gross price of the items.
     */
    private String sum;

    /**
     * Method of the payment.
     *
     * @see PaymentMethod
     */
    private PaymentMethod paymentMethod;

    /**
     * Status of the order.
     *
     * @see OrderStatus
     */
    private OrderStatus orderStatus;

    /**
     * Zip of the billing/shipping address.
     */
    private String zip;

    /**
     * City of the billing/shipping address.
     */
    private String city;

    /**
     * Street of the billing/shipping address.
     */
    private String street;

    /**
     * Address of the billing/shipping address.
     */
    private String address;

    /**
     * Date when the order was placed.
     */
    private Date orderDate;

    /**
     * Items of the order.
     */
    private Collection<OrderItemDTO> items;

    /**
     * VAT summary of the order.
     */
    private Map<Integer, String> vatSummary;

    /**
     * Returns the identifier of the order.
     *
     * @return {@link #id}
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the identifier of the order.
     *
     * @param id Identifier of the order.
     * @return Current instance of {@link OrderDTO}
     */
    public OrderDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the ID of the customer.
     *
     * @return {@link #userId}
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the customer.
     *
     * @param userId ID of the customer.
     * @return Current instance of {@link OrderDTO}
     */
    public OrderDTO setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Returns the IP address of the customer.
     *
     * @return {@link #ipAddress}
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Sets the IP address of the user.
     *
     * @param ipAddress IP address of the user.
     * @return Current instance of {@link OrderDTO}
     */
    public OrderDTO setIpAddress(String ipAddress) {
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
     * @param name Name of the customer.
     * @return Current instance of {@link OrderDTO}.
     */
    public OrderDTO setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Returns the gross price summary of the order.
     *
     * @return {@link #sum}
     */
    public String getSum() {
        return sum;
    }

    /**
     * Sets the gross price summary of the order.
     *
     * @param sum Gross price summary of the order.
     * @return Current instance of {@link OrderDTO}.
     */
    public OrderDTO setSum(String sum) {
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
     * @return Current instance of {@link OrderDTO}.
     */
    public OrderDTO setPaymentMethod(PaymentMethod paymentMethod) {
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
     * @return Current instance of {@link OrderDTO}.
     */
    public OrderDTO setOrderStatus(OrderStatus orderStatus) {
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
     * @return Current instance of {@link OrderDTO}.
     */
    public OrderDTO setZip(String zip) {
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
     * @return Current instance of {@link OrderDTO}.
     */
    public OrderDTO setCity(String city) {
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
     * @return Current instance of {@link OrderDTO}.
     */
    public OrderDTO setStreet(String street) {
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
     * @return Current instance of {@link OrderDTO}.
     */
    public OrderDTO setAddress(String address) {
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
     * @return Current instance of {@link OrderDTO}.
     */
    public OrderDTO setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    /**
     * Returns the items of the order.
     *
     * @return {@link #items}
     */
    public Collection <OrderItemDTO> getItems() {
        return items;
    }

    /**
     * Sets the items of the order.
     *
     * @param items Items of the order.
     * @return Current instance of {@link OrderDTO}.
     */
    public OrderDTO setItems(Collection <OrderItemDTO> items) {
        this.items = items;
        return this;
    }

    /**
     * Returns the VAT summary of the order.
     *
     * @return {@link #vatSummary}
     */
    public Map <Integer, String> getVatSummary() {
        return vatSummary;
    }

    /**
     * Sets the VAT summary of the order.
     *
     * @param vatSummary VAT summary of the order.
     * @return Current instance of {@link OrderDTO}.
     */
    public OrderDTO setVatSummary(Map <Integer, String> vatSummary) {
        this.vatSummary = vatSummary;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDTO orderDTO = (OrderDTO) o;

        if (!id.equals(orderDTO.id)) return false;
        if (!userId.equals(orderDTO.userId)) return false;
        if (!ipAddress.equals(orderDTO.ipAddress)) return false;
        if (!name.equals(orderDTO.name)) return false;
        if (!sum.equals(orderDTO.sum)) return false;
        if (paymentMethod != orderDTO.paymentMethod) return false;
        if (orderStatus != orderDTO.orderStatus) return false;
        if (!zip.equals(orderDTO.zip)) return false;
        if (!city.equals(orderDTO.city)) return false;
        if (!street.equals(orderDTO.street)) return false;
        if (!address.equals(orderDTO.address)) return false;
        if (!orderDate.equals(orderDTO.orderDate)) return false;
        if (items != null ? !items.equals(orderDTO.items) : orderDTO.items != null) return false;
        return vatSummary != null ? vatSummary.equals(orderDTO.vatSummary) : orderDTO.vatSummary == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + ipAddress.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + sum.hashCode();
        result = 31 * result + paymentMethod.hashCode();
        result = 31 * result + orderStatus.hashCode();
        result = 31 * result + zip.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + orderDate.hashCode();
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (vatSummary != null ? vatSummary.hashCode() : 0);
        return result;
    }
}
