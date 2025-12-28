package com.example.springboot4.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@Slf4j
public class VirtualThreadController {

  @Async("traditionalExecutor")
  @GetMapping("/traditional")
  public CompletableFuture<String> traditionalThread() {
    log.info("Starting traditional thread request. Thread: {}", Thread.currentThread().getName());
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return CompletableFuture.completedFuture("Task interrupted");
    }
    return CompletableFuture.completedFuture(
        "Traditional thread completed. Thread: " + Thread.currentThread().getName());
  }

  @Async("virtualExecutor")
  @GetMapping("/virtual")
  public CompletableFuture<String> virtualThread() {
    log.info("Starting virtual thread request. Thread: {}", Thread.currentThread());
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return CompletableFuture.completedFuture("Task interrupted");
    }
    return CompletableFuture.completedFuture(
        "Virtual thread completed. Thread: " + Thread.currentThread());
  }
}
