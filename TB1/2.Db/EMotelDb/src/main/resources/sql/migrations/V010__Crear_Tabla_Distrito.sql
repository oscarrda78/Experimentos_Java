-- Table: public.distrito

CREATE SEQUENCE distrito_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.distrito
(
    id integer NOT NULL DEFAULT nextval('distrito_id_seq'::regclass),
    nombre character varying(50) COLLATE pg_catalog."default",
    provincia_id integer,
    CONSTRAINT distrito_pkey PRIMARY KEY (id),
    CONSTRAINT fk_provincia FOREIGN KEY (provincia_id)
        REFERENCES public.provincia (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.distrito
    OWNER to postgres;