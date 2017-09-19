package com.ait.interview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
  @GetMapping("/")
  public String index() {
    return "default/index";
  }
}
