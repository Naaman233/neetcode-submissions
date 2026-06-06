class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> hashmap = new HashMap<>();
        int len = strs.length; 
        for (int i = 0; i < len; i++) {

            char[] result = strs[i].toCharArray();
            Arrays.sort(result);
            String sortedstrings = new String(result);
            if (!hashmap.containsKey(sortedstrings)) {
                hashmap.put(sortedstrings, new ArrayList<>());
            }
            hashmap.get(sortedstrings).add(strs[i]);
        }

        return new ArrayList<>(hashmap.values());
    }
}
