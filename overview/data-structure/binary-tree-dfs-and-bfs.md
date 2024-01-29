# ▫ Binary Tree: DFS & BFS

1. Understand the concept of a `tree` and a `binary tree`;
2. Be familiar with different `traversal` methods;
3. Use `recursion` to solve binary-tree-related problems;

> 做题心得：\
>
>
> 很多都是之前基本题的变形，要熟识没一个binary tree的基本题
>
> 1. DFS: pre, in, post order的recursion写法
> 2. BFS: 写法
> 3. Max /min depth的写法\
>
>
> Recursion的时候渐渐形成了自己的三要素
>
> 1. singly layer logic：考虑本node
> 2. recursion的实现：考虑left and right subtree
> 3. termination condition

## Concepts

<details>

<summary>Concept of tree and Binary Tree</summary>

<mark style="background-color:orange;">**Tree**</mark> - Key properties of trees include:

* **Root:** The root is the node in the tree where no other nodes point to it. There is only one root in a tree.
* **Parent Node:** A node which has one or more child nodes.
* **Child Node:** A node which is a descendant of another node.
* **Sibling Nodes:** Nodes which have the same parent node.
* **Leaf Node (or Terminal Node):** A node which has no children.
* **Internal Node:** A node which has at least one child (i.e., it is not a leaf node).
* **Degree of a Node:** The total number of children of a node.
* **Level:** The level of a node is defined by 1 + (the number of connections between the node and the root).
* <mark style="color:yellow;">**Height of a Tree:**</mark> The maximum level of any node in the tree.

```
最长路径是 A-B-E-G，有3步，所以树的高度height为3。
    A
   / \
  B   C
 / \   \
D   E   F
     \
      G
```

<mark style="color:yellow;">**Binary Tree**</mark>

A binary tree is a type of tree in which each node has at most two children, referred to as the left child and the right child.

The binary tree is the basis for many tree-like data structures including the binary search tree, the heap, and the B-tree. These trees allow for efficient lookup and update operations, and they're used in many algorithms and applications, including the implementation of databases and file systems.

</details>

### 1. Binary Tree 二叉树

<details>

<summary>1.Different <mark style="color:yellow;">Kind</mark> of Binary Trees</summary>

Key properties of binary trees include:

* <mark style="color:orange;">**Full Binary Tree 满二叉树**</mark><mark style="color:blue;">**:**</mark> A Binary Tree is full if every node has 0 or 2 children.
  * **每一个非叶子节点都有两个子节点**

```
    A
   / \
  B   C
 / \ / \
D  E F  G
```

* <mark style="color:orange;">**Complete Binary Tree 完全二叉树**</mark>
  * A Binary Tree is complete if all levels are completely filled except possibly the last level, which is filled from left to right.&#x20;
  * <mark style="color:yellow;">**条件1： 除了底层节点可能没填满**</mark>，其余每层的节点数都达到最大值&#x20;
  * <mark style="color:yellow;">**条件2**</mark>：<mark style="color:yellow;">**底层的节点**</mark>集中在改层<mark style="color:yellow;">**最左边**</mark>的若干位置

```
所有的层（除了最后一层）都被完全填充，且所有节点都尽可能地向左侧靠拢
    A
   / \
  B   C    => 完全二叉树 complete binary tree
 / \ / 
D  E F 

    A
   / \
  B   C  => 非完全二叉树 因为最后一层f靠right not left
 / \   \ 
D  E    F  
```

* <mark style="color:orange;">**Balanced Binary Tree**</mark>** **<mark style="color:purple;">**-- 与height相关**</mark>
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

*   <mark style="color:orange;">**Binary Search Tree (BST) 二叉搜索树**</mark>** **<mark style="color:purple;">**-- have value at tree node节点带数值**</mark>

    * **如果左子树left subtree 不空，则left sub tree的所有节点的值**<mark style="color:yellow;">**均**</mark>** < 根节点root的值**
    * **如果右子树right subtree不空，则right sub tree的所有节点的值**<mark style="color:yellow;">**均**</mark>** > 根节点root的值**



    ```
         8
       /   \
      3     10
     / \      \
    1   6      14  => BST
       / \     / 
      4   7   13  
      
      
    根节点8的左子树中的所有节点的值（包括4，1，和10）都应该小于8。
    根节点8的右子树中的所有节点的值（包括9，2，和11）都应该大于8。
         8
       /   \
      4     9     => 非BST: 
     / \   / \    => left: 10不满足<8 
    1   10 2  11  => right: 2不满足>8
    ```

