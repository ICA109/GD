import CTCI.AssortedMethods;
import CTCI.Q1_7_ModelB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static CTCI.Q1_7_ZeroMatrix.rotate;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Q1_7_Test {

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[1000][0];   //1st value determines number of tests run
    }


    public static int[][] cloneMatrix(int[][] matrix) {
        int[][] c = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                c[i][j] = matrix[i][j];
            }
        }
        return c;
    }


    @Test
    public void testRotate() {
        int nrows = 10;
        int ncols = 15;
        int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);
        int[][] matrix2 = cloneMatrix(matrix1);

        Q1_7_ModelB.setZeros(matrix2);
        rotate(matrix1);

        assertEquals(matrix1, matrix2);
    }
}
