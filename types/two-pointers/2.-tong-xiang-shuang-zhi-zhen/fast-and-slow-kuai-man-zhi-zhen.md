# Fast and Slow 快慢指针

<details>

<summary><strong>odd number of elements: find the middle element of a</strong> singly <strong>linked list</strong></summary>

take an example of a singly linked list with the following nodes:

```
1 -> 2 -> 3 -> 4 -> 5
```

The goal is to find the middle node of this linked list. Here's how we can apply the fast-slow pointer method:

1. Initialize two pointers, `slow` and `fast`, at the head of the linked list.

```
slow
  ↓
  1 -> 2 -> 3 -> 4 -> 5
  ↑
fast
```

2. Move `slow` one step and `fast` two steps.

```
    slow
      ↓
 1 -> 2 -> 3 -> 4 -> 5
           ↑
         fast
```

3. Again, move `slow` one step and `fast` two steps.

```
        slow
          ↓
1 -> 2 -> 3 -> 4 -> 5
                    ↑
                  fast
```

`fast` has reached the end of the linked list, and `slow` is at the middle. So, `slow` is pointing to the middle node of the linked list.

</details>

<details>

<summary><strong>even number of elements:</strong></summary>

如果链表的长度even，那么 `fast` 指针每次移动两个节点，

* <mark style="color:yellow;">**FAST指针：当fast到达最后一个节点的时候，其实已经无法再移动两步了**</mark>\
  \=> fast不在 null 位置停下来。 \
  \=> 在到达null之前就会停下来，所以是second last element时就已经停下不移动了
* `SLOW: slow` 指针会指向中间两个节点的第一个。为什么呢？\
  \- 因为 `fast` 指针每次移动两步，`slow` 指针每次移动一步，所以 `fast` 指针到达链表尾部的时候，<mark style="color:yellow;">`slow`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">指针会走到链表的中间。</mark>\ <mark style="color:yellow;">-</mark> <mark style="color:purple;">如果链表长度是偶数，那么链表的中间会有两个节点，此时</mark> <mark style="color:purple;"></mark><mark style="color:purple;">`slow`</mark> <mark style="color:purple;"></mark><mark style="color:purple;">指针指向的就是这两个节点的</mark><mark style="color:purple;">**第一个**</mark><mark style="color:purple;">。</mark>\ <mark style="color:purple;">-</mark> 然后，由于题目要求如果有两个中间节点，则返回第二个中间节点，那么我们<mark style="color:yellow;">只需让</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`slow`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">指针再向前走一步，就可以指向第二个中间节点了</mark>。这就是为什么在链表长度为偶数的时候，我们要返回 `slow` 指针的下一个节点。

If the linked list has an even number of nodes, say 4 (nodes: 1->2->3->4), \
&#x20;<mark style="color:yellow;">while</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`slow`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">will be at the SECOND middle node, the</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`fast =`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">null</mark> (node 3 in this case).

Here's how it looks like:

1. Initialize `slow` and `fast` at the head.

```
slow
  ↓
  1 -> 2 -> 3 -> 4
  ↑
fast
```

2. Move `slow` one step and `fast` two steps.

&#x20;<mark style="color:red;">此时已经无法再移动2steps, slow指向的是middle中的第一个</mark>

```
    slow
      ↓
 1 -> 2 -> 3 -> 4
           ↑
          fast
```

i**f trying to move `slow` one step and `fast` two steps.**

```
        slow
          ↓
1 -> 2 -> 3 -> 4 -> null
                     ↑
                    fast
```

Now, `fast` is null, and `slow` is pointing to the second middle node. Hence, the middle node in this case is the node with value 3.

</details>

