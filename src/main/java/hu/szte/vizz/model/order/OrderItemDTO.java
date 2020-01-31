package hu.szte.vizz.model.order;

import java.util.UUID;

/**
 * Represents an order item.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public class OrderItemDTO {
    /**
     * ID of the related product.
     */
    private UUID productId;

    /**
     * Name of the product.
     */
    private String name;

    /**
     * Quantity of the product.
     */
    private int quantity;

    /**
     * Net price of the product.
     */
    private String priceNet;

    /**
     * VAT (Value Added Tax) of the product.
     *
     * It is in percent format.
     */
    private int vat;

    /**
     * Gross price of the product.
     */
    private String priceGross;

    /**
     * Returns the ID of the related product.
     *
     * @return {@link #productId}
     */
    public UUID getProductId() {
        return productId;
    }

    /**
     * Sets the ID of the related product.
     *
     * @param productId ID of the related product.
     * @return Current instance of {@link OrderItemDTO}.
     */
    public OrderItemDTO setProductId(UUID productId) {
        this.productId = productId;
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
     * @param name Name of the product.
     * @return Current instance of {@link OrderItemDTO}.
     */
    public OrderItemDTO setName(String name) {
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
     * @return Current instance of {@link OrderItemDTO}.
     */
    public OrderItemDTO setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Returns the net price of the product.
     *
     * @return {@link #priceNet}
     */
    public String getPriceNet() {
        return priceNet;
    }

    /**
     * Sets the net price of the product.
     *
     * @param priceNet Net price of the product.
     * @return Current instance of {@link OrderItemDTO}.
     */
    public OrderItemDTO setPriceNet(String priceNet) {
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
     * @return Current instance of {@link OrderItemDTO}.
     */
    public OrderItemDTO setVat(int vat) {
        this.vat = vat;
        return this;
    }

    /**
     * Returns the gross price of the product.
     *
     * @return {@link #priceGross}
     */
    public String getPriceGross() {
        return priceGross;
    }

    /**
     * Sets the gross price of the product.
     *
     * @param priceGross Gross price of the product.
     * @return Current instance of {@link OrderItemDTO}.
     */
    public OrderItemDTO setPriceGross(String priceGross) {
        this.priceGross = priceGross;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemDTO that = (OrderItemDTO) o;

        if (quantity != that.quantity) return false;
        if (vat != that.vat) return false;
        if (!productId.equals(that.productId)) return false;
        if (!name.equals(that.name)) return false;
        if (!priceNet.equals(that.priceNet)) return false;
        return priceGross.equals(that.priceGross);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + priceNet.hashCode();
        result = 31 * result + vat;
        result = 31 * result + priceGross.hashCode();
        return result;
    }
}
