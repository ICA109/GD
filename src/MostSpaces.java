public class MostSpaces {

    public static void main(String[] args) {
        boolean[] sample = {true, true, false, false, true, false, false, true, true, true, false, false, false};  //true if empty, false if not
        boolean[] sample2 = {false, false, false, true, true, false, true, true, true, false, true, true, true};
        boolean[] sample3 = {false, true, false};
        boolean[] sample4 = {false, false, true, true, false, true, true, false, true, true, true};
        boolean[] sample5 = {false, true, true};
        boolean[] sample6 = {true, true, true};
        boolean[] sample7 = {false, false};


        System.out.println(indexOfMostFree(sample));
        System.out.println(indexOfMostFree(sample2));
        System.out.println(indexOfMostFree(sample3));
        System.out.println(indexOfMostFree(sample4));
        System.out.println(indexOfMostFree(sample5));
        System.out.println(indexOfMostFree(sample6));
        System.out.println(indexOfMostFree(sample7));
    }

    /*
    private static int indexOfMostFree(boolean[] seats) {
        int indexOfMost = 0;
        int freeCountOfMost = 0;
        int freeCountOfCurrent = 0;

        //Iterate through all seats
        for (int i=0; i<seats.length; i++) {

            if (seats[i]) {
                continue;   //Don't care about empty seats
            }

            //Iterate through seats to the left
            for (int l=i-1; l>=0; l--) {
                if (!seats[l]) {
                    break; //First full seat hit
                }
                freeCountOfCurrent++;
            }
            //Iterate through seats to the right
            for (int r=i+1; r<seats.length; r++) {
                if (!seats[r]) {
                    break; //First full seat hit
                }
                freeCountOfCurrent++;
            }

            if (freeCountOfCurrent > freeCountOfMost) {
                freeCountOfMost = freeCountOfCurrent;
                indexOfMost = i;
            }

            freeCountOfCurrent = 0; //Reset for next round

        }
        return indexOfMost;
    }
    */

    /*
    //Approach using single loop
    private static int indexOfMostFree(boolean[] seats) {
        int indexOfMost = 0;
        int freeCountOfMost = 0;
        int leftCount = 0;
        int rightCount = 0;
        int totCount = 0;
        int indexOfCurrent = 0;

        //Iterate through all seats
        for (int i=0; i<seats.length; i++) {

            if (seats[i]) {
                rightCount++;
            }

            else {

                if (totCount == 0) {
                    indexOfCurrent = i;
                }

                totCount = leftCount + rightCount;  //Works here

                if (totCount > freeCountOfMost) {
                    freeCountOfMost = totCount;
                    indexOfMost = indexOfCurrent;
                    leftCount = rightCount;
                    rightCount = 0;
                    totCount = 0; //Reset for next round
                }

            }
        }
        return indexOfMost;
    }
    */

    //Simplify variables
    private static int indexOfMostFree(boolean[] seats) {
        int indexOfMost = 0;
        int freeCountOfMost = 0;
        int leftCount = 0;
        int rightCount = 0;
        int totCount = 0;
        int indexOfCurrent = 0;

        //Iterate through all seats
        for (int i=0; i<seats.length; i++) {
            if (seats[i]) {
                rightCount++;
            }
            else {
                totCount = leftCount + rightCount;
                if (totCount > freeCountOfMost) {
                    freeCountOfMost = totCount;
                    indexOfMost = i;
                    leftCount = rightCount;
                    rightCount = 0;
                    totCount = 0; //Reset for next round
                }
            }
        }
        return indexOfMost;
    }

}
