package ru.geekbrains.eureka.client.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.domain.dtos.ProductDto;

import java.util.List;

@RestController
@RequestMapping("/front")
@RequiredArgsConstructor
public class FrontController {
    private final ProductClient productClient;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productClient.findAll();
    }
}
