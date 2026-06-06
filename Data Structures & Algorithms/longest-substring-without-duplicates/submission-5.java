class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length() , count = 0;
        if (s.equals(" ")) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (bfs(s,i,j)) {
                    count = Math.max(count,j-i+1);
                }
            }
        }

        return count;
    }


    static boolean bfs(String s, int i , int j) {
        Set<Character> hashset = new HashSet<>();
        for (int n = i; n <= j; n++) {
            if (hashset.contains(s.charAt(n))) {
                return false;
            }
            hashset.add(s.charAt(n));
        }

        return true;
    }
}
