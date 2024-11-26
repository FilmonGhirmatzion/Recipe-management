import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  constructor(private http: HttpClient) { }
  getRecipesList(): Observable<{}[]> {
    return this.http.get<{}[]>('/recipes');
  }

  getRecipeById(id: any) {
       return this.http.get<{}>(`/recipes/${id}`);
  }

  createRecipe(recipe: any) {
    return this.http.post(`/api/v1/recipes`, recipe);
  }

  updateRecipe(id: any, recipe: any) {
    return this.http.put(`/api/v1/recipes/${id}`, recipe);
  }

  deleteRecipe(id: any) {
    return this.http.delete(`/api/v1/recipes/${id}`);
  }

}
