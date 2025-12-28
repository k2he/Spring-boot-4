package com.example.springboot4.service;

import com.example.springboot4.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@NullMarked
@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
  private final ProductRestClientService productRestClientService;

  public @Nullable Product getProductByIdV1(int id) {
    log.info("Fetching product (V1) with id: {}", id);
    var product = productRestClientService.getProduct(id);
    if (product == null) {
      return null;
    }
    return Product.builder().name(product.getName()).id(product.getId()).build();
  }

  public @Nullable Product getProductByIdV2(int id) {
    log.info("Fetching product (V2) with id: {}", id);
    return productRestClientService.getProduct(id);
  }
}
