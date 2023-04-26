package com.example.payroll;

import java.io.*;

public class EmployeePayroll {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("PayDataFile");
            BufferedReader bufReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("Report.txt");
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufWriter);
            String input;
              printWriter.printf("Employee Gross Pay Info \n");
//            System.out.println("Employee Gross Pay Info ");
            while ((input = bufReader.readLine()) != null) {
                String[] subString = input.split("\\|");
                Employee e = new Employee(subString[0],subString[1], Double.parseDouble(subString[2]), Double.parseDouble(subString[3]));
//                System.out.printf("%s  %40s  $%.2f\n", e.getEmployeeId(), e.getName(), e.getGrossPay());
                printWriter.printf("%s  %40s  $%.2f\n", e.getEmployeeId(), e.getName(), e.getGrossPay());
            }
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
