package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Q15_3Sum_HashSet {
  // Input: nums = [-1,0,1,2,-1,-4]
  // Output: [[-1,-1,2],[-1,0,1]]
  // sort the array: [-4, -1, ,-1, 0 , 1, 2]
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    // only non-positive numbers are considered
    // as no triple positive numbers can sum to 0
    for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
      if (i == 0 || nums[i - 1] != nums[i]) {
        twoSum(nums, i, result);
      }
    }
    return result;
  }

  private void twoSum(int[] nums, int i, List<List<Integer>> result) {
    var seen = new HashSet<Integer>();
    for ( int j = i+1; j < nums.length; j++) {
      int complement = -nums[i] - nums[j];
      if (seen.contains(complement)) {
        result.add(Arrays.asList(nums[i], nums[j], complement));
        while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
          j++;
        }
      }
      seen.add(nums[j]);
    }
  }
}
