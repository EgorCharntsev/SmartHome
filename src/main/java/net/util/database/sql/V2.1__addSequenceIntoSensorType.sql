CREATE SEQUENCE sensor_type_seq;

SELECT nextval('sensor_type_seq');

ALTER TABLE sensor_type ALTER COLUMN id SET DEFAULT nextval('sensor_type_seq');