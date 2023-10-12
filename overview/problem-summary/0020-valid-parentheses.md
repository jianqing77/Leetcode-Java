---
description: '@Stack'
---

# 🟢 0020 - Valid Parentheses

<details>

<summary>Description 题目描述 </summary>

Given a string containing just the characters '(', ')', '{', '}', '\[' and ']', determine if the input string is valid.

An input string is valid if:

* Open brackets must be closed by the same type of brackets.
* Open brackets must be closed in the correct order.
* Note that an empty string is also considered valid.

Example 1:

```
Input: ""
Output: true
```

Example 2:

```
Input: "()[]{}" Output: true
```

Example 3:

```
Input: "((()(()))) " Output: true
```

Example 4:

```
Input: "([)]" Output: false
```

Example 5:

```
Input: "{[]}" Output: true
```

</details>

<details>

<summary>Algorithm 解题思路 </summary>

#### 题目大意：括号匹配问题

<mark style="background-color:green;">注意：</mark>

* input是个String
* 并不是所有的left bracket在前，right bracket在后，可能穿插

Examples:

```
"([])][{}"   --- false 因为中间][不是
"(( () (()) ))" --- true 每对都match
"([)]" --- false
"{[]}"  --- true
```

<mark style="color:yellow;">**Algo**</mark>

* 遇到左括号就进栈push&#x20;
* 遇到右括号并且stack top为与之"对应"的左括号，就把栈顶元素出栈&#x20;
* 最后看栈里面还有没有其他元素，如果为空，即匹配&#x20;
* 需要注意，空字符串是满足括号匹配的，即输出 true

<mark style="color:yellow;">**Algo Leetcode:**</mark>

1. Initialize a stack S.
2. Process _each bracket of the expression_ one at a time.
3. If we encounter an opening bracket, we simply push it onto the stack. This means we will process it later, let us simply move onto the **sub-expression** ahead.
4. If we encounter a closing bracket, then we <mark style="color:orange;">**check the element on top of the stack**</mark>. If the element at the top of the stack is an <mark style="color:orange;">opening bracket</mark> <mark style="color:orange;"></mark><mark style="color:orange;">`of the same type`</mark>, then we pop it off the stack and continue processing. Else, this implies an invalid expression.
5. In the end, if we are left with a stack still having elements, then this implies an invalid expression.

</details>

<details>

<summary>Code Demo</summary>

1. <mark style="color:purple;">用</mark><mark style="color:purple;">**HashMap作为field**</mark>** :**
   1. <mark style="color:yellow;">**储存应对应的 () \[] {}**</mark> => 简化中间 涉及到check if the left and right bracket is a matched couple
   2. <mark style="color:yellow;">**key: closing bracket ; value: open bracket的设计**</mark>：中间涉及到map.get(key) == topElement 用key来retrieve对应的value简单，用value来retrieve对应的key复杂
2. <mark style="color:purple;">**用Stack来处理reason:**</mark>&#x20;
   1. The key idea behind using a stack to solve this problem is that the <mark style="color:yellow;">problem involves managing a sequence of characters</mark> where the <mark style="color:yellow;">**ORDER**</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">in which they appear is important.</mark> Specifically, it requires us to check if the closing brackets match with the corresponding opening brackets in the correct order.
   2. Using two pointers wouldn't be as effective in this problem because you'd need to somehow keep track of all the unmatched opening brackets and their positions, which is exactly what the stack does for us in a very efficient way.
3. <mark style="color:purple;">**line 27 考虑到遇到closing bracket时stack为empty的情况**</mark>**:**
   1. &#x20;If you call `pop()` on an empty stack in Java, it will throw an <mark style="color:purple;background-color:green;">`EmptyStackException`</mark><mark style="background-color:green;">.</mark> => <mark style="color:green;">所以要处理：遇到 closing bracket尝试pop stack时候，如果stack是空的要给个place holder "#"</mark>
   2. example: () ]\[ => 处理到 “]"的时候stack是空的
4. Edge Case: Empty String的处理

<pre class="language-java" data-line-numbers><code class="lang-java">class Solution {

   public Map&#x3C;Character, Character> mappings;
   
   public Solution() {
        this.mappings = new HashMap&#x3C;>();
        this.mappings.put(')', '(');
        this.mappings.put(']', '[');
        this.mappings.put('}', '{');
    }

    public boolean isValid(String s) {
        // Edge Case: s is empty
        if (s.isEmpty()) {
            return true;
        }
        // "([])][{}" --- false
        Stack&#x3C;Character> stack = new Stack&#x3C;>();
        for (int i = 0; i &#x3C; s.length(); i++) {
            char c = s.charAt(i);
            // if c is open bracket
            if (this.mappings.containsValue(c)) {
                stack.push(c);
            } else {
                // if c is closing bracket
                // pop the top element from the stack and check if they match
                // 如果stacks是空的: 要给placeholder不然会throw emptyStackException
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                System.out.println("topElement: " + topElement);
                if (<a data-footnote-ref href="#user-content-fn-1">this.mappings.get(c)</a> != topElement) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
</code></pre>

</details>

<details>

<summary>Code Analysis</summary>

* Time complexity : $$O(n)$$ because we simply traverse the given string one character at a time and push and pop operations on a stack take $$O(1)$$ time.
* Space complexity : $$O(n)$$ as we **push all opening brackets onto the stack** and in the worst case, we will end up pushing all the brackets onto the stack. e.g. `((((((((((`.

</details>

<details>

<summary>Key Points</summary>

* This solution assumes that the input string only contains `(`, `)`, `{`, `}`, `[` and `]`. If there are other characters, the solution needs to be adjusted.
* This solution can handle cases where the string is empty, by returning `true` as an empty string is technically a valid input.

<!---->

* <mark style="background-color:yellow;">**Stack**</mark>
  * Stack\<Character> stack = new Stack<>();
  * stack.push()
  * stack.pop()
* <mark style="background-color:yellow;">String</mark>
  * s.charAt(index)
  * s.length() 注意括号 arr.length的对比
  * check string is empty or not

<pre class="language-java"><code class="lang-java"><strong>if (str.isEmpty()) { 
</strong>    System.out.println("String is empty");
}
if (str.length() == 0) { 
    System.out.println("String is empty");
}
</code></pre>

</details>

[^1]: 
