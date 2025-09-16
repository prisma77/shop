package com.multi.shop.controller;

import com.multi.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping({"/", "/products"})
    public String products(Model model) {
        model.addAttribute("products", productService.list());
        return "products"; // templates/products.html
    }
}

