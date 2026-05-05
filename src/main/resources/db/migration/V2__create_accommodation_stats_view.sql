CREATE MATERIALIZED VIEW accommodation_stats AS
SELECT
    a.category,
    c.name as country,
    COUNT(DISTINCT a.id) as total_accommodations,
    SUM(a.num_rooms) as total_rooms,
    AVG(a.num_rooms)::DOUBLE PRECISION as avg_rooms
FROM accommodations a
    INNER JOIN hosts h ON a.host_id = h.id
    INNER JOIN countries c ON h.country_id = c.id
GROUP BY a.category, c.name;

CREATE INDEX idx_accommodation_stats_category ON accommodation_stats(category);
CREATE INDEX idx_accommodation_stats_country ON accommodation_stats(country);