# 🔸 Recursion

In this code, we have a public function `binarySearch(int[] nums, int target)` that calls a private helper function `binarySearch(int[] nums, int target, int left, int right)`. The helper function is recursive and does the actual binary search.

The base case for the recursion is when `left` is greater than `right`, which means the target is not in the array. In this case, we return `-1`.

Then, we calculate the middle index `mid`. If the element at `mid` is equal to the target, we return `mid`. If the element at `mid` is greater than the target, we recursively search in the left half of the array. Otherwise, we recursively search in the right half of the array.

Please note that recursion can lead to a stack overflow error for very large arrays, as each recursive call adds a layer to the call stack. The iterative version of binary search avoids this potential issue.

```java
// Some code
public class Solution {
    public int binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;  // target is not in the array
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }
}
```
