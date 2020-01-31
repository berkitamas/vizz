package hu.szte.vizz.event.listener;

import hu.szte.vizz.event.OnRegistrationCompleteEvent;
import hu.szte.vizz.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * This class listens for {@link OnRegistrationCompleteEvent}.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    /**
     * User service object.
     */
    private final UserService userService;

    @Autowired
    public RegistrationListener(UserService userService) {
        this.userService = userService;
    }

    /**
     * When {@link OnRegistrationCompleteEvent} thrown it calls the user service to send an activation email to the user.
     *
     * @param event The event itself
     */
    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        userService.sendActivationMail(event.getUser());
    }

}
