import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;


public class GradingStudents {
    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        /*
         * Write your code here.
         */

        int rounded;

        for (int i=0; i<grades.length; i++) {
            rounded = (grades[i]) % 5;
            if (grades[i] >= 38 && (rounded == 4 || rounded == 3)) {
                grades[i] += 5 - rounded;
            }
        }

        return grades;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] testGrades = {73, 67, 38, 33};
        System.out.println(Arrays.toString(gradingStudents(testGrades)));
    }
}
