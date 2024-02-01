# 🔸 \[left, right]

<mark style="color:purple;">定义 search space 很重要 => 决定了如何写code</mark>

### <mark style="background-color:red;">Search Space:  \[left, right]</mark>

> * 定义target在一个左闭右闭的search space区间 => \[left, right]
> * Initial Condition: `left = 0, right = length - 1`
> * While loop 边界处理：left <=right ; Termination: `left > right`
> * Searching Left: `right = mid - 1`
> * Searching Right: `left = mid + 1`

**Development Process**

1. <mark style="background-color:yellow;">**left = 0; right = nums.length - 1;**</mark> => right index is the actual index of the last element
2. <mark style="background-color:yellow;">**定义 while loop condition:**</mark>** **<mark style="color:yellow;">**left == right**</mark>情况在\[left, right]的区间内是<mark style="color:yellow;">**有意义的**</mark> => 在while循环中要使用<mark style="color:yellow;">**while (left <= right)**</mark>
   1. if target < nums\[middle], 则需要update search space的right index 为 middle - 1, 因为nums\[middle]一定不是target
   2. if target > nums\[middle], 则需要update search space的left index为middle + 1, 因为nums\[middle]一定不是target
   3. if target == nums\[middle], return index
3. finally not found => return -1

```java
class Solution {
    public int search(int[] nums, int target) {
        // Edge Case
        if (nums.length == 0 || nums == null ) {
            return -1;
        }
        // 1. 定义target在左边闭合右边闭合的区间[left, right]
        int left = 0;
        int right = nums.length - 1;

        // 2. 用 while loop
        // 当left == right时，[left, right] is meaningful
        while (left <= right) {
            // 3. 在while loop中定义mid 防止溢出overflow,等同于left+right/2
            int mid = left + (right - left)/2;
            if (target < nums[mid]) { // nums[middle]一定不是target
                right = mid - 1; // target在left左区间[left, mid - 1]
            } else if (target > nums[mid]) { // nums[middle]一定不是target
                left = mid + 1; // target在right右区间[mid + 1, right]
            } else {
                return mid; // nums[middle]是target, return the index
            }
        }
        return -1; // not found target value
    }
}

```

###



