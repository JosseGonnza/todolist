import { CategoryListComponent } from './components/category/category-list.component';
import { Routes } from '@angular/router';
import { LoginComponent } from './components/auth/login.component';
import { RegisterComponent } from './components/auth/register.component';

export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'categories/home', component: CategoryListComponent }
];

export default routes;
