# Approach

**Tags:** `Database`

## Intuition

"Top three unique salaries" is the whole problem, and it decides which ranking function to use.

Ranking per department is a window function over a partition. The three candidates differ exactly on ties:

- `ROW_NUMBER()` gives every row a distinct number, so two employees on the same salary get different ranks and one of them is arbitrarily cut. Wrong.
- `RANK()` gives ties the same number but then skips ahead, so after two employees tied at rank 2 the next distinct salary is rank 4 and gets excluded. Wrong.
- `DENSE_RANK()` gives ties the same number and does not skip, so the next distinct salary is rank 3. That is the definition of "third-highest unique salary".

The example is built to catch this. In IT the salaries are 90000, 85000, 85000, 70000, 69000. `DENSE_RANK` assigns 1, 2, 2, 3, 4, so Will at 70000 is included and Janet at 69000 is not. `RANK` would assign 1, 2, 2, 4, 5 and drop Will.

After ranking, the join to `Department` only supplies the department name.

## Approach

1. In a subquery over `Employee`, compute `DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC)`.
2. Join the result to `Department` on `departmentId = Department.id`.
3. Keep rows with rank `<= 3` and project the three required aliases: `Department`, `Employee`, `Salary`.

The filter has to sit outside the window computation, since window functions cannot appear in a `WHERE` clause. A subquery (or a CTE) is what makes the rank available to filter on.

## Complexity

- **Time:** O(n log n) — the window function sorts within each partition
- **Space:** O(n) for the intermediate ranked set

## Edge Cases

- A department with fewer than three employees returns all of them, with no padding (Sales in the example)
- Ties on the top salary: all tied employees are returned and they occupy one rank
- Several distinct salaries tied at rank 3 all qualify, so a department can return more than three rows
- A department with no employees produces no rows, since the join starts from `Employee`
- An employee whose `departmentId` has no matching department is dropped by the inner join
- Column aliases must be exactly `Department`, `Employee`, `Salary`; the grader checks names
- Requires window function support, so MySQL 8.0 or later
