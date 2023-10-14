# 🟢 0278 - First Bad Version

<details>

<summary>Description 题目描述 </summary>

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have `n` versions `[1, 2, ..., n]` and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API `bool isBadVersion(version)` which returns whether `version` is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

**Example 1:**

<pre><code><strong>Input: n = 5, bad = 4
</strong><strong>Output: 4
</strong><strong>Explanation:
</strong>call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
</code></pre>

**Example 2:**

<pre><code><strong>Input: n = 1, bad = 1
</strong><strong>Output: 1
</strong></code></pre>

</details>

<details>

<summary>Algorithm 解题思路 </summary>

**本质：**在这个二分搜索的变体中，我们尝试找到<mark style="color:red;">**"第一个"坏版本，所以我们实际上在寻找一个区间的左边界**</mark>。

<pre class="language-sql"><code class="lang-sql"><strong>Scenario #1: isBadVersion(mid) => false
</strong> 1 2 3 4 5 6 7 8 9
 G G G G G G B B B       G = Good, B = Bad
 |       |       |
left    mid    right   
isBadVersion(mid) = false => left = mid + 1
---------------------------------------------
 6   7 8 9
 G   B B B   mid = 6 + (9-6)/2 = 7    
 |   |   |      
left mid right
---------------------------------------------
isBadVersion(mid) = true => right = mid

 6   7
 G   B   mid = 6    
 |   |         
mid right
isBadVersion(mid) = false => left = mid + 1 = 7
left == right == false => return left

===============================================
Scenario #2: isBadVersion(mid) => true
 1 2 3 4 5 6 7 8 9
 G G G B B B B B B       G = Good, B = Bad
 |       |       |
left    mid    right
---------------------------------------------
 1 2 3 4 5 6 7 8 9
 G G G G B B B B B       G = Good, B = Bad
 |       |       |
left    mid    right
</code></pre>

</details>

<details>

<summary>Code Demo </summary>

<mark style="background-color:yellow;">**Why left < right not left <= right?**</mark>

* 在这个二分搜索的变体中，我们尝试找到<mark style="color:red;">**"第一个"坏版本，所以我们实际上在寻找一个区间的左边界**</mark>。在这种情况下，我们通常使用 `while (left < right)` 而不是 `while (left <= right)`。
* 原因是，<mark style="color:yellow;">当我们使用</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`while (left < right)`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">时，循环结束时，</mark><mark style="color:yellow;">`left`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">和</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`right`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">将指向同一个位置</mark>，这就是我们要找的左边界。而我们在循环中的操作确保了这个位置就是第一个坏版本。
* 但是，如果我们使用 `while (left <= right)`，可能会出现这样的情况：<mark style="color:purple;">当</mark> <mark style="color:purple;"></mark><mark style="color:purple;">`left`</mark> <mark style="color:purple;"></mark><mark style="color:purple;">和</mark> <mark style="color:purple;"></mark><mark style="color:purple;">`right`</mark> <mark style="color:purple;"></mark><mark style="color:purple;">指向同一个 "坏版本"，并且这个 "坏版本" 是我们要找的左边界时，我们的</mark> <mark style="color:purple;"></mark><mark style="color:purple;">`mid`</mark> <mark style="color:purple;"></mark><mark style="color:purple;">也会指向这个 "坏版本"，因此</mark> <mark style="color:purple;"></mark><mark style="color:purple;">`right = mid`</mark> <mark style="color:purple;"></mark><mark style="color:purple;">不会改变</mark> <mark style="color:purple;"></mark><mark style="color:purple;">`right`</mark> <mark style="color:purple;"></mark><mark style="color:purple;">的值。</mark>在下一次循环中，`left`、`right` 和 `mid` 的值都不会改变，从而导致无限循环。
* 所以，为了避免这种可能的无限循环，我们在寻找左边界时通常使用 `while (left < right)`。

<pre class="language-java"><code class="lang-java">/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
// 1 &#x3C;= bad &#x3C;= n &#x3C;= 231 - 1
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1; //  n >= 1, we could use left = 0 like classic binary search
        int right = n; // n is an int, we could only use n as right
        while <a data-footnote-ref href="#user-content-fn-1">(left &#x3C; right) </a>{
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
</code></pre>

</details>

<details>

<summary>Code Analysis</summary>

* Time complexity : $$O(log⁡n)$$.\
  The search space is halved each time, so the time complexity is $$O(log⁡n)$$.
* Space complexity : $$O(1)$$.

</details>

<details>

<summary>Key Points</summary>



</details>

[^1]: &#x20;   &#x20;
