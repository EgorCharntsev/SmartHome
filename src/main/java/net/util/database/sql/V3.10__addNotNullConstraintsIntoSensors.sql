ALTER TABLE sensors
    ADD CONSTRAINT status_not_null_check CHECK(status IS NOT NULL),
    ADD CONSTRAINT state_not_null_check CHECK(state IS NOT NULL),
    ADD CONSTRAINT commission_date_not_null_check CHECK(commission_date IS NOT NULL),
    ADD CONSTRAINT type_id_not_null_check CHECK(type_id IS NOT NULL);
