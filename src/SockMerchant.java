import java.util.HashMap;

public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> sockCountsByType = new HashMap<Integer, Integer>();
        int numPairs = 0;

        for (int i=0; i<ar.length; i++) {
            if (sockCountsByType.containsKey(ar[i])) {
                int prevCount = sockCountsByType.get(ar[i]);
                sockCountsByType.put(ar[i], prevCount+1);
            }
            else {
                sockCountsByType.put(ar[i], 1);
            }
        }

        for (int j : sockCountsByType.values()) {
            numPairs += (j/2);
        }

        return numPairs;
    }
}
