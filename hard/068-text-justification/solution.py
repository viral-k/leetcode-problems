from typing import List


class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        """
        68. Text Justification
        Time: O(total characters)
        Space: O(maxWidth) excluding the output
        """
        result = []
        line = []          # words on the current line
        line_len = 0       # total word length, excluding spaces

        def flush(words_on_line: List[str], total: int, last: bool) -> str:
            if last or len(words_on_line) == 1:
                # last line and single-word lines are left-justified
                text = " ".join(words_on_line)
                return text + " " * (maxWidth - len(text))

            gaps = len(words_on_line) - 1
            base, extra = divmod(maxWidth - total, gaps)
            parts = []
            for i, w in enumerate(words_on_line[:-1]):
                # the leftmost `extra` gaps take one additional space
                parts.append(w)
                parts.append(" " * (base + (1 if i < extra else 0)))
            parts.append(words_on_line[-1])
            return "".join(parts)

        for word in words:
            # len(line) accounts for one mandatory space before each new word
            if line and line_len + len(line) + len(word) > maxWidth:
                result.append(flush(line, line_len, last=False))
                line, line_len = [], 0
            line.append(word)
            line_len += len(word)

        result.append(flush(line, line_len, last=True))
        return result
