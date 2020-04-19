package otherProblems.TopKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
 */

/**
 *  Time Complexity - k log(k) + (N-k) log(k) -> Nlog(k)
 *  Space Complexity - O(k)
 */
public class TopKNumbers {

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((p1,p2)-> p1-p2);

        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }

        for(int j=k;j<nums.length;j++){
            if(minHeap.peek()<nums[j]){
                minHeap.poll();
                minHeap.add(nums[j]);
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        List<Integer> result = TopKNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = TopKNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
