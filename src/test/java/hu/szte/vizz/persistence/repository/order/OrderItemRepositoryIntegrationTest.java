package hu.szte.vizz.persistence.repository.order;

import hu.szte.vizz.persistence.entity.order.Order;
import hu.szte.vizz.persistence.entity.order.OrderItem;
import hu.szte.vizz.model.order.OrderStatus;
import hu.szte.vizz.model.order.PaymentMethod;
import hu.szte.vizz.persistence.entity.product.Category;
import hu.szte.vizz.persistence.entity.product.Product;
import hu.szte.vizz.persistence.entity.user.Location;
import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderItemRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderItemRepository itemRepository;

    private Order order1, order2;

    private OrderItem item1, item2, item3, item4, item5;

    @SuppressWarnings("Duplicates")
    @Before
    public void setUp() {
        User user = new User()
                .setUsername("alex1")
                .setEmail("alex1@email.com")
                .setPassword(BCrypt.hashpw("passw0rd", BCrypt.gensalt()))
                .setFirstName("Alex")
                .setLastName("Doe");
        entityManager.persist(user);
        Location location = new Location()
                .setTitle("Home")
                .setZip("6722")
                .setCity("Szeged")
                .setStreet("Kis utca")
                .setAddress("5/B")
                .setUser(user)
                .setDefault(true);
        entityManager.persist(location);
        Category category = new Category()
                .setName("Category");
        entityManager.persist(category);
        Product product1 = new Product()
                .setName("Awesome product")
                .setCategory(category)
                .setPriceNet(BigDecimal.valueOf(1000))
                .setVat(27)
                .setDetails("Lorem Ipsum Dolor Sit Amet");
        Product product2 = new Product()
                .setName("Wonderful product")
                .setCategory(category)
                .setPriceNet(BigDecimal.valueOf(10000))
                .setVat(18)
                .setDetails("Another longer text");
        Product product3 = new Product()
                .setName("New product")
                .setCategory(category)
                .setPriceNet(BigDecimal.valueOf(50000))
                .setVat(5)
                .setDetails("Very long text");
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.persist(product3);
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
        BigDecimal order1Sum = new BigDecimal(BigInteger.ZERO);
        BigDecimal order2Sum = new BigDecimal(BigInteger.ZERO);
        order1Sum = order1Sum.add(item1.getPriceNet().multiply(BigDecimal.valueOf(item1.getQuantity())));
        order1Sum = order1Sum.add(item2.getPriceNet().multiply(BigDecimal.valueOf(item2.getQuantity())));
        order2Sum = order2Sum.add(item3.getPriceNet().multiply(BigDecimal.valueOf(item3.getQuantity())));
        order2Sum = order2Sum.add(item4.getPriceNet().multiply(BigDecimal.valueOf(item4.getQuantity())));
        order2Sum = order2Sum.add(item5.getPriceNet().multiply(BigDecimal.valueOf(item5.getQuantity())));
        order1 = new Order()
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
        entityManager.persist(order1);
        entityManager.persist(order2);
        item1.setOrder(order1);
        item2.setOrder(order1);
        item3.setOrder(order2);
        item4.setOrder(order2);
        item5.setOrder(order2);
        entityManager.persist(item1);
        entityManager.persist(item2);
        entityManager.persist(item3);
        entityManager.persist(item4);
        entityManager.persist(item5);
        entityManager.flush();
    }

    @Test
    public void When_findAllByOrder_Expect_filteredItems() {
        Collection<OrderItem> expectedItems = new ArrayList <>();
        expectedItems.add(item1);
        expectedItems.add(item2);
        Collection<OrderItem> currentItems = itemRepository.findAllByOrder(order1);

        assertTrue(expectedItems.containsAll(currentItems) && currentItems.containsAll(expectedItems));
    }
}