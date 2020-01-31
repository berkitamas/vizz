package hu.szte.vizz.model.cart;

import hu.szte.vizz.persistence.entity.product.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CartUnitTest {

    private Product product1;
    private Product product2;

    @Before
    public void setUp() {
        product1 = new Product()
                .setId(UUID.randomUUID())
                .setName("Product1");
        product2 = new Product()
                .setId(UUID.randomUUID())
                .setName("Product2");
    }

    @Test
    public void When_getItems_Expect_returnItems() {
        List<Product> products = new ArrayList <>();
        products.add(product1);
        products.add(product2);
        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);

        List<Product> assertProducts = new ArrayList <>();

        for (Cart.CartItem item : cart.getItems()) {
            assertProducts.add(item.getProduct());
        }

        assertEquals(products, assertProducts);
    }

    @Test
    public void When_addProduct_Expect_productIsInCart() {
        Cart cart = new Cart();
        cart.addProduct(product1);
        assertEquals(product1, cart.getItems().get(0).getProduct());
        assertEquals(1, cart.getItems().get(0).getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void When_addProductWithNegativeQuantity_Expect_exception() {
        Cart cart = new Cart();
        cart.addProduct(product1, -10);
    }

    @Test
    public void When_addProductWithQuantity_Expect_productIsInCartWithQuantity() {
        Cart cart = new Cart();
        cart.addProduct(product1, Integer.MAX_VALUE);
        assertEquals(product1, cart.getItems().get(0).getProduct());
        assertEquals(Integer.MAX_VALUE, cart.getItems().get(0).getQuantity());
    }

    @Test
    public void When_addProductAlreadyIn_Expect_exception() {
        Cart cart = new Cart();
        cart.addProduct(product1, 10);
        assertEquals(10, cart.getItems().get(0).getQuantity());
        assertEquals(product1, cart.getItems().get(0).getProduct());
        cart.addProduct(product1);
        assertEquals(11, cart.getItems().get(0).getQuantity());
        assertEquals(product1, cart.getItems().get(0).getProduct());
        cart.addProduct(product1, 10);
        assertEquals(21, cart.getItems().get(0).getQuantity());
        assertEquals(product1, cart.getItems().get(0).getProduct());
        cart.addProduct(product2, 10);
        assertEquals(21, cart.getItems().get(0).getQuantity());
    }

    @Test
    public void When_increaseProductQuantity_thenProductHasIncreasedQuantity() {
        Cart cart = new Cart();
        cart.addProduct(product1, 10);
        cart.addProduct(product2, 10);
        cart.increaseProductQuantity(product1);
        assertEquals(product1, cart.getItems().get(0).getProduct());
        assertEquals(11, cart.getItems().get(0).getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void When_increaseProductQuantityOfUnknownProduct_Expect_exception() {
        Cart cart = new Cart();
        cart.increaseProductQuantity(product1);
    }


    @Test
    public void When_decreaseProductQuantity_Expect_productQuantityDecreased() {
        Cart cart = new Cart();
        cart.addProduct(product1, 10);
        cart.addProduct(product2);
        cart.decreaseProductQuantity(product1);
        assertEquals(product1, cart.getItems().get(0).getProduct());
        assertEquals(9, cart.getItems().get(0).getQuantity());
        assertEquals(1, cart.getItems().get(1).getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void When_decreaseProductQuantityOfUnknownProduct_Expect_exception() {
        Cart cart = new Cart();
        cart.decreaseProductQuantity(product1);
    }

    @Test(expected = RuntimeException.class)
    public void When_decreaseProductQuantityToZero_Expect_exception() {
        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.decreaseProductQuantity(product1);
    }

    @Test
    public void When_decreaseProductQuantityToZeroWithRemove_Expect_productIsRemoved() {
        Cart cart = new Cart();
        cart.addProduct(product1);
        assertEquals(1, cart.getItems().size());
        cart.decreaseProductQuantity(product1, true);
        assertEquals(0, cart.getItems().size());
    }

    @Test
    public void When_updateProductQuantity_Expect_quantityIsChanged() {
        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertEquals(1, cart.getItems().get(0).getQuantity());
        cart.updateProductQuantity(product1, 10);
        assertEquals(10, cart.getItems().get(0).getQuantity());
        assertEquals(1, cart.getItems().get(1).getQuantity());
    }

    @Test
    public void When_updateProductWithNegativeQuantity_Expect_productIsRemoved() {
        Cart cart = new Cart();
        cart.addProduct(product1);
        assertEquals(1, cart.getItems().size());
        cart.updateProductQuantity(product1, -10);
        assertEquals(0, cart.getItems().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void When_updateProductWithUnknownProduct_Expect_exception() {
        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.updateProductQuantity(product2, 10);
    }

    @Test
    public void When_removeProduct_Expect_productIsRemoved() {
        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertEquals(2, cart.getItems().size());
        cart.removeProduct(product2);
        assertEquals(1, cart.getItems().size());
    }

    @Test
    public void When_cartItemEqualsSame_Expect_equal() {
        Cart cart = new Cart();
        cart.addProduct(product1);

        assertEquals(cart.getItems().get(0), cart.getItems().get(0));
    }

    @Test
    public void When_cartItemEqualsIdentical_Expect_equal() {
        Cart cart1 = new Cart();
        cart1.addProduct(product1);
        Cart cart2 = new Cart();
        cart2.addProduct(product1);

        assertEquals(cart1.getItems().get(0), cart2.getItems().get(0));
    }

    @Test
    public void When_cartItemEqualsDifferent_Expect_different() {
        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertNotEquals(cart.getItems().get(0), cart.getItems().get(1));
    }

    @Test
    public void When_cartItemEqualsDifferentObject_Expect_different() {
        Cart cart = new Cart();
        cart.addProduct(product1);

        assertNotEquals(cart.getItems().get(0), "notitem");
    }

    @Test
    public void When_cartItemEqualsNullObject_Expect_different() {
        Cart cart = new Cart();
        cart.addProduct(product1);

        assertNotEquals(cart.getItems().get(0), null);
    }
}