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
        Recipe recipe = null;
        String sql = "SELECT id, name, description FROM recipe_management WHERE id = ?;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);
        if (rows.next()) {
            recipe = mapRowToRecipe(rows);
        }
        return recipe;
    }


    @Override
    public void create(Recipe recipe) {
        String sql = "INSERT INTO recipe_management (name, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, 
            recipe.getName(),
            recipe.getDescription()
            );
    }


    @Override
    public void update(Recipe recipe) {
        String sql = "UPDATE recipe_management SET name = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(sql, 
            recipe.getName(),
            recipe.getDescription(),
            recipe.getId()
            );
    }


    @Override
    public void deleteRecipe(Long id) {
        String sql = "DELETE FROM recipe_management WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
