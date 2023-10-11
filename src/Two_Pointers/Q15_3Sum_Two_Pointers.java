package Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
public class Q15_3Sum_Two_Pointers {
  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums); // [-4, -1, -1, 0 , 1, 2]
    List<List<Integer>> result = new ArrayList<>();
    // Iterate through the array and find potential triplets
    for ( int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        continue;
      }
      // Check if the current element is unique or not
      if (i == 0 || nums[i-1] != nums[i]) {
        // Call the twoSumII function to find pairs
        twoSum(nums, i, result);
      }
    }
    // Return the final list of triplets
    return result;
  }

  // Function to find pairs that sum to zero with a fixed element
  private static void twoSum(int[] nums, int i, List<List<Integer>> result) {
    int low = i + 1; // the next value of the i is assumed to be the low boundary
    int high = nums.length - 1; // Initialize the right pointer
    // Use two pointers approach to find pairs
    while ( low < high) {
      int sum = nums[i] + nums[low] + nums[high];
      if (sum < 0) {
        low++; // Increment left pointer if the sum is too small
      } else if (sum > 0) {
        high--; // Decrement right pointer if the sum is too large
      } else {
        // If sum equals zero, add the triplet to the result list
        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
        low++;
        high--;
        // Handle duplicate elements
        while (low < high && nums[low] == nums[low - 1]) {
          low++;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> result = threeSum(nums);
    System.out.println(result);
  }
}
