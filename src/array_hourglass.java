import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class array_hourglass {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxSum = arr[0][0] + arr[2][0] + arr[2][1] + arr[0][1] + arr[1][1] + arr[0][2] + arr[2][2];


        boolean firstHourglass = true;
        for (int r=1; r<=4; r++) {
            for (int c=1; c<=4; c++) {
                int aSum = arr[r-1][c-1] + arr[r+1][c-1] + arr[r+1][c] + arr[r-1][c] + arr[r][c] + arr[r-1][c+1] + arr[r+1][c+1];
                if (aSum > maxSum) {
                    maxSum = aSum;
                }
            }
        }
        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
