package com.himani;

public class Sms extends Observer{
    Sms(Employeee emp)
    {
        this.employee=emp;
    }

    @Override
    public void update()
    {
        System.out.println("Notification sent through Sms");
        this.employee.salaryCredited=false;
    }
}
