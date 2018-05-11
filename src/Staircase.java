public class Staircase {

    static void staircase(int n) {
        /*
         * Write your code here.
         */
        int numSpaces;
        int level = 1;
        while (level <= n) {
            numSpaces = n - level;
            for (int i=0; i<n; i++) {
                if (i < numSpaces) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("#");
                }
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        staircase(6);
    }
}
