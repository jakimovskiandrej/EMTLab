CREATE TABLE accommodations (
                                id BIGSERIAL PRIMARY KEY,
                                name VARCHAR(100) NOT NULL,
                                category VARCHAR(20),
                                status VARCHAR(20),
                                host_id BIGINT REFERENCES hosts(id),
                                num_rooms INTEGER NOT NULL,
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);