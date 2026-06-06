class Solution:
    def maxArea(self, heights: List[int]) -> int:
        i,j = 0 , len(heights) - 1
        result = 0
        while i < j:
            height = min(heights[i],heights[j])
            breadth = j - i
            area = height * breadth
            result = max(result,area)

            if heights[i] < heights[j]:
                i += 1
            else:
                j -= 1
        return result






        