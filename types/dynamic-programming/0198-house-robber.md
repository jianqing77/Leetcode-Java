---
description: '@Dynamic Programming @Array'
---

# 🟠 198. House Robber

<details>

<summary>Description 题目描述 </summary>

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that <mark style="color:yellow;">**adjacent houses**</mark>** have s**<mark style="color:yellow;">**ecurity systems**</mark>** connected and it will automatically contact the police if two adjacent houses were broken into on the same night.**

Given an integer array `nums` representing the amount of money of each house, return _the <mark style="color:yellow;">**maximum amount of money you can rob tonight without alerting the police**</mark>_<mark style="color:yellow;">**.**</mark>

**Example 1:**

<pre><code><strong>Input: nums = [1,2,3,1]
</strong><strong>Output: 4
</strong><strong>Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
</strong>Total amount you can rob = 1 + 3 = 4.
</code></pre>

**Example 2:**

<pre><code><strong>Input: nums = [2,7,9,3,1]
</strong><strong>Output: 12
</strong><strong>Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
</strong>Total amount you can rob = 2 + 9 + 1 = 12.
</code></pre>

</details>

<details>

<summary>✅ 解题思路 Intuition </summary>

<mark style="color:yellow;">**How to feel it's DP?**</mark>

* It's asking for the <mark style="color:red;">**maximum**</mark>** **<mark style="color:green;">**of something,**</mark>&#x20;
* and our <mark style="color:red;">**current decisions**</mark> will <mark style="color:red;">**affect**</mark> which options are available for our <mark style="color:red;">**future decisions**</mark><mark style="color:green;">**.**</mark>

<mark style="color:yellow;">**Step 1: Decide State Variables**</mark>

* First, we need to decide on state variables. As a reminder<mark style="color:green;">**, state variables should be fully capable of describing a scenario**</mark>. Imagine if you had this scenario in real life - you're a robber and you have a lineup of houses. If you are at one of the houses, <mark style="color:green;">**the only variable you would need to describe your situation is an**</mark>** **<mark style="color:yellow;">**integer**</mark> - <mark style="color:yellow;">**the index of the house you are currently at.**</mark> Therefore, the only state variable is an integer, say  i, that indicates the index of a house.&#x20;
  * <mark style="color:blue;">**If the problem had an added constraint such as "**</mark>_<mark style="color:blue;">**you are only allowed to rob up to k houses**</mark>_<mark style="color:blue;">**"**</mark>, <mark style="color:green;">**then k would be another necessary state variable**</mark>**.** This is because being at, say house 4 with 3 robberies left is different than being at house 4 with 5 robberies left.
  * You may be wondering - <mark style="color:blue;">**why don't we include a state variable that is a boolean indicating if we robbed the previous house or not?**</mark> We certainly could include this state variable, but we can develop our recurrence relation in a way that makes it unnecessary.
* The problem is asking for "the maximum amount of money you can rob". Therefore, we would use either&#x20;
  * <mark style="color:yellow;">**a function dp(i)**</mark> that returns the maximum amount of money you can rob up to and including house i,&#x20;
  * or <mark style="color:yellow;">**an array dp where dp\[i]**</mark> represents the maximum amount of money you can rob up to and including house i.
  * This means that after all the subproblems have been solved, dp\[i] and dp(i) both return the answer to the original problem for the subarray of nums that spans 00 to ii inclusive.
  * To solve the original problem, we will just need to return dp\[nums.length - 1] or dp(nums.length - 1), depending if we do bottom-up or top-down.

<mark style="color:yellow;">**Step 2:  A recurrence relation to transition between states**</mark>

Next, we need to find a recurrence relation, which is typically the hardest part of the problem. For any recurrence relation, a good place to start is to <mark style="color:yellow;">**think about a general state**</mark> (in this case, let's say we're at the house at index ii), and use information from the problem description to think about how other states relate to the current one.

<mark style="color:yellow;">**If we are at some house, logically, we have 2 options: we can choose to rob this house, or we can choose to not rob this house.**</mark>

1. If we decid<mark style="color:green;">**e not to rob the house,**</mark> then we don't gain any money. Whatever money we had from the previous house is how much money we will have at this house - which is <mark style="color:green;">**dp(i - 1).**</mark>
2. <mark style="color:green;">**If we decide to rob the house, then we gain nums\[i] money.**</mark> However, <mark style="color:red;">**this is only possible if we did not rob the previous house**</mark>. This means the money we had when arriving at this house is the money we had from the previous house without robbing it, which would be however much money we had 2 houses ago, dp(i - 2). After robbing the current house, we will have <mark style="color:green;">**dp(i - 2) + nums\[i]**</mark> money.

From these two options, we always want to pick the one that gives us maximum profits. Putting it together, we have our recurrence relation: `dp(i)=max(dp(i - 1), dp(i - 2) + nums[i])`.

<mark style="color:yellow;">**3. Base cases**</mark>

The last thing we need is base cases so that our recurrence relation knows when to stop. The base cases are often found from clues in the problem description or found using logical thinking. In this problem, if there is only one house, then the most money we can make is by robbing the house (the alternative is to not rob the house). If there are only two houses, then the most money we can make is by robbing the house with more money (since we have to choose between them). Therefore, our base cases are:

