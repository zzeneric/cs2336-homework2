// Raghav Pillai, 6/11/21

import java.util.Scanner; // Import scanner for input

public class checkSSN{
    Scanner scanner = new Scanner(System.in); // New scanner
    String ssnString; // String to hold SSN
    String[] stringTable; // String table to hold SSN bits

    public void checkNum(){ // Check user input
        boolean check1 = false; // First set
        boolean check2 = false; // Second set
        boolean check3 = false; // Third set

        if(stringTable[0].length() == 3){ // First set needs to equal 3 numbers
            check1 = true;
        }
        if(stringTable[1].length() == 2){ // Second set needs to equal 2 numbers
            check2 = true;
        }
        if(stringTable[2].length() == 4){ // Third set needs to equal 4 numbers
            check3 = true;
        }

        if(check1 && check2 && check3){ // If all checks passed then valid
            System.out.println(ssnString + " is a valid social security number");
        }else{ // If checks don't pass then invalid
            System.out.println(ssnString + " is an invalid social security number");
        }
    }

    public void getInput(){ // Get user input
        System.out.print("Enter a SSN: ");
        ssnString = scanner.nextLine();
        stringTable = ssnString.split("-"); // Split by -
        scanner.close(); // Close scanner for memory leak
    }

    public static void main(String[] args){ // Main
        checkSSN myObj = new checkSSN(); // new object for SSN check
        myObj.getInput();
        myObj.checkNum();
    }
}