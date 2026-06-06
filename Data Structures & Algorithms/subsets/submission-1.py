class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result: List[List[int]] = []
        def compileSubset(start: int, current:List[int]):
            result.append(current[:])
            for index in range(start, len(nums)):
                current.append(nums[index])
                compileSubset(index+1, current)
                current.pop()

        compileSubset(0,[])
        return result