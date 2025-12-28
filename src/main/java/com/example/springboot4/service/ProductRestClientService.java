package com.example.springboot4.service;

import com.example.springboot4.model.Product;
import java.util.List;
import org.jspecify.annotations.Nullable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url="https://api.restful-api.dev", accept = "application/json")
public interface ProductRestClientService {

    @GetExchange("/objects")
    List<Product> getAllProducts();

    @GetExchange("/objects/{productId}")
    @Nullable Product getProduct(@PathVariable int productId);
}
