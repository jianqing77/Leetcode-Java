# ◽ Array 数组

**Sorting:** `Arrays.sort(arr)`

* Time Complexity: $$O(nlogn)$$ in the average and worst case, where n is the number of elements in the array.&#x20;
* This method sorts the elements of an array in ascending order. It uses a modified version of the merge sort algorithm known as **TimSort**. TimSort is a hybrid sorting algorithm that takes advantage of patterns in real-world data.

```java
int[] arr = {5, 3, 2, 8, 1};
Arrays.sort(arr); // [1, 2, 3, 5, 8]
```

**Length**

<pre class="language-java"><code class="lang-java"><strong>int[] myArray = {1, 2, 3, 4, 5};
</strong>int length = myArray.length;  // Length of array: 5
</code></pre>

**Subarray**

<pre class="language-java"><code class="lang-java"><strong>int[] myArray = {1, 2, 3, 4, 5};
</strong>int[] subArray = Arrays.copyOfRange(myArray, 1, 4); 
Arrays.toString(subArray)// [2, 3, 4]
</code></pre>

**Copy:** Arrays.copyOf(arr)

* Time Complexity: `O(n),` where n is the number of elements to be copied.

```java
int[] arr = {1, 2, 3, 4, 5};
int[] copy = Arrays.copyOf(arr, 3);
System.out.println(Arrays.toString(copy)); // [1, 2, 3]
```

**Binary Search:**  return the index of the target

* Time Complexity: $$O(logn)$$, where n is the number of elements in the array.&#x20;
* Explanation: This method searches for a specific element in a sorted array using binary search. It returns the index of the element if found, or a negative value if the element is not present.

```java
int[] arr = {1, 2, 3, 5, 8};
int index = Arrays.binarySearch(arr, 5);
```





Arrays.copyOf():  Explanation: This method creates a new array with the specified length and copies elements from the source array to the new array. It can be used to create a shallow copy of the array.

Arrays.fill(): Time Complexity: O(n), where n is the number of elements to be filled. Explanation: This method fills the specified range of elements in an array with a given value. It can be used to initialize an array with a default value or reset its contents.

Arrays.equals(): Time Complexity: O(n), where n is the number of elements in the arrays being compared. Explanation: This method checks if two arrays are equal in terms of their contents. It compares corresponding elements of the arrays.

Arrays.copyOfRange(): Explanation: This method creates a new array with elements copied from the source array within the specified range. It allows you to create a subset of the original array. Time Complexity: O(k), where k is the size of the copied range.

Arrays.toString(): Explanation: This method returns a string representation of the array, converting the elements to strings and joining them with commas. It's useful for printing the contents of an array. Time Complexity: O(n), where n is the number of elements in the array.

Arrays.asList(): Time Complexity: O(1), as it creates a view of the array without copying the elements. Explanation: This method converts an array into a fixed-size List. Note that it returns a List view of the array, so modifications to the list will affect the original array.

Arrays.stream(): Time Complexity: Depends on the operations performed on the Stream, but often involves iterating over the array elements. Explanation: This method converts an array into a Stream, allowing you to perform various stream operations on the array elements.
