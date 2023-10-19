---
description: '@Binary Tree @String @Backtracking  @Depth-First Search'
---

# 🟢 257 - Binary Tree Paths

<details>

<summary>Description 题目描述 </summary>

Given the <mark style="color:yellow;">**`root`**</mark> of a binary tree, return _<mark style="color:yellow;">**ALL root-to-leaf paths**</mark> in <mark style="color:yellow;">**any order**</mark>_<mark style="color:yellow;">**.**</mark>

A **leaf** is a node with no children.

<pre class="language-sql"><code class="lang-sql"><strong>Input:
</strong>   1
 /   \
2     3
 \
  5
Output: ["1->2->5", "1->3"]  // List&#x3C;Strings>
</code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

* <mark style="color:red;">**Path**</mark> => <mark style="color:yellow;">**ROOT to LEAF node:**</mark> the deepest node of each child branch
  * <mark style="color:purple;">**root**</mark>: 不变 , 以root为基准
  * <mark style="color:purple;">**Leaf node的判断**</mark>：if (root.left == null && root.right == null)
* <mark style="color:yellow;">**✅ 思考笔记过程**</mark>
  * if the root is null, -> no consideration&#x20;
  * initiate a list resultList to store the variable, add and update if reach a leaf node&#x20;
  * recursion:
    * Termination Condition:  if currNode.left == null && currNode.right == null => leaf node
      * 1.add the node to the subString&#x20;
      * 2.add the subString to the resultList
    * Logic of Singly Layer Recursion
      * add the currNode to the string with ->&#x20;
      * the path from currNode to its left and right node (binaryTreePaths(root.left)
* &#x20;<mark style="color:red;">**卡的点:**</mark>** **<mark style="color:yellow;">**String related method**</mark>\
  1\. initiate an empty string \
  2\. add character to a string
* 在写的过程中想到了helper function with parameters: root, resultList, strBuilder

</details>

<details>

<summary><mark style="color:green;">Code 自己写的wrong的</mark>: 因为没有回溯backtrack的idea在脑子里，差一点</summary>

<pre class="language-java"><code class="lang-java">class Solution {
  public List&#x3C;String> binaryTreePaths(TreeNode root) {
  
    List&#x3C;String> resultList = new ArrayList&#x3C;>();
    StringBuilder strBuilder = new StringBuilder(); // sub string in the list

    updateResult(root, resultList, strBuilder);
    return resultList;
  }

  // helper method: update the resultList using recursion
  public void updateResult(TreeNode root, List&#x3C;String> resultList, StringBuilder strBuilder) {
    // termination condition
    if (root == null) {
      return;
    }

    strBuilder.append(root.val);

    if (root.left == null &#x26;&#x26; root.right == null) {
      resultList.add(strBuilder.toString());
      <a data-footnote-ref href="#user-content-fn-1">strBuilder.setLength(0);</a>
    } else {
      strBuilder.append("->");
      updateResult(root.left, resultList, strBuilder);
      <a data-footnote-ref href="#user-content-fn-2">updateResult(root.right, resultList, strBuilder);</a>
    }

  }
}
</code></pre>

```
    1
   / \
  2   3
 / \
4   5
```

Here's a visualization of how your original code operates:

1. Begin at the root node, `1`. Append `1` to the `StringBuilder`.
2. Since `1` has left and right children, append `"->"` to the `StringBuilder`.
3. Recursively call `updateResult()` on the left child, `2`. Append `2` to the `StringBuilder`.
4. Since `2` also has left and right children, append `"->"` to the `StringBuilder`.
5. Recursively call `updateResult()` on the left child, `4`. Append `4` to the `StringBuilder`.
6. Since `4` is a leaf node (no children), add the current `StringBuilder` value (`"1->2->4"`) to the `resultList` and reset `StringBuilder` to an empty state.
7. <mark style="color:yellow;">Backtrack to node</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`2`</mark><mark style="color:yellow;">. Now,</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`StringBuilder`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">is empty. Call</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`updateResult()`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">on the right child,</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`5`</mark><mark style="color:yellow;">. But since</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`StringBuilder`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">is now empty, the path will be</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`"5"`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">instead of</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`"1->2->5"`</mark><mark style="color:yellow;">.</mark>
8. <mark style="color:yellow;">Backtrack to node</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`1`</mark><mark style="color:yellow;">. Call</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`updateResult()`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">on the right child,</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`3`</mark><mark style="color:yellow;">. But</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`StringBuilder`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">is now empty, so the path will be</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`"3"`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">instead of</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`"1->3"`</mark><mark style="color:yellow;">.</mark>

</details>

<details>

<summary>✅ Algorithm &#x26; Code: use back track and helper method </summary>

