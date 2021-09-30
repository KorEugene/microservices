package ru.geekbrains.eureka.client.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.geekbrains.domain.dtos.ProductDto;

import java.util.List;

@FeignClient("products-service")
public interface ProductClient {

    @GetMapping("/products")
    List<ProductDto> findAll();

}
