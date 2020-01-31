package hu.szte.vizz.persistence.repository.order;

import hu.szte.vizz.persistence.entity.order.Order;
import hu.szte.vizz.model.order.OrderStatus;
import hu.szte.vizz.persistence.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

/**
 * The repository for {@link Order}.
 *
 * @see <a href="https://docs.spring.io/spring-data/data-commons/docs/current/reference/html/#repositories">Spring Data Repositories</a>
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    /**
     * Finds all order by a user.
     *
     * @param user Creator of the orders.
     * @param pageable Paging and sorting information.
     * @return Page of orders.
     */
    Page<Order> findAllByUser(User user, Pageable pageable);

    /**
     * Finds all order by a given status.
     *
     * @param status Status of the orders.
     * @param pageable Paging and sorting information.
     * @return Page of orders.
     */
    Page<Order> findAllByOrderStatus(OrderStatus status, Pageable pageable);

    /**
     * Finds all orders within a date interval.
     *
     * @param from Lower boundary of interval.
     * @param to Upper boundary of interval.
     * @param pageable Paging and sorting information.
     * @return Page of orders.
     */
    Page<Order> findAllByOrderDateBetween(Date from, Date to, Pageable pageable);

    /**
     * Finds all orders of a user within a date interval.
     *
     * @param user Creator of the orders.
     * @param from Lower boundary of interval.
     * @param to Upper boundary of interval.
     * @param pageable Paging and sorting information.
     * @return Page of orders.
     */
    Page<Order> findAllByUserAndOrderDateBetween(User user, Date from, Date to, Pageable pageable);
}
