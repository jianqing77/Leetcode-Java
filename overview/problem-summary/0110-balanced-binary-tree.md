---
description: '@Tree @Depth-First Search @Binary Tree'
---

# 🟢 0110 - Balanced Binary Tree

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

<summary>解题思路</summary>

* <mark style="color:yellow;">**Concept不能卡**</mark>：The intuition for checking if a binary tree is height-balanced involves understanding what it means for a tree to be height-balanced. According to the definition, <mark style="color:yellow;">**a binary tree is height-balanced**</mark>** **<mark style="color:orange;">**if for every node in the tree, the height difference between its left subtree and right subtree is at most 1.**</mark>
* <mark style="color:yellow;">**"Every Node of the Tree":**</mark> This suggests a <mark style="color:red;">**recursive approach,**</mark> because <mark style="color:orange;">**for every node, we need to (难想到啊！！)**</mark>
  * <mark style="color:green;">**1.ensure that  its left and right subtrees are balanced**</mark>&#x20;
  * <mark style="color:green;">**2.also calculate the height of these subtrees.**</mark>&#x20;
  *   \=> potential method signature for the helper function:

      ```java
      private int checkHeight(TreeNode node) {
          // ...
      }
      ```

      The <mark style="color:green;">**checkHeight**</mark> function would <mark style="color:green;">**return -1 if the tree is not balanced**</mark> (this is more efficient than throwing an exception), and <mark style="color:green;">**otherwise return the height of the tree.**</mark>&#x20;

      * The height of the tree is the <mark style="color:green;">**maximum of the heights**</mark> <mark style="color:green;">**of the left and right subtrees, plus 1 (for the current node)**</mark>. We can calculate this as we recurse back up the tree, which allows us to efficiently check if the tree is balanced at the same time.
  *   Then, in the `isBalanced` function, we simply need to return whether the height of the tree is not -1:

      ```java
      public boolean isBalanced(TreeNode root) {
          return checkHeight(root) != -1;
      }
      ```
* This is a perfect task for a <mark style="color:yellow;">**post-order recursion traversal**</mark>, where we <mark style="color:orange;">**first recurse on the child nodes**</mark> and <mark style="color:orange;">**then visit the node**</mark>. This allows us to get the heights of the child nodes before visiting the node, which is necessary to determine if the node is balanced.

</details>

<details>

<summary>Algorithm: <mark style="color:red;">Post-Order -  Bottom UP -- recursion</mark></summary>

用helper function <mark style="color:yellow;">**checkHeight()**</mark>

* 对于每个node (Current Node)\
  **1. 确保当前node的左右子树是平衡的** \
  \=> If either left/right subtree are not balanced(checkHeight == -1), **return -1**\
  2\. **计算其左右子树的高度并计算difference**:\
  \=>  Calculate the height of its subtrees. If the height difference > 1, **return -1**

</details>

<details>

<summary>Code Demo</summary>

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode root) {
        // Termination conditon: root == null
        if (root == null) {
            return 0;
        }
        
        // Termination conditon: reaching a leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        // Singly logic of Recursion
        // 1. Ensure current node's left and right subtrees are balanced. 
        //    If either left/right subtree are not balanced(checkHeight == -1), return -1
        // 2. Calculate the height of its subtrees. If the height difference > 1, return -1
        // If both conditions are met, return the max of left and right subtree height and + 1
        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);

        // If either subtree is not balanced, return -1
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        // If the height difference is more than 1, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
```

</details>

<details>

<summary>心得</summary>

* 首先：要<mark style="color:yellow;">**明确 balance tree的概念**</mark>需要满足<mark style="color:yellow;">**两个条件**</mark> && <mark style="color:red;">**把条件转化成IF语句**</mark>
  * <mark style="color:blue;">current node 的left\&right node 都需要是balance的</mark> \
    \=> If EITHER left/right subtree are not balanced(checkHeight == -1), **return -1**
  * <mark style="color:blue;">current node 的left\&right subtree的高度差不能大于1</mark>\
    \=> Calculate the height of its subtrees. If the abs height difference > 1, **return -1**
* **其次：想到用**<mark style="color:yellow;">**helper function**</mark>**的checkHeight我觉得是这个**<mark style="color:yellow;">**问题思考的简化关键**</mark>**，虽然不用checkHeight这个function也可以，但用的话就可以把问题变得很好思考，因为最终只需要retrun checkHeight 是否等于-1 就可以检查是否balance**
* **再者，helper function **<mark style="color:yellow;">**checkHeight的设计**</mark>**也很巧妙，用int作为return值，不仅可以计算每个subtree的height, 还可以标识这个tree是不是balanced**
* **最终，这个问题是**<mark style="color:yellow;">**如何想到用recursion**</mark>**以及recursion的**<mark style="color:yellow;">**termination condition**</mark>**的思考过程也是值得学习的**

</details>

<details>

<summary><mark style="color:yellow;">Q: why or every node, we need to</mark> <br><mark style="color:yellow;">1. Ensure current node its left and right subtrees are balanced</mark> <br><mark style="color:yellow;">2. Calculate the height of its subtrees.</mark></summary>

The requirement to check if a binary tree is height-balanced is based on two conditions:

1. <mark style="color:yellow;">**The left and right subtrees of every node are themselves height-balanced.**</mark> This is derived directly from the definition of a height-balanced tree. If either the left or right subtree is not balanced, the entire tree cannot be balanced. Hence, we need to recursively check if the left and right subtrees are balanced.
2. <mark style="color:yellow;">**The absolute difference between the height of the left subtree and the right subtree for current node is not more than 1.**</mark> Again, this is part of the definition of a height-balanced tree.

Now, why do we need to calculate the heights of the subtrees?

The height of a subtree is a crucial piece of information needed to determine whether a tree is height-balanced. Without knowing the heights of the left and right subtrees, we cannot determine if their height difference is within the acceptable limit (not more than 1).

So, for every node, we need to calculate the heights of its left and right subtrees. This is typically done by taking the maximum height of the left and right subtrees and adding 1 to it (for the current node) during the recursive call.

In summary, we check if the left and right subtrees are balanced (height-difference is not more than 1) and calculate their heights to pass this information up to the parent node. This allows us to use a bottom-up DFS approach, where we calculate and return the information needed by the parent nodes from the child nodes. This procedure is repeated from the leaves up to the root of the tree.

</details>
