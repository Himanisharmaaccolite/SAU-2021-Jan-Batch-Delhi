import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewdetailsComponent } from './viewdetails/viewdetails.component';
import {EmployeeService} from './employee.service';
import {FormsModule} from '@angular/forms';
import { ShowDetailsComponent } from './show-details/show-details.component';
@NgModule({
  declarations: [
    AppComponent,
    ViewdetailsComponent,
    ShowDetailsComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [EmployeeService],
  entryComponents: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
