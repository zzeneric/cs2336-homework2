// Raghav Pillai, 6/11/21

import java.util.Scanner;

public class daysMonth{
    Scanner scanner = new Scanner(System.in); // New scanner for input
    String month; // Month var
    int year; // Year var

    public int monthCheck(){ // Check the months and return an integer value depending on month legnth
        if(month.equals("Jan") || month.equals("Mar") || month.equals("May") || month.equals("Jul") || month.equals("Aug") || month.equals("Oct") || month.equals("Dec")){ // 31 days
            return 1;
        }else if(month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || month .equals("Nov")){ // 30 days
            return 2;
        }else if(month.equals("Feb")){ // Check for leap year (if not 28 days)
            return 3;
        }
        return 0;
    }

    public void getDays(){ // Check the days per month taking into account leap years
        if(monthCheck() == 1){ // 31 days
            System.out.println(month + " " + year + " has 31 days");
        }else if(monthCheck() == 2){ // 30 days
            System.out.println(month + " " + year + " has 30 days");
        }else if(monthCheck() == 3){ // Feb (possible leap year)
            if ((year % 4 == 0) && year % 100 != 0){ // If leap year (checking 1)
                System.out.println(month + " " + year + " has 29 days");
            }else if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)){ // Checking 2 leap year
                System.out.println(month + " " + year + " has 29 days");
            }else{ // Not a leap year
                System.out.println(month + " " + year + " has 28 days");
            }
        }
    }
    
    public void getInput(){ // Get user input
        String inputYear; // year stored as string
        System.out.print("Enter a year: ");
        inputYear = scanner.nextLine(); // Get next line
        year = Integer.parseInt(inputYear); // Cast string to integer

        System.out.print("Enter a month: "); // Get month
        month = scanner.nextLine(); // Store month as global string
    }
    
    public static void main(String[] args){ // Main function
        daysMonth myObj = new daysMonth(); // Initialize class as object
        myObj.getInput();
        myObj.getDays();
    }
}