# ▫ String 字符串



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
