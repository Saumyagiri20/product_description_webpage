package com.example.productdescription.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/products")
    public String getProductPage() {
        return "product";  // Refers to 'product.html' in the 'templates' folder
    }
}

