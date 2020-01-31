package hu.szte.vizz.persistence.repository.product;

import hu.szte.vizz.persistence.entity.product.Product;
import hu.szte.vizz.persistence.entity.product.Review;
import hu.szte.vizz.persistence.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

/**
 * The repository for {@link Review}.
 *
 * @see <a href="https://docs.spring.io/spring-data/data-commons/docs/current/reference/html/#repositories">Spring Data Repositories</a>
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
    /**
     * Finds all reviews for a product in a date interval.
     *
     * @param product Product of the reviews.
     * @param from Lower boundary of interval.
     * @param to Upper boundary of interval.
     * @param pageable Paging and sorting information.
     * @return Page of reviews.
     */
    Page<Review> findAllByProductAndPublishDateBetween(Product product, Date from, Date to, Pageable pageable);

    /**
     * Finds all reviews for a product.
     *
     * @param product Product of the reviews.
     * @param pageable Paging and sorting information.
     * @return Page of reviews.
     */
    Page<Review> findAllByProduct(Product product, Pageable pageable);

    /**
     * Finds all reviews written by a specified user.
     *
     * @param user Author of the reviews.
     * @param pageable Paging and sorting information.
     * @return Page of reviews.
     */
    Page<Review> findAllByUser(User user, Pageable pageable);
}
