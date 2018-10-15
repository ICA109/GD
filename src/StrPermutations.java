import java.util.ArrayList;
import java.util.Arrays;

public class StrPermutations {


    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ABCD";
        String s3= "AAC";

        permutation_wrapper(s1);
        permutation_wrapper(s2);
        permutation_wrapper(s3);

    }


    public static ArrayList<String> permutation_wrapper(String source) {
        ArrayList<String> all_combos = new ArrayList<>();
        permutation("", source, all_combos);
        System.out.println(all_combos);
        return all_combos;
    }

    public static void permutation(String prefix, String remainingSet, ArrayList<String> all_combos) {
        int rsLength = remainingSet.length();
        if (rsLength == 0) {
            all_combos.add(prefix);
        }
        else {
            for (int i=0; i<rsLength; i++) {
                permutation(prefix + remainingSet.charAt(i),
                        remainingSet.substring(0, i) + remainingSet.substring(i+1,rsLength),
                        all_combos);
            }
        }
    }





}
