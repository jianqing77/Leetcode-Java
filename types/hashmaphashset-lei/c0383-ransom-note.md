---
description: '@Hash Table @String @Counting'
---

# 🟢 C0383 - Ransom Note

<details>

<summary>Problem Description</summary>

Given two strings `ransomNote` and `magazine`, return `true` _if_ `ransomNote` _can be constructed by using the letters from_ `magazine` _and_ `false` _otherwise_.

Each letter in `magazine` <mark style="color:yellow;">**can only be used once**</mark> in `ransomNote`.

**Example 1:**

<pre><code><strong>Input: ransomNote = "a", magazine = "b"
</strong><strong>Output: false
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: ransomNote = "aa", magazine = "ab"
</strong><strong>Output: false
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: ransomNote = "aa", magazine = "aab"
</strong><strong>Output: true
</strong></code></pre>

**Constraints:**

* `1 <= ransomNote.length, magazine.length <= 105`
* `ransomNote` and `magazine` consist of <mark style="color:yellow;">lowercase English letters.</mark>\
  &#x20;<mark style="color:yellow;">=> 不考虑space/number</mark>

</details>

<details>

<summary>Algorithm</summary>

```sql
ransom: aa magzine: ab  => false
ransom: aa magzine: aba => true
ransom: aaa magzine: ab => false
```

<mark style="color:yellow;">**题目大意：**</mark>

看magazine里的字母能否构成ransom note string,如果可以构成，返回 true ；否则返回 false 。magazine 中的每个字符只能在 ransomNote 中使用一次。

<mark style="color:yellow;">**Intuition:**</mark>&#x20;

* 看magazine里每个char的出现次数frequency是否 >= ransomNote里对应char的出现次数
* 除非所有的char都满足>=，否则return false
* char和frequency一一对应，并要在另一个string里找对应的char和frequency => <mark style="color:yellow;">**HashMap**</mark>

<mark style="color:yellow;">**Algorithm**</mark>

1. Generate a character count HashMap for both Strings => use helper method\
   key: character, value: count
2.  loop through each character(key) in the charCountRansomMap&#x20;

    if the character is not in the charCountMagazine OR if the character's count in charCountRansomMap > the count in charCountMagazine => return false
3. return true

</details>

<details>

<summary>Code Demo</summary>

<mark style="color:yellow;">**Consideration:**</mark>

1. <mark style="color:purple;">**obvious fail case:**</mark> ransom.length() > magazine.length()
2. <mark style="color:purple;">**read the constraint:**</mark> consist of <mark style="color:yellow;">lowercase English letters. => 不考虑space/number</mark>

<mark style="color:yellow;">**卡到的点**</mark>： retrieve only the keys from the ransom note

<pre class="language-java"><code class="lang-java"><strong>// retrieve the keys of a hashmap using map.keySet() 
</strong><strong>// could iterate the set using the for loop
</strong><strong>Set&#x3C;TypeOfKey> mySet = map.keySet(); 
</strong><strong>for (TypeOfKey element : mySet) {
</strong>    System.out.println(element);
}
</code></pre>

<mark style="color:yellow;">**想到的点:**</mark> 用helper method来创建两个hashMap

```java
   private Map generateCharCountHashMap(String s) {
        if (s.length() == 0) {
            return null;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }
```

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // ransom: aabb magzine: abacaab
        // Step 1: construct a hashmap for both ransomNote and magzine 
        Map<Character, Integer> charCountRanMap = generateCharCountHashMap(ransomNote);
        Map<Character, Integer> charCountMagMap = generateCharCountHashMap(magazine);

        // {a: 2, b: 2}
        // {a: 3, b: 2, c:2}
        // Step 2: loop through each key in the ransom note map
        // need to retrieve the keys from charCountRanMap
        for (Character c: charCountRanMap.keySet()) {
            if (!charCountMagMap.containsKey(c) || charCountMagMap.get(c) < charCountRanMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    // helper method
    private Map generateCharCountHashMap(String s) {
        if (s.length() == 0) {
            return null;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }
}
```

</details>

<details>

<summary>Analysis</summary>

Time Complexity: <mark style="color:yellow;">**O(n + m)**</mark>

1. **Comparing lengths of strings**: The comparison `ransomNote.length() > magazine.length()` is a constant time operation, O(1), because getting the length of a string in Java is a constant time operation.
2. **Building the HashMaps**: The <mark style="color:yellow;">**`generateCharCountHashMap`**</mark> method goes through each character in the string and puts it into a HashMap. This operation is O(n), where n is the length of the string. Since this <mark style="color:yellow;">**method is called twice**</mark>, once for `ransomNote` and once for `magazine`, the total time complexity for this step would be <mark style="color:yellow;">**O(n + m),**</mark> where n is the length of `ransomNote` and m is the length of `magazine`.
3. **Iterating over the keys of the ransomNote HashMap**: This is a loop that may traverse through each key in the `charCountRanMap` HashMap. In the worst-case scenario, this is an <mark style="color:yellow;">**O(k)**</mark> operation, where k is the number of unique characters in `ransomNote`. However, since k is limited by the number of unique characters that can exist (which is a constant if we consider only ASCII characters), it can also be considered as <mark style="color:yellow;">**O(1)**</mark> operation in practice.
4. **Checking if the key exists in magazine HashMap**: The `containsKey` operation is a constant time operation, O(1), for a HashMap.
5. **Getting values from the HashMaps**: The `get` operation is a constant time operation, O(1), for a HashMap.

Therefore, given these steps, the overall time complexity of the `canConstruct` method is dominated by the time complexity of building the HashMaps, which is <mark style="color:yellow;">**O(2n + m).**</mark>

**space complexity: **<mark style="color:yellow;">**O(n + m) / O(k)**</mark>

We build two `HashMap`s of counts; each with up to $$k$$ characters in them. This means that they take up $$O(k)$$ space.

For this problem, because $$k$$ is never more than $$262626$$, which is a constant, it'd be reasonable to say that this algorithm requires $$O(1)$$ space.

</details>
