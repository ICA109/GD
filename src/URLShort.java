import java.util.HashMap;
import java.util.Random;

public class URLShort {
    private HashMap<String, String> database;
    private Random rng;

    public URLShort() {
        database = new HashMap<>();
        rng = new Random();
    }

    public String shorten(String orgURL) {
        System.out.println("Your current URL is: " + orgURL);
        String currentShort;
        char[] alphaNumeric = new char[3];
        do {
            currentShort = "";

            for (int i = 1; i <= 6; i++) {
                //currentShort += (char) (48 + rng.nextInt(2));
                alphaNumeric[0] = (char) (48 + rng.nextInt(10));    //Numbers
                alphaNumeric[1] = (char) (65 + rng.nextInt(26));    //Uppercase
                alphaNumeric[2] = (char) (97 + rng.nextInt(26));    //Uppercase

                currentShort += alphaNumeric[rng.nextInt(3)];       //Pick one of the above
            }
        } while (database.containsKey(currentShort));
        database.put(currentShort, orgURL);
        System.out.println("Your new URL is: " + currentShort);
        return currentShort;
    }

    public String expand(String shortURL) {
        if (database.containsKey(shortURL)) {
            System.out.println("Short URL match found. Original URL is: " + database.get(shortURL) + "\n");
            return database.get(shortURL);
        }
        else {
            System.out.println("No match found.\n");
            return null;
        }
    }

    public static void main(String[] args) {
        URLShort url = new URLShort();

        //Test 1
        String tmp = url.shorten("https://www.google.com");
        url.expand(tmp);

        //Test 2
        String tmp2 = url.shorten("http://www.bing.com");
        url.expand(tmp2);

        //Test 3 (not found)
        url.expand("other");
    }
}
