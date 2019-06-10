package otherProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/articles/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationOfPhoneNumber {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    public List<String> getLetterCombination(String digits) {
        List<String> list = new ArrayList<>();
        backtrack(list, digits, "");
        return list;
    }

    public void backtrack(List<String> list, String digits, String combination) {

        // Base condition
        if (digits.length() == 0) {
            list.add(combination);
            return;
        }


        String digit = digits.substring(0, 1);
        String letters = phone.get(digit);

        for (int j = 0; j < letters.length(); j++) {
            String letter = letters.substring(j, j + 1);
            backtrack(list, digits.substring(1), combination + letter);
        }

    }

    public static void main(String[] args){
        LetterCombinationOfPhoneNumber letterCombinationOfPhoneNumber = new LetterCombinationOfPhoneNumber();
        List<String> list =  letterCombinationOfPhoneNumber.getLetterCombination("23");
        StringBuffer stringBuffer  = new StringBuffer();
        stringBuffer.append("[");

        int index = 1;
        int size =  list.size();
        for(String val : list){
            System.out.println(val);

            if(index< size)
            stringBuffer.append("\""+val+"\",");
            else
                stringBuffer.append("\""+val+"\"");
            index++;
        }


        stringBuffer.append("]");
        System.out.println(stringBuffer.toString());
//        String val = "234";
//        System.out.println(val.substring(1,2));
//        System.out.print(val.substring(1));
    }

}
