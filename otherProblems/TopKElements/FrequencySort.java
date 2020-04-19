package otherProblems.TopKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string, sort it based on the decreasing frequency of its characters.
 * Input: "Programming"
 * Output: "rrggmmPiano"
 * Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.
 */
public class FrequencySort {
    public static String sortCharacterByFrequency(String str) {
        Map<Character,Integer> freqMap =  new HashMap<>();

        for(char ch : str.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<Map.Entry<Character,Integer>>(
                (e1,e2)-> (e2.getValue()-e1.getValue())
        );

        maxHeap.addAll(freqMap.entrySet());

        StringBuilder stringBuilder = new StringBuilder();

        while (!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> entry = maxHeap.poll();
            for (int i=0;i<entry.getValue();i++){
                stringBuilder.append(entry.getKey());
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
