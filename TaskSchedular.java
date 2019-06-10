package otherProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

// Learn it in deep
public class TaskSchedular {
    public int leastInterval(char[] tasks, int n) {

        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }

    public int lastIntervalWithPQ(char[] tasks, int n){
        int[] map = new int[26];

        for(char c: tasks)
            map[c-'A']++;

        // MAx Heap
        PriorityQueue<Integer> queue =  new PriorityQueue<>(26, Collections.reverseOrder());

        for(int f : map){
            if(f>0)
                queue.add(f);
        }

        int time = 0;

        while (!queue.isEmpty()){
            int i =0;
            List<Integer> temp = new ArrayList<>();
            while (i<=n){
                if(!queue.isEmpty()){
                    if(queue.peek()>1){
                        temp.add(queue.poll()-1);
                    }else {
                        queue.poll();
                    }
                }

                time++;
                if(queue.isEmpty() && temp.size() ==0)
                    break;;

                i++;
            }

            for(int t : temp)
                queue.add(t);
        }

        return time;
    }

    public static void main(String[] args){
        char[] test = {'A','A','A','B','B','B'};
        TaskSchedular taskSchedular = new TaskSchedular();
        taskSchedular.leastInterval(test,2);
        Stack stack = new Stack();
        String string = "temp";


        Map<Position, String> map  = new HashMap<>();
        Position position = new Position(1,2);
        map.put(position,"value" );

        Position p2 = new Position(1,2);
        System.out.println(map.get(p2));


    }
}
class Position implements Comparable{
    int i;
    int j;

    public  Position(int i,  int j){
        this.i = i;
        this.j =j;
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass() != this.getClass())
            return false;

        Position position = (Position)o;

        if(position.i == this.i && position.j == j)
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(Object o) {
        return ((Position)o).compareTo(this);
    }
}