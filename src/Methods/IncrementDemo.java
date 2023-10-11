package Methods;

public class IncrementDemo {
    public static void main(String[] args) {
      int i = 5;

      // Using ++i
      // i is incremented first, then the value is assigned to result1
      int result1 = ++i;
      System.out.println("Using ++i:");
      System.out.println("i: " + i); // Output: i: 6
      System.out.println("result1: " + result1); // Output: result1: 6

      // Reset i to 5
      i = 5;

      // Using i++
      // The value of i is assigned to result2, then i is incremented
      int result2 = i++;
      System.out.println("\nUsing i++:");
      System.out.println("i: " + i); // Output: i: 6
      System.out.println("result2: " + result2); // Output: result2: 5
    }
}

