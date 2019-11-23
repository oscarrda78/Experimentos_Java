-- Table: public.tipohotel

CREATE SEQUENCE tipo_hotel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
	
CREATE TABLE public.tipohotel
(
    id integer NOT NULL DEFAULT nextval('tipo_hotel_id_seq'::regclass),
    nombre character varying(50) COLLATE pg_catalog."default",
    descripcion character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT tipo_hotel_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tipohotel
    OWNER to postgres;