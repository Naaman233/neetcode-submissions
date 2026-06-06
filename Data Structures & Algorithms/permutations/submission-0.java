class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        boolean[] seen = new boolean[nums.length];
        compilePermutation(nums,res,new ArrayList<>(),seen);
        return res;

    }

    static void compilePermutation(int[] nums,List<List<Integer>> res,List<Integer> curr,boolean[] seen) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (seen[i]) {
                continue;
            }
            seen[i] = true;
            curr.add(nums[i]);
            compilePermutation(nums,res,curr,seen);
            curr.remove(curr.size() -1);
            seen[i] = false;
        }
    }
}
