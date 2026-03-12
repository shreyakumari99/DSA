WITH first_login AS (
    SELECT 
        player_id,
        MIN(event_date) AS first_date
    FROM 
        Activity
    GROUP BY 
        player_id
)
SELECT 
    ROUND(
        COUNT(DISTINCT CASE WHEN a.event_date = fl.first_date + INTERVAL 1 DAY THEN fl.player_id END) / 
        COUNT(DISTINCT fl.player_id), 
        2
    ) AS fraction
FROM 
    first_login fl
LEFT JOIN 
    Activity a ON fl.player_id = a.player_id;