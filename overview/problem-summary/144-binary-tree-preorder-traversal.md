---
description: '@Recursion @Binary Tree'
---

# 🟢 0144 - Binary Tree Preorder Traversal

<details>

<summary>Description 题目描述 </summary>

Given a binary tree, return the preorder traversal of its nodes' values.

Example :

```c
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
```

Follow up: Recursive solution is trivial, could you do it iteratively?

</details>

<details>

<summary>Algorithm 解题思路 </summary>

[Pre-order Traversal](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/#pre-order-traversal): root-> left subtree -> right subtree

<mark style="color:orange;">**Algorithm -- recursion**</mark>

* visit the root node (add  the value to the result list )
* pre-order traversal of left subtree&#x20;
* pre-order traversal of right subtree

<!---->

* <mark style="color:orange;">**How to assume the subproblem have been solved?**</mark>
  * In the code, when we call `preorderHelper(root.left, result)` and `preorderHelper(root.right, result)`, we are essentially assuming that we know how to preorder traverse `root.left` and `root.right`. We combine the solutions to these two sub-problems with the visit to the root node to form the solution to the original problem.
  * So, through recursion, we break down a large problem into smaller ones, assume that the smaller problems have been solved, and then combine the solutions to these smaller problems to solve the larger problem. This is the essence of recursion.

<mark style="color:orange;">**Algorithm: Stack**</mark>

* Create an empty stack and <mark style="color:yellow;">**push the root node to the stack.**</mark>
* Run a loop until the stack is empty. In each iteration:
  * Pop a node from the stack and add its value to the result list.
  * If the popped node has a right child, push the right child to the stack.
  * If the popped node has a left child, push the left child to the stack.
* The reason we <mark style="color:yellow;">**push the right child before the left child**</mark> is that we want the left child to be processed first (since the stack is a <mark style="color:red;">**LIFO**</mark> structure).

</details>

<details>

<summary>Code Demo </summary>

<pre class="language-java" data-line-numbers><code class="lang-java"><strong>// Recursion
</strong>// 1. determine the params &#x26; return type
<strong>// 2. determine the single layer logic
</strong>// 3. determine the termination condition

class Solution {
    public List&#x3C;Integer> preorderTraversal(TreeNode root) {
        List&#x3C;Integer> result = new ArrayList&#x3C;>();
        preOrderHelper(root, result);
        return result;
    }
    
    // preOrderHelper: recursion function
    // 1. pamas和return值：参数为树的root和result arrayList，无返回值
    private void preOrderHelper(TreeNode root, List&#x3C;Integer> result) {
        // 3. termination condition: current root is null, end recursion
        if (root == null) {
            return;
        }
        // 2. single layer logic: visit the root, preorder left and right
        // 确定单层递归的逻辑：先访问当前节点，然后访问左子树，最后访问右子树
        result.add(<a data-footnote-ref href="#user-content-fn-1">root.val</a>); //注意是value not the root self
        // recursion shown up
        preOrderHelper(root.left, <a data-footnote-ref href="#user-content-fn-2">result</a>);
        preOrderHelper(root.right, <a data-footnote-ref href="#user-content-fn-3">result</a>);
    }
}
</code></pre>

```java
// Stack
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    
    if (root != null) {
        stack.push(root);
    }

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.val);

        if (node.right != null) {
            stack.push(node.right);
        }

        if (node.left != null) {
            stack.push(node.left);
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

[^1]: 

[^2]: There's no need to specify the type (`List<Integer>`) when passing `result` into `preOrderHelper`.

[^3]: There's no need to specify the type (`List<Integer>`) when passing `result` into `preOrderHelper`.
