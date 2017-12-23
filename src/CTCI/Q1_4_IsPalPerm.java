package CTCI;

import java.util.HashMap;

/*
Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words
-> TLDR; can input string be rearranged into a palindrome?
 */
public class Q1_4_IsPalPerm {
    public static void main(String[] args) {

        String[] strings = {"aaa", "bbbb", "Tact Coa","Rats live on no evil star", "A man a plan a canal panama", "A man, a plan, a canal, panama","Lleve", "Tacotac", "asda"};
        //String[] strings = {"TAC TCC O CATT"};
        //String[] strings = {"Tact Coa"};
        //String[] strings = {"A man, a plan, a canal, panama"}; //Outcome depends on whether or not we ignore punctuation

        for (String s : strings) {
            boolean a = canCreatePalPerm(s);
            System.out.println(s);
            System.out.println("Agree: " + a);
            System.out.println();
        }

    }

    public static boolean canCreatePalPerm (String toChk) {

        toChk = toChk.toLowerCase();    //This implementation ignores casing (treats all characters as valid in any position)
        int strLen = 0;                 //We need the length of the string ignoring spaces (and other non-letter entries)
        for (int i=0; i<toChk.length(); i++) {
            if (toChk.charAt(i) >= 97 && toChk.charAt(i) <= 122)
                strLen++;
        }

        //Generate frequency table
        HashMap<Character, Integer> repOfA = new HashMap<Character, Integer>();
        for (int i=0; i<toChk.length(); i++) {
            char tmp = toChk.charAt(i);
            if (tmp < 97 || tmp > 122) {
                continue;   //Ignore all non-letters -> i.e. spaces
            }
            else {
                if (repOfA.containsKey(tmp)) {
                    repOfA.put(tmp, repOfA.get(tmp) + 1);
                } else {
                    repOfA.put(tmp, 1);
                }
            }
        }

        /*
        //For testing contents
        for (HashMap.Entry<Character, Integer> entry : repOfA.entrySet()) {
            Character aChar = entry.getKey();
            Integer aCount = entry.getValue();
            System.out.println("Character: " + aChar + " Count: " + aCount);  //For testing contents
        }
       */

        //Even-length strings require all characters to be perfectly "paired off" (even freq. count)
        if (strLen%2 == 0) {
            for (HashMap.Entry<Character, Integer> entry : repOfA.entrySet()) {
                Character aChar = entry.getKey();   //Not actually needed...
                Integer aCount = entry.getValue();
                if (aCount%2 != 0) {
                    //System.out.println("Case 1: " + aChar);
                    return false; //Unpaired character exists
                }
            }
        }
        //Odd-length strings require all but one "extra" character to be perfectly "paired off"
        else {
            int numUnpaired = 0;
            for (HashMap.Entry<Character, Integer> entry : repOfA.entrySet()) {
                if (numUnpaired > 1) {
                    return false;
                }
                Integer aCount = entry.getValue();
                if (aCount%2 != 0) {
                    //System.out.println("Case 2");
                    numUnpaired ++; //Unpaired character exists
                }
            }
        }

        return true;
    }

}
