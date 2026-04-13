CREATE OR REPLACE PROCEDURE refresh_accommodation_view()
LANGUAGE plpgsql
AS $$
BEGIN
    REFRESH MATERIALIZED VIEW accommodation_stats;
END;
$$;