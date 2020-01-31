package hu.szte.vizz.controller.cart;

import hu.szte.vizz.model.product.ProductDTO;
import hu.szte.vizz.service.cart.CartService;
import hu.szte.vizz.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

//@Scope("sessions")
@Controller
public class CartController {

    @Autowired
    ProductService productService;
    CartService cartService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView setupCartPage()
    {
        return new ModelAndView("cart");
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(HttpSession session, @RequestParam("id") UUID id) {
        ProductDTO product = productService.getProductById(id);
        //cartService.addProductToCart(product);
        session.setAttribute("newCartProduct", product);
        return "products";
    }

    @RequestMapping("/cart")
    public String viewCartItems(HttpSession session, Model model) {
        Map<ProductDTO, Integer> listProducts = cartService.listProducts();
        Collection<ProductDTO> asd2 = listProducts.keySet();
        session.setAttribute("collectionOfProducts", asd2);
        model.addAttribute("cartItems", asd2);
        return "cart";
    }

    @RequestMapping("/removeItemFromCart")
    public String removeCartItem(HttpSession session, @RequestParam("id") UUID id){
        ProductDTO product = productService.getProductById(id);
        //cartService.removeProductFromCart(product);
        session.removeAttribute("newCartProduct");
        return "cart";
    }
}