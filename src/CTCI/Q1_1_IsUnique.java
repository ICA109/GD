package CTCI;

import java.util.HashMap;

/*
Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
 */
public class Q1_1_IsUnique {
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            boolean wordA =  isUniqueWithHash (word);
            System.out.println(word + ": " + wordA);
        }
    }

    public static boolean isUniqueWithHash (String toChk) {
        HashMap<Character, Integer> findDuplicates = new HashMap<Character, Integer>();

        for (int i=0; i<toChk.length(); i++) {
            if (findDuplicates.containsKey(toChk.charAt(i))) {
                return false;   //Map already contains this character, it must be a duplicate
            }
            else {
                findDuplicates.put(toChk.charAt(i), 1); //Place character into map for future comparison
            }
        }
        return true;
    }
}
