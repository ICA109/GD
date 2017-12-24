package CTCI;

public class Q1_3_URLify {

    public static void main(String[] args) {
        String sample = "Mr John Smith    ";
        char[] tester = sample.toCharArray();
        substitution(tester, 13);
        String tmp = new String(tester);
        System.out.println("New output: " + tmp);
    }

    //In-place modification
    public static void substitution(char[] input, int trueLen) {
        int numSpaces = 0;  //Count number of spaces
        int cIndex = 0;     //Track current index to edit

        for (int i=0; i<trueLen; i++) {
            if (input [i] == ' ')
                numSpaces++;
        }

        cIndex = trueLen + numSpaces * 2 - 1; //Replace " " with "%20"
        for (int j=trueLen-1; j>=0; j--) {
            if (input[j] == ' ') {
                input[cIndex] = '0';
                input[cIndex - 1] = '2';
                input[cIndex - 2] = '%';
                cIndex -= 3;
            }
            else {
                input[cIndex] = input[j];
                cIndex -= 1;
            }
        }
    }
}
