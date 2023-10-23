---
description: '@Backtracking @ Depth-First Search @Binary Tree'
---

# 🟠 113 - Path Sum II

<details>

<summary>Description 题目描述 </summary>

Given the `root` of a binary tree and an integer `targetSum`, return _all <mark style="color:yellow;">**root-to-leaf**</mark> paths where the sum of the node values in the path equals_ `targetSum`_. <mark style="color:yellow;">**Each path should be returned as a list of the node values, not node references**</mark>_<mark style="color:yellow;">**.**</mark>

A **root-to-leaf** path is a path starting from the root and ending at any leaf node. A **leaf** is a node with no children.

<pre><code><strong>Given the below binary tree and sum = 22
</strong>      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
return
<strong>[ 
</strong>  [5,4,11,2], 
  [5,8,4,5]
]
</code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

和112- 基础的path sum对比：

* 基础的path sum: 只需要判断是否等于, as long as one 等于就好
* 这道题的path sum: 要找到 ALL matched paths and return a nested list of node values

和257 - binary search paths对比：

* 不是form a string but build a nested list
* 还需要calculate sum 和path对比

</details>

<details>

<summary>✅ Algorithm &#x26; Code Accepted: <mark style="color:yellow;">recursion &#x26;&#x26; backtrack</mark> -- 结构similar to 257</summary>

<mark style="background-color:purple;">**自己总结的Backtrack的新结构模版**</mark>

<pre class="language-sql"><code class="lang-sql"><strong>1. 处理null node
</strong><strong>2. 标记当前node,用于backtrack (如果是list的话可以直接backtrack用build in method)
</strong><strong>3. 处理当前node
</strong><strong>4. 用 IF ELSE 来处理leaf node和normal node的情况: 两种都需要back track
</strong><strong>if (leaf node) {
</strong>    do the termination
} else {
    do the recursion and pass the 共享变变量
}
5. backtrack // 两种都需要back track所以用上边的if else
</code></pre>

<pre class="language-java" data-line-numbers><code class="lang-java">class Solution {
    public List&#x3C;List&#x3C;Integer>> pathSum(TreeNode root, int targetSum) {
        List&#x3C;List&#x3C;Integer>> resultPathList = new ArrayList&#x3C;>(); // store all matched result
        List&#x3C;Integer> subPathList = new ArrayList&#x3C;>();
        generatePathList(root, resultPathList, subPathList, targetSum);
        return resultPathList;
    }
    private void generatePathList(TreeNode root, List&#x3C;List&#x3C;Integer>> resultPathList, List&#x3C;Integer> subPathList, int targetSum) {
        if (root == null) { // 1. 处理null node
            return;
        }
        
        subPathList.add(root.val); // 3. 处理当前node
        // 4. IF LESE
        // leaf node: 也需要back track 
        if (root.left == null &#x26;&#x26; root.right == null ) {
            if (calculateSum(subPathList) == targetSum){
                resultPathList.add(<a data-footnote-ref href="#user-content-fn-1">new ArrayList&#x3C;>(subPathList)</a>); // check if the path sum == target
            } 
        } else {
            //  node with at least one child
            // recursion to 
            generatePathList(root.left, resultPathList, subPathList, targetSum);
            generatePathList(root.right, resultPathList, subPathList, targetSum);
        }
        // 5. ========== backtrack ==========
        // remove the current node from the path (backtrack)
        // for both leaf and normal node
         subPathList.remove(subPathList.size() - 1);
        
    }
    
    private int calculateSum(List&#x3C;Integer> list) {
        if (list == null) {
            return 0;
        }
        int sum = 0;
        for (int num: list) {
            sum += num;
        }
        return sum;
    }
}
</code></pre>

<mark style="background-color:purple;">**Pass by reference: list -- line 18的处理**</mark>

* line 18 <mark style="color:yellow;">**不能直接将subPathList添加到resultPathList中，而是要添加subPathList的一个新的**</mark><mark style="color:red;">**copy**</mark>（通过new ArrayList<>(subPathList)创建）。
* 这是因为，<mark style="color:yellow;">**subPathList是一个"共享变量"，而且list是个 reference type 它在整个recursion过程中会被反复修改**</mark>。如果你直接将`subPathList`添加到`resultPathList`中，那么当`subPathList`在后续的递归过程中被修改时，<mark style="color:red;">已经添加到</mark><mark style="color:red;">`resultPathList`</mark><mark style="color:red;">中的路径也会被改变</mark>，这显然是我们不希望看到的。

<mark style="background-color:purple;">**为什么Q257是string的时候, 虽然pathString是个共享变量，但可以直接把其直接加到resultList中?**</mark>

* 当你把一个类型（比如int）的变量添加到列表中时，实际上<mark style="color:yellow;">**添加的是这个value的一个copy**</mark>。即使你后来改变了这个变量的值，已经添加到列表中的那个值并不会受到影响。
* 但是，当你把一个reference type（比如List）的变量添加到列表中时，实际上添加的是这个<mark style="color:yellow;">**reference的一个copy**</mark>，也就是说，<mark style="color:red;">**这个副本和原来的变量指向的是同一个对象**</mark>。因此，<mark style="color:red;">**如果你后来通过这个变量修改了这个对象，已经添加到列表中的那个引用所指向的对象也会被改变。**</mark>
* 这就是为什么你需要创建一个新的ArrayList的副本，然后把这个副本添加到resultPathList中。这样，即使原来的subPathList被修改，已经添加到resultPathList中的那个副本所指向的列表并不会受到影响，因为它是一个新的、独立的对象。

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>✅心得 Key Points</summary>

<mark style="color:yellow;">**通过对比257和114，自己总结的Backtrack的新结构模版**</mark>

<pre class="language-sql"><code class="lang-sql"><strong>1. 处理null node
</strong><strong>2. 标记当前node,用于backtrack (如果是list的话可以直接backtrack用build in method)
</strong><strong>3. 处理当前node
</strong><strong>4. 用 IF ELSE 来处理leaf node和normal node的情况: 两种都需要back track
</strong><strong>if (leaf node) {
</strong>    do the termination
} else {
    do the recursion and pass the 共享变变量
}
5. backtrack // 两种都需要back track所以用上边的if else
</code></pre>

<mark style="color:yellow;">java的</mark><mark style="color:yellow;">**pass by value & pass by reference**</mark><mark style="color:yellow;">的理解很重要</mark>

* <mark style="color:red;">**pass by reference在main function中的体现**</mark>
  * 在Java中，List\<List\<Integer>> resultPathList和List\<Integer> subPathList都是引用类型。当我们调用generatePathList()方法时，我们传递的是resultPathList和subPathList的引用。
  * 这意味着在generatePathList()方法中对resultPathList和subPathList的任何修改，都会直接影响到原来的对象。例如，当我们调用resultPathList.add(new ArrayList<>(subPathList))时，我们实际上是在原来的resultPathList对象中添加了一个新的元素。同样，当我们调用subPathList.remove(subPathList.size() - 1)时，我们实际上是在原来的subPathList对象中移除了一个元素。
  * 这就是Java中的"pass-by-reference"（传引用）的概念。它与"pass-by-value"（传值）的主要区别在于，传值会创建一个新的变量来存储原始变量的值，而传引用则会创建一个新的变量来存储原始变量的引用，也就是说新的变量和原始变量实际上指向了同一个对象

</details>



[^1]: 没想到的
