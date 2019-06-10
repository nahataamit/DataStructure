package otherProblems;

import java.util.HashMap;

public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder ans = new StringBuilder();
        int X = 0;
        for (int shift: shifts)
            X = (X + shift) % 26;

        for (int i = 0; i < S.length(); ++i) {
            int index = S.charAt(i) - 'a';
            ans.append((char) ((index + X) % 26 + 97));
            X = Math.floorMod(X - shifts[i], 26);
        }

        return ans.toString();
    }

    public static void main(String[] args){
        ShiftingLetters shiftingLetters = new ShiftingLetters();
        System.out.println(shiftingLetters.shiftingLetters("bad", new int[]{10,20,30}));
    }
}
