---
description: '@HashTable @DFS @BFS  @BinaryTree'
---

# 🟠 0314 -  Binary Tree Vertical Order Traversal

<details>

<summary>Description 题目描述 </summary>

Given the `root` of a binary tree, return _**the vertical order traversal** of its nodes' values_. (i.e., from <mark style="color:yellow;">**top to bottom**</mark>, <mark style="color:yellow;">**column by column**</mark>).

If two nodes are in the same row and column, the order should be from <mark style="color:yellow;">**left to right**</mark><mark style="color:yellow;">.</mark>&#x20;

<pre><code>Input: [3,9,8,4,0,1,7,null,null,null,2,5]
Output: [[4],[9,5],[3,0,1],[8,2],[7]]

          3        
      /      \
     9        8            
   /   \     /  \
  4     0   1    7   
<strong>       /     \
</strong><strong>      5       2     
</strong></code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

* <mark style="color:yellow;">**主要key:  build column**</mark> => start with the root at column 0. Then, for each node, we will&#x20;
  * assign column -1 to its left child&#x20;
  * assign column +1 to its right child.&#x20;
  * This way, all nodes in the same column will get the same column number.
* from <mark style="color:yellow;">**top to bottom**</mark>, <mark style="color:yellow;">**column by column, left to right**</mark><mark style="color:yellow;">.</mark>  <mark style="color:yellow;"></mark><mark style="color:yellow;">**=>**</mark>** **<mark style="color:red;">**BFS**</mark>

</details>

<details>

<summary>Algorithm </summary>

1.  **Understanding the problem:**

    We need to assign a column number to each node. We can start with the root at column 0. Then, for each node, we will assign column -1 to its left child and column +1 to its right child. This way, all nodes in the same column will get the same column number. Each column in the output corresponds to a unique column number, and the nodes in each column are listed in the order from top to bottom.
2. **Building an intuition:**
   1. We can use a BFS to traverse the tree level by level. BFS allows us to visit the nodes in order from top to bottom, and within each level from left to right.
   2. <mark style="color:yellow;">**BFS using queue**</mark>: Instead of just enqueuing the node itself, we can <mark style="color:red;">**enqueue a pair that contains the node and its column number.**</mark>\ <mark style="color:red;">**如果不想enqueue  a pair可以形成两个queue**</mark>
   3. <mark style="color:yellow;">**HashMap**</mark>**:** We can use a <mark style="color:red;">**map**</mark> to store the nodes in each column. The key in the Hashmap is the column number, and the value is a list of nodes in that column. TreeMap ensures that the columns are sorted by their column numbers.\
      \- key: column number\
      \- value: List\<TreeNode> : the node in the column\
      但是采用的code是用一个helper method先形成resultList的structure我觉得更好理解

</details>

<details>

<summary>✅ Code:  DFS &#x26; BFS Strategy  with Column Index Calculation</summary>

```java
关键点：helper method
想到找到column index的范围，然后形成resultList的大小，可以计算出index的指数
同时要想到adjust这个colIndex的大小，不能是negative

class Solution {
    private int min = 0;
    private int max = 0;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        
        // call helper function to update the min and max
        computeColRange(root, 0);
        int columnSize = max - min + 1;
        for (int i = 0; i < columnSize; i++) {
            List<Integer> subList = new ArrayList<>();
            resultList.add(subList);  // form the structure of the resultList
        }
        
        // initiate two queues for tracking the nodes and col index
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<TreeNode> colQueue = new LinkedList<>();
        
        // 处理的当前node
        nodeQueue.add(root);
        colQueue.add(-min); // adjust the column index to all postive number
        
        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            int colIdx = colQueue.poll();
            // Add the node's value to the corresponding column's list
            resultList.get(colIdx).add(currNode.val);
            
            // If the left child exists, enqueue it and its column index
            if (currNode.left != null) {
                nodeQueue.add(root.left);
                colQueue.add(colIdx - 1);
            }
            if (currNode.right != null) {
                nodeQueue.add(root.right);
                colQueue.add(colIdx + 1);
            }
        }
        return resultList; 
    }
    
    // Helper method to find the range of columns
    private void computeColRange(TreeNode root, int idx) {
        if (root == null) return; // termination condition
        min = Math.min(min, idx); // 处理当前node => update the range
        max = Math.max(max, idx); 
        computeColRange(root.left, idx - 1);
        computeColRange(root.right, idx + 1);
    }
}
```

<mark style="background-color:orange;">**Helper Method:**</mark> <mark style="color:yellow;">**computeColRange**</mark>() - <mark style="color:red;">**DFS**</mark>

