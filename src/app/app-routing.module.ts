import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { EntrarComponent } from './entrar/entrar.component';

/**
 * Array de objetos de rotas
 * 
 * path: -> nome da minha rota.
 * component: -> pra qual component essa rota vai.
 * pathMatch: -> trazer toda rota por compoelto (forçar).
 * 
 */
const routes: Routes = [

  { path: '', redirectTo: 'entrar', pathMatch: 'full'},

  { path: 'entrar', component: EntrarComponent},
  { path: 'cadastrar', component: CadastrarComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
