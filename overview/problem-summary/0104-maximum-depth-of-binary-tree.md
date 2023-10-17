---
description: '@Binary Tree @Recursion @DFS: Top-down/bottom up✅'
---

# 🟢 0104 - Maximum Depth of Binary Tree

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

<summary>解题思路</summary>

### 题目大意

要求输出一棵树的最大高度。

### 解题思路

* 这一题递归遍历就可，遍历根节点的左孩子的高度和根节点右孩子的高度，取出两者的最大值再+1 即为总高度
* 有两种方式来进行递归recursion: top down 和bottom up
* leetCode定义的node depth =1

</details>

<details>

<summary>✅ Algorithm &#x26; Code Demo: <mark style="background-color:orange;">Bottom-up</mark>  (Recursion) </summary>

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
```

* **Logic of Single-Layer Recursion**: For each node, we first recursively call the <mark style="color:yellow;">**maxDepth**</mark> function for its <mark style="color:yellow;">**left**</mark> and <mark style="color:yellow;">**right**</mark> children. This gives us the <mark style="color:yellow;">**maximum depth of the left subtree and the right subtree**</mark><mark style="color:yellow;">.</mark>  We then return the maximum of these two depths, plus 1 to account for the current node.
* **Termination Condition:** The recursion ends when we encounter a null node, which represents an empty tree. In this case, we return 0, because an empty tree has no depth.

<mark style="color:yellow;">**Why this is "BOTTOM UP"?**</mark>

<img src="../../.gitbook/assets/Screenshot 2023-10-17 at 2.34.01 PM (1).png" alt="" data-size="original">

* The processing (calculating the tree depth) is done after the recursive calls. That's why it's a bottom-up approach: <mark style="color:yellow;">**we first go down to the lowest nodes (leaves), then process the information (calculate depths)**</mark> on our way back up.
* In the bottom-up approach, the algorithm <mark style="color:purple;">**first traverses down to the leaf nodes**</mark> of <mark style="color:purple;">**the tree, and then "returns" back up, calculating the maximum depth as it goes along**</mark>. This is a post-order traversal, which means the root is visited last.
  * `if (root == null) { return 0; }` - If we reach a null node (which is considered a leaf node), we return 0. This is the base case for our recursion and marks the deepest level of leaf nodes.
  * `int left_depth = maxDepth(root.left);` - We then recursively call the function for the left subtree. Notice that we haven't done anything yet with the current node. We're going down to the leaf nodes first.
  * `int right_depth = maxDepth(root.right);` - Similarly, we recursively call the function for the right subtree.
  * `return Math.max(left_depth, right_depth) + 1;` - Only after we've reached the leaf nodes and calculated the depths of left and right subtrees, we "return" back up, calculating the maximum depth of the current subtree. This is done by taking the maximum of the left and right depths and adding 1 to it (for the current node).



</details>

<details>

<summary>Algorithm &#x26; Code Demo: <mark style="background-color:orange;">Top-Down</mark>  (Recursion) -- helper method return int</summary>

```java
// top down: helper function return teh maxDepth 
// helper method: params只有root, 而且不需要考虑leaf node
// 思想和543: calculate max diameter
class Solution {
    int maxDepth = 0; // initialize to 0

    public int maxDepth(TreeNode root) {
        return calculateDepth(root);
        
    }

    // 注意这里calculate depth会return value, 而且不用考虑leaf node
    private int calculateDepth(TreeNode node) {
        // Termination Condition
        if (node == null) {
            return 0;
        }

        // Calculate the depth of left and right node
        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);

