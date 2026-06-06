class Solution {
    public int longestConsecutive(int[] nums) {
        
        int longest = 0;
        HashSet<Integer> hashset = new HashSet<>();
        for (int i : nums) {
            hashset.add(i);
        }

        for (int n : nums) {
            if (!hashset.contains(n-1)) {
                int length = 1;
                while (hashset.contains(n + length)) {
                    length++;
                }
                longest = Math.max(length,longest);
            }
        }

        return longest;
    }
}
