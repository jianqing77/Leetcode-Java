---
description: '@Recursion @Binary Tree'
---

# 🟢 94 -  Binary Tree Inorder Traversal

<details>

<summary>Description 题目描述 </summary>

Given a binary tree, return the inorder traversal of its nodes' values.

Example :

```c
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
```

</details>

<details>

<summary>Algorithm 解题思路 </summary>

[In-order Traversal](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/#in-order-traversal): left subtree -> root -> right subtree

<mark style="color:orange;">**Algorithm: recursion**</mark>

1. In-order traversal of left subtree
2. Visit the root node
3. In-order traversal of right subtree

* <mark style="color:orange;">**How to assume the subproblem have been solved?**</mark>
  * In the code, when we call `inorderHelper(root.left, result)` and `inorderHelper(root.right, result)`, we are essentially assuming that we know how to in-order traverse `root.left` and `root.right`.
  * We first solve the subproblem of in-order traversing the left subtree (which will recursively break down into smaller and smaller left subtrees until reaching a leaf node), then we visit the root node, and finally, we solve the subproblem of in-order traversing the right subtree (which will also recursively break down into smaller and smaller right subtrees until reaching a leaf node).
  * These three steps combined form the solution to the original problem. So, through recursion, we break down a large problem into smaller ones, assume that the smaller problems have been solved, and then combine the solutions to these smaller problems to solve the larger problem. This is the essence of recursion.

<mark style="color:orange;">**Algorithm: stack**</mark>

* Create an empty stack.
* Initialize a pointer to the root node, let's call it `curr`.
* Run a loop until `curr` is null and the stack is not empty. In each iteration:
  * If `curr` is not null, push `curr` to the stack and move `curr` to its left child.
  * If `curr` is null, pop the top node from the stack, add its value to the result list and make `curr` point to the popped node's right child.
* This algorithm ensures that we first reach the leftmost node (the smallest element in a BST), process it, then go to its right subtree and repeat the process.

</details>

<details>

<summary>Code Demo </summary>

```java
// Recursion
// 1. determine the params & return type
// 2. determine the single layer logic -- assume sub-problem solved -- 归纳
// 3. determine the termination condition 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    // preOrderHelper: recursion function
    // 1. pamas和return值：参数为树的root和result arrayList，无返回值
    private void inorderHelper(TAreeNode root, List<Integer> result) {
        // 3. termination condition: current root is null, end recursion
        if (root == null) {
            return;
        }
        // 2. single layer logic: inorder left, visit the root, inorder right
        // 确定单层递归的逻辑：先访问左子树，然后访问当前节点，最后访问右子树
        inorderHelper(root.left, result);
        result.add(root.val);
        inorderHelper(root.right, result);
    }
}
```



```java
// Stack
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        curr = stack.pop();
        result.add(curr.val);
        curr = curr.right;
    }

    return result;
}
```

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>Key Points</summary>



</details>
