---
description: '@Backtracking @Tree @Depth-First Search'
---

# 🟢 0112 - Path Sum

<details>

<summary>Description 题目描述 </summary>

<mark style="color:yellow;">**Given a binary tree and a sum**</mark>, determine if the tree has a <mark style="color:yellow;">**root-to-leaf path**</mark> such that adding up all the values along the path equals the given sum.

**Note:** A leaf is a node with no children.

```
Given the below binary tree and sum = 22, 
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
```

</details>

<details>

<summary>解题思路 Intuition </summary>

1. handle value了开始
2. 感觉是binary tree paths的变形: not form a string, but calculate the sum of each node

</details>

<details>

<summary>Algorithm &#x26; Code: 用257-binary tree path的方法来做 -- 自己写的效率不高</summary>

<mark style="color:yellow;">**整体思想**</mark>：把**every path sun form a list, and check if the targetSum is in the list**

1. <mark style="color:yellow;">**Helper Method:**</mark>  generatePathList(TreeNode root, List\<Integer> pathSumList, int pathSum) \
   params: root, set(to be updated), subset(to be backtrack)
   1. null node
   2. leaf node
   3. node with one/two child
      1. <mark style="color:blue;">**处理当前node**</mark>
      2. <mark style="color:blue;">**标记当前node**</mark>
      3. <mark style="color:blue;">**recursion left**</mark>
      4. <mark style="color:blue;">**backtrack to recursion left之前的node**</mark>
      5. <mark style="color:blue;">**recursion right**</mark>
2. <mark style="color:yellow;">**Main method**</mark><mark style="color:yellow;">:</mark> hasPathSum(root)
   1. initiate the params to be passed in **Helper**
   2. call helper method
   3. return

```
Given the below binary tree and sum = 22, 
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
```

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> pathSumList = new ArrayList<>();
        int pathSum = 0;
        generatePathSumList(root, pathSumList, pathSum);
        return pathSumList.contains(targetSum);
    }
    
    private void generatePathSumList(TreeNode root, List<Integer> pathSumList, int pathSum) {
        // 1. node == null
        if (root == null) {
            return;
        } 

        // 2. leaf node
        if ((root.left == null) && (root.right == null)) {
            pathSum += root.val;
            pathSumList.add(pathSum);
            return;
        }

        // 3. node with one/two child
        pathSum += root.val; // 3.1. 处理当前node
        int tempSum = pathSum; // 3.2 标记root node的值
        generatePathSumList(root.left, pathSumList, pathSum); //3.3 recursion left
        pathSum = tempSum; // 3.4 backtracking: 撤回操作
        generatePathSumList(root.right, pathSumList, pathSum); //3.3 recursion right
    }
}
```

</details>

<details>

<summary>Algorithm: 效率高， 不需要form a list，隐形backtracking</summary>

<mark style="color:yellow;">**The**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`pathSumList`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**in the above method does not need to store all sums**</mark>**.** Instead of storing all path sums and then checking if the target sum is in the list, you can return true as soon as you find a path that sums to the target. This will make your code more efficient because you can stop the search early.

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Call the helper method with the root node and initial path sum of 0
        return hasPathSumHelper(root, 0, targetSum);
    }
    
    private boolean hasPathSumHelper(TreeNode node, int pathSum, int targetSum) {
        // Termination Condition: null node
        // If the node is null, return false (this path doesn't sum to the target)
        if (node == null) {
            return false;
        }

        // Termination condition: If this is a leaf node, check if the path sum equals the target sum
        if (node.left == null && node.right == null) {
            pathSum += node.val;
            return pathSum == targetSum;
        }
                
        // Add the current node's value to the path sum
        pathSum += node.val;
        
        // Recursively check the left and right subtrees
        // pathSum is a local variable, one change does not affect another
        return hasPathSumHelper(node.left, pathSum, targetSum) || 
               hasPathSumHelper(node.right, pathSum, targetSum);
    }
}
```

<mark style="color:yellow;">**Q: How did the solution uses backtracking?**</mark>

* In fact, this solution does <mark style="color:yellow;">**use a form of backtracking**</mark>, but it may be less obvious because we <mark style="color:blue;">**don't explicitly undo any changes**</mark> as in some other backtracking problems
* Backtracking is a strategy used for finding all (or some) solutions to computational problems, particularly constraint satisfaction problems. It incrementally builds candidates for the solutions, and abandons a candidate as soon as it determines that the candidate cannot possibly be extended to a valid solution.
* In this problem:
  * we're <mark style="color:yellow;">**incrementally building the sum of the path from the root to each leaf node.**</mark>&#x20;
  * We <mark style="color:yellow;">**"abandon" a path**</mark> (i.e., stop going further down a branch of the tree) <mark style="color:blue;">**as soon as we reach a LEAF node**</mark>. When we've finished processing a leaf node, the recursive call to that path finishes, and we automatically "go back" (hence, backtracking) to the parent node and start processing the other child.

<mark style="color:yellow;">**Q: Why don't need to manually subtract  the node value from the pathSum?**</mark>

We don't need to manually subtract the node value from the path sum in a separate step (as some might expect in a typical backtracking approach) <mark style="color:yellow;">**because the**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`pathSum`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**variable is a local variable**</mark>. <mark style="color:blue;">**Each recursive function call gets its own copy of this variable, so changes in one function call don't affect the**</mark><mark style="color:blue;">** **</mark><mark style="color:blue;">**`pathSum`**</mark><mark style="color:blue;">** **</mark><mark style="color:blue;">**in another.**</mark>

So, in this problem, the backtracking is somewhat "implicit" in the sense that it's done automatically by the function call stack when the recursive calls return.

</details>

<details>

<summary>Code Analysis</summary>

Time Complexity: The time complexity of this code is O(N), where N is the total number of nodes in the tree. This is because in worst-case scenario, we have to visit all the nodes of the tree once.

Space Complexity: The space complexity of this code is O(H), where H is the height of the tree. This is because the maximum amount of space it will use on the function call stack relates to the deepest path in the tree, which is the height of the tree. In the worst case (a skewed tree), this would be O(N).

</details>

<details>

<summary>心得 Key Points</summary>

注意不同的backtracking的体现：这道题的第二种解法，<mark style="color:red;">backtrack的undo操作是没有的</mark>，因为我们的pathSum是个 local vairable而且recursion到left and right node的时候是用OR, 因此left的pathSum不会影响rightPathSum: <mark style="color:yellow;">**`pathSum`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**variable is a local variable**</mark>. <mark style="color:blue;">**Each recursive function call gets its own copy of this variable, so changes in one function call don't affect the**</mark><mark style="color:blue;">** **</mark><mark style="color:blue;">**`pathSum`**</mark><mark style="color:blue;">** **</mark><mark style="color:blue;">**in another.**</mark>

</details>
