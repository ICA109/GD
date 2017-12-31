package CTCI;

/*
There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
 */
public class Q1_5_OneAway {
    public static void main(String[] args) {
        //Default CTCI test cases
        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};
        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");
            test(a, b, expected);
            test(b, a, expected);
        }
    }

    //3 cases to deal with depending on lengths
    public static boolean isOneAway(String before, String after) {
        //Replace at most 1 char
        if (before.length() == after.length()) {
            int numDiff = 0;
            for (int i = 0; i < before.length(); i++) {
                if (before.charAt(i) != after.charAt(i))
                    numDiff++;
            }
            if (numDiff > 1)
                return false;
        }
        //Insert
        else if (before.length() + 1 == after.length()) {
            int numDiff, indexBefore, indexAfter;
            numDiff = indexBefore = indexAfter = 0;
            while (indexBefore < before.length() && indexAfter < after.length()) {
                if (before.charAt(indexBefore) != after.charAt(indexAfter)) {
                    numDiff++;
                    indexAfter++;
                }
                else {
                    indexBefore++;
                    indexAfter++;
                }
            }
            if (numDiff > 1)
                return false;
        }
        //Remove
        else if (before.length() - 1 == after.length()) {
            int numDiff, indexBefore, indexAfter;
            numDiff = indexBefore = indexAfter = 0;
            while (indexBefore < before.length() && indexAfter < after.length()) {
                if (before.charAt(indexBefore) != after.charAt(indexAfter)) {
                    numDiff++;
                    indexBefore++;
                }
                else {
                    indexBefore++;
                    indexAfter++;
                }
            }
            if (numDiff > 1)
                return false;
        }
        if (Math.abs(after.length() - before.length()) > 1)
            return false; //Removed or inserted more than 1 character
        return true;
    }

    //Tester
    public static void test(String a, String b, boolean expected) {
        boolean resultA = isOneAway(a, b);
        boolean resultB = isOneAway(a, b);
        if (resultA == expected && resultB == expected) {
            System.out.println(a + ", " + b + ": success");
        }
        else {
            System.out.println(a + ", " + b + ": error");
        }
    }


}
