ALTER TABLE sensor_states
    ADD CONSTRAINT sensor_id_check CHECK(sensor_id > 0),
    ADD CONSTRAINT sensor_state_length_check CHECK(LENGTH(sensor_state) >= 5);