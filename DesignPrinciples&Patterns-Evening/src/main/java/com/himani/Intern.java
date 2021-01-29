package com.himani;

public class Intern extends Employeee{

    public  Intern()
    {
        hirearchyLevel=1;
        salary=salary+ ((salary * hirearchyLevel * 10)/100);
    }

    public void setAttributes(String empName,int empId,String type)
    {
        id=empId;
        name=empName;
        salary=salary+ ((salary * hirearchyLevel * 10)/100);

        if(type.equals("SMS"))
            notificationType=new Sms(this);
        else if(type.equals("Email"))
            notificationType=new Email(this);
        else if(type.equals("Push"))
            notificationType=new NotificationCheck(this);
    }
}
