import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {


    public static void main(String[] args) {

        System.out.println(fizzBuzz(15).toString());
    }

    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        String curr = "";

        for (int i=1; i<=n; i++) {
            if (i%3 == 0) {
                curr += "Fizz";
            }
            if (i%5 == 0) {
                curr += "Buzz";
            }
            if (curr.equals("")) {
                curr = Integer.toString(i);
            }
            ans.add(curr);
            curr = "";
        }
        return ans;
    }
}
