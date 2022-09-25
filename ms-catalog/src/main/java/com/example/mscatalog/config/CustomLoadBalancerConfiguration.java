package com.example.mscatalog.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


public class CustomLoadBalancerConfiguration {

    @Bean
    ReactorLoadBalancer<ServiceInstance> RandomLoadBalancer(Environment env, LoadBalancerClientFactory lc){
        String name= env.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return  new RandomLoadBalancer(lc.getProvider(name, ServiceInstanceListSupplier.class),name);

    }
}
