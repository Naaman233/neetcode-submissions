class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res: List[List[int]] = []
        if nums == None:
            return res
        seen: List[bool] = [False] * len(nums)
        def compilePermutation(nums,res,curr,seen):
            if len(nums) == len(curr):
                res.append(curr[:])
                return
            
            for i in range(len(nums)):
                if seen[i]:
                    continue
                seen[i] = True
                curr.append(nums[i])
                compilePermutation(nums,res,curr,seen)
                curr.pop()
                seen[i] = False
        compilePermutation(nums,res,[],seen)
        return res
