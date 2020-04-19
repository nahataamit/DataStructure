package otherProblems.SubSets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find all of its permutations preserving the character sequence but changing case.
 * Input: "ab7c"
 * Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 */

/**
 * time complexity
 *
 */
public class StringPermutationsByChangingCase {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);

        for(int i=0;i<str.length();i++){
            if(Character.isLetter(str.charAt(i))){
                int n = permutations.size();
                for (int j=0;j<n;j++){
                    char[] chars = permutations.get(j).toCharArray();
                    if(Character.isUpperCase(chars[i])){
                        chars[i] = Character.toLowerCase(chars[i]);
                    }else {
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                    permutations.add(String.copyValueOf(chars));
                }
            }
        }

        return permutations;
    }


    public static void main(String[] args) {
        List<String> result = StringPermutationsByChangingCase.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = StringPermutationsByChangingCase.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
