class Solution:
    def minWindow(self, s: str, t: str) -> str:
        count_t = {}
        for char_t in t:
            count_t[char_t] = 1 + count_t.get(char_t,0)
        
        required,have = len(count_t),0
        left, result_len = 0 , float('inf')
        
        window_count = {}
        pointer_tracker = [-1,-1]
        
        for right in range(len(s)):
            char_c = s[right]
            window_count[char_c] = 1 + window_count.get(char_c,0)
            if char_c in count_t and window_count[char_c] == count_t[char_c]:
                have += 1
            while required == have:
                if (right - left + 1) < result_len:
                    result_len = right - left + 1
                    pointer_tracker = [left,right]
                
                window_count[s[left]] -= 1
                if s[left] in count_t and window_count[s[left]] < count_t[s[left]]:
                    have -= 1
                left += 1
        l,r = pointer_tracker
        return s[l:r + 1] if result_len != float('inf') else ""

        


