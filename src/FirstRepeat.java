import java.util.HashSet;

public class FirstRepeat {

    public static void main(String[] args) {
        System.out.println(getFirstRepeat(""));             //Expect '0'
        System.out.println(getFirstRepeat("  "));           //Expect ' '
        System.out.println(getFirstRepeat("aawueiq2"));     //Expect a
        System.out.println(getFirstRepeat("asiq22"));       //Expect 2
        System.out.println(getFirstRepeat("asi1sq22"));     //Expect s
    }

    private static char getFirstRepeat(String sentence) {
        HashSet<Character> hs = new HashSet<>();

        for (char currChar : sentence.toCharArray()) {
            if (hs.contains(currChar)) {
                return currChar;
            }
            else {
                hs.add(currChar);
            }
        }
        return '0'; //Code signaling no repeating characters
    }
}
