class Solution:
    def maximizeSquareHoleArea(self, n: int, m: int, hBars: list[int], vBars: list[int]) -> int:
        """
        2943. Maximize Area of Square Hole in Grid
        Time: O(h log h + v log v)
        Space: O(1)
        """
        def max_gap(arr: list[int]) -> int:
            arr.sort()
            longest = 1
            curr = 1
            
            for i in range(1, len(arr)):
                if arr[i] == arr[i - 1] + 1:
                    curr += 1
                else:
                    longest = max(longest, curr)
                    curr = 1
            
            longest = max(longest, curr)
            return longest + 1
        
        max_h = max_gap(hBars)
        max_v = max_gap(vBars)
        
        side = min(max_h, max_v)
        return side * side
