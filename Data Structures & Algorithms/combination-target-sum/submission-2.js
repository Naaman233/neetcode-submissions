class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @returns {number[][]}
     */
    combinationSum(nums, target) {
        let res = []
        if (nums == null) {
            return res
        }
        nums.sort()
        const generateCombinationSum = (index,cur,total) => {
            if (total == target) {
                res.push([...cur])
                return
            }

            if (total > target || index >= nums.length) {
                return
            }
            cur.push(nums[index])
            generateCombinationSum(index,cur,total+nums[index])
            cur.pop()
            generateCombinationSum(index+1,cur,total)
        }

        generateCombinationSum(0,[],0)
        return res

    }
}
