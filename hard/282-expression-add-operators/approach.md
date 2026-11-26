# Approach

**Tags:** `Math`, `String`, `Backtracking`

## Intuition

With at most 10 digits there are only `4^9` ways to fill the 9 gaps (`+`, `-`, `*`, or no operator), so trying them all is fine. What matters is evaluating each expression as it's built, instead of parsing it again at the end.

`+` and `-` are easy: add or subtract the next operand. `*` binds tighter, so it applies to the last term, not to the whole value. If the running value is `value` and the last term added was `last` (with its sign), then multiplying by `x` turns `value` into `value - last + last * x`, and the new last term is `last * x`. This also works for chains like `2 + 3 * 4 * 5`, because `last` keeps growing through the products.

## Approach

1. `dfs(i, expr, value, last)` builds the expression from position `i` onward.
2. If `i == n`, record `expr` when `value == target`.
3. Otherwise try each operand `x = num[i:j]` for `j = i + 1 .. n`, stopping after one digit if `num[i] == '0'`:
   - at `i == 0`, start with `expr = x`, `value = x`, `last = x`
   - otherwise branch into `+x` (`last = x`), `-x` (`last = -x`) and `*x` (`value - last + last * x`, `last = last * x`)
4. Java builds the expression in one `char[]` buffer and uses `long`, because a 10-digit operand doesn't fit in an `int`.

## Complexity

- **Time:** O(n · 4^n). There are at most `4^(n-1)` expressions, and each costs O(n) to build into a string.
- **Space:** O(n) for the recursion and the expression buffer, plus the output

## Edge Cases

- Leading zeros: `"105", 5` gives `1*0+5` and `10-5`, but never `1*05`. A lone `0` is still a valid operand.
- All zeros: `"000", 0` gives all 9 combinations of operators, since every operand has to be `0` itself
- One digit: the only expression is the digit itself
- Large operands: `"9999999999"` exceeds `2^31 - 1`, and products like `99999 * 99999` don't fit in an `int` either
- Negative targets: `"10", -1` gives nothing (`1-0 = 1`), while `"12", -1` gives `1-2`
- Expressions are recorded only at the end of the string, so every digit is used
