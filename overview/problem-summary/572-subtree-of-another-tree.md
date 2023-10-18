# 🟢 572 - Subtree of Another Tree

<details>

<summary>Description 题目描述 </summary>

Given two <mark style="color:yellow;">**non-empty**</mark> binary trees **s** and **t**, check whether tree **t** has <mark style="color:yellow;">**exactly the same structure**</mark> and node values with a subtree of **s**. A subtree of **s** is a tree consists of a node in **s** and all of this node's descendants. The tree **s** could also be considered as a subtree of itself.

* The number of nodes in the `root` tree is in the range `[1, 2000]`.
* The number of nodes in the `subRoot` tree is in the range `[1, 1000]`.

<pre><code>Given tree s:                 Given tree t:
     3                              4 
    / \                            / \
   4   5                          1   2
<strong>  / \
</strong> 1   2
</code></pre>

Return **true**, because t has the same structure and node values with a subtree of s.

```
Given tree s:                        Given tree t:
     3                                    4
    / \                                  / \
   4   5                                1   2
  / \                        
 1   2
    /
   0
```

Return **false**.

</details>

<details>

<summary>解题思路 Intuition </summary>

题目大意： 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

<mark style="color:yellow;">**解题思路**</mark>

* 给出 2 棵树 `s` 和 `t`，要求判断 `t` 是否是 `s` 的子树🌲。
  * 注意只是t是否是s的子树，并不是s是t的子树
* 自己想法：还是像之前一样把tree的每个node按照顺序形成一个arraylist,\
  用indexOfSublist来检查 => 试验了很多个不行
* 针对 <mark style="color:yellow;">**3 种情况**</mark>依次recursion判断\
  第一种情况 `s` 和 `t` 是完全一样的两棵树\
  第二种情况 `t` 是 `s` 左子树中的子树\
  第三种情况 `t` 是 `s` 右子树中的子树。\
  第一种情况判断两棵数是否完全一致是第 100 题的原题。

</details>

<details>

<summary>✅ Algorithm: recursion</summary>

* <mark style="color:yellow;">**题目给的 non-empty tree of s and t 有一定的迷惑性**</mark>: 虽然题目假设了 s 和 t 是非空树，但recursion过程中，你可能会遇到null node作为termination condition（即，遍历到leaf节点的下一个节点）。此时说明，如果遇到一个 `null`，也就是说你已经到达了树的底部，但还没有找到和subroot相匹配的结构，应该返回 `false`。
* <mark style="color:yellow;">**关键：要想到三种情况**</mark>
  * same tree => helper function using recursion
  * subtree(root.left, subRoot): subRoot 是root的left sub tree的sub tree
  * subtree(root.right, subRoot): subRoot是root的right sub tree的sub tree
* isSubtree的termination condition: reachd the end of a branch

<pre class="language-java"><code class="lang-java"><strong>class Solution {
</strong>    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    
        if (root == null) { // termination condition: reach branch end
            return false;
        }
        
        // three situation
        return isSameTree(root, subRoot)
               || isSubtree(root.left, subRoot)
               || isSubtree(root.right, subRoot);
    }
    
    // helper method
    // use recursion to check if two trees are the same
    // Time complexity: O(n), where n is the number of nodes in the tree.
    //  As we are traversing each node once, the time complexity is O(n).
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null &#x26;&#x26; q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return <a data-footnote-ref href="#user-content-fn-1">p.val == q.val </a>
               &#x26;&#x26; isSameTree(p.left, q.left) 
               &#x26;&#x26; isSameTree(p.right, q.right);
    }
}
 
</code></pre>

让我们用一个简单的例子来可视化递归过程。假设我们有以下的树 `s` 和子树 `t`：

<pre><code>Given tree s:                 Given tree t:
     3                              4 
    / \                            / \
   4   5                          1   2
<strong>  / \
</strong> 1   2
</code></pre>

recursion过程如下：

1. 我们首先从树 `s` 的root = 3节点开始。我们对 `isSameTree(3, 4)` 进行调用，返回 `false`。然后我们对左子树和右子树进行递归调用 `isSubtree`。
2. 接下来，我们对 `isSubtree(4, 4)` 进行调用。我们对 `isSameTree(4, 4)` 进行调用，返回 `true`，所以我们返回 `true`。<mark style="color:yellow;">**在这个点，递归开始**</mark> "<mark style="color:yellow;">**回溯**</mark>"，即逐层返回上一级。
3. 在回溯过程中，我们会回到最初的 `isSubtree(3, 4)` 调用。由于我们已经找到了一个子树，所以我们不需要再检查右子树，直接返回 `true`。

