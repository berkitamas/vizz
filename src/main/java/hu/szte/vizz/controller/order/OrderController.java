package hu.szte.vizz.controller.order;

import hu.szte.vizz.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired OrderService orderService;

    @RequestMapping("/orders")
    public String setupOrders (HttpSession session) {
        
        return "orders";
    }
}
