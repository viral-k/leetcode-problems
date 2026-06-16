class Solution:
    def processStr(self, s: str) -> str:
        """
        3612. Process String with Special Operations I
        Time: O(n * L)
        Space: O(L)
        """
        result = []

        for ch in s:
            if ch == "*":
                if result:
                    result.pop()
            elif ch == "#":
                result += result
            elif ch == "%":
                result.reverse()
            else:
                result.append(ch)

        return "".join(result)
