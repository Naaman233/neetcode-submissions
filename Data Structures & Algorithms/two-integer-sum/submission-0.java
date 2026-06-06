class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++){
            int x = target - nums[i];

            if (hashMap.containsKey(x) && hashMap.get(x) != i) {
                int index1 = hashMap.get(x);
                int index2 = i;

                return new int[]{Math.min(index1,index2),Math.max(index1,index2)};
            }else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[0];
    }
}
