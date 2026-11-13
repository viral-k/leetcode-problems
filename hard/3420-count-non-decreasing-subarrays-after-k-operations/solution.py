from collections import deque
from typing import List


class Solution:
    def countNonDecreasingSubarrays(self, nums: List[int], k: int) -> int:
        """
        3420. Count Non-Decreasing Subarrays After K Operations
        Time: O(n)
        Space: O(n)
        """
        n = len(nums)
        # Window nums[l..r] split into blocks, left to right. A block [value, count]
        # is a run of count elements whose prefix max (from l) is value. Values
        # strictly increase from front to back.
        blocks = deque()
        cost = 0  # sum of (prefix max - nums[i]) over the window
        r = n - 1
        ans = 0

        for l in range(n - 1, -1, -1):
            # nums[l] becomes the prefix max of every block it is >= to.
            count = 1
            while blocks and blocks[0][0] <= nums[l]:
                value, c = blocks.popleft()
                cost += (nums[l] - value) * c
                count += c
            blocks.appendleft([nums[l], count])

            # Too expensive: drop elements from the right. nums[r] is in the
            # last block, and leaving takes its (value - nums[r]) with it.
            while cost > k:
                cost -= blocks[-1][0] - nums[r]
                blocks[-1][1] -= 1
                if blocks[-1][1] == 0:
                    blocks.pop()
                r -= 1

            ans += r - l + 1

        return ans
