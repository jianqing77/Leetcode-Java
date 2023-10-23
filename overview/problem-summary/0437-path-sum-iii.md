---
description: '@Depth-First Search @Binary Tree'
---

# ❌ 437 - Path Sum III



<details>

<summary>Description 题目描述  <a href="https://leetcode.com/problems/path-sum-iii/description/">link</a></summary>

Given the `root` of a binary tree and an integer `targetSum`, return _the number of paths where the sum of the values along the path equals_ `targetSum`.

The <mark style="color:yellow;">**path does not need to start or end at the**</mark>** **<mark style="color:red;">**root or a leaf**</mark><mark style="color:yellow;">**,**</mark> but it <mark style="color:yellow;">**must go downwards**</mark> (i.e., traveling only from parent nodes to child nodes).

![](<../../.gitbook/assets/Screenshot 2023-10-19 at 8.19.45 PM.png>)

<pre><code><strong>Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
</strong><strong>Output: 3
</strong><strong>Explanation: The paths that sum to 8 are shown.
</strong></code></pre>

**Constraints:**

* The number of nodes in the tree is in the range <mark style="color:red;">`[0,`</mark>` ``1000]`.
* `-109 <= Node.val <= 109`
* `-1000 <= targetSum <= 1000`

</details>

<details>

<summary>解题思路 Intuition: Value是positive</summary>

1. 不同的constraint: node可能为0
2. 不同的path定义：path不需要是roof to leaf但是需要downwards且连续

Question:

<mark style="color:yellow;">**The definition of path is different so the method is also different? or i can still use backtracking？**</mark>

The definition of a path in this problem is slightly different from some other tree path problems since a path does not need to start from the root or end at a leaf. However, you can still use a method similar to backtracking to solve this problem by exploring all possible paths.

<mark style="color:yellow;">**The nodes must be continuous, how can i use the downward keyword to solve the problem?**</mark>

The 'downward' keyword means that once you start a path, you can only move to the child nodes, not the parent nodes. So, you can't go back up once you start a path. This is important because it limits the direction of the path traversal.

<mark style="color:yellow;">**Any solution or ideas you could provide to help me with the problem?? How can i think to this approach?**</mark>

Here's a high-level approach to solve this problem:

* <mark style="color:blue;">**For each node, we could try to treat it as the start of a path,**</mark> and see if we can find a path down to a leaf node such that the sum of the values along the path equals the target sum.
* <mark style="color:blue;">**To implement this, we can use recursion.**</mark> In the recursive function, we pass the current node and the current sum. If the current node is null, we return 0. If the current sum + node.val equals the target sum, we increase the count by 1.
* We then return the count from the left subtree + the count from the right subtree. This gives us the total number of paths that sum to the target sum in the tree rooted at the current node.
* Finally, we call this recursive function on both the left and right child of the original root, and return the sum of these two counts, plus the count from the root itself.

</details>

<details>

<summary>解题思路: Value包含negative的</summary>

The solution involves using a <mark style="color:yellow;">**prefix sum**</mark> and a <mark style="color:yellow;">**HashMap**</mark> to record how many ways can get to this prefix sum. Here we use a <mark style="color:red;">**HashMap**</mark> to track the prefix sum we have encountered so far and the corresponding path count.

Here's a high-level approach to solve this problem:

* Use a HashMap to save the prefix sum up to the current node in the recursion. The prefix sum is the target in the problem description. The key is the prefix sum, and the value is how many ways get to the prefix sum.
* If we can find a prefix sum in the HashMap that equals to `currentSum - target`, we know there are those many number of paths where the sum equals to the target.
* Add the current node's value to the current sum at the beginning of the recursion.
* If the current sum equals to the target in the HashMap, increment the path count.
* In the end, return the path count.

</details>

<details>

<summary>Prefix Sum </summary>

<mark style="color:yellow;">**Prefix Sum:**</mark>** **<mark style="color:red;">**优化求sublist的value sum**</mark> \ <mark style="color:red;">**=>**</mark> optimize the problem of <mark style="color:blue;">**obtaining the sum of elements within a range.**</mark>

```sql
Array a:
index:  0   1   2   3   4
valeu:  [3,  2,  1,  4,  5]

prefixSum:
index:  0   1   2   3   4
value:  [3, 5,  6, 10, 15]
```

* prefixSum\[2] = a\[0] + a\[1] + a\[2] = 3 + 2 + 1 = 6。
* <mark style="color:blue;">**sum of value from index 1 - 3**</mark> (inclusive, 3 elements):\
  <mark style="color:blue;">**prefixSum\[3] - prefixSum\[0]**</mark> =  10 - 3 = 7 =  a\[1] + a\[2] + a\[3] =  2 + 1 + 4 = 7。

