class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        Map<Character,String> combinations = Map.of(
            '2',"abc" , '3',"def", '4',"ghi", '5',"jkl", '6',"mno", '7',"pqrs", '8',"tuv", '9',"wxyz"
        );

        List<String> result = new ArrayList<>();
        StringBuilder build = new StringBuilder();
        backtrack(combinations, result, build, digits, 0);
        return result;
    }

    void backtrack(Map<Character,String> map, List<String> result, StringBuilder build, String digits, int index) {
        if (digits == null) {
            return;
        }

        int len = digits.length();

        if (index == len) {
            result.add(build.toString());
            return;
        }

        String possibleCombinations = map.get(digits.charAt(index));
        for (char c : possibleCombinations.toCharArray()) {
            build.append(c);
            backtrack(map,result,build,digits,index+1);
            build.deleteCharAt(build.length() -1);
        }
    }
}
