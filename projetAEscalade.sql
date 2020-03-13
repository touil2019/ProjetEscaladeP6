--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

-- Started on 2020-03-13 17:22:58

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
-- TOC entry 204 (class 1259 OID 127347)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    id bigint NOT NULL,
    contenu character varying(255),
    datedeparution timestamp without time zone,
    id_site bigint,
    id_utilisateur bigint
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 127345)
-- Name: commentaire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_id_seq OWNER TO postgres;

--
-- TOC entry 2900 (class 0 OID 0)
-- Dependencies: 203
-- Name: commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;


--
-- TOC entry 202 (class 1259 OID 127343)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 127353)
-- Name: longueur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.longueur (
    id bigint NOT NULL,
    cotation character varying(255),
    hauteur integer NOT NULL,
    nom character varying(255),
    id_voie bigint
);


ALTER TABLE public.longueur OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 127361)
-- Name: reservation_topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation_topo (
    id bigint NOT NULL,
    acceptations boolean NOT NULL,
    dateemprunt timestamp without time zone,
    id_topo bigint,
    id_utilisateur bigint
);


ALTER TABLE public.reservation_topo OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 127366)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id_utilisateur bigint NOT NULL,
    roles character varying(255)
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 127371)
-- Name: site; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.site (
    id_site bigint NOT NULL,
    departement character varying(255),
    nom character varying(255),
    officiel boolean NOT NULL,
    ville character varying(255),
    id_utilisateur bigint
);


ALTER TABLE public.site OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 127369)
-- Name: site_id_site_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.site_id_site_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.site_id_site_seq OWNER TO postgres;

--
-- TOC entry 2901 (class 0 OID 0)
-- Dependencies: 208
-- Name: site_id_site_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.site_id_site_seq OWNED BY public.site.id_site;


--
-- TOC entry 210 (class 1259 OID 127380)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    id bigint NOT NULL,
    date timestamp without time zone,
    description character varying(255),
    disponible boolean NOT NULL,
    nom character varying(255),
    id_utilisateur bigint
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 127388)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    id bigint NOT NULL,
    account_non_expired boolean,
    account_non_locked boolean,
    credentials_non_expired boolean,
    email character varying(255) NOT NULL,
    enabled boolean,
    firstname character varying(255) NOT NULL,
    lastname character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 127398)
-- Name: voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.voie (
    id_voie bigint NOT NULL,
    cotation character varying(255),
    hauteur integer NOT NULL,
    nom character varying(255),
    secteur character varying(255),
    id_site bigint
);


ALTER TABLE public.voie OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 127396)
-- Name: voie_id_voie_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.voie_id_voie_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.voie_id_voie_seq OWNER TO postgres;

--
-- TOC entry 2902 (class 0 OID 0)
-- Dependencies: 212
-- Name: voie_id_voie_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.voie_id_voie_seq OWNED BY public.voie.id_voie;


--
-- TOC entry 2726 (class 2604 OID 127350)
-- Name: commentaire id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id SET DEFAULT nextval('public.commentaire_id_seq'::regclass);


--
-- TOC entry 2727 (class 2604 OID 127374)
-- Name: site id_site; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site ALTER COLUMN id_site SET DEFAULT nextval('public.site_id_site_seq'::regclass);


--
-- TOC entry 2728 (class 2604 OID 127401)
-- Name: voie id_voie; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie ALTER COLUMN id_voie SET DEFAULT nextval('public.voie_id_voie_seq'::regclass);


--
-- TOC entry 2885 (class 0 OID 127347)
-- Dependencies: 204
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire (id, contenu, datedeparution, id_site, id_utilisateur) FROM stdin;
1	commentaire1	2020-03-13 17:22:00.896	1	1
2	commentaire2	2020-03-13 17:22:00.899	1	2
3	commentaire	2020-03-13 17:22:00.901	2	1
4	commentaire	2020-03-13 17:22:00.903	3	2
5	commentaire	2020-03-13 17:22:00.905	4	2
\.


