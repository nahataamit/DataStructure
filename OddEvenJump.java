package otherProblems;

import java.util.TreeMap;

public class OddEvenJump {
    public int oddEvenJump(int[] A) {
        int N = A.length;

        boolean[] even  = new boolean[N];
        boolean[] odd   = new boolean[N];
        even[N-1] = odd[N-1] = true;

        TreeMap<Integer,Integer> vals =  new TreeMap<>();
        vals.put(A[N-1],N-1 );

        for(int i=N-2;i>=0;i--){
            int v = A[i];

            if(vals.containsKey(v)){
                even[i] = odd[vals.get(v)];
                odd[i] = even[vals.get(v)];

            }else {
                Integer lower = vals.lowerKey(v);
                Integer higher =  vals.higherKey(v);

                if(lower!=null)
                    even[i] = odd[vals.get(lower)];

                if(higher!=null)
                    odd[i] = even[vals.get(higher)];
            }
            vals.put(v,i );

        }

        int ans = 0;

        for(boolean b : odd)
            if(b) ans++;

        return ans;

    }

    public static void main(String[] args){
        OddEvenJump oddEvenJump = new OddEvenJump();
       // System.out.println(oddEvenJump.oddEvenJump(new int[]{10,13,12,14,15}));
        System.out.println(oddEvenJump.oddEvenJump(new int[]{2,3,1,1,4}));
    }
}
