-- Table: public.reservahotel

CREATE SEQUENCE reservahotel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.reservahotel
(
    id integer NOT NULL DEFAULT nextval('reservahotel_id_seq'::regclass),
    hotel_id integer,
    fecha date,
    nrodias integer,
    nrocuartos integer,
    nropersonas integer,
    usuario_id integer,
    CONSTRAINT reservahotel_pkey PRIMARY KEY (id),
    CONSTRAINT fk_hotel FOREIGN KEY (hotel_id)
        REFERENCES public.hotel (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.reservahotel
    OWNER to postgres;