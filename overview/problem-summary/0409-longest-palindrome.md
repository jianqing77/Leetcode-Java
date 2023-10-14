---
description: '@HashTable @String @Greedy'
---

# 🟢 0409 - Longest Palindrome

<details>

<summary>Description 题目描述 </summary>

Given a string `s` which consists of <mark style="color:yellow;">**lowercase or uppercase**</mark> letters, return _the <mark style="color:yellow;">**length**</mark> of the <mark style="color:yellow;">**longest palindrome**</mark>_ that can be <mark style="color:yellow;">**built with those letters.**</mark>

Letters are <mark style="color:red;">**case sensitive**</mark>, for example, `"Aa"` is not considered a palindrome here.

**Example 1:**

<pre><code><strong>Input: s = "abccccdd"
</strong><strong>Output: 7
</strong><strong>Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: s = "a"
</strong><strong>Output: 1
</strong><strong>Explanation: The longest palindrome that can be built is "a", whose length is 1.
</strong></code></pre>

</details>

<details>

<summary>Algorithm </summary>

<mark style="background-color:orange;">**题目大意：**</mark>

给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。注意:假设字符串的长度不会超过 1010。

<mark style="background-color:orange;">**解题思路：**</mark>

1. <mark style="background-color:purple;">**First Impression**</mark>
   1. **string manipulation**&#x20;
   2. **understanding the properties of palindromes.** A palindrome is a string that reads the same backward as forward. To create the longest palindrome from a set of characters, we need to understand that <mark style="color:yellow;">a palindrome is almost always symmetrical, except for one character which can sit in the middle if the total length is odd.</mark>
2.  <mark style="background-color:purple;">**Thinking Process**</mark>

    Here are the main keywords and ideas to consider:

    * **Palindrome**: A palindrome is a string that reads the same backward as forward. This means that for most characters in a palindrome, there must be a matching pair on the opposite side. This leads us to the idea of pairing characters.
    * **Longest**: We are not just asked to create any palindrome, <mark style="color:yellow;">**but the longest one possible.**</mark> This suggests we need to use as many characters as possible.
    * **Case Sensitive**: "Aa" is not a palindrome because it is case sensitive. This means we must <mark style="color:yellow;">**treat lowercase and uppercase letters as distinct characters.**</mark>

    Based on these keywords and understanding of palindromes, here's a possible way to approach the problem:

    * Count the occurrences of each character in the string.
    * For each character that appears an even number of times, we can add all of them to the palindrome (pairing them up).
    * For characters that appear an odd number of times, we can add one less than the total occurrence to the palindrome, leaving out one character (since we can only have one unpaired character in a palindrome).
    * If there is at least one character that appears an odd number of times, we can place one of them in the middle of the palindrome.

<mark style="background-color:orange;">**How can this problem related to Greedy and HashTable?**</mark>

1. **Greedy Algorithms**: The problem is related to greedy algorithms because we want to <mark style="color:yellow;">use as many characters as possible to form the longest palindrome</mark>. The greediness is evident when we choose to use all pairs of characters that we can. For characters that occur an odd number of times, we use `count - 1` characters, which allows us to form pairs and add to the length of the palindrome. The one character left (if any exist) can be used as the center of the palindrome if the total length of the palindrome is odd. This reflects the greedy strategy of making the locally optimal choice at each step with the hope of finding the global optimum.
2. **Hash Tables**: A hash table (in the form of a character counter in most languages) is an ideal data structure for this problem because <mark style="color:yellow;">we need to keep track of the frequency of each character in the string</mark>. In most programming languages, this could be a HashMap (in Java), a dictionary (in Python), or an object (in JavaScript). By <mark style="color:yellow;">iterating through the string once, we can build a hash table where the keys are the characters and the values are their frequencies.</mark> This will allow us to quickly look up the count of each character when forming the longest possible palindrome.

<mark style="background-color:orange;">**Algo Using Both Greedy and HashMap**</mark>

1. Create an empty `HashMap` called `charCount`. This will store each character in the string `s` as keys and their respective counts as values. Loop through each character `c` in the string `s`. For each character:
   1. If the character is already in the `charCount` map, increment its count.
   2. If the character is not in the `charCount` map, add it with a count of 1.

