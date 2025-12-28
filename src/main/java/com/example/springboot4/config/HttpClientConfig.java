package com.example.springboot4.config;

import com.example.springboot4.service.ProductRestClientService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration(proxyBeanMethods = false)
@ImportHttpServices(ProductRestClientService.class)
public class HttpClientConfig {}
