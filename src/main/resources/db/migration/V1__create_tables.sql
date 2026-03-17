CREATE TABLE countries (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    name VARCHAR(100) NOT NULL,
    continent VARCHAR(50) NOT NULL
);

CREATE TABLE hosts (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    country_id BIGINT NOT NULL REFERENCES countries(id)
);

CREATE TABLE accommodations (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    name VARCHAR(100) NOT NULL,
    category VARCHAR(20) NOT NULL,
    status VARCHAR(10) NOT NULL,
    host_id BIGINT NOT NULL REFERENCES hosts(id),
    num_rooms INT NOT NULL
);

CREATE TABLE reviews (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    comment TEXT,
    rating INT NOT NULL,
    accommodation_id BIGINT NOT NULL REFERENCES accommodations(id)
);