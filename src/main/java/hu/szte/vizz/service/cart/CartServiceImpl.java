package hu.szte.vizz.service.cart;

import hu.szte.vizz.exception.ProductNotFoundException;
import hu.szte.vizz.model.cart.Cart;
import hu.szte.vizz.model.product.ProductDTO;
import hu.szte.vizz.persistence.entity.product.Product;
import hu.szte.vizz.persistence.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    private Cart cart;
    private ProductRepository productRepository;

    @Autowired
    public CartServiceImpl(Cart cart, ProductRepository productRepository) {
        this.cart = cart;
        this.productRepository = productRepository;
    }

    @Override
    public void addProductToCart(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId())
                .orElseThrow(ProductNotFoundException::new);
        cart.addProduct(product);
    }

    @Override
    public void removeProductFromCart(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId())
                .orElseThrow(ProductNotFoundException::new);
        cart.removeProduct(product);
    }

    @Override
    public Map<ProductDTO, Integer> listProducts() {
        return cart.getItems().stream().collect(Collectors.toMap(k -> {
            BigDecimal gross = new BigDecimal(BigInteger.ZERO);
            gross = gross.add(k.getProduct().getPriceNet());
            gross = gross.multiply(
                    BigDecimal.valueOf(k.getProduct().getVat())
                            .divide(BigDecimal.valueOf(100), 100, BigDecimal.ROUND_CEILING)
                            .add(BigDecimal.ONE)
            );
            gross = gross.setScale(2, RoundingMode.CEILING);
            return new ProductDTO()
                    .setId(k.getProduct().getId())
                    .setCategoryId(k.getProduct().getCategory().getId())
                    .setName(k.getProduct().getName())
                    .setDetails(k.getProduct().getDetails())
                    .setPictureUrl(k.getProduct().getPictureUrl())
                    .setPriceNet(k.getProduct().getPriceNet().toPlainString())
                    .setPriceGross(gross.toPlainString())
                    .setVat(k.getProduct().getVat());
        }, Cart.CartItem::getQuantity));
    }
}
