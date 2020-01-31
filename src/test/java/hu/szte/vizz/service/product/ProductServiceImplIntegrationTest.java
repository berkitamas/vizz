package hu.szte.vizz.service.product;

import hu.szte.vizz.exception.CategoryNotFoundException;
import hu.szte.vizz.exception.ProductNotFoundException;
import hu.szte.vizz.model.product.CategoryDTO;
import hu.szte.vizz.model.product.ProductDTO;
import hu.szte.vizz.persistence.entity.product.Category;
import hu.szte.vizz.persistence.entity.product.Product;
import hu.szte.vizz.persistence.repository.product.CategoryRepository;
import hu.szte.vizz.persistence.repository.product.ProductRepository;
import hu.szte.vizz.persistence.repository.product.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(SpringRunner.class)
public class ProductServiceImplIntegrationTest {

    @TestConfiguration
    static class ProductServiceImplIntegrationTestContextConfiguration {
        @Autowired
        private CategoryRepository categoryRepository;

        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private ReviewRepository reviewRepository;

        @Bean
        public ProductService productService() {
            return new ProductServiceImpl(
                    categoryRepository,
                    productRepository,
                    reviewRepository
            );
        }
    }

    @Autowired
    private ProductService productService;

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ReviewRepository reviewRepository;

    private Category category1, category2;

    private Product product1, product2, product3;

    private CategoryDTO category1DTO, category2DTO;

    private ProductDTO product1DTO, product2DTO, product3DTO;

    @Before
    public void setUp() {
        category1 = new Category()
                .setId(UUID.randomUUID())
                .setName("Category1");
        category2 = new Category()
                .setId(UUID.randomUUID())
                .setName("Category2");
        category1DTO = new CategoryDTO()
                .setId(category1.getId())
                .setName(category1.getName());
        category2DTO = new CategoryDTO()
                .setId(category2.getId())
                .setName(category2.getName());

        product1 = new Product()
                .setId(UUID.randomUUID())
                .setName("Awesome product")
                .setCategory(category1)
                .setPriceNet(BigDecimal.valueOf(1000))
                .setVat(27)
                .setDetails("Lorem Ipsum Dolor Sit Amet");
        product2 = new Product()
                .setId(UUID.randomUUID())
                .setName("Wonderful product")
                .setCategory(category1)
                .setPriceNet(BigDecimal.valueOf(10000))
                .setVat(18)
                .setDetails("Another longer text");
        product3 = new Product()
                .setId(UUID.randomUUID())
                .setName("New product")
                .setCategory(category2)
                .setPriceNet(BigDecimal.valueOf(50000))
                .setVat(5)
                .setDetails("Very long text");

        product1DTO = ProductServiceImpl.fromProductEntity(product1);
        product2DTO = ProductServiceImpl.fromProductEntity(product2);
        product3DTO = ProductServiceImpl.fromProductEntity(product3);

        Mockito.when(productRepository.findById(any())).thenReturn(Optional.empty());
        Mockito.when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1, category2));
        Mockito.when(categoryRepository.findById(category1.getId())).thenReturn(Optional.of(category1));
        Mockito.when(categoryRepository.findById(category2.getId())).thenReturn(Optional.of(category2));
        Mockito.when(productRepository.findAllByCategory(eq(category1), any(Pageable.class))).thenReturn(new PageImpl <>(Arrays.asList(product1, product2)));
        Mockito.when(productRepository.findAllByCategory(eq(category2), any(Pageable.class))).thenReturn(new PageImpl <>(Collections.singletonList(product3)));
        Mockito.when(productRepository.findById(product1.getId())).thenReturn(Optional.of(product1));
    }

    @Test
    public void When_listCategories_Expect_allCategories() {
        Collection<CategoryDTO> expected = Arrays.asList(category1DTO, category2DTO);
        Collection<CategoryDTO> actual = productService.listCategories();

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void When_listProductsByCategory_Expect_IllegalArgumentException() {
        productService.listProductsByCategory(
                category1.getId(),
                0,
                80,
                false,
                "name"
        );
    }

    @Test(expected = CategoryNotFoundException.class)
    public void When_listProductsByCategory_Expect_CategoryNotFoundException() {
        productService.listProductsByCategory(
                UUID.randomUUID(),
                0,
                10,
                false,
                "name"
        );
    }

    @Test
    public void When_listProductsByCategory_Expect_correctProducts() {
        Collection<ProductDTO> expected = Arrays.asList(product1DTO, product2DTO);
        Collection<ProductDTO> actual = productService.listProductsByCategory(
                category1.getId(),
                0,
                5,
                false,
                "name"
        ).getContent();
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

    @Test
    public void When_listProductsByCategoryDescending_Expect_correctProducts() {
        Collection<ProductDTO> expected = Arrays.asList(product1DTO, product2DTO);
        Collection<ProductDTO> actual = productService.listProductsByCategory(
                category1.getId(),
                0,
                5,
                true,
                "name"
        ).getContent();
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

    @Test(expected = ProductNotFoundException.class)
    public void When_getProductById_Expect_ProductNotFoundException() {
        productService.getProductById(UUID.randomUUID());
    }

    @Test
    public void When_getProductById_Expect_correctProductReturned() {
        ProductDTO expected = product1DTO;
        ProductDTO actual = productService.getProductById(product1.getId());
        assertEquals(expected, actual);
    }

    @Test(expected = ProductNotFoundException.class)
    public void When_getProductDetailsById_Expect_ProductNotFoundException() {
        productService.getProductDetailsById(UUID.randomUUID());
    }

    @Test
    public void When_getProductDetailsById_Expect_correctProductDetails() {
        String expected = product1.getDetails();
        String actual = productService.getProductDetailsById(product1.getId());
        assertEquals(expected, actual);
    }

    @Test
    public void When_fromProductEntity_Expect_correctlyConverted() {
        ProductDTO expected = new ProductDTO()
                .setId(product1.getId())
                .setCategoryId(product1.getCategory().getId())
                .setName(product1.getName())
                .setPictureUrl(product1.getPictureUrl())
                .setPriceNet("1000")
                .setVat(27)
                .setPriceGross("1270.00");
        ProductDTO actual = ProductServiceImpl.fromProductEntity(product1);
        assertEquals(expected, actual);
    }
}