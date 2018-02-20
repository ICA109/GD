import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mix {

    public static void main(String[] args) {

        //Set #1
        int[] sampArr= {-5, 2, 1, -20, 20, 4, 2};  //Expect 4
        System.out.println(sumOfArrayFor(sampArr));
        System.out.println(sumOfArrayWhile(sampArr));
        System.out.println(sumOfArrayRec(sampArr, 0, 0));

        //Set #2
        //System.out.println(Arrays.toString());
        List<Character> one = new ArrayList<Character>();
        one.add('a');
        one.add('b');
        one.add('c');
        List<Integer> two = new ArrayList<Integer>();
        two.add(1);
        two.add(2);
        two.add(3);
        List<Object> ans = combineLists(one, two);
        for (Object i : ans) {
            System.out.print(i);
        }
        System.out.println();

        //Set #3
        //System.out.println(Arrays.toString(fibs(10)));
        //System.out.println(Arrays.toString(fibs(100)));
        System.out.println(fibs(10));
        System.out.println(fibs(100));
    }

    //For-loop
    public static int sumOfArrayFor(int[] arr) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //While-loop
    public static int sumOfArrayWhile(int[] arr) {
        int sum = 0;
        int i = 0;
        while (i < arr.length) {
            sum += arr[i];
            i++;
        }
        return sum;
    }

    //Recursion
    public static int sumOfArrayRec(int[] arr, int i, int sum) {
        if (i == arr.length) {
            return sum;
        }
        sum += arr[i];
        i++;
        return sumOfArrayRec(arr, i, sum);
    }


    //Combine lists
    public static List<Object> combineLists(List<Character> l1, List<Integer> l2) {
        int length;
        List<Object> ans = new ArrayList<>();
        if (l1.size() >= l2.size())
            length = l1.size();
        else
            length = l2.size();
        for (int i=0; i<length; i++) {
            if (i < l1.size())
                ans.add(l1.get(i));
            if (i < l2.size())
                ans.add(l2.get(i));
        }
        return ans;
    }


    //Fibs (actually be careful with data overflow...)
    /*
    public static long[] fibs(int amt) {
        long[] all = new long[amt];
        long n1 = 0;
        long n2 = 1;
        long sum = 0;
        for (int i=1; i<=amt; i++) {
            all[i-1] = n1;
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return all;
    }
    */
    /*
    public static String fibs(int amt) {
        BigInteger[] all = new BigInteger[amt];
        BigInteger n1 = BigInteger.ZERO;
        BigInteger n2 = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        for (int i=1; i<=amt; i++) {
            all[i-1] = n1;
            sum = n1.add(n2);
            n1 = n2;
            n2 = sum;
        }
        return Arrays.toString(all);
    }
    */
    public static String fibs(int amt) {
        BigInteger[] all = new BigInteger[amt];
        all[0] = BigInteger.ZERO;
        all[1] = BigInteger.ONE;
        for (int i=2; i<amt; i++) {
            all[i] = all[i-2].add(all[i-1]);
        }
        return Arrays.toString(all);
    }
}
