class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.end = False

    

class PrefixTree:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        cur = self.root
        for char in word:
            i = ord(char) - ord("a")
            if  cur.children[i] == None:
                cur.children[i] = TrieNode()
            cur = cur.children[i]
        cur.end = True


    def search(self, word: str) -> bool:
        cur = self.root
        for char in word:
            i = ord(char) - ord("a")
            if cur.children[i] == None:
                return False

            cur = cur.children[i]
        return cur.end

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for char in prefix:
            i = ord(char) - ord("a")
            if cur.children[i] == None:
                return False
            cur = cur.children[i]
        return True
        
        