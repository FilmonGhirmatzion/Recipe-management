package com.filmon.Recipe_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmon.Recipe_management.models.Recipe;
import com.filmon.Recipe_management.services.RecipeDAO;

@RestController
@RequestMapping("/recipes")
public class RecipeRestController {
    
    private final RecipeDAO recipeDAO;

    public RecipeRestController(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }
    @GetMapping("/list")
    public List<Recipe> list() {
        return recipeDAO.getAllRecipes();
    }

    @GetMapping("/get/{id}")
    public Recipe get(@PathVariable Long id) {
        return recipeDAO.getRecipeById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Recipe recipe) {
        recipeDAO.create(recipe);
    }

    @PutMapping("/update/{id}")
    public void updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
         recipeDAO.update(recipe);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        recipeDAO.deleteRecipe(id);
    }
 
}
