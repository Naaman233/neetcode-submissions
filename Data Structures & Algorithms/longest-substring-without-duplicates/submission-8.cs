public class Solution {
    public int LengthOfLongestSubstring(string s) {
        HashSet<char> set = new HashSet<char>();
        int left = 0;
        int result = 0;

        for (int i = 0; i < s.Length; i++) {
            while (i < s.Length && set.Contains(s[i])) {
                set.Remove(s[left]);
                left = left + 1;
            }
            set.Add(s[i]);
            result = Math.Max(result, i - left + 1);
        }

        return result;
    }
}
