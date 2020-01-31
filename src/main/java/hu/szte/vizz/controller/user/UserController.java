package hu.szte.vizz.controller.user;

import hu.szte.vizz.exception.UserExistsException;
import hu.szte.vizz.model.user.RegisterDTO;
import hu.szte.vizz.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    // User registration
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView setupRegisterUser(){
        return new ModelAndView("register", "user", new RegisterDTO());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("user") RegisterDTO user) throws UserExistsException {

            userService.registerUser(user);

        return new ModelAndView("login");
    }

}