class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0,result,subset,nums);
        return result;
    }

    void dfs(int index, List<List<Integer>> result, List<Integer> subset, int[] nums) {
        int n = nums.length;
        if (index >= n) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(index+1, result, subset, nums);
        subset.remove(subset.size() -1);
        dfs(index+1, result, subset, nums);
    }
}
