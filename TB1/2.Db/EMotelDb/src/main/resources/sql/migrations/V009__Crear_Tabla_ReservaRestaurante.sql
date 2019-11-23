-- Table: public.reservarestaurante

CREATE SEQUENCE reservarestaurante_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.reservarestaurante
(
    id integer NOT NULL DEFAULT nextval('reservarestaurante_id_seq'::regclass),
    restaurante_id integer,
    fecha date,
    hora character varying(50) COLLATE pg_catalog."default",
    nropersonas integer,
    usuario_id integer,
    CONSTRAINT reservarestaurante_pkey PRIMARY KEY (id),
    CONSTRAINT fk_restaurante FOREIGN KEY (restaurante_id)
        REFERENCES public.restaurante (id) MATCH SIMPLE
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

ALTER TABLE public.reservarestaurante
    OWNER to postgres;