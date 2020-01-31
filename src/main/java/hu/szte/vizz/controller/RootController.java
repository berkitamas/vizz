package hu.szte.vizz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Root controller of the project.
 *
 * This is temporary. Only for show some examples for the frontend team.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Controller
public class RootController {
    /**
     * Name of the application.
     */
    @Value("${spring.application.name}")
    private String appName;

    /**
     * Index page of the project
     *
     * This is temporary
     *
     * @param model {@link Model}
     * @return Template page which will be rendered
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }
}
