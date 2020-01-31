package hu.szte.vizz.model.user;

import java.util.UUID;

/**
 * Represents a token.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public class TokenDTO {
    /**
     * The token itself.
     */
    private String token;

    /**
     * ID of the related user.
     */
    private UUID userId;

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
     * @param token The token itself
     * @return Current instance of {@link TokenDTO}.
     */
    public TokenDTO setToken(String token) {
        this.token = token;
        return this;
    }

    /**
     * Returns the token.
     *
     * @return {@link #userId}
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the related user.
     *
     * @param userId ID of the related user.
     * @return Current instance of {@link TokenDTO}.
     */
    public TokenDTO setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokenDTO tokenDTO = (TokenDTO) o;

        if (!token.equals(tokenDTO.token)) return false;
        return userId.equals(tokenDTO.userId);
    }

    @Override
    public int hashCode() {
        int result = token.hashCode();
        result = 31 * result + userId.hashCode();
        return result;
    }
}
