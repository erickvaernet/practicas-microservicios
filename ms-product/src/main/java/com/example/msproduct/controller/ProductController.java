package com.example.msproduct.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<List<String>> getProducts(){
        return ResponseEntity.ok(List.of("Television","Banana","Orange","Pickle","Radio"));
    }
}
