---
description: '@Array @Binary Search'
---

# 🟠 0162 - Find Peak Element

<details>

<summary>Description 题目描述 </summary>

A peak element is an element that is strictly greater than its neighbors.

Given a <mark style="color:yellow;">**0-indexed**</mark> integer array `nums`, find a peak element, and return its index. <mark style="color:yellow;">**If the array contains multiple peaks, return the index to any of the peaks.**</mark>

You may imagine that `nums[-1] = nums[n] = -∞`. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in <mark style="color:yellow;">`O(log n)`</mark> time.

* `1 <= nums.length <= 1000`
* `-231 <= nums[i] <= 231 - 1`
* <mark style="color:red;">`nums[i] != nums[i + 1]`</mark> <mark style="color:red;"></mark><mark style="color:red;">for all valid</mark> <mark style="color:red;"></mark><mark style="color:red;">`i`</mark><mark style="color:red;">.</mark> <mark style="color:yellow;">**no two consecutive elements are equal.**</mark>

**Example 1:**

<pre><code><strong>Input: nums = [1,2,3,1]
</strong><strong>Output: 2
</strong><strong>Explanation: 3 is a peak element and your function should return the index number 2.
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: nums = [1,2,1,3,5,6,4]
</strong><strong>Output: 5 or 1
</strong><strong>Explanation: Your function can return 
</strong><strong>either index number 1 where the peak element is 2, 
</strong><strong>or index number 5 where the peak element is 6.
</strong></code></pre>

</details>

<details>

<summary>Algorithm 解题思路 </summary>

<mark style="color:yellow;">题目大意</mark>：在给定的数组`nums`中找到一个peak元素并返回其index。peak元素是指其值大于其neighbor的元素。数组可能包含多个peak，此函数**返回任一峰值的index。**

<mark style="color:yellow;">**intuition：find the largest element is an array （could be multiple）**</mark>

* **不是 sorted array,** 用O(logn)不能提前用Arrays.sort(nums)
* 不是return唯一的answer，只要两边的数字比他小，则他就是peak
* 本质：find the largest element is an array => search for an index in a collection
* 普通的binary search都有一个target来和mid对比，但是这个没有提前的target
* special case:&#x20;
  * 两个peak？\[1,2,1,3,2,6,4,6,5,3]?  -- 返回任意一个
  * 只有一个元素？\[1]&#x20;
  * 不可能有所有元素一样的情况因为在题目里说的

</details>

<details>

<summary>Code Demo 1: <strong>Iteration binary search</strong></summary>

**Algorithm:**

1. identify the mid element&#x20;
2.  <mark style="color:orange;">**if nums\[mid] < nums\[mid+1]**</mark>  \
    \=> the mid value is currently lying in a ascending ↑ sequence of numbers,&#x20;

    \=> the peak should be lying at the right portion \
    \=> update the left boundary to mid+1  <mark style="color:orange;">**left = mid + 1**</mark>\
    <mark style="color:orange;">**=> mid is definitely not the peak**</mark>
3.  <mark style="color:orange;">**if nums\[mid] > nums\[mid+1]**</mark>  \
    \=> the mid value is lying in a descending ↓ sequence of  numbers,&#x20;

    \=> the peak should be lying at the left portion \
    \=> update the right boundary to mid <mark style="color:orange;">**right = mid**</mark>\
    <mark style="color:orange;">**=> mid could possibly be the peak**</mark>

<pre class="language-sql"><code class="lang-sql">[1,2,1,3,6,5,4]  n=7, 
 0 1 2 3 4 5 6
<strong>------------------------------------------
</strong><strong>1: 
</strong>mid value = 3
mid + 1 value = 6;
3 &#x3C; 6 => ascending => left = mid + 1 = 4;
------------------------------------------
2: [6,5,4]
mid value = 5;
mid + 1 value = 4;
5 > 4+> descending => right = mid = 5 ;
------------------------------------------
3: [6,5]
mid value = 6;
mid + 1 value = 5;
6 > 5 => descending => right = mid = 4;
------------------------------------------
left == right
</code></pre>

```java
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid+1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
        // return right 
        // while left < right => finally left == right => so they are the same
    }
}
```

<mark style="color:yellow;">**why left < right not left <=right**</mark>&#x20;

* 在这个函数中，我们使用 while (left < right) 来保证避免无限循环并且在正确的位置停止循环。
* 如果我们使用 <mark style="color:purple;">**while (left <= right)**</mark>，那么当 left 和 right 指向同一个元素（也就是我们要找的峰值）时，还会继续进行循环，<mark style="color:purple;">**这可能导致无限循环。**</mark>
* 但是，如果我们使用 <mark style="color:purple;">**while (left < right)，**</mark>那么当 <mark style="color:purple;">**left 和 right 指向同一个元素时**</mark>，循环就会停止。这是因为 left < right 的条件不再满足。
* 此外，由于我们<mark style="color:purple;">**在循环中移动 left 和 right 的方式，确保了 left 和 right 最终都会指向峰值**</mark>。如果 nums\[mid] > nums\[mid + 1]，我们会将 right 移动到 mid；否则，我们会将 left 移动到 mid + 1。这两种情况都保证了 left 和 right 会向峰值移动。
* 所以，我们使用 while (left < right) 来确保在找到峰值时能够正确地停止循环。

</details>

<details>

<summary>Code Demo 2: linear scanning </summary>



</details>

<details>

<summary>Code Demo 3: <strong>recursion binary search</strong></summary>

<mark style="color:yellow;">**How can I know that i should use binary search?**</mark>

* Binary Search should be considered every time you need to <mark style="color:orange;">**search for an index or element in a collection.**</mark>
* <mark style="background-color:yellow;">**Binary Search:**</mark>&#x20;
  * _<mark style="color:yellow;">**Pre-processing**</mark>_ - <mark style="color:red;">**Sort**</mark> if collection is unsorted.
  * _<mark style="color:yellow;">**Binary Search**</mark>_ - Using a <mark style="color:red;">**loop or recursion**</mark> to <mark style="color:red;">**divide search space in half**</mark> after each comparison.
  * _<mark style="color:yellow;">**Post-processing**</mark>_ - Determine viable candidates in the remaining space.

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>Key Points</summary>



</details>
