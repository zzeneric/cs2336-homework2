import java.util.Scanner;

public class daysMonth{
    Scanner scanner = new Scanner(System.in);
    String month;
    int year;

    public int monthCheck(){
        if(month.equals("Jan") || month.equals("Mar") || month.equals("May") || month.equals("Jul") || month.equals("Aug") || month.equals("Oct") || month.equals("Dec")){
            return 1;
        }else if(month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || month .equals("Nov")){
            return 2;
        }else if(month.equals("Feb")){
            return 3;
        }
        return 0;
    }

    public void getDays(){
        if(monthCheck() == 1){
            System.out.println(month + " " + year + " has 31 days");
        }else if(monthCheck() == 2){
            System.out.println(month + " " + year + " has 30 days");
        }else if(monthCheck() == 3){
            if ((year % 4 == 0) && year % 100 != 0){
                System.out.println(month + " " + year + " has 29 days");
            }else if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)){
                System.out.println(month + " " + year + " has 29 days");
            }else{
                System.out.println(month + " " + year + " has 28 days");
            }
        }
    }
    
    public void getInput(){
        String inputYear;
        System.out.print("Enter a year: ");
        inputYear = scanner.nextLine();
        year = Integer.parseInt(inputYear);

        System.out.print("Enter a month: ");
        month = scanner.nextLine();
    }
    
    public static void main(String[] args){
        daysMonth myObj = new daysMonth();
        myObj.getInput();
        myObj.getDays();
    }
}