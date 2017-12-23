import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class CommonInts {

    public static void main(String[] args) {
        ArrayList<int[]> testCases = new ArrayList<int[]>();

        int[] a1 = {9, -3, 4, 6, 2, 10, 10, -99};
        int[] a2 = {14, 3, 15, 6, 9, 10, 15, 17, 9, -99};
        int[] expectedOut = {-99, 6, 9, 10};


        System.out.println("Input: " + Arrays.toString(a1) + " " + Arrays.toString(a2));
        System.out.println("Output (Actual):   " + Arrays.toString(rmDuplicate(a1, a2)));
        System.out.println("Output (Expected): " + Arrays.toString(expectedOut));
        System.out.println("------------------");

    }

    public static int[] rmDuplicate(int[] array1, int[] array2) {
        //Note: Case-sensitive so B != b
        //int[] toReturn = new int[array1.length + array2.length];    //Or could simply choose smaller of the 2 with int

        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>(); //For array 1
        Hashtable<Integer, Integer> ht2 = new Hashtable<Integer, Integer>(); //For array 2 (to avoid issue of internal duplicates)

        //First Map contents of array 1 into hashtable: O(n)
        for (int i = 0; i < array1.length; i++) {
            ht.put(array1[i], array1[i]);
        }

        //Now for every element in array 2, if it exists in ht -> then duplicate -> therefore add to returned int[]
        for (int j = 0; j<array2.length; j++) {
            if(ht.containsKey(array2[j]))
                ht2.put(array2[j], array2[j]);
                //toReturn[j] = array2[j];
        }

        ArrayList<Integer> tmpProcess = new ArrayList<Integer>(ht2.values());
        int[] toReturn = new int[tmpProcess.size()];

        for (int k = 0; k<tmpProcess.size(); k++) {
            toReturn[k] = tmpProcess.get(k);
        }

        Arrays.sort(toReturn);  //Not actually needed, just used for clarity. Note works in-place on original array

        return toReturn;
    }

}
