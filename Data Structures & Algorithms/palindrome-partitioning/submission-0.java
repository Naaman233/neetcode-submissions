class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        dfs(0,result,partition,s);
        return result;
    }

    void dfs(int index, List<List<String>> result, List<String> partition, String s) {
        int len = s.length();

        if (index >= len) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int i = index; i < len; i++) {
            if (isPalindrome(s,index,i)) {
                partition.add(s.substring(index,i+1));
                dfs(i+1, result, partition, s);
                partition.remove(partition.size() -1);
            }
        }
    }

    boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
        j--;
        }
        
        return true;
    }
}
