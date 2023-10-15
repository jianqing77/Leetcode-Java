---
description: '@Linked List @Recursion'
---

# 🟢 0206 - Reverse Linked List

<details>

<summary>Description 题目描述 </summary>

Given the `head` of a singly linked list, reverse the list, and return _the reversed list_.

![](<../../.gitbook/assets/Screenshot 2023-10-15 at 6.07.57 PM.png>)

<pre><code><strong>Input: head = [1,2,3,4,5]
</strong><strong>Output: [5,4,3,2,1]
</strong></code></pre>

</details>

<details>

<summary>Algorithm: Iteration迭代</summary>

<mark style="background-color:yellow;">**Iteration: 本质是**</mark> <mark style="background-color:yellow;"></mark><mark style="background-color:yellow;">make the current node -></mark> <mark style="background-color:yellow;"></mark><mark style="background-color:yellow;">**PREVIOUS**</mark> <mark style="background-color:yellow;"></mark><mark style="background-color:yellow;">Node, NOT the NEXT node</mark>

<mark style="color:purple;">**Reverse Linked List 之前明确**</mark>：\
1\. 正常的 linked list <mark style="color:yellow;">**only have a pointer to the next node**</mark>, rather than its previous node\
2\. 正常的linked list <mark style="color:yellow;">**无法access to its previous node**</mark>&#x20;

因此为了达到目的，我们需要<mark style="color:purple;">**新建一个variable (**</mark><mark style="color:yellow;">**prevNode**</mark><mark style="color:purple;">**)**</mark> 来refer to its previous node\
\=> we  must keep track of the previous node with some variable \
\=> 为了达到reverse的效果还需要 make the current node point to the previous node\
\=> override <mark style="color:yellow;">**currNode.next = prevNode**</mark>

如果新建prevNode && currNode.next = prevNode, 我们会<mark style="color:purple;">**lose access to the next node**</mark>\
\=> 需要<mark style="color:purple;">save the next node to another variable(</mark><mark style="color:yellow;">**nextNode**</mark><mark style="color:purple;">)</mark> before override currNode.next

</details>

<details>

<summary>Code Demo </summary>

```sql
null -> 1 -> 2 -> 3 -> null
prev   cur  next

null <- 1  -> 2  -> 3 -> null
next   prev  cur  

null <- 1  <- 2  -> 3 -> null
       next  prev  cur

null <- 1  <- 2  <- 3 -> null
             next  prev  cur
```

<mark style="color:yellow;">**Q: 为什么要新建prevNode, currNode 和nextNode三个pointer？**</mark>

在迭代过程中，我们实际上是在移动这三个指针，它们之间的关系如下：

1. `prevNode`始终指向 `currNode` 的前一个节点。
2. `currNode`始终指向当前正在处理的节点。
3. `nextNode`始终指向 `currNode` 的下一个节点。

我们首先将 `prevNode` 设置为 `null`，`currNode` 设置为链表的头节点。然后开始迭代，每次迭代执行以下操作：

* 将 `nextNode` 设置为 `currNode` 的下一个节点。
* 将 `currNode` 的 `next` 指针设置为 `prevNode`。这是反转链表的关键步骤。
* 将 `prevNode` 和 `currNode` <mark style="color:orange;">**向前移动一步**</mark>。也就是说，将 `prevNode` 设置为 `currNode`，将 `currNode` 设置为 `nextNode`。

当 `currNode` 成为 `null`，即链表的末尾时，循环结束。此时，`prevNode` 就成为了新链表的头节点。因为在反转链表的过程中，原本的链表头成为了尾部，原本的链表尾成为了头部。

这个过程的时间复杂度是 O(N)，其中 N 是链表中的节点数量。每个节点都被处理一次，然后进行常数时间的操作。空间复杂度是 O(1)，因为我们只使用了几个额外的变量，不依赖于输入链表的大小。

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode;
        
        while (currNode != null) {
            // before overriding currNode.next: 
            // save the next node to a variable to not lose track
            nextNode = head.next;
            // override currNode.next: link to prevNode
            head.next = prevNode;
            // 注意这里“向前移动一步”的顺序
            // update the prevNode to the old currNode
            prevNode = currNode;
            // update the currNode to the next node
            currNode = nextNode;
        }
        // not return currNode as the ending of while loop is currNode is null
        return prevNode;
    }
}
```



</details>

<details>

<summary>Algorithm: Recursion</summary>

**Recursion Logic:**&#x20;

```sql
Step 1: 
Reverse the SUBLIST except the head (reverseList(head.next)) 
1 -> [2 -> 3 -> 4 -> 5 -> null]
Step 2: 
Append the head to the last element of the SUBLIST
[null <- 5 <- 4 <- 3 <- 2] <- 1
...
return the sublist
```

![](<../../.gitbook/assets/Screenshot 2023-10-15 at 9.07.16 PM (1).png>)

![](<../../.gitbook/assets/Screenshot 2023-10-15 at 9.07.48 PM (1).png>)

![](<../../.gitbook/assets/Screenshot 2023-10-15 at 9.07.54 PM (1).png>)

![](<../../.gitbook/assets/Screenshot 2023-10-15 at 9.08.13 PM (1).png>)

![](<../../.gitbook/assets/Screenshot 2023-10-15 at 9.08.26 PM.png>)

</details>

<details>

<summary>Code Analysis</summary>

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        // base case: empty or one element list
        if (head == null || head.next == null) {
            return head;
        }
        // intuition: 
        // step 1: reverse the sublist except the head (reverseList(head.next))
        ListNode reversedSublist = reverseList(head.next);
        // step 2: attach the head to the last element of the sublist
        // append the current node to head.next -> (head.next).next = head
        head.next.next = head;
        // current node is last element of the reversedlist
        head.next = null;

        return reversedSublist;
    }
}
```

</details>

<details>

<summary>Key Points</summary>



</details>
