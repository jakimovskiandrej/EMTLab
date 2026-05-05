INSERT INTO countries (name, continent, created_at, updated_at) VALUES
    ('Macedonia', 'Europe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Serbia', 'Europe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Greece', 'Europe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Albania', 'Europe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Bulgaria', 'Europe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Italy', 'Europe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('France', 'Europe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Spain', 'Europe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Germany', 'Europe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Switzerland', 'Europe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO hosts (name, surname, country_id, created_at, updated_at) VALUES
    ('Marko', 'Markovic', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Petar', 'Petrovic', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Nikola', 'Nikolic', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Ana', 'Anic', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Ivan', 'Ivanovic', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Elena', 'Elenovic', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Marco', 'Rossi', 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Sophie', 'Martin', 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Carlos', 'Garcia', 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Hans', 'Mueller', 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO accommodations (name, category, status, host_id, num_rooms, total_rents, created_at, updated_at) VALUES
    ('Luxury Apartment Downtown', 'APARTMENT', 'GOOD', 1, 5, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Cozy Studio', 'ROOM', 'GOOD', 2, 2, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Beach House', 'HOUSE', 'GOOD', 3, 8, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Mountain Cabin', 'HOUSE', 'GOOD', 4, 4, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('City Center Loft', 'FLAT', 'BAD', 5, 3, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Countryside Villa', 'HOUSE', 'GOOD', 6, 10, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Modern Penthouse', 'APARTMENT', 'GOOD', 7, 6, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Charming Cottage', 'HOUSE', 'GOOD', 8, 3, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Beachfront Condo', 'FLAT', 'GOOD', 9, 4, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Historic Manor', 'HOUSE', 'BAD', 10, 7, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reviews (comment, rating, accommodation_id, created_at, updated_at) VALUES
    ('Amazing place, highly recommended!', 5, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Great location and friendly host', 4, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Very comfortable and clean', 5, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Perfect for a beach vacation', 5, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Beautiful views, wonderful experience', 4, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Peaceful and relaxing environment', 4, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Good value for money', 4, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Luxurious and elegant', 5, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Excellent service and amenities', 5, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Cozy and intimate setting', 4, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Outstanding experience, will return', 5, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Historical charm with modern comfort', 4, 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Spacious and well-equipped', 5, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Great for families', 4, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Perfect hideaway', 5, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);