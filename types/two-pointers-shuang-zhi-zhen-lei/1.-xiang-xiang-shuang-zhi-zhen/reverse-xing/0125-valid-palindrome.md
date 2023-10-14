---
description: '@String @Two Pointers'
---

# 🟢 0125 - Valid Palindrome

<details>

<summary>Description 题目描述 </summary>

Given a string, determine if it is a palindrome, considering **only **<mark style="color:yellow;">**alphanumeric**</mark> characters and <mark style="color:yellow;">**ignoring cases.**</mark>

For example,

```c
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
```

Note:

* Have you consider that the string might be empty? This is a good question to ask during an interview.
* For the purpose of this problem, we define empty string as valid palindrome.

</details>

<details>

<summary>Algorithm 解题思路 </summary>

* 题目大意： 判断所给string字符串是否是有效的回文子串
* 题目给了很多限制条件：alphanumeric + ignore cases
* <mark style="color:yellow;">**Preparation: 前期准备 => Helper Classes**</mark>&#x20;
  * 去除所有的空格space和标点符号
    * 自己定义 <mark style="color:green;">**isValidChar()**</mark>
    * 用JDK自带的Character.isLetterOrDigit(char)
  * 转化为lowercase character string&#x20;
    * 自己定义 <mark style="color:green;">**isEqual()**</mark>
    *   用 Character.toLowerCase


* <mark style="color:yellow;">**Two Pointers Approach**</mark>
  * left right pointer(index)的char进行对比
    * 如果一样一方不是valid char的话，跳过
  * 如果不一样的话，return false;
  * 如果一样的话，left right pointer同时对撞靠近
* Summary of Algorithm:
  1. <mark style="color:orange;">**Initialize Pointers**</mark><mark style="color:orange;">:</mark> Set two pointers `left` and `right` to the start and end of the string respectively.
  2. <mark style="color:orange;">**Skip Invalid Characters**</mark><mark style="color:orange;">:</mark> Move `left` and `right` to skip over any characters that aren't alphanumeric (not a letter or a number).
  3. <mark style="color:orange;">**Compare Characters**</mark><mark style="color:orange;">:</mark> Compare the characters at the `left` and `right` pointers. If they're not the same (ignoring case), the string isn't a palindrome, so return `false`. If they are the same, move both pointers inward and continue to the next comparison.
  4. <mark style="color:orange;">**Return Result**</mark><mark style="color:orange;">:</mark> If all pairs of valid characters have been compared and found to be the same, the string is a palindrome, so return `true`.

</details>

<details>

<summary>Code Demo</summary>

* 注意<mark style="color:yellow;">**Character**</mark>的JDK方法
  1. Character.toLowerCase() 而不是a.toLowerCase()
  2. Character.isLetterOrDigit() 来判断character是alphanumeric

<!---->

* 用了 <mark style="color:yellow;">**while (left < right) loop**</mark>
  1. <mark style="color:orange;">**用while而不用 for:**</mark> The while loop is used here because we want to <mark style="color:green;">**increment or decrement our pointers (**</mark><mark style="color:green;">**`left`**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**and**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`right`**</mark><mark style="color:green;">**) based on certain conditions, not just at every step of the loop**</mark>**.** In this case, we want to move `left` and `right` to skip over any invalid characters. <mark style="color:green;">**The NUMBER OF STEPS to take isn't known ahead of time (as it often is with a for loop)**</mark><mark style="color:green;">,</mark> so a while loop is more appropriate in this case.
  2. <mark style="color:orange;">**用left < right而不是 left <= right:**</mark> The condition `left < right` is used to <mark style="color:green;">**PREVENT UNNECESSARY COMPARISION when**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`left`**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**and**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`right`**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**pointers point to the same character.**</mark> In a palindrome, the middle character (in strings of odd length) doesn't need to be compared with anything else, so we can stop when `left` and `right` meet in the middle. If we were to use `left <= right`, we'd do an unnecessary comparison of the middle character with itself.

<pre class="language-java"><code class="lang-java"><strong>class Solution {
</strong>    public boolean isPalindrome(String s) {
        // ----- initialize pointers -----
          int left = 0;
          int right = s.length() - 1;

        // 比较的是char所以相等没有意义
          while ( left &#x3C; right) {
              // ----- SKIP INVALID CHAR ----
              while ( !isValidChar(s.charAt(left))) {
                  left++;
              }
              while ( !isValidChar(s.charAt(right))) {
                  right--;
              }
              // ----- COMPARE CHARACTER -----
              if (!isEqual(s.charAt(left), s.charAt(right))) {
                  return false;
              } else {
                  left++;
                  right--;
              }
          }
          // ----- RETURN RESULT -----
          return true;
        }
        
        // ----- HELPER FUNCTIONS -----
        private boolean isValidChar(Character tarChar) {
            return Character.isLetterOrDigit(tarChar);
        }

        private boolean isEqual(Character a, Character b) {
            return Character.toLowerCase(a) == Character.toLowerCase(b);
        }
    }
}
</code></pre>

</details>

<details>

<summary>Code Analysis</summary>

* Time complexity : $$O(n)$$, in length $$nnn$$ of the string. We traverse over each character at-most once, until the two pointers meet in the middle, or when we break and return early.
* Space complexity : $$O(1)$$. No extra space required, at all.

</details>

<details>

<summary>Key Points</summary>



</details>
