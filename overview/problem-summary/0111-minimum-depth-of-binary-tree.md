# 0111 - Minimum Depth of Binary Tree

<details>

<summary>Description 题目描述 </summary>

Given a binary tree, find its minimum depth.

The minimum depth is the number of <mark style="color:red;">**nodes**</mark> along the shortest path from the root node down to the nearest leaf node.

```
    3
   / \
  9  20
    /  \
   15   7
```

```
Input: root = [3,9,20,null,null,15,7]
output: 2 (3->9)
```

```
    2
     \
      3
       \
        4
         \
          5
           \
            6
```

```
Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
```

</details>

<details>

<summary>Algorithm 解题思路 </summary>

### 题目大意

给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。说明: 叶子节点是指没有子节点的节点。

### 解题思路

* 递归求出根节点root 到 叶子节点leaf node的深度depth，输出最小值即可

</details>

<details>

<summary>Code Demo </summary>

<pre class="language-java"><code class="lang-java"><strong>class Solution {
</strong>    public int maxDepth(TreeNode root) {
        
    }
}
</code></pre>

注意：

* maxDepth只有一个parameter root, 所以如果用top-down的话需要有helper function, 然而bottom-up的方式不需要

</details>



<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>Key Points</summary>



</details>
