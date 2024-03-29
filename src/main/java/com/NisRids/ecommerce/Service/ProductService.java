package com.NisRids.ecommerce.Service;

import com.NisRids.ecommerce.dto.ProductDto;
import com.NisRids.ecommerce.exceptions.ProductNotExistException;
import com.NisRids.ecommerce.model.Category;
import com.NisRids.ecommerce.model.Product;
import com.NisRids.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public void addProduct(ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        productRepository.save(product);
    }

    public static Product getProductFromDto(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageURL());
        product.setPrice((product.getPrice()));
        product.setName(productDto.getName());
        return product;
    }

    public List<ProductDto> listProducts() {
        // first fetch all the products
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for(Product product : products) {
            // for each product change it to DTO
            productDtos.add(new ProductDto(product));
        }
        return productDtos;
    }


    public void updateProduct(Long productID, ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto,category);
        product.setId(productID);
        productRepository.save(product);
    }

    public Product getProductById(Long productId) throws ProductNotExistException{
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(!optionalProduct.isPresent()) {
            throw new ProductNotExistException("Product id is invalid " + productId);
        }
            return optionalProduct.get();
    }
}
