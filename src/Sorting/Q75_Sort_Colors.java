package Sorting;

// Two Pointers
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
public class Q75_Sort_Colors {
  public void sortColors(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    for (int i = 0; i <= right;) {
      // If current num = 0, we need to swap it to the leftmost position
      // Now the value is at its correct position
      // Then we could increase the left pointer and i to the next
      if (nums[i] == 0){
        swap(nums, i, left);
        left++;
        i++;
        // swap(nums, i++, left++);
      }
      else if (nums[i] == 2) {
        // swap(nums, i, right--);
        swap(nums, i, right);
        right--;
      }
      else {
        i++;
      }
    }

  }
  // note: here i and j are both index
  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
