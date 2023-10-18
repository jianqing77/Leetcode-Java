# ▫ List 列表



<table><thead><tr><th width="226.33333333333331">Operation</th><th width="473">Code</th><th></th></tr></thead><tbody><tr><td>Initiation</td><td>List&#x3C;Employee> employeeList = new ArrayList&#x3C;>();</td><td></td></tr><tr><td>Length</td><td>int num = employeeList.<mark style="color:red;"><strong>size();</strong></mark></td><td></td></tr><tr><td>Add (to the end)</td><td>employeeList.add(newEmployee);</td><td></td></tr><tr><td>Add (to specific position)</td><td>employeeList.add(3, newEmployee);</td><td></td></tr><tr><td>convert to Array</td><td>Employee[ ]  employeeArray = employeeList.<mark style="color:red;"><strong>toArray</strong></mark>(new Employee[<mark style="color:green;"><strong>employeeList.size()</strong></mark>];</td><td></td></tr><tr><td>check if an element is in the List (add equal method)</td><td>Boolean result = employeeList.<mark style="color:red;"><strong>contains</strong></mark>(someEmployee)</td><td></td></tr><tr><td>get the index of specific item</td><td>int index = employeeList.<mark style="color:red;"><strong>indexOf</strong></mark>(aEmployee)</td><td></td></tr><tr><td>forEach</td><td>employeeList.<mark style="color:red;"><strong>forEach</strong></mark>((employee -> System.out.println(employee)))</td><td></td></tr></tbody></table>

1. 如何check一个list是否是另一个list的sublist in java

```java
int index = Collections.indexOfSubList(list, sublist);
if (index != -1) {
   System.out.println("list2 is a sublist of list1. Index: " + index);
} else {
    System.out.println("list2 is not a sublist of list1.");
}
```

2. 如何check一个nested list包含了所有的sublist In another nested list

To check if a nested list contains all the sublists of another nested list in Java, you can use the `containsAll()` method from the `Collection` interface. `containsAll()` checks if the collection contains all the elements in the specified collection.

```java
 if (list1.containsAll(list2)) {
     System.out.println("list1 contains all sublists of list2.");
 } else {
     System.out.println("list1 does not contain all sublists of list2.");
 }
```
