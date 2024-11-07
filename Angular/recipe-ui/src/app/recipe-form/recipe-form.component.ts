import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Inject } from '@angular/core';

@Component({
  selector: 'app-recipe-form',
  templateUrl: './recipe-form.component.html',
  styleUrl: './recipe-form.component.css'
})
export class RecipeFormComponent implements OnInit {

  model = { id: null, name: null, description: null };

  constructor(
    @Inject(Router) private router: Router
  ) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if(this.model.id) {
      // save new recipe
    } else {
      // update existing recipe
    }

    this.router.navigate(['/']);
  }

}
