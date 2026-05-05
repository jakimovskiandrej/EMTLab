CREATE OR REPLACE FUNCTION refresh_accommodation_stats()
RETURNS void AS $$
BEGIN
    REFRESH MATERIALIZED VIEW CONCURRENTLY accommodation_stats;
END;
$$ LANGUAGE plpgsql;