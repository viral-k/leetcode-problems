class Solution:
    def numOfSubarrays(self, arr: list[int]) -> int:
        """
        1524. Number of Sub-arrays With Odd Sum
        Time: O(n)
        Space: O(1)
        """
        MOD = 10**9 + 7
        # Prefix sums seen so far, by parity. The empty prefix (sum 0) is even.
        even, odd = 1, 0
        parity = 0
        ans = 0
        for x in arr:
            parity ^= x & 1
            # A subarray ending here is odd iff its start prefix has the
            # opposite parity to the current one.
            if parity:
                ans += even
                odd += 1
            else:
                ans += odd
                even += 1
        return ans % MOD
