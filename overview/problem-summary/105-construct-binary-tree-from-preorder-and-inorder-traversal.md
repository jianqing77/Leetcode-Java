---
description: '@HashMap @Recursion @DFS @BFS'
---

# 🟠 0105 - Construct Binary Tree from Preorder and Inorder Traversal



<details>

<summary>Description 题目描述 </summary>

Given two integer arrays `preorder` and `inorder` \
\-  `preorder` is the preorder traversal of a binary tree \
&#x20;\- `in-order` is the in-order traversal of the <mark style="color:yellow;">**same tree**</mark>,\
construct and return _the binary tree_.

```java
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]  // output: level order traversal
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
```

**Constraints:**

* `1 <= preorder.length <= 3000`
* `inorder.length == preorder.length`
* `-3000 <= preorder[i], inorder[i] <= 3000`
* `preorder` and `inorder` consist of <mark style="color:yellow;">**unique**</mark> values.
* Each value of `inorder` also appears in `preorder`.
* `preorder` is **guaranteed** to be the preorder traversal of the tree.
* `inorder` is **guaranteed** to be the inorder traversal of the tree.

</details>

<details>

<summary>解题思路 Intuition </summary>

pre-order: root, left, right\
in-order: left root right

* 根据二叉树的 inOrder traversal 和 preOrder Traversal 结果来重建二叉树。这可以通过递归来实现。
* Key: preOrder Traversal: 第一个元素是root节点。inOrder traversal: root.left的nodes是left subtree, root.right的所有nodes是right subtree。
* 我们可以将这些信息结合起来，
  * 先找到preOrder遍历的first element元素（即根节点）=> 要更新
  * 然后在中序遍历中找到根节点，将数组分为两部分，左边是左子树，右边是右子树，
  * 然后递归地重建左子树和右子树。

</details>

<details>

<summary>Algorithm </summary>

1. &#x20;<mark style="background-color:green;">**buildTree function**</mark> is the entry point.&#x20;
   1. initializes the preorder and  in-order arrays \
      \=> <mark style="color:yellow;">**preorder array**</mark>:  particularly useful because <mark style="color:blue;">**the first element of any preorder traversal is always the root of the tree (or subtree).**</mark> \
      \=> <mark style="color:yellow;">**in-order**</mark> <mark style="color:yellow;">**array**</mark> traversal helps us <mark style="color:blue;">**determine which nodes are in the left subtree and which are in the right subtree.**</mark>
   2. &#x20;populates the <mark style="color:yellow;">**in-orderMap**</mark> with elements from in-order array and their respective indices. The purpose of <mark style="color:yellow;">**in-orderMap**</mark> is to quickly look up the index of a value in  in-order array without having to scan the entire array.
   3. calls the helper function constructTree with the start and end indices of inorder array.

<!---->

1. <mark style="background-color:green;">**constructTree Helper function**</mark>\
   The **constructTree** method's main use is to <mark style="color:yellow;">**construct a binary tree given the start and end indices of its inorder traversal.**</mark> It does this by finding the root of the tree (using the preorder array), creating a new node for the root, and recursively constructing the left and right subtrees (using the in-order arrays ).
   1. if the start index is greater than the end index, it returns null. This is the base case for the recursion and represents an empty tree or subtree, which happens when there are no more elements to construct in the subtree.
   2. If the start index is not greater than the end index, it creates a new <mark style="color:orange;">**TreeNode**</mark> with the current value in the <mark style="color:red;">**preorder**</mark> array (starting from <mark style="color:yellow;">preStart</mark>). It then <mark style="color:yellow;">**increments preStart**</mark> to move to the next root in the `preorder` array for the next recursive call.
   3. It then finds the index of the root value in the in-order arrays using the inorderMap.
   4. <mark style="color:yellow;">**Recursion**</mark>: The constructTree function is then called recursively twice: once for the left subtree and once for the right subtree, by splitting the in-order array at the root's index. The left recursive call is made for the elements before the root index and the right recursive call is made for the elements after the root index in the in-order arrays . The results of these recursive calls are assigned to `root.left` and `root.right`, respectively.

<!---->

1. Finally, the `constructTree` function returns the `root`, which now represents a tree (or subtree in recursive calls) with its left and right children set correctly.



</details>

<details>

<summary>✅  Code Demo </summary>

