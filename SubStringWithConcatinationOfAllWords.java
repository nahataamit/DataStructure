package otherProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

public class SubStringWithConcatinationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        HashMap<String,List<Integer>> wordIndexMap = new HashMap();
        List<Integer> intervenStartIndex = new ArrayList();

        int totalwordLength = 0;

        String opword = s;

        int size = 0;

        for(String word : words ){

            List<Integer> indexList = new ArrayList();

            int nextStartIndex = 0;
            while(opword.indexOf(word)!=-1){
                int ind = nextStartIndex + opword.indexOf(word);
                indexList.add(ind);
                if(ind+word.length()<opword.length())
                opword = opword.substring(ind+word.length());
                else opword = "";
                nextStartIndex +=ind+word.length();
            }
            size = Math.max(size,indexList.size());
            wordIndexMap.put(word,indexList);
            opword = s;
            totalwordLength+=word.length();
        }



        for(int i=0;i<size;i++){
            List<Integer> freList = new ArrayList();
            int start = Integer.MAX_VALUE;
            int end = -1;

            int localCount = 0;
            for(String word : words){
                // check index
                if(i<wordIndexMap.get(word).size()) {
                    start = Math.min(start, wordIndexMap.get(word).get(i));
                    end = Math.max(end, wordIndexMap.get(word).get(i) + word.length() - 1);
                    localCount++;
                }

            }

            if(end-start == totalwordLength-1 && localCount == words.length)
                intervenStartIndex.add(start);
        }

        return intervenStartIndex;

    }

    /**
     * "wordgoodstudentgoodword"
     ["word","student"]
     "wordgoodgoodgoodbestword"
     ["word","good","best","word"]
     "barfoothefoobarman"
     ["foo","bar"]
     "barfoofoobarthefoobarman"
     ["bar","foo","the"]
     * @param args
     */
    public static void main(String[] args){
        SubStringWithConcatinationOfAllWords sub = new SubStringWithConcatinationOfAllWords();
//        List<Integer> startIndexList = sub.findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","word"});
        List<Integer> startIndexList = sub.findSubstring("barfoofoobarthefoobarman",new String[]{"bar","foo","the"});

        for(int start : startIndexList){
            System.out.println(start);
        }



    }

}
