public class DiagonalSum {

    static int diagonalDifference(int[][] a) {
        /*
         * Write your code here.
         */
        int r, cp, cs, pSum, sSum;
        r = cp = pSum = sSum = 0;
        cs = a.length - 1;
        while (r < a.length) {
                pSum += a[r][cp];
                sSum += a[r][cs];
                r++;
                cp++;
                cs--;
        }
        return Math.abs(pSum -sSum);
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(diagonalDifference(test));
    }
}
