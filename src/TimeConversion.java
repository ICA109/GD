import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String milTime = "";
        String sHr = "";
        int iHr;

        iHr = Integer.parseInt(String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(1)));

        //Pad iHr if PM time, or reset to 0 in case of 12AM
        if (s.charAt(s.length()-2) == 'P') {
            if (iHr != 12) {
                iHr += 12;
            }
        }
        else {
            if (iHr == 12) {
                iHr = 0;
            }
        }

        //Convert hours to string representation
        sHr = String.valueOf(iHr);
        if (sHr.length() < 2) {
            sHr = "0" + sHr;
        }

        //Append remainder of time info
        milTime = sHr + s.substring(2, 8);

        return milTime;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(timeConversion("07:05:45PM"));
    }
}
