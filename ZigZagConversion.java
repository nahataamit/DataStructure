package otherProblems;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public String convert(String s, int numRows) {

        if(numRows ==1)
            return s;

        List<StringBuilder> rows = new ArrayList();

        for (int i = 0; i < numRows; i++)
            rows.add(new StringBuilder());

        char[] sc = s.toCharArray();
        int index = 0;
        boolean godown = false;

        for(char c : sc){
            rows.get(index).append(c);

            if(index ==0 || index == numRows-1) godown = !godown;

            index+= godown?1:-1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();

    }

    public static void main(String[] args){
        ZigZagConversion zigZagConversion = new ZigZagConversion();
//        System.out.println(zigZagConversion.convert("PAYPALISHIRING", 3));
        System.out.println(zigZagConversion.convert("ABCD", 2));
    }

}
