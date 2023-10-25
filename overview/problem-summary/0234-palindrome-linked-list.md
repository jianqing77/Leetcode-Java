# 🟠 0234 - Palindrome Linked List

<details>

<summary>Description 题目描述 </summary>

Given the `head` of a singly linked list, return `true` _if it is a palindrome or_ `false` _otherwise_.

<pre><code><strong>Input: head = [1,2,2,1]
</strong><strong>Output: true
</strong><strong>
</strong>Input: head = [1,2]
Output: false
</code></pre>

</details>

<details>

<summary>解题思路 Intuition </summary>

思路1： convert to string => two pointers 同向同速度指针

思路2：像009一样 => revert half, and compare first half and second half

</details>

<details>

<summary>✅ Code:  convert to string</summary>

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        // Step 1: convert linked list values to string
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        String valStr =  sb.toString();
        // Step 2: Two pointers method
        int left = 0;
        int right = valStr.length() - 1;
        while(left < right) {
            if (valStr.charAt(left) == valStr.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
```

Time & Space: O(n)

</details>

<details>

<summary>✅ Code:  <mark style="color:red;">Could you do it in <code>O(n)</code> time and <code>O(1)</code> space?</mark></summary>

1. find the mid of the linked list: [0876-middle-of-the-linked-list.md](0876-middle-of-the-linked-list.md "mention")
2. reverse the second half of the linked list: [0206-reverse-linked-list.md](0206-reverse-linked-list.md "mention")
3. compare the first half and second half

注意：

* line 7: 用midNode.next进行reverse的原因 => 针对odd num of nodes
  *   1->2->3->2->1：midNode = 3

      firstHalf：1 -> 2 -> 3\
      secondHalf：2 -> 1     => second half 是用midNode.next为开始
* line 33: even num of nodes 把first作为mid的原因
  * 因为上边要line 7: 用midNode.next进行reverse

<pre class="language-java" data-line-numbers><code class="lang-java">class Solution {
    public boolean isPalindrome(ListNode head) {
        // step 1: find the middle of the linked list
        ListNode midNode = findMid(head);

        // step 2: reverse the second half of the linked list
        ListNode secondHalf = reverseLinkedList<a data-footnote-ref href="#user-content-fn-1">(midNode.next);</a>

        // step 3: compare the first half and the reversed second half
        return sameLinkedList(head, secondHalf);
    }
    
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null &#x26;&#x26; fast.next !=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // even num of nodes: return the first one rather than second
        if (fast == null) {
            return prev;
        }
        return slow;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    private boolean sameLinkedList(ListNode head1, ListNode head2) {
        while (head1 != null &#x26;&#x26; head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
}
</code></pre>



```java
// without helper method
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode prev = null, next = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Step 3: Compare the first half and the reversed second half
        slow = head;
        fast = prev; // the start of the reversed second half
        while (fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        // The linked list is a palindrome
        return true;
    }
}
```

**Time Complexity: O(n)**

Here, n is the number of nodes in the linked list. The time complexity of the solution is linear because each node in the linked list is visited a constant number of times.

1. Finding the middle of the linked list requires traversing half of the list, which takes O(n/2) time, simplifying to O(n) in big O notation.
2. Reversing the second half of the list again requires traversing the other half of the list, which is also O(n/2), simplifying to O(n).
3. Comparing the two halves of the list requires traversing the entire list, which is O(n).

Adding these up, the overall time complexity is O(n).

**Space Complexity: O(1)**

The space complexity is constant because the solution only uses a fixed amount of space to store the slow and fast pointers, as well as a few temporary variables. It does not use any additional space that scales with the size of the input linked list. The reversal of the second half of the list is done in-place, which means it does not require additional space proportional to the list size.

</details>

<details>

<summary>✅ 心得 Key Points</summary>

Linked list 的基本体型一定要记牢

* find mid
* reverse
* compare
* merge

</details>

[^1]: 这里很容易出错
