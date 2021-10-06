CREATE TABLE tree_kind  (
    id BIGSERIAL NOT NULL PRIMARY KEY ,
    name varchar(64),
    forest_type_id BIGSERIAL,
    CONSTRAINT forest_type_id_fk FOREIGN KEY (forest_type_id) REFERENCES forest_type (id) ON DELETE CASCADE
);
