# 🟢 0100 - Same Tree

注意是两个tree node 作为parameter

<details>

<summary>Description 题目描述 </summary>

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

```c
           1         1
          / \       / \
         2   3     2   3      => same tree

        [1,2,3],   [1,2,3]

```

```c
           1         1
          /           \
         2             2     => NOT same tree

        [1,2],     [1,null,2]
```

```c
           1         1
          / \       / \
         2   1     1   2   => invert tree

        [1,2,1],   [1,1,2]
```

</details>

<details>

<summary>解题思路 Intuition </summary>

Intuition:&#x20;

* 方法1： recursion: 如果目前p.val == q.val && p.所有SubTree和q.所有subTree都相等
* 方法2：想用traversal的方法来获得两个tree的所有node,作为一个collection(linked list/ arraylist), 对比一下就知道是否相等，这种办法怎么写？和recursion对比起来如何

</details>

<details>

<summary>✅ Algorithm : Recursion</summary>

* <mark style="color:yellow;">**Logic of singly layer condition: => 想错了**</mark> \
  对比当前p.val 和q.val是否相等 => 注意这里code demo写的是不相等，return false;
* <mark style="color:yellow;">**Recursion的体现：**</mark>对比each node的left sub-tree 和right sub-tree是否相等
* <mark style="color:yellow;">**termination condition:**</mark>**   **<mark style="color:red;">**=>卡**</mark>
  * <pre class="language-java"><code class="lang-java"><strong>        // Termination Condition 
    </strong>        if (p == null &#x26;&#x26; q == null) { // 两个node都是null
                return true;
            }
            if (p == null || q == null) { // 期中一个是null
                return false;
            }
    </code></pre>

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 3. Termination Condition 
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        // ----- Recursion -----
        // 1. Singly layer logic: 对比当前的
        if (p.val != q.val) {
            return false;
        }
        
        // 2.Recursion的实现
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```



</details>

<details>

<summary>Algorithm: Traversal &#x26; form a List -- DFS  也好理解其实</summary>

<mark style="color:yellow;">**DFS: preorder/inorder/postorder**</mark>

* 注意这里termination condition of pre-order: 如果node = null, 要加入null
* 注意pre-order helper里加了一个parameter value为了实现singly layer logic
* 对比两个list是否完全相等 list1.equals(list2)

```java
// preorder
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> valueOfP = new ArrayList<>();
        List<Integer> valueOfQ = new ArrayList<>();
        
        preOrder(p, valueOfP);
        preOrder(q, valueOfQ);
        
        return valueOfP.equals(valueOfQ);
    }
    
    private void preOrder(TreeNode p, List<Integer> values) {
        // 3. termination condition: 
        if (p == null) {
            values.add(null)
            return;
        }
        
        // ----- Recursion ----- 
        // 1. singly layer logic
        values.add(p.val);
        
        // 2. recursion的实现
        preOrder(p.left);
        preOrder(p.right);
    }

}

```

</details>

<details>

<summary>Algorithm: Traversal &#x26; form a list -- BFS  讨厌写BFS但是这个要熟练</summary>

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> valuesP = valuesOfTree(p);
        List<Integer> valuesQ = valuesOfTree(q);
        
        return valuesP.equals(valuesQ);
    }

    private List<Integer> valuesOfTree(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
        
            TreeNode currNode = queue.poll();
            
            if (currNode == null) {
                resultList.add(null);
                continue;
            }
            
            resultList.add(currNode.val);
            queue.offer(currNode.left);
            queue.offer(currNode.right);
        }
        
        return values;
    }
}
```

</details>

<details>

<summary>Code Analysis</summary>

**Time Complexity:**

* The function will traverse every node in both trees, therefore, the time complexity is O(N), where N is the number of nodes in the trees.
* Each call of `isSameTree` checks if the current pair of nodes are equal, then recursively calls itself on the pairs of left and right children.

**Space Complexity:**

* The worst-case space complexity is also O(N) because in a skewed tree (a tree where each node only has one child), the maximum depth of the recursive call stack will be N.

</details>

<details>

<summary><mark style="color:red;">心得 Key Points</mark></summary>

1. 自己有思路了，而且是对的，但是要把自己的思路一点一点的考虑清楚
2. 很多都是之前基本题的变形，要熟识没一个binary tree的基本题
   1. DFS: pre, in, post order的recursion写法
   2. BFS: 写法
   3. Max /min depth的写法
3. Recursion的时候渐渐形成了自己的三要素
   1. singly layer logic：考虑本node
   2. recursion的实现：考虑left and right subtree
   3. termination condition

</details>
