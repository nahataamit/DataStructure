package otherProblems;

import java.util.Arrays;
import java.util.List;

public class MinimumMoves {
    public static int minimumMoves(List<Integer> a, List<Integer> m) {
        // Write your code here
        if(a.size() != m.size())
            return 0;

        int count = 0;

        for(int i=0;i<a.size();i++){
            char[] num1 = String.valueOf(a.get(i)).toCharArray();
            char[] num2 = String.valueOf(m.get(i)).toCharArray();

            for(int j=0;j<num1.length;j++){
                count+=Math.abs(('0'-num1[j])-('0'-num2[j]));
            }
        }

        return count;
    }

    public static void main(String[] args){
        List<Integer> a = Arrays.asList(1234,4321);
        List<Integer> b = Arrays.asList(2345,3214);
        MinimumMoves minimumMoves = new MinimumMoves();
        System.out.println(minimumMoves.minimumMoves(a,b));
    }
}
