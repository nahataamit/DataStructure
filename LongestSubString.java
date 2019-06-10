package otherProblems;

import java.util.HashMap;

public class LongestSubString {
    public int lengthOfLongestSstring(String s){
        if (s.length()==0) return 0;
        HashMap<Character,Integer> wordMap = new HashMap<>();
        int startIndex = 0;
        int maxLength = 0;

        for(int i=0;i<s.length();i++){

            if(wordMap.containsKey(s.charAt(i))) {

                startIndex = Math.max(wordMap.get(s.charAt(i))+1,startIndex);

            }

            wordMap.put(s.charAt(i),i);
            maxLength = Math.max(maxLength,i-startIndex+1);
        }

        return maxLength;

    }
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        String substr = "";
        int subStrLength = 0;


        for(int i=0;i<length;i++){
            if(!substr.contains(String.valueOf(s.charAt(i)))){
                substr+=s.charAt(i);
            }else{
                if(subStrLength<=substr.length()){
                    subStrLength = substr.length();
                    int index = substr.indexOf(s.charAt(i));
                    if(index == i)
                        substr = String.valueOf(s.charAt(i));
                    else if(index<substr.length()-1){
                        substr = substr.substring(index+1,substr.length());
                        substr += String.valueOf(s.charAt(i));
                    }else {
                        substr ="";
                    }

                }
            }
        }

        if(substr.length()>subStrLength)
        {
            subStrLength = substr.length();
        }

        return subStrLength;
    }

    public static void main(String [] args ){
        String test = "jbpnbwwd";
        test = " ";
        test = "abba";
        test = "abcabcbb";
        StringBuilder sb = new StringBuilder(test);
        sb.setCharAt(0,'_');
        System.out.println(sb.toString());

//        LongestSubString longestSubString = new LongestSubString();
//       // System.out.print(longestSubString.lengthOfLongestSstring(test));
//        char str1[] = "abcdef".toCharArray();
//        char str2[] = "zbcdf".toCharArray();
//        System.out.println(longestSubString.longestCommonSubstringRecWithoutequalcheck(str1,str2,str1.length-1,str2.length-1,false));
    }

    /**
     * Longest Common SubString Using dynamic Programming
     */

    public int longestCommonSubstrDyn(String str1, String str2){
        int[][] T = new int[str1.length()+1][str2.length()];
        int max= 0;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        for(int i=1;i<str1.length();i++){
            for(int j=1;j<str2.length();j++){
                if(s1[i]==s2[j]){
                    T[i][j] = T[i-1][j-1]+1;
                    max = Math.max(max,T[i][j]);
                }else{
                    T[i][j] = 0;
                }
            }
        }

        return max;
    }

    /**
     * Same problem with recursion and dynamic programming
     */
    public int longestCommonSubstringRec(char str1[], char str2[], int pos1, int pos2, boolean checkEqual){
        if(pos1 == -1 || pos2 == -1){
            return 0;
        }
        if(checkEqual){
            if(str1[pos1] == str2[pos2]){
                return 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
            }else{
                return 0;
            }
        }
        int r1 = 0;
        if(str1[pos1] == str2[pos2]){
            r1 = 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
        }
        return Math.max(r1,Math.max(longestCommonSubstringRec(str1, str2, pos1-1, pos2, false), longestCommonSubstringRec(str1, str2, pos1, pos2-1,false)));
    }

    public int longestCommonSubstringRecWithoutequalcheck(char str1[], char str2[], int pos1, int pos2, boolean checkEqual){
        if(pos1 == -1 || pos2 == -1){
            return 0;
        }
//        if(checkEqual){
//            if(str1[pos1] == str2[pos2]){
//                return 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
//            }else{
//                return 0;
//            }
//        }
        int r1 = 0;
        if(str1[pos1] == str2[pos2]){
            r1 = 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
        }

        return Math.max(r1,Math.max(longestCommonSubstringRec(str1, str2, pos1-1, pos2, false), longestCommonSubstringRec(str1, str2, pos1, pos2-1,false)));
    }
}
