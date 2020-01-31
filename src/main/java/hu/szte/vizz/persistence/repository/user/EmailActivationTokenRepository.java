package hu.szte.vizz.persistence.repository.user;

import hu.szte.vizz.persistence.entity.user.EmailActivationToken;
import hu.szte.vizz.persistence.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

/**
 * The repository for {@link EmailActivationToken}.
 *
 * @see <a href="https://docs.spring.io/spring-data/data-commons/docs/current/reference/html/#repositories">Spring Data Repositories</a>
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Repository
public interface EmailActivationTokenRepository extends JpaRepository<EmailActivationToken, UUID> {
    /**
     * Checks if the token is active and matched with the user.
     *
     * @param token The token which should be checked
     * @param user The user of the token.
     * @param date The current date.
     * @return Active state of the token (true if active).
     */
    boolean existsByTokenAndUserAndExpiryDateIsAfter(String token, User user, Date date);

    /**
     * Deletes all token of a user.
     *
     * @param user User of the tokens.
     */
    void deleteAllByUser(User user);

    /**
     * Deletes all token before a date.
     *
     * @param date The date until all tokens should be deleted.
     */
    void deleteAllByExpiryDateBefore(Date date);
}
