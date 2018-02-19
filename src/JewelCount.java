public class JewelCount {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb")); //Expect 3
        System.out.println(numJewelsInStones("z", "ZZ"));       //Expect 0
    }

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        for (char j : J.toCharArray()) {
            for (char s : S.toCharArray()) {
                if (j == s) {
                    count++;
                }
            }
        }
        return count;
    }
}
