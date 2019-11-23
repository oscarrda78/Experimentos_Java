-- Table: public.administrador

-- DROP TABLE public.administrador;

CREATE SEQUENCE administrador_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.administrador
(
    id integer NOT NULL DEFAULT nextval('administrador_id_seq'::regclass),
    nombre character varying(50) COLLATE pg_catalog."default",
    apellido character varying(50) COLLATE pg_catalog."default",
    correo character varying(50) COLLATE pg_catalog."default",
    fecha date,
    password character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT administrador_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.administrador
    OWNER to postgres;