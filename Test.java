package otherProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String [] args){
        List<Integer> list  = new ArrayList<Integer>();
        list.add(0,2);
        list.add(0,3);

        HashMap<String, String> map =  new HashMap<>();

        list.listIterator();


        for(int a : list){
        System.out.print(a);
        }
    }
}
