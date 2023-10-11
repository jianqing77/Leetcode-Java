package Two_Pointers;

import java.util.Arrays;

public class Q16_3Sum_Closet {
  // nums =  [-1,2,1,-4] target = 1
  // find closest to target
  // two pointers: [-4, -1, 1, 2]

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int ans = nums[0] + nums[1] + nums[2]; // arbitrary ans

    for (int i = 0; i < nums.length; i++) {
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        // if |sum - target| < |ans - target|, update ans
        if (Math.abs(sum - target) < Math.abs(ans - target)) {
          ans = sum;
        }
        // if sum > target, try smaller sum to approach target
        if (sum > target) right--;
          // if sum < target, try bigger sum to approach target
        else if (sum < target) left++;
          // if sum == target, return target
        else return target;
      }
    }
    return ans;
  }
}