```java
// input:[1, 2, 3, 4, 5]
// output:["1->2->4", "1->2->5", "1->3"]
    1
   / \
  2   3
 / \
4   5
```

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultPathList = new ArrayList<>();
        StringBuilder pathString = new StringBuilder();
        // update resultPathList by passing it to the helper method
        generatePaths(root, resultPathList, pathString);
        return resultPathList;
    }
    
    // main idea: recurision and backtracking
    private void generatePaths(TreeNode root, List<String> resultPathList, StringBuilder pathString) {
        // 1. null node: termination condition for a null node
        // not just for the initial but the ending condition of the leaf node
        if (root == null) {
            return;
        }
        
        // 2: leaf node termination condition: leaf node
        if (root.left == null && root.right == null) {
            // append the leaf node value to pathString wthout "->"
            pathString.append(root.val);
            resultPathList.add(pathString.toString()); // 这里忘记写 
            return;
        } 

        // 3: Node with at least one/two child
        // if root is not null: append its value to the pathString with "->"
        // =========== 处理本层node ===========
        pathString.append(root.val);
        pathString.append("->");
        // =========== backtracking ============
        // Key: 标记在处理left node之前的点
        int len = pathString.length();
        // ---- recursion: 处理left node ----
        generatePaths(root.left, resultPathList, pathString);
        // ---- KEY: 回溯backtracking，撤销处理结果 ----
        // 在处理right branch之前要把left更新的pathString更新到之前的状态
        pathString.setLength(len);
        // ---- recursion: 处理right node ----
        generatePaths(root.right, resultPathList, pathString); // 这里前要更新pathString
    }
}
```

A binary tree represented by the array `[1,2,3,4,5]` can be visualized like this:

```
    1
   / \
  2   3
 / \
