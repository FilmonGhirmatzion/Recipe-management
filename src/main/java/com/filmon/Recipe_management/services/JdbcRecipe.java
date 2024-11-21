package com.filmon.Recipe_management.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.filmon.Recipe_management.models.Recipe;

@Component
public class JdbcRecipe implements RecipeDAO {

    private JdbcTemplate jdbcTemplate;
    public JdbcRecipe(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        String sql = "SELECT id, name, description FROM recipe_management;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            Recipe recipe = mapRowToRecipe(rows);
            recipes.add(recipe);
        }
        return recipes;
    }
    
    private Recipe mapRowToRecipe(SqlRowSet row) {
        Recipe recipe = new Recipe();
        recipe.setId(row.getLong("id"));
        recipe.setName(row.getString("name"));
        recipe.setDescription(row.getString("description"));
        return recipe;
    }



    @Override
    public Recipe getRecipeById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecipeById'");
    }


    @Override
    public void create(Recipe recipe) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }


    @Override
    public void update(Recipe recipe) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    @Override
    public void deleteRecipe(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRecipe'");
    }

}
