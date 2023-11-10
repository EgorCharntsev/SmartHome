CREATE SEQUENCE sensor_states_seq;

SELECT nextval('sensor_states_seq');

ALTER TABLE sensor_states ALTER COLUMN id SET DEFAULT nextval('sensor_states_seq');

