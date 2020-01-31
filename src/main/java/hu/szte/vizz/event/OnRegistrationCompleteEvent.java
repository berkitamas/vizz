package hu.szte.vizz.event;

import hu.szte.vizz.model.user.UserDTO;
import org.springframework.context.ApplicationEvent;

/**
 * This is an event object for registration completion
 * This object contains the registered user
 * {@link hu.szte.vizz.event.listener.RegistrationListener} listens for this event.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 *
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent {
    /**
     * Parameters of the registered user.
     */
    private UserDTO user;

    /**
     * Constructor of the event with the registered user.
     *
     * @param user Parameters of the registered user.
     */
    public OnRegistrationCompleteEvent(UserDTO user) {
        super(user);
        this.user = user;
    }

    /**
     * Returns the parameters of the registered user.
     *
     * @return {@link #user}
     */
    public UserDTO getUser() {
        return user;
    }

    /**
     * Sets the parameters of the registered user.
     *
     * @param user Parameters of the registered user
     * @return Current instance of {@link OnRegistrationCompleteEvent}
     */
    public OnRegistrationCompleteEvent setUser(UserDTO user) {
        this.user = user;
        return this;
    }
}
