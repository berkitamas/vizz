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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private ReviewRepository reviewRepository;

    @Autowired
    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, ReviewRepository reviewRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Collection<CategoryDTO> listCategories() {
        return categoryRepository.findAll().stream().map(category -> new CategoryDTO()
                .setId(category.getId())
                .setName(category.getName())).collect(Collectors.toList());
    }

    @Override
    public Page<ProductDTO> listProductsByCategory(UUID categoryId, int page, int size, boolean desc, String field) throws IllegalArgumentException, CategoryNotFoundException {
        if (size > 50) {
            throw new IllegalArgumentException("Size must be maximum of 50");
        }

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(CategoryNotFoundException::new);

        Sort.Direction direction = (desc) ? Sort.Direction.DESC : Sort.Direction.ASC;

        return productRepository.findAllByCategory(category, PageRequest.of(page, size, Sort.by(direction, field))).map(ProductServiceImpl::fromProductEntity);
    }

    @Override
    public ProductDTO getProductById(UUID id) throws ProductNotFoundException {
       return productRepository.findById(id).map(ProductServiceImpl::fromProductEntity)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public String getProductDetailsById(UUID id) throws ProductNotFoundException {
        return productRepository.findById(id).map(Product::getDetails)
                .orElseThrow(ProductNotFoundException::new);
    }

    static ProductDTO fromProductEntity(Product product) {
        BigDecimal gross = (new BigDecimal(BigInteger.ZERO))
                .add(product.getPriceNet())
                .multiply(
                        BigDecimal.valueOf(product.getVat())
                                .divide(BigDecimal.valueOf(100), 100, BigDecimal.ROUND_CEILING)
                                .add(BigDecimal.ONE)
                );
        gross = gross.setScale(2, RoundingMode.CEILING);
        return new ProductDTO()
                .setId(product.getId())
                .setCategoryId(product.getCategory().getId())
                .setName(product.getName())
                .setPictureUrl(product.getPictureUrl())
                .setPriceNet(product.getPriceNet().toPlainString())
                .setVat(product.getVat())
                .setPriceGross(gross.toPlainString());
    }

}
