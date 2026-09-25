# Approach

**Tags:** `String`, `Backtracking`, `Stack`, `Breadth-First Search`

## Intuition

The grammar in the statement is already a parser specification, with the usual precedence: concatenation binds tighter than the comma. Writing it as three mutually recursive functions makes the two set operations fall out directly, one per production.

```
union  := concat (',' concat)*      -> set union of the parts
concat := term+                     -> pairwise concatenation (cartesian product)
term   := letter | '{' union '}'    -> singleton, or recurse
```

Using a `set` at every level means duplicates collapse the moment they appear, so `{{a,b},{b,c}}` needs no extra work, and neither does the repeated `a` in Example 2.

## Approach

Carry a single mutable index into the expression.

1. `parse_union`: parse a `concat`, then while the next character is `,`, consume it and parse another `concat`, unioning the results.
2. `parse_concat`: start from `{""}` and, while the next character is neither `,` nor `}` nor end of input, parse a `term` and replace the accumulator with `{a + b}` over the cross product.
3. `parse_term`: on `{`, consume it, `parse_union`, consume the matching `}`. Otherwise consume one letter and return a singleton.
4. Call `parse_union` at index 0 and return the sorted result.

Because `parse_concat` halts on `,` and `}`, the caller always sees those delimiters and the recursion stays in step with the braces without any explicit depth counter.

## Complexity

- **Time:** O(total output size * word length) — each parse step touches one character, and the set products build the words
- **Space:** O(total output size)

With 60 input characters, the widest output comes from repeated small alternation blocks: `{a,b,c}` is 7 characters, so 8 of them give `3^8 = 6561` words. Nothing here explodes.

## Edge Cases

- A bare letter, `"a"` → `["a"]`, no braces at all
- Nested unions inside a concatenation, `"{a,b}{c,{d,e}}"` (Example 1)
- Duplicates arising from different branches, `"{{a,z},a{b,c},{ab,z}}"` (Example 2)
- Words of differing lengths in the same union (`a` and `ab` in Example 2); sorting is plain lexicographic, so `"a"` precedes `"ab"`
- A union nested immediately inside another, `"{{a,b}}"` → `["a","b"]`
- `parse_concat` must seed with the single empty string rather than an empty set, or the product with the first term would collapse to nothing
