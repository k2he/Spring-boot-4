package com.example.springboot4.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ThreadService {

  private final Executor traditionalExecutor;
  private final Executor virtualExecutor;

  public String simulateTraditionalThreadTask() throws ExecutionException, InterruptedException {
    CompletableFuture<String> future =
        CompletableFuture.supplyAsync(
            () -> {
              logThreadInfo();
              // simulate some work
              simulateDelay();
              return "Traditional thread task completed.";
            },
            traditionalExecutor);
    return future.get();
  }

  public String simulateVirtualThreadTask() throws ExecutionException, InterruptedException {
    CompletableFuture<String> future =
        CompletableFuture.supplyAsync(
            () -> {
              logThreadInfo();
              // simulate some work
              simulateDelay();
              return "Virtual thread task completed.";
            },
            virtualExecutor);
    return future.get();
  }

  private static void simulateDelay() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      log.error(e.getLocalizedMessage());
    }
  }

  private void logThreadInfo() {
    log.info("Task executed by: {}", Thread.currentThread().getName());
  }
}
