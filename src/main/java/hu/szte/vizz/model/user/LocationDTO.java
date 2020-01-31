package hu.szte.vizz.model.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Represents a location.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public class LocationDTO {
    /**
     * Identifier of the location.
     */
    private UUID id;

    /**
     * ID of the related user.
     */
    private UUID userId;

    /**
     * Title of the location.
     */
    @NotNull
    @Size(min = 3, max = 64)
    private String title;

    /**
     * Zip address of the location.
     */
    @NotNull
    @Size(max = 16)
    private String zip;

    /**
     * City of the location.
     */
    @NotNull
    @Size(max = 64)
    private String city;

    /**
     * Street of the location.
     */
    @NotNull
    @Size(max = 64)
    private String street;

    /**
     * Address of the location.
     */
    @NotNull
    @Size(max = 32)
    private String address;

    /**
     * Toggles the default state of the location.
     */
    private boolean isDefault;

    /**
     * Returns the identifier of the location.
     *
     * @return {@link #id}
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the identifier of the location.
     *
     * @param id Identifier of the location.
     * @return Current instance of {@link LocationDTO}.
     */
    public LocationDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the ID of the related user.
     *
     * @return {@link #userId}
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the related user.
     *
     * @param userId Related user of the location.
     * @return Current instance of {@link LocationDTO}.
     */
    public LocationDTO setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Returns the title of the location.
     *
     * @return {@link #title}
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the location.
     *
     * @param title Title of the location.
     * @return Current instance of {@link LocationDTO}.
     */
    public LocationDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Returns the zip address of the location.
     *
     * @return {@link #zip}
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the zip address of the location.
     *
     * @param zip Zip address of the location.
     * @return Current instance of {@link LocationDTO}.
     */
    public LocationDTO setZip(String zip) {
        this.zip = zip;
        return this;
    }

    /**
     * Returns the city of the location.
     *
     * @return {@link #city}
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the location.
     *
     * @param city City of the location.
     * @return Current instance of {@link LocationDTO}.
     */
    public LocationDTO setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Returns the street of the location.
     *
     * @return {@link #street}
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street of the location.
     *
     * @param street street of the location.
     * @return Current instance of {@link LocationDTO}.
     */
    public LocationDTO setStreet(String street) {
        this.street = street;
        return this;
    }

    /**
     * Returns the address of the location.
     *
     * @return {@link #address}
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the location.
     *
     * @param address Address of the location.
     * @return Current instance of {@link LocationDTO}.
     */
    public LocationDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Returns the default state of the location.
     *
     * @return {@link #isDefault}
     */
    public boolean isDefault() {
        return isDefault;
    }

    /**
     * Sets the default state of the location.
     *
     * @see #isDefault
     *
     * @param isDefault Default state of the location.
     * @return Current instance of {@link LocationDTO}.
     */
    public LocationDTO setDefault(boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationDTO that = (LocationDTO) o;

        if (isDefault != that.isDefault) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (!title.equals(that.title)) return false;
        if (!zip.equals(that.zip)) return false;
        if (!city.equals(that.city)) return false;
        if (!street.equals(that.street)) return false;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + title.hashCode();
        result = 31 * result + zip.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + (isDefault ? 1 : 0);
        return result;
    }
}
