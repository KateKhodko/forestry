CREATE TABLE tree_kind  (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(64),
    forest_type_id bigint NULL DEFAULT NULL,
    CONSTRAINT forest_type_id_fk FOREIGN KEY (forest_type_id) REFERENCES forest_type (id) ON DELETE CASCADE
);
