package hu.szte.vizz.service.product;

import hu.szte.vizz.exception.CategoryNotFoundException;
import hu.szte.vizz.exception.ProductNotFoundException;
import hu.szte.vizz.model.product.CategoryDTO;
import hu.szte.vizz.model.product.ProductDTO;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.UUID;

/**
 * Service for the product management
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public interface ProductService {
    /**
     * Returns the product categories.
     *
     * @return All product categories in a Collection
     */
    Collection<CategoryDTO> listCategories();

    /**
     * Returns some product by the specified category and sorting options.
     *
     * @param categoryId ID of the category of the products.
     * @param page Page number
     * @param size Size of a page
     * @param desc If true then the order will be in descending order
     * @param field Field for the order
     * @return Some product in a page
     * @throws CategoryNotFoundException if category is not found
     * @throws IllegalArgumentException if the size parameter is greater than 50
     */
    Page<ProductDTO> listProductsByCategory(UUID categoryId, int page, int size, boolean desc, String field) throws IllegalArgumentException, CategoryNotFoundException;

    /**
     * Returns a product by a specified ID
     *
     * @param id ID of the product
     * @return Parameters of the product
     * @throws ProductNotFoundException if the product is not found
     */
    ProductDTO getProductById(UUID id) throws ProductNotFoundException;

    /**
     * Returns the details of the product
     *
     * @param id ID of the product
     * @return Details of the product ({@link hu.szte.vizz.persistence.entity.product.Product#details})
     * @throws ProductNotFoundException if the product is not found
     */
    String getProductDetailsById(UUID id) throws ProductNotFoundException;
}
