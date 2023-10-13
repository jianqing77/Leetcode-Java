---
description: '@Math @Binary Search'
---

# 🟢 0069 - Sqrt(x)

<details>

<summary>Description 题目描述 </summary>

Given a <mark style="color:yellow;">**non-negative integer**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`x`**</mark>, return _the <mark style="color:yellow;">square root of</mark>_ <mark style="color:yellow;"></mark><mark style="color:yellow;">`x`</mark> _rounded down to the <mark style="color:yellow;">**nearest integer**</mark>_. The returned integer should be **non-negative** as well.

You **must not use** any built-in exponent function or operator.

* For example, do not use `pow(x, 0.5)` in c++ or `x ** 0.5` in python.

**Example 1:**

<pre><code><strong>Input: x = 4
</strong><strong>Output: 2
</strong><strong>Explanation: The square root of 4 is 2, so we return 2.
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: x = 8
</strong><strong>Output: 2
</strong><strong>Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
</strong></code></pre>

</details>

<details>

<summary>Algorithm 解题思路 </summary>

实现 int sqrt(int x) 函数。计算并返回 x 的平方根，其中 x 是非负整数。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

<mark style="color:yellow;">**How can i know that i should use BINARY SEARCH**</mark>

* Binary search is a strategy to <mark style="color:red;">**find a specific value within a sorted list**</mark>
* 题目要求求出根号 x, 根据题意，根号 x 的取值范围一定在 `[0,x]` 之间，这个区间内的值
  * 是**递增有序**的 sorted&#x20;
  * 有边界的 search space is defined
  * 可以用下标访问的 could get with index

<mark style="color:yellow;">**Compare with Binary Search**</mark>

* binary search是比较mid & target
* sqrt(x)是比较mid\*mid & target = **x**

<mark style="color:yellow;">**Algorithm:**</mark>

* <mark style="color:green;">If</mark> <mark style="color:green;"></mark><mark style="color:green;">`x`</mark> <mark style="color:green;"></mark><mark style="color:green;">==</mark> <mark style="color:green;"></mark><mark style="color:green;">`0`</mark>, the square root is also `0`, so it returns `0` immediately.
* **I**<mark style="color:green;">**nitializes variables**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`left`**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**= 1**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`right`**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**=**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`x`**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**respectively, and**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`ans`**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**to**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`0`**</mark><mark style="color:yellow;">**.**</mark> These represent the range in which the square root of `x` can possibly lie (from `1` to `x`), and the current best approximation of the square root.
* <mark style="color:green;">**While left <= right:**</mark>
  * mid = left +  (right - left ) / 2&#x20;
  * Compute **mid \* mid** and compare it with x:
    * If <mark style="color:green;">**mid \* mid > x,**</mark> move the right boundary <mark style="color:yellow;">**right = mid -1**</mark>
      * Else, if <mark style="color:green;">**mid \* mid < x,**</mark> move the left boundary left = mid + 1 &#x20;
      * <mark style="color:orange;">**updates**</mark><mark style="color:orange;">** **</mark><mark style="color:orange;">**`ans`**</mark><mark style="color:orange;">** **</mark><mark style="color:orange;">**to**</mark><mark style="color:orange;">** **</mark><mark style="color:orange;">**`mid`**</mark> (since `mid` is the largest integer found so far whose square is less than `x`).
      * Otherwise <mark style="color:green;">**mid \* mid == x**</mark>, the integer square root is here, let's return it
* Return ans



</details>

<details>

<summary>Code Demo </summary>

<mark style="color:yellow;">**注意**</mark>

1. **题目的int设定**， edge case: x ==0时的情况直接return0
2. 如何想到binary search: 在可以确定space boundary的 sorted list中找 target value
3. 和传统binary search的区别: 一个是mid和target比较，这个是mid\*mid和target x比较
4. 多个注意overflow的地方：除了mid还有mid\*mid
5. 在mid\*mid\<x时：除了 update边界 要update ans = mid => 有点难想到
6. 在最开始设定一个int ans来 hold answer

```java
class Solution {
    public int mySqrt(int x) {
        int ans = 0;
        
        if(x == 0) {
            return ans;
        }
        
        // Initialize the boundary to [1, x] to find the sqrt
        int left = 1;
        int right = x;
        
        // Start the binary search loop
        while(left <= right){
            // calculete the mid -- avoid overflow
            int mid = left + (right - left) / 2;
            // if mid*mid > x, update the right boundary to [left, mid-1]
            if (x / mid < mid)  {  // not use mid*mid to avoid overflow 
                right = mid - 1; 
            }
            // if mid*mid < x, update the left bound to [mid+1, right]
            else if (x / mid > mid)  { 
                left = mid + 1;
                ans = mid // updates ans to mid as mid is the largest integer found so far whose square is less than x).
            } 
            else {
                ans = mid; // find the sqrt, return mid
                break; // update our answer to mid and break the loop.
            }
        }
        return ans;
    }
}
```

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>Key Points</summary>

* Note that the code uses `x / mid` instead of `mid * mid` to prevent integer overflow. If `mid` is large, `mid * mid` could exceed the maximum value that can be represented by an `int`. By using `x / mid`, the code avoids this problem, since `x / mid` is guaranteed to be less than or equal to `mid`.

</details>
