package com.filmon.Recipe_management.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.filmon.Recipe_management.models.Recipe;

@Component
public interface RecipeDAO {
    public List<Recipe> getRecipes();
    public Recipe getRecipe(Long id);
    public void saveRecipe(Recipe recipe);
    public void deleteRecipe(Long id);

}