</details>

<details>

<summary>2.Binary Tree二叉树的储存方式</summary>

```java
// Definition of Tree in LeetCode
// Definition for a binary tree node.
 public class TreeNode {
      // fields
      int val;
      TreeNode left;
      TreeNode right;
      
      // constructers
      TreeNode() {}
      TreeNode(int val) { 
            this.val = val; 
      }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
```



</details>

<details>

<summary>3.Different Traversal Methods: <mark style="color:yellow;">DFS and BFS的区别</mark></summary>

<mark style="color:yellow;">**总的来说，前序、中序和后序遍历是深度优先遍历的特例**</mark>，它们都是先访问深度较深的节点，然后再回溯访问兄弟节点；而广度优先遍历则是先访问深度较浅的节点，也就是先访问同一层的兄弟节点，然后再访问下一层的节点。

**Depth-First Search (DFS)** and **Breadth-First Search (BFS)** are two common traversal methods for graphs and trees.

* <mark style="color:yellow;">**Depth-First Search**</mark><mark style="color:yellow;">:</mark> DFS starts at the root and explores as far as possible along each branch before backtracking. In the context of a tree traversal, DFS can be further classified into preorder, in-order, and postorder traversal.
  * <mark style="color:red;">**Pre-order**</mark>** Traversal**: The visit order is "Root -> Left Subtree -> Right Subtree".
    * top down&#x20;
  * <mark style="color:red;">**In-order**</mark>** Traversal**: The visit order is "Left Subtree -> Root -> Right Subtree".
  * <mark style="color:red;">**Post-order**</mark>** Traversal**: The visit order is "Left Subtree -> Right Subtree -> Root".
    * bottom up
* <mark style="color:yellow;">**Breadth-First Search**</mark><mark style="color:yellow;">:</mark> BFS starts at the root and visits nodes in a level by level manner (i.e., visiting each node on a level before going to a lower level). All nodes are self first visited before all of their successors.

In summary, preorder, in-order, and postorder traversals are special cases of depth-first search, where nodes are visited first in the deeper part of the tree and then backtracked to visit sibling nodes. Breadth-first search, on the other hand, visits nodes at shallower depths first, i.e., it visits sibling nodes on the same level before moving to the next level.

***

</details>

***

### 2. DFS Traversal of Binary Tree

```
    1
   / \
  2   3
 / \
4   5
```

* **Pre-order Traversal** **Sequence** (Root, Left, Right): 1 -> 2 -> 4 -> 5 -> 3
* **In-order Traversal** **Sequence**(Left, Root, Right): 4 -> 2  -> 5 -> 1 -> 3
* **Postorder Traversal** **Sequence**(Left, Right, Root): 4  -> 5  -> 2  -> 3 -> 1

<details>

<summary>Pre-oder Traversal 前序遍历</summary>

[Pre-order Traversal](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/#pre-order-traversal): root-> left subtree -> right subtree

* <mark style="color:orange;">**Algorithm -- recursion**</mark>
  * visit the root node (add  the value to the result list )
  * pre-order traversal of left subtree&#x20;
  * pre-order traversal of right subtree
* <mark style="color:orange;">**How to assume the subproblem have been solved?**</mark>
  * In the code, when we call `preorderHelper(root.left, result)` and `preorderHelper(root.right, result)`, we are essentially assuming that we know how to preorder traverse `root.left` and `root.right`. We combine the solutions to these two sub-problems with the visit to the root node to form the solution to the original problem.
  * So, through recursion, we break down a large problem into smaller ones, assume that the smaller problems have been solved, and then combine the solutions to these smaller problems to solve the larger problem. This is the essence of recursion.

<pre class="language-java" data-line-numbers><code class="lang-java">// Recursion
// 1. determine the params &#x26; return type
// 2. determine the single layer logic
// 3. determine the termination condition

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
        preOrderHelper(root.left, <a data-footnote-ref href="#user-content-fn-2">result</a>);
        preOrderHelper(root.right, <a data-footnote-ref href="#user-content-fn-3">result</a>);
    }
}
</code></pre>

