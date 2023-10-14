---
description: '@Array @Binary Search'
---

# 🟠 0033 - Search in Rotated Sorted Array

<details>

<summary>Description 题目描述 </summary>

There is an integer array `nums` <mark style="color:orange;">**sorted**</mark> in ascending order (with <mark style="color:orange;">**distinct**</mark> values).

Prior to being passed to your function, `nums` is **possibly rotated** at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (**0-indexed**). For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index `3` and become `[4,5,6,7,0,1,2]`.

Given the array `nums` **after** the possible rotation and an integer `target`, return _the index of_ `target` _if it is in_ `nums`_, or_ `-1` _if it is not in_ `nums`.

You must write an algorithm with O(log n) runtime complexity.

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

</details>

<details>

<summary>Algorithm 解题思路 </summary>

***

题目大意：&#x20;

假设按照升序排序的数组在<mark style="color:yellow;">**预先未知的某个点上进行了旋转**</mark>。( 例如，数组 \[0,1,2,4,5,6,7] 可能变为 \[4,5,6,7,0,1,2] )。搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。你可以假设数组中不存在重复的元素。你的算法时间复杂度必须是 O(log n) 级别。

***

Binary Search的条件:

* [ ] <mark style="color:red;">**是递增有序的 sorted  => 不是sorted的因为在某处进行了rotate**</mark>
* [x] 有边界的 search space is defined
* [x] 可以用下标访问的 could get with index

<mark style="background-color:yellow;">**突破点：**</mark>

每次我们选择中点 `mid` 后，都可以把原始数组分为两个子数组。\
1\. `nums[start]` 到 `nums[mid]`，\
2\. `nums[mid]` 到 `nums[end]`。\
&#x20;<mark style="color:yellow;">**重要的是，至少有一个子数组是有序的。**</mark>这是因为，旋转点<mark style="color:yellow;">**最多只能在其中一个子数组中**</mark>，也就是说，另一个子数组必定是有序的。我们可以利用这个<mark style="color:yellow;">有序的subarray来判断目标值</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`target`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">应该在哪个subarray中查找。</mark>

<mark style="background-color:yellow;">解题思路</mark>：

1. **初始化**：首先，我们初始化两个指针，`left` 和 `right`，分别指向数组的开始和结束。
2. **找到中点**：然后，在 while 循环中，我们找到 `left` 和 `right` 的中点 `mid`。
3. **比较中点和目标值**：
   * 如果 `nums[mid]` 等于 `target`，我们找到了目标值，返回 `mid`。
   * 如果 `nums[mid]` 不等于 `target`，我们需要在子数组中查找 `target`。
4. <mark style="color:yellow;">**确定在哪个子数组中查找目标值**</mark><mark style="color:yellow;">：</mark>
   * 如果 `nums[left] <= nums[mid]`，那么 `left` 到 `mid` 是一个有序数组。
     * 如果 `target >= nums[left]` 并且 `target < nums[mid]`，那么 `target` 在左侧的有序子数组中，我们应将 `right` 设置为 `mid - 1`。
     * 否则，`target` 在右侧的子数组中，我们应将 `left` 设置为 `mid + 1`。
   * 如果 `nums[mid] <= nums[right]`，那么 `mid` 到 `right` 是一个有序数组。
     * 如果 `target > nums[mid]` 并且 `target <= nums[right]`，那么 `target` 在右侧的有序子数组中，我们应将 `left` 设置为 `mid + 1`。
     * 否则，`target` 在左侧的子数组中，我们应将 `right` 设置为 `mid - 1`。
5. **重复步骤 2-4**：我们继续这个过程，直到找到 `target` 或者 `left` 大于 `right`。
6. **未找到目标值**：如果我们没有找到 `target`，我们返回 `-1`。

```
总之在while循环里
step0: 判断left<right还是left<=right => 因为我们是要 find exact same value,而且是每个num是unique的，所以用left<=right
step1: 找出哪边是sorted array 然后divide to 2 sub arrays
step2: 判断在sorted还是非sorted array搜索
```



</details>

<details>

<summary>Code Demo </summary>

<mark style="background-color:orange;">**心得：举一些特殊的例子**</mark>

<mark style="color:yellow;">**判断left array is sorted:**</mark>  nums = \[4,5,6,7,8,9,0,1,2,3]   n = 10 \ <mark style="color:yellow;">**-**</mark> mid= 0+9/2 = 4 ; mid value = 8 \
\- nums\[left] = 4 < nums\[mid] = 8 => <mark style="color:orange;">left array is sorted =>分为两个array</mark> \[4,5,6,7] \[9,0,1,2,3]\
\- 判断过target是否=mid 之后就可以把mid移掉

