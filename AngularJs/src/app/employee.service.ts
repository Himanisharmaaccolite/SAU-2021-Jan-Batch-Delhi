import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './model/emplyoeemodel';

const headeroption = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
}

@Injectable()
export class EmployeeService {

  url = 'http://localhost:3000/Employee';

  currentemployee: Employee = {
    id: null,
    name: ' ',
    address: ' ',
    designation: '',
    contact: null,
  }

  constructor(
    private http: HttpClient
  ) { }

  getdetails(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.url, headeroption);
  }

  deletetheemployee(id: number): Observable<Employee> {
    return this.http.delete<Employee>(this.url + '/' + id, headeroption);
  }

  createemployees(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.url, employee, headeroption);
  }

  updateemployees(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(this.url + '/' + employee.id, employee, headeroption);
  }

}
