package hu.szte.vizz.controller.product;

import hu.szte.vizz.model.product.ProductDTO;
import hu.szte.vizz.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {

    // Listing products by category

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView setupProductPage(Model model)
    {
        model.addAttribute("categories", productService.listCategories());
        return new ModelAndView("products");
    }

    @GetMapping(value = "/products/{category}")
    public String getProducts(
            @PathVariable("category") String categoryIdStr,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "5") int size,
            Model model) {

            Page<ProductDTO> productsPage = productService.listProductsByCategory(UUID.fromString(categoryIdStr), page, size, false, "name");
            Collection<ProductDTO> productsColl = productsPage.getContent();
            model.addAttribute("productCollection", productsColl);
            model.addAttribute("productsPage", productsPage);
            model.addAttribute("categories", productService.listCategories());
            model.addAttribute("categoryIdForPaginate", categoryIdStr);
            model.addAttribute("productNumberOnPage", size);
            int totalPages = productsPage.getTotalPages();
            if(totalPages > -1) {
                List<Integer> pageNumbers = IntStream.rangeClosed(0, totalPages)
                        .boxed()
                        .collect(Collectors.toList());
                model.addAttribute("pageNumbers", pageNumbers);
            }
            return "products";
    }
}
