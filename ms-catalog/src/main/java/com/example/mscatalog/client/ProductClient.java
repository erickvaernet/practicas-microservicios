package com.example.mscatalog.client;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "ms-product")
@LoadBalancerClient(name = "ms-product")
public interface ProductClient {
    @RequestMapping( method = RequestMethod.GET,value = "/products")
    public List<String> getProducts();
}
