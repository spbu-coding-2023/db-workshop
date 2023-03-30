CREATE TABLE if not exists cities
(
    id   INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name varchar(255)
);

CREATE TABLE if not exists users
(
    userId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name   varchar(255),
    phone  INTEGER,
    cityId INTEGER,
    FOREIGN KEY (cityId) REFERENCES cities (id) ON DELETE SET NULL
);
