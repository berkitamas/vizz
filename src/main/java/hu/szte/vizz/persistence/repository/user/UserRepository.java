package hu.szte.vizz.persistence.repository.user;

import hu.szte.vizz.persistence.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * The repository for {@link User}.
 *
 * @see <a href="https://docs.spring.io/spring-data/data-commons/docs/current/reference/html/#repositories">Spring Data Repositories</a>
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    /**
     * Finds user by username.
     *
     * @param username Username of the user.
     * @return One or zero user.
     */
    Optional<User> findByUsername(String username);

    /**
     * Finds user by e-mail address.
     *
     * @param email e-mail address of the user.
     * @return One or zero user.
     */
    Optional<User> findByEmail(String email);

    /**
     * Finds all administrators.
     *
     * @param pageable Paging and sorting information.
     * @return Page of users.
     */
    @Query("SELECT u FROM User u WHERE u.admin = true")
    Page<User> findAllAdmin(Pageable pageable);

}
