package org.example.java5n_sof3022_01.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.java5n_sof3022_01.entity.Product;
import org.example.java5n_sof3022_01.service.CategoryService;
import org.example.java5n_sof3022_01.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/products/showNewProductForm")
    public String showNewProductForm(Model model) {

        Product product = new Product();
        model.addAttribute("product", product);

        model.addAttribute("categories", categoryService.getAllCategories());

        return "views/new_product";
    }

    @PostMapping("/products/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return "views/new_product";
        }

        productService.saveProduct(product);

        return "redirect:/products";
    }

    @GetMapping("/products/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") long id) {

        productService.deleteProductById(id);

        return "redirect:/products";
    }

    @GetMapping("/products/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") long id, Model model) {

        Product product = productService.getProductById(id);

        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());

        return "views/update_product";
    }

    @PostMapping("/products/updateProduct")
    public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("categories", categoryService.getAllCategories());
            return "views/update_product";
        }

        productService.updateProduct(product);

        return "redirect:/products";
    }


}
