import java.util.Arrays;

/**
 * Created by tonyyin on 7/26/17.
 */
public class MajorityElement {

    public static void main(String[] args) {
        //int[] nums = {1, 3, 3, 1, 3, 5};   // -> [1, 1, 2, 2, 2, 5]
        //int[] nums = {1, 2, 2, 3};
        int[] nums = {2, 1, 3, 2};  //Suggest solution fails here if no pre-sorting performed
        //int[] nums = {1};
        //int[] nums = {3, 1, 2, 3, 2, 5, 3, 5, 3};
        //int[] nums = {5, 1, 5, 2, 5, 1, 2, 4, 5}; // -> [1, 1, 2, 2, 5, 5, 5]
        System.out.println("Majority number V1: " + majorityElement1(nums));
        System.out.println("Majority number V2: " + majorityElement2(nums));
    }

    //Option 1: Sort array and see if longest "run" exceeds majority count in length
    public static int majorityElement1(int[] nums) {
        int majorRequired = nums.length / 2;
        Arrays.sort(nums);  //Nums now in sorted order
        if (majorRequired == 0) //Special case of only 1 number (since floor will be zero)
            return nums[0];
        int contCount = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                contCount++;
                if (contCount >= majorRequired)
                    return nums[i];
                continue;   //Don't reset contCount
            }
            contCount = 1; //Gets reset (since length wasn't enough)
        }
        return -1;  //If no majority exists
    }

    //Option 2: Much simpler with O(n) time; wait this assumes array is already sorted? YES!!!!! Because my
    //original code had actually modified the original nums array!
    public static int majorityElement2(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else count--;
        }
        return major;
    }
}
