package com.himani;

public class Manager extends Employeee{

    public Manager()
    {
        hirearchyLevel=3;
        salary=salary+ ((salary * hirearchyLevel * 10)/100);
    }

    public void setAttributes(String empName,int empId,String type)
    {
        id=empId;
        name=empName;
        if(type.equals("SMS"))
            notificationType=new Sms(this);
        else if(type.equals("Email"))
            notificationType=new Email(this);
        else if(type.equals("Push"))
            notificationType=new NotificationCheck(this);
    }

}
