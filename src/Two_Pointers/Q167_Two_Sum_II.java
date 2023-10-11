package Two_Pointers;

public class Q167_Two_Sum_II {

  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (numbers[left] + numbers[right] != target) {
      if (numbers[left] + numbers[right] > target) {
        right--;
      } else {
        left++;
      }
    }
    // guaranteed with an answer
    // return the 1-indexed result
    return new int[]{left+1, right+1};
  }

}
