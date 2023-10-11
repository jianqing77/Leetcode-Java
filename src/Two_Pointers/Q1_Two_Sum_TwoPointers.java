package Two_Pointers;

import java.util.Arrays;

public class Q1_Two_Sum_TwoPointers {
  public int[] twoSum(int[] nums, int target) {
    // Create a copy of the nums array and sort it in ascending order
    int[] sortedNums = Arrays.copyOf(nums, nums.length);
    Arrays.sort(sortedNums);

    int left = 0;
    int right = sortedNums.length - 1;

    while (left < right) {
      int sum = sortedNums[left] + sortedNums[right];
      if (sum == target) {
        // Find the original indices of the sorted numbers in the original array
        int index1 = -1, index2 = -1;
        for (int i = 0; i < nums.length; i++) {
          if (nums[i] == sortedNums[left] && index1 == -1) {
            index1 = i;
          } else if (nums[i] == sortedNums[right]) {
            index2 = i;
          }
        }
        return new int[]{index1, index2};
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    return new int[]{-1, -1}; // No solution found
  }
  public static void main(String[] args) {
    Q1_Two_Sum_TwoPointers solution = new Q1_Two_Sum_TwoPointers();
    int[] nums = { 20, 35, 15, 7, 55, 1, -22 };
    int target = 8;
    int[] result = solution.twoSum(nums, target);
    System.out.println("Indices of the two numbers: " + Arrays.toString(result));
  }
}
