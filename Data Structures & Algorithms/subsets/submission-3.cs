public class Solution {
    public List<List<int>> Subsets(int[] nums) {
        List<List<int>> res = new List<List<int>>();
        if (nums == null) {
            return res;
        }

        generateSubset(0,res,nums,new List<int>());
        return res;
    }

    static void generateSubset(int start, List<List<int>> res,
    int[] nums, List<int> cur) {
        res.Add(new List<int>(cur));

        for (int i = start; i < nums.Length; i++) {
            cur.Add(nums[i]);
            generateSubset(i+1,res,nums,cur);
            cur.RemoveAt(cur.Count - 1);

        }
    }
}
