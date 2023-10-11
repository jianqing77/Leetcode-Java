# 001 - Two Pointers

<details>

<summary>Description 题目描述 </summary>



</details>

<details>

<summary>Algorithm 解题思路 </summary>

<mark style="background-color:orange;">**HashMap? Why?**</mark>

* As we are trying to match the index with the value, so it's like a PAIR value&#x20;
* \=> HashMap => key value set => key: array value ;  Value: array index

<mark style="background-color:orange;">**How to convert the input int ARRAY to HashMap**</mark>

1. initiate a new EMPTY map => specify the key value type&#x20;
2. <mark style="color:orange;">**NO NEED TO COPY ALL THE VALUE TO THE MAP AT FIRST**</mark>
   1. 初始map是empty的, 刚开始 必然 会把array的第一个num的index和num加进去
   2. for loop里边的else会逐个把未匹配上的数字加到map里



1. **Algorithm**: Iterate through the array. For each element, first calculate the difference between the target number and this element (referred to as the complement), then look up this complement in the hash map. If it exists, we've found the two numbers that sum up to the target number and return their indices. If it doesn't exist, add the current element and its index to the hash map, and continue to the next element.



</details>

<details>

<summary>Code Demo </summary>

```java
// Some code
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key: value ; value: index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
            map.put(nums[i], i);
            }
        }
        
        return new int[]{};
    }
}

```

</details>

<details>

<summary>Code Analysis</summary>

**Central Idea**: The solution primarily uses a hash map (`HashMap` in Java) and a single loop. The hash map is used to store each element in the array and their indices, enabling an O(1) time complexity for element lookup.

<mark style="color:yellow;">Time complexity: O(n)</mark>

The time complexity is O(n) because there is a <mark style="color:blue;">single loop that iterates through the</mark> <mark style="color:blue;"></mark><mark style="color:blue;">`nums`</mark> <mark style="color:blue;"></mark><mark style="color:blue;">array</mark>. Inside the loop, all operations (checking if the map contains a key, getting a value from the map, and putting a value into the map) have constant time complexity O(1). So, the overall time complexity of the function is O(n).

Space Complexity  O(n)&#x20;

The space complexity is O(n) because, in the worst case, we might need to store all the `n` elements of the array in the `HashMap`. Each element will be stored as a key-value pair in the map. Therefore, the space complexity of the function is O(n).

\




</details>

<details>

<summary>Key Points</summary>

Map related:

1. initiate a new HashMap: Map\<Integer, Integer> map = new HashMap<>();
2. check if map contains the key:&#x20;
3. check if map contains specific value:&#x20;
4. retrieve specific value with the key: map.get(key)
5. add key value pair to the map: map.put(key, value)

</details>
