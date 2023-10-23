---
description: '@Binary Tree @Queue @Doubly Linked List'
---

# 🟠 0102 - Binary Tree Level Order Traversal

<details>

<summary>Description 题目描述 </summary>

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example: Given binary tree \[3,9,20,null,null,15,7],

```c
    3
   / \
  9  20
    /  \
   15   7
```

return its level order traversal as:

```c
[
  [3],
  [9,20],
  [15,7]
]
```

</details>

<details>

<summary>Algorithm 解题思路 </summary>

### 题目大意

按层序从上到下遍历一颗树。

### 解题思路

用一个队列queue即可实现。

</details>

<details>

<summary>Code Demo </summary>

**algo总结**

* Create an empty queue and <mark style="color:yellow;">**enqueue the root node.**</mark>
* <mark style="color:yellow;">**WHILE the queue is not empty**</mark>, do the following:
  * Determine the <mark style="color:yellow;">**current level size**</mark> (i.e., number of nodes in the queue).
  * FOR each node in the current level&#x20;
    * Dequeue the node from the queue.
    * Add the value of the node to the current level's list of values (SublevelList).
    * If the node has a left child, enqueue the left child.
    * If the node has a right child, enqueue the right child.
  * Add the current level's list of values to the list of all levels.

<mark style="color:yellow;">**注意的点**</mark>**：**

* While loop + For loop
* 如果root是null, return的是empty list NOT NULL
  * \=>最开始要initiate <mark style="color:orange;">**result NESTED list**</mark>** => new LinkedList<>()**
  * <mark style="color:orange;">**这道题用 linked list 或者是 array list作为result list的类型无差别**</mark>
* 不同的type of queue和result nested list
  * <mark style="color:purple;">**queue**</mark>的element type: <mark style="color:purple;">**TreeNode**</mark>
  * <mark style="color:purple;">**result**</mark> nested list: Integer => retrieve the <mark style="color:purple;">**val of the TreeNode**</mark>
* <mark style="color:orange;">**注意queue的initiation: 必须用linked list 并且是doubly linked list**</mark>&#x20;
  * **=> 因为要**有<mark style="color:purple;">**currNode.left**</mark> &**&** <mark style="color:purple;">**currNode.right**</mark>&#x20;
* 注意这里用的<mark style="color:purple;">**linked list的JDK initiation**</mark>: List\<Integer>[^1] linkedList = new LinkedList<>();
* 注意queue的一些methods:&#x20;
  * enqueue: queue.<mark style="color:purple;">**add()**</mark>
  * dequeue: queue<mark style="color:purple;">**.poll()**</mark>
  * 由于queue是linked list -> <mark style="color:red;">list => 没有length这个方法</mark>
    * 检查queue是否是empty时用queue.isEmpty()
    * get queue的元素个数：<mark style="color:yellow;">用queue.size()</mark>

<pre class="language-java"><code class="lang-java">class Solution {
    public List&#x3C;List&#x3C;<a data-footnote-ref href="#user-content-fn-2">Integer</a>>> levelOrder(TreeNode root) {
        List&#x3C;List&#x3C;Integer>> resultList = new <a data-footnote-ref href="#user-content-fn-3">LinkedList&#x3C;>();</a>
        if (root == null) {
            return <a data-footnote-ref href="#user-content-fn-4">resultList</a>;
        }
        // Step 1: Create an empty queue and enqueue the root node.
        Queue&#x3C;<a data-footnote-ref href="#user-content-fn-5">TreeNode</a>> queue = new <a data-footnote-ref href="#user-content-fn-6">LinkedList&#x3C;>();</a> //卡：queue的initiatiion
        queue.add(root);
        
        // Step 2: WHILE the queue is not empty
        while (!<a data-footnote-ref href="#user-content-fn-7">queue.isEmpty()</a>) { // 卡：queue是否empty用isEmpty()
            // 2.1 Determine the current level size (i.e., number of nodes in the queue)
            int levelSize = queue.size(); // 卡：queue的element个数用size()
            // 2.2 create a sub level empty list to store the dequeued node
            // iterate through each node of that level 
            // dequeue each node from the queue while return the dequeued node, 
            // and add the dequeued node to a sublist
            // If the node has a left child, enqueue the left child.
            // If the node has a right child, enqueue the right child.
            List&#x3C;Integer> subLevelList = new LinkedList&#x3C;>();
            for (int i=0; i&#x3C;levelSize; i++) {
                TreeNode currNode = <a data-footnote-ref href="#user-content-fn-8">queue.poll();</a>
                subLevelList.add(currNode.<a data-footnote-ref href="#user-content-fn-9">val</a>); //卡：sublist的element type是integer,要get its value not the node
                if (currNode.left != null) {
                    queue.add(<a data-footnote-ref href="#user-content-fn-10">currNode.left</a>);
                }
                if (currNode.right != null) {
                    queue.add(<a data-footnote-ref href="#user-content-fn-11">currNode.right</a>);
                }
            }
            resultList.add(subLevelList); //每个level要在for loop结束后add到resultList中
        }
        return resultList;
    }
}
</code></pre>

</details>

<details>

<summary>Code Analysis</summary>

Time Complexity:

* The outer while loop will execute in O(N) time where N is the total number of nodes in the tree because each node is dequeued exactly once.
* The inner for loop will execute in O(1) time for each node because it just adds the node's value to a list and adds its children to the queue.
* Therefore, the overall time complexity is O(N), where N is the total number of nodes in the tree.

Space Complexity:

* The worst-case space complexity is O(N). This can occur when the tree is a perfect binary tree and the last level has N/2 nodes. In this case, the queue will store N/2 nodes at most, and thus the space complexity is O(N).

</details>

<details>

<summary>Key Points</summary>

1. algorithm的理解
2. 写code时候很多小点

</details>

[^1]: 

[^2]: <mark style="color:purple;">**result**</mark> nested list: Integer => retrieve the <mark style="color:purple;">**val of the TreeNode**</mark>

[^3]: <mark style="color:orange;">**这道题用 linked list 或者是 array list作为result list的类型无差别**</mark>

[^4]: 如果root是null, return的是empty list NOT NULL

[^5]: <mark style="color:purple;">**queue**</mark>的element type: <mark style="color:purple;">**TreeNode**</mark>&#x20;

[^6]: <mark style="color:orange;">**注意queue的initiation: 必须用linked list 并且是doubly linked list**</mark>&#x20;

[^7]: queue是linkedlist(LIST)检查queue是否是empty时用queue.isEmpty()

[^8]: dequeue: queue<mark style="color:purple;">**.poll()**</mark>

[^9]: <mark style="color:purple;">**result**</mark> nested list: Integer => retrieve the <mark style="color:purple;">**val of the TreeNode**</mark>

[^10]: <mark style="color:orange;">**doubly linked list**</mark>&#x20;

[^11]: <mark style="color:orange;">**doubly linked list**</mark>&#x20;
