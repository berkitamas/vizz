package hu.szte.vizz.event;

import hu.szte.vizz.model.user.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class OnRegistrationCompleteEventUnitTest {

    @Test
    public void When_getUser_Expect_correctUserReturned() {
        UserDTO user = new UserDTO()
                .setId(UUID.randomUUID());
        OnRegistrationCompleteEvent event = new OnRegistrationCompleteEvent(user);
        assertEquals(user, event.getUser());
    }

    @Test
    public void When_setUser_Expect_correctUserSetted() {
        UserDTO user1 = new UserDTO()
                .setId(UUID.randomUUID());
        UserDTO user2 = new UserDTO()
                .setId(UUID.randomUUID());
        OnRegistrationCompleteEvent event = new OnRegistrationCompleteEvent(user2);
        assertNotEquals(user1, event.getUser());
        event.setUser(user1);
        assertEquals(user1, event.getUser());
    }
}