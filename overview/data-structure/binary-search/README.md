# ▫ Binary Search 二分法

**Binary Search经常写错的原因：不清楚区间search space的定义**

* 区间的定义是不变量
* 在binary search中保持“ 不变量”
* 在while循环中，每一次边界的处理都根据区间的定义来操作 => 循环不变量规则

**Terminologies:**

***

* **Target** - the value that you are searching for&#x20;
* Index - the current location that you are searching&#x20;
* Left, Right - the indicies from which we use to maintain our search Space
* Mid - the index that we use

<mark style="background-color:orange;">**How do we identify Binary Search?**</mark>

***

* Binary Search is an algorithm that _<mark style="color:yellow;">**divides the search space in 2**</mark>_<mark style="color:yellow;">** **</mark><mark style="color:yellow;">**after every comparison.**</mark>&#x20;
* Binary Search should be considered every time you need to search for an index or element in a collection.
* &#x20;If the collection is <mark style="color:yellow;">**unordered**</mark>, we can always <mark style="color:yellow;">**SORT IT FIRST before applying Binary Search**</mark>**.**

<mark style="background-color:orange;">**3 Parts of a Successful Binary Search**</mark>

***

Binary Search is generally composed of 3 main sections:

1. _<mark style="color:yellow;">**Pre-processing**</mark>_ - <mark style="color:red;">**Sort**</mark> if collection is unsorted.
2. _<mark style="color:yellow;">**Binary Search**</mark>_ - Using a <mark style="color:red;">**loop or recursion**</mark> to <mark style="color:red;">**divide search space in half**</mark> after each comparison.
3. _<mark style="color:yellow;">**Post-processing**</mark>_ - Determine viable candidates in the remaining space.
