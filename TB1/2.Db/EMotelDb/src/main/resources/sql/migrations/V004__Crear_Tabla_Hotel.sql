-- Table: public.hotel

CREATE SEQUENCE hotel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.hotel
(
    id integer NOT NULL DEFAULT nextval('hotel_id_seq'::regclass),
    nombre character varying(50) COLLATE pg_catalog."default",
    precio double precision,
    ubicacion character varying(50) COLLATE pg_catalog."default",
    tipohotel_id integer,
    provincia_id integer,
    CONSTRAINT hotel_pkey PRIMARY KEY (id),
    CONSTRAINT fk_provincia FOREIGN KEY (provincia_id)
        REFERENCES public.provincia (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_tipohotel FOREIGN KEY (tipohotel_id)
        REFERENCES public.tipohotel (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hotel
    OWNER to postgres;