---
description: '@Math-prefixSum'
---

# 🟠 ❌0528 - Random Pick with Weight

<details>

<summary>Description 题目描述 </summary>

You are given a **0-indexed** array of positive integers `w` where `w[i]` describes the **weight** of the `ith` index.

You need to implement the function `pickIndex()`, which **randomly** picks an index in the range `[0, w.length - 1]` (**inclusive**) and returns it. The **probability** of picking an index `i` is `w[i] / sum(w)`.

* For example, if `w = [1, 3]`, the probability of picking index `0` is `1 / (1 + 3) = 0.25` (i.e., `25%`), and the probability of picking index `1` is `3 / (1 + 3) = 0.75` (i.e., `75%`).

**Example 1:**

<pre><code><strong>Input
</strong>["Solution","pickIndex"]
[[[1]],[]]
<strong>Output
</strong>[null,0]

<strong>Explanation
</strong>Solution solution = new Solution([1]);
solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.
</code></pre>

**Example 2:**

<pre><code><strong>Input
</strong>["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
<strong>Output
</strong>[null,1,1,1,1,0]
</code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

题目理解

1. 对于input:\[`"Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]` => a <mark style="color:yellow;">**sequence of operations,**</mark> \
   `[[[1,3]],[],[],[],[],[]]` <mark style="color:yellow;">**=> operation inputs**</mark>
2. 对于output:\
   `[null,0]` => 对应每个operation的output
3. **Why mentioned **<mark style="color:yellow;">**weight calculation**</mark>** in the problem??** \
   The problem description explains the concept of probability because the task requires you to <mark style="color:yellow;">**implement a function that selects an index based on its associated weight,**</mark> essentially <mark style="color:red;">**creating a weighted random selection.**</mark>

</details>

<details>

<summary>Algorithm </summary>

<mark style="color:yellow;">**prefixSum**</mark>

* `prefixSum`是一种常用的编程技巧，指arr中从头开始到给定iindex的所有元素的总和。
* 假设我们有一个 `arr = [1, 2, 3, 4, 5]`。\
  对应的 `prefixSumArr=` `[1, 3, 6, 10, 15]`。
* `prefixSum` 的主要用途是<mark style="color:red;">**快速查询数组中一段连续元素的总和**</mark>。例如，如果你想知道 `arr` 数组中索引 `2` 到索引 `4` 的元素总和，你可以简单地用 `prefixSum[4] - prefixSum[1]` 来得到结果，这是 `15 - 3 = 12`，和直接加 `arr[2] + arr[3] + arr[4]` 得到的结果是一样的。

在本题中，我们<mark style="color:yellow;">**使用**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`prefixSum`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**arr来帮助我们根据weight randomly pick an index**</mark>。

1. 我们首先找到所有权重的总和（也就是 `prefixSum` 数组的最后一个元素），然后生成一个随机数。
2. 然后，我们查找 `prefixSum` 数组中第一个大于或等于这个随机数的元素，对应的index就是我们要选择的index。这样可以确保每个索引被选择的概率与其权重成正比。

</details>

<details>

<summary>Code Demo </summary>

```java
class Solution {
    private int[] prefixSums;
    private int totalSum;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();
        // run a linear search to find the target zone
        for (int i = 0; i < this.prefixSums.length; i++) {
            if (target < this.prefixSums[i])
                return i;
        }
        // to have a return statement, though this should never happen.
        return i - 1;
  }
}
```

```
arr = [1, 3, 2]
prefixSum =  [1, 4, 6]

1----------------4----------6

random num生成方式：targetSum = 6 * [0,1]中间的随机数
假如生成的是5，则选择的index为2✅

问题：
所以为什么要return这个index呢？
这个index是指prefixSum中的index吗？
这个和original array的联系是什么？

回答：
if randomNum = 5, return pickedIndex = 2
这个pickedIndex是 arr 的index，也是 prefixSums 的index。
返回这个pickedIndex的含义是：如果你根据weight从 arr 中随机选择一个元素，你应该选择 arr[2]
这个算法的目标是让每个元素被选中的概率与其权重成正比。
在这个例子中，arr[2] 的权重是 2，占总权重 6 的三分之一，所以 arr[2] 被选中的概率应该是 1/3。
通过生成一个在 [0, totalSum) 范围内的随机数，并查找这个随机数落在 prefixSums 的哪个区间，
我们可以实现这个目标。
```

**Constructor: `Solution(int[] w)`**

* Initialize an array `prefixSums` with the same length as the input array `w`.
* Create a variable `prefixSum` and set it to 0. This will hold the cumulative sum of the weights as we iterate through the array.
* Iterate over the input array `w`:
  * For each element `w[i]`, add it to `prefixSum`.
  * Store the value of `prefixSum` in the corresponding position in `prefixSums` array (`prefixSums[i]`).
* After building the `prefixSums` array, store the final value of `prefixSum` (which is the total sum of all weights) in `totalSum`.

**Method: `pickIndex()`**

* <mark style="color:red;">**random num的生成:**</mark> Generate a random `target` number. This is done by multiplying <mark style="color:yellow;">**`totalSum`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**by a random number between 0 (inclusive) and 1 (exclusive).**</mark>
* Initialize an index counter `i` to 0.
* Iterate over the `prefixSums` array:
  * <mark style="color:yellow;">For each</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`prefixSums[i]`</mark><mark style="color:yellow;">, if</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`target`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">is less than</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`prefixSums[i]`</mark><mark style="color:yellow;">, return</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`i`</mark><mark style="color:yellow;">.</mark>
* If no index was returned during the iteration (which should never happen because `target` is less than `totalSum`), return `i - 1` as a fallback.

The overall idea is to select an index from the input array `w`, with the probability of each index `i` being selected proportional to the value of `w[i]`. The `prefixSums` array and the `target` number are used to implement this weighted randomness.

</details>



<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>心得 Key Points</summary>

1. `Math.random()` 在 `[0, 1)` 区间生成随机浮点数
2.

</details>
