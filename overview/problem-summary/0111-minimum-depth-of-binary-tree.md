---
description: '@DFS @BFS✅ @Binary Tree'
---

# 🟢 0111 - Minimum Depth of Binary Tree

<details>

<summary>Description 题目描述 </summary>

Given a binary tree, find its minimum depth.

The minimum depth is the number of <mark style="color:red;">**nodes**</mark> along the shortest path from the root node down to the nearest leaf node.

```
    3
   / \
  9  20
    /  \
   15   7
```

```
Input: root = [3,9,20,null,null,15,7]
output: 2 (3->9)
```

```
    2
     \
      3
       \
        4
         \
          5
           \
            6
```

```
Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
```

</details>

<details>

<summary>Algorithm 解题思路 </summary>

### 题目大意

给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。说明: 叶子节点是指没有子节点的节点。

### 解题思路

* <mark style="color:red;">**用BFS最佳**</mark>： For the minimum depth problem, my first thought is to use a Breadth-First Search (BFS) approach. This is because BFS traverses the tree level by level from the root to the deeper levels. As soon as we find the first leaf node (a node with no children), we can return its depth as the minimum depth. This is contrasted with a Depth-First Search (DFS), where we might have to traverse the whole tree before we can ensure the minimum depth.
* 用DFS也可以：bottom up时候整体和maxDepth相同，只不过要有个extra step

<pre><code>        <a data-footnote-ref href="#user-content-fn-1">if (leftMinDepth == 0 || rightMinDepth == 0) {</a>
            return<a data-footnote-ref href="#user-content-fn-2"> </a>leftMinDepth + rightMinDepth + 1;
        }
</code></pre>



</details>

***

DFS: 好理解但是runtime长

<details>

<summary>Algorithm: DFS -> bottom up(post-order)  => <mark style="color:yellow;">extra step compared with maxDepth</mark></summary>

<pre class="language-java"><code class="lang-java">class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            <a data-footnote-ref href="#user-content-fn-3">return 0</a>;
        }
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        // 如果left/right只有一个child
        <a data-footnote-ref href="#user-content-fn-4">if (leftMinDepth == 0 || rightMinDepth == 0) {</a>
            return<a data-footnote-ref href="#user-content-fn-5"> </a>leftMinDepth + rightMinDepth + 1;
        }
        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }
}
</code></pre>

注意：

* minDepth在这里要<mark style="color:yellow;">**考虑left/right只有一个child的情况**</mark>: <mark style="color:red;">**example 2**</mark>
  * example 2中每个node都只有一个child node, 如果直接取min(leftMinDepth, rightMinDepth)， 那么result = 1 => 左边的subtree, 然而 if a node only has one child (either a left or right subtree), we cannot consider it as a leaf node and <mark style="color:yellow;">**should continue to traverse to its child node.**</mark>
  * However, when we calculate the maximum depth, our goal is to find the path from the root node to the furthest leaf node. So even if a node only has one child, we would take it into consideration because it can also form a path from the root node to a leaf node.

<!---->

* termination conditon: if root == null时return的是0而不是直接return

</details>

<details>

<summary>Algorithm: DFS -> top down(pre-order) => minVal的初始值不同</summary>

注意：

* 这里minVal的取值为<mark style="color:yellow;">**Integer.MAX\_VALUE**</mark>：
  * 这种做法其实是在初始化时把 `minVal` 设定为了一个极大的值，以便在后续的计算中，只要有任何一个叶子节点的深度小于这个值，我们就可以用这个叶子节点的深度来更新 `minVal`。
  * 如果我们将 `minVal` 初始化为 0 或者一个比较小的数，那么在遍历过程中可能会出现不能正确更新 `minVal` 的情况，因为所有的叶子节点深度都会大于或等于 1（至少，根节点自身就有一层深度），我们无法找到一个小于0或者这个较小数的叶子节点的深度来更新 `minVal`。
* 在main function minDepth的<mark style="color:yellow;">**第一步如果root为null要更新minVal 为0**</mark>

<pre class="language-java"><code class="lang-java">class Solution {

<strong>    int minVal = Integer.<a data-footnote-ref href="#user-content-fn-6">MAX_VALUE</a>; // 和max不同，取最大值
</strong><strong>    
</strong>    public int minDepth(TreeNode root) {
        <a data-footnote-ref href="#user-content-fn-7">if (root == null) return 0;</a> // 错点：注意这里如果是empty的时候要修改minVal
        calculateDepth(root, 1);
        return minVal;
    }
    
    private void calculateDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null &#x26;&#x26; root.right == null) {
            minVal = Math.min(minVal, depth);
        }
        calculateDepth(root.left, depth + 1);
        calcualteDepth(root.right, depth + 1);
    }
}
</code></pre>

