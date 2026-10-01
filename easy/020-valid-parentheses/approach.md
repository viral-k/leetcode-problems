# Approach

**Tags:** `String`, `Stack`

## Intuition

Brackets must close in reverse order of opening, which is exactly last-in-first-out, so a stack is the natural structure. Push each opener. When a closer arrives, the only bracket it is allowed to match is the most recent unclosed opener, i.e. the top of the stack. If the top is the wrong type, or there is nothing on the stack at all, the string is invalid.

The three rules in the statement map onto three failure conditions: wrong type on top, empty stack on a closer, and a non-empty stack at the end.

## Approach

1. Keep a map from each closing bracket to its opening bracket.
2. For each character:
   - not in the map → it is an opener, push it
   - in the map → fail if the stack is empty or its top is not the expected opener; otherwise pop
3. Return true only if the stack ends empty.

## Complexity

- **Time:** O(n)
- **Space:** O(n) in the worst case, e.g. all openers

## Edge Cases

- Odd length → always invalid; the stack logic catches it without a special check
- A lone closer `")"` → the stack is empty when it arrives
- A lone opener `"("` → the stack is non-empty at the end
- Right count, wrong type: `"(]"` → top is `(` but `]` expects `[`
- Right types, wrong order: `"([)]"` → when `)` arrives the top is `[`
- All openers `"((((("` → the stack grows to `n`, which is the space worst case
