# Write your MySQL query statement below
SELECT euni.unique_id,e.name
from employees e
LEFT JOIN EmployeeUNI euni
ON e.id = euni.id