* A recursive function that uses DFS to traverse the tree and determine the minimum and maximum column indices. It's used to figure out how many columns will be in the final output.

```java
private int min = 0, max = 0;
private void computeColRange(TreeNode root, int idx){
    if(root == null) return;
    min = Math.min(min, idx);
    max = Math.max(max, idx);
    computeColRange(root.left, idx - 1); // compute range for the left subtree
    computeColRange(root.right, idx + 1); // compute range for the right subtree
}
```

* Visualization of the helper method

<pre class="language-sql"><code class="lang-sql">        1(0)
     /      \
    2(-1)    3(1)    => range [-2, 2] // length = 5
  /   \     /   \    =>  main list looks like [[], [], [], [], []] before the BFS.
<strong>4(-2) 5(0) 6(0) 7(2)
</strong><strong>
</strong>- At the root (1), the index is 0. So, min = max = 0.
- Goes left to node 2:  idx = -1. So, min = -1, max = 0.
- Goes left to node 4. idx = -2. So, min = -2, max = 0.
It cannot go further left.
- Goes right from 4 to 5. idx = 0. min = -2, max = 0.
Finishing the left subtree of the root. 
- Goes to the right subtree to node 3: idx = 1. min = -2, max = 1.
- Goes left to node 6. idx=  0. min = -2, max = 1.
It can't go further left
- Goes from 6 to 7. idx = 2 (back to 1 at 3 and then +1 at 7). min = -2, max = 2.
</code></pre>

*   Adjust the column indices

    * After running the `computeRange` function, `min` is -2 and `max` is 2. But when we create lists for each column, the index of the list starts from 0, and <mark style="color:red;">**we can't use negative numbers as list indices.**</mark>
    * So, we adjust the column indices by `-min` (which is 2 in this case), effectively shifting the column indices so that they start from 0:

    <pre><code>        1(2)
         /      \
        2(1)    3(3)    => range [0, 4] // length = 5
      /   \     /   \   
    <strong>4(0) 5(2) 6(2) 7(4)
    </strong></code></pre>



Algorithm

1. **Initialize min and max variables**: These variables are used to keep track of the minimum and maximum column indices in the tree, which are computed in the `computeColRange` method.
2. **Define the verticalOrder method**: This is the main function that performs the vertical order traversal. It takes the root of the binary tree as input and returns a list of integer lists, where each sublist represents a column of nodes in the tree.
3. **Compute the column range**: `computeColRange` is a recursive function that traverses the tree to find the minimum and maximum column indices. It's initially called with the root node and column index 0.
4. **Initialize the result list**: Create a list of empty lists for each column in the tree. The number of columns is the difference between the maximum and minimum column indices plus 1.
5. **Initialize node and column queues**: These queues are used to perform a breadth-first traversal of the tree. Each node in the tree is enqueued along with its corresponding column index.
6. **Perform the breadth-first traversal**: While the node queue is not empty, dequeue a node and its column index, add the node's value to the appropriate column in the result list, and enqueue its left and right children (if they exist) along with their corresponding column indices.
7. **Return the result list**: After all nodes have been processed, return the result list, which contains the node values in vertical order.

The time complexity of this algorithm is O(N), where N is the total number of nodes in the binary tree. This is because each node is visited exactly once during the breadth-first traversal. The helper function `computeColRange` also visits each node once, so its time complexity is also O(N), but we consider this as a part of the total complexity. Hence, the overall time complexity remains O(N).

The space complexity of the algorithm is also O(N). The primary space consumption comes from the queue used for the breadth-first traversal and the list used to store the result. In the worst case, if the tree is completely unbalanced, e.g., each node has only left child node or only right child node, the breadth-first traversal queue will contain all the nodes in one level of the binary tree. The maximum number of nodes on one level can be N (in the case of a skewed tree), so the space complexity due to the queue is O(N).

The result list will contain N elements in total (since it will eventually contain all the nodes of the tree), which also contributes O(N) to the space complexity. Therefore, the total space complexity is O(N) + O(N) = O(N). Remember, we drop constants in Big O notation, so we don't count the "2" in "2N".

</details>

<details>

<summary>Code: Using a Pair</summary>

```java
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        int column = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<>());
                }
                columnTable.get(column).add(root.val);

                queue.offer(new Pair<>(root.left, column - 1));
                queue.offer(new Pair<>(root.right, column + 1));
            }
        }

        List<Integer> sortedKeys = new ArrayList<>(columnTable.keySet());
        Collections.sort(sortedKeys);
        List<List<Integer>> result = new ArrayList<>();
        for (int k : sortedKeys) {
            result.add(columnTable.get(k));
        }

        return result;
    }
}java
```

</details>
