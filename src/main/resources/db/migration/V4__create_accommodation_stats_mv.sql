CREATE MATERIALIZED VIEW accommodation_stats AS
SELECT
    c.name AS country,
    a.category,
    COUNT(a.id) AS total_accommodations,
    SUM(a.num_rooms) AS total_rooms,
    AVG(a.num_rooms) AS avg_rooms
FROM accommodations a
         JOIN hosts h ON a.host_id = h.id
         JOIN countries c ON h.country_id = c.id
GROUP BY c.name, a.category;