1. dp(0) = nums\[0]
2. dp(1)=max⁡(nums\[0], nums\[1])\


</details>

<details>

<summary>✅ Algorithm: TOP DOWN DP - MEMOIZATION</summary>

We are trying to maximize the amount you can rob from a line of houses, but  cannot rob adjacent houses. The `dp` method employs a <mark style="color:yellow;">**top-down dynamic programming approach**</mark> <mark style="color:red;">**with memoization**</mark> to solve this problem.

* Within the `Solution` class, declare a private `HashMap<Integer, Integer>` named `memo` for memoization to store previously computed results.
* Also declare a private `int[]` array called `nums` which will hold the input array representing the amount of money at each house.
* Define a private method `dp(int i)` which takes an integer `i` representing the index of the current house under consideration.
  * Base Cases:
    * `i` == 0 , return the value at the first house (`nums[0]`), because there is no previous house to consider.
    * `i` == 1 , return the maximum of the first two houses (`Math.max(nums[0], nums[1])`), since we can only rob one of the two.
  * If there is no entry in the `memo` map for the current index `i`, compute the value to be memoized:
    * Call `dp(i - 1)` to get the maximum amount that can be robbed from the first `i-1` houses.
    * Call `dp(i - 2)` and add `nums[i]` to get the maximum amount that can be robbed when including the current house `i` and skipping the directly previous one.
    * Use `Math.max` to determine the larger of the two values (robbing the current house vs. not robbing it), and store that value in the `memo` map using the current index `i` as the key.
  * Return the computed or memoized value for the current index `i` from the `memo` map.
* Define a public method `rob(int[] nums)` which sets the `nums` array to the input and starts the dynamic programming process.
  * Assign the input array `nums` to the instance variable `nums`.
  * Call the `dp` method with `nums.length - 1` to initiate the dynamic programming process starting from the last house, and return its result.
  * The result of `dp(nums.length - 1)` will be the maximum amount that can be robbed from the entire line of houses, respecting the condition of not robbing adjacent houses.

This algorithm ensures that each subproblem is calculated only once, and the results are stored in `memo` for future reference. This memoization prevents the exponential time complexity that would be caused by recalculating overlapping subproblems in a naive recursive approach.

</details>

<details>

<summary>✅ Code Demo: TOP DOWN</summary>

````java

class Solution {

    private HashMap<Integer, Integer> memo = new HashMap<>(); // to store the accumulated money
    private int[] nums; // class-level variable

    private int dp(int i) {
        // Base cases: when choosing between the first two houses
        if (i==0) return nums[0];
        if (i==1) return Math.max(nums[0], nums[1]);

        // regular pattern - memo: accumulated money for fast retrieval
        // dp(i-1): not rob current house, choose to rob the prev house
        // dp(i-2 ) + nums[i: rob the current house, so could only rob the house before the prev house to avoid alert
        if (!memo.containsKey(i)) {
            memo.put(i, Math.max(dp(i-1), dp(i-2 ) + nums[i]));
        }
        return memo.get(i);
    }
    // THE INPUT IS AN ARRAY NOT THE INDEX
    public int rob(int[] nums) {
        this.nums = nums; // Assigns the input array to the class-level variable
        return dp(nums.length - 1);
    }
}
```
````

</details>

<details>

<summary>✅ Code Demo: Bottom UP -> TABLIZATION</summary>

```java
class Solution {
    // bottom up approach: tablization
    public int rob(int[] nums) {
        // Check the special input
        if (nums.length == 1) return nums[0];

        // initiate new array as table
        int[] dp = new int[nums.length]; // notice here we just wanna have the length as the input is an array
        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        // use for loop 
        for (int i = 2; i < nums.length; i++ ) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        int lastIdx = nums.length - 1;
        return dp[lastIdx];
    }
}
```

</details>

<details>

<summary>✅ Code Analysis</summary>

**Time Complexity:**

* **O(n):** The `dp` function is called for each index from `0` to `n - 1` where `n` is the length of the input array `nums`. Due to memoization, each index is processed only once. The recursive calls for indices that have already been computed are not re-calculated; instead, the cached values from the `memo` hash map are returned. This means the `dp` function effectively iterates over the array once, leading to a linear time complexity.

**Space Complexity:**

*   **O(n):** The space complexity is determined by two factors:

    * The size of the recursion call stack.
    * The size of the memoization table (in this case, the `memo` hash map).

    Since the `dp` function is called recursively, in the worst case, it could go as deep as `n` levels, if we consider a case where the function calls itself for `dp(i-1)` and `dp(i-2)` without any overlap until `i = 0`. However, due to memoization, we don't actually make `n` separate calls, as results are reused. Thus, the call stack will not contain `n` frames at the same time.

    The memoization table (`memo` hash map) holds a key-value pair for each index from `0` to `n - 1`, which results in a space requirement linearly proportional to the size of the input array `nums`. Therefore, the space complexity due to the memoization table is `O(n)`.

    In conclusion, the space complexity is dominated by the size of the memoization table, which is `O(n)`.

</details>

<details>

<summary>心得 Key Points</summary>

1. decide the state variable: to know the variable to be capable of describing the seneraio
2. define the recursion relation: to transit between states
3. define the base cases: when not using DP

</details>
