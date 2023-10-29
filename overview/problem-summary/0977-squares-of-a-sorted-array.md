# 🟢 0977 - Squares of a Sorted Array

<details>

<summary>Description 题目描述 </summary>

Given an integer array `nums` sorted in **non-decreasing** order, return _an array of **the squares of each number** sorted in non-decreasing order_.&#x20;

**Example 1:**

<pre><code><strong>Input: nums = [-4,-1,0,3,10]
</strong><strong>Output: [0,1,9,16,100]
</strong><strong>Explanation: After squaring, the array becomes [16,1,0,9,100].
</strong>After sorting, it becomes [0,1,9,16,100].
</code></pre>

**Example 2:**

<pre><code><strong>Input: nums = [-7,-3,2,3,11]
</strong><strong>Output: [4,9,9,49,121]
</strong></code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

1. **Sort:** simple but bad runtime and space complexity
2. **Two Pointer:**&#x20;

</details>

<details>

<summary>Algo &#x26; Code: SORT</summary>

1. Iterate through each element in the input array `nums`.
2. For each element, square it and store the result in the corresponding position in the `resultArr` array.
3. After all elements have been squared and stored, sort the `resultArr` array in ascending order.
4. Return the sorted `resultArr` array.

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] resultArr = new int[length];
        for (int i = 0; i < length; i++) {
            resultArr[i] = nums[i] * nums[i];
        }
        Arrays.sort(resultArr); // sor the array
        return resultArr;
    }
}
```

* Time Complexity : O(nlogn)
  * The time complexity is <mark style="color:yellow;">**dominated by the sorting operation**</mark>. The time complexity of the sorting function in Java (TimSort) is <mark style="color:red;">**O(nlogn)**</mark>, where n is the length of the array. The loop that squares each element takes O(n) time, but O(n log n) is the larger term as n gets large, so the overall time complexity is O(n log n).
* Space Complexity: O(n)
  * The space complexity is O(n), where n is the length of the array. This is because we create a new array `resultArr` that has the same length as the input array `nums`. The rest of the space is used for variables that take constant space, so the overall space complexity is O(n).

</details>

<details>

<summary>Algo &#x26; Code: Two Pointers</summary>

**Algorithm (Optimized):  avoid sorting method to improve the runtime**

1. Initialize two pointers, `left` at the start of `nums` and `right` at the end.
2. Compare the absolute values of `nums[left]` and `nums[right]`. The larger one is the number which, when squared, gives the largest result.
3. Place the square of the larger number from step 2 in the last available position in the resultant array.
4. Move the pointers inward (if `nums[left]` was larger, increment `left`; if `nums[right]` was larger, decrement `right`) and decrease the position for the next largest square in the resultant array.
5. Repeat steps 2 to 4 until the `left` and `right` pointers meet.

注意：

* <mark style="color:blue;">**为什么for loop是从大到小排？**</mark>因为我们在使用两个指针从数组的两端向中间移动时，我们首<mark style="color:green;">**先处理的是最大的数**</mark>（即，最大的平方）。因此，我们需要从<mark style="color:green;">**结果数组的末尾开始填充**</mark>，这就是为什么 for 循环是从大到小排的。
* <mark style="color:blue;">**为什么i>=0而不是i>0?**</mark> 因为我们的目标是<mark style="color:green;">**填充整个结果数组，包括索引为 0 的位置**</mark>。如果我们使用 `i > 0`，那么当 `i` 为 0 时，循环就会停止，最后我们将无法填充结果数组的第一个位置。<mark style="color:green;">**通过使用**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`i >= 0`**</mark><mark style="color:green;">**，我们可以确保结果数组的每个位置都被正确填充。**</mark>

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        
        // 注意loop: 从右往左拍
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[i] = nums[right] * nums[right];
                right--;
            } else {
                result[i] = nums[left] * nums[left];
                left++;
            }
        }
        
        return result;
    }
}
```

```
Step 1: i = 4
nums = [-4,-1,0,3,10], left = 0, right = 4, result = [_,_,_,_,_]
Calculate nums[left]^2 = 16 and nums[right]^2 = 100. 
100 is larger, so place it in the last position of result.

Step 2:  i = 3
nums = [-4,-1,0,3,10], left = 0, right = 3, result = [_,_,_,100]
Calculate nums[left]^2 = 16 and nums[right]^2 = 9. 
16 is larger, so place it in the next available last position of result.

Step 3: i = 2
nums = [-4,-1,0,3,10], left = 1, right = 3, result = [_,_,16,100]
Calculate nums[left]^2 = 1 and nums[right]^2 = 9. 
9 is larger, so place it in the next available last position of result.

Step 4: i = 1
nums = [-4,-1,0,3,10], left = 1, right = 2, result = [_,1,9,16,100]
Calculate nums[left]^2 = 1 and nums[right]^2 = 0. 
1 is larger, so place it in the next available last position of result.

Step 5: i = 0
nums = [-4,-1,0,3,10], left = 2, right = 2, result = [0,1,9,16,100]
Now, both pointers are at the same position. 
Calculate nums[left]^2 = 0 and place it in the last available position of result.

Finally: result = [0,1,9,16,100]
```

* Time Complexity: O(n). The new algorithm simply processes each element in the array once, so it runs in linear time.
* Space Complexity: O(n). Even with the optimization, we still need to create a new array of size n to hold the results. So the space complexity remains O(n).

</details>

<details>

<summary>Code Analysis</summary>



</details>

<details>

<summary>心得 Key Points</summary>



</details>
