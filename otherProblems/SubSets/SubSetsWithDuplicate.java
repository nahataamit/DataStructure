package otherProblems.SubSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsWithDuplicate {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList());
        Arrays.sort(nums);
        int startIdx = 0, endIdx = 0;
        for(int i=0;i<nums.length;i++){
           startIdx = 0;

           if(i>0 && nums[i] == nums[i-1]){
               // update the start index to previous run endIndex+1
               startIdx = endIdx+1;
           }

           // Keep track of last index of current run
           endIdx = subsets.size()-1;

           for(int j=startIdx;j<=endIdx;j++){
                ArrayList<Integer> set = new ArrayList(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubSetsWithDuplicate.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubSetsWithDuplicate.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