</details>

<details>

<summary>Code Demo : using prefix sum</summary>

Asks for the number of paths in a binary tree that sum up to a given value. The path doesn't need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

Here's how the algorithm works:

1. **Initialize variables**:&#x20;
   1. <mark style="color:purple;">**totalPathsCount**</mark><mark style="color:yellow;">**:**</mark> keep track of the total # of valid paths found,  initially set to 0
   2. <mark style="color:purple;">**targetSum**</mark><mark style="color:yellow;">**:**</mark> hold the sum we are trying to find in the paths.&#x20;
   3. <mark style="color:yellow;">**HashMap**</mark>**  **<mark style="color:purple;">**prefixSumCount**</mark> : \
      **key**:  the prefix sum (sum of values from the root to the current node) \
      **value**: frequency of the prefix sum.
2. **Helper Method:  **<mark style="color:yellow;">**depthFirstSearch**</mark> \
   Start a depth-first search from the root, with the initial current sum set to 0.\
   params: root, targetSum\
   return: void
   * If the current node is null, return. \
     This base case handles the recursion for leaf nodes' children.
   * If the current node is null, add the current node's value to <mark style="color:yellow;">**currentSum**</mark>.
   * If (currentSum == targetSum ) => **totalPathsCount++**
   * Check if there is a prefix sum that when added to some subarray equals to `targetSum`. This is done by checking if `currentSum - targetSum` exists in the `prefixSumCount` hashmap. If it does, add its frequency to `totalPaths`. This step essentially checks for any subpath ending at the current node whose sum of nodes equals `targetSum`.
   * Add the `currentSum` into the `prefixSumCount` hashmap or update its frequency if it exists already.
   * Recursively call the `depthFirstSearch` method for the left and right child of the current node, continuing the process.
   * After both left and right subtrees have been processed, decrement the frequency of `currentSum` in the hashmap by 1. This is done because as we pop off the function call stack (backtrack from the current node), we need to remove the current node's effect on the prefix sum for subsequent recursive calls on parallel subtrees.
3. **Return the result**: After the depth-first search is complete, return the `totalPaths` variable which now holds the number of paths that sum up to the given target sum.

This algorithm effectively uses the prefix sum concept along with depth-first search traversal to solve the problem. The prefix sum helps to quickly check if a subpath sum equals to the target sum, and the depth-first search is used to explore all possible paths in the tree.

```java
class Solution {
    int count = 0;
    int k;
    HashMap<Long, Integer> map = new HashMap();
    
    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0L);
        return count;
    }
    
    public void preorder(TreeNode node, long currSum) {
        if (node == null)
            return;
        
        // current prefix sum
        currSum += node.val;

        // here is the sum we're looking for
        if (currSum == k)
            count++;
        
        // number of times the curr_sum − k has occured already, 
        // determines the number of times a path with sum k 
        // has occured upto the current node
        count += map.getOrDefault(currSum - k, 0);
        
        // add the current sum into hashmap
        // to use it during the child nodes processing
        h.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // process left subtree
        preorder(node.left, currSum);
        // process right subtree
        preorder(node.right, currSum);

        // remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        map.put(currSum, map.get(currSum) - 1);
    }    
        
}
```

</details>

<details>

<summary>✅ DFS: use recursion =这个好理解但是runtime打 </summary>

```java
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        // If root is null, there are no paths to add up to the sum
        if(root == null) {
            return 0;
        }

        // Find paths starting from the root, then try the same for the left and right children
        return countPathsFromNode(root, sum) 
               + pathSum(root.left, sum) 
               + pathSum(root.right, sum);
    }
    
    private int countPathsFromNode(TreeNode node, long sum) {
        // If node is null, there are no paths to add up to the sum
        if(node == null) {
            return 0;
        }

        // If the node's value equals the sum, 
        // explore paths starting from the left and right children with sum reset to 0
        // 更改targetSum: 如果root node value = targetSum, 那么在左右child node里边寻找和为0的path
        if(node.val == sum) {
            return countPathsFromNode(node.left, 0) 
                   + countPathsFromNode(node.right, 0)
                   + 1;
        }

        // Explore paths starting from the left and right children with updated sum
        // 无论当前节点的值是否等于目标和，我们都会继续在左右子节点中寻找其值等于 sum - node.val 的路径，
        // 更新目标和为 sum - node.val
        return countPathsFromNode(node.left, sum - node.val) 
              + countPathsFromNode(node.right, sum - node.val);
    } 
}
```

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>心得 Key Points</summary>



</details>
