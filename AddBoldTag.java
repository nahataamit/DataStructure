package otherProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddBoldTag {
    public String addBoldTag(String s, String[] dict){
        boolean [] bold = new boolean[s.length()];
        for(int i =0,end = 0; i< s.length();i++){
            for(String word : dict){
                if(s.startsWith(word,i )){
                    end = Math.max(end, i+word.length());
                }

            }
// MArk all the positions with true which would be marked as bols
            bold[i] = end > i;
        }

        StringBuilder result =  new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(!bold[i])
            {
                result.append(s.charAt(i));
                continue;
            }

            int j = i;
            while(j<s.length() && bold[j]) j++;
            result.append("<b>"+s.substring(i,j)+"</b>");
            i = j-1;
        }

        return result.toString();
    }

    public static void main(String[] args){
        String s = "aaabbcc";
        String[] dict = {"aaa","aab","bc"};

        AddBoldTag addBoldTag = new AddBoldTag();
        System.out.println(addBoldTag.addBoldTag(s,dict ));

        int[] arr = new int[] {2,1,5};
        Arrays.sort(arr);
        System.out.println(arr.toString());

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-1);
        list.add(3);

        Collections.sort(list);

    }
}
