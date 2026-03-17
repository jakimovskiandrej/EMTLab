insert into countries (created_at, updated_at, name, continent)
values
    (now(), now(), 'Macedonia', 'Europe'),
    (now(), now(), 'Germany', 'Europe'),
    (now(), now(), 'USA', 'North America');

insert into hosts (created_at, updated_at, name, surname, country_id)
values
    (now(), now(), 'Andrej', 'Jakimovski', (select id from countries where name = 'Macedonia')),
    (now(), now(), 'Maria', 'Schmidt', (select id from countries where name = 'Germany')),
    (now(), now(), 'John', 'Doe', (select id from countries where name = 'USA'));

insert into accommodations (created_at, updated_at, name, category, status, host_id, num_rooms)
values
    (now(), now(), 'Cozy Room', 'ROOM', 'GOOD', (select id from hosts where name = 'Andrej' and surname = 'Jakimovski'), 1),
    (now(), now(), 'Family House', 'HOUSE', 'GOOD', (select id from hosts where name = 'Maria' and surname = 'Schmidt'), 5),
    (now(), now(), 'City Flat', 'FLAT', 'GOOD', (select id from hosts where name = 'John' and surname = 'Doe'), 3),
    (now(), now(), 'Grand Hotel', 'HOTEL', 'GOOD', (select id from hosts where name = 'Maria' and surname = 'Schmidt'), 20),
    (now(), now(), 'Motel Sunset', 'MOTEL', 'GOOD', (select id from hosts where name = 'John' and surname = 'Doe'), 10);

insert into reviews (created_at, updated_at, comment, rating, accommodation_id)
values
    (now(), now(), 'Great stay!', 5, (select id from accommodations where name = 'Cozy Room')),
    (now(), now(), 'Very comfortable', 4, (select id from accommodations where name = 'Family House')),
    (now(), now(), 'Average experience', 3, (select id from accommodations where name = 'City Flat')),
    (now(), now(), 'Luxurious hotel', 5, (select id from accommodations where name = 'Grand Hotel')),
    (now(), now(), 'Decent motel', 3, (select id from accommodations where name = 'Motel Sunset'));