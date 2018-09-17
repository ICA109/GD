import java.io.*;
import java.util.*;

public class String_MakeAnagram {
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int numDel = 0;
        int[] aAlpha = new int[26];
        int[] bAlpha = new int[26];

        for (char c1: a.toCharArray()) {
            aAlpha[c1-97] += 1;
        }
        for (char c2: b.toCharArray()) {
            bAlpha[c2-97] += 1;
        }

        for (int i=0; i<26; i++) {
            numDel += Math.abs(bAlpha[i] - aAlpha[i]);
        }
        return numDel;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }



}
