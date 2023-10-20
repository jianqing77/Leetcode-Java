# 🟠 1644 - Lowest Common Ancestor of a Binary Tree II

<details>

<summary>Description 题目描述 </summary>

Given the `root` of a binary tree, return _the lowest common ancestor (LCA) of two given nodes,_ `p` _and_ `q`. If <mark style="color:yellow;">either node</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`p`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">or</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`q`</mark> <mark style="color:yellow;">**does not exist**</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">in the tree, return</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`null`</mark>. All values of the nodes in the tree are **unique**.

Constriant

* The number of nodes in the tree is in the range <mark style="color:red;">**`[1`**</mark>`, 104]`.
* `-109 <= Node.val <= 109`
* All `Node.val` are <mark style="color:red;">**unique**</mark>.
* <mark style="color:red;">`p != q`</mark>

</details>

<details>

<summary>解题思路 Intuition </summary>

这道题可能p或者q都不在tree中

写题的过程中感受到需要很多的helper function但是逻辑有点复杂

写完之后其实觉得也不是很复杂，只是在normal之前用dfs检查是否p和q都在tree中，而且要把lca写成一个helper method因为加了checkNodeInTree的原因

</details>

<details>

<summary>Algorithm </summary>

main function: <mark style="color:yellow;">**lowestCommonAncestor**</mark>

1. check if p and q is in the tree(helper method <mark style="color:yellow;">**checkNodeInTree**</mark> to do dfs)\
   \=> if either p or q is not in the tree, return null
2. after confirming both p and q is in the tree, \
   we use a helper method <mark style="color:yellow;">**LCAHelper**</mark> to do the recursion do the normal LCA searching&#x20;



</details>

<details>

<summary>Code Demo </summary>

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {    
        if (!checkNodeInTree(root, p) || !checkNodeInTree(root, q)) {
            return null;
        } else {   // after confirming both p and q is in the tree
            return LCAHelper(root, p, q); // do the normal LCA searching
        }
                
    }
    
    // use dfs to check if a node is in the tree   
    private boolean checkNodeInTree(TreeNode root, TreeNode node){
        if (root == null || node == null) {
            return false;
        }
        return root.val == node.val
               || checkNodeInTree(root.left, node) 
               || checkNodeInTree(root.right, node);
    }
    
    private TreeNode LCAHelper(TreeNode root, TreeNode p, TreeNode q) {
        // termination condition and if root value is the p/q's value
        if (root == null || root.val == p.val || root.val == q.val){
            return root;
        } 
        // if p/q is in the root's subtree
        TreeNode left = LCAHelper(root.left, p, q);
        TreeNode right = LCAHelper(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } 
        return null;
    } 
}
```

```java
// more efficient way to write the code in the main function        
        TreeNode ans = LCAHelperjava(root, p, q);
        if (ans == p) // check if q is in the subtree of p
            return checkNodeInTree(p, q) ? p : null;
        else if (ans == q) // check if p is in the subtree of q
            return checkNodeInTree(q, p) ? q : null;
        return ans; 
        
```

</details>

<details>

<summary>Code Analysis</summary>

Time complexity: $$O(N)$$

* `checkNodeInTree()` 函数采用深度优先搜索（DFS）遍历整棵树，时间复杂度是 O(N)，其中 N 是树的节点数。
* `LCAHelper()` 函数也使用 DFS 遍历整棵树，时间复杂度同样是 O(N)。
* 因此，整个 `lowestCommonAncestor()` 函数的时间复杂度是 O(2N) 或简化为 O(N)，因为我们最多会遍历两次整棵树。

Space Complexity: O(H)

* `checkNodeInTree()` 和 `LCAHelper()` 函数都使用了递归，递归的深度由树的高度决定，因此空间复杂度是 O(H)，其中 H 是树的高度。
* 因此，整个 `lowestCommonAncestor()` 函数的空间复杂度是 O(H)

</details>

<details>

<summary>心得 Key Points</summary>



</details>
