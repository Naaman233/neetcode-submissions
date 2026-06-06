class TrieNode:
    def __init__(self):
        self.branches = {}
        self.end = False


class PrefixTree:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        cur = self.root
        for char in word:
            if char not in cur.branches:
                cur.branches[char] = TrieNode()
            cur = cur.branches[char]
        cur.end = True
        

    def search(self, word: str) -> bool:
        cur = self.root
        for char in word:
            if char not in cur.branches:
                return False
            cur = cur.branches[char]
        return cur.end
        

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for char in prefix:
            if char not in cur.branches:
                return False
            cur = cur.branches[char]
        return True
        
        