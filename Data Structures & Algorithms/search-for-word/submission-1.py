class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        #####
        # loop through the board taking note of the characters
        # when we find a character we traverse horizontally and 
        # vertically until we are able to form the word
        ######
        row = len(board)
        col = len(board[0])

        def dfs(i,j,index):
            length_of_word = len(word)
            if index == length_of_word:
                return True
            if i < 0 or i >= row or j < 0 or j >= col or word[index] != board[i][j]:
                return False

            temp = board[i][j]
            board[i][j] = "#"
            found = (
                dfs(i+1,j,index+1) or
                dfs(i-1,j,index+1) or
                dfs(i,j+1,index+1) or
                dfs(i,j-1,index+1)
            )
            board[i][j] = temp
            return found
        for i in range(row):
            for j in range(col):
                if board[i][j] == word[0] and dfs(i,j,0):
                    return True
        return False
