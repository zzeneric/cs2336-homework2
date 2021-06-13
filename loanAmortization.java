// Raghav Pillai, 6/11/21

import java.util.Scanner;

public class loanAmortization{
    int loanAmount, years; // Setup loan amount and years
    double interest; // Interest rate
    Scanner scanner = new Scanner(System.in); // Scanner to get user input

    public void calcInterest(){
		double monthRate = interest / 1200; // Monthly rate of interest
		double monthPayment = loanAmount * monthRate / (1 - 1 / Math.pow(1 + monthRate, years * 12)); // Get monthly payment (from interest formula)
        double balance = loanAmount; // Get current balance
        double principal, interest; // Setup principal and interest

		System.out.println("\nMonthly Payment: " + String.format("%.2f",monthPayment)); // Round monthly payment to 2 decimal places
		System.out.println("Total Payment: " + String.format("%.2f",((monthPayment * 12) * years))); // Round the total payment to 2 decimal places
        System.out.println("\nPayment#\tInterest\tPrincipal\tBalance"); // Setup column headers

		for (int i = 1; i <= (years*12); i++){ // Loop each month (year*12)
			interest = monthRate * balance; // Interest (monthly rate * balance)
			principal = monthPayment - interest; // Principal amount
			balance = balance - principal; // Balance remaining
			System.out.println(i + "\t\t" + String.format("%.2f", interest) + "\t\t" + String.format("%.2f", principal) + "\t\t" + String.format("%.2f", balance)); // Print the column (interest, principal and balance)
		}
    }

    public void getInput(){
        System.out.print("Loan Amount: "); // Get loan amoutn
        loanAmount = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Number of years: "); // Get years (months*12)
        years = Integer.parseInt(scanner.nextLine());

        System.out.print("Annual Interest Rate: "); // Get interest rate
        interest = Double.parseDouble(scanner.nextLine());
    }

    public static void main(String[] args){
        loanAmortization myObj = new loanAmortization(); // Setup object for amortization

        myObj.getInput();
        myObj.calcInterest();
    }
}