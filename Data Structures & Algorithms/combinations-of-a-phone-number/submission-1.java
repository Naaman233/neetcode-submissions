class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }

        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        backtracking(0,mapping,"",digits,result);
        return result;
    }

    void backtracking(int index, String[] mapping, String current, String digits, List<String> result) {
        if (digits.length() == current.length()) {
            result.add(current);
            return;
        }
        char i = digits.charAt(index);
        int d = i - '0';
        String possibleCombinations = mapping[i - '0'];
        if (possibleCombinations.length() == 0){
            return;
        }

        for (char c : possibleCombinations.toCharArray()) {
            backtracking(index+1,mapping,current+c,digits,result);
        }
    }
}
