package otherProblems.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than
 * K distinct characters.
 */
public class LongestSubstringKDistinct {
    /**
     * Time Complexity #
     * The time complexity of the above algorithm will be O(N) where ‘N’ is the number of characters
     * in the input string.
     * The outer for loop runs for all characters and the inner while loop processes each character only once,
     * therefore the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N).
     *
     * Space Complexity #
     * The space complexity of the algorithm is O(K), as we will be storing a maximum of ‘K+1’ characters in the HashMap.
     *
     */
    public static int findLength(String str, int k) {
        int windowStart = 0;
        int length = 0;
        Map<Character, Integer> wordMap =  new HashMap<>();
        char[] charArr = str.toCharArray();

        for(int windowEnd = 0; windowEnd< charArr.length;windowEnd++){
            char rightCharacter = charArr[windowEnd];
            wordMap.put(rightCharacter, wordMap.getOrDefault(rightCharacter, 0) + 1);

            while (wordMap.size() > k){
                char leftCharacter = charArr[windowStart];
                wordMap.put(leftCharacter,wordMap.get(leftCharacter)-1);

                if(wordMap.get(leftCharacter) == 0){
                    wordMap.remove(leftCharacter);
                }
                windowStart++;
            }

            length = Math.max(length,windowEnd-windowStart+1);

        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
