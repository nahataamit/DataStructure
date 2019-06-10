package otherProblems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);

        if(!scanner.hasNext()){
            System.out.println("FAILURE => WRONG INPUT (LINE "+1+")");
        }

        int noOfTest = 0 ;
        String test = scanner.nextLine();

        // Check if total no of test cases received in first line matches with all the input received (TO-DO) For now this is done in last step but shoud be done uppfron to avoid any unnacessary processing


        // check if this is a valid input
        try{
            noOfTest = Integer.valueOf(test);
        }catch(NumberFormatException ex){
            System.out.println("FAILURE => WRONG INPUT (LINE "+1+")");
        }
        // counter for check against total test cased submitted vs received
        int receivedTests = 0;

        for(int i=0;i<noOfTest;i++){
            String testCase = "";
            // Read the events received and check if next input exist

            if(scanner.hasNext()){
                testCase = scanner.nextLine();
            }else{
                System.out.println("FAILURE => WRONG INPUT (LINE "+(i+2)+")");
            }

            if(testCase == null || "".equals(testCase)){
                System.out.println("FAILURE => WRONG INPUT (LINE "+(i+2)+")");
            }

            // Split each event because events are saperated by white spaces
            String[] sequence = testCase.split(" ");

            // Check all the events received are valid
            if(validateInput(sequence)){
                // Sort the Received Events (Gotcha if there are invaid event then sorting might be mis leading)// TODO (Handle it)
                Arrays.sort(sequence);

                // Find the highest element on the array
                int totalEvents = sequence.length;

                // Check is the total events recieved is same as the highest event
                if(Integer.valueOf(sequence[totalEvents-1]) == totalEvents){
                    // if yes then success
                    System.out.println("SUCCESS => RECEIVED: "+totalEvents)   ;
                }else{
                    // if no then flag failure
                    System.out.println("FAILURE => RECEIVED: "+totalEvents + ", EXPECTED: "+sequence[totalEvents-1]);
                }
            }else{
                // Generate MEssage for Invalid Input
                System.out.println("FAILURE => WRONG INPUT (LINE "+(i+2)+")");
            }
            receivedTests++;

        }

        // This should be done upfront but due to time limitation i just added it in the last moment
        if(receivedTests != noOfTest)
            System.out.println("FAILURE => WRONG INPUT (LINE "+1+")");
    }

    public static boolean validateInput(String[] sequence){
        // Check if the all events are integer not repeated
        boolean isValidInput = true;
        String str = "";
        for(int i=0;i<sequence.length;i++){
            try{
                // check if there is no repeated event recieved
                if(!str.contains(sequence[i])){
                    str+=sequence[i];
                }else{
                    isValidInput = false;
                    break;
                }
                int local = Integer.valueOf(sequence[i]);
            }catch(NumberFormatException e){
                isValidInput = false;
                break;
            }
        }

        return isValidInput;
    }
}
