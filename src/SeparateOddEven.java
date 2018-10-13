import java.util.Arrays;

public class SeparateOddEven {


    public static void main(String[] args) {
        int[] t1 = {1, 2, 2, 2, 1};
        int[] t2 = {};
        int[] t3 = {3, 4};
        int[] t4= {5, 2, 7, 9, 2, 3, 8, 4};

        divideArray(t1);
        divideArray(t2);
        divideArray(t3);
        divideArray(t4);

        divideArrayInPlace(t1);
        divideArrayInPlace(t2);
        divideArrayInPlace(t3);
        divideArrayInPlace(t4);

    }

    public static void divideArray(int[] source) {
        int evenIndex = 0;
        int oddIndex = source.length-1;
        int[] destination = new int[source.length];

        for (int i=0; i<source.length; i++) {

            if(source[i]%2 == 0) {
                destination[evenIndex] = source[i];
                evenIndex++;
            }

            else {
                destination[oddIndex] = source[i];
                oddIndex--;
            }
        }
        System.out.println(Arrays.toString(destination));
    }


    public static void divideArrayInPlace(int[] source) {
        int oddCount = 0;
        for (int i=0; i<source.length; i++) {

            if(source[i]%2 == 0) {
                int tmp = source[i-oddCount];
                source[i-oddCount] = source[i];
                source[i] = tmp;
            }
            else {
                oddCount++;
            }
        }
        System.out.println(Arrays.toString(source));
    }
}
