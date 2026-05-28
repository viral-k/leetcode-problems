from typing import List


class Solution:
    def stringIndices(self, wordsContainer: List[str], wordsQuery: List[str]) -> List[int]:
        """
        3093. Longest Common Suffix Queries
        Time: O(total container length + total query length)
        Space: O(total container length)
        """
        children = [{}]
        best_index = [-1]
        best_length = [float("inf")]

        def update_best(node: int, word_index: int, word_length: int) -> None:
            if word_length < best_length[node] or (
                word_length == best_length[node] and word_index < best_index[node]
            ):
                best_length[node] = word_length
                best_index[node] = word_index

        for index, word in enumerate(wordsContainer):
            node = 0
            word_length = len(word)
            update_best(node, index, word_length)

            for char in reversed(word):
                if char not in children[node]:
                    children[node][char] = len(children)
                    children.append({})
                    best_index.append(-1)
                    best_length.append(float("inf"))
                node = children[node][char]
                update_best(node, index, word_length)

        answer = []
        for query in wordsQuery:
            node = 0
            result = best_index[node]

            for char in reversed(query):
                if char not in children[node]:
                    break
                node = children[node][char]
                result = best_index[node]

            answer.append(result)

        return answer
