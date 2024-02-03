---
description: '@Dynamic Programming @Array'
---

# 🟢 0746 - Min Cost Climbing Stairs

<details>

<summary>Description 题目描述 </summary>

You are given an integer array `cost` where <mark style="color:yellow;">`cost[i]`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">is the cost of</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`ith`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">step on a staircase.</mark> Once you pay the cost, you can either climb <mark style="color:yellow;">one or two steps.</mark>

You can either start from the step with index `0`, or the step with index `1`.

Return _the <mark style="color:yellow;">minimum cost</mark> to reach the top of the floor_.

**Example 1:**

<pre><code><strong>Input: cost = [10,15,20]
</strong><strong>Output: 15
</strong><strong>Explanation: You will start at index 1.
</strong>- Pay 15 and climb two steps to reach the top. The total cost is 15.
</code></pre>

**Example 2:**

<pre><code><strong>Input: cost = [1,100,1,1,1,100,1,1,100,1]
</strong><strong>Output: 6
</strong><strong>Explanation: You will start at index 0.
</strong>- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
</code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

* given:&#x20;
  * `cost[]:` array to store the cost of each step
  * `i`: index of the step
* <mark style="color:yellow;">**state variable**</mark>: dp(i) to store the min cost BEFORE getting to i
* <mark style="color:yellow;">**recursion pattern**</mark>: dp(i) = Math.min( dp(i-1, cost)+ cost\[i-1], dp(i-2) + cost\[i-2]))
  * if not pay cost at current step: pay cost of the prev step-> use accumulated memo + the cost of the prev step
  * if pay cost at current step: must pay for the i-2 step, use accumulated memo + cost of current step

<!---->

* <mark style="color:yellow;">**base cases**</mark>: dp(0) = dp(1) = cost\[i]

</details>

<details>

<summary>✅ Algorithm: Top Down - Memoization</summary>

1. Define a hash map `memo`, where `memo[i]` represents the minimum cost of reaching the $$i^{th}$$ step.
2. Define a function `dp`, where `dp(i)` will determine the minimum cost to reach the $$ithi^{th}ith$$ step.
3. In our function `dp`
   1. first check the base cases: `return 0` when `i == 0` or `i == 1`.
   2. Next, check if the argument `i` has already been calculated and stored in our hash map `memo`.
      1. &#x20;If so, `return memo[i]`.&#x20;
      2. Otherwise, use the recurrence relation to calculate `memo[i]`, and then return `memo[i]`.
4. Simply call and return `dp(cost.length)`. Once again, we can make use of the trick from approach 1 where we treat the top floor as an extra "step". Since `cost` is 0-indexed, `cost.length` will be an index 1 step above the last element of `cost`.

</details>

<details>

<summary>✅ Code Demo </summary>

```java
class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>();

    // Return: total cost BEFORE getting to stair i
    // pass cost as a vairable to avoid deine it as a class-level variable
    private int dp(int i, int[] cost) {
        // base cases: i <= 1 returns 0 is based on the problem formulation where:
        // - The cost array represents the cost to step onto a stair from the previous stair.
        // - start at either step 0 or step 1 => don't have to pay any cost to get to the start
        if (i <= 1) {
            return 0;
        }

        // check if result is already computed
        if (!memo.containsKey(i)) {
            // recursive call and memoization
            memo.put(i, Math.min(dp(i - 1, cost) + cost[i - 1], dp(i - 2, cost) + cost[i-2]));
        }
        return memo.get(i);
    }

    public int minCostClimbingStairs(int[] cost) {
        // start from the step beyond the last step, which is the top of the floor
        return dp(cost.length, cost); 
    }
}
```

</details>

<details>

<summary>Code Analysis</summary>

Time complexity: O(n)

Space Complexity: O(n)

</details>

<details>

<summary>✅ 心得 Key Points</summary>

1. 这道题把cost作为一个params 所以就不需要define class-level cost
2. 心机的点在于dp(i)是cost before getting to the current stair
3. 注意pass in的是cost.length而不是cost.length-1 和之前的两道题有区别
4. 所以其实是会overlap the actual num of stairs

</details>
