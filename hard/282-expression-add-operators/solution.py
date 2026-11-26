class Solution:
    def addOperators(self, num: str, target: int) -> list[str]:
        """
        282. Expression Add Operators
        Time: O(n * 4^n)
        Space: O(n) besides the output
        """
        n = len(num)
        out = []

        # value: the expression so far. last: its final term with sign, so a
        # '*' can take it back out and put back last * x.
        def dfs(i: int, expr: str, value: int, last: int) -> None:
            if i == n:
                if value == target:
                    out.append(expr)
                return
            for j in range(i + 1, n + 1):
                if j > i + 1 and num[i] == '0':
                    break  # no operands with leading zeros
                s = num[i:j]
                x = int(s)
                if i == 0:
                    dfs(j, s, x, x)
                else:
                    dfs(j, expr + '+' + s, value + x, x)
                    dfs(j, expr + '-' + s, value - x, -x)
                    dfs(j, expr + '*' + s, value - last + last * x, last * x)

        dfs(0, "", 0, 0)
        return out
