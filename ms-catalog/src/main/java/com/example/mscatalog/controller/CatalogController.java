package com.example.mscatalog.controller;

import com.example.mscatalog.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final ICatalogService catalogService;

    @Autowired
    public CatalogController(ICatalogService catalogService) {
        this.catalogService=catalogService;
    }

    @GetMapping
    public ResponseEntity<?> getCatalog(){

        return  ResponseEntity.ok(catalogService.getCatalog());
    }
}