4   5
output:["1->2->4", "1->2->5", "1->3"]
```

Now, let's go through your code with this tree:

1. Start with the root node, `1`. Add `1` to the `StringBuilder`.
2. As the root node has both left and right children, append `"->"` to the `StringBuilder`.
3. Recursively call `updateResult()` on the left child, `2`. Add `"2"` to the `StringBuilder`.
4. As node `2` also has both left and right children, append `"->"` to the `StringBuilder`.
5. Recursively call `updateResult()` on the left child, `4`. Add `"4"` to the `StringBuilder`.
6. Node `4` is a leaf node, so add the current `StringBuilder` value (`"1->2->4"`) to `resultList` and <mark style="color:yellow;">reset the</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`StringBuilder`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">to the</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">**length before processing node**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`4`**</mark><mark style="color:yellow;">**.**</mark>
7. Backtrack to node `2` and now process its right child, `5` in a similar manner, leading to `"1->2->5"` being added to `resultList`.
8. Backtrack to node `1` and now process its right child, `3`. Add `"1->3"` to `resultList` as node `3` is a leaf node.
9. At the end of the traversal, `resultList` contains `["1->2->4", "1->2->5", "1->3"]`.

</details>

<details>

<summary>✅✅ Algorithm: do back track for the leaf node -- inspired by 113</summary>

通过113之后修改的写法：

* 在helper method中，\ <mark style="color:yellow;">**除了null node, 无论是leaf node和普通node**</mark><mark style="color:red;">**都需要backtrack到上一个节点**</mark>

<pre class="language-sql"><code class="lang-sql"><strong>1. 处理null node
</strong><strong>2. 标记当前node,用于backtrack
</strong><strong>3. 处理当前node
</strong><strong>4. 用 IF ELSE
</strong><strong>if (leaf node) {
</strong>    do the termination
} else {
    do the recursion and pass the 共享变变量
}
5. backtrack
</code></pre>

<mark style="background-color:purple;">**为什么虽然String是个reference type，但是我们在line 18中把pathString加到resultPathList中的时候，pathString不会随着recursion的改变而改变？**</mark>

* 对于String和StringBuilder，它们是**引用类型**。
* <mark style="color:yellow;">**String是不可变的**</mark>，也就是说一旦一个String对象被创建，它的值就不能改变。如果你对一个<mark style="color:yellow;">**String对象进行修改（比如拼接或者剪裁），Java实际上会**</mark><mark style="color:red;">**创建一个新的String对象来存储修改后的字符串**</mark><mark style="color:yellow;">**，原来的String对象不会被改变**</mark>。
* 相比之下，StringBuilder是可变的。如果你对一个StringBuilder对象进行修改，这个修改会直接影响到这个对象本身，而不会创建一个新的对象。因此，StringBuilder通常用于需要频繁修改字符串的情况，因为它的性能比String更好。

{% code lineNumbers="true" %}
```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultPathList = new ArrayList<>();
        StringBuilder pathString = new StringBuilder();
        generatePaths(root, resultPathList, pathString);
        return resultPathList;
    }
    
    private void generatePaths(TreeNode root, List<String> resultPathList, StringBuilder pathString) {
        if (root == null) {   // 1. 处理null node
            return;
        }
        
        int len = pathString.length(); // 2. 标记当前node, 用于backtrack
        pathString.append(root.val);    // 3. 处理当前node
        
        if (root.left == null && root.right == null) { // 4. if lese
            resultPathList.add(pathString.toString()); // add pathString to result list when we reach a leaf node
        } else {
            pathString.append("->");
            generatePaths(root.left, resultPathList, pathString);
            generatePaths(root.right, resultPathList, pathString);
        }
        
        pathString.setLength(len); // 5.backtrack
    }
}
```
{% endcode %}



</details>

<details>

<summary>Algoritm Summary</summary>

The main idea of this algorithm is depth-first search (DFS) based on recursion and backtracking. Here are the steps of the algorithm:

<mark style="color:yellow;">**Main Function:**</mark> <mark style="color:blue;">**binaryTreePaths(TreeNode root)**</mark>

* Initialize an empty result list `resultPathList` and a StringBuilder `pathString` to hold the path.
* Call the helper function generatePaths with the root node, result list, and path string as arguments. By calling this helper function, we will update the resultPathList

<mark style="color:yellow;">**Helper Function:**</mark> <mark style="color:blue;">generatePaths(TreeNode root, List\<String> resultPathList, StringBuilder pathString)</mark>

<mark style="color:orange;">**Termination condition: null and leaf node**</mark>

* <mark style="color:blue;">**Null Node:**</mark> check if the current node is null:
  * If it is, then return.
  * This is the termination condition for handling null nodes, including the initial root node and the children of leaf nodes.
* <mark style="color:blue;">**Leaf Node:**</mark> Check if the current node is a leaf node (i.e., both left and right children are null):
  * If it is, append the leaf node's value to pathString (no arrow needed), then add the path string to the result list. Then return, as leaf nodes have no children for further recursion.

Now focus on <mark style="color:orange;">**node with at one/two node.**</mark> If the current node is neither null nor a leaf node, process the current node:

* <mark style="color:blue;">**Append**</mark> the current node's value and an arrow to pathString.&#x20;
* <mark style="color:red;">**Backtracking Preparation:**</mark> Before processing the left child node, mark the current length of the path string for later backtracking.
* Recursively process the left child node: call <mark style="color:blue;">**generatePaths(root.left, resultPathList, pathString).**</mark>
* <mark style="color:red;">**Backtrack:**</mark> before processing the right child node, undo the modification to the path string by setting its length back to the previous length.
* Recursively process the right child node: call <mark style="color:blue;">**generatePaths(root.right, resultPathList, pathString).**</mark>

In this way, we can traverse the entire tree and for each leaf node, we generate and save a path from the root node to it.

**Time Complexity:**

The time complexity of this solution is O(N), where N is the number of nodes in the binary tree. This is because we visit each node exactly once during the DFS traversal.

**Space Complexity:**

The space complexity is O(H), where H represents the height of the tree. This is due to the maximum amount of space that will be used by the call stack during the recursion.

</details>

<details>

<summary>✅ 心得 Key Points</summary>

1. 把思考笔记过程写下来是个好办法
2. <mark style="color:red;">**node的三种情况**</mark>
   1. <mark style="color:yellow;">**termination: null node**</mark>\
      尽管题目中写root不是null, 但是要考虑leafNode.left & right的null
   2. <mark style="color:yellow;">**termination: leaf node**</mark>\
      这里的处理是这道题的单层termination
   3. <mark style="color:yellow;">**node with at least one/two child:**</mark>** **<mark style="color:green;">**这里用了backtracking的思想**</mark>\
      处理left和right child use recursion
3. 参照<mark style="color:red;">**backtrack**</mark>的模版，这是我做backtrack tag的第一题

```java
void backtracking(参数){
    if (termination conditon) {
        store result;
        return;
    }
    
    for (选择：本层的元素（tree中node的child数量就是set的大小）) {
        处理node;
        backtracking(路径， 选择列表) // recursion
        回溯，撤销处理结果
    }
}
```

4. <mark style="color:yellow;">**StringBuilder的method**</mark>
   1. StringBuilder是个<mark style="color:orange;">**class**</mark>: StringBuilder sb = new <mark style="color:orange;">**StringBuilder();**</mark>
   2. add to StringBuilder: sb.<mark style="color:orange;">**append**</mark>("aadhaks")
   3. set the length of StringBuilder: sb.<mark style="color:orange;">**setLength**</mark>(newLength)
   4. convert StringBuilder to string: sb.toString()\


</details>

[^1]: 这个写的不对

[^2]: 在进行这一步之前strBuilder已经被set为空
