package hu.szte.vizz.model.user;


import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents the registration form output.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public class RegisterDTO {
    /**
     * Username of the user.
     */
    @NotNull
    @Size(min = 3, max = 32)
    private String username;

    /**
     * Password of the user.
     */
    @NotNull
    @Size(min = 6)
    private String password;

    /**
     * Password again.
     */
    private String passwordAgain;

    /**
     * E-mail address of the user.
     */
    @NotNull
    @Email
    private String email;

    /**
     * First name of the user.
     */
    @NotNull
    @Size(max = 64)
    private String firstName;

    /**
     * Last name of the user.
     */
    @NotNull
    @Size(max = 64)
    private String lastName;

    /**
     * Phone number of the user.
     */
    @Size(max = 16)
    private String phone;

    /**
     * Zip address of the default location.
     */
    @NotNull
    @Size(max = 16)
    private String zip;

    /**
     * City of the default location.
     */
    @NotNull
    @Size(max = 64)
    private String city;

    /**
     * Street of the default location.
     */
    @NotNull
    @Size(max = 64)
    private String street;

    /**
     * Address of the default location.
     */
    @NotNull
    @Size(max = 32)
    private String address;

    /**
     * Returns true if the passwords are matched.
     *
     * @return True if the passwords are matched.
     */
    @AssertTrue
    boolean passwordsMatch() {
        return password.equals(passwordAgain);
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
     * @return Current instance of {@link RegisterDTO}.
     */
    public RegisterDTO setUsername(String username) {
        this.username = username;
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
     * @return Current instance of {@link RegisterDTO}.
     */
    public RegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Returns the confirmation password of the user.
     *
     * @return {@link #password}
     */
    public String getPasswordAgain() {
        return passwordAgain;
    }

    /**
     * Sets the confirmation password of the user.
     *
     * @param passwordAgain Confirmation password of the user.
     * @return Current instance of {@link RegisterDTO}.
     */
    public RegisterDTO setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
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
     * @return Current instance of {@link RegisterDTO}.
     */
    public RegisterDTO setEmail(String email) {
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
     * @return Current instance of {@link RegisterDTO}.
     */
    public RegisterDTO setFirstName(String firstName) {
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
     * @return Current instance of {@link RegisterDTO}.
     */
    public RegisterDTO setLastName(String lastName) {
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
     * @return Current instance of {@link RegisterDTO}.
     */
    public RegisterDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Returns the zip address of the default location.
     *
     * @return {@link #zip}
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the zip address of the default location.
     *
     * @param zip Zip address of the location.
     * @return Current instance of {@link RegisterDTO}.
     */
    public RegisterDTO setZip(String zip) {
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
     * @return Current instance of {@link RegisterDTO}.
     */
    public RegisterDTO setCity(String city) {
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
     * @return Current instance of {@link RegisterDTO}.
     */
    public RegisterDTO setStreet(String street) {
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
     * @return Current instance of {@link RegisterDTO}.
     */
    public RegisterDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegisterDTO that = (RegisterDTO) o;

        if (!username.equals(that.username)) return false;
        if (!password.equals(that.password)) return false;
        if (!passwordAgain.equals(that.passwordAgain)) return false;
        if (!email.equals(that.email)) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (!zip.equals(that.zip)) return false;
        if (!city.equals(that.city)) return false;
        if (!street.equals(that.street)) return false;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + passwordAgain.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + zip.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }
}
