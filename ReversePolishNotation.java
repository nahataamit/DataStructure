package otherProblems;

import java.util.Arrays;
import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack();

        for(int i=0;i<tokens.length;i++){
            if(isInteger(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }else{

                // Add validation for the stack size
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = evalOperator(tokens[i],num1, num2);
                stack.push(result);
            }
        }
        // Add validations
        return Integer.valueOf(stack.pop());
    }

    public boolean isInteger(String str){
        try{
            Integer.parseInt(str);
        }catch(NumberFormatException ex){
            return false;
        }
        return true;
    }


    public int evalOperator(String op,int num1, int num2){
        int result = 0;

        switch(op){
            case "+" :
                result = num1+num2;
                break;
            case "-" :
                result = num1-num2;
                break;
            case "*" :
                result = num1*num2;
                break;
            case "/" :
                if(num2!=0 || num1 !=0){
                    result = num1/num2;}
                break;
        }

        return result;
    }

    public static void main(String[] args){
        String[] tokens = new String[] {"4","13","5","/","+"};
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        System.out.println(reversePolishNotation.evalRPN(tokens));
    }
}
