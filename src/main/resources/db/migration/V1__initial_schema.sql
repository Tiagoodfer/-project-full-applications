CREATE TABLE client (
    uuid UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE book (
    uuid UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL
);

CREATE TABLE booking (
    uuid UUID PRIMARY KEY,
    client_id UUID NOT NULL,
    book_id UUID NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client (uuid),
    FOREIGN KEY (book_id) REFERENCES book (uuid)
);