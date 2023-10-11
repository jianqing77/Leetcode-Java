package Two_Pointers;

import java.util.Arrays;

public class Q1_Two_Sum_usePair_TwoPointers {
  public int[] twoSum(int[] nums, int target) {
    // Sort the nums array along with their original indices
    int n = nums.length;
    Pair[] pairs = new Pair[n];
    for (int i = 0; i < n; i++) {
      pairs[i] = new Pair(nums[i], i);
    }
    Arrays.sort(pairs);

    int left = 0;
    int right = n - 1;

    while (left < right) {
      int sum = pairs[left].value + pairs[right].value;
      if (sum == target) {
        return new int[]{pairs[left].index, pairs[right].index};
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    return new int[]{-1, -1}; // No solution found
  }

  static class Pair implements Comparable<Pair> {
    int value;
    int index;

    Pair(int value, int index) {
      this.value = value;
      this.index = index;
    }

    @Override
    public int compareTo(Pair other) {
      return Integer.compare(this.value, other.value);
    }
  }

  public static void main(String[] args) {
    Q1_Two_Sum_usePair_TwoPointers solution = new Q1_Two_Sum_usePair_TwoPointers();
    int[] nums = { 20, 35, 15, 7, 55, 1, -22 };
    int target = 8;
    int[] result = solution.twoSum(nums, target);
    System.out.println("Indices of the two numbers: " + Arrays.toString(result));
  }
}
