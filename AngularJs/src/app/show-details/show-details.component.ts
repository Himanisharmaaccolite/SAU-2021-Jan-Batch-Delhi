import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../model/emplyoeemodel';
@Component({
  selector: 'app-show-details',
  templateUrl: './show-details.component.html',
  styleUrls: ['./show-details.component.css']
})
export class ShowDetailsComponent implements OnInit {

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

  deleteEmployee(id: number) {
    this.employeeservice.deletetheemployee(id).subscribe(
      (data: Employee) => {
        this.getAllDetails();
      });
  }
  updateEmployee(employeeId: number){
    this.allEmployee.forEach(element => {
      if(element.id == employeeId)
        this.employeeservice.currentemployee = Object.assign({},element);
    });
  }

}
