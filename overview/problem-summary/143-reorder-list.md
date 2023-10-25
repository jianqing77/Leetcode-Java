# 🟠 143 - Reorder List

<details>

<summary>Description 题目描述 </summary>

You are given the head of a singly linked-list. The list can be represented as:

```
L0 → L1 → … → Ln - 1 → Ln
```

_Reorder the list to be on the following form:_

```
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
```

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

</details>

<details>

<summary>解题思路 Intuition </summary>



</details>

<details>

<summary>Algorithm </summary>

The problem is to rearrange a given linked list in a specific order. The new order is such that the first element is followed by the last, then second, then second last, and so on. This can be done by dividing the problem into three parts:

1. <mark style="color:green;">**Find the middle of the linked list**</mark><mark style="color:green;">:</mark> The first step is to divide the linked list into two halves. The first half will be the nodes from the start to the middle, and the second half will be from the middle to the end of the list. We can use the slow and fast pointers technique to find the middle of the list, where the slow pointer moves one node at a time and the fast pointer moves two nodes at a time. When the fast pointer reaches the end, the slow pointer will be at the middle.
2. <mark style="color:green;">**Reverse the second half of the list**</mark><mark style="color:green;">:</mark> Next, we need to reverse the second half of the list. This can be done using a simple iterative approach where we maintain three pointers: `prev`, `current`, and `next`.
3. <mark style="color:green;">**Merge the two halves**</mark><mark style="color:green;">:</mark> Finally, we merge the two halves by taking one node alternately from each half <mark style="color:green;">**(first from the first half, then from the second half, and so on).**</mark>

```
Original list:            1 -> 2 -> 3 -> 4 -> 5
After finding middle:     1 -> 2 -> 3, and 4 -> 5
After reversing second:   1 -> 2 -> 3, and 5 -> 4
After merging:            1 -> 5 -> 2 -> 4 -> 3
```

```
Original list:            1 -> 2 -> 3 -> 4
After finding middle:     1 -> 2 and 3 -> 4
After reversing second:   1 -> 2 and 4 -> 3
After merging:            1 -> 4 -> 2 -> 3
```

</details>

<details>

<summary>Code Demo </summary>

```java
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode midNode = findMid(head); // find mid
        ListNode secondHalfStart = midNode.next; // find the start of second half
        midNode.next = null; // Break the connection between the two halves
        ListNode reversedHalf = reverseList(secondHalfStart); // reverse the second half 
        mergeList(head, reversedHalf); // merge
    }

    // step 1: find the mid node
    // step 2: reverse the second half
    // step 3: taking one node alternately from each half
    // odd num of nodes: append mid 

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { // list length is even
            return slow;
        } else {
            return prev;
        }
    }

    // 2: params should be the midNode
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            // move to next
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // 3. pick alternatively from each half => merge in place 
    // First Half:  1 -> 2 -> 3
    // Reversed Second Half: 5 -> 4
    private void mergeList(ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            // store the next node to a variable to avoid losing access
            ListNode temp1 = h1.next; // temp1 = 2
            ListNode temp2 = h2.next; // temp2 = 4

            h1.next = h2; // Append h2 after h1. // 1->5

            if (temp1 == null) { // Break if h1 has no remaining nodes.
                break;
            }
            h2.next = temp1; // 1->5->2

            h1 = temp1; // h1=2
            h2 = temp2; // h2=3
        }
        
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
