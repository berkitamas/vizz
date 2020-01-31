package hu.szte.vizz.persistence.repository.order;

import hu.szte.vizz.persistence.entity.order.Order;
import hu.szte.vizz.model.order.OrderStatus;
import hu.szte.vizz.model.order.PaymentMethod;
import hu.szte.vizz.persistence.entity.user.Location;
import hu.szte.vizz.persistence.entity.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    private User user1, user2;

    private Order order1, order2, order3, order4, order5;

    private Location location1, location2, location3, location4, location5;

    @Before
    public void setUp() {
        user1 = new User()
                .setUsername("alex1")
                .setEmail("alex1@email.com")
                .setPassword(BCrypt.hashpw("passw0rd", BCrypt.gensalt()))
                .setFirstName("Alex")
                .setLastName("Doe");
        user2 = new User()
                .setUsername("eva1")
                .setEmail("eva1@email.com")
                .setPassword(BCrypt.hashpw("M0nkey!", BCrypt.gensalt()))
                .setFirstName("Eva")
                .setLastName("Doe")
                .setAdmin(true);
        entityManager.persist(user1);
        entityManager.persist(user2);
        location1 = new Location()
                .setTitle("Home")
                .setZip("6722")
                .setCity("Szeged")
                .setStreet("Kis utca")
                .setAddress("5/B")
                .setUser(user1)
                .setDefault(true);
        location2 = new Location()
                .setTitle("Work")
                .setZip("1010")
                .setCity("Budapest")
                .setStreet("Nagy utca")
                .setAddress("3")
                .setUser(user1);
        location3 = new Location()
                .setTitle("Home")
                .setZip("2301")
                .setCity("Biharnekeresd")
                .setStreet("Fő utca")
                .setAddress("10/B B. épület 4. lépcsőház 6. emelet. 3. ajtó.")
                .setUser(user2)
                .setDefault(true);
        location4 = new Location()
                .setTitle("Work")
                .setZip("4123")
                .setCity("Biharkettőnekeresd")
                .setStreet("Bim utca")
                .setAddress("64")
                .setUser(user2);
        location5 = new Location()
                .setTitle("Grandma")
                .setZip("2301")
                .setCity("Biharnekeresd")
                .setStreet("Bam utca")
                .setAddress("522")
                .setUser(user2);
        entityManager.persist(location1);
        entityManager.persist(location2);
        entityManager.persist(location3);
        entityManager.persist(location4);
        entityManager.persist(location5);
        order1 = new Order()
                .setUser(user1)
                .setIpAddress("192.168.1.1")
                .setName(user1.getFirstName() + " " + user1.getLastName())
                .setSum(BigDecimal.valueOf(1000))
                .setPaymentMethod(PaymentMethod.COD)
                .setZip(location1.getZip())
                .setCity(location1.getCity())
                .setStreet(location1.getStreet())
                .setAddress(location1.getAddress())
                .setOrderDate(new Date());
        order2 = new Order()
                .setUser(user1)
                .setIpAddress("192.168.1.2")
                .setName(user1.getFirstName() + " " + user1.getLastName())
                .setSum(BigDecimal.valueOf(5000))
                .setOrderStatus(OrderStatus.AWAITING_PAYMENT)
                .setPaymentMethod(PaymentMethod.WIRE_TRANSFER)
                .setZip(location2.getZip())
                .setCity(location2.getCity())
                .setStreet(location2.getStreet())
                .setAddress(location2.getAddress())
                .setOrderDate(Date.from(LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC)));
        order3 = new Order()
                .setUser(user2)
                .setIpAddress("192.168.1.3")
                .setName(user2.getFirstName() + " " + user2.getLastName())
                .setSum(BigDecimal.valueOf(1000))
                .setPaymentMethod(PaymentMethod.COD)
                .setZip(location3.getZip())
                .setCity(location3.getCity())
                .setStreet(location3.getStreet())
                .setAddress(location3.getAddress())
                .setOrderDate(new Date());
        order4 = new Order()
                .setUser(user2)
                .setIpAddress("192.168.1.4")
                .setName(user2.getFirstName() + " " + user2.getLastName())
                .setSum(BigDecimal.valueOf(1000))
                .setOrderStatus(OrderStatus.AWAITING_PAYMENT)
                .setPaymentMethod(PaymentMethod.WIRE_TRANSFER)
                .setZip(location4.getZip())
                .setCity(location4.getCity())
                .setStreet(location4.getStreet())
                .setAddress(location4.getAddress())
                .setOrderDate(Date.from(LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC)));
        order5 = new Order()
                .setUser(user2)
                .setIpAddress("192.168.1.5")
                .setName(user2.getFirstName() + " " + user2.getLastName())
                .setSum(BigDecimal.valueOf(1000))
                .setOrderStatus(OrderStatus.AWAITING_SHIPMENT)
                .setPaymentMethod(PaymentMethod.COD)
                .setZip(location5.getZip())
                .setCity(location5.getCity())
                .setStreet(location5.getStreet())
                .setAddress(location5.getAddress())
                .setOrderDate(new Date());
        entityManager.persist(order1);
        entityManager.persist(order2);
        entityManager.persist(order3);
        entityManager.persist(order4);
        entityManager.persist(order5);
        entityManager.flush();
    }

    @Test
    public void When_findAllByUser_Expect_filteredOrders() {
        Collection<Order> expectedOrders = new ArrayList <>();
        expectedOrders.add(order1);
        expectedOrders.add(order2);
        Collection<Order> currentOrders = orderRepository.findAllByUser(user1, PageRequest.of(0,5)).getContent();

        assertTrue(expectedOrders.containsAll(currentOrders) && currentOrders.containsAll(expectedOrders));
    }

    @Test
    public void When_findAllByOrderStatus_Expect_filteredOrders() {
        Collection<Order> expectedOrders = new ArrayList <>();
        expectedOrders.add(order1);
        expectedOrders.add(order3);
        Collection<Order> currentOrders = orderRepository.findAllByOrderStatus(OrderStatus.PENDING, PageRequest.of(0,5)).getContent();

        assertTrue(expectedOrders.containsAll(currentOrders) && currentOrders.containsAll(expectedOrders));
    }

    @Test
    public void When_findAllByOrderDateBetween_Expect_filteredOrders() {
        Collection<Order> expectedOrders = new ArrayList <>();
        expectedOrders.add(order2);
        expectedOrders.add(order4);
        Collection<Order> currentOrders = orderRepository.findAllByOrderDateBetween(
                Date.from(
                        order2.getOrderDate()
                                .toInstant()
                                .atZone(ZoneId.of("UTC"))
                                .toLocalDateTime()
                                .minusHours(1)
                                .toInstant(ZoneOffset.UTC)
                ),
                Date.from(
                        order2.getOrderDate()
                                .toInstant()
                                .atZone(ZoneId.of("UTC"))
                                .toLocalDateTime()
                                .plusHours(1)
                                .toInstant(ZoneOffset.UTC)
                ),
                PageRequest.of(0, 5)
        ).getContent();

        assertTrue(expectedOrders.containsAll(currentOrders) && currentOrders.containsAll(expectedOrders));
    }

    @Test
    public void When_findAllByUserAndOrderDateBetween_Expect_filteredOrders() {
        Collection<Order> expectedOrders = new ArrayList <>();
        expectedOrders.add(order2);
        Collection<Order> currentOrders = orderRepository.findAllByUserAndOrderDateBetween(
                order2.getUser(),
                Date.from(
                        order2.getOrderDate()
                                .toInstant()
                                .atZone(ZoneId.of("UTC"))
                                .toLocalDateTime()
                                .minusHours(1)
                                .toInstant(ZoneOffset.UTC)
                ),
                Date.from(
                        order2.getOrderDate()
                                .toInstant()
                                .atZone(ZoneId.of("UTC"))
                                .toLocalDateTime()
                                .plusHours(1)
                                .toInstant(ZoneOffset.UTC)
                ),
                PageRequest.of(0, 5)
        ).getContent();

        assertTrue(expectedOrders.containsAll(currentOrders) && currentOrders.containsAll(expectedOrders));

    }
}