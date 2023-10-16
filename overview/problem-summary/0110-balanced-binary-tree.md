---
description: '@Tree @Depth-First Search @Binary Tree'
---

# 0110 - Balanced Binary Tree

<details>

<summary>Problem Description</summary>

Given a binary tree, determine if it is **height-balanced**.

```c
[3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
```

<pre><code><strong>Input: root = [3,9,20,null,null,15,7]
</strong><strong>Output: true
</strong></code></pre>

Given the following tree \[1,2,2,3,3,null,null,4,4]:

```c
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

<pre><code><strong>Input: root = [1,2,2,3,3,null,null,4,4]:
</strong><strong>Output: true
</strong></code></pre>

</details>

<details>

<summary>Balanced Binary Tree</summary>

<mark style="color:orange;">**Balanced Binary Tree**</mark>** **<mark style="color:purple;">**-- 与height相关**</mark>

* A binary tree is balanced if the <mark style="color:yellow;">**tree height =**</mark> <mark style="color:yellow;">**log(n)**</mark> where n is the number of nodes.
* 又称为AVL树 &#x20;

<pre><code>    5
   / \
  3   6
 / \   \
1   4   8
root 5: 左右子树高度都为2，高度差为0；
root 3: 左右子树高度分别为1和1，高度差为0；
root 6: 左右子树高度分别为0和1，高度差为1。
其余节点为叶子节点，左右子树高度都为0。
因此，这是一棵平衡二叉树。

    5
   / \
  3   6
 / \   \
1   4   8
         \
          9
<strong>如果我们在节点8的右侧再添加一个节点9
</strong><strong>这时，节点6的左右子树高度分别为0和2，高度差为2，
</strong><strong>所以这棵树就不再是平衡二叉树
</strong></code></pre>

</details>

<details>

<summary>Algorithm</summary>



</details>

<details>

<summary>Code Demo</summary>



</details>
