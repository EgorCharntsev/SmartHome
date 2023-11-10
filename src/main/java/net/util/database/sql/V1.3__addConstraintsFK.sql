ALTER TABLE sensorstates RENAME TO sensor_states;

ALTER TABLE sensortype RENAME TO sensor_type;

ALTER TABLE sensors DROP COLUMN type_id;

ALTER TABLE sensors ADD type_id integer;

ALTER TABLE sensors
    ADD CONSTRAINT sensor_type_foreign_key
        FOREIGN KEY (type_id) REFERENCES sensor_type(id);

ALTER TABLE sensor_states DROP COLUMN sensor_id;

ALTER TABLE sensor_states ADD sensor_id bigint;

ALTER TABLE sensor_states
    ADD CONSTRAINT sensor_id_foreign_key
        FOREIGN KEY (sensor_id) REFERENCES sensors(id);

ALTER TABLE sensor_states DROP COLUMN sensor_type;