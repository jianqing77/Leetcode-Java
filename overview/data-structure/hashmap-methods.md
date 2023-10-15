# HashMap Methods

### HashMap Useful Methods:

**Initialization**

```java
Map<Character, Integer> map = new HashMap<>();
```

Retrieve

retrieve <mark style="color:yellow;">**a value**</mark> with its key: get & getOrDefault

```java
int value = map.get(key);
int value = map.getOrDefault(key);
```

retrieve <mark style="color:yellow;">**all the values**</mark> of a HashMap: return a collection

```java
Collection values = map.values()
```

retrieve <mark style="color:yellow;">**only the keys**</mark> of a HashMap: return a set&#x20;

```java
Set<Character> keys = map.keySet()
```

Add/update a element to a HashMap

```java
map.put(key, value)
```

***

<mark style="background-color:yellow;">**Convert a string to a HashMap to count the occurence of each character**</mark>\
key: character \
value: character frequency





