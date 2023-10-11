package Two_Pointers;

/**
 * 680. Valid Palindrome II
 * Tag:
 * Given a string s, return true if the s can be palindrome
 * after deleting at most one character from it.
 */

public class Q680_Valid_Palindrome_2 {
  // Time complexity: O(N)
  // The main while loop we use can iterate up to N / 2 times, since each iteration
  // represents a pair of characters. On any given iteration, we may find a mismatch
  // and call checkPalindrome twice. checkPalindrome can also iterate up to N / 2 times,
  // in the worst case where the first and last character of s do not match.
  // Because we are only allowed up to one deletion, the algorithm only considers one mismatch.
  // This means that checkPalindrome will never be called more than twice.
  // As such, we have a time complexity of O(N)
  //
  // Space complexity: O(1)
  // The only extra space used is by the two pointers i and j, which can be considered constant relative to the input size.
  public boolean validPalindrome(String s) {

    if (s == null) {
      return false;
    }

    int left = 0, right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else {
        // Try skipping either the character at left or the character at right,
        // and check if the remaining substring is a palindrome.
        return canFormPalindromeBySkipping(s, left + 1, right) || canFormPalindromeBySkipping(s, left, right - 1);
      }
    }

    return true;
  }

  // Helper function to check if a substring can form a palindrome by skipping characters.
  private boolean canFormPalindromeBySkipping(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else {
        return false; // Skipping a character doesn't form a palindrome.
      }
    }

    return true; // The substring can form a palindrome by skipping characters.
  }

}
