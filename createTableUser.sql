CREATE TABLE "user"
(
  id bigserial NOT NULL,
  first_name text NOT NULL,
  last_name text NOT NULL,
  username text NOT NULL,
  email character varying(20) NOT NULL,
  password text NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
