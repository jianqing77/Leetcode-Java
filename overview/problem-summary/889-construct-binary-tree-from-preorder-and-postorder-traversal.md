# 🟠 0889 -  Construct Binary Tree from Preorder and Postorder Traversal

<details>

<summary>Description 题目描述 </summary>

Given two integer arrays, `preorder` and `postorder` where `preorder` is the preorder traversal of a binary tree of **distinct** values and `postorder` is the postorder traversal of the same tree, reconstruct and return _the binary tree_.

If there exist multiple answers, you can **return any** of them.

</details>

<details>

<summary>解题思路 Intuition </summary>

`Preorder` and `postorder` are two types of depth-first traversals for a binary tree.

<mark style="color:yellow;">**Preorder:**</mark> the order of visiting nodes is <mark style="color:blue;">**Root -> Left Subtree -> Right Subtree**</mark>. This means that the root of any subtree is always the first node visited in that subtree. As a result, the first element in a `preorder` traversal array is always the root of the tree.

<mark style="color:yellow;">**PostOrder:**</mark> the order of visiting nodes is <mark style="color:blue;">**Left Subtree -> Right Subtree -> Root**</mark>. This means that the **root of any subtree is always the **<mark style="color:red;">**LAST**</mark>** node visited in that subtree.** As a result, the last element in a `postorder` traversal array is always the root of the tree.

Given these properties, we can use `preorder` and `postorder` traversals together to reconstruct the original binary tree:

* The first element in the preorder array gives us the root of the tree.
* Since we know the root, we can <mark style="color:yellow;">**split the postorder array into two parts**</mark>: the left subtree and the right subtree. The root divides the postorder array into\
  \- nodes of the left subtree (which come first)\
  \- nodes of the right subtree (which come last).
* We can then recursively apply this process to the left and right subtrees.

</details>

<details>

<summary>Algorithm </summary>

```
preorder = [1, 2, 4, 5, 3, 6, 7]
postorder = [4, 5, 2, 6, 7, 3, 1]

          1
         / \
        2   3
       / \ / \
      4  5 6  7
```

1. Initialize an index to the start of the preorder and post order array.\
   <mark style="color:purple;">**preIndex = 0, postIndex=0**</mark>
2. function constructFromPrePost(int\[] pre, int\[] post)
   1. Within this function, <mark style="color:yellow;">**create the root node**</mark> using the element at the current index in the preorder array, and then increment the index.  \
      <mark style="color:purple;">**TreeNode root = new TreeNode(pre\[preIndex++]);**</mark>
   2. Then, the function checks if the value of the newly created node is not the same as the current value from the `post` list.
      1. If the values are not the same, this means that the current subtree must have a left child that hasn't been constructed yet. So, the function recursively calls itself to construct the left subtree. The result of this recursive call (which should be the root node of the left subtree) is then assigned to the `left` property of the current node.
      2. After the left subtree is constructed, the function checks the `post` list again. If the value of the current node is still not the same as the current value from the `post` list, this means that the current subtree must also have a right child that hasn't been constructed yet. So, the function recursively calls itself again to construct the right subtree. The result of this recursive call (which should be the root node of the right subtree) is then assigned to the `right` property of the current node.
   3. After the left and right subtrees are constructed, the function increments the `posIndex` and then returns the current node (which now includes the entire subtree rooted at that node).
   4. This returned node is then linked to its parent node in the previous recursive call (i.e., a higher level in the recursion).

<mark style="color:yellow;">**Recursion Logic**</mark>

Recursion involves a function calling itself in its own definition. In this case, the `constructFromPrePost` function is using recursion to construct a binary tree.

The recursion in this function is based on two key observations:

* <mark style="color:yellow;">**In a pre-order traversal, the first element is always the root of the tree**</mark>**.** So, the function takes the first element from the `pre` list to be the root of the current subtree.&#x20;
* <mark style="color:green;">**If the root of the current subtree is not the same as the next element in the**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`post`**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**list, this means that the current subtree must have a left child. S**</mark>o, the function calls itself to construct the left subtree.
* <mark style="color:green;">**After the left child is constructed, if the root of the current subtree is still not the same as the next element in the**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`post`**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**list**</mark>, this means that the current subtree must also have a right child. So, the function calls itself again to construct the right subtree.

</details>

<details>

<summary>Code Demo </summary>

```java
class Solution {
    private int preIndex = 0, posIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[posIndex])
            root.left = constructFromPrePost(pre, post);
        if (root.val != post[posIndex])
            root.right = constructFromPrePost(pre, post);
        posIndex++;
        return root;
    }
}
```

</details>

<details>

<summary>Code Analysis</summary>

**Time Complexity**

The time complexity is O(N) because each node in the tree is processed once when constructing the `nodeMap` (in the `buildNodeMap` method) and then potentially once more when performing the breadth-first search (in the `findNodesAtDistanceK` method). Although we do a look-up operation in the `nodeMap` and `visitedNodes` sets, these operations can be considered as O(1) because the `HashMap` and `HashSet` data structures provide constant time performance for the basic operations (get and put).

**Space Complexity**

The space complexity is also O(N) because the `nodeMap` stores an entry for each node in the tree, the `visitedNodes` set could potentially store every node in the tree (in the worst-case scenario), and the queue used for the breadth-first search could also potentially store all nodes of the tree (again, in the worst-case scenario).

</details>

<details>

<summary>心得 Key Points</summary>



</details>
