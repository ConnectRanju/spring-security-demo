package com.ran.spring_security_example.controller;

import com.ran.spring_security_example.dto.Product;
import com.ran.spring_security_example.entity.UserInfo;
import com.ran.spring_security_example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")

public class ProductController {

@Autowired
    private ProductService service;
    /* welcome page for all users.*/
 @GetMapping("/welcome")
    public String welcome(){
     return " Welcome to this end point. It is not secured !!!";
 }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllTheProducts() {
        return service.getProducts();
    }

 @GetMapping("/{id}")
 @PreAuthorize("hasAuthority('USER')")
    public Product getProductById(@PathVariable int id){
     return service.getProduct(id);
 }

 @GetMapping("/search")
 public void searchProduct(@RequestParam String category,
                           @RequestParam int page,
                           @RequestParam int size){

 }


 @PostMapping("/new")
    public String createUser(@RequestBody UserInfo userInfo){
     return service.addUser(userInfo);
 }
}
