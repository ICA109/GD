public class LongestPalindrome {

    public static void main(String[] args) {
        //String s = "aba";
        //String s = "ababc";

        System.out.println(getLongestPalidrome("aaaa"));


    }

    public static String getLongestPalidrome(String input) {
        String answer = "";
        int longestLength = 0;
        int currentLength = 0;
        String currentAnswer = "";
        //int headIndex = 0;
        //int tailIndex = input.length() - 1;

        //Go through each character L to R; testing for a palindrome each time
        /*
        for (char c : input.toCharArray()) {
            for (int i = tailIndex; i >= 0; i--) {
                if ()
            }
            headIndex++;
        }
        */

        //Edge cases
        if (input.length() == 0 || input.length() == 1) {
            return input;
        }

        for (int i=0; i<input.length(); i++) {

            for (int j=input.length()-1; j>i; j--) {

                if (input.charAt(i) == input.charAt(j)) {
                    char c = input.charAt(i);
                    currentLength++;
                    //currentAnswer += c;
                    currentAnswer = c + currentAnswer;
                    currentAnswer = currentAnswer+ c;
                    if (currentLength > longestLength) {
                        answer = currentAnswer;
                        longestLength = currentLength;
                    }
                }
                else {
                    if (currentLength > longestLength) {
                        answer = currentAnswer;
                        if (j-i == 1) {
                            //answer += input.charAt(j);  //Append extra as needed
                            int mid = answer.length() /2;
                            answer = answer.substring(0, mid) + input.charAt(j) + answer.substring(mid);
                        }
                        longestLength = currentLength;
                    }
                }
                //Repeated? (adding this in fixes "aa" but bricks "aba")
                /*
                if (currentLength > longestLength) {
                    answer = currentAnswer;
                    longestLength = currentLength;
                }
                */

                if (i == j) {

                }

            }
            currentAnswer = ""; //Reset for next loop
            currentLength = 0;
        }
        return answer;
    }
}
