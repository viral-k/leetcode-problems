class Solution:
    def minimumDistance(self, word: str) -> int:
        """
        1320. Minimum Distance to Type a Word Using Two Fingers
        Time: O(n × 27)
        Space: O(27)
        """
        def pos(c):
            idx = ord(c) - ord('A')
            return (idx // 6, idx % 6)

        def dist(c1, c2):
            if c1 == 26:  # finger not yet placed
                return 0
            p1 = (c1 // 6, c1 % 6)
            p2 = (c2 // 6, c2 % 6)
            return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])

        # dp[j] = min cost where other finger is at letter j (26 = not placed)
        dp = [float('inf')] * 27
        dp[26] = 0  # initially, other finger is free

        prev = ord(word[0]) - ord('A')
        # First character: one finger goes there for free
        # dp stays the same, prev = first letter

        for i in range(1, len(word)):
            curr = ord(word[i]) - ord('A')
            new_dp = [float('inf')] * 27

            for j in range(27):
                if dp[j] == float('inf'):
                    continue

                # Option 1: Use finger that was at prev
                cost1 = dp[j] + dist(prev, curr)
                new_dp[j] = min(new_dp[j], cost1)

                # Option 2: Use finger that was at j (other finger)
                cost2 = dp[j] + dist(j, curr)
                new_dp[prev] = min(new_dp[prev], cost2)

            dp = new_dp
            prev = curr

        return min(dp)
