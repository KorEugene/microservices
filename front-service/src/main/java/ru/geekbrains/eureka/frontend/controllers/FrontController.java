package ru.geekbrains.eureka.frontend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.domain.dtos.ProductDto;

import java.util.List;

@RestController
@RequestMapping("/front")
@RequiredArgsConstructor
public class FrontController {
    private final ProductClient productClient;

    // GET: http://localhost:8190/front-service/front/
    @GetMapping
    public List<ProductDto> getProducts() {
        return productClient.findAll();
    }

    // GET: http://localhost:8190/front-service/front/1
    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productClient.findById(id);
    }

    // POST: http://localhost:8190/front-service/front/
    /*
    {
    "title": "postman",
    "price": 1000
    }
     */
    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        return productClient.save(productDto);
    }

    // PUT: http://localhost:8190/front-service/front/
    /*
    {
    "id": 1,
    "title": "bread",
    "price": 50
    }
     */
    @PutMapping
    public void updateProduct(@RequestBody ProductDto productDto) {
        productClient.updateProduct(productDto);
    }

    // DELETE: http://localhost:8190/front-service/front/2
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return productClient.delete(id);
    }
}
