--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

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

--
-- Name: category; Type: TABLE; Schema: public; Owner: anteaa
--

CREATE TABLE public.category (
    id integer NOT NULL,
    name_en character varying(256),
    name character varying(256),
    parent integer NOT NULL,
    icon character varying(512),
    image character varying(512),
    kind character(1),
    priority integer,
    visibility boolean,
    deleted boolean,
    cdt timestamp without time zone,
    udt timestamp without time zone
);


ALTER TABLE public.category OWNER TO anteaa;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: anteaa
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO anteaa;

--
-- Name: parent; Type: TABLE; Schema: public; Owner: anteaa
--

CREATE TABLE public.parent (
    id integer NOT NULL,
    name_en character varying(256),
    name character varying(256)
);


ALTER TABLE public.parent OWNER TO anteaa;

--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: anteaa
--

COPY public.category (id, name_en, name, parent, icon, image, kind, priority, visibility, deleted, cdt, udt) FROM stdin;
1	food	غذا	1	\N	sfsf		1	t	f	2019-01-01 03:30:00	2020-01-01 03:30:00
5	Dress	پیرهن	2	\N	sfsf		1	t	f	2020-11-14 18:24:45.668	2020-11-14 18:24:45.668
6	Pants	شلوار	2	\N	sfsf		1	t	f	2020-11-14 19:50:11.071	2020-11-14 19:50:11.071
\.


--
-- Data for Name: parent; Type: TABLE DATA; Schema: public; Owner: anteaa
--

COPY public.parent (id, name_en, name) FROM stdin;
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: anteaa
--

SELECT pg_catalog.setval('public.hibernate_sequence', 6, true);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: anteaa
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: parent parent_pkey; Type: CONSTRAINT; Schema: public; Owner: anteaa
--

ALTER TABLE ONLY public.parent
    ADD CONSTRAINT parent_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

