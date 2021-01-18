import { Component, OnInit } from '@angular/core';
import { CompletionObserver, Observable } from 'rxjs';
import { EmployeeService } from '../employee.service';
import { Employee } from '../model/emplyoeemodel';

@Component({
  selector: 'app-viewdetails',
  templateUrl: './viewdetails.component.html',
  styleUrls: ['./viewdetails.component.css']
})
export class ViewdetailsComponent implements OnInit {
  allEmployee: Employee[];
  constructor(
    public employeeservice: EmployeeService
  ) { }

  ngOnInit() {
    this.getAllDetails();
  }

  getAllDetails() {
    this.employeeservice.getdetails().subscribe(
      (data: Employee[]) => {
        this.allEmployee = data;
      });
  }

  

  create(currentemployee: Employee) {
    if (currentemployee.id != null) {
      this.employeeservice.updateemployees(currentemployee).subscribe();
    }
    else {
      this.employeeservice.createemployees(currentemployee).subscribe();
    }
  }

  
  title = 'Angularcrud';

}



