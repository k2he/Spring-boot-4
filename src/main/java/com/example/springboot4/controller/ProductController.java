package com.example.springboot4.controller;

import com.example.springboot4.model.Product;
import com.example.springboot4.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

  private final ProductService productService;

  /* --------------- API Versioning using Custom Header or Query Parameter -----------------*/
  //    @GetMapping(path = "/product/{id}", version = "1")
  //    public ResponseEntity<Product> getProductV1(@PathVariable int id) {
  //        var product = productService.getProductByIdV1(id);
  //        return ResponseEntity.ok(product);
  //    }
  //
  //    @GetMapping(path = "/product/{id}", version = "2")
  //    public ResponseEntity<Product> getProductV2(@PathVariable int id) {
  //        var product = productService.getProductByIdV2(id);
  //        return ResponseEntity.ok(product);
  //    }

  /* --------------- API Versioning using Path Segment -----------------*/
  @GetMapping(path = "/{version}/product/{id}", version = "1")
  public ResponseEntity<Product> getProductV1(@PathVariable int id) {
    var product = productService.getProductByIdV1(id);
    if (product == null) { // Added null check
      return ResponseEntity.notFound().build();
    }
    log.info("Retrieved product id: {}", product.getId());
    return ResponseEntity.ok(product);
  }

  @GetMapping(path = "/{version}/product/{id}", version = "2")
  public ResponseEntity<Product> getProductV2(@PathVariable int id) {
    var product = productService.getProductByIdV2(id);
    return ResponseEntity.ok(product);
  }
}
