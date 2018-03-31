import java.util.HashMap;

public class WordScramble {

    public static void main(String[] args) {
        System.out.println(scramble("jaitac", "cat"));
        System.out.println(scramble("ow", "wow"));
        System.out.println(scramble("jaitac", "dog"));
    }

    public static boolean scramble(String sourceCharacters, String sourceString) {

        //(0) Common variables
        HashMap<Character, Integer> hm = new HashMap<>();
        char currChar;
        int currCount;

        //(1) Hash characters and appearance counts into table
        for (int i=0; i<sourceCharacters.length(); i++) {
            currChar = sourceCharacters.charAt(i);

            if (hm.containsKey(currChar)) {
                currCount = hm.get(currChar);
                hm.put(currChar, ++currCount);  //Character appears more than once, increment by 1
            }
            else {
                hm.put(currChar, 1);
            }
        }

        //(2) Now compare source string against candidate character pool
        for (int j=0; j<sourceString.length(); j++) {
            currChar = sourceString.charAt(j);

            if (!hm.containsKey(currChar)) {
                return false;               //Unknown character (key) provided, hence source string is invalid
            }

            currCount = hm.get(currChar);
            hm.put(currChar, --currCount);  //Remove one char count from candidate pool

            if (hm.get(currChar) < 1) {
                hm.remove(currChar);        //Remove character from map altogether if count (value) now beneath 1
            }
        }
        return true;
    }
}
