# 🔵 Bubble Sort

### Why Bubble Sort

The algorithm can be visualized as <mark style="color:red;">largest bubbles rising to the surface of water</mark>, hence the name. Smaller or larger values bubble through the list to find their correct position.

### Algorithm

* Compares <mark style="color:yellow;">**adjacent**</mark> elements and <mark style="color:yellow;">**swaps**</mark> them if they are in the wrong order. This step is repeated until the end of the list is reached, which completes one full pass.

<details>

<summary>Example Array</summary>

&#x20;`[5, 3, 8, 4, 2]`

*   **Pass 1**: 4 comparisons <mark style="color:blue;">(for an array of 5 elements, we do</mark> <mark style="color:blue;"></mark><mark style="color:blue;">`n - 1`</mark> <mark style="color:blue;"></mark><mark style="color:blue;">comparisons)</mark>

    * \[5, 3] -> Swap
    * \[5, 8] -> No swap
    * \[8, 4] -> Swap
    * \[8, 2] -> Swap

    Result:  \[3, 5, 4, 2, <mark style="color:red;">8</mark>] => largest element at the end
*   **Pass 2**: 3 comparisons <mark style="color:blue;">(since we know the last element is already sorted)</mark>

    * \[3, 5] -> No swap
    * \[5, 4] -> Swap
    * \[5, 2] -> Swap

    Result:  \[3, 4, 2, <mark style="color:red;">5</mark>, <mark style="color:red;">8</mark>]&#x20;
*   **Pass 3**: 2 comparisons <mark style="color:blue;">(last two elements are sorted)</mark>

    * \[3, 4] -> No swap
    * \[4, 2] -> Swap

    Result:  \[3, 2, <mark style="color:red;">4</mark>, <mark style="color:red;">5</mark>, <mark style="color:red;">8</mark>]&#x20;
*   **Pass 4**: 1 comparison <mark style="color:blue;">(only the first two elements might be out of order)</mark>

    * \[3, 2] -> Swap

    Result:  \[2, <mark style="color:red;">3</mark>, <mark style="color:red;">4</mark>, <mark style="color:red;">5</mark>, <mark style="color:red;">8</mark>]&#x20;

</details>

### Features

* Start from the first element & Find the largest at each pass:&#x20;
  * Bubble the largest element of the unsorted part to the end of the array
* In-place comparison&#x20;
* Stable sorting algorithm because it does not change the relative order of elements with equal keys

```java
public class SortBubble {

  public static void bubbleSort(int[] array) {
    for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
      for (int i = 0; i < lastUnsortedIndex; i++) {
        if (array[i] > array[i + 1]) {
          swap(array, i, i + 1);
        }
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
    bubbleSort(intArray);
    for (int j : intArray) {
      System.out.println(j);
    }
  }
}

```

### Complexity

* <mark style="color:yellow;">Time Complexity:</mark> In the worst case, we have to search the entire array to find the minimum element, meaning we can have up to  ( n − 1 ) + ( n − 2 ) + …+ 1 = `n(n-1)/2`.total operations, which is $$O(n^2 )$$&#x20;
* <mark style="color:yellow;">Space Complexity:</mark> The space complexity of selection sort is  O(1) since we do not use any additional space during the algorithm (all operations are in-place).

