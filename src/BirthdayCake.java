import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BirthdayCake {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {

        int maxHeight = 0;
        int candleCount = 0;

        for (int i : ar) {
            if (i > maxHeight) {
                maxHeight = i;
                candleCount = 1;
            }
            else if (i == maxHeight) {
                candleCount++;
            }
        }
        return candleCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] arr = {3, 2, 1, 3};
        System.out.println(birthdayCakeCandles(arr));
    }
}

