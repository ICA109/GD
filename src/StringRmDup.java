import java.util.ArrayList;
import java.util.Hashtable;

public class StringRmDup {

    public static void main(String[] args) {
        ArrayList<String> testCases = new ArrayList<String>();
        StringBuilder SB = new StringBuilder();

        testCases.add("Bobby");
        testCases.add("Boby");

        testCases.add("Z");
        testCases.add("Z");

        testCases.add("POP");
        testCases.add("PO");

        testCases.add("11234456");
        testCases.add("123456");

        for (int i = 0; i < testCases.size(); i++) {
            if (i % 2 == 0) {
                System.out.println("Input: " + testCases.get(i) + "     ");
                System.out.println("Output (Actual):   " + rmDuplicate(testCases.get(i)));
            } else {
                System.out.println("Output (Expected): " + testCases.get(i) + "     ");
                System.out.println("------------------");
            }
        }
    }

    public static String rmDuplicate(String input) {
        //Note: Case-sensitive so B != b
        String extractedChar = "";
        String finalAnswer = "";
        Hashtable<String, String> ht = new Hashtable<String, String>();

        for (int i = 0; i < input.length(); i++) {
            extractedChar = input.substring(i, i + 1);
            if (!ht.containsKey(extractedChar)) {
                ht.put(extractedChar, extractedChar); //No duplicate yet so safe to print
                finalAnswer += extractedChar;
            }
        }

        //Slightly more complicated answer
        //ArrayList<String> tentativeAnswer = new ArrayList<>(ht.values());   //Can pass collections are parameters to ArrayList
        //return tentativeAnswer.toString();

        return finalAnswer;
    }


}
