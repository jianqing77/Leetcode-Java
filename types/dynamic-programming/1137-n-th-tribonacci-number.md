---
description: '@Math @Dynamic Programming @Memoization'
---

# 1137 - N-th Tribonacci Number

<details>

<summary>Description 题目描述 </summary>

The Tribonacci sequence T(n) is defined as follows:&#x20;

* T(0) = 0, T(1) = 1, T(2) = 1
* T(n+3) = T(n) + T(n+1) + T(n+2) for n >= 0.

Given `n`, return the value of T(n).

**Example 1:**

<pre><code><strong>Input: n = 4
</strong><strong>Output: 4
</strong>Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
</code></pre>

**Example 2:**

<pre><code><strong>Input: n = 25
</strong><strong>Output: 1389537
</strong></code></pre>

**Constraints:**

* `0 <= n <= 37`
* The answer is guaranteed to fit within a 32-bit integer, ie. `answer <= 2^31 - 1`.

</details>

<details>

<summary>解题思路 Intuition </summary>

* Fibonacci 的变形
* 有时候就是这种变形的题会让人很不知所措

</details>

<details>

<summary>Fibonacci的回顾</summary>

```
F(0) = 0, F(1) = 1
F(n) = F(n-1) + F(n-2), for n > 1
So the sequence goes: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
```

```java
class Solution {

    // intitiate a memo as a HashMap
    private HashMap<Integer, Integer> memo = new HashMap<>();

    private int dp(int i) {
        if (i <= 1) return i;
        
        // Check if the result is already in the memo to avoid re-computation
        if (!memo.containsKey(i)) {
            memo.put(i, dp(i-1) + dp(i-2)); // recursion -- If not, compute it by breaking it into subproblems
        }
        return memo.get(i);
    } 


    public int fibonacci(int n) {
        return dp(n);
    }
}
```

</details>

<details>

<summary>✅ Algorithm </summary>

1. base case的改变
2. recursion的改变
3. 其他的和fibonacci一样

</details>

<details>

<summary>✅ Code Demo </summary>

```java
class Solution {
    // intitiate a memo as a HashMap
    private HashMap<Integer, Integer> memo = new HashMap<>();

    private int dp(int i) { 
        // MAIN DIFFERENCE COMPARED TO BASE FIBONACCI 
        if (i <= 1) return i;
        if (i == 2) return 1;
        
        // Check if the result is already in the memo to avoid re-computation
        if (!memo.containsKey(i)) {
            memo.put(i, dp(i-1) + dp(i-2) + dp(i-3)); // recursion -- If not, compute it by breaking it into subproblems
        }
        return memo.get(i); // the calculated result retreived using key
    } 


    public int tribonacci(int n) { // n: like an index, could be 0
        return dp(n);
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
