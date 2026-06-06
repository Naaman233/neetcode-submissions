class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), res = 0;

        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++) {
                if (bfs(s,i,j)){
                    res = Math.max(res, j - i+1);
                }
            }
        }

        return res;

    }

    boolean bfs(String s, int i, int j) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int k = i; k <= j; k++ ) {
            if (hashSet.contains(s.charAt(k))) {
                return false;
            }else {
                hashSet.add(s.charAt(k));
            }
        }

        return true;
    }
}
