package hu.szte.vizz.persistence.repository.product;

import hu.szte.vizz.persistence.entity.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * The repository for {@link Category}.
 *
 * @see <a href="https://docs.spring.io/spring-data/data-commons/docs/current/reference/html/#repositories">Spring Data Repositories</a>
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    /**
     * Finds a category by its name.
     *
     * @param name Name of the category.
     * @return One or zero category.
     */
    Optional<Category> findByName(String name);
}
