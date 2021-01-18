import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ViewdetailsComponent} from './viewdetails/viewdetails.component';
import {ShowDetailsComponent} from './show-details/show-details.component';
const routes: Routes = [
  {path:"route",component:ShowDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
