package otherProblems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {
    LinkedList<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        // Remove first element in the linked List
        Iterator poll = list.remove();
        int result = (Integer)poll.next();
        // if this is not the last element then add it to end of the linked list
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }

    public static void main(String[] args){
//        Integer[] ar1 = new Integer[]{1,2};
////        List<Integer> v1 = Arrays.asList(ar1);
////
////        Integer[] ar2 =  new Integer[]{3,4,5,6};
////        List<Integer> v2 =  Arrays.asList(ar2);
////
////        ZigzagIterator zigzagIterator = new ZigzagIterator(v1,v2);
////
////        while (zigzagIterator.hasNext()){
////            System.out.println(zigzagIterator.next());
////        }

        System.out.println(9%4);
    }
}
