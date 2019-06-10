package otherProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinPower {
    public static int minPower(List<Integer> p) {

        // start the minPower with the lowest value+1
        int minPower = p.get(0)>0?0:(p.get(0)*-1)+1;

        int currentPower = minPower;

        int index = 0;
        int size = p.size();
        // iterate through the loop
        while(index <= size-1){
            currentPower +=p.get(index);
            if(currentPower >=1){
                index++;
            }else{
                index = 0;
                currentPower = ++minPower;
            }
        }
        return minPower;
    }

    public static void main(String[] args){
      //List<Integer> list =  Arrays.asList(-5,4,-2,3,1,-1,-6,-1,0,-5);
        List<Integer> list =  Arrays.asList(10,2,-10,3,4,-2);
        MinPower minPower = new MinPower();
        System.out.println(minPower.minPower(list));

    }
}
