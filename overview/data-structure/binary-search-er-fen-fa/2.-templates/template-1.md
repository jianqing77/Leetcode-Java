# Template 1

<pre class="language-java"><code class="lang-java"><strong>class Solution {
</strong>    public int search(int[] nums, int target) {
        // Edge Case
        if (nums.length == 0 || nums == null ) {
            return -1;
        }
        // 1. 定义target在左边闭合右边闭合的区间[left, right]
        int left = 0;
        int right = <a data-footnote-ref href="#user-content-fn-1">nums.length - 1;</a>

        // 2. 用 while loop
        // 当left == right时，[left, right] is meaningful
        while <a data-footnote-ref href="#user-content-fn-2">(left &#x3C;= right)</a> {
            // 3. 在while loop中定义mid 防止溢出overflow,等同于left+right/2
            int mid = left + (right - left)/2;
            if (target &#x3C; nums[mid]) { // nums[middle]一定不是target
                right = mid - 1; // target在left左区间[left, mid - 1]
            } else if (target > nums[mid]) { // nums[middle]一定不是target
                left = mid + 1; // target在right右区间[mid + 1, right]
            } else {
                return mid; // nums[middle]是target, return the index
            }
        }
        return -1; // not found target value
    }
}

</code></pre>

[^1]: 

[^2]: 
