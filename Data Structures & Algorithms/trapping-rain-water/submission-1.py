class Solution:
    def trap(self, height: List[int]) -> int:
        max_left = [0] * len(height)
        left_pointer = 0

        for i in range(len(height)):
            if i == 0:
                max_left[i] = 0
            else:
                max_left[i] = left_pointer
            
            left_pointer = max(left_pointer, height[i])
        
        max_right = [0] * len(height)
        right_pointer = 0

        for i in range(len(height) -1,-1,-1):
            if i == len(height) - 1:
                max_right[i] = 0
            else:
                max_right[i] = right_pointer
            right_pointer = max(right_pointer, height[i])
        
        result = 0
        for i in range(len(height)):
            if height[i] < min(max_left[i], max_right[i]):
                result = result + min(max_left[i], max_right[i]) - height[i]
        return result
    
        