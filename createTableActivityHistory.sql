CREATE TABLE "activity_history"
(
  id bigserial NOT NULL,
  username text references "user"(username),
  timestamp date NOT NULL,
  distance real,
  duration real,
  CONSTRAINT activity_history_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
