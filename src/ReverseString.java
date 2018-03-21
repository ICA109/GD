import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("ab".toCharArray()));
        System.out.println(reverseString("abc".toCharArray()));
        System.out.println(reverseString("abcd".toCharArray()));
        System.out.println(reverseString("".toCharArray()));
    }

    /* Too slow, fails final test case...
    public String reverseString(String s) {
        String reversed = "";

        for (int i=s.length()-1; i>=0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }
    */
    public static String reverseString(String s) {
        char[] reversed = new char[s.length()];
        int j = s.length()-1;

        for (int i=0; i<s.length(); i++) {
            reversed[i] += s.charAt(j);
            j--;
        }

        return String.valueOf(reversed);
    }

    //Using an char array
    public static String reverseString(char[] s) {
        int il = 0, ir = s.length-1;
        char tmp;
        while (il < ir) {
            tmp = s[il];
            s[il] = s[ir];
            s[ir] = tmp;
            il++;
            ir--;
        }
        return Arrays.toString(s);
    }
}