<mark style="color:orange;">**Algorithm: Stack**</mark>

* Create an empty stack and <mark style="color:yellow;">**push the root node to the stack.**</mark>
* Run a loop until the stack is empty. In each iteration:
  * Pop a node from the stack and add its value to the result list.
  * If the popped node has a right child, push the right child to the stack.
  * If the popped node has a left child, push the left child to the stack.
* The reason we <mark style="color:yellow;">**push the right child before the left child**</mark> is that we want the left child to be processed first (since the stack is a <mark style="color:red;">**LIFO**</mark> structure).

```java

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

<summary>Inorder Traversal 中序遍历</summary>

[In-order Traversal](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/#in-order-traversal): left subtree -> root -> right subtree

* <mark style="color:orange;">**Algorithm**</mark>
  1. In-order traversal of left subtree
  2. Visit the root node
  3. In-order traversal of right subtree

<!---->

* <mark style="color:orange;">**How to assume the subproblem have been solved?**</mark>
  * In the code, when we call `inorderHelper(root.left, result)` and `inorderHelper(root.right, result)`, we are essentially assuming that we know how to in-order traverse `root.left` and `root.right`.
  * We first solve the subproblem of in-order traversing the left subtree (which will recursively break down into smaller and smaller left subtrees until reaching a leaf node), then we visit the root node, and finally, we solve the subproblem of in-order traversing the right subtree (which will also recursively break down into smaller and smaller right subtrees until reaching a leaf node).
  * These three steps combined form the solution to the original problem. So, through recursion, we break down a large problem into smaller ones, assume that the smaller problems have been solved, and then combine the solutions to these smaller problems to solve the larger problem. This is the essence of recursion.

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

<mark style="color:orange;">**Algorithm: stack**</mark>

* Create an empty stack.
* Initialize a pointer to the root node, let's call it `curr`.
* Run a loop until `curr` is null and the stack is not empty. In each iteration:
  * If `curr` is not null, push `curr` to the stack and move `curr` to its left child.
  * If `curr` is null, pop the top node from the stack, add its value to the result list and make `curr` point to the popped node's right child.
* This algorithm ensures that we first reach the leftmost node (the smallest element in a BST), process it, then go to its right subtree and repeat the process.

```java
// Some code
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

<summary> Post-order Traversal 后序遍历</summary>

