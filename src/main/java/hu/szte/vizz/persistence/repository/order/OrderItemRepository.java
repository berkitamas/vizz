package hu.szte.vizz.persistence.repository.order;

import hu.szte.vizz.persistence.entity.order.Order;
import hu.szte.vizz.persistence.entity.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

/**
 * The repository for {@link OrderItem}.
 *
 * @see <a href="https://docs.spring.io/spring-data/data-commons/docs/current/reference/html/#repositories">Spring Data Repositories</a>
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
    /**
     * Finds all items of an order.
     *
     * @param order The order where the items are
     * @return All items of the order
     */
    Collection<OrderItem> findAllByOrder(Order order);
}
