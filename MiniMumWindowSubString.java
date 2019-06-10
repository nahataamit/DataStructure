package otherProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MiniMumWindowSubString {

    public String minWindow(String s, String t) {

        Set<Character> ts = new HashSet();

        for(int i =0; i<t.length();i++){
            ts.add(t.charAt(i));
        }

        int count = 0 ;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        int lowM = 0;

        for(int col = 0; col< s.length();col++){
            for(char c : ts){
                if(s.charAt(col) == c){
                    count++;
                    if(count == 2)
                        lowM = col;
                    break;
                }
            }

            if(count == ts.size()){
                end = col;
                int length = end-start;
                if(length < min){
                    res = s.substring(start,end+1);
                    min = res.length();
                }

                start = lowM;
                end = lowM;
                count = 0;

            }

        }

        return res;

    }

    public String minWindow1(String s, String t) {
        if(s.length() == 0 || t.length() ==0)
            return "";

        Map<Character, Integer> map = new HashMap();
        // iterate through the target and count the occurances for each character string
        // Start
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, ++count);
            }else{
                map.put(c, 1);
            }
        }
        //End

        Nod head = null;
        Nod pre = head;

        for(int i=0;i< s.length();i++){
            if(t.contains(String.valueOf(s.charAt(i)))){
                if(pre == null){
                    pre = new Nod(i,s.charAt(i));
                    head = pre;
                }else{
                    Nod node = new Nod(i,s.charAt(i));
                    pre.next = node;
                    pre = node;
                }
            }
        }

        Nod start = head;

        String response = "";

        int formed = 0;
        int minL = Integer.MAX_VALUE;

        Map<Character, Visited> visited = new HashMap();

        int min= head.index;
        int max = min;

        while(start !=null){
            Nod next=start;
            min= next.index;
            max = min;

            // deal with the duplicates
            while(formed != map.size()){

                if(next ==null)
                    break;

                char c = next.w;

                Visited visit = null;

                if(!visited.containsKey(c)){
                    visit = new Visited(map.get(c));
                    visit.visit();
                    visit.setIndex(next.index);
                    visited.put(c,visit);
                }else if(! visited.get(c).isVisited()){
                    visit = visited.get(c);
                    visit.setIndex(next.index);
                    visit.visit();
                }

                if(visit !=null && visit.isVisited())
                {
                    formed++;
                }

                if(max < next.index)
                    max = next.index;

                next =  next.next;
            }

            if(formed == map.size()) {
                String newStr = s.substring(min,max+1);//findSubString(visited, s);
                response = newStr.length() < minL ? newStr : response;
                minL = response.length();
            }
            formed = 0;
            start = start.next;
            visited = new HashMap();
        }

        return response;

    }
    public String findSubString(Map<Character, Visited> visitMap, String s){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(Map.Entry<Character,Visited> entry : visitMap.entrySet()){
            Visited visited = entry.getValue();
            if(visited.index < min)
                min = visited.index;
            if(visited.index > max)
                max = visited.index;
        }

        return s.substring(min, max+1);
    }




        public static void main(String [] args){
        MiniMumWindowSubString miniMumWindowSubString = new MiniMumWindowSubString();
       // System.out.println(miniMumWindowSubString.minWindow1("ADOBECODEBANC",
              //  "ABC" ));
            System.out.println(miniMumWindowSubString.minWindow1("aa",
                    "aa" ));
            String ss = "ss";

    }
}

    class Visited {

        int count;
        int visitC;
        int index;

        public Visited (int count){
            this.count = count;
        }

        public boolean isVisited(){
            return visitC == count;
        }

        public void visit(){
            visitC++;
        }

        public void setIndex(int idx){
            this.index = idx > index ? idx : index;
        }
    }
    class Nod{
        int index;
        Character w;
        Nod next;

        public Nod(int index,Character w){
            this.w = w;
            this.index = index;
        }

    }