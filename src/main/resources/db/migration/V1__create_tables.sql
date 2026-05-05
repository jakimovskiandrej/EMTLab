CREATE TABLE countries (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        continent VARCHAR(255) NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_countries_name ON countries(name);
CREATE INDEX idx_countries_continent ON countries(continent);

CREATE TABLE hosts (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        surname VARCHAR(255) NOT NULL,
        country_id BIGINT REFERENCES countries(id) ON DELETE SET NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_hosts_country_id ON hosts(country_id);
CREATE INDEX idx_hosts_name_surname ON hosts(name, surname);

CREATE TABLE accommodations (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        category VARCHAR(50),
        status VARCHAR(50),
        host_id BIGINT NOT NULL REFERENCES hosts(id) ON DELETE CASCADE,
        num_rooms INTEGER NOT NULL,
        total_rents INTEGER,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_accommodations_host_id ON accommodations(host_id);
CREATE INDEX idx_accommodations_category ON accommodations(category);
CREATE INDEX idx_accommodations_status ON accommodations(status);
CREATE INDEX idx_accommodations_name ON accommodations(name);

CREATE TABLE reviews (
        id BIGSERIAL PRIMARY KEY,
        comment TEXT,
        rating INTEGER NOT NULL,
        accommodation_id BIGINT NOT NULL REFERENCES accommodations(id) ON DELETE CASCADE,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_reviews_accommodation_id ON reviews(accommodation_id);
CREATE INDEX idx_reviews_rating ON reviews(rating);

CREATE TABLE users (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        surname VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL UNIQUE,
        username VARCHAR(255) UNIQUE,
        password VARCHAR(255),
        role VARCHAR(50),
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_role ON users(role);

CREATE TABLE accommodation_activities (
        id BIGSERIAL PRIMARY KEY,
        accommodation_id BIGINT NOT NULL REFERENCES accommodations(id) ON DELETE CASCADE,
        timestamp TIMESTAMP NOT NULL,
        event_type VARCHAR(50) NOT NULL
);

CREATE INDEX idx_accommodation_activities_accommodation_id ON accommodation_activities(accommodation_id);
CREATE INDEX idx_accommodation_activities_event_type ON accommodation_activities(event_type);
CREATE INDEX idx_accommodation_activities_timestamp ON accommodation_activities(timestamp);