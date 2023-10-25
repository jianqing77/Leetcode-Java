---
description: '@String @Hash Table @Math'
---

# 0012 - Integer to Roman

<details>

<summary>Description 题目描述 </summary>

Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.

<pre><code><strong>Symbol       Value
</strong>I             1
V             5
X             10
L             50
C             100
D             500
M             1000
</code></pre>

For example, `2` is written as `II` in Roman numeral, just two one's added together. `12` is written as `XII`, which is simply `X + II`. The number `27` is written as `XXVII`, which is `XX + V + II`.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:

* `I` can be placed before `V` (5) and `X` (10) to make 4 and 9.&#x20;
* `X` can be placed before `L` (50) and `C` (100) to make 40 and 90.&#x20;
* `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral.

**Example 1:**

<pre><code><strong>Input: num = 3
</strong><strong>Output: "III"
</strong><strong>Explanation: 3 is represented as 3 ones.
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: num = 58
</strong><strong>Output: "LVIII"
</strong><strong>Explanation: L = 50, V = 5, III = 3.
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: num = 1994
</strong><strong>Output: "MCMXCIV"
</strong><strong>Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
</strong></code></pre>

**Constraints:**

* `1 <= num <= 3999`

</details>

<details>

<summary>解题思路 Intuition </summary>



</details>

<details>

<summary>Algorithm </summary>

1. **Initialization**: First, prepare two arrays, one for the integer values and another for the corresponding Roman numerals. Include both the <mark style="color:orange;">**regular values**</mark> (I, V, X, L, C, D, M) and the <mark style="color:orange;">special cases</mark> (IV, IX, XL, XC, CD, CM). <mark style="color:orange;">**Make sure these arrays are sorted in descending order of the integer values.**</mark>
2. **Conversion**: FOR and while loop
   1. Start with an empty string as the initial Roman numeral.&#x20;
   2.  Iterate over each value-symbol pair in the arrays. For each pair, as long as the integer is equal to or larger than the value, append the corresponding symbol to the Roman numeral and subtract the value from the integer. Repeat this process until the integer is reduced to zero.



</details>

<details>

<summary>Code Demo </summary>

```java
class Solution {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num > 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
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
