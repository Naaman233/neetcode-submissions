class TrieNode:
    def __init__(self):
        self.branches = {}
        self.end = False
        self.word = None

    def insert_word(self, word):
        root = self
        for char in word:
            if char not in root.branches:
                root.branches[char] = TrieNode()
            root = root.branches[char]
        root.end = True
        root.word = word
    

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = TrieNode()
        for word in words:
            trie.insert_word(word)
        ROWS,COLS = len(board) , len(board[0])
        res = set()
        def dfs(row, col, node):

            if row < 0 or row >= ROWS or col < 0 or col >= COLS or board[row][col] not in node.branches or board[row][col] == "#":
                return 

            char = board[row][col]
            cur = node.branches[char]

            if cur.end:
                res.add(cur.word)
                cur.word = None
                cur.end = False

            temp = board[row][col]
            board[row][col] = "#"

            directions = [(-1,0),(1,0),(0,1),(0,-1)]
            for next_row,next_col in directions:
                dfs(row + next_row, col + next_col, cur)
            board[row][col] = temp
        for i in range(ROWS):
            for j in range(COLS):
                if board[i][j] in trie.branches:
                    dfs(i,j,trie)
        return list(res)




        