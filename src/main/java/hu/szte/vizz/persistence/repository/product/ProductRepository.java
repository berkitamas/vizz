package hu.szte.vizz.persistence.repository.product;

import hu.szte.vizz.persistence.entity.product.Category;
import hu.szte.vizz.persistence.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * The repository for {@link Product}.
 *
 * @see <a href="https://docs.spring.io/spring-data/data-commons/docs/current/reference/html/#repositories">Spring Data Repositories</a>
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    /**
     * Finds all products by a category.
     *
     * @param category Category of products.
     * @param pageable Paging and sorting information.
     * @return Page of products.
     */
    Page<Product> findAllByCategory(Category category, Pageable pageable);
}
