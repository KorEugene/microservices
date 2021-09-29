package ru.geekbrains.eureka.client.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.domain.dtos.ProductDto;
import ru.geekbrains.eureka.client.entities.Product;
import ru.geekbrains.eureka.client.exceptions.ResourceNotFoundException;
import ru.geekbrains.eureka.client.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll().stream().map(p -> new ProductDto(p.getId(), p.getTitle(), p.getPrice())).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " not found"));
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Product result = productService.save(product);
        return new ProductDto(result.getId(), result.getTitle(), result.getPrice());
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProductFromDto(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
