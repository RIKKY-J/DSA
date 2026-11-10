# Write your MySQL query statement below
select e.employee_id , e.name, count(*) as reports_count, round(avg(m.age)) average_age
FROM Employees e
JOIN Employees m on e.employee_id = m.reports_to
group by e.employee_id , e.name
order by e.employee_id