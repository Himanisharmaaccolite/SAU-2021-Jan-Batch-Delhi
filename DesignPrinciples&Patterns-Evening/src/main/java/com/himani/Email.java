package com.himani;

public class Email extends Observer{
    Email(Employeee emp)
    {
        this.employee=emp;
    }
    @Override
    public void update(){
        System.out.println("Email Notification Sent");
        this.employee.salaryCredited=false;
    }
}