--
-- TOC entry 2886 (class 0 OID 127353)
-- Dependencies: 205
-- Data for Name: longueur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.longueur (id, cotation, hauteur, nom, id_voie) FROM stdin;
3	4C	800	Passage Maripasoula	1
4	4B	200	Boucle sable blanc	1
5	4C	400	Boucle de la clairiere	2
6	10B	700	Allée aux chasseurs	2
7	5C	300	Route du postier	3
8	7B	500	Grand Fromagier	3
9	1B	400	Chemin du col vert	4
10	2B	800	Col du bois vaillant	4
11	6C	400	Bois de Nèfles	5
12	5C	900	Plage de l'éméraude	5
13	7B	1200	Falaise du diamant	6
14	2B	1400	Route du vieux phare	6
\.


--
-- TOC entry 2887 (class 0 OID 127361)
-- Dependencies: 206
-- Data for Name: reservation_topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation_topo (id, acceptations, dateemprunt, id_topo, id_utilisateur) FROM stdin;
19	f	2020-03-13 17:22:00.908	17	2
20	f	2020-03-13 17:22:00.91	18	2
21	t	2020-03-13 17:22:00.912	15	1
22	f	2020-03-13 17:22:00.914	16	1
\.


--
-- TOC entry 2888 (class 0 OID 127366)
-- Dependencies: 207
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id_utilisateur, roles) FROM stdin;
1	ROLE_USER
2	ROLE_USER
2	ROLE_ADMIN
\.


--
-- TOC entry 2890 (class 0 OID 127371)
-- Dependencies: 209
-- Data for Name: site; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.site (id_site, departement, nom, officiel, ville, id_utilisateur) FROM stdin;
1	Guyane	le pic de dante	f	Maripasoula	1
2	Réunion	le pic vert	f	Bois de Nèfles	1
3	Mayotte	le pic rouge	f	Mamoudzou	2
4	Guadeloupe	Saint-Pierre	f	Pointe-à-Pitre	2
\.


--
-- TOC entry 2891 (class 0 OID 127380)
-- Dependencies: 210
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo (id, date, description, disponible, nom, id_utilisateur) FROM stdin;
15	2020-03-13 17:22:00.886	cadre accueillant	t	Saint-Pierre	2
16	2020-03-13 17:22:00.89	lieu ensoleillé	t	Croix Rouge	2
17	2020-03-13 17:22:00.892	plage vierge	t	Maripasoula	1
18	2020-03-13 17:22:00.894	ballade buccolique	t	Bois de Nèfles	1
\.


--
-- TOC entry 2892 (class 0 OID 127388)
-- Dependencies: 211
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur (id, account_non_expired, account_non_locked, credentials_non_expired, email, enabled, firstname, lastname, password, username) FROM stdin;
1	t	t	t	user1@gmail.com	t	user	user	$2a$10$/W9DIEUudxO2XCYtYF8zc.jsEq7YHOSBbgrRuCrjL.I2vxZRo4wVG	user
2	t	t	t	admin1@gmail.com	t	admin	admin	$2a$10$wl/la..v0CKiC3NvGaAxuuAXJzUbtJX/FAVRgdWlT8Hx8HvsEcs/a	admin
\.


--
-- TOC entry 2894 (class 0 OID 127398)
-- Dependencies: 213
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.voie (id_voie, cotation, hauteur, nom, secteur, id_site) FROM stdin;
1	4C	10	Chemin Maripasoula	secteur1	1
2	6C	10	Pic du col vert	secteur2	1
3	8C	10	Passage du colibri	secteur3	2
4	9C	10	Route des fleurs	secteur1	2
5	7C	9	Chemin des Amaryllis	secteur2	3
6	5B	8	Col de la Croix-haute	secteur3	3
\.


--
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 203
-- Name: commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_id_seq', 5, true);


--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 202
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 22, true);


--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 208
-- Name: site_id_site_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.site_id_site_seq', 4, true);


--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 212
-- Name: voie_id_voie_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voie_id_voie_seq', 6, true);


--
-- TOC entry 2730 (class 2606 OID 127352)
-- Name: commentaire commentaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pkey PRIMARY KEY (id);


