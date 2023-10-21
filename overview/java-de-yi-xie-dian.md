# Java的一些点

<details>

<summary>Java: Primitive &#x26; Reference Type</summary>

* **基本类型**primitive types <--> 值类型value type\
  包括`byte`, `short`, `int`, `long`, `float`, `double`, `boolean`, `char`。\
  这些类型的变量直接存储了value本身
  * **Value types** (also known as primitive types) in Java include `int`, `char`, `double`, `boolean`, `byte`, `short`, `long`, and `float`. These types of variables store the actual values.
* **Reference types** in Java include <mark style="color:yellow;">**Classes**</mark>, <mark style="color:yellow;">**Interfaces**</mark>, and <mark style="color:yellow;">**Arrays**</mark>. These types of variables <mark style="color:purple;">**store the reference (or address) to the value rather than the value itself.**</mark>
  * **Reference types**（引用类型）：在Java中，除了基本数据类型之外的所有类型都是引用类型，包括数组、类（包括包装类如Integer等）和接口。这些类型的变量存储的是对值的引用（或者说是值的地址），而不是值本身
* 本质的区别
  * **值类型**：值类型变量的赋值或者复制操作是传值的。也就是说新的变量会得到一个原始变量值的完全独立的副本，两个变量之间没有任何关联。修改一个变量的值不会影响到另一个变量。
  * **引用类型**：引用类型变量的赋值或者复制操作是传引用的。也就是说新的变量和原始变量都指向同一个对象，他们之间是有关联的。修改一个变量指向的对象的状态会影响到另一个变量。

记忆方法与例子：

* **值类型**：你可以想象值类型就像一份食谱上的菜品，例如“苹果派”。如果你按照食谱做出了一份苹果派，这份派就是一个具体的存在，它是独立的，不会因为食谱上的文字改变而改变。
* **引用类型**：你可以想象引用类型就像一份食谱上的链接或者标签，例如“#甜点”。这个标签可以链接到许多具体的菜品，比如“苹果派”、“巧克力蛋糕”等。如果你点击这个链接，你会看到一个菜品（一个对象）。如果这个菜品被改变了（比如从“苹果派”改成了“巧克力蛋糕”），你通过这个链接看到的菜品也会跟着改变。

Quick memory aid with an example:

* **Value types**: Think of a value type as a box containing a certain item without an address. If you make a copy of the box, you get a new box with a new item inside. Changing the item in the new box doesn't affect the item in the original box.
* **Reference types**: Think of a reference type as a box containing a piece of paper with an address written on it. The address points to a location where the actual item is stored. If you copy the box, you get a new box with a piece of paper inside, but the address written on the paper is the same. Changing the item at that address changes it for anyone who has the address.

</details>

<details>

<summary>Java: Pass by Value &#x26; Pass by Reference</summary>

In summary, Java is strictly "pass-by-value". When we **pass a **<mark style="color:purple;">**primitive type**</mark> to a method, it's a true "pass-by-value". When we pass an object, the reference to the object is passed by value, which might give the appearance of "pass-by-reference".







In Java, <mark style="color:yellow;">**method arguments are always**</mark>** **<mark style="color:red;">**passed by**</mark> <mark style="color:red;">**value**</mark><mark style="color:yellow;">**, not by reference.**</mark>&#x20;

* This means that when you pass a variable to a method, Java passes the value in the variable, not the actual variable itself. If you change the value of the argument inside the method, it does not affect the variable in the caller.
* However, there's a twist when it comes to <mark style="color:red;">**objects**</mark>. When you pass an object as an argument to a method, the value being passed is actually the <mark style="color:red;">**reference to the object in memory**</mark> (think of it as the memory address of the object). So, we often say that objects are passed by "reference", but it's more accurate to say that object references are passed by value.This means that if you modify the object's fields inside the method, those changes will persist after the method returns, because the method and the caller are referencing the same object in memory. But if you make the parameter reference a new object, it doesn't affect the original reference.

