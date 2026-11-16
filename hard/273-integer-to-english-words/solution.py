class Solution:
    def numberToWords(self, num: int) -> str:
        """
        273. Integer to English Words
        Time: O(1), at most 4 chunks of 3 digits
        Space: O(1)
        """
        if num == 0:
            return "Zero"

        ones = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
                "Eighty", "Ninety"]
        scales = ["", "Thousand", "Million", "Billion"]

        def chunk(n: int) -> list[str]:
            # Words for 1 <= n <= 999. Empty strings are filtered out later.
            hundreds, rest = divmod(n, 100)
            words = [ones[hundreds], "Hundred"] if hundreds else []
            if rest < 20:
                words.append(ones[rest])
            else:
                words += [tens[rest // 10], ones[rest % 10]]
            return words

        words = []
        for scale in range(3, -1, -1):
            n = num // 1000**scale % 1000
            if n:  # a zero chunk adds nothing, not even its scale word
                words += chunk(n) + [scales[scale]]
        return " ".join(w for w in words if w)
