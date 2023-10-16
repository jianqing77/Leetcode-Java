# ▫ Queue: FIFO

<details>

<summary>Queue Visualization</summary>

simple visualization of a queue:

```
Front [ 5 | 7 | 3 | 8 | 2 ] Rear  
```

In this queue, `5` is at the front and `2` is at the rear. When a new element is added (this operation is often called "enqueue"), it gets added to the rear of the queue:

```
Enqueue 9:  Front [ 5 | 7 | 3 | 8 | 2 | 9 ] Rear
```

When an element is removed from the queue (this operation is often called "dequeue"), it's always the element at the front that gets removed:

```
Dequeue: Front [ 7 | 3 | 8 | 2 | 9 ] Rear
```

As you can see, the oldest element (the one that's been in the queue the longest) is removed, which is why we say that a queue follows the First-In, First-Out principle.

</details>

<details>

<summary><strong>Queue Operation: </strong><mark style="color:yellow;"><strong>Linked List</strong></mark></summary>

<mark style="background-color:blue;">**Q: why we use LInked List to implement a queue? if queue is define why don't we initialize a new queue**</mark>

* In Java, `Queue` is an interface, not a class. An interface in Java is a specification of method signatures that a class can implement. It defines what methods a class should have, but it doesn't provide the actual implementation of these methods.
* So, when we say `Queue<Integer> queue = new LinkedList<Integer>();`, we mean that we are <mark style="color:purple;">creating an instance of the</mark> <mark style="color:purple;"></mark><mark style="color:purple;">`LinkedList`</mark> <mark style="color:purple;"></mark><mark style="color:purple;">class, which implements the</mark> <mark style="color:purple;"></mark><mark style="color:purple;">`Queue`</mark> <mark style="color:purple;"></mark><mark style="color:purple;">interface</mark>. In other words, <mark style="color:purple;">`LinkedList`</mark> <mark style="color:purple;"></mark><mark style="color:purple;">provides the actual code that backs the</mark> <mark style="color:purple;"></mark><mark style="color:purple;">`Queue`</mark> <mark style="color:purple;"></mark><mark style="color:purple;">operations.</mark>
* We use `LinkedList` to implement a `Queue` because `LinkedList` is a <mark style="color:yellow;">doubly-linked list</mark>, and its insertions and deletions at the beginning and end of the list (which correspond to the enqueue and dequeue operations) are very efficient.

```java
Queue<Integer> queue = new LinkedList<Integer>();

// Add elements to the queue using add() or offer()
queue.add(1);
queue.offer(2);

// Remove elements from the queue using remove() or poll()
// These methods retrieve and remove the head of the queue
int firstElement = queue.remove(); // This will throw an exception if the queue is empty
int firstElement = queue.poll(); // This will return null if the queue is empty

// Retrieve the head of the queue without removing it using element() or peek()
int head = queue.element(); // This will throw an exception if the queue is empty
int head = queue.peek(); // This will return null if the queue is empty
```

</details>

<details>

<summary>Demo Code</summary>

```java
Queue<Integer> queue = new LinkedList<>();

// enqueue items
queue.add(1);
queue.add(2);
queue.add(3);

// get the front element
int frontValue = queue.peek()

// dequeue items
while(!queue.isEmpty()) {
    System.out.println(queue.poll());
}
```

</details>

<details>

<summary>Q: <strong>Why use </strong><mark style="color:yellow;"><strong>Doubly Linked List</strong></mark><strong> not Singly Linked list?</strong></summary>

* While it's true that you could implement a queue with either a singly-linked list or a doubly-linked list, using a doubly-linked list like Java's `LinkedList` class provides some advantages.

<!---->

* When implementing a queue, we need to be able to efficiently perform the following operations:
  * <mark style="color:yellow;">**Enqueue**</mark>: Add an element to the end of the queue.
  * <mark style="color:yellow;">**Dequeue**</mark>: Remove an element from the front of the queue.
  * <mark style="color:yellow;">**Peek**</mark>: Look at the element at the front of the queue without removing it.

<!---->

* A singly-linked list allows for efficient addition and removal of elements at the front (head) of the list, but <mark style="color:orange;">**adding elements to the end (tail) of the list requires traversing the entire list, which can be inefficient.**</mark>

<!---->

* On the other hand, a doubly-linked list allows for efficient addition and removal of elements at both the front and the end of the list. This is because each node in a doubly-linked list holds a reference to both the next node and the previous node, which means you can easily add or remove nodes at either end.

<!---->

* In Java's `LinkedList` implementation of the `Queue` interface, the "front" of the queue is the head of the list, and the "end" of the queue is the tail of the list. This means that both enqueue (`add`/`offer`) and dequeue (`remove`/`poll`) operations can be performed in constant time, making it an efficient choice for implementing a queue.

<!---->

* However, as always, the best data structure to use depends on the specific requirements and constraints of your application. For example, if memory usage is a concern, you might opt for a different data structure, as doubly-linked lists require more memory to store the additional "previous" references.

</details>
