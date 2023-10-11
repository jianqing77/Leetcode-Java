package Two_Pointers;

/**
 * Q2330: Valid Palindrome IV
 * Tags: Two Pointers, String
 * You are given a 0-indexed string s consisting of only lowercase English letters.
 * In one operation, you can change any character of s to any other character.
 * Return true if you can make s a palindrome after performing exactly ONE or TWO
 * operations, or return false otherwise.
 */

// We simply need to count how many times two characters are mismatch by
// s.charAt(left) != s.charAt(right).
// Eventually, we return miss < 3.

public class Q2330_Valid_Palindrome_4 {
  public boolean makePalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    int miss = 0;
    while ( left < right ) {
      if(s.charAt(left) != s.charAt(right)) {
        miss++;
      }
      left++;
      right--;
    }
    return miss < 3;
  }
 // another easier expression
  public boolean makePalindrome2(String s) {
    int left = 0, right = s.length()-1, miss=0;
    // The updated value of miss (incremented by 1) is less than 3 (++miss < 3).
    while(left < right && (s.charAt(left) == s.charAt(right) || ++miss < 3 )){
      left++;
      right--;
    }
    return miss < 3;
  }
}
