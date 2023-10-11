package Two_Pointers;

// Three Pointers
public class Q88_Merge_Sorted_Array {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1; // Pointer for the last element in nums1
    int p2 = n - 1; // Pointer for the last element in nums2

    // Iterate from the end of the merged array (nums1)
    for (int p = m + n - 1; p >= 0; p--) {
      // If all elements from nums2 are merged, break
      // as p1 is already sorted
      if (p2 < 0) {
        break;
      }

      // Compare elements from nums1 and nums2
      if (p1 >= 0 && nums1[p1] > nums2[p2]) {
        // If the element from nums1 is larger, place it in the merged array
        nums1[p] = nums1[p1];
        p1--; // Move the pointer to the previous element in nums1
      } else {
        // If the element from nums2 is larger or equal, place it in the merged array
        nums1[p] = nums2[p2];
        p2--; // Move the pointer to the previous element in nums2
      }
    }
  }
}
