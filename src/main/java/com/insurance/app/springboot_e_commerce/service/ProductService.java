package com.insurance.app.springboot_e_commerce.service;

import com.insurance.app.springboot_e_commerce.entity.Product;
import com.insurance.app.springboot_e_commerce.exception.ProductNotFoundException;
import com.insurance.app.springboot_e_commerce.repository.CategoryRepository;
import com.insurance.app.springboot_e_commerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found"));
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product){
        Product product1 = getProduct(id);
        product1.setDescription(product.getDescription());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());

        return productRepository.save(product1);
    }

    public String deleteProduct(Long id){
        Product product = getProduct(id);
        productRepository.delete(product);

        return "Product deleted";
    }
}
