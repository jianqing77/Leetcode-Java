---
description: '@Tree @Depth-First Search @Breadth-First Search @Binary Tree'
---

# 🟢 0226 - Invert Binary Tree

<details>

<summary>Description 题目描述 </summary>

Given the `root` of a binary tree, INVERT the tree, and <mark style="color:yellow;">**return**</mark><mark style="color:yellow;">** **</mark>_<mark style="color:yellow;">**its root**</mark>_<mark style="color:yellow;">**.**</mark>

<pre class="language-c"><code class="lang-c">     4                            4
   /   \                        /   \
  2     7                      7     2
 / \   / \                    / \   / \
<strong>1   3 6   9                  9   6 3   1
</strong></code></pre>

<pre><code><strong>Input: root = [4,2,7,1,3,6,9]
</strong><strong>Output: [4,7,2,9,6,3,1]
</strong></code></pre>

```
Input: root = [] // input is null 
Output: []       // output is null
```

</details>

<details>

<summary>解题思路</summary>

### 题目大意

"经典"的反转二叉树的问题。

### 解题思路

还是用recursion来解决，先递归调用反转根节点的left child，然后递归调用反转根节点的right child，然后左右交换根节点的left child和left child。

</details>

<details>

<summary>Algorithm</summary>

<mark style="color:yellow;">**Logic of Singly Layer Recursion:**</mark>&#x20;

* 核心： <mark style="color:red;">**SWAP**</mark>** the left and right node at each recursion**
* **for every node, **<mark style="color:red;">**invert the left and right child**</mark> \
  \=> call invertTree() for each node's left and right child

<mark style="color:yellow;">**Termination Condition:**</mark> \
1\. root == null => return null\
~~2. root = leaf node => if (root.left == null && root.right == null) => return 不需要考虑leaf node~~

<mark style="color:yellow;">**Q：为什么不需要考虑leaf node的情况**</mark>

假如二叉树只有一个节点，比如 `root = [3]`，那么这个二叉树的可视化将会是这样的：

```
  3
 / \
```

这里，`3` 是根节点，它没有左子节点和右子节点（因为它们都是 `null`）。

当你调用 `invertTree(root)` 函数时，会发生以下过程：

1. 检查根节点是否为 `null`。在这个例子中，根节点是 `3`，所以我们继续执行。
2. 将left node和right node交换。在这个例子中，left node和right node都是 `null`，所以交换它们并不会改变任何事情。
3. 对left node和right node点调用 `invertTree` 函数。在这个例子中，left node和right node点都是 `null`，所以这两个递归调用立即返回null。
4. 返回root节点。在这个例子中，我们返回 `3`。

当你的二叉树有三个节点，例如 `root = [2,1,3]`，这个二叉树的可视化将会是这样的：

```
  2
 / \
1   3
```

这里，`2` 是root，`1` 是它的left node，`3` 是它的right node。

当你调用 `invertTree(root)` 函数时，会发生以下过程：

1. 检查根节点是否为 `null`。在这个例子中，根节点是 `2`，所以我们继续执行。
2. 将left node和right node交换。在这个例子中，left node是 `1`，right node是 `3`，所以交换它们后，`1` 变成了right node，`3` 变成了left node。
3. 对left node和right node调用 `invertTree` 函数。在这个例子中，left node和right node都是叶节点（`3` 和 `1`），所以这两个递归调用立即返回null, return null。

</details>

<details>

<summary>Code Demo </summary>

卡：

1. 写了leaf node的termination情况, which does not need
2. singly layer logic 只写了recall invertTree for left and right node, 没写关键的swap

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Termination Condition  O(1)
        if (root == null) {
            return null;
        }
        
        // Singly Layer Logic: 
        // 1. swap the left and right node  O(1)
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        // 2. call invertTree() for each node's left and right child 
        invertTree(root.left);
        invertTree(root.right);
        
        return root; 
    }
}
```

</details>

<details>

<summary>Code Analysis</summary>

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Termination Condition
        // This is a constant time operation, O(1)
        if (root == null) {
            return null;
        }
        
        // Singly Layer Logic: 
        // 1. Swap the left and right node
        // This is a constant time operation, O(1)
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        
        // 2. Call invertTree() for each node's left and right child
        // This is a linear time operation, as we are calling the function recursively for each node
        invertTree(root.left);
        invertTree(root.right);
        
        // The final return is also a constant time operation, O(1)
        return root;
    }
}
```

**时间复杂度：** 该问题的时间复杂度为 O(n)，其中 n 是二叉树中的node number。这是因为我们访问每个节点一次，对于每个节点，我们只执行常数时间的操作。

**空间复杂度：** 在最坏的情况下，树完全不平衡，例如每个节点都只剩下左子节点，递归将会被调用 N 次（树的高度），因此保持调用栈的存储将是 O(N)。但在最好的情况下（树完全平衡），树的高度将是 log(N)。因此，在这种情况下的空间复杂度将是 O(log(N))。

</details>

<details>

<summary>心得 Key Points</summary>



</details>
