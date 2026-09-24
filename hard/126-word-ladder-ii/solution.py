from collections import defaultdict
from string import ascii_lowercase
from typing import List


class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        """
        126. Word Ladder II
        Time: O(n * L * 26) for the BFS, plus the output size
        Space: O(n * L)
        """
        unvisited = set(wordList)
        if endWord not in unvisited:
            return []
        unvisited.discard(beginWord)

        parents = defaultdict(list)
        level = {beginWord}
        found = False

        while level and not found:
            discovered = set()
            for word in level:
                for i in range(len(word)):
                    prefix, suffix = word[:i], word[i + 1:]
                    for ch in ascii_lowercase:
                        if ch == word[i]:
                            continue
                        nxt = prefix + ch + suffix
                        if nxt in unvisited:
                            discovered.add(nxt)
                            # only shortest-path edges land here, since nxt is
                            # still unvisited and so sits on the next level
                            parents[nxt].append(word)
                            if nxt == endWord:
                                found = True
            # remove after the whole level, so every parent gets recorded
            unvisited -= discovered
            level = discovered

        if not found:
            return []

        result = []
        path = [endWord]

        def backtrack(word: str) -> None:
            if word == beginWord:
                result.append(path[::-1])
                return
            for prev in parents[word]:
                path.append(prev)
                backtrack(prev)
                path.pop()

        backtrack(endWord)
        return result
