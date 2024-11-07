import { Component } from '@angular/core';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrl: './recipe-list.component.css'
})
export class RecipeListComponent {

  constructor(){}

  recipes = [
    { id: 1, name: 'Chocolate Chip Cookies', description: 'sugar, flaour, chocolate chips' },
    { id: 2, name: 'Pasta Carbonara', description: 'pasta, eggs, bacon, parmesan cheese' },
    { id: 3, name: 'Chicken Curry', description: 'chicken, curry powder, coconut milk' }

  ];
  selectedRecipe?: any;
  ngOnInit(): void {

  }

}
