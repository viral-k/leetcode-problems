class Solution:
    def sortableIntegers(self, nums: list[int]) -> int:
        """
        3886. Sum of Sortable Integers
        Time: O(n + sigma(n))
        Space: O(n)
        """
        n = len(nums)

        # suf_min[m] = min(nums[m:]), so suf_min[n] is +infinity
        suf_min = [0] * (n + 1)
        suf_min[n] = float("inf")
        for i in range(n - 1, -1, -1):
            suf_min[i] = nums[i] if nums[i] < suf_min[i + 1] else suf_min[i + 1]

        # breakpoint[m]: the first m elements are the m smallest, which holds
        # exactly when max(nums[:m]) <= min(nums[m:])
        breakpoint_at = [False] * (n + 1)
        run_max = 0
        for m in range(1, n + 1):
            if nums[m - 1] > run_max:
                run_max = nums[m - 1]
            breakpoint_at[m] = run_max <= suf_min[m]

        # desc[i] = number of j in 1..i with nums[j-1] > nums[j], so the
        # descents strictly inside [l, r) are desc[r-1] - desc[l]
        desc = [0] * n
        for i in range(1, n):
            desc[i] = desc[i - 1] + (nums[i - 1] > nums[i])

        divisors = []
        d = 1
        while d * d <= n:
            if n % d == 0:
                divisors.append(d)
                if d != n // d:
                    divisors.append(n // d)
            d += 1

        total = 0
        for k in divisors:
            for l in range(0, n, k):
                r = l + k
                if not breakpoint_at[r]:
                    break
                # a block is rotatable into sorted order iff it has at most
                # one cyclic descent
                cyclic = desc[r - 1] - desc[l] + (nums[r - 1] > nums[l])
                if cyclic > 1:
                    break
            else:
                total += k

        return total
