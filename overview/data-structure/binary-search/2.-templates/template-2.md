# Template 2

<pre class="language-java"><code class="lang-java">// binary search: find exact the same number
class Solution {
    public int search(int[] nums, int target) {
        // Edge Case
        if (nums.length == 0 || nums == null ) {
            return -1;
        }
        // 1. 定义target在左闭右开的区间[left, right）
        int left = 0;
        int right = <a data-footnote-ref href="#user-content-fn-1">nums.length;</a>

        // 2. 用 while loop
        // 当left == right时，[left, right) 无意义
        while <a data-footnote-ref href="#user-content-fn-2">(left &#x3C; right)</a> {
            int mid = left + (right - left)/2;
            if (target &#x3C; nums[mid]) { 
                right = mid; 
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

[^1]: 

[^2]: 
