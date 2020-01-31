package hu.szte.vizz.service.cart;

import hu.szte.vizz.model.product.ProductDTO;

import java.util.Map;

public interface CartService {
    void addProductToCart(ProductDTO productDTO);
    void removeProductFromCart(ProductDTO productDTO);
    Map<ProductDTO, Integer> listProducts();
}
