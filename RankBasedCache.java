package otherProblems;

import java.security.Key;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class RankBasedCache {

    HashMap<KeyI,Data> cache;
    PriorityQueue<Composit> priorityQueue;
    int size;
    Datasource ds;
    public RankBasedCache(int size,Datasource ds){
        cache = new HashMap<>(size);
        priorityQueue = new PriorityQueue<Composit>(new Comparator<Composit>() {
            @Override
            public int compare(Composit o1, Composit o2) {
                int value =0;
                if(o1.getData().getRank()>o2.getData().getRank())
                    value =  1;
                else if(o1.getData().getRank() < o2.getData().getRank())
                    value = -1;
                else if(o1.getData().getRank() == o2.getData().getRank())
                    value =  0;
                return value;
//                return Integer.valueOf((int) (o1.getData().getRank()-o1.getData().getRank()));
            }
        });
        this.size = size;
        this.ds = ds;
    }

    public Data get(KeyI key){


        if(cache.containsKey(key)) {
            System.out.println("Fetching Key from cache:: "+key.getKey());
            return cache.get(key);
        }

        System.out.println("Fetching Key from DS:: "+key.getKey());
        Data data = ds.getData(key);

        if(cache.size() >= this.size ) {
            Composit composit = priorityQueue.poll();
            System.out.println("Removing Key :: "+composit.getKey().getKey());
            cache.remove(composit.getKey());
        }

        cache.put(key, data);
        Composit composit = new Composit(data,key);
        priorityQueue.add(composit);

        return data;
    }

    public static void main(String [] args){
        RankBasedCache rankBasedCache = new RankBasedCache(5,new Datasource());
        rankBasedCache.get(new KeyI("1"));
        rankBasedCache.get(new KeyI("2"));
        rankBasedCache.get(new KeyI("3"));
        rankBasedCache.get(new KeyI("4"));
        rankBasedCache.get(new KeyI("5"));
        rankBasedCache.get(new KeyI("6"));
        rankBasedCache.get(new KeyI("7"));
        rankBasedCache.get(new KeyI("8"));
        rankBasedCache.get(new KeyI("9"));
    }

}

class Composit{
    Data data;
    KeyI key;

    public Composit(Data data, KeyI key){
        this.data =  data;
        this.key = key;
    }

    public Data getData(){
        return data;
    }

    public KeyI getKey(){
        return key;
    }
}

 class Datasource {
    float rank = (float) 1.32;
    public Datasource(){

    }

    public Data getData(KeyI key){
        Data data = new Data("data"+rank++,rank,key);
        return data;
    }
}

class Data {
    private String data;
    private float rank;
    private KeyI key;


    public  Data(String data, float rank,KeyI key){
        this.data = data;
        this.rank = rank;
        this.key = key;
    }

    public String getData(){
        return data;
    }

    public float getRank(){
        return rank;
    }

}

interface KeyInterface {
        public String getKey();
}

class KeyI{
    private String key;

    public String getKey(){
        return key;
    }

    public  KeyI(String key){
        this.key = key;
    }

    @Override
    public boolean equals(Object keyI){
        if(keyI == null || keyI.getClass() != this.getClass())
            return false;

        return ((KeyI) keyI).getKey().equalsIgnoreCase(this.getKey());
    }

    @Override
    public int hashCode(){
        return this.getKey().hashCode();
    }

    public static int lengthLongestPath(String input) {
        int max = 0;
//        int rIdx =  input.indexOf("\\n\\t");
//        if(rIdx ==-1)
//            return max;
//
//        String root = input.substring(0,rIdx);
//        String path = root+"/";
//
//        input = input.substring(rIdx+4);
//
//        while(input.indexOf("\\n\\t")!=-1 || input.indexOf("\\t")!=-1){
//            rIdx =  (input.indexOf("\\n\\t")!=-1)?input.indexOf("\\n\\t") :input.indexOf("\\t");
//            root = input.substring(0,rIdx);
//            input = input.substring(rIdx+4);
//            if(root.contains(".ext")){
//                String filePath = path+root;
//                max = Math.max(max,filePath.length());
//            }else{
//                path+=root+"/";
//            }
//        }

        Deque<Integer> stack  = new ArrayDeque<>();
        stack.push(0);

        for(String s : input.split("\n")){
            int lev =  s.lastIndexOf("\t")+1; // Total number of \t
            while (lev+1<stack.size()) stack.pop(); //
            int len = stack.peek()+s.length() -lev+1;
            stack.push(len);
            if(s.contains(".")) max = Math.max(max,len-1 );
        }

        return max;
    }

    public static void main(String [] args){
        String temp = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
       // temp = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
       // System.out.println(temp.split("\\@").length);
//        System.out.println(temp.indexOf("\\n\\t"));
//        System.out.println(temp.substring(0, temp.indexOf("\\n\\t")));
//        System.out.println(temp.substring(temp.indexOf("\\n\\t")+4));
        System.out.println(lengthLongestPath(temp));
        String[] strings = temp.split("\n");
        //System.out.println(temp.split("\n"));
        List<int[]> edge =  new ArrayList<>();
        edge.add(new int[]{1,2});
        edge.add(new int[]{1,2,3});

        for(int i = 0;i< edge.size();i++){
            int [] lcl = edge.get(i);
            for (int n : lcl)
                System.out.println(n);
        }
        System.out.println("\t\tfile.ext".lastIndexOf("\t")+1);
    }
}



