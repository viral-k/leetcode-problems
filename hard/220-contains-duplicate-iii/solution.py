class Solution:
    def containsNearbyAlmostDuplicate(
        self, nums: list[int], indexDiff: int, valueDiff: int
    ) -> bool:
        """
        220. Contains Duplicate III
        Time: O(n)
        Space: O(min(n, indexDiff))
        """
        width = valueDiff + 1  # same bucket => difference at most valueDiff
        buckets = {}  # bucket id -> its single value, over the live window

        for i, v in enumerate(nums):
            if i > indexDiff:
                # keep the window at indices [i - indexDiff, i - 1]
                old = nums[i - indexDiff - 1]
                buckets.pop(old // width, None)

            b = v // width  # floors for negatives, which is what we need
            if b in buckets:
                return True
            # a value within valueDiff can only be in an adjacent bucket, and
            # bucket b-1 holds values below b * width <= v, so no abs needed
            if b - 1 in buckets and v - buckets[b - 1] <= valueDiff:
                return True
            if b + 1 in buckets and buckets[b + 1] - v <= valueDiff:
                return True

            buckets[b] = v

        return False