```java
public class Test {
    static void update(int num, StringBuffer buffer) {
        num = 20;
        buffer.append("world"); // reflected
        buffer = new StringBuffer("Hello "); // not relected 
    }

    public static void main(String[] args) {
        int num = 10;
        StringBuffer buffer = new StringBuffer("Hello ");
        update(num, buffer);
        System.out.println(num); // Output: 10 -- not changed even if we called update
        System.out.println(buffer); // Output: Hello world -- changed
    }
}
```

* <mark style="color:yellow;">**`num`**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**is a primitive type,**</mark> so it's passed by value. Changes made to `num` inside the `update` method do not affect the original `num` in `main`.&#x20;
  * <mark style="color:green;">在</mark><mark style="color:green;">`update`</mark><mark style="color:green;">方法中对</mark><mark style="color:green;">`num`</mark><mark style="color:green;">做的改变不会影响到</mark><mark style="color:green;">`main`</mark><mark style="color:green;">中的原始</mark><mark style="color:green;">`num`</mark>
* <mark style="color:yellow;">`buffer`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">is an object. The reference to</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">`buffer`</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">is passed by</mark> <mark style="color:yellow;"></mark><mark style="color:yellow;">**value**</mark><mark style="color:yellow;">.</mark>&#x20;
  * So when you change the object that `buffer` refers to by calling `buffer.append("world")`, <mark style="color:green;">the change is reflected in</mark> <mark style="color:green;"></mark><mark style="color:green;">`main`</mark> <mark style="color:green;"></mark><mark style="color:green;">after</mark> <mark style="color:green;"></mark><mark style="color:green;">`update`</mark> <mark style="color:green;"></mark><mark style="color:green;">returns.</mark>
  * &#x20;But when you make `buffer` refer to a new object with `buffer = new StringBuffer("Hello ") in update`, it doesn't affect the original `buffer` reference in `main`.

In summary, Java is strictly "pass-by-value". When we pass a primitive type to a method, it's a true "pass-by-value". When we pass an object, the reference to the object is passed by value, which might give the appearance of "pass-by-reference".



</details>

<details>

<summary>Java: prefix and postfix operator</summary>

<mark style="background-color:orange;">**Postfix Operator**</mark>

The <mark style="color:yellow;">**postfix operator**</mark> (++/ `--`) in Java is used to increase/decrease the value of a variable by 1, but <mark style="color:purple;">**the value is returned first before the  operation occurs.**</mark>

```java
int a = 10;
System.out.println(a--); // prints 10
System.out.println(a);   // prints 9
```

1. The current value of `a` (which is 10) is returned.
2. The value of `a` is decreased by 1, so `a` becomes 9.

However, because the current value is returned before the decrement operation occurs, the first `println` statement prints 10, not 9. The new value of `a` (which is 9) isn't revealed until the second `println` statement.

<pre class="language-java"><code class="lang-java"><strong>TreeNode root = new TreeNode(postorder[postorderRootIndex]);
</strong>postorderRootIndex--;
// Simplized:
TreeNode root = new TreeNode(postorder[postorderRootIndex--]);
</code></pre>

```java
for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}

// Simplized:
for (int i = 0; i < array.length; System.out.println(array[i++])); 
```

```java
while(node != null) {
    System.out.println(node.val);
    node = node.next;
}
// Simplized:
while(node != null) {
    System.out.println((node = node.next).val);
}
```

<mark style="background-color:orange;">**Prefix Operator**</mark>

This behavior contrasts with the prefix operator (++/`--`), <mark style="color:purple;">**which increase/decreases the value first before returning it:**</mark>

```java
int a = 10;
System.out.println(--a); // prints 9
```

In the println statement, `--a` is used. Here's what happens:

1. The value of `a` is decreased by 1, so `a` becomes 9.
2. The new value of `a` (which is 9) is returned.

So, the `println` statement prints 9, not 10.

</details>



