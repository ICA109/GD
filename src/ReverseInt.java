public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(321));
        System.out.println(reverse(-321));
        System.out.println(reverse(1534236469));    //Too large for int...
    }


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
}
