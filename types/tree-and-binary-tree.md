# ▫ Tree & Binary Tree

1. Understand the concept of a `tree` and a `binary tree`;
2. Be familiar with different `traversal` methods;
3. Use `recursion` to solve binary-tree-related problems;

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
* **Height of a Tree:** The maximum level of any node in the tree.

<mark style="color:yellow;">**Binary Tree**</mark>

A binary tree is a type of tree in which each node has at most two children, referred to as the left child and the right child.

The binary tree is the basis for many tree-like data structures including the binary search tree, the heap, and the B-tree. These trees allow for efficient lookup and update operations, and they're used in many algorithms and applications, including the implementation of databases and file systems.

Key properties of binary trees include:

* <mark style="color:blue;">**Full Binary Tree:**</mark> A Binary Tree is full if every node has 0 or 2 children.
* <mark style="color:orange;">**Complete Binary Tree**</mark>**:** A Binary Tree is complete if all levels are completely filled except possibly the last level, which is filled from left to right.
* <mark style="color:orange;">**Balanced Binary Tree**</mark>**:** A binary tree is balanced if the <mark style="color:yellow;">**tree height =**</mark> <mark style="color:yellow;">**log(n)**</mark> where n is the number of nodes.
* <mark style="color:orange;">**Binary Search Tree (BST):**</mark> A binary tree where for each node, the values of all the nodes in the left subtree are less than or equal to the node, and the values of all the nodes in the right subtree are greater than the node.

</details>

<details>

<summary>Different <code>Traversal</code> Methods</summary>

* Definition of Tree in LeetCode

```java
// Definition for a binary tree node.
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
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

* [Pre-order Traversal](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/#pre-order-traversal): root-> left subtree -> right subtree

```java
```

* [In-order Traversal](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/#in-order-traversal): left subtree -> root -> right subtree

```java
```

* [Post-order Traversal](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/#post-order-traversal): left subtree ->  right subtree -> root

```java
```

* [Recursive or Iterative](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/992/#recursive-or-iterative): compare with iteration

</details>

<details>

<summary>Recursion in Binary Tree </summary>



</details>
