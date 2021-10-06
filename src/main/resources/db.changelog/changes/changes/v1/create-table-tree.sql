CREATE TABLE tree  (
    id BIGSERIAL NOT NULL PRIMARY KEY ,
    age int NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    planting_id BIGSERIAL,
    CONSTRAINT planting_id_fk FOREIGN KEY (planting_id) REFERENCES planting (id) ON DELETE CASCADE
);
