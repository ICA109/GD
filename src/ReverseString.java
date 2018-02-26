public class ReverseString {
    /* Too slow, fails final test case...
    public String reverseString(String s) {
        String reversed = "";

        for (int i=s.length()-1; i>=0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }
    */
    public String reverseString(String s) {
        char[] reversed = new char[s.length()];
        int j = s.length()-1;

        for (int i=0; i<s.length(); i++) {
            reversed[i] += s.charAt(j);
            j--;
        }

        return String.valueOf(reversed);
    }
}
