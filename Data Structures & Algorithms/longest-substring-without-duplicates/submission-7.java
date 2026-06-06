class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int result = 0;
        Set<Character> hashset = new HashSet<Character>();
        int left = 0; 

        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && hashset.contains(s.charAt(i))) {
                hashset.remove(s.charAt(left));
                left++;
            }
            hashset.add(s.charAt(i));
            result = Integer.max(result, i-left +1);
        }

        return result;
    }
}
