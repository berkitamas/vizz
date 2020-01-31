package hu.szte.vizz.persistence.entity.user;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Represents a location entity of a {@link User}.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "title"})
})
public class Location {
    /**
     * Identifier of the location.
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
     * Related user of the location.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    /**
     * Title of the location.
     *
     * Title must be unique for each user.
     */
    @Column(name = "title")
    private String title;

    /**
     * Zip address of the location.
     */
    @Column(nullable = false)
    private String zip;

    /**
     * City of the location.
     */
    @Column(nullable = false)
    private String city;

    /**
     * Street of the location.
     */
    @Column(nullable = false)
    private String street;

    /**
     * Address of the location.
     */
    @Column(nullable = false)
    private String address;

    /**
     * Toggles the default state of the location.
     *
     * The default location will be the selected location in the dropdown list.
     */
    @Column(name = "isDefault")
    private boolean isDefault = false;

    /**
     * Default constructor of the {@link Location}.
     *
     * It is needed because of the JPA.
     */
    public Location() {
    }

    /**
     * Constructor of the {@link Location} with a specified {@link User}.
     *
     * @param user {@link #user}
     */
    public Location(User user) {
        this.user = user;
    }

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
     * @return Current instance of {@link Location}.
     */
    public Location setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the related user of the location.
     *
     * @return {@link #user}
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the related user of the location.
     *
     * @param user Related user of the location.
     * @return Current instance of {@link Location}.
     */
    public Location setUser(User user) {
        this.user = user;
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
     * @return Current instance of {@link Location}.
     */
    public Location setTitle(String title) {
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
     * @return Current instance of {@link Location}.
     */
    public Location setZip(String zip) {
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
     * @return Current instance of {@link Location}.
     */
    public Location setCity(String city) {
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
     * @return Current instance of {@link Location}.
     */
    public Location setStreet(String street) {
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
     * @return Current instance of {@link Location}.
     */
    public Location setAddress(String address) {
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
     * @return Current instance of {@link Location}.
     */
    public Location setDefault(boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        return id.equals(location.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