</details>

BFS: 没有recursion在DFS中好理解 但是runtime好

<details>

<summary>Algorithm: BFS</summary>

```java
class Solution {
    public int minDepth(TreeNode root) {
        return bfs(root); 
    }
    
    // This is a helper method responsible for the entire breadth-first search process
    // and returns the minimum depth directly
    private int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int depth = 1; // need to inititate the depth to 1
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // add the root before looping
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                
                if(currNode.left == null && currNode.right == null) {
                    return depth;
                } 
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right!=null) {
                    queue.add(currNode.right);
                }
            }
            depth++;  // after each level, update the depth by adding 1
        }
        return -1;
    }
}

```

<mark style="color:yellow;">**Q:**</mark> <mark style="color:yellow;">**解释该算法如何使用 BFS 计算 minDepth**</mark>

* 这个算法是使用广度优先搜索（BFS）策略来遍历二叉树。BFS 是一种层序遍历策略，从根节点开始，然后逐层向下遍历，直到找到叶子节点。这个算法使用一个队列来存储待处理节点，队列的特性是先进先出（FIFO），因此能够保证层序遍历。
* 算法开始时，先将根节点放入队列，然后开始一个循环，直到队列为空。在每个循环里，先获取当前队列的大小，这个大小就是当前层级的节点数量。然后，对每一个在这一层的节点，从队列中移除它，检查它是否是叶子节点（即左右子节点都为空）。<mark style="color:green;">**一旦遇到叶子节点，就立即返回当前的深度。**</mark>
* <mark style="color:green;">**如果节点不是叶子节点，就将它的左右子节点添加到队列中**</mark>。<mark style="color:green;">**等这一层的所有节点都被处理完后，深度加一，然后继续处理下一层的节点**</mark>。因此，由于 BFS 的特性，我们总是先处理浅层的节点，然后再处理深层的节点。所以，当我们遇到第一个叶子节点时，就找到了最小深度。

<mark style="color:yellow;">**Q: 为什么计算 minDepth 的时候考虑用 BFS 而 maxDepth 时只考虑DFS呢？**</mark>

* 当我们寻找一棵树的minDepth时，我们的目标是找到从root到<mark style="color:red;">**最近的left node**</mark>的最短路径。因为 BFS 是层序遍历level traversal，<mark style="color:yellow;">**我们可以保证在一个level一旦出现一个leaf node，它的深度一定是最小的**</mark>**。因此，使用 BFS 是一个很有效的策略。**
* 然而，当我们计算maxDepth时，我们需要找到从root到<mark style="color:green;">**最远的叶子节点**</mark>的最长路径。在这种情况下，<mark style="color:green;">**BFS 就不太适用了，因为我们需要遍历整棵树，而 DFS 则可以直接深入到最深的节点，因此，DFS 通常是更好的选择。**</mark>

<mark style="color:yellow;">**depth++:**</mark> Inside the main while-loop of the BFS algorithm, we process all nodes at the current level (all nodes currently in the queue). Once we've finished processing all nodes at the current level, we move to the next level of the tree. This is when we increment `depth` by one with `depth++`, to indicate that we're moving down one level in the tree.



</details>

<details>

<summary>Code Analysis</summary>

BFS:

* Time complexity: O(n), where n is the total number of nodes in the tree. This is because in the worst-case scenario, we will need to visit all nodes in the tree once.

<!---->

* Space complexity: O(n), where n is the total number of nodes in the tree. In the worst-case scenario, the queue might need to store all nodes of a level. And for a full binary tree, the lowest level has roughly n/2 nodes.

DFS:

* Time Complexity: **O(N)** The time complexity of DFS is O(N), where N is the total number of nodes in the binary tree. This is because DFS traverses each node exactly once, so the total time complexity is proportional to the number of nodes in the tree.
* Space Complexity: O(H), The space complexity of DFS is O(H), where H is the height of the binary tree. This is because the maximum amount of space is utilized by the recursion stack (or the system stack) which is at max, the height of the tree. In the worst case of a skewed binary tree, the tree height is N, so the space complexity is O(N). But in the best case of a balanced binary tree, the tree height is logN, so the space complexity is O(logN).

</details>

<details>

<summary>Key Points</summary>



</details>

[^1]: 区别maxDepth

[^2]: 

[^3]: notnull&#x20;

[^4]: 区别maxDepth

[^5]: 

[^6]: 区别maxDepth

[^7]: 区别maxDepth
