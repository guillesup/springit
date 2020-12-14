package com.vega.springit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {
  @GetMapping("/hello")
  public String hello() {
    return "Hello I'm looking for a hot, chubby and dirty girl!";
  }
}
