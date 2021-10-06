CREATE TABLE forestry  (
    id BIGSERIAL NOT NULL PRIMARY KEY ,
    name varchar(64),
    forester_id BIGSERIAL,
    village_id BIGSERIAL,
    CONSTRAINT forester_id_fk FOREIGN KEY (forester_id) REFERENCES forester (id) ON DELETE CASCADE,
    CONSTRAINT village_id_fk FOREIGN KEY (village_id) REFERENCES village (id) ON DELETE CASCADE
);
