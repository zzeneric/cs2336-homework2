// Raghav Pillai, 6/11/21

import java.util.Scanner; // Use scanner for input

public class interestChecker{
    int loanAmount, years; // Loan amount and years used
    Scanner scanner = new Scanner(System.in); // New scanner input

    public void getLoan(){ // Use input items to get interest rates for the loan
        System.out.println("Interest Rate\tMonthly Payment\tTotal Payment"); // Make column headers
		
		// Display table with interest rates
		for (double i = 5.0; i <= 8; i += 0.125){ // Loop through and display each interest rate
			System.out.print(String.format("%.3f",i) + "%\t\t"); // Format to 3 decimal places for interest
			double monthlyInterestRate = i / 1200; // Get monthly interest rate
			double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12)); // Use interest rate formula to find monthly payment
			System.out.print(String.format("%.2f",monthlyPayment) + "\t\t"); // Round to 2 decimal places and print payment, put tabs after for spacing
			System.out.println(String.format("%.2f",(monthlyPayment * 12) * years)); // Get total payment so far
		}
    }

    public void getInput(){ // Get user input
        System.out.print("Loan Amount: "); // Get loan amount
        loanAmount = Integer.parseInt(scanner.nextLine()); // Use parseInt to convert string to int
        
        System.out.print("Number of years: "); // Get amount of years for loan
        years = Integer.parseInt(scanner.nextLine());
    }

    public static void main(String[] args){
        interestChecker myObj = new interestChecker(); // New object to store interest items
        myObj.getInput();
        myObj.getLoan();
    }
}