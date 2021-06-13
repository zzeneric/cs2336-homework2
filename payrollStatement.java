// Raghav Pillai, 6/11/21

import java.util.Scanner; // Scanner for user input

public class payrollStatement{
    String name; // Var declaration
    double hours, payRate, fedTax, stateTax;
    Scanner scanner = new Scanner(System.in); // New scanner for input

    public void getPayroll(){
        double beforeTax = payRate * hours; // Get money before tax
        double fedRemove = beforeTax * fedTax; // Get federal tax $
        double stateRemove = beforeTax * stateTax; // Get state tax $

        System.out.println("\nEmployee Name: " + name); // Print data
        System.out.println("Hours worked: " + hours);
        System.out.println("Pay Rate: $" + String.format("%.2f",payRate)); // Format to 2 decimal places
        System.out.println("Gross Pay: $" + String.format("%.2f",beforeTax));

        System.out.println("Deductions:"); // Print all deductions (round to 2 decomal places)
        System.out.println("   Federal Withholding (" + fedTax*100 + "%): $" + String.format("%.2f",fedRemove));
        System.out.println("   State Withholding (" + stateTax*100 + "%): $" + String.format("%.2f",stateRemove));
        System.out.println("   Total Deduction: $" + String.format("%.2f",(stateRemove + fedRemove)));

        System.out.print("Net Pay: $" + String.format("%.2f",(beforeTax - (stateRemove + fedRemove)))); // Print net pay (tax - (state+fed))
    }

    public void getInput(){
        System.out.print("Enter employee's name: "); // Get name
        name = scanner.nextLine();
        
        System.out.print("Enter mumbers of hours worked in a week: "); // Get hours per week
        hours = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Enter hourly pay rate: "); // Get pay rate
        payRate = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter federal tax withholding rate: "); // Get federal tax rate
        fedTax = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter state tax withholding rate: "); // Get state tax rate
        stateTax = Double.parseDouble(scanner.nextLine());
    }
    public static void main(String[] args){
        payrollStatement myObj = new payrollStatement(); // Setup object to get payroll info

        myObj.getInput();
        myObj.getPayroll();
    }
}