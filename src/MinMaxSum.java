import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class MinMaxSum {

    /*
     * Complete the miniMaxSum function below.
     */
    static void miniMaxSum(int[] arr) {
        /*
         * Write your code here.
         */

        long fiveSum = 0;
        long tMin = 0;
        long tMax = 0;

        //1st loop collects sum of all 5 integers
        for (int i=0; i<5; i++) {
            fiveSum += arr[i];
        }

        tMin = fiveSum - arr[0]; //Start with exclusion of 1st element as initial guess
        tMax = tMin;

        //2nd loop determines index-by-index min/max
        for (int j=0; j<5; j++) {
            if (fiveSum - arr[j] > tMax) {
                tMax = fiveSum - arr[j];
            }
            if (fiveSum - arr[j] < tMin) {
                tMin = fiveSum - arr[j];
            }
        }

        System.out.println(tMin + " " + tMax);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        miniMaxSum(arr);    //Expected: "10 14"
    }
}

