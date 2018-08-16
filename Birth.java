import java.io.IOException;
import java.util.*;
import java.util.regex.*;

class Birth {

    private static final String STOP = "0";
    private static final String VALID = "Valid IC format";
    private static final String INVALID = "Invalid IC format";

    private static final String VALID_IC_PATTERN
                   = "[0-9][0-9][0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]";


    public static void main (String[] args) throws IOException, Exception
    {

        Scanner scanner = new Scanner(System.in);
        
        //ask name
        String name;
        System.out.print("Please enter your name: ");
        name = scanner.nextLine();
        
        //ask gentle
        char gentle;
        String call = "";
        try{
            do
            {
                System.out.print("Please enter your gentle[Enter m = male ... f = female]: ");
                gentle = scanner.next().charAt(0);
                if(gentle == 'm')
                    call = "Mr. ";
                else if (gentle == 'f')
                    call = "Mrs. ";           
                else
                    System.out.println("Please see instruction");
            }while(gentle != 'm' && gentle != 'f');
            
        }catch(InputMismatchException e)
        {
            System.out.println("Invalid entry");
        }

        
        String icStr, reply;

        Pattern icPattern = Pattern.compile(VALID_IC_PATTERN);
        Matcher icMatcher;

    
        int choice;
        do {
            System.out.println("Hi "+ call + name);
            
            //format have to be followed exactly
            System.out.print("Enter your ic number [ex. 123456-78-1234]: ");
            icStr = scanner.next();

            if (icStr.equals(STOP)) break;

            icMatcher = icPattern.matcher(icStr);

            if (icMatcher.matches()) 
            {
                reply = VALID;     
                //to find the birth date
                int combination;
                int yeart;
                int montht;
                int dayt;
                String textm = null;

                String year = icStr.substring(0,2);
                yeart = Integer.parseInt(year);
                String month = icStr.substring(2,4);
                montht = Integer.parseInt(month);
                String day = icStr.substring(4,6);
                dayt = Integer.parseInt(day);

                if(yeart > 19 )
                    combination = 19;
                else
                    combination = 20;

                switch(montht)
                {
                    case 1:
                    {
                        textm = "January";
                        break;
                    }
                    case 2:
                    {
                        textm = "February";
                        break;
                    }
                    case 3:
                    {
                        textm = "March";
                        break;
                    }
                    case 4:
                    {
                        textm = "April";
                        break;
                    }
                    case 5:
                    {
                        textm = "May";
                        break;
                    }
                    case 6:
                    {
                        textm = "June";
                        break;
                    }
                    case 7:
                    {
                        textm = "July";
                        break;
                    }
                    case 8:
                    {
                        textm = "August";
                        break;
                    }
                    case 9:
                    {
                        textm = "September";
                        break;
                    }
                    case 10:
                    {
                        textm = "October";
                        break;
                    }
                    case 11:
                    {
                        textm = "November";
                        break;
                    }
                    case 12:
                    {
                        textm = "December";
                        break;
                    }
                    default:
                        System.out.println("Invalid IC number");
                        break;
                }

                System.out.println(call + " " + name.toUpperCase());
                System.out.println("You are born in " + combination + year);
                System.out.print("Birthday: ");
                System.out.println( dayt + " " + textm);
            } 
            else 
            {
                reply = INVALID;
            }

            System.out.println(icStr + ": " + reply + "\n");
            
            //only enter 0 to exit
            System.out.print("Enter 0 to exit, others to continue: ");
            choice = scanner.nextInt();
        }while(choice != 0);
  
        
    }
    
}
