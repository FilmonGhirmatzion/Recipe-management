package com.filmon.Recipe_management.services;

import java.util.List;

import com.filmon.Recipe_management.models.Recipe;

public class JdbcRecipe implements RecipeDAO {

    @Override
    public List<Recipe> getRecipes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Recipe getRecipe(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteRecipe(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveRecipe(Recipe recipe) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveRecipe'");
    }

}
