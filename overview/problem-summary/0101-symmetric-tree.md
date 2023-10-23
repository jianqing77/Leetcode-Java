# 🟢 101 - Symmetric Tree

<details>

<summary>Description 题目描述 </summary>

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

<pre class="language-c"><code class="lang-c">    1
   / \
  2   2      => symmetric
 / \ / \
<strong>3  4 4  3
</strong></code></pre>

```c
    1
   / \
  2   2      => NOT symmetric
   \   \
   3    3
```

```
    1
   / \
  2   2      =>  symmetric
 /     \
3       3
```

</details>

<details>

<summary>解题思路 Intuition </summary>

* Symmetric: 是不是invert 左右两个sub tree之后 判断是否相等呢? 应该不是，因为example 2里边就不是
* ✅我觉得这道题最重要的就是找到symmetric的特征
  * null node: return true
  * one node: return true -> leaf node
  * left child/right child是null -> 好像也不好判断
* ✅总觉得和same tree和invert tree有点相似
  * <mark style="color:red;">啊！recursion: 先invert right sub tree -> compare with left sub tree to see if they are same</mark>
  * 226: invert binary tree&#x20;
  * 100: same tree

</details>

<details>

<summary>Algorithm: combine invert and same (226 &#x26; 100) -- 自己写的，更好理解</summary>

* recursion的实现: \
  <mark style="color:yellow;">**通过 helper method 来实现recursion,**</mark> \ <mark style="color:yellow;">**main function里不需要recursion**</mark>

<!---->

* singly layer logic: -> 卡
  * <mark style="color:red;">INVERT right sub tree -> compare with left sub tree to see if they are SAME</mark>
  * <mark style="color:red;">两个问题的结合 226 & 100</mark>
* Line15 不需要的原因：在检查left sub tree 和inverted后的right sub tree是否same时候已经隐含地检查了左子树和右子树是否symmetric。

<pre class="language-java" data-line-numbers><code class="lang-java">class Solution {
    public boolean isSymmetric(TreeNode root) {
        // termination condition
        if (root == null) {
            return true;
        }
        if (root.left == null &#x26;&#x26; root.right == null) {
            return true;
        }
        
        // singly layer logic:
        // recursion的体现:
        return isSameTree(root.left, invertTree(root.right))
        // 这里不需要因为自带recursion        
        // <a data-footnote-ref href="#user-content-fn-1">return isSymmetric(root.left) &#x26;&#x26; isSymmetric(root.right);</a>
    }
    
    // also use recursion
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null &#x26;&#x26; q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        
        // singly layer logic: the value of root is same
        if (p.val != q.val) {  // => 用不等于
            return false;
        }
        // recursion的实现
        return isSameTree(p.left, q.left) &#x26;&#x26; isSameTree(p.right, q.right);
    }
    
    // also use recursion
    private TreeNode invertTree(TreeNode root) {
        // termination condition
        if (root == null) {
            return null;
        }
        // singly layer logic: swap the left and right subtree
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode; 
        
        // recursion的实现
        invertTree(root.left);
        invertTree(root.right);
    
        return root;
    }
}
</code></pre>

</details>

<details>

<summary>Algorithm:  one function use isMirror() -- solution给的 更简洁</summary>

<pre class="language-java"><code class="lang-java">public boolean isSymmetric(TreeNode root) {
    if (root == null) {
        return true;
    }
    return isMirror(root.left, root.right);
}
// helper method: recursion
private boolean isMirror(TreeNode p, TreeNode q) {
    // termination condition
    if (p == null || q == null) { // either of the treeNode is null
        return false;
    }
    if (p == null &#x26;&#x26; q == null) { // leaf node
        return true;
    }
    // singly layer condition &#x26; recursion的实现
    return (p.val == q.val) 
            &#x26;&#x26; <a data-footnote-ref href="#user-content-fn-2">isMirror(p.left, q.right) </a>
            &#x26;&#x26; <a data-footnote-ref href="#user-content-fn-3">isMirror(p.right, q.left);</a>
}
</code></pre>

这个算法的时间复杂度和空间复杂度均为 O(n)，其中 n 是二叉树中的节点数量。下面是具体的解释：

* 时间复杂度：在这个算法中，我们需要遍历二叉树的每个节点一次，因此时间复杂度为 O(n)。这是因为`isMirror`函数会递归地访问每个节点，比较左子树的左节点与右子树的右节点，以及左子树的右节点与右子树的左节点。
* 空间复杂度：在最坏的情况下，我们需要存储与二叉树的高度相当的函数调用（即递归栈）。在一棵满二叉树中，树的高度和节点数量的对数成正比，所以空间复杂度为 O(log n)。然而，在最坏的情况下（即树为线性结构），树的高度等于节点的数量，所以空间复杂度为 O(n)。

</details>

<details>

<summary>心得 Key Points</summary>

* 自己写着写着logic思考和intuition就想到了，有了点信心
* 是226invert和100same的体现，自己的intuition部分写的很好哈哈啊哈
* 但是解决方法有点赘余 有更优解更简单的解法 <mark style="color:red;">**注意main function中错误的点：赘余的recursion的体现**</mark>
* recursion的实现: 两个都是pass in 的argument是root的left和right\
  <mark style="color:yellow;">**通过 helper method 来实现recursion,**</mark> \ <mark style="color:yellow;">**main function里不需要recursion**</mark>

</details>

[^1]: 赘余的recursion体现

[^2]: 

[^3]: 
