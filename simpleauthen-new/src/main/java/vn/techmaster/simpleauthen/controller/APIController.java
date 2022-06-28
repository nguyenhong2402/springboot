package vn.techmaster.simpleauthen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.simpleauthen.model.Product;

@RestController

@RequestMapping("/api")
public class APIController {

  @GetMapping("/products")
  public List<Product> getProducts() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    UserDetails userDetails = (UserDetails) auth.getPrincipal();
    System.out.println("Logged user: " + userDetails.getUsername() + "|" + userDetails.getPassword());
    List<Product> result = new ArrayList<>();
    result.add(new Product("Coffe Machine", 150));
    result.add(new Product("Apple Watch", 250));
    result.add(new Product("Eink Book Reader", 350));
    return result;
  }
}
