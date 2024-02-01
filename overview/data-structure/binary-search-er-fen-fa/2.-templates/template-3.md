# 🔸 Template 3

<pre class="language-java"><code class="lang-java"><strong>int binarySearch(int[] nums, int target){
</strong>  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, 
  int right =<a data-footnote-ref href="#user-content-fn-1">nums.length - 1;</a>
  
  while<a data-footnote-ref href="#user-content-fn-2">(left &#x3C; right)</a>{
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target) { 
      return mid; 
    } else if(nums[mid] &#x3C; target) { 
      left = mid + 1; 
    } else { 
      right = mid; 
    }
  }

  // Post-processing:
  // End Condition: left == right
  if(nums[left] == target) return left;
  return -1;
}
</code></pre>

[^1]: 

[^2]: 
