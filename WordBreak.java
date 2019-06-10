package otherProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);

        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args){
        WordBreak wordBreak = new WordBreak();
       // wordBreak.wordBreak( "catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat" }));
        String string = "catsanddog";
        System.out.println(string.substring(0,0));
        System.out.println(string.substring(0,1));
        System.out.println(string.substring(0,2));
    }
}
