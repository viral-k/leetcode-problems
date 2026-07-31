from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        """
        17. Letter Combinations of a Phone Number
        Time: O(4^n * n)
        Space: O(n) recursion depth (excluding output)
        """
        if not digits:
            return []

        mapping = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz",
        }

        result = []

        def backtrack(idx: int, path: List[str]) -> None:
            if idx == len(digits):
                result.append("".join(path))
                return
            for ch in mapping[digits[idx]]:
                path.append(ch)
                backtrack(idx + 1, path)
                path.pop()

        backtrack(0, [])
        return result
