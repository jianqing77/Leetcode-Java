---
description: '#Tree #DFS #BFS #Binary Tree #HashMap'
---

# 🟠 0863 - All Nodes Distance K in Binary Tree

<details>

<summary>Description 题目描述 </summary>

Given the `root` of a binary tree, the value of a target node `target`, and an integer `k`, return _an array of the values of all nodes that have a distance_ `k` _from the target node._

You can return the answer in **any order**.

```sql
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.
```

![](<../../.gitbook/assets/image (1) (1).png>)

**Constraints:**

* The number of nodes in the tree is in the range `[1, 500]`.
* `0 <= Node.val <= 500`
* All the values `Node.val` are **unique**.
* `target` is the value of one of the nodes in the tree.
* `0 <= k <= 1000`

</details>

需要多体会

<details>

<summary>解题思路 Intuition </summary>

1. **Understanding the problem**: The first step is understanding the problem. In this case, you're asked to find all nodes that are a certain distance `k` from a target node in a binary tree. This suggests a traversal or search problem, where you're looking to explore the tree in some way.
2. **Knowing your algorithms**: DFS and BFS are two of the most common algorithms used for traversing trees or graphs.&#x20;
   1. DFS explores as far as possible along each branch before backtracking. It's particularly useful when you want to go deep into the tree (for example, finding leaves or paths).&#x20;
   2. BFS explores all the neighbors at the present depth before moving on to nodes at the next depth level. It's especially useful for finding the shortest path or just exploring the immediate neighbors in stages.
3. **Connecting the problem to the algorithms**: <mark style="color:yellow;">**In this problem, you first need to find the target node and then explore all nodes a distance**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`k`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**away from it.**</mark> This can be thought of as a two-step process:&#x20;
   1. <mark style="color:yellow;">**traverse the tree to find the target node and build a graph**</mark> <mark style="color:red;">DFS can do this efficiently</mark>: DFS is efficient for this task because it explores all the way down each path. In the process of traversing, <mark style="color:blue;">**we're not only just searching for the target node, but also building a graph representation of the tree where each node has a reference to its parent and children.**</mark> This is done by starting from the root node and exploring each node's children (i.e., going deeper into the tree) before backtracking. This depth-first approach is very suitable for this process as we want to ensure we explore every branch of the tree and build complete connections.
   2. <mark style="color:blue;">**once you have the target node, explore all nodes a distance**</mark><mark style="color:blue;">** **</mark><mark style="color:blue;">**`k`**</mark><mark style="color:blue;">** **</mark><mark style="color:blue;">**from it**</mark> <mark style="color:red;">(BFS is perfect for this,</mark> since it explores nodes in stages, "levels" which correspond to distances from the starting node). Once you have found the target node and built the graph, you want to find all nodes that are a distance `k` from the target node. If you think about the problem visually, imagine starting at the target node and drawing rings around it, where each ring represents nodes that are a certain distance away from the target node. <mark style="color:blue;">BFS is perfect for this because it explores all neighbors at the current level before moving on to the next level.</mark> We start the BFS from the target node, and each level of the BFS corresponds to one "ring". When we reach the `k`th level, those nodes are the ones that are at a distance `k` from the target node.
4. **The nature of the tree**: <mark style="color:yellow;">**Binary trees do not have a built-in reference to their parent nodes, only to their children.**</mark> However, in this problem, you need to be able to traverse upwards as well as downwards from the target node. This suggests that you need to convert the tree into a bidirectional graph, which again points to using DFS.

</details>

<details>

<summary>Algorithm </summary>

Combine DFS and BFS

1. **Initial Setup**: \
   \-  a HashMap `nodeMap` to hold each node and its neighbors, \
   \- a List `result` to hold the nodes at distance K, \
   \- a HashSet `visited` to keep track of nodes that have been visited.
2. **Build Node Map**: Call the <mark style="color:yellow;">**`buildNodeMap`**</mark> method with the root node and null as the parent. This method will use <mark style="color:orange;">**DFS**</mark> to traverse the tree and build the node map.
   * If the current node (`child`) is null, return.
     * If `nodeMap` does not contain the current node, add it.
     * If the parent node is not null, add it as a neighbor of the current node, and the current node as a neighbor of the parent.
     * Recursively call **`buildNodeMap`** on the left and right children of the current node.
3. **Breadth-First Search (BFS)**: Call the <mark style="color:yellow;">**findNodesAtDistanceK**</mark> method with the target node and K. This method will perform <mark style="color:orange;">**BFS**</mark> to find all nodes at distance K from the target node.
   * Initialize a queue with the target node and add the target node to the `visited` set.
   * Initialize a **distance** variable to track the current distance from the target node.
   * While the queue is not empty:
     * If the current distance is equal to K, add all nodes in the current level (same distance from the target) to `result` and return.
     * For each node at the current distance:
       * Remove it from the queue.
       * For each unvisited neighbor of this node, add it to the `visited` set and the queue.
     * Increment `distance` by 1.

<mark style="color:yellow;">**Q: why build a node map?**</mark>

* Build the node map used DFS and recursion
* The node map is a hashmap where\
  \-  key: node \
  \- value: a list of its neighbors node.&#x20;
