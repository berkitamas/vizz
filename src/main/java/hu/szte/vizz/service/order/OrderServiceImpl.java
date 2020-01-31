package hu.szte.vizz.service.order;

import hu.szte.vizz.exception.OrderNotFoundException;
import hu.szte.vizz.model.order.OrderDTO;
import hu.szte.vizz.model.order.OrderItemDTO;
import hu.szte.vizz.persistence.entity.order.Order;
import hu.szte.vizz.persistence.repository.order.OrderItemRepository;
import hu.szte.vizz.persistence.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    private OrderItemRepository orderItemRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Collection <OrderItemDTO> listAllItemsOfOrder(OrderDTO orderDTO) {
        Order order = orderRepository.findById(orderDTO.getId())
                .orElseThrow(OrderNotFoundException::new);
        return orderItemRepository.findAllByOrder(order).stream().map((item) -> {
            BigDecimal gross = (new BigDecimal(BigInteger.ZERO))
                    .add(item.getPriceNet())
                    .multiply(
                            BigDecimal.valueOf(item.getVat())
                                    .divide(BigDecimal.valueOf(100), 100, BigDecimal.ROUND_CEILING)
                                    .add(BigDecimal.ONE)
                    )
                    .multiply(BigDecimal.valueOf(item.getQuantity()));
            gross = gross.setScale(2, RoundingMode.CEILING);
            return new OrderItemDTO()
                    .setName(item.getName())
                    .setProductId(item.getProduct().getId())
                    .setQuantity(item.getQuantity())
                    .setPriceNet(item.getPriceNet().toPlainString())
                    .setVat(item.getVat())
                    .setPriceGross(gross.toPlainString());

        })
        .collect(Collectors.toList());
    }
}
