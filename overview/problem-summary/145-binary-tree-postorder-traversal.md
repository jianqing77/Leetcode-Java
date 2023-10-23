---
description: '@Recursion @Binary Tree'
---

# 🟢 0145 -  Binary Tree Postorder Traversal

<details>

<summary>Description 题目描述 </summary>

Given a binary tree, return the postorder traversal of its nodes' values.

Example :

```c
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
```

</details>

<details>

<summary>Algorithm 解题思路 </summary>

[Post-order Traversal](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/#post-order-traversal): left subtree ->  right subtree -> root

* Algorithm:
  1. Post-order traversal of left subtree
  2. Post-order traversal of right subtree
  3. Visit the root node
* How to assume the subproblem have been solved?
* In the code, when we call `postorderHelper(root.left, result)` and `postorderHelper(root.right, result)`, we are essentially assuming that we know how to post-order traverse `root.left` and `root.right`.
* We first solve the subproblem of post-order traversing the left subtree (which will recursively break down into smaller and smaller left subtrees until reaching a leaf node), then we solve the subproblem of post-order traversing the right subtree (which will also recursively break down into smaller and smaller right subtrees until reaching a leaf node), and finally, we visit the root node.
* These three steps combined form the solution to the original problem. So, through recursion, we break down a large problem into smaller ones, assume that the smaller problems have been solved, and then combine the solutions to these smaller problems to solve the larger problem. This is the essence of recursion.

<mark style="color:orange;">**Algorithm: Stack**</mark>

* **Create an empty stack and push the root node to the stack. => same as preorder**
* Create an empty output list <mark style="color:yellow;">**(LinkedList)**</mark> to store the result.
* Run a loop until the stack is empty. In each iteration:
  * Pop a node from the stack and add its value to the front of the result list.
  * If the popped node has a left child, push it to the stack.
  * If the popped node has a right child, push it to the stack.
* The reason we add nodes to the front of the result list is that we want to reverse the order of traversal which would otherwise be root, right, left. Also, we push left child before the right child because we want the right child to be processed first.



</details>

<details>

<summary>Code Demo </summary>

```java
// Recursion
// 1. determine the params & return type
// 2. determine the single layer logic
// 3. determine the termination condition
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }
    
    // preOrderHelper: recursion function
    // 1. pamas和return值：参数为树的root和result arrayList，无返回值
    private void postorderHelper(TreeNode root, List<Integer> result) {
        // 3. termination condition: current root is null, end recursion
        if (root == null) {
            return;
        }
        // 2. single layer logic: postorder left, postorder right, visit the root
        // 确定单层递归的逻辑：先访问左子树，然后访问右子树，最后访问当前节点
        postorderHelper(root.left, result);
        postorderHelper(root.right, result);
        result.add(root.val);
    }
}
```

```java
// Stack
public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    
    if (root != null) {
        stack.push(root);
    }

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.addFirst(node.val);

        if (node.left != null) {
            stack.push(node.left);
        }

        if (node.right != null) {
            stack.push(node.right);
        }
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
