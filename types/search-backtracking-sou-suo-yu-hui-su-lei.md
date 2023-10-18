# ▫ Search & BackTracking

### 理解backtracking

1. Backtracking解决的问题都可以<mark style="color:yellow;">**抽象为TREE结构**</mark>, 因为其解决的问题都是<mark style="color:red;">**在Set中寻找Subset**</mark>
   1. <mark style="background-color:purple;">**Tree Structure in Backtracking**</mark><mark style="background-color:purple;">:</mark> Backtracking problems can generally be <mark style="color:yellow;">**thought of as a traversal over a tree structure**</mark>, where each node of the tree represents a partial solution. The tree is a "decision tree" where each level represents a decision point.
   2. <mark style="background-color:purple;">**Searching for Subsets in a Set**</mark>: Many backtracking problems involve searching for all subsets of a certain set that satisfy some condition. For example, in the classic "eight queens" problem, the set is all possible positions for queens on a chess board, and the condition is that no two queens threaten each other.
2. Set的size组成了tree的width, recursion的深度构成了tree的深度

```
                        {} 
                /       |       \
             {1}       {2}       {3}
           /   \       |
        {1,2} {1,3}   {2,3}
        /       
     {1,2,3}  
```

On each level of the tree, we decide whether to include a number in our subset. The root of the tree represents the empty set. On the first level, we decide whether to include `1`. If we include `1`, we get `{1}`; if we don't include `1`, we move on to decide whether to include `2`, and so forth.

Each path from the root to a leaf node represents a distinct subset of the original set. The leaf nodes of the tree are all possible subsets of the original set.

The width of the tree is determined by the size of the set (in this case `3`), and the depth of the tree (in this case also `3`) is determined by how many decisions we need to make while constructing a subset, which is equivalent to the size of the set.

### 解决的问题类型

* subset子集问题：在一个N个元素的Set中有多少符合条件的subset
* combination组合问题: 如何按照一定条件在N个数中找出k个数的集合
  * n mathematics, a combination is a selection of items from a larger set where the order of selection does not matter (unlike permutations).
* permutation排列问题：N个数按照一定条件进行permutation, 共有几种排列方式
* 棋盘问题
* 切割问题

### BackTracking的模板

```java
// BackTracking的模板
void backtracking(参数){
    if (termination conditon) {
        store result;
        return;
    }
    
    for (选择：本层的元素（tree中node的child数量就是set的大小）) {
        处理node;
        backtracking(路径， 选择列表) // recursion
        回溯，撤销处理结果
    }
}
// 英文
void backtracking(Parameters){
    if (termination condition) {
        store result;
        return;
    }
    
    for (Choice : Choices in the current set (the number of children of a node in the tree is the size of the set)) {
        process the node;
        backtracking(Path, Choice List) // recursion
        backtrack, undo the processing result
    }
}
```
