from typing import List


class Solution:
    def resultArray(self, nums: List[int], k: int) -> List[int]:
        """
        3524. Find X Value of Array I
        Time: O(n * k)
        Space: O(k)
        """
        result = [0] * k
        # cnt[x] = number of subarrays ending at the current index with
        # product % k == x
        cnt = [0] * k

        for v in nums:
            m = v % k
            nxt = [0] * k
            for x in range(k):
                if cnt[x]:
                    nxt[x * m % k] += cnt[x]
            nxt[m] += 1  # the one-element subarray [v]

            for x in range(k):
                result[x] += nxt[x]
            cnt = nxt

        return result
