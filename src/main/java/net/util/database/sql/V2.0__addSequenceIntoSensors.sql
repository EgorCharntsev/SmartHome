CREATE SEQUENCE sensors_seq;

SELECT nextval('sensors_seq');

ALTER TABLE sensors ALTER COLUMN id SET DEFAULT nextval('sensors_seq');