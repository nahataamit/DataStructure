package otherProblems.SlidingWindow;

import otherProblems.MAxWidthOfBinaryTree;

/**
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous sub array whose sum is greater than or equal to ‘S’.
 * Return 0, if no such subarray exists.
 */
public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int startWindow = 0;
        int length = Integer.MAX_VALUE;
        int windowSum = 0;
        for(int endWindow = 0; endWindow<arr.length;endWindow++){

            windowSum+=arr[endWindow];
            // Shrink the window as small as possible until the windowSum is
            // smaller than 'S'
            while (windowSum>=S){
                length = Math.min(length,endWindow-startWindow+1);
                windowSum-=arr[startWindow];
                startWindow+=1;
            }

        }

        return length;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
