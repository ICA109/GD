/**
 * Created by tonyyin on 7/26/17.
 */
public class ReverseInteger {

    //Issues: (1) Need to handle int overflows, (2) Need to cut leading 0's
    public static void main(String[] args) {
        int x = 123;
        x = 1000;       //Should be 1
        x = -123;       //Should be -321
        x = 1000000003; //Should be 0 (int overflow)
        System.out.println("\n-reverse()-");
        System.out.println("Result: " + reverse(x));
        System.out.println("\n-reverseStringPrinter()-");
        reverseStringPrinter(15);
    }

    //Passed all test cases LOL...
    public static int reverse(int x) {
        String strRep = Integer.toString(x);
        StringBuilder sb = new StringBuilder();
        int stopIndex = 0;

        //Handle negatives
        if (strRep.charAt(0) == '-') {
            stopIndex = 1;
            sb.append('-');
        }

        for (int i = strRep.length() - 1; i >= stopIndex; i--) {
            sb.append(strRep.charAt(i));
        }
        String rvStr = sb.toString();
        System.out.println("Final string: " + rvStr);

        //  try/catch block resolves int-overflow issues (as catch checks if INTEGER.MAX_VALUE is triggered)
        try {
            return Integer.parseInt(rvStr);    //Already handles leading 0's issue
        }
        catch (NumberFormatException ex) {
            return  0;
        }
    }

    public static void reverseStringPrinter(int n) {
        for (int i=1; i<=n; i++) {
            if (i%3 == 0 && i%5 == 0) {
                System.out.println("FizzBuzz");
            }
            else if (i%3 == 0) {
                System.out.println("Fizz");
            }
            else if (i%5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }

}
