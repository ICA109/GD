public class PlusOne {

    public static void main(String[] args) {
        int[] test = {8, 9};
        plusOne(plusOne(test));
    }

    public static int[] plusOne(int[] digits) {

        int[] mod = new int[digits.length+1];   //For carry-over add on extra slot at start
        System.arraycopy(digits, 0, mod, 1, digits.length);

        for (int i = mod.length-1; i>= 0; i--) {
            if (mod[i] == 9 || mod[i] == 10) {
                mod[i] = 0;
            }

            else {
                mod[i] += 1;
                break;
            }
        }

        //Drop leadings 0's
        if (mod[0] == 0) {
            int[] trimmed = new int[mod.length-1];
            System.arraycopy(mod, 1, trimmed, 0, trimmed.length);
            return trimmed;
        }

        return mod;
    }
}
