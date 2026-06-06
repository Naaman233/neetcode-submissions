class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        if nums is None:
            return res

        def combinationSumBuilder(index,cur,total):
            if total == target:
                res.append(cur[:])
                return

            if total > target:
                return
            
            for i in range(index,len(nums)):
                cur.append(nums[i])
                combinationSumBuilder(i,cur,total + nums[i])
                cur.pop()
        combinationSumBuilder(0,[],0)
        return res;
        