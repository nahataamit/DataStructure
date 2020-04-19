package otherProblems.TwoHeaps;

import java.util.PriorityQueue;

/**
 * Important funda : Every time you add or remove the elements from the MinHeap or the MaxHeap
 * Rebalance is required !!
 */
public class SlidingWindowMedian {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public SlidingWindowMedian(){
        minHeap = new PriorityQueue<>((a,b)-> a-b);
        maxHeap = new PriorityQueue<>((a,b)-> b-a);
    }
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int windowStart = 0;

        for(int windowEnd = 0;windowEnd< nums.length;windowEnd++){

            insert(nums[windowEnd]);

           if(windowEnd-windowStart+1 == k){
                result[windowStart] = getMedian();
                removeFromPQ(nums[windowStart]);
                windowStart++;
            }
        }
        return result;
    }

    public void removeFromPQ(int num){
        if(minHeap.contains(num)){
            minHeap.remove(num);
        }else {
            maxHeap.remove(num);
        }
        rebalanceHeap();
    }

    public void insert(int num){
        if(maxHeap.isEmpty() || maxHeap.peek()< num){
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }
        rebalanceHeap();
    }

    public void rebalanceHeap(){
        if(maxHeap.size()> minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size()> maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double getMedian(){
        if(minHeap.size() == maxHeap.size())
            return minHeap.peek()/2.0 + maxHeap.peek()/2.0;

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
