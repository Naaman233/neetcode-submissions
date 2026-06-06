class Solution {
    /**
     * @param {number[]} nums
     * @return {number[][]}
     */
    subsets(nums) {
        let res = []
        if (nums == null) {
            return res
        }
      const  generateSubset = (cur,start) => {
            res.push([...cur])
            for (let i = start; i < nums.length; i++){
                cur.push(nums[i])
                generateSubset(cur, i+1)
                cur.pop();
            }
        }
        generateSubset([],0)
        return res
    }
}
