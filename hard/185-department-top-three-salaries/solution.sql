-- 185. Department Top Three Salaries
-- Time: O(n log n) for the partitioned sort
-- Space: O(n)

SELECT
    d.name AS Department,
    r.name AS Employee,
    r.salary AS Salary
FROM (
    -- DENSE_RANK, not RANK: tied salaries share a rank without consuming
    -- the ranks below them, which is what "top three unique salaries" means
    SELECT
        name,
        salary,
        departmentId,
        DENSE_RANK() OVER (
            PARTITION BY departmentId
            ORDER BY salary DESC
        ) AS salary_rank
    FROM Employee
) AS r
JOIN Department AS d
    ON d.id = r.departmentId
WHERE r.salary_rank <= 3;
