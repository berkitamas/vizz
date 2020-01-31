package hu.szte.vizz.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import hu.szte.vizz.exception.UserNotFoundException;
import hu.szte.vizz.model.user.LoginDTO;
import hu.szte.vizz.persistence.entity.user.User;
import hu.szte.vizz.persistence.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.UUID;

@Controller
public class LoginController {

    //  User login
    //@RequestMapping(value = "/login")
    //public String login() {
    //    return "login";
    //}
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView setupLoginUser() {
        return new ModelAndView("login", "user", new LoginDTO());
    }

    private Optional<User> userFromDB;
    private User existingUser;

    @RequestMapping(value = "/login/save", method = RequestMethod.POST)
    public String loginUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            @ModelAttribute("user") LoginDTO login) throws UserNotFoundException {

        userFromDB = userRepository.findByUsername(login.getUsername());
        if (userFromDB.isPresent()) {
            existingUser = userFromDB.get();
            UUID usersId = existingUser.getId();
            String usersUsername = existingUser.getUsername();
            String usersEmail = existingUser.getEmail();
            String usersFirst = existingUser.getFirstName();
            String usersLast = existingUser.getLastName();
            String usersPhone = existingUser.getPhone();

            if (login.getUsername().equals(usersUsername)) {
                session.setAttribute("userId", usersId);
                session.setAttribute("username", username);
                session.setAttribute("useremail", usersEmail);
                session.setAttribute("userFirst", usersFirst);
                session.setAttribute("userLast", usersLast);
                session.setAttribute("userPhone", usersPhone);
            }
        } else {
            return "login";
        }
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("userId");
        session.removeAttribute("username");
        session.removeAttribute("useremail");
        session.removeAttribute("userFirst");
        session.removeAttribute("userLast");
        session.removeAttribute("userPhone");

        return "index";
    }
}
