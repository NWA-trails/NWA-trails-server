CREATE TABLE "profile_picture"
(
  id bigserial NOT NULL,
  username text references "user"(username),
  image bytea,
  CONSTRAINT profile_picture_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);