<!---->

2. Initialize a int <mark style="color:green;">**length**</mark> = 0: keep track of the max length of the palindrome that can be built.
3. [Initialize a boolean](#user-content-fn-1)[^1] <mark style="color:green;">**odd = false:**</mark> keep track of whether we have encountered any character with an odd count.
4. Loop through the counts of each character in the `charCount` map:
   1. <mark style="color:green;">**If the count is even,**</mark> add the [<mark style="color:yellow;">**count**</mark>](#user-content-fn-2)[^2] to `length`, since all of these characters can be used to build the palindrome.
   2. <mark style="color:green;">**If the count is odd,**</mark> add `count - 1` to `length` <mark style="color:yellow;">(because</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`count - 1`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">is the largest even number less than</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`count`</mark><mark style="color:yellow;">) and set</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`odd`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">to true.</mark>
5. After the loop, if `odd` is true, increment `length` by one. This is because if there is at least one character with an odd count, <mark style="color:yellow;">**one such character can be placed in the center of the palindrome.**</mark>
6. Finally, return `length`. This is the length of the longest palindrome that can be built with the characters in `s`.

</details>

<details>

<summary>Code Demo </summary>

注意：

* <mark style="color:yellow;">**String Iteration:**</mark> iterate each character through a String

```
str.toCharArray()
```

* <mark style="color:yellow;">**HashMap**</mark>** Function**

<pre class="language-java"><code class="lang-java">// retrieve the value with key:  
<strong>map.get(key);
</strong>map.getOrDefault(key, value);
// check if map contains key
map.containsKey(k);
// values() method returns a Collection not array or arrayList
// more general than both arrays and ArrayList
map.values()
// generate a arraylist
ArrayList&#x3C;Integer> arrayList = new ArrayList&#x3C;>(map.values());
</code></pre>

<pre class="language-java"><code class="lang-java">
class Solution {
    public int longestPalindrome(String s) {
        // Step 1: O(n)
        // Create a map to keep track of each character's frequency
        // Loop through the string, incrementing the count of each character in the map.
        Map&#x3C;Character, Integer> charCounts = new HashMap&#x3C;>();
        for (char c: s.<a data-footnote-ref href="#user-content-fn-3">toCharArray()</a>) {
            if (charCounts.<a data-footnote-ref href="#user-content-fn-4">containsKey</a>(c)) {
                int newCount = charCounts.get(c) + 1;
                charCounts.put(c, newCount);
            } else {
                charCounts.put(c, 1);
            }
        }
        // Step 2: Initialzation of int length and boolean odd
        int length = 0;
        boolean odd = false;
        
        // step3: Loop through the map, adding even counts to length 
        // if a count is odd, add count - 1 to length and set the odd flag to true.
        // O(1) while technically the time complexity could be considered O(m), 
        // in practice, m is a constant that does not increase with the size of the input string
        // so we often simplify this to O(1)
        for (int count: charCounts<a data-footnote-ref href="#user-content-fn-5">.values()</a>) {
            if (count % 2 == 0) {
                length += count; // count not 2
            } else {
                // => at lease add the largest even number possible
                length += <a data-footnote-ref href="#user-content-fn-6">count - 1;</a>  // handle count = 1 and odd 
                <a data-footnote-ref href="#user-content-fn-7">odd = true</a>;
            }
        }
        if (odd) { // as long as one odd count exist
            length += 1; //  => could be added to the palindrome middle
        }
        return length;
    }
}

</code></pre>

</details>

<details>

<summary>Code Analysis</summary>

1. 难：想到用odd来标记最后是否length+1
2. 很多methods关于hash map不熟悉
3. 用更简单的方式写step1

```java
// Step 1: O(n)
// Create a map to keep track of each character's frequency
// Loop through the string, incrementing the count of each character in the map.
Map<Character, Integer> charCounts = new HashMap<>();
for (char c: s.toCharArray()) {
    charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
}

```

</details>

<details>

<summary>Key Points</summary>



</details>

[^1]: 难想到

[^2]: not2   &#x20;

[^3]: 

[^4]: &#x20;

[^5]: 

[^6]: 

[^7]: 
