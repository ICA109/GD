import java.util.*;

public class InsertionSortP1 {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {

        int toInsert = arr[arr.length-1];

        for (int i=arr.length-1; i>0; i--) {

            if (arr[i-1] > toInsert) {
                arr[i] = arr[i-1];
                printArray(arr);
            }
            else {
                arr[i] = toInsert;
                printArray(arr);
                break;
            }
        }
    }

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 3};
        insertionSort1(5, arr);
    }
}
