package productServiceSpringBoot.productServiceSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productServiceSpringBoot.productServiceSpringBoot.entity.Products;
import productServiceSpringBoot.productServiceSpringBoot.repository.ProductRepository;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Products createProduct(Products products) {
        products.setCreatedAt(new Date());
        products.setUpdatedAt(new Date());
        return productRepository.save(products);
    }

    public Products updateProduct(String id, Products updatedProduct) {
        Products existingProduct = getProductById(id);
        if (existingProduct != null) {
            updatedProduct.setId(id);
            updatedProduct.setCreatedAt(existingProduct.getCreatedAt());
            updatedProduct.setUpdatedAt(new Date());
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
