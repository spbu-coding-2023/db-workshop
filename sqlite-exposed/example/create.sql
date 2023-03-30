CREATE TABLE if not exists cities
(
    id   INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name varchar(255)
);

CREATE TABLE if not exists users
(
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name   varchar(255),
    phone  INTEGER,
    city   INTEGER,
    FOREIGN KEY (city) REFERENCES cities (id) ON DELETE SET NULL
);
