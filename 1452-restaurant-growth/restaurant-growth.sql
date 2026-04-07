# Write your MySQL query statement below
SELECT 
    c1.visited_on,
    SUM(c2.amount) AS amount,
    ROUND(SUM(c2.amount) / 7, 2) AS average_amount
FROM 
    (
        SELECT 
            DISTINCT visited_on
        FROM 
            Customer
        WHERE 
            visited_on >= (SELECT MIN(visited_on) + INTERVAL 6 DAY FROM Customer)
    ) c1
JOIN 
    Customer c2 ON c2.visited_on BETWEEN c1.visited_on - INTERVAL 6 DAY AND c1.visited_on
GROUP BY 
    c1.visited_on
ORDER BY 
    c1.visited_on;