package com.example.mscatalog.service;

import com.example.mscatalog.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CatalogService implements ICatalogService {

    private final ProductClient productClient;

    @Autowired
    public CatalogService(ProductClient productClient) {
        this.productClient = productClient;
    }

    @Override
    public HashMap<String, List<String>> getCatalog() {
        List<String> products= productClient.getProducts();
        HashMap<String,List<String>> catalog =new HashMap<>();
        List<String> electrodomesticos= new ArrayList<>();
        List<String> otros= new ArrayList<>();
        products.stream().forEach((product)->{
            if (product.equalsIgnoreCase("television")) {
                electrodomesticos.add(product);
            } else {
                otros.add(product);
            }
        });

        catalog.put("Electrodomesticos",electrodomesticos);
        catalog.put("Otros",otros);

        return catalog;
    }

}
