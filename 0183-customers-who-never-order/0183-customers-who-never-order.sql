# Write your MySQL query statement below
select name As customers
FROM customers a
LEFT JOIN orders b 
ON a.id = b.customerid
WHERE b.customerid is null;
