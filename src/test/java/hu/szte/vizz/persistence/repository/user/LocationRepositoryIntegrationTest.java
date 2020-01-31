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
public class LocationRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LocationRepository locationRepository;

    private User user1, user2;

    private Location location1, location2, location3, location4, location5;

    @Before
    public void setUp()  {
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
        entityManager.flush();
    }

    @Test
    public void When_findAllByUser_Expect_returnsCorrectLocations() {
        Collection<Location> locations = locationRepository.findAllByUser(user1, PageRequest.of(0,5)).getContent();
        Collection<Location> expectedLocations = new ArrayList <>();
        expectedLocations.add(location1);
        expectedLocations.add(location2);
        assertTrue(locations.containsAll(expectedLocations) && expectedLocations.containsAll(locations));
    }

    @Test
    public void When_findDefaultByUser_Expect_returnsCorrectLocation() {
        Location location = locationRepository.findDefaultByUser(user2).orElse(null);
        assertEquals(location3, location);
    }
}