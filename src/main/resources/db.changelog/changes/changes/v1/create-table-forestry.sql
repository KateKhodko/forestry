CREATE TABLE forestry  (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(64),
    forester_id bigint NULL DEFAULT NULL,
    village_id bigint NULL DEFAULT NULL,
    CONSTRAINT forester_id_fk FOREIGN KEY (forester_id) REFERENCES forester (id) ON DELETE CASCADE,
    CONSTRAINT village_id_fk FOREIGN KEY (village_id) REFERENCES village (id) ON DELETE CASCADE
);
