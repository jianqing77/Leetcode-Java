package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers numbers and an integer target, return INDICES
 * of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you
 * may not use the same element twice.
 * Using HashMap: key=value, use map.containsKey(key)
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Q1_Two_Sum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<>();
    // Iterate through the array from left to right.
    for (int i = 0; i < nums.length; i++) {
      // For each element nums[i], calculate the complement
      // by subtracting it from the target: complement = target - nums[i].
      int complement = target - nums[i];
      // Check if the complement exists in the hash table,
      // If it does, we have found a solution.
      if (numsMap.containsKey(complement)) {
        return new int[]{numsMap.get(complement), i};
      }
      // If the complement does not exist in the hash table,
      // add the current element nums[i] to the hash table with its index as the value.
      numsMap.put(nums[i], i);
    }
    return new int[]{};
  }
}
