package CTCI;

public class Q1_9_StringRotate {

    public static void main(String[] args) {
        String[][] pairs = {{"pleap", "apple"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length() && s1.length() > 0) {
            String extendedStr = s1 + s1;
            if (extendedStr.indexOf(s2) >= 0) {
                return true;
            }
        }
        return false;
    }
}
