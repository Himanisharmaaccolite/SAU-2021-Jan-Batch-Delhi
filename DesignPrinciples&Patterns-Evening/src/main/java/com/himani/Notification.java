package com.himani;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.jar.Attributes;


public class Notification implements Job {

    ArrayList<Employeee> employees=new ArrayList<>();

    public Notification() throws IOException {

        FactoryEmployee employeeFactory=new FactoryEmployee();
        int id=1;
        FileInputStream inputStream = new FileInputStream(new File("src/main/resources/Employeedata.xlsx"));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            ArrayList<String> attributes=new ArrayList<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                attributes.add(cell.getStringCellValue());
            }

            Employeee employee=employeeFactory.getEmployeeObject(attributes.get(0));
            employee.setAttributes(attributes.get(1),id++,attributes.get(2));
            employees.add(employee);
        }
        workbook.close();
        inputStream.close();
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        for(Employeee e:employees)
        {
            e.setSalaryCredited(true);
        }
    }
}
