package org.example.java5n_sof3022_01.controller;

import lombok.RequiredArgsConstructor;
import org.example.java5n_sof3022_01.entity.Product;
import org.example.java5n_sof3022_01.service.CategoryService;
import org.example.java5n_sof3022_01.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/products")
    public String listProducts(Model model) {

        // get data from db
        List<Product> products = productService.getAllProducts();

        // forward data
        model.addAttribute("products", products);

        // return view
        return "views/products";
    }
}
