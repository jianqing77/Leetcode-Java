# 1644 - Lowest Common Ancestor of a Binary Tree II

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

</details>

<details>

<summary>Algorithm </summary>

1. termination condition: root = null
2. if (root.val == p.val )如果root的value为p.val\
   \=> 需要确定他的left/right child里边有没有q.val\
   if (root.val == q.val) &#x20;



</details>

<details>

<summary>Code Demo </summary>

<pre class="language-java"><code class="lang-java"><strong>class Solution {
</strong>    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (root.val == p.val) {
        }
        if (root.val == q.val)
    }
}
</code></pre>

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>心得 Key Points</summary>



</details>