下面是这个过程的可视化表示：

```sql
isSubtree(3, 4)
|-> isSameTree(3, 4) = false
|-> isSubtree(4, 4) = true -> return true
|-> isSubtree(5, 4) = (not evaluated because we found the subtree in the left child)
```

</details>

<details>

<summary>❌  Algorithm : 把value通过traversal转化为list</summary>

刚开始的思路是将二叉树通过遍历转化为list，然后检查root的value list是否包含subroot的list。这种方法在某些情况下可能不能正常工作，<mark style="color:red;">**主要是因为它没有完全考虑到二叉树结构的特性**</mark>。特别是，它没有考虑到树中节点之间的<mark style="color:red;">**父子关系和兄弟关系**</mark>。因此，仅仅通过比较转化后的列表可能会产生错误的结果。

例如，假设有以下两棵树：

```
Tree 1:      Tree 2:
  1             1
 / \           /
2   3         2
```

尽管 Tree 1 包含 Tree 2 的所有节点，但 Tree 2 并不是 Tree 1 的子树，因为它们的结构不同。但是，如果你通过前序遍历或者其他遍历方式将这两棵树转化为列表（Tree 1 变为 `[1, 2, 3]`，Tree 2 变为 `[1, 2]`），你会发现 Tree 1 的列表按照某种方式包含了 Tree 2 的列表，从而得出错误的结论。

因此，一个更好的方法是使用recursion来解决这个问题。这样，你可以同时检查节点的值和它们的结构。

```java
int index = Collections.indexOfSubList(list, sublist);
```

<mark style="color:yellow;">**这道题要看example的list的traversal方式 => bfs => 不行！！**</mark>

```java
Input:
root =[3,4,5,1,2]
subRoot =[4,1,2]
```

<mark style="color:yellow;">**除非形成一个 nested list => 也不行！！！**</mark>

<mark style="color:yellow;">**卡：**</mark>** **<mark style="color:red;">**how to check if a nested list contains All the sublist of another nested list? in java**</mark>

To check if a nested list contains all the sublists of another nested list in Java, you can use the `containsAll()` method from the `Collection` interface. `containsAll()` checks if the collection contains all the elements in the specified collection.

```java
 if (list1.containsAll(list2)) {
     System.out.println("list1 contains all sublists of list2.");
 } else {
     System.out.println("list1 does not contain all sublists of list2.");
 }
```

</details>

<details>

<summary>Code Analysis</summary>

Time Complexity: O(m\*n)

* m: root的node数量，n: subRoot的node数量
* 这是因为在最坏的情况下，我们需要检查root中的每一个node是否与subroot的根节点相同（通过 `isSameTree` 函数），这个过程的时间复杂度是 O(n)。由于我们需要对主树的每一个节点执行这个检查，所以总的时间复杂度是 O(mn)。
* 数学的方法解释：
  * 给出一个树 `s` 和一个子树 `t`，假设 `s` 有 `m` 个节点，`t` 有 `n` 个节点。
  * 主函数 `isSubtree` 的逻辑是遍历 `s` 的每一个节点，然后通过函数 `isSameTree` 来比较该节点下的子树是否与 `t` 相同。因此，我们需要对 `s` 的每一个节点都进行一次 `isSameTree` 的调用。
  * `isSameTree` 函数的时间复杂度是 O(n)，因为在最坏的情况下，它需要比较 `t` 的所有节点以确定两棵树是否相同。
  * 因此，<mark style="color:yellow;">**`isSubtree`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**函数的时间复杂度是 O(m\*n)，因为我们需要对**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`s`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**的每一个节点都进行一次**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`isSameTree`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**的调用。**</mark>
  * 这就是为什么我们说这个解决方案的时间复杂度是 O(m\*n) 的原因。

Space Complexity: O(m)

空间复杂度是 O(m)，其中 m 是主树的高度。这是由于在深度优先搜索过程中使用的递归栈的空间消耗，这是与主树的高度相等的。在最坏的情况下（也就是当树完全不平衡时），栈中可能包含从根节点到叶节点的所有节点，因此空间复杂度是 O(m)。

</details>

<details>

<summary>心得 Key Points</summary>



</details>

[^1]: 
