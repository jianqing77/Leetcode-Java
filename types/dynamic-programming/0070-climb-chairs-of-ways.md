---
description: '@ Dynamic Programming'
---

# 🟢 0070 - Climb Chairs - # of ways

<details>

<summary>Description 题目描述 </summary>

You are climbing a staircase. It takes `n` steps to reach the top. Each time you can either climb `1` or `2` steps. <mark style="color:yellow;">**In how many distinct ways**</mark> can you climb to the top?

**Example 1:**

<pre><code><strong>Input: n = 2
</strong><strong>Output: 2
</strong><strong>Explanation: There are two ways to climb to the top.
</strong>1. 1 step + 1 step
2. 2 steps
</code></pre>

**Example 2:**

<pre><code><strong>Input: n = 3
</strong><strong>Output: 3
</strong><strong>Explanation: There are three ways to climb to the top.
</strong>1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
</code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

* <mark style="color:red;">**Fibonacci Sequence**</mark>
  * The problem states that we are allowed to take <mark style="color:yellow;">either 1 or 2 steps at a time</mark>.&#x20;
  * Logically, that means <mark style="color:yellow;">to climb to the 30th stair</mark>, we arrived from <mark style="color:yellow;">either the 28th or 29th stair</mark>. Therefore, the number of ways we can climb to the 30th stair is equal to the number of ways we can climb to the 28th stair plus the number of ways we can climb to the 29th stair.
  * we can use the logic from above to define a recurrence relation. In this case, `dp(i) = dp(i - 1) + dp(i - 2)`

</details>

<details>

<summary>👌🏻 Algorithm 1: Use Recursion -> not DP   --> TOP DOWN </summary>

```java
// just a simple recursion based on intuition
// time complexity: O(2^n) => because every call to dp creates 2 more calls to  dp
class Solution {
    private int dp(int i)){
        // base case: i = 1 or i = 2
        if (i <= 2 ) return i;
        return dp(i-1) + dp(i-2);
    }
}
```

</details>

<details>

<summary>✅ Algorithm 2: Add <mark style="color:yellow;">Memoization</mark> -> <mark style="color:yellow;">use DP</mark> --> TOP DOWN</summary>

In fact, without the memoization, this isn't actually dynamic programming - it's just basic recursion. <mark style="color:green;">**Only after we optimize our solution**</mark>** by **<mark style="color:yellow;">**adding memoization**</mark> to <mark style="color:green;">**avoid repeated computations**</mark> can it be called DP.

```java
// Time Complexity: O(n)
class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<>();
    
    private int dp(int i) {
        if (i <= 2) return i;
        // Instead of just returning dp(i - 1) + dp(i - 2), calculate it once and then
        // store it inside a hashmap to refer to in the future
        if (!memo.containsKey(i)) {    // ----- MEMOIZATION
            memo.put(i, dp(i - 1) + dp(i - 2)); // ----- RECURSION
        }
        
        return memo.get(i);
    }
    
    public int climbStairs(int n) {
        return dp(n);
    }
}
```

</details>

<details>

<summary>✅ Algorithm 3: <mark style="color:yellow;">Iteration &#x26; Tabulation</mark> --> BOTTOM UP</summary>

```java
// Some code
class Solution {

    public int climbStairs(int n ) {
        if (n == 1) return i;
        
        // Initiate a array like a table
        int[] dpTable = new int[n+1];
        // Initiate the base cases
        dpTable[1] = 1; // 注意这里的层数是从1开始，不是从0
        dpTable[2] = 2;
        // for Loop 
        for (int i = 3; i <= n; i++) { // 注意这里有个for loop
            dpTable[i] = dpTable[i-1] + dpTable[i-2]
        }
        return 
    } 
}
```

* Time Complexity: O(n) -- Each step requires a constant amount of work—just the summation of the two previous numbers—and there are `n` such steps to reach `F(n)`. Therefore, the time complexity of the bottom-up approach for calculating the `n`th Fibonacci number is `O(n)`
* If you store all computed Fibonacci numbers up to `n`, for instance in an array, the space complexity is `O(n)` because you're storing each computed value.

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>心得 Key Points</summary>



</details>
