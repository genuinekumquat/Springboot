package com.example.heo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    private ProductRepository productRepository;
    // DI를 주입받는 방법

    @Autowired // 생성자 통한 스프링빈주입
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String findProduct(int id) {
        return productRepository.findProduct(id);
    }

    public void saveProduct(String productName) {
        productRepository.save(productName); // Repository의 save 호출
    }
}
