package com.example.springboot4.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.example.springboot4.service.ThreadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/threads")
@Slf4j
@RequiredArgsConstructor
public class VirtualThreadController {

  private final ThreadService threadService;

  @GetMapping(value = "{version}/", version = "1")
    public String home() {
        return "Virtual Thread Demo Home";
    }

  @GetMapping(value = "{version}/traditional", version = "1")
  public String traditionalThread() throws ExecutionException, InterruptedException {
    return threadService.simulateTraditionalThreadTask();
  }

  @GetMapping(value = "{version}/virtual", version = "1")
  public String virtualThread() throws ExecutionException, InterruptedException {
    return threadService.simulateVirtualThreadTask();
  }
}
