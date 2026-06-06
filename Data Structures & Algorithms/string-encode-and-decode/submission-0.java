class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        int n = strs.size();
        for (int i = 0; i < n; i++) {
            builder.append(strs.get(i).length()).append('#').append(strs.get(i));
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            int j = index;
            while (str.charAt(j) != '#') {
                j++;
            }

            int n = Integer.parseInt(str.substring(index, j));
            index = j + 1;
            j = index + n;
            result.add(str.substring(index,j));
            index = j;
        }
        return result;
    }
}
