---
description: '@Sort'
---

# 🟢 1051 - Height Checker

<details>

<summary>Description 题目描述 </summary>

A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in **non-decreasing order** by height. Let this ordering be represented by the integer array `expected` where `expected[i]` is the expected height of the `ith` student in line.

You are given an integer array `heights` representing the **current order** that the students are standing in. Each `heights[i]` is the height of the `ith` student in line (**0-indexed**).

<mark style="color:yellow;">Return</mark> <mark style="color:yellow;"></mark>_<mark style="color:yellow;">the</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">**number of indices**</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">where</mark>_ <mark style="color:yellow;"></mark><mark style="color:yellow;">`heights[i] != expected[i]`</mark><mark style="color:yellow;">.</mark>

<pre><code><strong>Input: heights = [1,1,4,2,1,3]
</strong><strong>Output: 3
</strong><strong>
</strong><strong>Explanation: 
</strong><strong>    heights:  [1,1,4,2,1,3]
</strong>    expected: [1,1,1,2,3,4]
    Indices 2, 4, and 5 do not match.
</code></pre>

<pre><code><strong>Input: heights = [5,1,2,3,4]
</strong><strong>Output: 5
</strong><strong>
</strong><strong>Explanation:
</strong>    heights:  [5,1,2,3,4]
    expected: [1,2,3,4,5]
<strong>    All indices do not match.
</strong></code></pre>

<pre><code><strong>Input: heights = [1,2,3,4,5]
</strong><strong>Output: 0
</strong><strong>
</strong><strong>Explanation:
</strong>    heights:  [1,2,3,4,5]
    expected: [1,2,3,4,5]
    All indices match.
</code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

* 题目没说不能用Arrays.sort(),
* 可以先sort the array use built in function and then compare with the original array

</details>

<details>

<summary>Algorithm </summary>

* make a copy of the original array
* sort the copied array
* compare with the original array

注意copy:

* arr.clone()是来copy the array
* Using `clone()` with <mark style="color:yellow;">an array of primitives</mark> (like `int[]`, `double[]`, `char[]`, etc.) is safe because <mark style="color:yellow;">it will not reflect changes from the cloned array to the original array or vice versa</mark>, since primitive types are copied by value.

</details>

<details>

<summary>Code Demo </summary>

```java
class Solution {
    public int heightChecker(int[] heights) {
        // make a copy of the original array: shallow copy
        int[] expectedHeights = heights.clone();
        Arrays.sort(expectedHeights);

        // compare and count the difference
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expectedHeights[i]) {
                count++;
            }
        }
        return count;
    }

}
```

</details>

<details>

<summary>心得 Key Points</summary>



</details>
