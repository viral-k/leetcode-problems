from typing import List


class Solution:
    def evaluate(self, s: str, knowledge: List[List[str]]) -> str:
        """
        1807. Evaluate the Bracket Pairs of a String
        Time: O(n + m)
        Space: O(n + m)
        """
        lookup = {key: value for key, value in knowledge}

        parts = []
        key_chars = []
        in_key = False

        for ch in s:
            if ch == "(":
                in_key = True
                key_chars.clear()
            elif ch == ")":
                in_key = False
                parts.append(lookup.get("".join(key_chars), "?"))
            elif in_key:
                key_chars.append(ch)
            else:
                parts.append(ch)

        return "".join(parts)
