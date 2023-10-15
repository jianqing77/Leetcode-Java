# 🟢 21 - Merge Two Sorted Lists

<details>

<summary>Description 题目描述 </summary>

You are given the heads of <mark style="color:yellow;">two sorted linked lists</mark> `list1` and `list2`.

Merge the two lists into <mark style="color:yellow;">one</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">**sorted**</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">list.</mark> The list should be made by splicing together the nodes of the first two lists.

Return _the head of the merged linked list_.

Example :tada:

```
Input: 1->2->4->5, 1->3->4
Output: 1->1->2->3->4->4->5
```

</details>

<details>

<summary>Algorithm 解题思路 </summary>

题目大意：merge two sorted linked list into one sorted linked list

![](<../../.gitbook/assets/Screenshot 2023-10-12 at 8.48.18 PM.png>)

![](<../../.gitbook/assets/Screenshot 2023-10-12 at 8.49.10 PM.png>)

![](<../../.gitbook/assets/Screenshot 2023-10-12 at 8.52.19 PM.png>)

Algorithm:  find the smallest node, and **merge the rest of the linked list and attach to the smallest node**(recursive)

1. Compare the head of list1 and list2 find which head is the smaller
2. Assign the returned list's head = smallest head node we first found in the two list
3. Merge the remaining two list together, and attach the **merged** linked list to the head
4. Base Case: if either list 1 or list 2 is null, we no longer need to traverse the another linked list => the result head is the another linked list which is not null yet =>  back to the start of the solution and add the base case

</details>

<details>

<summary>Code Demo </summary>

注意：

1. `list1 = [1, 2, 4]`
   1. <mark style="color:yellow;">list1 = head node</mark>  In the context of a singly linked list, <mark style="background-color:yellow;">**list1 would be a reference to the head node of the list.**</mark>
   2.  &#x20;<mark style="color:yellow;">list1.val = 1</mark>  When you say list1.val, it will return the value of the HEAD node.

       <mark style="background-color:yellow;">=> 题目给的是node, node.val是这个node的value, 但是list.val指的是head node的value</mark>
2. 一开始觉得recursion很复杂，但是看了这个的讲解，感觉似乎又没有那么复杂

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // base case: if either of the list is null
        // stop interate the another non-null linked list and that is the result
        if (list1 == null) { return list2; }
        if (list2 == null) { return list1; }
        
        // 1. initiate the result merged linked list head
        ListNode resultHead;
        // 2. find the smaller head node between two linekd list
        // assign the result head to the smaller head node we found
        // move the founded list backwards
        if ( list1.val < list2.val) {
            resultHead = list1; // list1 = head node of list1
            list1 = list1.next;
        } else {
            resultHead = list2;
            list2 = list2.next;
        }
        // 3. merge the remaining two linked list together
        // attach the merged list to the resultHead
        resultHead.next = mergeTwoLists(list1, list2);
        // 4. return the resultHead node
        return resultHead
    }
}
```

</details>

<details>

<summary>Code Analysis</summary>



**Complexity Analysis**

*   Time complexity : $$O(n+m)$$

    Because each recursive call increments the pointer to `l1` or `l2` by one (approaching the dangling `null` at the end of each list), there will be exactly one call to `mergeTwoLists` per element in each list. Therefore, the time complexity is linear in the combined size of the lists.
*   Space complexity : $$O(n+m)$$

    The first call to `mergeTwoLists` does not return until the ends of both `l1` and `l2` have been reached, so $$n+m$$ stack frames consume $$O(n+m)$$

    &#x20;space.



</details>

<details>

<summary>Key Points</summary>

1.  `list1 = [1, 2, 4]`

    1. <mark style="color:yellow;">list1 = head node</mark>  In the context of a singly linked list, <mark style="background-color:yellow;">**list1 would be a reference to the head node of the list.**</mark>
    2. <mark style="color:yellow;">list1.val = 1</mark>  When you say list1.val, it will return the value of the HEAD node.

    <mark style="background-color:yellow;">=> 题目给的是node, node.val是这个node的value, 但是list.val指的是head node的value</mark>

<!---->

2. 就找第一步的algorithm
3. 找准base case

</details>
