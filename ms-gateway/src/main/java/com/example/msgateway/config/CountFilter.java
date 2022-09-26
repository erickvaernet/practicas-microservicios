package com.example.msgateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Calendar;

@Component
public class CountFilter extends AbstractGatewayFilterFactory<CountFilter.Config> {

    public static Logger loger= LoggerFactory.getLogger(CountFilter.class);

    public CountFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) ->
        {
            loger.info("Request vino de: "+exchange.getRequest().getPath());
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                loger.info("Tiempo respuesta: "+ Calendar.getInstance().getTime());
            }));
        });
    }

    public static class Config{


    }

}
