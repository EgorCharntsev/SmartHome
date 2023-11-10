ALTER TABLE sensor_states DROP CONSTRAINT sensor_state_length_check;

ALTER TABLE sensor_states
    ADD CONSTRAINT sensor_state_length_check CHECK(LENGTH(sensor_state) > 0);