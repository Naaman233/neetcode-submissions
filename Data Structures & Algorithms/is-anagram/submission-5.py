class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        count_frequency = {}
        for char_s in s:
            count_frequency[char_s] = 1 + count_frequency.get(char_s,0)
        for char_t in t:
            if char_t in count_frequency:
                count_frequency[char_t] -= 1
            else:
                return False
        
        for count in count_frequency.values():
            if count != 0:
                return False
        return True