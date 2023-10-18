# Methods

In Java, <mark style="color:yellow;">`String`</mark> is a final class, not an interface. This means that you cannot inherit from the `String` class, and it cannot be modified, hence it is called an immutable class.

<mark style="color:yellow;">`StringBuilder`</mark> is also a class, not an interface. The `StringBuilder` class is designed to <mark style="color:blue;">**efficiently handle mutable character sequences, so it is mutable.**</mark>



initialize an empty string and  add a character to this string

<pre class="language-java"><code class="lang-java"><strong>// way 1: 用String
</strong><strong>String str = "";
</strong>str += 'a'; // Now str is "a"
</code></pre>

However, if you're going to be **adding many characters** to a string in Java, it's generally more efficient to use a `StringBuilder`. This is because <mark style="color:yellow;">**strings in Java are immutable, which means a new string object is created every time a string is modified**</mark>.&#x20;

`StringBuilder` is mutable, so it's faster for making many modifications. Here's an example:

```java
// way 2: 用StringBuilder
StringBuilder strBuilder = new StringBuilder();
strBuilder.append('a'); // Now strBuilder contains "a"
String str = strBuilder.toString(); // Convert to a string when you're done building
```

To delete all the elements in a `StringBuilder` in Java, you can use the `setLength(0)` method. This effectively clears the `StringBuilder` by setting its length to zero. Here is an example:

```
StringBuilder sb = new StringBuilder("Hello, World!");
sb.setLength(0);  // Now sb is empty
```

Another method is to use `delete(int start, int end)` method like this:

```
StringBuilder sb = new StringBuilder("Hello, World!");
sb.delete(0, sb.length());  // Now sb is empty
```

```java
// String Length
String str = "Hello, World!";
int length = str.length();
System.out.println(length); // 13

// Character Access
char ch = str.charAt(0);
System.out.println(ch); // 'H'

// Substring
String sub = str.substring(7);
System.out.println(sub); // "World!"

// Concatenation
String str2 = "Java";
String result = str.concat(" ").concat(str2);
System.out.println(result); // "Hello, World! Java"

// String Replacement
String replacedStr = str.replace("World", "Java");
System.out.println(replacedStr); // "Hello, Java!"

// String Splitting
String[] splitStr = str.split(", ");
System.out.println(Arrays.toString(splitStr)); // ["Hello", "World!"]

// Case Conversion
String upper = str.toUpperCase();
System.out.println(upper); // "HELLO, WORLD!"

String lower = str.toLowerCase();
System.out.println(lower); // "hello, world!"

// String Searching
int index = str.indexOf("World");
System.out.println(index); // 7

// String Comparison
boolean isEqual = str.equals("Hello, World!");
System.out.println(isEqual); // true

boolean isIgnoreCaseEqual = str.equalsIgnoreCase("hello, world!");
System.out.println(isIgnoreCaseEqual); // true
```
