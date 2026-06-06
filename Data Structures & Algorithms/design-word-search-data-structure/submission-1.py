class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.end = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        cur = self.root
        for char in word:
            index = ord(char) - ord("a")
            if cur.children[index] == None:
                cur.children[index] = TrieNode()
            cur = cur.children[index]
        cur.end = True
        

    def search(self, word: str) -> bool:
        def dfs(index,node):
            if node is None:
                return False
            
            if index == len(word):
                return node.end

            char = word[index]
            if char == '.':
                for i in range(26):
                    if node.children[i] != None and dfs(index + 1, node.children[i]):
                        return True
                return False
            else:
                i = ord(char) - ord("a")
                return dfs(index + 1, node.children[i])
        return dfs(0,self.root)
        
