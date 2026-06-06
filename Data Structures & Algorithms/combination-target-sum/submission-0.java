class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        if (nums == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtracking(0, nums, target, result, combination);
        return result;
    }

    void backtracking (int index, int[] nums, int target, List<List<Integer>> result, List<Integer> combination) {

        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0 || index >= nums.length) {
            return;
        }else{
            combination.add(nums[index]);
            backtracking(index,nums,target-nums[index],result,combination);

            combination.remove(combination.get(combination.size() -1));
            backtracking(index+1,nums,target,result,combination);
        }
    }
}
