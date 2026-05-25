class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        """
        1871. Jump Game VII
        Time: O(n)
        Space: O(n)
        """
        n = len(s)
        reachable = [False] * n
        reachable[0] = True
        reachable_count = 0

        for index in range(1, n):
            add_index = index - minJump
            if add_index >= 0 and reachable[add_index]:
                reachable_count += 1

            remove_index = index - maxJump - 1
            if remove_index >= 0 and reachable[remove_index]:
                reachable_count -= 1

            reachable[index] = s[index] == "0" and reachable_count > 0

        return reachable[-1]
