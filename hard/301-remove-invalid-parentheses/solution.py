from typing import List


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        """
        301. Remove Invalid Parentheses
        Time: O(product of run lengths), far below 2^p after the budget prunes
        Space: O(n) recursion depth plus the output
        """
        # the exact removal budget: unmatchable ')' and leftover '('
        extra_open = extra_close = 0
        for ch in s:
            if ch == "(":
                extra_open += 1
            elif ch == ")":
                if extra_open > 0:
                    extra_open -= 1
                else:
                    extra_close += 1

        n = len(s)
        results = set()

        def dfs(i: int, balance: int, rem_open: int, rem_close: int, built: str) -> None:
            if i == n:
                # both budgets must be spent exactly, or we removed too many
                if balance == 0 and rem_open == 0 and rem_close == 0:
                    results.add(built)
                return

            ch = s[i]
            if ch != "(" and ch != ")":
                dfs(i + 1, balance, rem_open, rem_close, built + ch)
                return

            # removing the 2nd of "((" gives the same string as removing the
            # 1st, so branch on *how many* to drop from each run of identical
            # brackets rather than on which ones
            end = i
            while end < n and s[end] == ch:
                end += 1
            run = end - i
            budget = rem_open if ch == "(" else rem_close

            for drop in range(min(run, budget) + 1):
                keep = run - drop
                if ch == "(":
                    dfs(end, balance + keep, rem_open - drop, rem_close,
                        built + "(" * keep)
                elif balance >= keep:
                    dfs(end, balance - keep, rem_open, rem_close - drop,
                        built + ")" * keep)

        dfs(0, 0, extra_open, extra_close, "")
        return list(results)
