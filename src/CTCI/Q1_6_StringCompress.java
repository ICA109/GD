package CTCI;

public class Q1_6_StringCompress {

    public static void main(String[] args) {

        System.out.println(compress(""));
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("aaaaabbbbaaaabbddc"));
    }

    public static String compress(String original) {
        char prevChar;
        int compCount;
        String compressed;

        try {
            prevChar = original.charAt(0);  //Initial values
            compCount = 1;                  //Assuming string is always at least one character long
            compressed = "";
        }
        catch (StringIndexOutOfBoundsException ex) {
            System.out.print("Error. Empty string cannot be compressed.");
            return "";
        }

        for (int i=1; i<original.length(); i++) {
            if (original.charAt(i) == prevChar) {
                compCount++;
            } else {
                compressed += prevChar;
                compressed += compCount;
                prevChar = original.charAt(i);
                compCount = 1;  //The new character itself needs to be counted

            }
            //For last segment
            if (i == original.length() -1 ) {
                compressed += prevChar;
                compressed += compCount;
                return compressed;
            }
        }
        return compressed;
    }
}
