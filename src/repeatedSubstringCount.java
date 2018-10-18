public class repeatedSubstringCount {
    static long repeatedString(String s, long n) {
        long numberOfAInSubstring = 0;
        long numberOfAInTotal = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'a') {
                numberOfAInSubstring++;
            }
        }

        numberOfAInTotal = numberOfAInSubstring * (n/s.length());

        for (int j=0; j<n%s.length(); j++) {
            if (s.charAt(j) == 'a') {
                numberOfAInTotal++;
            }
        }

        return numberOfAInTotal;

    }
}
