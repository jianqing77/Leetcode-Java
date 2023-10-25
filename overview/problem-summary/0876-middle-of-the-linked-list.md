---
description: '@Linked List @Two Pointers'
---

# 🟢 0876 - Middle of the Linked List

<details>

<summary>Description 题目描述 </summary>

Given the `head` of a singly linked list, return _the <mark style="color:yellow;">**middle**</mark> node of the linked list_.

<mark style="color:yellow;">**If there are two middle nodes,**</mark> return **the **<mark style="color:yellow;">**second middle**</mark> node.

![](<../../.gitbook/assets/Screenshot 2023-10-15 at 9.20.03 PM.png>)

</details>

<details>

<summary>Algorithm: <mark style="color:yellow;">Fast and Slow Pointers</mark></summary>

这个问题可以通过使用两个指针：一个快指针和一个慢指针来解决。这种方法被称为“快慢指针”或“双指针”方法。下面是算法的步骤：

1. 创建两个指针 `slow` 和 `fast`，并将它们都设置为链表的头节点。
2. **同时移动**这两个指针，`slow` 指针每次移动一个节点，`fast` 指针每次移动两个节点。
3. 当 `fast` 指针到达链表的尾部或者 `fast` 指针的下一个节点是 `null`（这代表链表长度为偶数）时，`slow` 指针就指向了链表的中间节点。

这种方法的原理是：

* 因为 `fast` 指针每次移动的速度是 `slow` 指针的两倍，所以当 `fast` 指针到达链表的尾部时，`slow` 指针刚好在链表的中间。
* 如果链表的长度是偶数，那么 `fast` 指针会在到达尾部节点之前就停下来，这时 `slow` 指针指向的是中间两个节点的第一个，再移动一步就是第二个中间节点。

</details>

<details>

<summary>Code Demo</summary>

卡点：\
1\. linked list的middle? \
2\. 怎么才能在有两个middle的时候retrieve second?&#x20;

<mark style="color:yellow;">**Q: while loop 为什么设定fast != null && fast.next != null? 为什么return slow 而不是slow.next**</mark>

* <mark style="color:green;">**奇数的edge case:**</mark>** **<mark style="background-color:yellow;">**此时fast.next == null**</mark>&#x20;

```
        slow
          ↓
1 -> 2 -> 3 -> 4 -> 5
                    ↑
                  fast
```

* <mark style="color:green;">**偶数的edge case:**</mark>  \
  <mark style="color:red;">倒数第二个循环, 因为此时fast. != null && fast.next != null，</mark>**所以会进入下一个循环**\ <mark style="color:red;">slow指向的是middle中的第一个</mark>

```
    slow
      ↓
 1 -> 2 -> 3 -> 4
           ↑
          fast
```

**进入下一个循环**：<mark style="color:red;">**slow指向的恰好是middle中的第二个元素**</mark>，此时<mark style="background-color:yellow;">**fast ==  null**</mark>

```
        slow
          ↓
1 -> 2 -> 3 -> 4 -> null
                     ↑
                    fast 
```

```java
// if even num: return the second one
class Solution {
    public ListNode middleNode(ListNode head) {
        // initialize two pointers
        ListNode slow = head;
        ListNode fast = head;
        // fast!=null => match even number of elements edge case
        // fast.next!=null => match odd number of elements edge case
        while (fast != null && fast.next != null) {
            slow = slow.next; // 1 step/move
            fast = fast.next.next; // 2 steps / move
        }
        return slow;
    }
}
```

<pre class="language-java"><code class="lang-java">// if even num: return the first one
class Solution {
    public ListNode middleNode(ListNode head) {
        // initialize two pointers
        ListNode slow = head;
        ListNode fast = head;
        <a data-footnote-ref href="#user-content-fn-1">ListNode prev = null;</a>
        // fast!=null => match even number of elements edge case
        // fast.next!=null => match odd number of elements edge case
        while (fast != null &#x26;&#x26; fast.next != null) {
            prev = slow; 
            slow = slow.next; // 1 step/move
            fast = fast.next.next; // 2 steps / move
        }
        // when the num is even: return the first mid 
        if (fast != null){
            <a data-footnote-ref href="#user-content-fn-2">return prev;</a>
        }
        return slow;
    }
}

</code></pre>

</details>

<details>

<summary>Algorithm: <mark style="color:yellow;">convert to array</mark> </summary>

**Intuition and Algorithm**

Put every node into an array  in order. Then the middle node is just `A[A.length // 2]`, since we can retrieve each node by index.

We can initialize the array to be of length `100`, as we're told in the problem description that the input contains between `1` and `100` nodes.

在这个方法中，我们首先创建了一个数组 `A` 来存储链表中的每个节点。然后我们遍历链表，把链表中的每个节点都保存到数组中，并用 `t` 来记录节点的数量。

最后，我们返回 `A[t / 2]`。这是因为，如果链表有 `t` 个节点，那么中间节点就是第 `t / 2` 个节点（数组下标从0开始计数）。

<mark style="color:yellow;">**这个解法的关键在于整数除法会自动向下取整。**</mark>所以，如果 `t` 是奇数，`t / 2` 就是中间的那个节点（因为索引从0开始，所以 `t / 2` 是第 `(t / 2) + 1` 个节点），如果 `t` 是偶数，`t / 2` 就是中间两个节点中的第二个。

例如，如果链表的长度是5（奇数），节点是 1->2->3->4->5，那么 `t / 2` 就是 2，对应的节点是3，即中间节点。

如果链表的长度是4（偶数），节点是 1->2->3->4，那么 `t / 2` 就是 2，对应的节点是3，即中间的第二个节点。

所以，这个解法可以正确地返回链表的中间节点。如果链表有两个中间节点，它会返回第二个。

<mark style="color:yellow;">在 Java 中，不存在</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`//`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">这种除法运算符。Java 只有</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`/`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">这一种除法运算符。</mark>

根据操作数的类型，Java 的 `/` 可以进行浮点数除法或整数除法：

* 如果两个操作数都是整数，那么 `/` 就进行整数除法，结果会自动向下取整。例如，`5 / 2` 会返回 `2`。
* 如果至少有一个操作数是浮点数，那么 `/` 就进行浮点数除法，结果是一个浮点数。例如，`5.0 / 2` 或 `5 / 2.0` 会返回 `2.5`。

在你给出的 Java 代码中，`t` 是一个整数，所以 `t / 2` 进行的是整数除法，结果会自动向下取整。这正好符合我们找链表中间节点的需求：如果链表长度是奇数，返回中间的节点；如果链表长度是偶数，返回中间两个节点的第二个。

</details>

<details>

<summary>Code Demo </summary>

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }
}
```

</details>

<details>

<summary>Code Analysis</summary>

fast & slow:&#x20;

* Time Complexity: , where $$N$$ is the number of nodes in the given list.
* Space Complexity: $$O(1)$$, the space used by `slow` and `fast`.

Array:

* Time Complexity: O(N), where NNN is the number of nodes in the given list.

<!---->

* Space Complexity: O(N), the space used by A.

</details>

[^1]: initiate a placeholder for the previous node

[^2]: return the previous one
