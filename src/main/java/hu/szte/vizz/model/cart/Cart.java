package hu.szte.vizz.model.cart;

import hu.szte.vizz.persistence.entity.product.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a cart.
 *
 * Every session which invokes the cart mechanism will have one and only one cart.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    /**
     * The collection of the {@link CartItem}s.
     */
    private List<CartItem> cartItems;

    /**
     * Default constructor of the cart.
     */
    public Cart() {
        cartItems = new ArrayList <>();
    }

    /**
     * Retrieves all items of the cart.
     *
     * @return {@link CartItem}
     */
    public List <CartItem> getItems() {
        return cartItems;
    }

    /**
     * Represents a cart item.
     *
     * When users put product into {@link Cart}, a cart item object will be created.
     * It has the {@link Product} and the quantity.
     */
    public class CartItem {
        /**
         * The product in the cart.
         *
         * @see Product
         */
        private Product product;

        /**
         * The quantity of the product (must be greater than 0).
         *
         */
        private int quantity;

        /**
         * Constructor of the cart item with a specified quantity.
         *
         * @param product The product which users put into the {@link Cart}.
         * @param quantity The quantity of the product.
         */
        CartItem(Product product, int quantity) {
            if (quantity < 1) {
                throw new IllegalArgumentException("Quantity must be greater than 0");
            }
            this.product = product;
            this.quantity = quantity;
        }

        /**
         * Constructor of the cart item.
         *
         * @param product The product which users put into the {@link Cart}.
         */
        CartItem(Product product) {
            this.product = product;
            quantity = 1;
        }

        /**
         * Returns the product.
         *
         * @return {@link #product}
         */
        public Product getProduct() {
            return product;
        }

        /**
         * Returns the quantity of the product.
         *
         * @return {@link #quantity}
         */
        public int getQuantity() {
            return quantity;
        }

        /**
         * Sets the quantity of the product.
         * @param quantity Quantity of the product (must be greater than 0).
         * @throws IllegalArgumentException if the quantity is less than 1
         */
        void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CartItem cartItem = (CartItem) o;

            return product.equals(cartItem.product);
        }
    }

    /**
     * Adds product into the cart with a specified quantity.
     * If product is already in the cart, it will increase the quantity by the {@code quantity}.
     *
     * @param product The {@link Product} which will be added.
     * @param quantity The quantity of the product.
     */
    public void addProduct(Product product, int quantity) {
        // If product already exists in the cart then we only modify the quantity
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    /**
     * Adds product into the cart with a specified quantity.
     * If product is already in the cart, it will increase the quantity by one
     *
     * @param product The {@link Product} which will be added.
     */
    public void addProduct(Product product) {
        // If product already exists in the cart then we only modify the quantity
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        cartItems.add(new CartItem(product));
    }

    /**
     * Increases product quantity by one.
     *
     * @param product The {@link Product} which quantity will be increased.
     * @throws IllegalArgumentException if the product is not in the cart
     */
    public void increaseProductQuantity(Product product) {
        int quantity = 0;
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                quantity = item.getQuantity();
            }
        }
        if (quantity == 0) {
            throw new IllegalArgumentException("Product is not in cart");
        }
        updateProductQuantity(product, quantity + 1);
    }

    /**
     * Decreases product quantity by one.
     *
     * @param product The {@link Product} which quantity will be decreased.
     *
     * @throws IllegalArgumentException if the product is not in the cart
     * @throws RuntimeException if the product has quantity of 1 (prevents deletion)
     */
    public void decreaseProductQuantity(Product product) {
        decreaseProductQuantity(product, false);
    }

    /**
     * Decreases product quantity by one.
     *
     * @param product The {@link Product} which quantity will be decreased.
     * @param remove If the product's quantity is 1 and the property is true, then the product will be removed, otherwise throws exception.
     *
     * @throws IllegalArgumentException if the product is not in the cart
     * @throws RuntimeException if the product has quantity of 1 (prevents deletion)
     */
    public void decreaseProductQuantity(Product product, boolean remove) {
        int quantity = 0;
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                quantity = item.getQuantity();
            }
        }
        if (quantity == 0) {
            throw new IllegalArgumentException("Product is not in cart");
        }
        if (quantity == 1) {
            if (remove) {
                removeProduct(product);
            } else {
                throw new RuntimeException("Product has quantity of 1 and remove is not allowed.");
            }
        } else {
            updateProductQuantity(product, quantity - 1);
        }
     }

    /**
     * Updates the product quantity by the specified amount.
     *
     * If the product quantity is less than 1, it will delete the product.
     *
     * @param product The {@link Product} which quantity will be updated.
     * @param quantity The quantity of the updated product.
     *
     * @throws IllegalArgumentException if the product is not in the cart
     */
    public void updateProductQuantity(Product product, int quantity) {
        if (quantity < 1) {
            removeProduct(product);
        } else {
            for (CartItem item : cartItems) {
                if (item.getProduct().equals(product)) {
                    item.setQuantity(quantity);
                    return;
                }
            }
            throw new IllegalArgumentException("Product is not in cart");
        }
    }

    /**
     * Removes the product from the cart.
     *
     * @param product The {@link Product} which will be removed.
     */
    public void removeProduct(Product product) {
        List<CartItem> matches = new ArrayList <>();
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                matches.add(item);
            }
        }
        cartItems.removeAll(matches);
    }
}
