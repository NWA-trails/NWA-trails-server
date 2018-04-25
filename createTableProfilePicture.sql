CREATE TABLE "profile_picture"
(
  id bigserial NOT NULL,
  username text references "users"(username),
  image bytea,
  CONSTRAINT profile_picture_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);