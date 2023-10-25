---
description: '@String @Hash Table @Math'
---

# 🟢 0013 - Roman to Integer

<details>

<summary>Description 题目描述 </summary>

Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.

```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

For example, two is written as `II` in Roman numeral, just two one's added together. Twelve is written as, `XII`, which is simply `X` + `II`. The number twenty seven is written as `XXVII`, which is `XX` + `V` + `II`.

Roman numerals are usually written largest to smallest from left to right.&#x20;

**Subtraction**\
However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:

* `I` can be placed before `V` (5) and `X` (10) to make 4 and 9.
* `X` can be placed before `L` (50) and `C` (100) to make 40 and 90.
* `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

**Example 1:**

<pre><code><strong>Input: s = "III"
</strong><strong>Output: 3
</strong><strong>Explanation: III = 3.
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: s = "LVIII"
</strong><strong>Output: 58
</strong><strong>Explanation: L = 50, V= 5, III = 3.
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: s = "MCMXCIV"
</strong><strong>Output: 1994
</strong><strong>Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
</strong></code></pre>

**Constraints:**

* `1 <= s.length <= 15`
* `s` contains only the characters `('I', 'V', 'X', 'L', 'C', 'D', 'M')`.
* It is **guaranteed** that `s` is a valid roman numeral in the range `[1, 3999]`.

</details>

<details>

<summary>解题思路 Intuition </summary>

**Intuition**

The problem is asking to convert a Roman numeral into its corresponding integer value. The intuition to solve this problem is understanding the rules of the Roman numeral system. In general, Roman numerals are written from largest to smallest, from left to right. But there are exceptions where a smaller numeral appears before a larger numeral, in which case we need to subtract the smaller one.

**Keywords in Problem Description**

* <mark style="color:yellow;">Roman numerals and their corresponding integer values.</mark>
* Rules of Roman numeral system, <mark style="color:yellow;">especially the exceptions where we need to subtract.</mark>

</details>

<details>

<summary>Algorithm </summary>

1. Create a mapping of Roman numerals to their corresponding integer values.
2. Initialize a variable `total` to store the result.
3. Iterate over the string from left to right.
   * <mark style="color:red;">**key:  If the current Roman numeral is smaller than the next one**</mark>**,** subtract its value from `total`.
   * Otherwise, add its value to `total`.
4. Return `total`.

</details>

<details>

<summary>Code Demo </summary>

注意：

* <mark style="color:yellow;">**关键点**</mark>：<mark style="color:blue;">观察到如果当前的罗马数字比下一个数字小，那么就从总数中减去它的值。</mark>
* <mark style="color:yellow;">**one to one relationship:**</mark> <mark style="color:yellow;">**用Hash Map**</mark> => convert String to HashMap
* 要时刻对比currentChar和nextChar的对应的integer大小
* 要注意line 11的<mark style="color:yellow;">**edge case: indexOutOfBound**</mark>
* <mark style="color:blue;">**String method: get character with index =>**</mark>** **<mark style="color:yellow;">**s.charAt(index)**</mark>

{% code lineNumbers="true" %}
```java
class Solution {

    private Map<Character, Integer> map = new HashMap<>();
    
    // LVIII = 50 - 5 + 1 + 1 +1
    public int romanToInt(String s) {

        populateMap(); // call helper method

        int result = 0;
        
        // if (s.length() == 0) {
        //     return result;
        // }

        // iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            int currentCharValue = map.get(s.charAt(i));
            int nextCharValue = i + 1 < s.length() ? map.get(s.charAt(i+1)) : 0;
            
            if (currentCharValue < nextCharValue) {
                result-=currentCharValue;
            } else {
                result+=currentCharValue;
            }
        }
        return result;
    }
    
    private void populateMap() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}
```
{% endcode %}

The following code in the editorial declared the map as `static` because the Roman numeral-to-integer mappings are the <mark style="color:yellow;">**same for every instance of the**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`Solution`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**class.**</mark> Declaring this map as `static` means it gets initialized only once, when the class is loaded, instead of every time an instance of the class is created.

This can be advantageous in terms of <mark style="color:yellow;">**memory usage and performance**</mark> in a scenario where you're creating many instances of the `Solution` class and calling `romanToInt` on each one. Since the mappings don't change, it's not necessary to create a new map for each instance.

```java
// improve the runtime and storage
class Solution {

    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = 0;

        // iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            int currentCharValue = map.get(s.charAt(i));
            int nextCharValue = i + 1 < s.length() ? map.get(s.charAt(i+1)) : 0;
            
            if (currentCharValue < nextCharValue) {
                result-=currentCharValue;
            } else {
                result+=currentCharValue;
            }
        }
        return result;
    }
    
}
```

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>心得 Key Points</summary>



注意：

* <mark style="color:yellow;">**关键点**</mark>：<mark style="color:blue;">观察到如果当前的罗马数字比下一个数字小，那么就从总数中减去它的值。</mark>
* <mark style="color:yellow;">**one to one relationship:**</mark> <mark style="color:yellow;">**用Hash Map**</mark> => convert String to HashMap
* 要时刻对比currentChar和nextChar的对应的integer大小
* 要注意line 11的<mark style="color:yellow;">**edge case: indexOutOfBound**</mark>
* <mark style="color:blue;">**String method: get character with index =>**</mark>** **<mark style="color:yellow;">**s.charAt(index)**</mark>

</details>
