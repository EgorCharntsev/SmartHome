ALTER TABLE sensor_type
    ADD CONSTRAINT name_not_null_check CHECK(name IS NOT NULL),
    ADD CONSTRAINT description_not_null_check CHECK(description IS NOT NULL);