# 🔸 \[left, right) left < right

<details>

<summary>find the exact value in a sorted array  == target value</summary>

<pre class="language-java"><code class="lang-java">// binary search: find exact the same number
class Solution {
    public int search(int[] nums, int target) {
        // Edge Case
        if (nums.length == 0 || nums == null ) {
            return -1;
        }
        // 1. 定义target在左闭右开的区间[left, right）
        int left = 0;
        <a data-footnote-ref href="#user-content-fn-1">int right = nums.length;</a>

        // 2. 用 while loop
        // 当left == right时，[left, right) 无意义
        while (<a data-footnote-ref href="#user-content-fn-2">left &#x3C; right</a>) {
            int mid = left + (right - left)/2;
            if (target &#x3C; nums[mid<a data-footnote-ref href="#user-content-fn-3">]</a>) { 
                <a data-footnote-ref href="#user-content-fn-4">right = mid; </a>
            } else if (target > nums[mid]) { 
                left = mid + 1; 
            } else {
                return mid; 
            }
        }
        return -1; // not found target value
    }
}
</code></pre>



</details>

<details>

<summary>变形： find the smallest value in a sorted array >= target value </summary>

<mark style="color:red;">寻找左边界</mark>

* 在一个排序数组中找到大于等于目标值的最小值，实际上就是在寻找左边界。
* 考虑一个升序排序的数组，我们的目标是找到第一个大于或等于给定目标值的元素。这个元素实际上就是一个新的“区间”的开始，这个区间包含的所有元素都大于或等于目标值。因此，这个元素就是我们要找的左边界。
* 在这种情况下，我们可以使用类似的二分搜索方法。我们不断将数组分成两半，如果中间元素小于目标值，我们就去右半部分继续查找；如果中间元素大于或等于目标值，我们就去左半部分查找。当搜索结束时，左指针将指向第一个大于或等于目标值的元素，也就是我们要找的左边界

An example where using `left < right` would be more appropriate is when you're trying to find the smallest value in a sorted array that is greater than or equal to a target value. This is sometimes known as a "lower bound" search.

```
input: nums = [1, 5, 6, 8, 10] , target = 7
output: 3 (8 is the value)
```

```java

class Solution {
    public int lowerBound(int[] nums, int target) {
        int left = 0;
        // Notice that right is set to nums.length, not nums.length - 1
        int right = nums.length; 

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
```

这段代码是实现了一个在排序数组中查找给定目标值的最小边界的算法

* 首先，初始化左边界 `left` 为 0，右边界 `right` 为数组的长度 `nums.length`。注意这里的 `right` 是设置为数组长度，而不是数组长度减一。

```
int left = 0;
int right = nums.length;
```

* 然后，进入一个 while 循环，条件是 `left` 小于 `right`。这样可以确保 `left` 和 `right` 不会交错。

```
while (left < right) {
```

* 在循环中，首先计算中间位置 `mid`。这里使用 `(right - left) / 2` 来避免可能的整数溢出。

```
int mid = left + (right - left) / 2;
```

* 然后，比较 `nums[mid]` 和目标值 `target`。
* 如果 `nums[mid]` 小于 `target`，则目标值应在 `mid` 的右边，所以将 `left` 设为 `mid + 1`。
* 如果找到一个 `nums[mid]` 大于等于 `target` 的值时，不能立即返回 `mid`，因为这并不一定是第一个满足条件的元素。这时我们应该在 `[left, mid]` 的范围内继续查找，也就是将 `right` 设为 `mid`，并继续执行循环。这样做的目的是继续缩小搜索范围，直到找到第一个大于等于 `target` 的值的位置。将 `right` 设为 `mid`。

```
if (nums[mid] < target) {
    left = mid + 1;
} else {
    right = mid;
}
```

* 循环结束后，`left` 将等于 `right`，并且它们指向的是数组中第一个大于或等于目标值的元素。所以函数返回 `left`。

```
return left;
```

</details>

**变形的解释：为什么用while (left < right)更合适**

当我们使用 `while (left <= right)` 作为循环条件时，我们通常希望在循环结束时找到一个<mark style="color:yellow;">**精确的匹配**</mark>。在这种情况下，如果我们找到一个匹配，我们通常会立即返回这个匹配的索引。如果循环结束而我们没有找到匹配，那么我们通常会返回一些表示未找到的值，比如 `-1`。

然而，在这个算法中，我们的目标是找到数组中<mark style="color:yellow;">**大于等于目标值**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`target`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**的第一个元素的位置**</mark>。即使我们在数组中没有找到精确的匹配，我们仍然需要返回一个有效的索引。这就是为什么我们使用 `while (left < right)` 作为循环条件，而不是 `while (left <= right)`。

如果你使用 `while (left <= right)` 并将 `right` 设置为 `mid - 1` 而不是 `mid`，那么在 `nums[mid]` 等于 `target` 时，你可能会跳过所有等于 `target` 的元素并找到一个更大的元素。

考虑这样一个例子：`nums=[1,2,2,2,3]`，`target=2`。如果你使用 `while (left <= right)` 并将 `right` 设置为 `mid - 1`，你可能会返回 `4`（指向元素3）而不是 `1`（指向第一个2）。

在你给出的例子 `nums=[1,5,6,8,9]` 和 `target=8` 中，两种方式都会返回正确的结果。这是因为 `8` 在数组中只出现了一次。不过，如果 `8` 在数组中出现多次，那么 `while (left <= right)` 可能会返回最后一个 `8` 的位置，而不是第一个。



[^1]: diff

[^2]: diff

[^3]: 

[^4]: diff
