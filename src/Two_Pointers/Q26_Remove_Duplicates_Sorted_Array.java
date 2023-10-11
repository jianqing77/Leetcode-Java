package Two_Pointers;

public class Q26_Remove_Duplicates_Sorted_Array {
    public int removeDuplicates(int[] nums) {
      int insertionIndex = 1;
      // loop through the array from the second element
      for ( int i = 1; i < nums.length; i++) {
        // If found different
        // perform arr[insertIndex] = arr[i] and increment insertIndex by 1
        if (nums[i-1] != nums[i]) {
          nums[insertionIndex] = nums[i];
          insertionIndex++;
        }
      }
      return insertionIndex;
    }
  }

