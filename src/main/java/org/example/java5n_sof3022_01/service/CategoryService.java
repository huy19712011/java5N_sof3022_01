package org.example.java5n_sof3022_01.service;

import lombok.RequiredArgsConstructor;
import org.example.java5n_sof3022_01.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Object getAllCategories() {

        return categoryRepository.findAll();
    }
}
