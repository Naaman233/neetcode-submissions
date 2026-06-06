class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            char[] result = s.toCharArray();
            Arrays.sort(result);

            String sortedString = new String(result);
            if (!hashMap.containsKey(sortedString)) {
                hashMap.put(sortedString, new ArrayList<String>());
            }
            hashMap.get(sortedString).add(s);
        }

        return new ArrayList<>(hashMap.values());
    }
}
