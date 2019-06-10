package otherProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
    private final Map<String, List<String>> cache = new HashMap<>();

    private boolean containsSuffix(Set<String> dict, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (dict.contains(str.substring(i))) return true;
        }
        return false;
    }

    public List<String> wordBreak(String s, Set<String> dict) {
        if (cache.containsKey(s)) return cache.get(s);
        List<String> result = new LinkedList<>();
        if (dict.contains(s)) result.add(s);
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0,i),
                    right = s.substring(i);
            if (dict.contains(left) && containsSuffix(dict, right)) {
                List<String> list = wordBreak(right, dict);
                for (String ss : list) {
                    result.add(left + " " + ss);
                }
            }
        }
        cache.put(s, result);
        return result;
    }

//    public int numDecodings(String s) {
//        if(s.substring(0,1).equals("0"))
//            return 0;
//
//        List<String> decoded = decode(s);
//        return decoded.size();
//
//    }
//
//    public List<String> decode(String s){
//
//        if(cache.containsKey(s)) return cache.get(s);
//
//        List<String> result = new LinkedList();
//        if(Double.valueOf(s)>Double.valueOf(0) && Double.valueOf(s)<=Double.valueOf(26))
//            result.add(s);
//
//        for(int i=1;i<s.length();i++){
//            String left = s.substring(0,i);
//            String right = s.substring(i);
//
//            if(Double.valueOf(left)>Double.valueOf(0) && Double.valueOf(left)<=Double.valueOf(26)
//                    && containsSuffix(right)){
//                for(String ss : decode(right)){
//                    result.add(left + " "+ ss);
//                }
//            }
//        }
//        cache.put(s,result);
//        return result;
//    }
//
//    public boolean containsSuffix(String s){
//        if(s.substring(0,1).equals("0") || s.substring(0,1).equals(""))
//            return false;
////        for(int i=0;i<3;i++){
////            if(s.substring(i).equals(""))
////                break;
////            if(!s.substring(i).equals("0")) {
////                double val = Double.valueOf(s.substring(i));
////                if (val > Double.valueOf(0) && val <= Double.valueOf(26))
////                    return true;
////            }
////        }
//        if(Integer.valueOf(s.substring(0,1))<=26)
//            return true;
//
//        return false;
//    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        String s = "catsanddog";
        Set<String> wordDict = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        WordBreak2 wordBreak2 = new WordBreak2();
//        List<String> result = wordBreak2.wordBreak(s,wordDict);
//        System.out.print(result.size());
//        System.out.print(result);

        //
        wordBreak2.wordBreak(s,Arrays.asList("cat", "cats", "and", "sand", "dog"));

//        System.out.println(wordBreak2.numDecodings("10"));
    }
}
