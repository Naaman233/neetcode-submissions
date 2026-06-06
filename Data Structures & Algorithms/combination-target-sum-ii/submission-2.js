class Solution {
    /**
     * @param {number[]} candidates
     * @param {number} target
     * @return {number[][]}
     */
    combinationSum2(candidates, target) {
        let result = []
        if (candidates == null) {
            return []
        }
        candidates.sort()
        this.compileCombination([],0,target,result,0,candidates)
        return result
    }

    compileCombination(curr,total,target,result,index,candidates) {
        if (total == target){
            result.push([...curr])
            return
        }

        if (total > target) {
            return
        }

        for (let i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]){
                continue
            }
            curr.push(candidates[i])
            this.compileCombination(curr, total + candidates[i], target, result, i + 1, candidates)
            curr.pop()
        }
    }
}
