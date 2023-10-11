package Two_Pointers;

/**
 * 125. Valid Palindrome
 * Tag: #Two Pointers
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase
 * letters and removing all non-alphanumeric characters, it reads the same forward and
 * backward.
 * - Alphanumeric characters include letters and numbers.
 * - Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class Q125_Valid_Palindrome {
  // 相向双指针: 判断回文串
  // Time complexity : O(n), in length nnn of the string. We traverse over each character at-most once, until the two pointers meet in the middle, or when we break and return early.
  // Space complexity : O(1). No extra space required, at all.
    public boolean isPalindrome(String s) {
      // Special case: If the input string is null, it cannot be a palindrome.
      if (s == null) {
        return false;
      }

      // Initialize two pointers: one at the beginning (left)
      // one at the end (right) of the string.
      int left = 0, right = s.length() - 1;

      // Iterate through the string using the two pointers until they meet or cross each other.
      while (left < right) {
        // Move the left pointer to the right until a valid alphanumeric character is found.
        while (left < right && !isAlphanumeric(s.charAt(left))) {
          left++;
        }
        // Move the right pointer to the left until a valid alphanumeric character is found.
        while (left < right && !isAlphanumeric(s.charAt(right))) {
          right--;
        }

        // Check if the characters at the left and right pointers are not equal (ignoring case).
        // If they are not equal, the string cannot be a palindrome.
        if (left < right && !isEqual(s.charAt(left), s.charAt(right))) {
          return false;
        }

        // Move the pointers towards each other.
        left++;
        right--;
      }

      // If the loop completes without returning false, the string is a palindrome.
      return true;
    }

    // Helper function to check if a character is valid (alphanumeric).
    private boolean isAlphanumeric(char c) {
      return Character.isLetter(c) || Character.isDigit(c);
    }

    // Helper function to check if two characters are equal (ignoring case).
    private boolean isEqual(char a, char b) {
      return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
