from typing import List, Set


class Solution:
    def braceExpansionII(self, expression: str) -> List[str]:
        """
        1096. Brace Expansion II
        Time: O(total output size * word length)
        Space: O(total output size)
        """
        n = len(expression)
        self.pos = 0

        def parse_union() -> Set[str]:
            words = parse_concat()
            while self.pos < n and expression[self.pos] == ",":
                self.pos += 1  # skip ','
                words |= parse_concat()
            return words

        def parse_concat() -> Set[str]:
            words = {""}
            while self.pos < n and expression[self.pos] not in ",}":
                part = parse_term()
                words = {a + b for a in words for b in part}
            return words

        def parse_term() -> Set[str]:
            if expression[self.pos] == "{":
                self.pos += 1  # skip '{'
                words = parse_union()
                self.pos += 1  # skip '}'
                return words
            ch = expression[self.pos]
            self.pos += 1
            return {ch}

        return sorted(parse_union())
