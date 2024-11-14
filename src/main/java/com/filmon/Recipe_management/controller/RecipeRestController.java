package com.filmon.Recipe_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmon.Recipe_management.models.Recipe;
import com.filmon.Recipe_management.services.RecipeDAO;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeRestController {
    
    private final RecipeDAO recipeDAO;

    public RecipeRestController(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }
    
    @GetMapping
    public List<Recipe> getRecipes() {
        return recipeDAO.getRecipes();
    }
    
    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable int id) {
        return recipeDAO.getRecipeById(id);
    }
    
    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeDAO.addRecipe(recipe);
    }
    
    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        return recipeDAO.updateRecipe(id, recipe);
    }
    
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable int id) {
        recipeDAO.deleteRecipe(id);
    }
}
