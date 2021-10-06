CREATE TABLE tree  (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    age int NOT NULL,
    latitude double NOT NULL,
    longitude double NOT NULL,
    planting_id bigint NULL DEFAULT NULL,
    CONSTRAINT planting_id_fk FOREIGN KEY (planting_id) REFERENCES planting (id) ON DELETE CASCADE
);
