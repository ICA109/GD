/**
 Created by tonyyin on 7/26/17.

 Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        //int[] nums = {2, 7, 11, 15};
        //int target = 9;
        //int[] nums = {3, 2, 4};
        //int target = 6;
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        String answer = Arrays.toString(twoSum(nums, target));
        System.out.println(answer);
    }

    //Best solution
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement), i };
//            }
//            map.put(nums[i], i);
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }



    //Valid solution
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //Only need to check sums that possibly add up to target; so create new array with valid values
            //This is bricked if we're using negative values
            //Check value at index with sums against rest of array (array may not be in order at start!)
            for (int j = 0; j < nums.length; j++) {
                //Cannot have repeated elements!
                if (i != j) {
                    int testSum = nums[i] + nums[j];
                    if (testSum == target) {
                        int[] foundResponse = {i, j};
                        return foundResponse;
                    }
                }
            }
        }
        //If no earlier valid result found, return empty array
        int[] defaultResponse = {0};
        return defaultResponse;
    }


}
