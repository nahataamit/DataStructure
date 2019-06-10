package otherProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/articles/permutations/
 */
public class Permutation {

    public List<List<Integer>> getPrmutation(int [] nums ){
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> out  = new ArrayList<>();

        for(int n : nums)
            list.add(n);

        backtrack(list,0,out,nums.length);

        return out;
     }

     public void backtrack(List<Integer> list, int first, List<List<Integer>> out, int n){

        if(first ==  n)
            out.add(new ArrayList<>(list));
        for(int i=first; i< n;i++){
            Collections.swap(list, first, i);
            backtrack(list,first+1 ,out , n);
            Collections.swap(list,first ,i );
        }
     }

     public static void main(String[] args){
        Permutation permutation = new Permutation();
        List<List<Integer>> per = permutation.getPrmutation(new int []{1,2,3});
        for(List<Integer> list : per){
            System.out.println();

            System.out.print(list);
        }
     }
}
