class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        result = []
        if digits is None or len(digits) == 0:
            return result
        mapping = [
            "","","abc","def","ghi","jkl",
            "mno","pqrs","tuv","wxyz"
        ]
        def computeCombination(index,current):
            if len(current) == len(digits):
                result.append(current)
                return
            
            keypad = mapping[int(digits[index])]

            for i in keypad:
                computeCombination(index+1,current+i)
        
        computeCombination(0,"")
        return result


        