* The neighbors of a node include its parent and children. This makes it easier to traverse the graph in the BFS step,  as each node's neighbors can be quickly looked up in the nodeMap.

```
       3
     /   \
    5     1
  /  \   / \
 6    2 0   8
    /  \
   7    4

Graph (nodeMap):
3: [5, 1]
5: [3, 6, 2]
1: [3, 0, 8]
6: [5]
2: [5, 7, 4]
0: [1]
8: [1]
7: [2]
4: [2]
```

**Step 1: Initialize**

Set up the queue, visited set, and distance. The target node (5) is added to the queue and the visited set.

Queue: \[5]\
Visited: {5}\
Distance: 0

**Step 2: BFS**

Begin the BFS. Since the queue is not empty, enter the while loop. The distance is not yet equal to K (2), so skip the first if statement.

**Step 3: Process Nodes at Distance 0**

Get the size of the queue (1). For each node in the queue, remove it and add its neighbors to the queue if they haven't been visited.

Queue: \[3, 2, 6] (neighbors of 5)\
Visited: {5, 3, 2, 6}\
Distance: 1

**Step 4: Process Nodes at Distance 1**

Increment distance. The distance is not yet equal to K, so continue processing nodes. Get the size of the queue (2). For each node in the queue, remove it and add its neighbors to the queue if they haven't been visited.

Queue: \[1, 4, 7] \
Visited: {5, 3, 2, 6, 1, 4, 7}\
Distance: 2

**Step 5: Process Nodes at Distance 2**

Increment distance. The distance is now equal to K. For each node in the queue, remove it and add its value to the result list.

Queue: \[]\
Visited: {5, 3, 2, 6, 1, 4, 7}\
Result: \[1, 4, 7]\
Distance: 2

</details>

<details>

<summary>✅ Code Demo </summary>

```java
class Solution {
    Map<TreeNode, List<TreeNode>> nodeMap = new HashMap<>();
    List<Integer> resultList = new ArrayList<>();
    Set<TreeNode> visitedNodes = new HashSet<>();
        
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildNodeMap(null, root);
        findNodesAtDistanceK(target, K);
        return result;
    }
    
    // Helper method: build and update nodeMap using recursion and dfs
    // where the key is the node itself, the value is a list of the node's neighbor nodes
    // Params: parent -> the parent of the node
    private void buildNodeMap(TreeNode parent, TreeNode child) {
        if (child == null)  return;
        if (!nodeMap.containsKey(child)) {
            nodeMap.put(child, new ArrayList<>());
            if (parent != null) {
                nodeMap.get(child).add(parent); // add to both list
                nodeMap.get(parent).add(child);  // child and parent are both not null
            }
            buildNodeMap(child, child.left);
            buildNodeMap(child, child.right);
        }
    }
    
    // helper method to use bfs to find and update the resultList
    // which include all the node's value around taget with distance k
    private void findNodesAtDistanceK(TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visitedNodes.add(target);
        int distance = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == k) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    resultList.add(node);
                }
                return;
            }
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode neighbor : nodeMap.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }
    }
    
    
}
```

with comments:

```java
class Solution {
    // nodeMap stores each node and its neighbors (both parent and children)
    Map<TreeNode, List<TreeNode>> nodeMap = new HashMap<>();

    // resultList will store all nodes at distance K from the target node
    List<Integer> resultList = new ArrayList<>();

    // visitedNodes helps to avoid processing the same node twice
    Set<TreeNode> visitedNodes = new HashSet<>();
        
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // DFS to build nodeMap
        buildNodeMap(null, root);
        
        // BFS to find all nodes at distance K from target and store their values in resultList
        findNodesAtDistanceK(target, k);
        
        return resultList;
    }
    
    // DFS traversal to build nodeMap
    private void buildNodeMap(TreeNode parent, TreeNode child) {
        if (child == null) return;
        if (!nodeMap.containsKey(child)) {
            // initialize the list of neighbors for the child node
            nodeMap.put(child, new ArrayList<>());
            
            if (parent != null) {
                // add parent to the child's neighbor list and vice versa
                nodeMap.get(child).add(parent);
                nodeMap.get(parent).add(child);
            }
            
            // recursive calls to process the left and right children
            buildNodeMap(child, child.left);
            buildNodeMap(child, child.right);
        }
    }
    
    // BFS traversal to find all nodes at distance K from the target node
    private void findNodesAtDistanceK(TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visitedNodes.add(target);
        int distance = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == k) {
                // we've reached the nodes at distance K, so add them to the result list
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    resultList.add(node.val);
                }
                return;
            }
            
            // for all other nodes at the current distance, add their unvisited neighbors to the queue
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode neighbor : nodeMap.get(node)) {
                    if (!visitedNodes.contains(neighbor)) {
                        visitedNodes.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            // increment the distance as we're moving to the next level in the BFS
            distance++;
        }
    }
}
```

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>✅心得 Key Points</summary>

1. 需要多体会
2. 很多地方是自己想不到的，比如结合bfs和dfs，比如建立visited set, 比如建立hashmap to build a nodeMap
3. bfs + dfs + hashMap + recursion + hashSet&#x20;

</details>
