package hu.szte.vizz.model.product;

import hu.szte.vizz.persistence.entity.product.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Represents a product.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public class ProductDTO {
    /**
     * Identifier of the product.
     */
    private UUID id;

    /**
     * Category ID of the product.
     *
     * @see Category
     */
    private UUID categoryId;

    /**
     * Name of the product.
     */
    @NotNull
    @Size(min = 3, max = 64)
    private String name;

    /**
     * Picture URL of the product.
     */
    private String pictureUrl;

    /**
     * Net price of the product.
     */
    @NotNull
    private String priceNet;

    /**
     * VAT (Value Added Tax) of the product.
     *
     * It is in percent format.
     */
    @NotNull
    @Min(0)
    private int vat;

    /**
     * Gross price of the product.
     */
    private String priceGross;

    /**
     * Details of the product.
     *
     * It is in HTML format.
     */
    @Size(max = 65535)
    private String details;

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
     * @return Current instance of {@link ProductDTO}.
     */
    public ProductDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the category ID of the product.
     *
     * @return {@link #categoryId}
     */
    public UUID getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the category ID of the product.
     *
     * @param categoryId Category ID of the product.
     * @return Current instance of {@link ProductDTO}.
     */
    public ProductDTO setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
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
     * @return Current instance of {@link ProductDTO}.
     */
    public ProductDTO setName(String name) {
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
     * @return Current instance of {@link ProductDTO}.
     */
    public ProductDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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
     * @param priceNet Net price of the product.
     * @return Current instance of {@link ProductDTO}.
     */
    public ProductDTO setPriceNet(String priceNet) {
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
     * @return Current instance of {@link ProductDTO}.
     */
    public ProductDTO setVat(int vat) {
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
     * @return Current instance of {@link ProductDTO}.
     */
    public ProductDTO setPriceGross(String priceGross) {
        this.priceGross = priceGross;
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
     * @return Current instance of {@link ProductDTO}.
     */
    public ProductDTO setDetails(String details) {
        this.details = details;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDTO that = (ProductDTO) o;

        if (vat != that.vat) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (!name.equals(that.name)) return false;
        if (pictureUrl != null ? !pictureUrl.equals(that.pictureUrl) : that.pictureUrl != null) return false;
        if (!priceNet.equals(that.priceNet)) return false;
        if (priceGross != null ? !priceGross.equals(that.priceGross) : that.priceGross != null) return false;
        return details != null ? details.equals(that.details) : that.details == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + name.hashCode();
        result = 31 * result + (pictureUrl != null ? pictureUrl.hashCode() : 0);
        result = 31 * result + priceNet.hashCode();
        result = 31 * result + vat;
        result = 31 * result + (priceGross != null ? priceGross.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }
}
