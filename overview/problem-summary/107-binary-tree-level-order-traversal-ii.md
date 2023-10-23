# 🟠 107 - Binary Tree Level Order Traversal II

<details>

<summary>Description 题目描述 </summary>

Given the `root` of a binary tree, return _the bottom-up level order traversal of its nodes' values_. (i.e., from left to right, level by level from leaf to root).

<pre><code><strong>    3
</strong>   / \
  9  20
    /  \
   15   7
Input: root = [3,9,20,null,null,15,7]
<strong>Output: [[15,7],[9,20],[3]]
</strong></code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

按照level order搞一遍

然后reverse the result nested list

</details>

<details>

<summary>Algorithm </summary>

1. do the normal level order traversal
2. reverse the nested list using Collections.reverse(resultList)

</details>

<details>

<summary>✅ Code : reverse the list , use helper function</summary>

```java
class Solution {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<>();

        levelOrderHelper(root, resultList);
        Collections.reverse(resultList);
        return resultList;
    }

    private void levelOrderHelper(TreeNode root, List<List<Integer>> resultList) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                subList.add(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            resultList.add(subList);
        }
    }
}
```

</details>

<details>

<summary>✅ Code: add to front, not use helper function</summary>

<pre class="language-java"><code class="lang-java">class Solution {
    public List&#x3C;List&#x3C;Integer>> levelOrderBottom(TreeNode root) {
        List&#x3C;List&#x3C;Integer>> bottomUpLevelOrderList = new LinkedList&#x3C;>();

        // Use a queue for level order traversal
        Queue&#x3C;TreeNode> queue = new LinkedList&#x3C;>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            List&#x3C;Integer> levelList = new ArrayList&#x3C;>();
            int size = queue.size();

            // Process all nodes of the current level and add them to level list
            for (int i = 0; i &#x3C; size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                // Add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Insert the current level at the front of the list
            <a data-footnote-ref href="#user-content-fn-1">bottomUpLevelOrderList.add(0, levelList);</a>
        }

        return bottomUpLevelOrderList;
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

[^1]: add to front
