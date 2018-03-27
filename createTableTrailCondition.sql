CREATE TABLE "trail_condition"
(
  id bigserial NOT NULL,
  username text references "user"(username),
  timestamp date NOT NULL,
  image bytea,
  description text,
  CONSTRAINT trail_condition_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
