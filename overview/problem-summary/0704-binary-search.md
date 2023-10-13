---
description: '@Array @Binary Search'
---

# 🟢 0704 -Binary Search

Sorted array with boundary, find a num in the array == target&#x20;

<details>

<summary>Description 题目描述 </summary>

* Given&#x20;
  * a <mark style="color:yellow;">**sorted**</mark> (in ascending order) integer <mark style="color:yellow;">**array**</mark> `nums` of `n` elements&#x20;
  * a `target` value

<!---->

*   write a function to <mark style="color:yellow;">**SEARCH**</mark> `target` in `nums`.&#x20;

    * if `target` exists, then return its <mark style="color:yellow;">**INDEX**</mark>, otherwise return `-1`.

    <mark style="color:yellow;">You must write an algorithm with</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`O(log n)`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">runtime complexity.</mark>

**Example 1:**

```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```

**Example 2:**

```
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```

**Note:**

1. You may assume that all elements in `nums` are <mark style="color:yellow;">unique</mark>.
2. `n` will be in the range `[1, 10000]`.
3. The value of each element in `nums` will be in the range `[-9999, 9999]`.

</details>

<details>

<summary>Algorithm 解题思路 </summary>

题目大意

* 在一个sorted array中search到target的index
* 题目本身没有说要用binary search, 说的是O(nlogn)
* assume每个元素是unique的

**Search Space: \[left, right]**

* 定义target在一个左闭右闭的search space区间 => \[left, right]
* Initial Condition: `left = 0, right = length - 1`
* While loop 边界处理：left <=right ; Termination: `left > right`
* Searching Left: `right = mid - 1`
* Searching Right: `left = mid + 1`

**Development Process**

1. <mark style="background-color:yellow;">**left = 0; right = nums.length - 1;**</mark> => right index is the actual index of the last element
2. <mark style="background-color:yellow;">**定义 while loop condition:**</mark>** **<mark style="color:yellow;">**left == right**</mark>情况在\[left, right]的区间内是<mark style="color:yellow;">**有意义的**</mark> => 在while循环中要使用<mark style="color:yellow;">**while (left <= right)**</mark>
   1. if target < nums\[middle], 则需要update search space的right index 为 middle - 1, 因为nums\[middle]一定不是target
   2. if target > nums\[middle], 则需要update search space的left index为middle + 1, 因为nums\[middle]一定不是target
   3. if target == nums\[middle], return index
3. finally not found => return -1

</details>

<details>

<summary>Code Demo </summary>

```java
// Search Space:  [left, right]
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

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>Key Points</summary>



</details>

