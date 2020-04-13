package otherProblems.SlidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 */
public class MaxSumSubArrayOfSizeK {

    /**
     * Time Complexity O(n) space Complexity O(1)
     * @param k
     * @param arr
     * @return
     */
    public static int findMaxSumSubArray(int k, int[] arr) {
        int startWindow = 0;
        int result = 0;
        int sum = 0;
        for (int endWindow=0;endWindow<arr.length;endWindow++){
            sum+=arr[endWindow];
            if(endWindow>=k-1){
                result = Math.max(result,sum);
                sum-=arr[startWindow];
                startWindow+=1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
