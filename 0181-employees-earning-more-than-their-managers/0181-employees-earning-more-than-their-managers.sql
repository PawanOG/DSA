# Write your MySQL query statement below
SELECT e.name as employee
from employee e
Join employee m
ON e.managerId = m.id
where e.salary>m.salary