--
-- TOC entry 2732 (class 2606 OID 127360)
-- Name: longueur longueur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur
    ADD CONSTRAINT longueur_pkey PRIMARY KEY (id);


--
-- TOC entry 2734 (class 2606 OID 127365)
-- Name: reservation_topo reservation_topo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_topo
    ADD CONSTRAINT reservation_topo_pkey PRIMARY KEY (id);


--
-- TOC entry 2737 (class 2606 OID 127379)
-- Name: site site_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT site_pkey PRIMARY KEY (id_site);


--
-- TOC entry 2739 (class 2606 OID 127387)
-- Name: topo topo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pkey PRIMARY KEY (id);


--
-- TOC entry 2741 (class 2606 OID 127411)
-- Name: utilisateur uk_kq7nt5wyq9v9lpcpgxag2f24a; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT uk_kq7nt5wyq9v9lpcpgxag2f24a UNIQUE (username);


--
-- TOC entry 2743 (class 2606 OID 127409)
-- Name: utilisateur uk_rma38wvnqfaf66vvmi57c71lo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT uk_rma38wvnqfaf66vvmi57c71lo UNIQUE (email);


--
-- TOC entry 2745 (class 2606 OID 127395)
-- Name: utilisateur utilisateur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pkey PRIMARY KEY (id);


--
-- TOC entry 2747 (class 2606 OID 127406)
-- Name: voie voie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT voie_pkey PRIMARY KEY (id_voie);


--
-- TOC entry 2735 (class 1259 OID 127407)
-- Name: index_user_role; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX index_user_role ON public.roles USING btree (id_utilisateur);


--
-- TOC entry 2751 (class 2606 OID 127427)
-- Name: reservation_topo fk1wyjr0tv18tsr4f7c04xw93wd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_topo
    ADD CONSTRAINT fk1wyjr0tv18tsr4f7c04xw93wd FOREIGN KEY (id_topo) REFERENCES public.topo(id);


--
-- TOC entry 2756 (class 2606 OID 127452)
-- Name: voie fk4c02h16bmjsl2d76bofqc238u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT fk4c02h16bmjsl2d76bofqc238u FOREIGN KEY (id_site) REFERENCES public.site(id_site);


--
-- TOC entry 2755 (class 2606 OID 127447)
-- Name: topo fk5iv8hn3uf5rax8ejcwtj6w96r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT fk5iv8hn3uf5rax8ejcwtj6w96r FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id);


--
-- TOC entry 2748 (class 2606 OID 127412)
-- Name: commentaire fkkgndecm5i0gjb9q0vr7c7qpir; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT fkkgndecm5i0gjb9q0vr7c7qpir FOREIGN KEY (id_site) REFERENCES public.site(id_site);


--
-- TOC entry 2753 (class 2606 OID 127437)
-- Name: roles fknj2ecd8t8i7wmxfrl1mq8gql3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT fknj2ecd8t8i7wmxfrl1mq8gql3 FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id);


--
-- TOC entry 2749 (class 2606 OID 127417)
-- Name: commentaire fknn2n15aiy9r5gnmub0yxn65gl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT fknn2n15aiy9r5gnmub0yxn65gl FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id);


--
-- TOC entry 2754 (class 2606 OID 127442)
-- Name: site fko959xl437ru92w1wgsi5q8om6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT fko959xl437ru92w1wgsi5q8om6 FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id);


--
-- TOC entry 2750 (class 2606 OID 127422)
-- Name: longueur fksntp125c2624k8psbmjo0daru; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur
    ADD CONSTRAINT fksntp125c2624k8psbmjo0daru FOREIGN KEY (id_voie) REFERENCES public.voie(id_voie);


--
-- TOC entry 2752 (class 2606 OID 127432)
-- Name: reservation_topo fku1x4ghh1geaol6ubcow5ao8p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation_topo
    ADD CONSTRAINT fku1x4ghh1geaol6ubcow5ao8p FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id);


-- Completed on 2020-03-13 17:22:58

--
-- PostgreSQL database dump complete
--

