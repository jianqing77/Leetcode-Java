# 101 - Symmetric Tree

<details>

<summary>Description 题目描述 </summary>

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

```c
    1
   / \
  2   2      => symmetric
 / \ / \
3  4 4  3
```

```c
    1
   / \
  2   2      => NOT symmetric
   \   \
   3    3
```

Note:

Bonus points if you could solve it both recursively and iteratively.

</details>

<details>

<summary>解题思路 Intuition </summary>

### 题目大意

这一题要求判断 2 颗树是否是左右对称的。

### 解题思路

* Symmetric: 是不是invert 左右两个sub tree之后 判断是否相等呢? 应该不是，因为example 2里边就不是

<!---->

* 这道题是几道题的综合题。将根节点的左字数反转二叉树，然后再和根节点的右节点进行比较，是否完全相等。
* 反转二叉树是第 226 题。判断 2 颗树是否完全相等是第 100 题。

</details>

<details>

<summary>Algorithm </summary>





</details>

<details>

<summary>Code Demo </summary>

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
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
