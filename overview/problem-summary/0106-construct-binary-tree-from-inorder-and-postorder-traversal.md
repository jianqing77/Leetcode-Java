# 🟠 106 - Construct Binary Tree from InOrder and Postorder Traversal

<details>

<summary>Description 题目描述 </summary>

Given two integer arrays `inorder` and `postorder` where `inorder` is the inorder traversal of a binary tree and `postorder` is the postorder traversal of the same tree, construct and return _the binary tree_.

```
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

    	3
       / \
      9  20
        /  \
       15   7
```

</details>

<details>

<summary>解题思路 Intuition </summary>

* 根据二叉树的 inOrder traversal 和 postOrder Traversal 结果来重建二叉树。\
  这可以通过递归来实现。
* Key: \
  \- <mark style="color:yellow;">**postOrder Traversal:**</mark>** **<mark style="color:red;">**最后一个元素是root节点。**</mark>\
  \- <mark style="color:yellow;">**inOrder traversal :**</mark> \
  &#x20;  <mark style="color:red;">**root.left的nodes是left subtree, root.right的所有nodes是right subtree**</mark>。
* 我们可以将这些信息结合起来，
  * 先找到postOrder遍历的最后一个元素（即根节点）
  * 然后在中序遍历中找到根节点，将数组分为两部分，左边是左子树，右边是右子树
  * 然后递归地重建左子树和右子树。

</details>

<details>

<summary>Algorithm </summary>

这个算法使用了后序遍历和中序遍历的性质来重建二叉树，以下是步骤的详细说明：

1. **初始化**：首先，初始化 `inorder` 和 `postorder` 数组，设置 `postorderRootIndex` 为 `postorder` 数组的最后一个元素的索引（这是树的根节点），并创建一个哈希表 `inorderMap` 来存储 `inorder` 数组的元素和其索引。
2. **填充哈希表**：遍历 `inorder` 数组，并将每个元素和它的索引添加到 `inorderMap` 中。这样可以在后续的步骤中快速查找元素在 `inorder` 数组中的位置。
3. **开始构建树**：调用 `constructTree` 函数，参数是 `inorder` 数组的开始和结束索引。
4. **递归边界**：在 `constructTree` 函数中，首先检查 `inorderLeftIndex` 是否大于 `inorderRightIndex`。如果是，返回 `null`。这是递归的边界条件，表示当前的子树已经没有节点。
5. **创建根节点**：然后，使用 `postorderRootIndex` 从 `postorder` 数组中获取根节点的值，并创建一个新的 `TreeNode`。然后，`postorderRootIndex` 减一，这是因为在后序遍历中，根节点后面的节点是它的右子树的根节点。
6. **分割子树**：然后，根据根节点的值，在 `inorderMap` 中找到它在 `inorder` 数组中的位置。这个位置将 `inorder` 数组分割为两部分，左边是左子树，右边是右子树。
7. **构建右子树**：首先，调用 `constructTree` 函数，参数是 `inorder` 数组的当前位置加一和 `inorderRightIndex`，来构建右子树。这是因为在后序遍历中，根节点后面的节点是它的右子树的根节点。
8. **构建左子树**：然后，调用 `constructTree` 函数，参数是 `inorderLeftIndex` 和 `inorder` 数组的当前位置减一，来构建左子树。
9. **返回结果**：最后，返回根节点，这个节点现在已经连接了它的左子树和右子树。

整个过程是一个递归的过程，每次递归都会构建出一个新的子树。最后，所有的子树会连接成一个完整的二叉树。



</details>

<details>

<summary>Code Demo </summary>

```java
class Solution {
    int[] inorder;
    int[] postorder;
    int postorderRootIndex;
    Map<Integer, Integer> inorderMap = new HashMap<>(); // key: value; value: index

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.postorderRootIndex = postorder.length-1;

        // Cache the inorder elements and their indices for easy lookup
        for (int i = 0; i < inorder.length; i++ ) {
            inorderMap.put(inorder[i], i);
        }
        return constructTree(0, inorder.length-1);
    }

    private TreeNode constructTree(int inorderLeftIndex, int inorderRightIndex) {
        if (inorderLeftIndex > inorderRightIndex) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postorderRootIndex]);
        postorderRootIndex--;

        // Split the tree into left and right subtrees
        int inIndex = inorderMap.get(root.val);
        root.right = constructTree(inIndex + 1, inorderRightIndex); // construct right subtree first
        root.left = constructTree(inorderLeftIndex, inIndex-1); // then construct left subtree
        
        return root;
    }
}
```

</details>

<details>

<summary>Code Analysis</summary>

**时间复杂度**：\
这个算法的时间复杂度是 O(n)。 在这里，n 是树中节点的数量。 原因是我们对每个节点进行了恰好一次的访问 -- 每个节点被构造成一个新的 TreeNode 一次且只有一次。

**空间复杂度**：\
这个算法的空间复杂度是 O(n)。 这里的 n 也是树中节点的数量。 这个空间复杂度来自于两部分：

* 递归时的调用栈深度。在最坏的情况下，如果树是非常不平衡的，例如每个节点都只有左子节点或者每个节点都只有右子节点，那么递归的最大深度就是 n。因此，递归调用栈的空间复杂度是 O(n)。
* 我们创建的哈希表 `inorderMap` 存储了 n 个元素，其中每个元素都是树中的一个节点。因此，`inorderMap` 的空间复杂度也是 O(n)。

</details>

<details>

<summary>心得 Key Points</summary>

和105相似，只不过平日e

</details>
