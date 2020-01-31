package hu.szte.vizz.persistence.entity.user;

import hu.szte.vizz.persistence.entity.order.Order;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

/**
 * Represents a user entity.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Entity
public class User {
    /**
     * Identifier of the user.
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
     * Username of the user.
     */
    @Column(unique = true, nullable = false)
    private String username;

    /**
     * E-mail address of the user.
     */
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * Password of the user.
     *
     * It must be hashed.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Toggles the state of the email activation.
     *
     * If true, then the user can log in.
     */
    private boolean activated = false;

    /**
     * First name of the user.
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * Last name of the user.
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * Phone number of the user.
     *
     * This must be numeric.
     */
    private String phone;

    /**
     * Toggles the administrator state of user.
     */
    private boolean admin = false;

    /**
     * All locations of the user.
     */
    @OneToMany(orphanRemoval = true)
    private Collection<Location> locations;

    /**
     * All orders of the user.
     */
    @OneToMany
    private Collection<Order> orders;

    /**
     * Returns the identifier of the user.
     *
     * @return {@link #id}
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the identifier of the user.
     *
     * @param id Identifier of the user.
     * @return Current instance of {@link User}.
     */
    public User setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the username of the user.
     *
     * @return {@link #username}
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username Username of the user.
     * @return Current instance of {@link User}.
     */
    public User setUsername(String username) {
        this.username = username.toLowerCase();
        return this;
    }

    /**
     * Returns the e-mail address of the user.
     *
     * @return {@link #email}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the e-mail address of the user.
     *
     * @param email E-mail address of the user.
     * @return Current instance of {@link User}.
     */
    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Returns the password of the user.
     *
     * @return {@link #password}
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password Password of the user.
     * @return Current instance of {@link User}.
     */
    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Returns the state of the email activation.
     *
     * @return {@link #activated}
     */
    public boolean isActivated() {
        return activated;
    }

    /**
     * Sets the state of the email activation.
     *
     * @param activated The state of the email activation. If true then the user is activated.
     * @return Current instance of {@link User}.
     */
    public User setActivated(boolean activated) {
        this.activated = activated;
        return this;
    }

    /**
     * Returns the first name of the user.
     *
     * @return {@link #firstName}
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName First name of the user.
     * @return Current instance of {@link User}.
     */
    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Returns the last name of the user.
     *
     * @return {@link #lastName}
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName Last name of the user.
     * @return Current instance of {@link User}.
     */
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Returns the phone number of the user.
     *
     * @return {@link #phone}
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phone Phone number of the user.
     * @return Current instance of {@link User}.
     */
    public User setPhone(String phone) {
        this.phone = phone.replaceAll("[^\\d]", "");
        return this;
    }

    /**
     * Returns the administrator state of user.
     *
     * @return {@link #admin}
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Sets the administrator state of user.
     *
     * @param admin Administrator state of user. If true then the user is admin.
     * @return Current instance of {@link User}.
     */
    public User setAdmin(boolean admin) {
        this.admin = admin;
        return this;
    }

    /**
     * Returns all locations of the user.
     *
     * @return {@link #locations}
     */
    public Collection <Location> getLocations() {
        return locations;
    }

    /**
     * Sets all locations of the user.
     *
     * @param locations Locations of the user.
     * @return Current instance of {@link User}.
     */
    public User setLocations(Collection <Location> locations) {
        this.locations = locations;
        return this;
    }

    /**
     * Returns all orders of the user.
     *
     * @return {@link #orders}
     */
    public Collection <Order> getOrders() {
        return orders;
    }

    /**
     * Sets all orders of the user.
     *
     * @param orders Orders of the user.
     * @return Current instance of {@link User}.
     */
    public User setOrders(Collection <Order> orders) {
        this.orders = orders;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
