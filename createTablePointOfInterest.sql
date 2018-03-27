CREATE TABLE "point_of_interest"
(
  id bigserial NOT NULL,
  username text references "user"(username),
  timestamp date NOT NULL,
  image bytea,
  description text,
  CONSTRAINT point_of_interest_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
