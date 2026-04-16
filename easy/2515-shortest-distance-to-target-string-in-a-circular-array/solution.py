from typing import List


class Solution:
    def closetTarget(self, words: List[str], target: str, startIndex: int) -> int:
        """
        2515. Shortest Distance to Target String in a Circular Array
        Time: O(n)
        Space: O(1)
        """
        n = len(words)
        min_dist = float('inf')

        for i, word in enumerate(words):
            if word == target:
                clockwise = (i - startIndex + n) % n
                counter_clockwise = n - clockwise
                min_dist = min(min_dist, clockwise, counter_clockwise)

        return min_dist if min_dist != float('inf') else -1
