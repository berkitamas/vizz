package hu.szte.vizz.service.order;

import hu.szte.vizz.exception.OrderNotFoundException;
import hu.szte.vizz.model.order.OrderDTO;
import hu.szte.vizz.model.order.OrderItemDTO;
import hu.szte.vizz.model.order.OrderStatus;
import hu.szte.vizz.model.order.PaymentMethod;
import hu.szte.vizz.model.product.CategoryDTO;
import hu.szte.vizz.persistence.entity.order.Order;
import hu.szte.vizz.persistence.entity.order.OrderItem;
import hu.szte.vizz.persistence.entity.product.Category;
import hu.szte.vizz.persistence.entity.product.Product;
import hu.szte.vizz.persistence.entity.user.Location;
import hu.szte.vizz.persistence.entity.user.User;
import hu.szte.vizz.persistence.repository.order.OrderItemRepository;
import hu.szte.vizz.persistence.repository.order.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class OrderServiceImplIntegrationTest {

    @TestConfiguration
    static class OrderServiceImplIntegrationTestContextConfiguration {
        @Autowired
        private OrderRepository orderRepository;

        @Autowired
        private OrderItemRepository orderItemRepository;

        @Bean
        public OrderService orderService() {
            return new OrderServiceImpl(
                    orderRepository,
                    orderItemRepository
            );
        }
    }

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private OrderItemRepository orderItemRepository;

    private Order order1, order2;
    private OrderDTO order1DTO, order2DTO;

    private OrderItem item1, item2, item3, item4, item5;
    private OrderItemDTO itemDTO1, itemDTO2, itemDTO3, itemDTO4, itemDTO5;

    @Before
    public void setUp() {
        User user = new User()
                .setUsername("alex1")
                .setEmail("alex1@email.com")
                .setPassword(BCrypt.hashpw("passw0rd", BCrypt.gensalt()))
                .setFirstName("Alex")
                .setLastName("Doe");
        Location location = new Location()
                .setTitle("Home")
                .setZip("6722")
                .setCity("Szeged")
                .setStreet("Kis utca")
                .setAddress("5/B")
                .setUser(user)
                .setDefault(true);
        Category category = new Category()
                .setId(UUID.randomUUID())
                .setName("Category1");

        Product product1 = new Product()
                .setId(UUID.randomUUID())
                .setName("Awesome product")
                .setCategory(category)
                .setPriceNet(BigDecimal.valueOf(1000))
                .setVat(27)
                .setDetails("Lorem Ipsum Dolor Sit Amet");
        Product product2 = new Product()
                .setId(UUID.randomUUID())
                .setName("Wonderful product")
                .setCategory(category)
                .setPriceNet(BigDecimal.valueOf(10000))
                .setVat(18)
                .setDetails("Another longer text");
        Product product3 = new Product()
                .setId(UUID.randomUUID())
                .setName("New product")
                .setCategory(category)
                .setPriceNet(BigDecimal.valueOf(50000))
                .setVat(5)
                .setDetails("Very long text");
        item1 = new OrderItem()
                .setProduct(product1)
                .setName(product1.getName())
                .setQuantity(3)
                .setPriceNet(product1.getPriceNet())
                .setVat(product1.getVat());
        item2 = new OrderItem()
                .setProduct(product2)
                .setName(product2.getName())
                .setQuantity(4)
                .setPriceNet(product2.getPriceNet())
                .setVat(product2.getVat());
        item3 = new OrderItem()
                .setProduct(product3)
                .setName(product3.getName())
                .setQuantity(1)
                .setPriceNet(product3.getPriceNet())
                .setVat(product3.getVat());
        item4 = new OrderItem()
                .setProduct(product2)
                .setName(product2.getName())
                .setQuantity(10)
                .setPriceNet(product2.getPriceNet())
                .setVat(product2.getVat());
        item5 = new OrderItem()
                .setProduct(product1)
                .setName(product3.getName())
                .setQuantity(1000)
                .setPriceNet(product3.getPriceNet())
                .setVat(product3.getVat());
        BigDecimal item1Gross = new BigDecimal(BigInteger.ZERO);
        BigDecimal item2Gross = new BigDecimal(BigInteger.ZERO);
        BigDecimal item3Gross = new BigDecimal(BigInteger.ZERO);
        BigDecimal item4Gross = new BigDecimal(BigInteger.ZERO);
        BigDecimal item5Gross = new BigDecimal(BigInteger.ZERO);
        item1Gross = item1Gross.add(item1.getPriceNet());
        item1Gross = item1Gross.multiply(
                BigDecimal.valueOf(item1.getVat())
                        .divide(BigDecimal.valueOf(100), 100, BigDecimal.ROUND_CEILING)
                        .add(BigDecimal.ONE)
        );
        item1Gross = item1Gross.multiply(BigDecimal.valueOf(item1.getQuantity()));
        item1Gross = item1Gross.setScale(2, RoundingMode.CEILING);

        item2Gross = item2Gross.add(item2.getPriceNet());
        item2Gross = item2Gross.multiply(
                BigDecimal.valueOf(item2.getVat())
                        .divide(BigDecimal.valueOf(100), 100, BigDecimal.ROUND_CEILING)
                        .add(BigDecimal.ONE)
        );
        item2Gross = item2Gross.multiply(BigDecimal.valueOf(item2.getQuantity()));
        item2Gross = item2Gross.setScale(2, RoundingMode.CEILING);

        item3Gross = item3Gross.add(item3.getPriceNet());
        item3Gross = item3Gross.multiply(
                BigDecimal.valueOf(item3.getVat())
                        .divide(BigDecimal.valueOf(100), 100, BigDecimal.ROUND_CEILING)
                        .add(BigDecimal.ONE)
        );
        item3Gross = item3Gross.multiply(BigDecimal.valueOf(item3.getQuantity()));
        item3Gross = item3Gross.setScale(2, RoundingMode.CEILING);

        item4Gross = item4Gross.add(item4.getPriceNet());
        item4Gross = item4Gross.multiply(
                BigDecimal.valueOf(item4.getVat())
                        .divide(BigDecimal.valueOf(100), 100, BigDecimal.ROUND_CEILING)
                        .add(BigDecimal.ONE)
        );
        item4Gross = item4Gross.multiply(BigDecimal.valueOf(item4.getQuantity()));
        item4Gross = item4Gross.setScale(2, RoundingMode.CEILING);

        item5Gross = item5Gross.add(item5.getPriceNet());
        item5Gross = item5Gross.multiply(
                BigDecimal.valueOf(item5.getVat())
                        .divide(BigDecimal.valueOf(100), 100, BigDecimal.ROUND_CEILING)
                        .add(BigDecimal.ONE)
        );
        item5Gross = item5Gross.multiply(BigDecimal.valueOf(item5.getQuantity()));
        item5Gross = item5Gross.setScale(2, RoundingMode.CEILING);

        itemDTO1 = new OrderItemDTO()
                .setName(item1.getName())
                .setPriceNet(item1.getPriceNet().toPlainString())
                .setVat(item1.getVat())
                .setPriceGross(item1Gross.toPlainString())
                .setQuantity(item1.getQuantity())
                .setProductId(item1.getProduct().getId());
        itemDTO2 = new OrderItemDTO()
                .setName(item2.getName())
                .setPriceNet(item2.getPriceNet().toPlainString())
                .setVat(item2.getVat())
                .setPriceGross(item2Gross.toPlainString())
                .setQuantity(item2.getQuantity())
                .setProductId(item2.getProduct().getId());
        itemDTO3 = new OrderItemDTO()
                .setName(item3.getName())
                .setPriceNet(item3.getPriceNet().toPlainString())
                .setVat(item3.getVat())
                .setPriceGross(item3Gross.toPlainString())
                .setQuantity(item3.getQuantity())
                .setProductId(item3.getProduct().getId());
        itemDTO4 = new OrderItemDTO()
                .setName(item4.getName())
                .setPriceNet(item4.getPriceNet().toPlainString())
                .setVat(item4.getVat())
                .setPriceGross(item4Gross.toPlainString())
                .setQuantity(item4.getQuantity())
                .setProductId(item4.getProduct().getId());
        itemDTO5 = new OrderItemDTO()
                .setName(item5.getName())
                .setPriceNet(item5.getPriceNet().toPlainString())
                .setVat(item5.getVat())
                .setPriceGross(item5Gross.toPlainString())
                .setQuantity(item5.getQuantity())
                .setProductId(item5.getProduct().getId());
        BigDecimal order1Sum = new BigDecimal(BigInteger.ZERO);
        BigDecimal order2Sum = new BigDecimal(BigInteger.ZERO);
        order1Sum = order1Sum.add(item1Gross);
        order1Sum = order1Sum.add(item2Gross);
        order2Sum = order2Sum.add(item3Gross);
        order2Sum = order2Sum.add(item4Gross);
        order2Sum = order2Sum.add(item5Gross);
        order1 = new Order()
                .setId(UUID.randomUUID())
                .setUser(user)
                .setIpAddress("192.168.1.1")
                .setName(user.getFirstName() + " " + user.getLastName())
                .setSum(order1Sum)
                .setPaymentMethod(PaymentMethod.COD)
                .setZip(location.getZip())
                .setCity(location.getCity())
                .setStreet(location.getStreet())
                .setAddress(location.getAddress())
                .setOrderDate(new Date());
        order2 = new Order()
                .setId(UUID.randomUUID())
                .setUser(user)
                .setIpAddress("192.168.1.2")
                .setName(user.getFirstName() + " " + user.getLastName())
                .setSum(order2Sum)
                .setOrderStatus(OrderStatus.AWAITING_PAYMENT)
                .setPaymentMethod(PaymentMethod.WIRE_TRANSFER)
                .setZip(location.getZip())
                .setCity(location.getCity())
                .setStreet(location.getStreet())
                .setAddress(location.getAddress())
                .setOrderDate(Date.from(LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC)));
        item1.setOrder(order1);
        item2.setOrder(order1);
        item3.setOrder(order2);
        item4.setOrder(order2);
        item5.setOrder(order2);
        order1.setOrderItems(Arrays.asList(item1, item2));
        order2.setOrderItems(Arrays.asList(item4, item4, item5));
        Map <Integer, BigDecimal> vatSummary1Price = new HashMap <>();
        Map <Integer, String> vatSummary1 = new HashMap <>();
        vatSummary1Price.put(item1.getVat(), new BigDecimal(BigInteger.ZERO));
        vatSummary1Price.put(item2.getVat(), new BigDecimal(BigInteger.ZERO));
        vatSummary1Price.put(item1.getVat(), vatSummary1Price.get(item1.getVat()).add(item1Gross.subtract(item1.getPriceNet())));
        vatSummary1Price.put(item2.getVat(), vatSummary1Price.get(item2.getVat()).add(item2Gross.subtract(item2.getPriceNet())));
        vatSummary1.put(item1.getVat(), vatSummary1Price.get(item1.getVat()).toPlainString());
        vatSummary1.put(item2.getVat(), vatSummary1Price.get(item2.getVat()).toPlainString());
        Map <Integer, BigDecimal> vatSummary2Price = new HashMap <>();
        Map <Integer, String> vatSummary2 = new HashMap <>();
        vatSummary2Price.put(item3.getVat(), new BigDecimal(BigInteger.ZERO));
        vatSummary2Price.put(item4.getVat(), new BigDecimal(BigInteger.ZERO));
        vatSummary2Price.put(item5.getVat(), new BigDecimal(BigInteger.ZERO));
        vatSummary2Price.put(item3.getVat(), vatSummary2Price.get(item3.getVat()).add(item3Gross.subtract(item3.getPriceNet())));
        vatSummary2Price.put(item4.getVat(), vatSummary2Price.get(item4.getVat()).add(item4Gross.subtract(item4.getPriceNet())));
        vatSummary2Price.put(item5.getVat(), vatSummary2Price.get(item5.getVat()).add(item5Gross.subtract(item5.getPriceNet())));
        vatSummary2.put(item3.getVat(), vatSummary2Price.get(item3.getVat()).toPlainString());
        vatSummary2.put(item4.getVat(), vatSummary2Price.get(item4.getVat()).toPlainString());
        vatSummary2.put(item5.getVat(), vatSummary2Price.get(item5.getVat()).toPlainString());
        order1DTO = new OrderDTO()
                .setId(order1.getId())
                .setOrderDate(order1.getOrderDate())
                .setOrderStatus(order1.getOrderStatus())
                .setIpAddress(order1.getIpAddress())
                .setZip(order1.getZip())
                .setCity(order1.getCity())
                .setStreet(order1.getStreet())
                .setAddress(order1.getAddress())
                .setUserId(order1.getUser().getId())
                .setItems(Arrays.asList(itemDTO1, itemDTO2))
                .setPaymentMethod(order1.getPaymentMethod())
                .setSum(order1.getSum().toPlainString())
                .setVatSummary(vatSummary1);
        order2DTO = new OrderDTO()
                .setId(order2.getId())
                .setOrderDate(order2.getOrderDate())
                .setOrderStatus(order2.getOrderStatus())
                .setIpAddress(order2.getIpAddress())
                .setZip(order2.getZip())
                .setCity(order2.getCity())
                .setStreet(order2.getStreet())
                .setAddress(order2.getAddress())
                .setUserId(order2.getUser().getId())
                .setItems(Arrays.asList(itemDTO3, itemDTO4, itemDTO5))
                .setPaymentMethod(order2.getPaymentMethod())
                .setSum(order2.getSum().toPlainString())
                .setVatSummary(vatSummary2);
        Mockito.when(orderRepository.findById(any())).thenReturn(Optional.empty());
        Mockito.when(orderRepository.findById(order1.getId())).thenReturn(Optional.of(order1));
        Mockito.when(orderRepository.findById(order2.getId())).thenReturn(Optional.of(order2));
        Mockito.when(orderItemRepository.findAllByOrder(any())).thenReturn(Collections.emptyList());
        Mockito.when(orderItemRepository.findAllByOrder(order1)).thenReturn(order1.getOrderItems());
        Mockito.when(orderItemRepository.findAllByOrder(order2)).thenReturn(order2.getOrderItems());
    }

    @Test
    public void When_listAllItemsOfOrder_Expect_CorrectOrderItems() {
        Collection<OrderItemDTO> expected = Arrays.asList(itemDTO1, itemDTO2);
        Collection<OrderItemDTO> actual = orderService.listAllItemsOfOrder(order1DTO);
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

    @Test(expected = OrderNotFoundException.class)
    public void When_listAllItemsOfOrder_Expect_OrderNotFoundException() {
        orderService.listAllItemsOfOrder(new OrderDTO().setId(UUID.randomUUID()));
    }
}