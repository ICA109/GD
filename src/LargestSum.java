import java.util.ArrayList;
import java.util.Arrays;

public class LargestSum {

    public static void main(String[] args) {
        int[] s1 = {1, 2, 3, 1, 5, 6, -9, -3, 1, 200, 1, 2};    //Works so long as the final element is decreasing
//        indices(s1);
        int[] s2 = {1, 2};
//        indices(s2);
        int[] s3 = {-3, -5, -15};
//        indices(s3);
        int[] s4 = {-3, 3};
//        indices(s4);
        int [] s5 = {-2, -3, 4, -1, -2, 1, 5, -3};
        //indices(s5);
        int [] s6 = {-1, 10, -200, 11};
        maxSum(s1);
        maxSum(s2);
        maxSum(s3);
        maxSum(s4);
        maxSum(s5);
        maxSum(s6);
    }


    //Version 0.4 (much simpler approach; based off Geeks-for-geeks)
    public static int[] maxSum(int [] input) {
        int runningMaxSum = 0;
        int maxFormedHere = 0;
        ArrayList<Integer> indices = new ArrayList<Integer>();

        for(int i=0; i<input.length; i++) {
            maxFormedHere += input[i];
            if (maxFormedHere < 0) {
                maxFormedHere = 0;
                indices.clear();  //Is needed (for example with the s6 case)
            }
            if (runningMaxSum < maxFormedHere) {
                runningMaxSum = maxFormedHere;
                indices.add(i);
            }
        }

        //System.out.println("maxFormedHere: " + maxFormedHere);
        //System.out.println("Indices: " + indices.toString());
        //System.out.println("runningMaxSum: " + runningMaxSum);

        if (indices.isEmpty()) {
            System.out.println("Output: " + "[No valid non-negative answer exists]");
            return null;
        }

        int[] output = new int[indices.get(indices.size()-1) - indices.get(0) + 1]; //+1 to not forgot 1st number itself
        int internalIndex = 0;

        for (int i=indices.get(0); i<=indices.get(indices.size()-1); i++) {
            output[internalIndex] = i;
            internalIndex++;
        }

        System.out.println("Output: " + Arrays.toString(output));
        return output;
    }

    

    //Version 0.3 (issues)
    public static int[] indices(int[] input) {

        System.out.println();
        System.out.println("Original array: " + Arrays.toString(input));

        ArrayList<Integer> possibleSeq = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> allSeq = new ArrayList<ArrayList<Integer>>();
        boolean hasPossSubSeq = false;
        int innerSum = 0; //Last final element (last index) in ArrayList represent sum of sub-sequence? Unused approach

        for(int i=0; i<input.length-1; i++) {
            if (input[i+1] > input[i]) {
                hasPossSubSeq = true;
                possibleSeq.add(input[i]);

                //Special case where entire sequence is increasing (don't miss last element)
                if (i == input.length-2) {
                    possibleSeq.add(input[i+1]);
                    allSeq.add(possibleSeq);
                }
            }
            else {
                if (hasPossSubSeq)
                    possibleSeq.add(input[i]);  //Also include the final element despite fact i+1 is now decreasing


                ArrayList<Integer> actuallyAdded = (ArrayList<Integer>) possibleSeq.clone();
                allSeq.add(actuallyAdded);
                possibleSeq.clear();    //Clear contents for next possible sequence (but turns out we're working with a reference)
                hasPossSubSeq = false;
            }
        }

        System.out.println("Midpoint Check: " + allSeq.toString());
        //Now we run the actual calculations
        int winningSubSeqIndex = 0;
        int oldSum = 0;
        int runningSum = 0;

        for(int i=0; i<allSeq.size(); i++) {

            for(int j=0; j<allSeq.get(i).size(); j++) {
                runningSum += allSeq.get(i).get(j);
            }

            if (runningSum > oldSum) {
                winningSubSeqIndex = i;
                oldSum = runningSum;
            }
            runningSum = 0; //Reset
        }

        System.out.println("Winning index: " + winningSubSeqIndex + "   Sum: " + oldSum);

        //Now calculate the desired indices
        int startInd = 0;   //Simply sum of sizes of previous inner sub-sequences
        int endInd = 0;     //Simply startInd + size - 1 (don't count self)

        for(int i=0; i<winningSubSeqIndex; i++) {
            startInd += allSeq.get(i).size();
        }

        endInd = startInd + allSeq.get(winningSubSeqIndex).size() - 1;

        //Special case where entire sequence is decreasing returns a -1
        if (endInd == -1) {
            System.out.println("No valid indices exist. Entire input array must be decreasing");
            return null;
        }

        //Otherwise now create final array with desired indices to output
        int[] output = new int[endInd-startInd+1];

        for(int i=0; i<=endInd-startInd; i++) {
            output[i] = i + startInd;
        }

        System.out.println(Arrays.toString(output));
        return input;
    }

}
