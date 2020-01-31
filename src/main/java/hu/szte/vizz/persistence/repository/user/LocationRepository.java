package hu.szte.vizz.persistence.repository.user;

import hu.szte.vizz.persistence.entity.user.Location;
import hu.szte.vizz.persistence.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * The repository for {@link Location}.
 *
 * @see <a href="https://docs.spring.io/spring-data/data-commons/docs/current/reference/html/#repositories">Spring Data Repositories</a>
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {
    /**
     * Finds all location by user.
     *
     * @param user User of the locations.
     * @param pageable Paging and sorting information.
     * @return Page of locations.
     */
    Page<Location> findAllByUser(User user, Pageable pageable);

    /**
     * Finds the default location of a user.
     *
     * @param user User of the location.
     * @return One or zero location.
     */
    @Query("SELECT l FROM Location l WHERE l.user = ?1 AND l.isDefault = true")
    Optional<Location> findDefaultByUser(User user);
}
