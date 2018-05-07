package CTCI;

public class Q1_7_ZeroMatrix {

    public static void main(String[] args) {
        int nrows = 10;
        int ncols = 15;
        int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);
        int[][] matrix2 = cloneMatrix(matrix1);

        AssortedMethods.printMatrix(matrix1);

        //QuestionA.setZeros(matrix1);
        //QuestionB.setZeros(matrix2);

        Q1_7_ModelB.setZeros(matrix2);

        rotate(matrix1);

        System.out.println();

        AssortedMethods.printMatrix(matrix1);
        System.out.println();
        AssortedMethods.printMatrix(matrix2);

        if (matricesAreEqual(matrix1, matrix2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }


    public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }

        for (int k = 0; k < m1.length; k++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[k][j] != m2[k][j]) {
                    return false;
                }
            }
        }
        return true;
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


    public static void rotate(int[][] original) {

        int[][] copyOfOrg = cloneMatrix(original);
        for (int m=0; m<original.length; m++) {
            for (int n=0; n<original[m].length; n++) {
                if (copyOfOrg[m][n] == 0) {
                    //Set rows and columns to 0 (relative to original)
                    for (int i=0; i<original.length; i++) {
                        original[i][n] = 0;
                    }
                    for (int j=0; j<original[m].length; j++) {
                        original[m][j] = 0;
                    }
                    //break;
                }
            }
        }
    }
}
