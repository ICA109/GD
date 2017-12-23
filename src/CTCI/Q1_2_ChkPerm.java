package CTCI;

import java.util.HashMap;

/*
Given two strings, write a method to decide if one is a permutation of the
other.
 */
public class Q1_2_ChkPerm {

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

    public static boolean isPermutation (String a, String b) {
        HashMap<Character, Integer> repOfA = new HashMap<Character, Integer>();

        if (a.length() != b.length()) {
            return false;
        }

        //Store contents esp. character counts of 1st string
        for (int i=0; i<a.length(); i++) {
            char tmp = a.charAt(i);
            if (repOfA.containsKey(tmp)) {
                repOfA.put(tmp, repOfA.get(tmp) + 1);
            }
            else {
                repOfA.put(tmp, 1);
            }
        }

        //Now compare 2nd string against HashMap to see if all characters are used correctly
        for (int j=0; j<b.length(); j++) {
            char tmp = b.charAt(j);
            if (repOfA.containsKey(tmp) && repOfA.get(tmp) > 0) {
                repOfA.put(tmp, repOfA.get(tmp) - 1);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
