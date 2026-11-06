from collections import deque


class Solution:
    def maxSlidingWindow(self, nums: list[int], k: int) -> list[int]:
        """
        239. Sliding Window Maximum
        Time: O(n)
        Space: O(k)
        """
        # Indices whose values strictly decrease from front to back. The front
        # is the current maximum.
        dq = deque()
        out = []
        for i, x in enumerate(nums):
            if dq and dq[0] == i - k:
                dq.popleft()
            # An older value <= x can never be a maximum again.
            while dq and nums[dq[-1]] <= x:
                dq.pop()
            dq.append(i)
            if i >= k - 1:
                out.append(nums[dq[0]])
        return out
