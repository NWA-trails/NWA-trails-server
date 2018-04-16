CREATE TABLE "trail_condition"
(
  id bigserial NOT NULL,
  username text references "user"(username),
  timestamp timestamptz NOT NULL,
  image bytea,
  description text,
  lat float,
  lng float,
  active boolean,
  acknowledged boolean,
  trail text,
  CONSTRAINT trail_condition_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

insert into trail_condition(id, username, timestamp)
values(20, 'BLAZINGDAMON', '2016-11-16 06:43:19.77');