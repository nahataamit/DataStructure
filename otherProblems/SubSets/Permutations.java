package otherProblems.SubSets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums){
        List<List<Integer>> result =  new ArrayList<>();
        Queue<List<Integer>> permutations =  new LinkedList<>();

        permutations.add(new ArrayList<>());

        for(int number : nums){
         int n = permutations.size();
         for (int i=0;i<n;i++ ){
             List<Integer> oldPermutation = permutations.poll();
             for (int j=0;j<=oldPermutation.size();j++){
                 List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                 newPermutation.add(j,number);

                 if(newPermutation.size()== nums.length)
                     result.add(newPermutation);
                 else
                 permutations.add(newPermutation);
             }
         }
        }

        return result;
    }

    public static List<List<Integer>> findPermutationsR(int[] nums) {
        List<List<Integer>> result =  new ArrayList<>();
        findPermutationsRecursion(nums,0,result,new ArrayList<>());
        return result;
    }

    public static void findPermutationsRecursion(int[] nums,int index, List<List<Integer>> result, List<Integer> permutation){
        if(permutation.size()== nums.length)
            result.add(permutation);
        else {
            for (int i=0;i<=permutation.size();i++){
                List<Integer> newPermutation =  new ArrayList<>(permutation);
                newPermutation.add(i,nums[index]);
                findPermutationsRecursion(nums,index+1,result,newPermutation) ;
            }
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.println("Here are all the permutations: " + result);
        result = Permutations.findPermutationsR(new int[] { 1, 3, 5 });
        System.out.println("Here are all the permutations: " + result);
    }
}
