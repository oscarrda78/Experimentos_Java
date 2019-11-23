-- Table: public.provincia

CREATE SEQUENCE provincia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.provincia
(
    id integer NOT NULL DEFAULT nextval('provincia_id_seq'::regclass),
    nombre character varying COLLATE pg_catalog."default",
    CONSTRAINT provincia_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.provincia
    OWNER to postgres;