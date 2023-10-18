# ▫ Recursion 递归类

递归算法的三个要素：

1. **Determine the **<mark style="color:yellow;">**parameters**</mark>** and **<mark style="color:yellow;">**return values**</mark>** of the recursive function**
   1. 确定哪些参数在recursion过程中需要处理 => 把这些参数加入recursive function
   2. 确定recursion的return值是什么 => 进而确定recursive function 的return type
2. **Determine the **<mark style="color:yellow;">**termination condition**</mark>&#x20;
   1. 经常遇到Stack Overflow栈溢出的问题 => termination的终止条件写的不对
   2. 如果没有明确的终止条件或者终止条件设置得不正确，递归可能会进入无限循环。
3. **Determine the **<mark style="color:yellow;">**logic of the single-layer recursion**</mark>
   1. **确定每层recursion需要处理的信息，在这里会重复调用函数本身来实现递归的过程：**defines the operations to be carried out at each level of recursion
   2. It typically involves <mark style="color:blue;">assuming that the sub-problems have been solved, and then figuring out how to use the solutions to these sub-problems to solve the original problem</mark>. 在这一步中，一般需要通过使用一些数学归纳的思想，**假设子问题已经被解决，然后思考如何利用子问题的解来找出原问题的解。**

<table data-full-width="true"><thead><tr><th width="241">Type</th><th width="527.3333333333333">Logic</th><th>Problem</th></tr></thead><tbody><tr><td><strong>Linked List</strong></td><td>especially when <br>- merging two linked list -- 0021<br>- reversing a linked list,<br>- finding or deleting specific elements, etc.</td><td>0021</td></tr><tr><td><strong>Binary Tree</strong></td><td><p>Many tree-related problems can be solved via recursion, as trees are naturally recursive structures. Examples include Depth-First Search (DFS) and Breadth-First Search (BFS) algorithms.</p><ol><li>Singly layer logic for the curret treeNode</li><li>Recursion的实现: left and right subtree</li><li>termination condition: <br>- node == null<br>- node.left == null &#x26;&#x26; node.right == null => left node</li></ol></td><td></td></tr><tr><td><strong>Graphs</strong></td><td>Graph-related problems often use recursion, especially when implementing Depth-First Search (DFS).</td><td></td></tr><tr><td><strong>Divide and Conquer</strong></td><td>Divide and Conquer is a design strategy that breaks a problem down into multiple smaller, similar subproblems, applying the same strategy to each subproblem. Recursion is key to implementing this strategy.</td><td></td></tr><tr><td><strong>Backtracking</strong></td><td>Backtracking is a trial-and-error strategy used for solving search problems like the eight queens problem, graph coloring, generating all possible subsets, etc. Recursion is commonly used in the implementation of backtracking algorithms.</td><td></td></tr><tr><td><strong>Dynamic Programming</strong></td><td>While dynamic programming problems can often be solved iteratively, some dynamic programming problems can be solved using memoized recursion, especially when dealing with overlapping subproblems.</td><td></td></tr></tbody></table>

