CREATE TABLE SensorStates(
    id bigserial primary key,
    sensor_id bigserial,
    sensor_type serial,
    sensor_state varchar,
    response_time timestamp
)