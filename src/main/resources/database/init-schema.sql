

DROP TABLE IF EXISTS injection.users CASCADE;

CREATE TABLE injection.users
(
    id bigint NOT NULL,
    username character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default",
    surname character varying COLLATE pg_catalog."default",
    token character varying COLLATE pg_catalog."default",
    role character varying COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE injection.users
    OWNER to postgres;
