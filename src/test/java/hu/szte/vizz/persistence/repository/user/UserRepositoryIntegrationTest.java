package hu.szte.vizz.persistence.repository.user;

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

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private User user1, user2, user3;

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
        user3 = new User()
                .setUsername("jane1")
                .setEmail("janedoe@email.com")
                .setPassword(BCrypt.hashpw("Sup3rS4fe", BCrypt.gensalt()))
                .setFirstName("Jane")
                .setLastName("Doe")
                .setAdmin(true);

        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.flush();
    }

    @Test
    public void When_findByUsername_Expect_returnsCorrectUser() {
        User user = userRepository.findByUsername(user1.getUsername())
                .orElseThrow(RuntimeException::new);

        assertEquals(user1.getId(), user.getId());
    }

    @Test
    public void When_findByEmail_Expect_returnsCorrectUser() {
        User user = userRepository.findByEmail(user2.getEmail())
                .orElseThrow(RuntimeException::new);

        assertEquals(user2.getId(), user.getId());
    }

    @Test
    public void When_findAllAdmin_Expect_returnsCorrectUsers() {
        Collection<User> admins = userRepository.findAllAdmin(PageRequest.of(0,5)).getContent();
        Collection<User> expectAdmins = new ArrayList <>();
        expectAdmins.add(user3);
        expectAdmins.add(user2);
        assertTrue(expectAdmins.containsAll(admins) && admins.containsAll(expectAdmins));
    }
}