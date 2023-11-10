ALTER TABLE sensor_states
    ADD CONSTRAINT sensor_state_not_null_check CHECK(sensor_state IS NOT NULL),
    ADD CONSTRAINT response_time_not_null_check CHECK(response_time IS NOT NULL),
    ADD CONSTRAINT sensor_id_not_null_check CHECK(sensor_id IS NOT NULL);