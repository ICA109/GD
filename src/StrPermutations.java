import java.util.ArrayList;
import java.util.HashSet;

public class StrPermutations {

    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ABCD";
        String s3= "AAC";

        permutation_wrapper(s1);
        permutation_wrapper(s2);
        permutation_wrapper(s3);
    }

    private static void permutation_wrapper(String source) {
        //ArrayList<String> processed_combos = new ArrayList<>();
        HashSet<String> unique_combos_set = new HashSet<>();

        permutation("", source, unique_combos_set);

        /*
        //  replaced by below bulk call to addAll()
        for (String a_combo : unique_combos_set) {
            processed_combos.add(a_combo);
        }
        */

        //processed_combos.addAll(unique_combos_set);

        ArrayList<String> processed_combos = new ArrayList<>(unique_combos_set);

        System.out.println(processed_combos);
    }

    private static void permutation(String prefix, String remainingSet, HashSet<String> unique_combos_set) {
        int rsLength = remainingSet.length();
        if (rsLength == 0) {
            unique_combos_set.add(prefix);
        }
        else {
            for (int i=0; i<rsLength; i++) {
                permutation(prefix + remainingSet.charAt(i),
                        remainingSet.substring(0, i) + remainingSet.substring(i+1,rsLength),
                        unique_combos_set);
            }
        }
    }
}
