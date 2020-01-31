package hu.szte.vizz.model.user;

import java.util.UUID;

/**
 * Represents a user.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public class UserDTO {
    /**
     * Identifier of the user.
     */
    private UUID id;

    /**
     * Username of the user.
     */
    private String username;

    /**
     * E-mail address of the user.
     */
    private String email;

    /**
     * First name of the user.
     */
    private String firstName;

    /**
     * Last name of the user.
     */
    private String lastName;

    /**
     * Phone number of the user.
     */
    private String phone;

    /**
     * Toggles the administrator state of user.
     */
    private boolean admin;

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
     * @return Current instance of {@link UserDTO}.
     */
    public UserDTO setId(UUID id) {
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
     * @return Current instance of {@link UserDTO}.
     */
    public UserDTO setUsername(String username) {
        this.username = username;
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
     * @return Current instance of {@link UserDTO}.
     */
    public UserDTO setEmail(String email) {
        this.email = email;
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
     * @return Current instance of {@link UserDTO}.
     */
    public UserDTO setFirstName(String firstName) {
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
     * @return Current instance of {@link UserDTO}.
     */
    public UserDTO setLastName(String lastName) {
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
     * @return Current instance of {@link UserDTO}.
     */
    public UserDTO setPhone(String phone) {
        this.phone = phone;
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
     * @return Current instance of {@link UserDTO}.
     */
    public UserDTO setAdmin(boolean admin) {
        this.admin = admin;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (admin != userDTO.admin) return false;
        if (!id.equals(userDTO.id)) return false;
        if (!username.equals(userDTO.username)) return false;
        if (!email.equals(userDTO.email)) return false;
        if (!firstName.equals(userDTO.firstName)) return false;
        if (!lastName.equals(userDTO.lastName)) return false;
        return phone != null ? phone.equals(userDTO.phone) : userDTO.phone == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (admin ? 1 : 0);
        return result;
    }
}
