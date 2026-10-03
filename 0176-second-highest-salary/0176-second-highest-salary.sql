# Write your MySQL query statement below
Select MAX(SALARY) AS secondhighestsalary 
from employee
where salary < (select max(salary) from employee);