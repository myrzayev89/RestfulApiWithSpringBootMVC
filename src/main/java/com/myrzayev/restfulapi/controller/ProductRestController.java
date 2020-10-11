package com.myrzayev.restfulapi.controller;

import com.myrzayev.restfulapi.dto.ResponseDTO;
import com.myrzayev.restfulapi.entity.Product;
import com.myrzayev.restfulapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductRestController {

    @Autowired
    private ProductService prodRepo;

    @GetMapping("/products")
    public ResponseEntity<ResponseDTO> getProducts() {
        List<Product> products = prodRepo.getAllProd();
        return ResponseEntity.ok(ResponseDTO.of(products));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ResponseDTO> getProduct(@PathVariable("id") int id) {
        Product product = prodRepo.getById(id);
        return ResponseEntity.ok(ResponseDTO.of(product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ResponseDTO> deleteProduct(@PathVariable("id") int id) {
        Product product = prodRepo.getById(id);
        prodRepo.delete(id);
        return ResponseEntity.ok(ResponseDTO.of(product,"Successfully deleted"));
    }

    @PostMapping("/product/add")
    public ResponseEntity<ResponseDTO> addProduct(){
        Product product = new Product();
        product.setProdName(product.getProdName());
        product.setSeventeen(product.getSeventeen());
        product.setThirty(product.getThirty());
        product.setFifty(product.getFifty());
        product.setOneHundred(product.getOneHundred());
        prodRepo.save(product);
        return ResponseEntity.ok(ResponseDTO.of(product,"Successfully added"));
    }
}
