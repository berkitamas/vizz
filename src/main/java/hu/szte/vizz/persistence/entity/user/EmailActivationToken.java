package hu.szte.vizz.persistence.entity.user;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Represents an email activation token entity of a {@link User}
 *
 * When the user registers to the site, the account's email must be confirmed. The system will create a token for it.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Entity
public class EmailActivationToken {
    /**
     * Identifier of the token.
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
     * Related user of the token.
     */
    @ManyToOne(optional = false)
    private User user;

    /**
     * The token itself.
     */
    @Column(nullable = false)
    private String token;

    /**
     * Expiration date of the token.
     *
     * It will be filled when the user creates an another token.
     */
    @Column(nullable = false)
    private Date expiryDate;

    /**
     * Default constructor of the {@link EmailActivationToken}.
     *
     * It is needed because of the JPA.
     */
    public EmailActivationToken() {
    }

    /**
     * Constructor of the {@link EmailActivationToken} with a specified {@link User}.
     *
     * @param user {@link #user}
     */
    public EmailActivationToken(User user) {
        this.user = user;
    }

    /**
     * Returns the identifier of the token.
     *
     * @return {@link #id}
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the identifier of the token.
     * @param id Identifier of the token.
     * @return Current instance of {@link EmailActivationToken}.
     */
    public EmailActivationToken setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the user of the token.
     *
     * @return {@link #user}
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user of the token.
     *
     * @param user User of the token.
     * @return Current instance of {@link EmailActivationToken}.
     */
    public EmailActivationToken setUser(User user) {
        this.user = user;
        return this;
    }

    /**
     * Returns the token.
     *
     * @return {@link #token}
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     *
     * @param token The token itself.
     * @return Current instance of {@link EmailActivationToken}.
     */
    public EmailActivationToken setToken(String token) {
        this.token = token;
        return this;
    }

    /**
     * Returns the expiration date of the token.
     *
     * @return {@link #expiryDate}
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the expiration date of the token.
     *
     * @param expiryDate Expiration date of the token.
     * @return Current instance of {@link EmailActivationToken}.
     */
    public EmailActivationToken setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailActivationToken that = (EmailActivationToken) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
