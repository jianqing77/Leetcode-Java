---
description: '@Sort without built-in methods'
---

# 🟠 0075 - Sort Colors

<details>

<summary>Description 题目描述 </summary>

Given an array `nums` with `n` objects colored red, white, or blue, sort them [**in-place**](https://en.wikipedia.org/wiki/In-place\_algorithm) so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively. You must solve this problem without using the library's sort function.

**Example 1:**

<pre><code><strong>Input: nums = [2,0,2,1,1,0]
</strong><strong>Output: [0,0,1,1,2,2]
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: nums = [2,0,1]
</strong><strong>Output: [0,1,2]
</strong></code></pre>

**Follow up:** Could you come up with a one-pass algorithm using only constant extra space?

</details>

<details>

<summary>解题思路 Intuition </summary>

1. 直接用Bubble sort

</details>

<details>

<summary>Algorithm 1: Bubble Sort</summary>

* Bubble Sort - inefficient
  * use 2 for loops
  * find the largest element in each pass
* Time Complexity: O(n^2)
* Space Complexity: O(n)

```java
- 注意这里的lastUnsortedIndex的理解
- 两个loops
class Solution {
    public void sortColors(int[] nums) {
        // 逐渐把unsorted的边界左移
        for (int lastUnsortedIndex = nums.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            // 针对unsorted部分进行swap
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }
    // helper methods
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

```

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>心得 Key Points</summary>



</details>
