package com.himani;

public abstract class Employeee
{
    public int id;
    public int salary=20000; // base salary
    public String name;
    public int hirearchyLevel;
    public Observer notificationType;
    boolean salaryCredited=false;

    public abstract void setAttributes(String empName,int empId,String type);

    public void setSalaryCredited(boolean flag)
    {
        salaryCredited=flag;
        notificationType.update();
    }

    @Override
    public String toString() {
        return "Employeee{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", hirearchyLevel=" + hirearchyLevel +
                '}';
    }
}
