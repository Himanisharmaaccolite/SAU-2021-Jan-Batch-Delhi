package com.himani;

public class NotificationCheck extends Observer{
    NotificationCheck(Employeee emp)
    {
        this.employee=emp;
    }
    @Override
    public void  update()
    {
        System.out.println("Push Notification Sent");
        this.employee.salaryCredited=false;
    }
}
