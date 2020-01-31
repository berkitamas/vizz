package hu.szte.vizz.model.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents the login form output.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public class LoginDTO {
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
     * @return Current instance of {@link LoginDTO}.
     */
    public LoginDTO setUsername(String username) {
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
     * @return Current instance of {@link LoginDTO}.
     */
    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginDTO loginDTO = (LoginDTO) o;

        if (!username.equals(loginDTO.username)) return false;
        return password.equals(loginDTO.password);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
