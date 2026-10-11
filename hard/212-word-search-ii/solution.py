from collections import Counter
from typing import Dict, List


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        """
        212. Word Search II
        Time: O(cells * 4 * 3^(L-1)) worst case, plus O(total word length) to build
        Space: O(total word length)
        """
        WORD = "$"
        rows, cols = len(board), len(board[0])

        # a word needing more of a letter than the board holds can never match
        available = Counter(ch for row in board for ch in row)
        candidates = [
            w for w in words
            if not (Counter(w) - available)
        ]

        trie: Dict = {}
        for word in candidates:
            node = trie
            for ch in word:
                node = node.setdefault(ch, {})
            node[WORD] = word

        found = []

        def dfs(r: int, c: int, parent: Dict) -> None:
            ch = board[r][c]
            node = parent[ch]

            word = node.pop(WORD, None)
            if word is not None:
                found.append(word)

            board[r][c] = "#"  # mark visited in place
            for dr, dc in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols and board[nr][nc] in node:
                    dfs(nr, nc, node)
            board[r][c] = ch

            # drop exhausted branches so later starts never revisit them
            if not node:
                del parent[ch]

        for r in range(rows):
            for c in range(cols):
                if board[r][c] in trie:
                    dfs(r, c, trie)

        return found
