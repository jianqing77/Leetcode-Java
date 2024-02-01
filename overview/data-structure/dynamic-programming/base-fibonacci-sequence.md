# 🔹 Base: Fibonacci Sequence

### <mark style="color:yellow;">Fibonacci Sequence</mark>

* The [Fibonacci sequence](https://en.wikipedia.org/wiki/Fibonacci\_number) is a classic example used to explain DP.&#x20;
* The Fibonacci sequence is a series of numbers where&#x20;
  * each number is the sum of the two preceding ones,&#x20;
  * usually starting with 0 and 1:

```
F(0) = 0, F(1) = 1
F(n) = F(n-1) + F(n-2), for n > 1
So the sequence goes: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
```

<details>

<summary>Naive Recursive Solution </summary>

A naive way to compute the n-th Fibonacci number is to use a simple recursive function:

```python
def fibonacci(n):
    if n <= 1:
        return n
    else:
        return fibonacci(n-1) + fibonacci(n-2)
```

However, this approach is highly inefficient for large `n` because it computes the same Fibonacci numbers many times. The time complexity is exponential, specifically O(2^n), because it generates a binary tree of recursive calls.



</details>

### <mark style="color:yellow;">Use Dynamic Programming</mark>

**Dynamic Programming** (DP) is a programming paradigm that can systematically and efficiently explore all possible solutions to a problem. As such, it is capable of solving a wide variety of problems that often have the following characteristics:

* The problem can be <mark style="color:yellow;">**broken down into "overlapping subproblems"**</mark> - <mark style="color:green;">**smaller versions of the original problem**</mark> that are <mark style="color:green;">**re-used**</mark> multiple times.
* The problem has an <mark style="color:yellow;">**"optimal substructure"**</mark> - an optimal solution can be formed from optimal solutions to the overlapping subproblems of the original problem.
* Two Basic Approaches:
  * Approach 1: Bottom Up - Tabulation
  * Approach 2:  Top Down - Memorization

{% hint style="info" %}
<mark style="color:red;">**Memoizing**</mark> a result means to <mark style="color:yellow;">**store the result of a function call**</mark>, usually in a **HashMap** or an **array**, so that when the same function call is made again, we can simply return the **memoized** result instead of recalculating the result.
{% endhint %}

<details>

<summary>Dynamic Programming: <mark style="color:yellow;">Bottom-Up</mark> <strong>(</strong>Tabulation<strong>)</strong></summary>

This approach involves <mark style="color:yellow;">**filling up a table**</mark> based on the <mark style="color:yellow;">**order of computation**</mark>&#x20;

* where the results of <mark style="color:green;">**smaller subproblems are calculated first**</mark>&#x20;
* and used to <mark style="color:green;">**build up solutions to larger subproblems.**</mark>
* The bottom-up approach to dynamic programming is <mark style="color:red;">**iterative**</mark> and <mark style="color:yellow;">**does not use recursion**</mark> at all, which is a fundamental difference from both naive recursion and top-down memoization.&#x20;
* It systematically builds up the solution by solving all subproblems starting with the smallest ones and using their solutions to arrive at the solution to the larger problems.

```java
// Pseudocode example for bottom-up
// int[] fibTable = new int[n] will have the indices from 0 to n-1
F = array of length (n + 1)  
F[0] = 0
F[1] = 1
for i from 2 to n:
    F[i] = F[i - 1] + F[i - 2]
```

```java
public class FibonacciTabulation {

    public static long fibonacci(int n) {
        // Base case: n = 0 and n = 1
        if (n <= 1) {
            return n;
        }
        // Define the fibTable to store the sub-result as table
        long[] fibTable = new long[n + 1];
        fibTable[0] = 0;
        fibTable[1] = 1;
        
        // Start with 2
        for (int i = 2; i <= n; i++) {
            fibTable[i] = fibTable[i - 1] + fibTable[i - 2];
        }
        
        return fibTable[n];
    }
}
```

</details>

<details>

<summary>Example --> Bottom-Up: tabulation, iterative, no recursion</summary>

Let's walk through the bottom-up approach for calculating the Fibonacci sequence with an example. We'll compute the 6th Fibonacci number (`F(6)`), which is the value of the sequence at position 6.

The Fibonacci sequence is defined as follows:

* `F(0) = 0`
* `F(1) = 1`
* For `n > 1`, `F(n) = F(n - 1) + F(n - 2)`

The bottom-up approach will create a table (array) and start by filling in the known base cases (`F(0)` and `F(1)`), then iteratively compute subsequent Fibonacci numbers by summing the two previous numbers in the sequence.

Here's the detailed calculation process:

1.  **Create an array** to store Fibonacci numbers up to `n`. Since arrays are zero-indexed, the array size must be `n + 1` to include the `n-th` element:

    ```java
    int[] fibTable = new int[6 + 1]; // Array of size 7 to store F(0) through F(6)
    ```
2.  **Initialize the base cases** in the array:

    ```java
    fibTable[0] = 0; // F(0)
    fibTable[1] = 1; // F(1)
    ```

    Now the array looks like this: `[0, 1, 0, 0, 0, 0, 0]`
3.  **Iterate from `2` to `n`** and compute each Fibonacci number based on the previous two:

    ```java
    for (int i = 2; i <= 6; i++) {
        fibTable[i] = fibTable[i - 1] + fibTable[i - 2];
    }
    ```

    Let's break down the iteration:

    * When `i = 2`: `fibTable[2] = fibTable[1] + fibTable[0] = 1 + 0 = 1`
    * When `i = 3`: `fibTable[3] = fibTable[2] + fibTable[1] = 1 + 1 = 2`
    * When `i = 4`: `fibTable[4] = fibTable[3] + fibTable[2] = 2 + 1 = 3`
    * When `i = 5`: `fibTable[5] = fibTable[4] + fibTable[3] = 3 + 2 = 5`
    * When `i = 6`: `fibTable[6] = fibTable[5] + fibTable[4] = 5 + 3 = 8`

    After each iteration, the array is updated as follows:

    * After `i = 2`: `[0, 1, 1, 0, 0, 0, 0]`
    * After `i = 3`: `[0, 1, 1, 2, 0, 0, 0]`
    * After `i = 4`: `[0, 1, 1, 2, 3, 0, 0]`
    * After `i = 5`: `[0, 1, 1, 2, 3, 5, 0]`
    * After `i = 6`: `[0, 1, 1, 2, 3, 5, 8]`
4.  **Retrieve the result** from `fibTable[n]`, which is now the last element in our array:

    ```java
    int result = fibTable[6]; // result is 8, which is F(6)
    ```

The final array represents the Fibonacci sequence from `F(0)` to `F(6)`, and we can see that the 6th Fibonacci number is indeed `8`. By using the bottom-up approach, we have avoided the exponential time complexity of the naive recursive approach and computed `F(6)` in `O(n)` time with just a single pass through the array.

Here's the complete Java code for the bottom-up approach:

````java
public class FibonacciBottomUp {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        int[] fibTable = new int[n + 1];
        fibTable[0] = 0;
        fibTable[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            fibTable[i] = fibTable[i - 1] + fibTable[i - 2];
        }
        
        return fibTable[n];
    }

    public static void main(String[] args) {
        int n = 6;
        System```java
        .out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}
````

This Java program demonstrates the bottom-up approach for calculating the Fibonacci number at position 6, which we've broken down step by step in the calculation process above.

</details>

<details>

<summary>Dynamic Programming: <mark style="color:yellow;"><strong>Top-down</strong></mark><strong> (Memoization)</strong></summary>

* This approach involves <mark style="color:yellow;">writing the recursive algorithm</mark> and then <mark style="color:yellow;">storing the results of each Fibonacci computation in a</mark> <mark style="color:red;">**table**</mark> (usually an array or a dictionary).&#x20;
* When the same computation is needed again, the algorithm will <mark style="color:green;">**first check the table to see if the result is already present**</mark> to avoid redundant calculations.

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

```java
// Pseudocode example for top-down

memo = hashmap
Function F(integer i):
    if i is 0 or 1: 
        return i
    if i doesn't exist in memo:
        memo[i] = F(i - 1) + F(i - 2)
    return memo[i]
```

```java
public class FibonacciMemoization {
    private static long[] memo;

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        // Initialize the memoization array if it hasn't been already
        if (memo == null) {
            memo = new long[n + 1];
        }

        // Check if the result is already in the memo array
        if (memo[n] != 0) {
            return memo[n];
        }

        // Store the result in the memo array and return it
        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 50; // for example
        memo = new long[n + 1]; // initialize the memo array
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}

```

```python
def fibonacci(n, memo={}):
    if n <= 1:
        return n
    if n not in memo:
        memo[n] = fibonacci(n-1, memo) + fibonacci(n-2, memo)
    return memo[n]
```

</details>

<details>

<summary>Example --> Top down: memoization, recursion</summary>

For this example, we'll use a memoization table (<mark style="color:yellow;">array</mark>) to store the results of the Fibonacci calculations. As we compute `F(n)` for different values of `n`, we'll save those results in the table. When we need to compute `F(n)` again, we'll first check the table to see if the result is already known.

Starting from `F(6)`, the process is as follows:

1. Check if `F(6)` is in the memoization table. If it is, return that value. If it's not (which it isn't the first time), we need to calculate it.
2. To calculate `F(6)`, we need `F(5)` and `F(4)`. Since they're not calculated yet, we will compute them, following the same process.
3. For `F(5)`, we need `F(4)` and `F(3)`. Again, since they're not calculated, we will compute them, following the same process.
4. This recursion continues until we reach the base cases `F(1)` and `F(0)`, which are known to be `1` and `0`, respectively.

```
F(6)
├─ F(5)
│  ├─ F(4)
│  │  ├─ F(3)
│  │  │  ├─ F(2)
│  │  │  │  ├─ F(1) (returns 1, base case)
│  │  │  │  └─ F(0) (returns 0, base case)
│  │  │  └─ F(1) (returns 1, base case)
│  │  └─ F(2) (already computed, returns value from memoization table)
│  └─ F(3) (already computed, returns value from memoization table)
└─ F(4) (already computed, returns value from memoization table)
```

* **Calculation**
  * **For `F(2)`**:  `F(1) + F(0) = 1 + 0 = 1`. We then store `1` in `memo[2]`.
  * **For `F(3)`**:  `F(2) + F(1) = 1 + 1 = 2`. We then store `2` in `memo[3]`.
  * **For `F(4)`**:  `F(3) + F(2) = 2 + 1 = 3`. We then store `3` in `memo[4]`.
  * **For `F(5)`**:  `F(4) + F(3) = 3 + 2 = 5`. We then store `5` in `memo[5]`.

```
memo: [0, 1, 1, 2, 3, 5, 8]

```

</details>

<details>

<summary>Which one is <mark style="color:yellow;">BETTER</mark>?</summary>

Any DP algorithm can be implemented with either method, and there are reasons for choosing either over the other. However, each method has one main advantage that stands out:

* A bottom-up implementation's runtime is usually faster, as iteration does not have the overhead that recursion does.
* A top-down implementation is usually much easier to write. This is because with recursion, the ordering of subproblems does not matter, whereas with tabulation, we need to go through a logical ordering of solving subproblems.

</details>

<details>

<summary>When we know that we should use DP: </summary>

1 . <mark style="color:yellow;">**ask for optimum value**</mark>

**The first characteristic** that is common in DP problems is that the problem will <mark style="color:green;">**ask for the optimum value**</mark> (maximum or minimum) of something, or the number of ways there are to do something. For example:

* What is the minimum cost of doing...
* What is the maximum profit from...
* How many ways are there to do...
* What is the longest possible...
* Is it possible to reach a certain point...

2\. <mark style="color:yellow;">**future "decisions" depend on earlier decisions**</mark>

Deciding to do something at one step may affect the ability to do something in a later step. This characteristic is what makes a greedy algorithm invalid for a DP problem - we need to factor in results from previous decisions.

</details>

<details>

<summary>Algorithm</summary>

1. <mark style="color:yellow;">F</mark><mark style="color:yellow;">**ind Base Case:**</mark> Finding the base cases is often the easiest part of solving a DP problem, and just involves a little bit of logical thinking. <mark style="color:green;">**When coming up with the base case(s) ask yourself: What state(s) can I find the answer to without using dynamic programming?**</mark> In this example, we can reason that there is only 1 way to climb to the first stair (1 step once), and there are 2 ways to climb to the second stair (1 step twice and 2 steps once). Therefore, our base cases are

</details>