        // Update the maxDepth at each node
        maxDepth = Math.max(maxDepth, Math.max(leftDepth, rightDepth) + 1);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
```

</details>

<details>

<summary>Algorithm &#x26; Code Demo: <mark style="background-color:orange;">Top-Down</mark>  (Recursion) -- helper method return void</summary>

```java
class Solution {
    private int maxVal = 0;
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return;
        }
        calculateDepth(root, 1); // pass in the root depth = 1;
        return maxVal;
    } 
    
    private void calculateDepth(TreeNode node, int depth) {
        // add termination condition
        // condition: reach the leaf node
        if (node.left == null && node.right == null) {
            maxVal = Math.max(maxVal, depth);
        }
        calculateDepth(node.left, depth + 1);
        calculateDepth(node.right, depth + 1);
    }
}
```

<mark style="color:yellow;">**Q: Why this is "TOP DOWN" approach?**</mark>

The key point here is that we're <mark style="color:yellow;">**updating the maxDepth as we traverse down the tree**</mark>, <mark style="color:green;">**not after we've reached the bottom and are coming back up**</mark>. This is why it's called a top-down approach: we <mark style="color:yellow;">**start at the top and update our answer as we go down.**</mark>

* `calculateDepth(root, 1);` - We start calculating the depth from the root node (which is at depth 1).
* `if (node == null) { return; }` - If we reach a null node, we just return without doing anything.
* `if (node.left == null && node.right == null) { maxDepth = Math.max(maxDepth, depth); }` - If we reach a leaf node (a node without any children), we update our maxDepth with the maximum of the current maxDepth and the depth of the current leaf node.
* `calculateDepth(node.left, depth + 1); calculateDepth(node.right, depth + 1);` - We then recursively calculate the depth for the left and right children of the current node, increasing the depth by 1 as we go down each level.

<mark style="background-color:yellow;">**Q: Why when we call calculateDepth for the left and right children, depth need + 1**</mark>

* When we move from a node to one of its children, we are moving one level deeper into the tree, so we need to increase the depth by 1
* When we recursively call <mark style="color:green;">**calculateDepth(node.left, depth + 1)**</mark> and <mark style="color:green;">**calculateDepth(node.right, depth + 1)**</mark>, we're essentially saying, "Go to my left child and increase the depth by 1" and "Go to my right child and increase the depth by 1".

<mark style="background-color:yellow;">**Q: recursion的精髓在这道问题中的体现？？**</mark>

* <mark style="color:yellow;">**Logic of Single-Layer Recursion:**</mark>
  * For each node, we recursively call the <mark style="color:green;">**calculateDepth**</mark> function for its left and right children (if they exist), with the <mark style="color:green;">**depth increased by 1.**</mark>&#x20;
  * If the node is a <mark style="color:orange;">**leaf**</mark> (i.e. <mark style="color:green;">**node.left == null && node.right == null**</mark>), we update `answer` to be the maximum of `answer` and the current depth.
* <mark style="color:yellow;">**Termination Condition:**</mark> The recursion ends when we encounter NULL node, we simply return.

</details>

<details>

<summary>Code Analysis</summary>

**Complexity analysis**

* Time complexity : we visit each node exactly once,\
  thus the time complexity is $$O(N$$）， where $$N$$ is the number of nodes.
* Space complexity : in the worst case, the tree is completely unbalanced,\
  _e.g._ each node has only left child node, the recursion call would occur\
  $$N$$ times (the height of the tree), therefore the storage to keep the call stack would be $$O(N)$$. But in the best case (the tree is completely balanced), the height of the tree would be $$log⁡(N)$$. Therefore, the space complexity in this case would be $$O(log⁡(N)$$

In most cases, yes, `maxDepth` will be greater than or equal to `depth` once it has been updated at least once. However, this is not always the case when we consider the entire traversal of the tree, especially when backtracking occurs in a depth-first search (DFS).

Consider this tree:

```
        1 (depth = 1)
      /   \
     2     3 (depth = 2)
    / \
   4   5 (depth = 3)
```

As you traverse from the root (1) to the left child (2), and then to its left child (4), the `depth` increases (from 1 to 3). At node 4, `maxDepth` is updated to 3. Then, as you backtrack to node 2 and traverse to its right child (5), `depth` is still 3, and `maxDepth` remains at 3 as well.

However, after visiting node 5, when you backtrack further to node 2 and then to node 1, the `depth` decreases (from 3 to 1). At this point, `maxDepth` (which is 3) is greater than `depth` (which is 1). Then, as you traverse from node 1 to its right child (3), `depth` increases to 2, but `maxDepth` remains at 3.

So, during the entire traversal of the tree, there will be times when `maxDepth` is greater than `depth`, especially when backtracking occurs. But when you visit a leaf node that is deeper than any previously visited leaf nodes, `depth` will be greater than `maxDepth`, and `maxDepth` will be updated.

This is why the line `maxDepth = Math.max(maxDepth, depth)` is essential. It ensures that `maxDepth` always reflects the maximum depth encountered so far, even when backtracking reduces the current `depth`

</details>

<details>

<summary>Key Points</summary>



</details>
