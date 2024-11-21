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

  getRecipeById(id: number): Observable<{}> {
       return this.http.get<{}>(`/recipes/${id}`);
  }

  createRecipe(recipe: {}): Observable<{}> {
    return this.http.post<{}>('/recipes', recipe);
  }

  updateRecipe(id: number, recipe: {}): Observable<{}> {
    return this.http.put<{}>(`/recipes/${id}`, recipe);
  }

  deleteRecipe(id: number): Observable<{}> {
    return this.http.delete<{}>(`/recipes/${id}`);
  }

}
