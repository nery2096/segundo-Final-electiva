
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;


CREATE TABLE public.permiso (
	id_permiso serial primary key,
	tipo_permiso integer not null,
	descripcion character varying(50) NOT NULL
);
ALTER TABLE public.permiso OWNER TO postgres;

CREATE TABLE public.usuario (
    id_usuario serial primary key,
	apellido character varying(50) NOT NULL,
    nombre character varying(50) NOT NULL,
	ci integer NOT NULL,
	direccion character varying(50),
	telefono numeric(16,0),
	id_permiso_usuario integer not null
);
ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT ci UNIQUE (ci);
	
ALTER TABLE public.usuario OWNER TO postgres;

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_permiso_fk FOREIGN KEY (id_permiso_usuario) 
	REFERENCES public.permiso(id_permiso);
	
create table public.mecanico_status(
	id_mecanico integer not null,
	status character varying(1) NOT NULL
);
ALTER TABLE public.mecanico_status OWNER TO postgres;
ALTER TABLE ONLY public.mecanico_status
    ADD CONSTRAINT id_mecanico_status_fk PRIMARY KEY (id_mecanico)
	
CREATE TABLE public.auto(
	id_auto serial primary key,
	matricula character varying(50) NOT NULL,
	modelo character varying(50) NOT NULL,
	color character varying(50) NOT NULL,
	id_cliente integer not null
);
ALTER TABLE public.auto OWNER TO postgres;
ALTER TABLE ONLY public.auto
    ADD CONSTRAINT matricula UNIQUE (matricula);
ALTER TABLE ONLY public.auto
    ADD CONSTRAINT id_auto_fk FOREIGN KEY (id_cliente) 
	REFERENCES public.usuario(id_usuario);
	
CREATE TABLE public.mecanico_por_auto(
	id serial primary key,
	id_auto integer not null,
	id_mecanico integer not null
);
ALTER TABLE public.mecanico_por_auto OWNER TO postgres;

ALTER TABLE ONLY public.mecanico_por_auto
    ADD CONSTRAINT id_auto_fk FOREIGN KEY (id_auto) 
	REFERENCES public.auto(id_auto);
	
ALTER TABLE ONLY public.mecanico_por_auto
    ADD CONSTRAINT id_mecanico_fk FOREIGN KEY (id_mecanico) 
	REFERENCES public.usuario(id_usuario);
	


Create table public.taller(
	id_taller serial primary key,
	fecha_entrada date,
	id_auto integer not null
);
ALTER TABLE public.taller OWNER TO postgres;

ALTER TABLE ONLY public.taller
    ADD CONSTRAINT id_taller_fk FOREIGN KEY (id_auto) 
	REFERENCES public.auto(id_auto);
	
create table public.hoja_repuestos_usados(
	id_hoja serial primary key,
	descripcion_repuesto character varying(50) NOT NULL,
	precio integer not null
);
ALTER TABLE public.hoja_repuestos_usados OWNER TO postgres;

create table public.factura(
	id_factura primary key,
	id_cliente integer not null,
	id_hoja integer not null,
	monto_total integer not null
);
ALTER TABLE public.taller OWNER TO postgres;
ALTER TABLE ONLY public.factura
    ADD CONSTRAINT id_factura_fk FOREIGN KEY (id_cliente) 
	REFERENCES public.usuario(id_usuario);
ALTER TABLE ONLY public.factura
    ADD CONSTRAINT id_factura_hoja_fk FOREIGN KEY (id_hoja) 
	REFERENCES public.hoja_repuestos_usados(id_hoja);




