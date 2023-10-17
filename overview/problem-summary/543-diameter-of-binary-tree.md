# 543 - Diameter of Binary Tree

<details>

<summary>Description 题目描述 </summary>

Given the `root` of a binary tree, return _the length of the **diameter** of the tree_.

The **diameter** of a binary tree is the **length** of the longest path between any two nodes in a tree. This path may or may not pass through the `root`.

The **length** of a path between two nodes is represented by the number of edges between them.

![](../../.gitbook/assets/image.png)

<pre><code><strong>Input: root = [1,2,3,4,5]
</strong><strong>Output: 3
</strong><strong>Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
</strong></code></pre>

<pre><code><strong>Input: root = [1,2]
</strong><strong>Output: 1
</strong></code></pre>

**Constraints:**

* The number of nodes in the tree is in the range `[1, 104]`.
* `-100 <= Node.val <= 100`

</details>

<details>

<summary>解题思路 Intuition </summary>

### 题目大意

给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

### 解题思路

* 简单题。遍历每个节点的左子树和右子树，累加从左子树到右子树的最大长度。遍历每个节点时，动态更新这个最大长度即可。

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