```java
class Solution {
    int[] preorder;
    int[] inorder;
    int preorderRootIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>(); // key: value; value: index

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder; // [3,9,20,15,7]
        this.inorder = inorder; // [9,3,15,20,7]

        // Cache the inorder elements and their indices for easy lookup
        for (int i = 0; i < inorder.length; i++ ) {
            inorderMap.put(inorder[i], i);
        }
        return constructTree(0, inorder.length-1);
    }
    // Helper Method: construct the binary tree recursively 
    // by using the preorder and inorder traversal arrays.
    // params: 
    // - leftInorderIndex: starting index of the in-order traversal array 
    // - rightInorderIndex: ending index of the in-order traversal array
    // return: a TreeNode which is the root of the constructed subtree.
    private TreeNode constructTree(int inorderLeftIndex, int inorderRightIndex) {
        if (inorderLeftIndex > inorderRightIndex) {
            return null;
        }

        // get the root node using the preorder array
        // TreeNode root = new TreeNode(preorder[preorderRootIndex++]);
        TreeNode root = new TreeNode(preorder[preorderRootIndex]);
        preorderRootIndex++; // WHY??
        // preorderRootIndex++; 

        // Split the tree into left and right subtrees
        // 1. get the index using the hashmap and the root.val retrieved from the preorder
        int inIndex = inorderMap.get(root.val); // [9,3,15,20,7]  => inIndex = 1
        // 2. recursion method to get the root left and right by updating the borders
        root.left = constructTree(inorderLeftIndex, inIndex-1); // left: [9]
        root.right = constructTree(inIndex + 1, inorderRightIndex); // [15,20,7]
        return root;
    }
}
```

```java
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]  // output: level order traversal
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
   
Round 1: 
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

preorderRootIndex = 0 => value = 3
inorderLeftIndex = 0 => LEFT inorder = [9]
inorderRightIndex => 4 => RIGHT inorder = [15,20,7]

We recursively call constructTree for the left and right subtrees.
Round 2: focus on LEFT
preorder = [9,20,15,7] 
inorder = [9]

preorderRoot = 9
left inorder = []
right inorder = []

Round 3: focus on RIGHT
preorder = [20,15,7]
inorder = [15,20,7]

preorderRoot = 20
left inorder = [15]
right inorder = [7]

recursively call constructTree for the left and right subtrees of 20. 
Round 4: focus on LEFT
preorder = [15,7]
inorder = [15]

root = 15
left inorder = []
right inorder = []
Round 4: focus on RIGHT
preorder = [7]
inorder = [7]

root = 7
left inorder = []
right inorder = []

```

<mark style="color:yellow;">**Why we initialize int\[] preorder; int\[] inorder; as global variables?**</mark>

1. **Simplify function signatures:** The `constructTree` method is recursive, so it needs to have access to the `preorder` and `inorder` arrays in each recursive call. If these arrays were not global, they would need to be passed as arguments to the `constructTree` method, complicating the function signature.
2. **Preserve state across function calls:** The `preorder` array is traversed sequentially from the start to the end during the construction of the tree. The `preStart` index keeps track of the current position in the `preorder` array across multiple function calls. Making `preorder` and `preStart` global enables this state to be preserved across all calls to `constructTree`.
3. **Reduce memory usage:** If the `preorder` and `inorder` arrays were passed as arguments to each recursive call, new array objects could potentially be created for each function call, which would increase the memory usage of the program. Using global variables avoids this potential issue.

<mark style="color:yellow;">**Helper Method constructTree 是focus在inOrder的？**</mark>

* The constructTree method does indeed focus on the <mark style="color:yellow;">**in-order array**</mark>: The reason it focuses on in-order is because <mark style="color:purple;">**in-order is what allows us to distinguish between nodes that are on the left of the current root and nodes that are on the right.**</mark> After finding the root node in the inorder array, everything to the left of the root forms the left subtree, and everything to the right forms the right subtree.
* &#x20;it also uses the <mark style="color:yellow;">**preorder array**</mark> : determine the root of each subtree.&#x20;

</details>

<details>

<summary>Code Analysis</summary>

\
**Time Complexity: O(n)**

The time complexity is O(n) where n is the number of nodes in the tree. This is because we are essentially visiting each node in the tree exactly once. Each visit involves constant time operations including looking up the index in the hashmap.

**Space Complexity: O(n)**

There are two primary space usages:

1. The recursion stack: In the worst case (a completely unbalanced tree), the maximum depth of the recursion is n (the number of nodes in the tree), thus the maximum amount of space is O(n).
2. The hashmap: We are also creating a hashmap to store the value-index pairs of the inorder array. Since there are n nodes, there are n entries in the hashmap, so the space usage is O(n).

Therefore, the total space complexity is O(n + n) = O(n).

</details>

<details>

<summary>✅ 心得 Key Points</summary>

1. 额 很难做出来的一道题
2. 关键点：用preorder array来找root, inorder array对应的root的左边是left subtree, right为right subtree
3. 简化写法：

```java
        TreeNode root = new TreeNode(preorder[preorderRootIndex++]);
                            ||
        TreeNode root = new TreeNode(preorder[preorderRootIndex]);
        preorderRootIndex++; 
```

</details>
