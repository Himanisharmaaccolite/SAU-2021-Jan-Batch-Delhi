package com.himani;

public class FactoryEmployee {


        public static Employeee getEmployeeObject(String designation)
        {
            Employeee emp=null;
            if(designation.equals("Intern"))
            {
                emp=new Intern();
            }
            else if(designation.equals("Manager"))
            {
                emp=new Manager();
            }
            return emp;
        }
}


