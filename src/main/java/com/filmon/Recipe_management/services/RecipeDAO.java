package com.filmon.Recipe_management.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.filmon.Recipe_management.models.Recipe;

@Component
public interface RecipeDAO {
    public List<Recipe> getAllRecipes();
    public Recipe getRecipeById(Long id);
    public void create(Recipe recipe); // Modified method name
    public void update(Recipe recipe);
    public void deleteRecipe(Long id);
    
}
