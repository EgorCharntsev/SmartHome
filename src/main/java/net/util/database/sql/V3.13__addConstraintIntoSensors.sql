ALTER TABLE sensors
    ADD CONSTRAINT type_id_check CHECK (type_id > 0);