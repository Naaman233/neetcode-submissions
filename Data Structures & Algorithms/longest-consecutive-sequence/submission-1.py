class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        Dict = set(nums)
        longest = 0
        for n in Dict:
            if (n - 1) not in Dict:
                length = 1
                while (n + length) in Dict:
                    length += 1
                longest = max(length,longest)
        return longest
