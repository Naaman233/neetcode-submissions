class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        if s is None:
            return res
        
        word_count = len(s)
        def palindromeChecker(left,right):
            while left < right:
                if s[left] != s[right]:
                    return False
                left += 1
                right -= 1
            return True

        def dfs(cur,index):
            if index == word_count:
                res.append(cur[:]) 
                return

            for i in range(index, word_count):
                if (palindromeChecker(index,i)):
                    cur.append(s[index:i+1])
                    dfs(cur, i + 1)
                    cur.pop()
        dfs([],0)
        return res



        


        