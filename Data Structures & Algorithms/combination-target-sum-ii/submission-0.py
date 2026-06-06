class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        result: List[List[int]] = []
        if candidates == None:
            return result

        candidates.sort()
        def compileCombination(start: int, current: List[int], total: int):
            if total == target:
                result.append(current[:])
                return
            if total > target or start == len(candidates):
                return
            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i-1]:
                    continue
                current.append(candidates[i])
                compileCombination(1 + i, current, total + candidates[i])
                current.pop()
        compileCombination(0,[],0)
        return result