[Post-order Traversal](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/#post-order-traversal): left subtree ->  right subtree -> root

* Algorithm:
  1. Post-order traversal of left subtree
  2. Post-order traversal of right subtree
  3. Visit the root node
* How to assume the subproblem have been solved?
* In the code, when we call `postorderHelper(root.left, result)` and `postorderHelper(root.right, result)`, we are essentially assuming that we know how to post-order traverse `root.left` and `root.right`.
* We first solve the subproblem of post-order traversing the left subtree (which will recursively break down into smaller and smaller left subtrees until reaching a leaf node), then we solve the subproblem of post-order traversing the right subtree (which will also recursively break down into smaller and smaller right subtrees until reaching a leaf node), and finally, we visit the root node.
* These three steps combined form the solution to the original problem. So, through recursion, we break down a large problem into smaller ones, assume that the smaller problems have been solved, and then combine the solutions to these smaller problems to solve the larger problem. This is the essence of recursion.

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

Algorithm: Stack

* **Create an empty stack and push the root node to the stack. => same as preorder**
* Create an empty output list <mark style="color:yellow;">**(LinkedList)**</mark> to store the result.
* Run a loop until the stack is empty. In each iteration:
  * Pop a node from the stack and add its value to the front of the result list.
  * If the popped node has a left child, push it to the stack.
  * If the popped node has a right child, push it to the stack.
* The reason we add nodes to the front of the result list is that we want to reverse the order of traversal which would otherwise be root, right, left. Also, we push left child before the right child because we want the right child to be processed first.

```java
// Some code
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

***

### 3.  BFS Traversal of Binary Tree

<details>

<summary>BFS: Level-order traversal </summary>

BFS: traverse the tree level by level.

Algorithm: algorithm starts with a root node and visit the node itself first. Then traverse its neighbors, traverse its second level neighbors, traverse its third level neighbors, so on and so forth. When we do breadth-first search in a tree, the order of the nodes we visited is in level order.

```
       1
      / \
     2   3
    / \ / \
   4  5 6  7
```

The sequence of nodes visited in a breadth-first search (BFS), or level-order traversal, would be:

```
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
```

Here's how BFS would work:

1. Start with the root node (1). Add it to the queue.
2. Remove the first node in the queue (1), visit it, and add its children (2 and 3) to the queue.
3. Remove the first node in the queue (2), visit it, and add its children (4 and 5) to the queue.
4. Remove the first node in the queue (3), visit it, and add its children (6 and 7) to the queue.
5. Remove the first node in the queue (4), visit it. It has no children, so we don't add anything to the queue.
6. Remove the first node in the queue (5), visit it. It has no children, so we don't add anything to the queue.
7. Remove the first node in the queue (6), visit it. It has no children, so we don't add anything to the queue.
8. Remove the first node in the queue (7), visit it. It has no children, so we don't add anything to the queue.
9. The queue is now empty, so the BFS is complete.

As you can see, BFS visits all the nodes at each level before moving on to the next level, going from left to right.



</details>

<details>

<summary>BFS:  Implementation using QUEUE</summary>

<pre><code>        3
      /   \
     9     20
    /      / \
   8      15  7
<strong>Input: root = [3,9,20,8,null,15,7]
</strong><strong>Output: [[3],[9,20],[8,15,7]]
</strong></code></pre>

Algorithm:

1. Create an empty queue and <mark style="color:yellow;">enqueue the root node.</mark>
2. <mark style="color:yellow;">While the queue is not empty</mark>, do the following:
   * <mark style="color:green;">Determine the current level size</mark> (i.e., number of nodes in the queue).
   * For each node in the current level:
     * <mark style="color:green;">**Dequeue the node**</mark> from the queue.
     * Add the value of the node to the current level's list of values.
     * If the node has a left child, enqueue the left child.
     * If the node has a right child, enqueue the right child.
   * Add the current level's list of values to the list of all levels.

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        // If the root node is null, return the empty list
        if (root == null) {
            return result;
        }

        // Step 1: Create an empty queue and enqueue the root node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Step 2: Loop while the queue is not empty
        while (!queue.isEmpty()) {
            // Determine the current level size (i.e., number of nodes in the queue)
            int size = queue.size();
            List<Integer> subLevel = new LinkedList<>(); // Store the values of the current level

            // For each node in the current level
            for (int i = 0; i < size; i++) {
                // Dequeue the node from the queue
                TreeNode currentRoot = queue.poll();

                // Add the value of the node to the current level's list of values
                subLevel.add(currentRoot.val);

                // If the node has a left child, enqueue the left child
                if (currentRoot.left != null) {
                    queue.add(currentRoot.left);
                }

                // If the node has a right child, enqueue the right child
                if (currentRoot.right != null) {
                    queue.add(currentRoot.right);
                }
            }

            // Add the current level's list of values to the list of all levels
            result.add(subLevel);
        }

        return result;
    }
}
```

</details>

## Recursion相关的变形问题

<mark style="color:red;">**Recursion is one of the natural features of a tree**</mark>. Therefore, many tree problems can be solved **recursively**. For each recursive function call, we only focus on the problem for the current node and call the function recursively to solve its children.

Top down & Bottom Up Appraoch

* 无论是从顶向下（top-down）方法还是从底向上（bottom-up）方法，都属于深度优先搜索（DFS，Depth-First Search）的一部分。
* 在top down的方法中，我们首先访问节点本身，然后递归地访问子节点。这种方法也被称为前序遍历（pre-order traversal），因为我们首先处理当前节点，然后处理它的子节点。
* 在bottom up的方法中，我们首先递归地访问子节点，然后处理节点本身。这种方法也被称为后序遍历（post-order traversal），因为我们首先处理子节点，然后处理当前节点。

[^1]: 

[^2]: There's no need to specify the type (`List<Integer>`) when passing `result` into `preOrderHelper`.

[^3]: There's no need to specify the type (`List<Integer>`) when passing `result` into `preOrderHelper`.
