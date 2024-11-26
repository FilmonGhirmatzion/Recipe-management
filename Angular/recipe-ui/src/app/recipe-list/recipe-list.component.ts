import { Component } from '@angular/core';
import { RecipeService } from '../services/recipe.service';
import { Subscriber } from 'rxjs';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrl: './recipe-list.component.css'
})
export class RecipeListComponent {

  constructor(private recipeService: RecipeService){}

  recipes: any ;
  selectedRecipe?: any;

  ngOnInit(): void {
    this.recipes = this.recipeService.getRecipesList().
    subscribe({next: r => this.recipes = r, error: e => console.log(e)});

  }
  onSelect(recipe: any): void {
    this.selectedRecipe = recipe;
  }

  onDelete(recipe: any): void {
    this.recipeService.deleteRecipe(recipe.id).
    subscribe({
      next: (r: any) => this.ngOnInit(),
      error: (e: any) => console.log(e)
    });

  }

}
