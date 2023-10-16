# Java的一些点

<details>

<summary>Java: Pass by Value &#x26; Pass by Reference</summary>

In summary, Java is strictly "pass-by-value". When we pass a primitive type to a method, it's a true "pass-by-value". When we pass an object, the reference to the object is passed by value, which might give the appearance of "pass-by-reference".

In Java, <mark style="color:yellow;">**method arguments are always**</mark>** **<mark style="color:red;">**passed by**</mark> <mark style="color:red;">**value**</mark><mark style="color:yellow;">**, not by reference.**</mark>&#x20;

* This means that when you pass a variable to a method, Java passes the value in the variable, not the actual variable itself. If you change the value of the argument inside the method, it does not affect the variable in the caller.
* However, there's a twist when it comes to <mark style="color:red;">**objects**</mark>. When you pass an object as an argument to a method, the value being passed is actually the <mark style="color:red;">**reference to the object in memory**</mark> (think of it as the memory address of the object). So, we often say that objects are passed by "reference", but it's more accurate to say that object references are passed by value.This means that if you modify the object's fields inside the method, those changes will persist after the method returns, because the method and the caller are referencing the same object in memory. But if you make the parameter reference a new object, it doesn't affect the original reference.

&#x20;Here's an example

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



