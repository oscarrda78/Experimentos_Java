-- Table: public.nacionalidad

CREATE SEQUENCE nacionalidad_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.nacionalidad
(
    id integer NOT NULL DEFAULT nextval('nacionalidad_id_seq'::regclass),
    nombre character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT nacionalidad_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.nacionalidad
    OWNER to postgres;