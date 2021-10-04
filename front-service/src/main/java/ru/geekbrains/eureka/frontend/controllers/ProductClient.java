package ru.geekbrains.eureka.frontend.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.domain.dtos.ProductDto;

import java.util.List;

@FeignClient("gateway-service/products-service")
public interface ProductClient {

    @GetMapping("/products")
    List<ProductDto> findAll();

    @GetMapping("/products/{id}")
    ProductDto findById(@PathVariable Long id);

    @PostMapping("/products")
    ProductDto save(@RequestBody ProductDto productDto);

    @PutMapping("/products")
    void updateProduct(@RequestBody ProductDto productDto);

    @DeleteMapping("/products/{id}")
    ResponseEntity delete(@PathVariable Long id);
}
