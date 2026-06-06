class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        result: List[List[int]] = []
        if len(nums) == 0:
            return result
        def compileCombination(index: int, current: List[int], target: int):
            if target == 0:
                result.append(current[:])
                return
            
            if target < 0 or index >= len(nums):
                return
            
            current.append(nums[index])
            compileCombination(index,current,target-nums[index])
            current.pop()
            compileCombination(index+1,current,target)

        compileCombination(0,[],target)
        return result
        