# Summary

```java
public class ListNode {
 
      int val;
      ListNode next;
      
      ListNode() {}
      ListNode(int val) { 
            this.val = val; 
      }
      ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
      }
 }

```

{% hint style="success" %}
Why define 3 Constructors?
{% endhint %}

The three constructors in the `ListNode` class provide flexibility in creating nodes for different scenarios when dealing with a singly linked list. Here are examples for each constructor:

1.  **Default Constructor**: `ListNode() {}`

    The default constructor is used when you want to create a new node, but you don't have the value or the next node at the moment of creation.

    ```
    ListNode node = new ListNode();
    // Some other code...
    node.val = 5;  // set value later
    node.next = null;  // set next node later

    ```
2.  **Single Argument Constructor**: `ListNode(int val) { this.val = val; }`

    This constructor is useful when you know the value of the node but don't have the next node yet, or this is the last node in the list.

    ```
    ListNode lastNode = new ListNode(10);
    ```
3.  **Two Argument Constructor**: `ListNode(int val, ListNode next) { this.val = val; this.next = next; }`

    This constructor is used when you know both the value of the new node and which node it should point to next. This is particularly useful when inserting a node into the middle of a list.

    javaCopy

    ```
    ListNode nextNode = new ListNode(15);
    ListNode newNode = new ListNode(10, nextNode);
    ```

In summary, different constructors are used to create nodes in different scenarios. This is a common practice in object-oriented programming, providing the flexibility to create objects in various states.

{% hint style="success" %}
`list1 = [1, 2, 4] =>` list1<mark style="color:yellow;">`.val = 1`</mark>
{% endhint %}

In the context of a singly linked list, <mark style="background-color:orange;">**list1**</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">would be a reference to the</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**head node**</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">of the list.</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**When you say**</mark><mark style="background-color:orange;">** **</mark><mark style="background-color:orange;">**`list1.val`**</mark><mark style="background-color:orange;">**, it will return the value of the HEAD node.**</mark>

Given your example where `list1` represents the linked list `[1,2,4]`, `list1.val` would return `1`, which is the value of the head node of the list.

To access the values of the subsequent nodes, you would need to follow the `next` references. For example, `list1.next.val` would return `2`, and `list1.next.next.val` would return `4`.

Please note that you would need to ensure that the `next` node you are trying to access is not `null` to avoid a `NullPointerException`.
