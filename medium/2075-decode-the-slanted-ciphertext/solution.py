class Solution:
    def decodeCiphertext(self, encodedText: str, rows: int) -> str:
        """
        2075. Decode the Slanted Ciphertext
        Time: O(n)
        Space: O(n)
        """
        if not encodedText:
            return ""

        cols = len(encodedText) // rows
        result = []

        for start_col in range(cols):
            row, col = 0, start_col
            while row < rows and col < cols:
                result.append(encodedText[row * cols + col])
                row += 1
                col += 1

        return ''.join(result).rstrip()
