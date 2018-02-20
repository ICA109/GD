public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(321));
        System.out.println(reverse(-321));
        System.out.println(reverse(1534236469));    //Too large for int...
    }

    //String-based approach (slower)
    /*
    public static int reverse(int x) {
        String rev = "";
        int wasNegative = x < 0 ? -1 : 1;   //Nice use of ternary operator

        for (char c : Integer.toString(x).toCharArray()) {
            if (c != '-')
                rev = c + rev;
        }

        try {
            return wasNegative*(Integer.parseInt(rev));
        }
        catch (NumberFormatException ex) {
            return  0;
        }
    }
    */

    //int-based approach. Faster
    public static int reverse(int x) {
        int output = 0;
        while (true) {
            if (x == 0)
                return x;
            output = output * 10 + x % 10;
            if ((x /= 10) == 0)
                return output;
            if (output > 214748364 || output < -214748364)  //int overflow
                return 0;
        }
    }
}
