package otherProblems.TwoHeaps;

import java.util.PriorityQueue;

public class MedianOfAStream {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianOfAStream(){
        minHeap = new PriorityQueue<>((a,b)-> a-b);
        maxHeap = new PriorityQueue<>((a,b)-> b-a);
    }

    // We will have more elements in the max heap
    // We can insert the element in the maxHeap if the no is smaller than
    // the top element.
    // After each insertion we will balance the no of elements in both heaps
    // Such that both have equal no of elements, if the count no is odd then we will
    // add element to the maxHeap

    public void insertNum(int num) {

        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size()< minHeap.size()){
            maxHeap.add(minHeap.poll());
        }


    }

    public void insertnum(int num){
        if(maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        if(maxHeap.size()> minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size()< minHeap.size()){
            maxHeap.add(minHeap.poll());
        }

    }


    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
            return minHeap.peek()/2.0+ maxHeap.peek()/2.0;

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
