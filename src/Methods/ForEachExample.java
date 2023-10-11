package Methods;

import java.util.*;

public class ForEachExample {
  public static void main(String[] args) {
    // Example with ArrayList
    List<Integer> numbersList = new ArrayList<>();
    numbersList.add(10);
    numbersList.add(20);
    numbersList.add(30);

    System.out.println("ArrayList:");
    numbersList.forEach(num -> System.out.println(num));
    numbersList.forEach(System.out::println);

    // Example with HashSet
    Set<String> namesSet = new HashSet<>();
    namesSet.add("Alice");
    namesSet.add("Bob");
    namesSet.add("Carol");

    System.out.println("\nHashSet:");
    namesSet.forEach(name -> System.out.println(name));

    // Example with HashMap
    Map<String, Integer> ageMap = new HashMap<>();
    ageMap.put("Alice", 25);
    ageMap.put("Bob", 30);
    ageMap.put("Carol", 28);

    System.out.println("\nHashMap:");
    ageMap.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
  }
}
