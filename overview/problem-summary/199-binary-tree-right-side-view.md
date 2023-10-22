# 🟠 199 -  Binary Tree Right Side View



<details>

<summary>Description 题目描述 </summary>

Given the `root` of a binary tree, imagine yourself standing on the **right side** of it, return _the values of the nodes you can see ordered from top to bottom_.

```
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```

**Constraints:**

* The number of nodes in the tree is in the range `[0, 100]`.
* `-100 <= Node.val <= 10`

</details>

<details>

<summary>解题思路 Intuition </summary>

* the right of right of right
* dfs on the right side only&#x20;
* need to use recursion
* 没想到的是如果right是null时可以看到left的

</details>

<details>

<summary>Algorithm </summary>

When viewing a binary tree from the right side, what you're essentially trying to do is <mark style="color:yellow;">**capture the rightmost node at each level of the tree.**</mark>

</details>

<details>

<summary>Code Demo : wrong</summary>

```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        findRightSideNodes(root, resultList);
        return resultList;
    }
    
    private void findRightSideNodes(TreeNode root, List<Integer> resultList) {
        if (root == null ) {
            return;
        }
        
        // 处理当前node
        resultList.add(root.val);
        
        if (root.right == null) {
            if (root.left == null) {
                return;
            } else {
                findRightSideNodes(root.left);
            }
        } 

        if (root.right != null) {
            findRightSideNodes(root.right);
        }
    }
}
```

```
Input: [1,2,3,null,4]
Output: 应该是[1, 3, 4] 但是我的code是[1,3]
   1            <---
 /   \
2     3         <---
 \     
  4             <---
```

My original code attempts to achieve this by always preferring to traverse to the right child of a node, and only traversing to the left child if the right child is null. This approach works correctly for trees that are either balanced or skewed to the right, as the rightmost node at each level will always be encountered and added to the result list.

</details>

<details>

<summary>✅✅ Code:   DFS + Add Level using recursion</summary>

难想到的点：加level作为indicator

```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        findRightSideNodes(root, resultList, 0); // start from level 0
        return resultList;
    }

    private void findRightSideNodes(TreeNode node, List<Integer> resultList, int level) {
        if (node == null) {
            return;
        }

        // If this is the first node of its level, add it to the result list
        if (resultList.size() == level) {
            resultList.add(node.val);
        }

        // First visit the right child, then the left child
        findRightSideNodes(node.right, resultList, level + 1);
        findRightSideNodes(node.left, resultList, level + 1);
    }
```

```
    1          Level 0 - Add 1 to the resultList -> [1]
   / \
  2   3        Level 1 - Add 3 to the resultList -> [1,3]
   \
    4          Level 2 - Add 4 to the resultList -> [1,3,4]
```

<mark style="color:yellow;">**How to explain the**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`findRightSideNodes`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**method in more detail:**</mark>

This method is a recursive function that's designed to traverse the tree in a depth-first manner, specifically right-first.

**Parameters:**

* `node`: This is the current node being processed.
* `resultList`: This is the list that stores the result.
* `level`: This is the current depth of the tree, starting from 0 for the root.

**Function Body:**

1. `if (node == null) return;`: This is the base case for the recursion. If a null node is encountered, it means we've reached a leaf node in a previous recursive call and should return without doing anything.
2. `if`` `<mark style="color:yellow;">**`(resultList.size() == level)`**</mark>` ``resultList.add(node.val);`: This line checks if the size of the `resultList` is equal to current `level`. If it is, that means we've reached a new level of the tree for the first time and should add the current node's value to the `resultList`. This happens because we're going "right-first" -- so the first node we hit at each level is the rightmost node at that level when viewed from the right side.
3. `findRightSideNodes(node.right, resultList, level + 1);`: This line is a recursive call to the right child of the current node. We increment the `level` by 1 since we're going down one level in the tree.
4. `findRightSideNodes(node.left, resultList, level + 1);`: This line is a recursive call to the left child of the current node, after the right child has been processed. We again increment the `level` by 1.

By visiting the right child before the left child and only adding the first node we encounter at each level, we ensure that the rightmost node at each level is added to the `resultList`. This gives us the right side view of the binary tree.

</details>

<details>

<summary>✅Code: BFS + Queue => find the last element in each level </summary>

```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelSize - 1) {
                    resultList.add(currentNode.val);
                }
                
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        
        return resultList;
    }
}
```

![](../../.gitbook/assets/image.png)

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>心得 Key Points</summary>



</details>
