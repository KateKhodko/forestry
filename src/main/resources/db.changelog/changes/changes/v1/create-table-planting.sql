CREATE TABLE planting  (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(64),
    square int NOT NULL,
    forestry_id bigint NULL DEFAULT NULL,
    tree_kind_id bigint NULL DEFAULT NULL,
    CONSTRAINT forestry_id_fk FOREIGN KEY (forestry_id) REFERENCES forestry (id) ON DELETE CASCADE,
    CONSTRAINT tree_kind_id_fk FOREIGN KEY (tree_kind_id) REFERENCES tree_kind (id) ON DELETE CASCADE
);
