CREATE TABLE Sensors(
    id bigserial primary key,
    type_id serial,
    status boolean,
    state varchar,
    commission_date timestamp
)