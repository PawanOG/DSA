# Write your MySQL query statement below
SELECT e.name as employee
from employee e
JOIN employee m
    ON e.managerId = m.id
where e.salary>m.salary;