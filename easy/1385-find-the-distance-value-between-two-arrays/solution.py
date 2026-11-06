from bisect import bisect_left


class Solution:
    def findTheDistanceValue(self, arr1: list[int], arr2: list[int], d: int) -> int:
        """
        1385. Find the Distance Value Between Two Arrays
        Time: O((n + m) log m)
        Space: O(m)
        """
        arr2 = sorted(arr2)
        m = len(arr2)
        count = 0
        for x in arr1:
            # x counts when no arr2 value lies in [x - d, x + d].
            i = bisect_left(arr2, x - d)
            if i == m or arr2[i] > x + d:
                count += 1
        return count
