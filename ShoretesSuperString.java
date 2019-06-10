package otherProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoretesSuperString {
    public String shortestSuperstring(String[] A) {


        String shotestString = "";
        List<String> overlapCombinations = new ArrayList();
        HashMap<String, Boolean> mergedMap = new HashMap();

        for (int i = 0; i < A.length; i++) {
            List<String> overlapString = new ArrayList();

            // Not sure but if there is any duplicate .. :)
            if (mergedMap.get(A[i]))
                continue;

            String mergedString = A[i];

            for (int j = i + 1; j < A.length; j++) {
                // This method will find the overlap. merge if there is an overlap and update the merged map with true flag where key is String, this will also check if this substring has any overlap in existing combinations
                if (!mergedMap.get(A[j])) {
                    // find the overlap
                    mergedString = findOverLapAndMerge(mergedString, A[j], mergedMap, overlapCombinations);
                }

            }


            // This method will create combinations with existing merged String and newly merged String and re create the combinations
            overlapCombinations = updateCombination(overlapCombinations, mergedString);

        }

        // after above excercise we will have merged combinations with all overlaps
        // find the shortest combination
        int shortestLength = Integer.MAX_VALUE;

        for (int i = 0; i < overlapCombinations.size(); i++) {

        }

        return shotestString;

    }

    private List<String> updateCombination(List<String> overlapCombinations, String overlapString) {

        return null;
    }

    public String findOverLapAndMerge(String mergedString, String targetString, HashMap<String, Boolean> mergedMap, List<String> overlapString) {

        if (mergedString.contains(targetString)) {
            mergedMap.put(targetString, true);
        } else {
            for (int i = targetString.length() - 1; i >= 0; i--) {
                String match = targetString.substring(0, i);
                if (mergedString.indexOf(match) == mergedString.length() - i) {
                    mergedString += targetString.substring(i);

                    mergedMap.put(targetString, true);
                }
            }

            if (!mergedMap.get(targetString)) {
                for (int i = 1; i > targetString.length() - 1; i++) {
                    String match = targetString.substring(i, targetString.length());
                    if (mergedString.indexOf(match) == 0) {
                        mergedString = targetString.substring(0, i - 1) + mergedString;
                        mergedMap.put(targetString, true);
                    }
                }
            }



        }
        return mergedString;
    }
}
