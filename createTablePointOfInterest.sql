CREATE TABLE "point_of_interest"
(
  id bigserial NOT NULL,
  username text references "users"(username),
  timestamp timestamptz NOT NULL,
  image bytea,
  description text,
  lat float,
  lng float,
  approved boolean,
  active boolean,
  trail text,
  CONSTRAINT point_of_interest_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);