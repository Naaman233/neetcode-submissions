class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;  // An empty string is a valid palindrome
        int i = 0, j = s.length() - 1;
        
        // Iterate over the string with two pointers
        while (i < j) {
            // Skip non-alphanumeric characters on the left side
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // Skip non-alphanumeric characters on the right side
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // Compare the characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            // Move pointers inward
            i++;
            j--;
        }

        // If we have gone through the string without mismatch, it is a palindrome
        return true;
    }

}
