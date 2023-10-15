# ▫ HashTable 哈希表

Hash Table is a data structure which organizes data using hash functions

<mark style="background-color:orange;">**Goal**</mark>: support <mark style="color:red;">**quick insertion and search.**</mark>

<mark style="background-color:orange;">**Two different kinds of hash tables**</mark>**: **<mark style="color:yellow;">**hash set**</mark>** & **<mark style="color:yellow;">**hash map**</mark>**.**

* &#x20;<mark style="color:yellow;">**hash set**</mark> is one of the implementations of a `set` data structure to <mark style="color:purple;">**store no repeated values**</mark><mark style="color:yellow;">**.**</mark>
* &#x20;<mark style="color:yellow;">**hash map**</mark> is one of the implementations of a `map` data structure to store **(**<mark style="color:purple;">**key, value)**</mark> pairs.

***

### HashSet

```java
// Initialization
Set<Integer> hashSet = new HashSet<>();

```

> Use HashSet to find Duplicate Values

```java
/*
 * Template for using hash set to find duplicates.
 */
boolean containsDuplicate(List<Type> keys) {
    // Replace Type with actual type of your key
    Set<Type> hashset = new HashSet<>();
    for (Type key : keys) {
        if (hashset.contains(key)) {
            return true;
        }
        hashset.add(key);
    }
    return false;
}
```

###
