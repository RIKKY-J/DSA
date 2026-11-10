# Write your MySQL query statement below
SELECT MAX(num) as num FROM MyNumbers
WHERE num IN (
    SELECT num
    FROM MyNumbers
    Group By num
    Having COUNT(*) = 1
)