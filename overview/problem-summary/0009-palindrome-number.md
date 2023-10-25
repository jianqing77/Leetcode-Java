---
description: '@Two Pointers @Math'
---

# 🟢 0009 - Palindrome Number

<details>

<summary>Description 题目描述 </summary>

Given an integer `x`, return `true` _if_ `x` _is a  **palindrome**, and_ `false` _otherwise_.

**Example 1:**

<pre><code><strong>Input: x = 121
</strong><strong>Output: true
</strong><strong>Explanation: 121 reads as 121 from left to right and from right to left.
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: x = -121
</strong><strong>Output: false
</strong><strong>Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: x = 10
</strong><strong>Output: false
</strong><strong>Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
</strong></code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

1. **convert to string and use two pointers**\
   if num<0 => false\
   if num=0 => true\
   if num>0 => convert to string and use two pointers
2. 但是有math的idea作为第二种解法

</details>

<details>

<summary>Algorithm </summary>



</details>

<details>

<summary>✅ Code : <mark style="color:yellow;">convert to String</mark>  O(n) &#x26; O(n) 很容易写对但是runtime高</summary>

卡：integer to string method => **String s **<mark style="color:yellow;">**= Integer.toString(x)**</mark>

```java
class Solution {
    public boolean isPalindrome(int x) {
        // edge cases
        if (x < 0) return false;
        if (x == 0) return true;
        
        // convert integer to string
        String s = Integer.toString(x);
        // two pointers method
        int left = 0;
        int right = s.length() - 1; // 121 // 1221
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
```

<mark style="color:yellow;">**Q: why runtime is not good?**</mark>

将整数转换为字符串可能会导致较低的运行效率，这主要是由于以下几个原因：

1. **string生成**：将整数转换为string需要在内存中为新生成的字符串分配空间。这个过程涉及到内存管理，会消耗一定的时间。
2. **字符操作**：在字符串上进行操作（例如访问特定位置的字符，比较字符等）可能会比直接在整数上进行操作更慢。这是因为字符实际上是以整数（通常是ASCII或Unicode值）的形式存储的，所以处理字符可能意味着处理更大的整数。
3. **无法利用整数运算**：当我们将数字转换为字符串后，我们就无法再利用整数的数学运算了。例如，在检查回文数的问题中，如果我们保持数字为整数，我们可以通过反转一半的数字并与另一半进行比较来快速检查一个数字是否是回文。这样的数学运算在字符串上执行起来会更复杂，因此可能需要更多的时间。

</details>

<details>

<summary>✅  Code: <mark style="color:yellow;">use math</mark> O(logn)&#x26; O(1) 有点难度写对 但是efficieny高</summary>

<mark style="color:green;">**Idea**</mark>**:**  <mark style="color:yellow;">**reverse**</mark>** **<mark style="color:blue;">**the**</mark>** **<mark style="color:yellow;">**second half of the given number**</mark> <mark style="color:blue;">**and compare it with the first half. If they are the same, the number is a palindrome.**</mark> This solution doesn't need to convert the number to a string. Instead, it <mark style="color:yellow;">**operates directly on the integers.**</mark>&#x20;

<mark style="color:green;">**Operation:**</mark> 三个关键点\
\-  repeatedly <mark style="color:blue;">**"popping" the last digit off**</mark> of the original number `x` \
\- <mark style="color:blue;">"</mark><mark style="color:blue;">**pushing**</mark><mark style="color:blue;">"</mark> <mark style="color:blue;"></mark><mark style="color:blue;">**the lastDigit onto the**</mark> <mark style="color:blue;">**revertedNumber**</mark><mark style="color:blue;">.</mark> \ <mark style="color:blue;">-</mark> When <mark style="color:purple;">**x becomes <=revertedNumber**</mark>, we've processed roughly half of the digits in the number.

