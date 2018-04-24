CREATE TABLE "accountInformation"
(
  id bigserial NOT NULL,
  username text references "user"(username),
  dateOfBirth text NULL,
  height text NULL,
  weight text NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);