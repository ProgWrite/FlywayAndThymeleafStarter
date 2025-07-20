CREATE TABLE persons (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        age INTEGER NOT NULL CHECK (age > 0)
);