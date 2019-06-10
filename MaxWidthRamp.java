package otherProblems;

import java.util.Arrays;
import java.util.Comparator;

/*
https://leetcode.com/problems/maximum-width-ramp/solution/
 */
public class MaxWidthRamp {
    public int maxWidthRamp(int[] A){
        int N =  A.length;

        Integer[] B =  new Integer[N];

        for(int i=0;i<A.length;i++)
          B[i] = i;

        // convert this without lambda
        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans =0;
        int m = N;

        for(int i : B){
           ans = Math.max(ans, i-m);
           m = Math.min(m,i );
        }


        return ans;

    }

    public static void main(String[] args){
        MaxWidthRamp maxWidthRamp = new MaxWidthRamp();
        maxWidthRamp.maxWidthRamp(new int[] {6,0,8,2,1,5});
    }
}
