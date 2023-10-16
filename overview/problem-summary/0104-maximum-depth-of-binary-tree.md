---
description: '@Recursion @Top-down/bottom up'
---

# 0104 - Maximum Depth of Binary Tree

<details>

<summary>Description 题目描述 </summary>

Given a binary tree, find its <mark style="color:yellow;">**maximum depth**</mark>.

The maximum depth is the number of <mark style="color:red;">**nodes**</mark> along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

```c
    3      depth = 1
   / \
  9  20    depth = 2
    /  \
   15   7  depth = 3
```

<pre><code><strong>Input: [3,9,20,null,null,15,7]
</strong>Output: 3
</code></pre>

</details>

<details>

<summary>概念明晰：Depth &#x26; Height </summary>

&#x20;<mark style="background-color:red;">**value: Max Depth == Height**</mark>

* <mark style="color:yellow;">**Depth**</mark> : the <mark style="color:purple;">**number of**</mark>** **<mark style="color:yellow;">**nodes/ edges**</mark> from the node to the tree's root node.&#x20;
  * 以root为起点，从上往下看&#x20;
    * 以node为基准: depth of root = 1 => leetcode
    * 以edge为基准: depth of root = 0
  * <mark style="background-color:orange;">**LeetCode: depth  start from 1 (always count the root)**</mark>
* <mark style="color:yellow;">**Height:**</mark> the <mark style="color:purple;">**number of**</mark>** **<mark style="color:yellow;">**nodes/edges**</mark> on the _<mark style="color:red;">**longest path**</mark>_ from the node to a leaf.&#x20;
  * 以leaf node这个level为起点， 从下往上看
    * 以node为基准: depth of root = 1 => leetcode
    * 以edge为基准: depth of root = 0

![](<../../.gitbook/assets/Screenshot 2023-10-16 at 10.24.25 PM.png>) 不是leetcode的root depth = 1&#x20;

</details>

<details>

<summary>Algorithm 解题思路 </summary>

### 题目大意

要求输出一棵树的最大高度。

### 解题思路

这一题递归遍历就可，遍历根节点的左孩子的高度和根节点右孩子的高度，取出两者的最大值再加一即为总高度



</details>

<details>

<summary>Code Demo </summary>



</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>Key Points</summary>



</details>
