package hu.szte.vizz.service.order;

import hu.szte.vizz.model.order.OrderDTO;
import hu.szte.vizz.model.order.OrderItemDTO;

import java.util.Collection;

/**
 * Service for the order management
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public interface OrderService {
    /**
     * List all items by the given order
     *
     * @param order Order which items should be listed
     * @return All items of the order
     */
    Collection<OrderItemDTO> listAllItemsOfOrder(OrderDTO order);
}
