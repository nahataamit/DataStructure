package otherProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
addLast and add method will add the element to the end
addFirst will add the element to the start -- > queue
 */
public class PlayWithDequeue {
    public static void main(String[] args){
//        Deque<Integer> deque = new LinkedList<>();
//        deque.add(1);
//        deque.add(2);
//        deque.add(3);
//
//        while(!deque.isEmpty()){
//            System.out.print(deque.remove());
//        }
//
//        System.out.println();
//        deque.addFirst(1);
//        deque.addFirst(2);
//        deque.addFirst(3);
//
//        while(!deque.isEmpty()){
//            System.out.print(deque.remove());
//        }
//
//        System.out.println();
//        Deque<String> stringDeque = new LinkedList<>();
//        String s =  "1,2,3,4,5";
//        stringDeque.addAll(Arrays.asList(s.split(",")));
//
//        while (!stringDeque.isEmpty()){
//            System.out.print(stringDeque.remove());
//        }
//
//        System.out.println();
//        deque.addLast(1);
//        deque.addLast(2);
//        deque.addLast(3);
//
//        while(!deque.isEmpty()){
//            System.out.print(deque.remove());
//        }

        int [] hand = {1,2,3,6,2,3,4,7,8};
        Arrays.sort(hand);
        System.out.print(hand);

        Arrays.sort(hand);
        int window = 0;
        TreeMap<Integer, Integer> handCount = new TreeMap<>();

        for(int i: hand){
            if(handCount.containsKey(i)){
                handCount.put(i,handCount.get(i)+1);
            }else{
                handCount.put(i,1);
            }
        }

        boolean r=true;

        while(handCount.size()>0){

                int key = handCount.firstKey();

                while(window<3){
                    if(handCount.get(key+window) >0){
                        if(handCount.get(key+window)-1 == 0)
                            handCount.remove(key+window);
                        else
                        handCount.put(key+window,handCount.get(key+window)-1);
                        window++;
                    }else{
                        r = false;
                    }
                }
                window = 0;
            }


        System.out.print(r);

        ArrayList<String> list = new ArrayList<>();

    }
}
