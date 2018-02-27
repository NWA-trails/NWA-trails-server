CREATE TABLE "user"
(
  id bigserial NOT NULL,
  first_name text NOT NULL,
  last_name text NOT NULL,
  username text NOT NULL UNIQUE,
  email character varying(20) NOT NULL UNIQUE,
  password text NOT NULL,
  role text NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
