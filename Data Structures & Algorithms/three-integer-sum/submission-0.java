class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                for (int m = j + 1; m < n; m++) {
                    if (nums[i] + nums[j] + nums[m] == 0){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[m]);
                        result.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
