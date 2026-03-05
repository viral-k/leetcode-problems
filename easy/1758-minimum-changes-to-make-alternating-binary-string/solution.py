class Solution:
    def minOperations(self, s: str) -> int:
        """
        1758. Minimum Changes To Make Alternating Binary String
        Time: O(n)
        Space: O(1)
        """
        change_start0 = 0
        change_start1 = 0

        for i, ch in enumerate(s):
            if i % 2 == 0:
                if ch != '0':
                    change_start0 += 1
                if ch != '1':
                    change_start1 += 1
            else:
                if ch != '1':
                    change_start0 += 1
                if ch != '0':
                    change_start1 += 1

        return min(change_start0, change_start1)
