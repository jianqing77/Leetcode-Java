# 0007 - Reverse Integer



<details>

<summary>Description 题目描述 </summary>

Given a signed 32-bit integer `x`, return `x` _with its digits reversed_. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-231, 231 - 1]`, then return `0`.

**Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**

<pre><code><strong>Input: x = 123
</strong><strong>Output: 321
</strong></code></pre>

<pre><code><strong>Input: x = -123
</strong><strong>Output: -321
</strong></code></pre>

<pre><code><strong>Input: x = 120
</strong><strong>Output: 21
</strong></code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

<mark style="color:yellow;">**题目大意:**</mark> 要求反转一个32位有符号整数的数字。如果反转数字导致结果超出32位有符号整数的范围\[-2^31, 2^31 - 1]，则应返回0。我们假设环境不允许存储64位的整数（无论是有符号还是无符号）

* The problem is asking to reverse the digits of an integer. A key point to consider is <mark style="color:yellow;">**handling the overflow**</mark>. Since the problem specifies that the environment only allows <mark style="color:yellow;">**32-bit signed integers**</mark>, we need to make sure the reversed integer does not exceed this limit.
* The keywords in this problem are <mark style="color:yellow;">**"reverse", "integer", "signed 32-bit", and "overflow**</mark>". These keywords give us a hint that we need to&#x20;
  * tackle this problem by <mark style="color:blue;">**considering each digit of the integer,**</mark>&#x20;
  * 注意 <mark style="color:blue;">**sign of the integer**</mark>&#x20;
  * 注意 <mark style="color:blue;">**possible overflow condition.**</mark>

</details>

<details>

<summary>Algorithm </summary>





</details>

<details>

<summary>Code Demo </summary>

```java
```

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>心得 Key Points</summary>



</details>
