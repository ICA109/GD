public class CountValley {
    static int countingValleys(int n, String s) {
        int level = 0;
        int numValleys = 0;
        boolean previousValley = false;

        for (int i=0; i<s.length(); i++) {
            char move = s.charAt(i);

            if (move == 'U') {
                level++;
            }
            else {
                level--;
            }

            if (level == 0 && previousValley) {
                numValleys++;
                previousValley = false;
            }
            else if (level < 0 && !previousValley) {
                previousValley = true;
            }

        }
        return numValleys;
    }


}