<mark style="color:green;">**Detailed Steps**</mark>\ <mark style="color:green;">**-**</mark>** **<mark style="color:yellow;">**Edge Case Handling**</mark>: If the <mark style="color:blue;">**number is negative OR it's last digit is 0 (but the number itself is not 0)**</mark>**,** it can't be a palindrome.\
\- <mark style="color:yellow;">**Revert Half of the Digits**</mark>: While `x` is greater than `revertedNumber`, "pop" the last digit off of `x` and "push" it onto the `revertedNumber`. In other words, `revertedNumber = revertedNumber * 10 + x % 10` and `x /= 10`.\
\- <mark style="color:yellow;">**Compare**</mark>: If `x` and `revertedNumber` are the same, or `x` is the same as `revertedNumber` with its last digit removed (which happens in the case where the number has an odd number of digits), then the number is a palindrome.

<mark style="color:green;">**Q: How to get the last digit of an integer?**</mark>

* 当一个integer除以`10`时，<mark style="color:red;">**除法的余数就是这个数的last digit**</mark>
* `1234 % 10 = 123 --- 4`  注意用的是 %modulus operator

<mark style="color:green;">注意:</mark>

* while loop的condition的界定：<mark style="color:blue;">**while x > revertedHalf**</mark> => Continue the loop until x is less than or equal to the reverted half
* 如何update the reverted half <mark style="color:blue;">**revertedHalf = revertedHalf \* 10 + x % 10;**</mark>\ <mark style="color:blue;">**=>**</mark> pop off the last digit of x && add it to reverted half && original reverted half need to \* 10
* compare的时候要涵盖偶数和奇数digit的情况，这样子的话才能针对奇数个digit有好的判断

<mark style="color:green;">**Q:**</mark> 这样如何improve了efficiency? The beauty of this solution lies in the fact that it only needs to process about half of the digits in the number, which makes it more efficient than solutions that process all the digits. Plus, it **doesn't require the extra space** that would be needed for a string representation of the number.

{% code lineNumbers="true" %}
```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x!=0) {
            return false;
        }
        // initiate the revertedHalf
        int revertedHalf = 0;
        while (x > revertedHalf) {  // while loop condition: Continue the loop until x is less than or equal to the reverted half
            revertedHalf = revertedHalf * 10 + x % 10; // update the reverted num
            x /= 10; // remove the last digit of x
        }
        // compare: 涵盖偶数和奇数digit的情况
        if (revertedHalf == x || revertedHalf/=10 == x ) {
            return true;
        }
        return false;
    }

```
{% endcode %}

```javascript
偶数digit情况
// initial 
x = 1221, revertedHalf = 0
// Step 1:(revert the last digit of x)
x = 122, revertedHalf = 1 //  1221 % 10 = 122 --- 1
// Step 2: (revert the next digit)
x = 12, revertedNumber = 12 // 122 % 10 = 12 --- 2
// Now x <= revertedNumber, so we stop here.

奇数digit情况
// initial 
x = 12321, revertedNumber = 0  
// Step 1: (revert the last digit of x)
x = 1232, revertedNumber = 1 // 12321 % 10 = 1232 --- 1
// Step 2: (revert the next digit) 
x = 123, revertedNumber = 12 // 1232 % 10 = 123 ---- 2
// Step 3: (revert the next digit)
x = 12, revertedNumber = 123  // 123 % 10 = 12 --- 3
// Now x is less than revertedNumber, 
// but if we remove the last digit of revertedNumber 
// (which is the middle digit of the original number), 
// x and revertedNumber become equal. So 12321 is a palindrome.
```

**Time Complexity:** The time complexity of the method is O(log(n)), where n is the input integer. This is because in each iteration of the while loop, we are dividing the number by 10, hence, we are reducing the size of the input by a factor of 10 in each step. The logarithm base 10 of n gives us the number of times we can divide n by 10 before we get to a number less than 10, hence the time complexity is O(log(n)).

**Space Complexity:** The space complexity of the method is O(1), as we are using a fixed amount of space to store the input number, the reverted half of the number, and some temporary variables. The space used does not increase with the size of the input number, hence the space complexity is constant.

</details>

<details>

<summary>心得 Key Points</summary>



</details>
