class Solution:
    def isNumber(self, s: str) -> bool:
        """
        65. Valid Number
        Time: O(n)
        Space: O(1)
        """
        seen_digit = False
        seen_dot = False
        seen_exp = False

        for i, ch in enumerate(s):
            if ch.isdigit():
                seen_digit = True
            elif ch in "+-":
                # a sign is only legal at the start or right after e/E
                if i > 0 and s[i - 1] not in "eE":
                    return False
            elif ch == ".":
                # the exponent must be an integer, so no dot after e/E
                if seen_dot or seen_exp:
                    return False
                seen_dot = True
            elif ch in "eE":
                if seen_exp or not seen_digit:
                    return False
                seen_exp = True
                seen_digit = False  # the exponent needs digits of its own
            else:
                return False

        return seen_digit