e.g. \
<mark style="color:blue;">target=0 => should search in right array</mark>\ <mark style="color:blue;">target=9  => should search in right array</mark>\
if (target < nums\[left]) => 比sorted array最小的还小\
OR If (target > nums\[mid] => 比sorted array最大的还大\
<mark style="color:blue;">target = 6 => should search in left array</mark>\
if (target >= nums\[left] && target < nums\[mid]) => 大于sorted array最小，而且小于mid

<mark style="color:yellow;">**判断right array is sorted:**</mark> nums=\[7,8,0,1,2,3,4,6] n = 8\
\- mid = 0 + 7/2 =3; mid value  = 1;\
\- nums\[left] = 7 > 1 <mark style="color:orange;">**=> right array is sorted =>**</mark> 分为两个array\[7,8,0] \[2,3,4,6]\
e.g.\
target=1 => 直接return mid\
<mark style="color:blue;">target=8 => 在非sorted array里搜索</mark>\ <mark style="color:blue;">target=0 => 在非sorted array里搜索</mark>\
If (target > nums\[right] || target < nums\[mid]) => 在sorted array里搜索\
<mark style="color:blue;">target=3 => 在sorted array里搜索</mark>\
If (target > nums\[mid] && target <= nums\[right]) => 在sorted array里搜索

nums = \[3,1] target = 1\
mid = 0+1/2 = 0; mid value = 3; \[]\
nums\[left] = 3 == mid  target = 1

Summary

The algorithm essentially divides the rotated array into two parts in each iteration - one part is sorted and the other is unsorted due to the rotation. The key idea is to identify which part is sorted and then check if the target value could possibly lie in that sorted part. 该算法基本上在每次迭代中将旋转的数组分为两部分 - 一部分是排序的，另一部分由于旋转而未排序。关键的想法是确定哪一部分是排序的，然后检查目标值是否可能位于那个已排序的部分。

{% code lineNumbers="true" %}
```java
/**
总之在while循环里
step0: 判断left<right还是left<=right => 因为我们是要 find exact same value,而且是每个num是unique的，所以用left<=right
step1: 找出哪边是sorted array 然后divide to 2 sub arrays
step2: 判断在sorted还是非sorted array搜索
*/
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while ( left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } 
            // if (nums[left] < nums[mid]) { 
            else if (nums[left] <= nums[mid]) {   // ---- left array is sorted
                // decide which sub array is ideal to search target
                if (target >= nums[left] && target < nums[mid]) { // search in sorted left array
                    right = mid - 1; // mid is definitely not the target
                } else {   // search in unsorted right array
                    left = mid + 1;  // mid is definitely not the target
                }
            } else {                         // ---- right array is sorted
                // decide which sub array is ideal to search target
                if (target <= nums[right] && target > nums[mid]) { // search in the sorted right array
                    left = mid + 1;
                } else { // search in unsorted left array
                    right = mid - 1; 
                }
            }
        }
        return -1;
    }
}
```
{% endcode %}

</details>

<details>

<summary>Code Analysis</summary>

Let  be the length of `nums`.

* Time complexity: $$O(log⁡n)】$$
  * This algorithm only requires one binary search over `nums`.
* Space complexity: $$O(1)$$
  * We only need to update several parameters `left`, `right` and `mid`, which takes $$O(1)$$ space.

</details>

<details>

<summary>Key Points</summary>

后续修改line 20: 加了=

Let's debug your code with the input `nums=[3,1]` and `target=1`.

In the first iteration, `left=0`, `right=1`, so `mid=0`. The value at `nums[mid]` is `3`, which does not equal the `target` `1`. Now, we move on to the `if` conditions.

The first condition checks if `nums[left] < nums[mid]`, which evaluates to `false` because `nums[0]` is `3` and `nums[0]` is `3`, so they are equal.

So, we move to the `else` part which is intended for the scenario where the right subarray is sorted. But in this case, we have a problem because the right subarray does not exist (since `mid` is `0` and `right` is `1`).

When we move to the inner `if` condition `target <= nums[right] && target > nums[mid]`, it also evaluates to `false` because `target` `1` is not greater than `nums[mid]` which is `3`.

As a result, we move to the inner `else` part and set `right = mid - 1`, which makes `right` become `-1`. Now `left` is `0` and `right` is `-1`, so the `while` condition `left <= right` is `false` and the loop ends, returning `-1`.

A better way to handle this is to use `<=` in the first `if` condition to cover the scenario where `nums[mid]` equals `nums[left]` or `nums[right]`, which can happen in cases like `nums=[3,1]` or `nums=[1,3]`.

</details>
