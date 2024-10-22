--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3 (Debian 16.3-1.pgdg120+1)
-- Dumped by pg_dump version 16.3 (Debian 16.3-1.pgdg120+1)

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
-- Name: immagine; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.immagine (
    id bigint NOT NULL,
    camion integer,
    data timestamp(6) without time zone,
    macchine integer,
    moto integer,
    webcam_id bigint
);


ALTER TABLE public.immagine OWNER TO postgres;

--
-- Name: traffico_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.traffico_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.traffico_sequence OWNER TO postgres;

--
-- Name: webcam; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.webcam (
    id bigint NOT NULL,
    latitudine double precision,
    longitudine double precision,
    media_camion real,
    media_macchine real,
    media_moto real,
    media_veicoli real,
    posizione character varying(255)
);


ALTER TABLE public.webcam OWNER TO postgres;

--
-- Data for Name: immagine; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.immagine (id, camion, data, macchine, moto, webcam_id) FROM stdin;
\.


--
-- Data for Name: webcam; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.webcam (id, latitudine, longitudine, media_camion, media_macchine, media_moto, media_veicoli, posizione) FROM stdin;
2	46.29568056176907	11.068099141528291	\N	\N	\N	\N	Galleria Rocchetta SS 43 direzione Trento
4	\N	\N	\N	\N	\N	\N	PMV CARRELLATO 836 Strada non specificata
5	\N	\N	\N	\N	\N	\N	PMV CARRELLATO 897 Strada non specificata
6	45.90313340291597	10.83648255500479	\N	\N	\N	\N	Moena nord SS 48 direzione Canazei
8	\N	\N	\N	\N	\N	\N	PMV CARRELLATO 834 Strada non specificata
10	46.27654671772232	11.431595668512708	\N	\N	\N	\N	St. Castello innesto / Gal. Brozzin SP 232 direzione Egna
11	46.27825213234128	11.431575697348581	\N	\N	\N	\N	Castello Molina di Fiemme, innesto dep. SP 232 direzione Predazzo
30	46.36147257918388	11.037484697352044	\N	\N	\N	\N	Mollaro SS 43 direzione Cles
31	46.48716413207695	11.341824839685614	\N	\N	\N	\N	Cadino SS 12 direzione Bolzano
32	46.393294870284656	11.013172597353334	\N	\N	\N	\N	Mostizzolo SS 42 direzione Malè
34	46.487156745089905	11.341824839685614	\N	\N	\N	\N	Trento Commerciale (U8) SS 12 direzione Bolzano
35	45.40608800097724	10.990024439641383	\N	\N	\N	\N	Piedicastello SUD (U4-U5) SS 12 direzione Verona
37	46.04622215768972	11.452379526174894	\N	\N	\N	\N	Borgo Valsugana SS 47 direzione Trento
39	46.04621471104211	11.4523687973391	\N	\N	\N	\N	San Cristoforo SS 47 direzione Borgo Valsugana
40	46.19687152372771	11.091695697345253	\N	\N	\N	\N	Mezzolombardo Sud SP 235 direzione Trento
41	46.217174595504154	11.087088910838677	\N	\N	\N	\N	Mezzolombardo Nord SS 43 direzione Val di Non
42	46.00273987610652	11.126309997337266	\N	\N	\N	\N	Mattarello Sud SS 12 direzione Rovereto
43	45.45579882276301	11.856718597314972	\N	\N	\N	\N	Campiello SS 47 direzione Padova
44	46.17899619982761	11.832435168508676	\N	\N	\N	\N	Totoga SS 50 direzione Imer
45	46.31466550224385	11.598536897350066	\N	\N	\N	\N	Predazzo SS 48 direzione Predazzo
46	46.0844849955615	11.131255997340638	\N	\N	\N	\N	Trento Est (U10) SS 47 direzione Trento
47	46.081168480305664	11.113488581358304	\N	\N	\N	\N	Trento Centro (U6) SS 12 direzione Rovereto
48	46.29564349701293	11.068045497349319	\N	\N	\N	\N	Mezzolombardo Campo sportivo SS 43 direzione Val di Non
49	45.882788877036916	11.032404797332351	\N	\N	\N	\N	Ravina Cavalcavia SS 12 direzione Rovereto
50	46.48716413207695	11.341824839685614	\N	\N	\N	\N	Ravina Cavalcavia SS 12 direzione Bolzano
51	\N	\N	\N	\N	\N	\N	Trento Centro SS 45 bis direzione Cadine
52	45.4558138744443	11.856718597314972	\N	\N	\N	\N	Località Martincelli Grigno SS 47 direzione Padova
53	45.857205966930266	11.661518931066494	\N	\N	\N	\N	Grigno Ovest SS 47 direzione Padova
54	45.882788877036916	11.03239406849656	\N	\N	\N	\N	Trento Commerciale (U7) SS 12 direzione Rovereto
55	46.487156745089905	11.341824839685614	\N	\N	\N	\N	Piedicastello SUD (U5) SS 12 direzione Bolzano
56	45.62405857108075	10.572816626157596	\N	\N	\N	\N	Cadine SS 45 bis direzione Riva
60	46.286772162142185	11.418753728662166	\N	\N	\N	\N	Stazione Castello SS 48 direzione Passo S.Lugano
61	45.88976177422461	10.845624910825313	\N	\N	\N	\N	Mori Ovest SS 240 direzione Riva del Garda
62	45.88976924193489	10.845646368496901	\N	\N	\N	\N	Mori Est SS 240 direzione Riva del Garda
63	\N	\N	\N	\N	\N	\N	Storo SS 237 direzione direzione Madonna di Campiglio
64	45.90313340291597	10.836461097333201	\N	\N	\N	\N	Rotatoria Riva del garda direzione Riva del Garda
65	46.034109583158894	10.747099891786915	\N	\N	\N	\N	Tione- Zuclo SS 237 direzione Saone/Ponte Arche/Trento
66	45.889754306513304	10.845635639661106	\N	\N	\N	\N	Loppio SS 240 direzione Riva del Garda
67	46.25747177110166	10.576371126183531	\N	\N	\N	\N	Passo del Tonale SS 42 direzione Brescia
68	45.876353082253395	10.904766235809825	\N	\N	\N	\N	Nago SS 240 direzione Passo San Giovanni/Mori/Rovereto
69	46.084571875017204	11.131059771359713	\N	\N	\N	\N	Pergine Centro SS 47 direzione Trento
70	46.161616092038486	11.079888670372279	\N	\N	\N	\N	Uscita Lavis SP 235 direzione Bolzano
71	46.032672316517704	11.392935039666884	\N	\N	\N	\N	Marter SS 47 direzione Trento
72	46.01045103446916	11.1289292955356	\N	\N	\N	\N	Mattarello Sud SS 12 direzione Trento
73	46.0214100018499	11.041176362120376	\N	\N	\N	\N	Vason SP 85 direzione Viote
74	46.06223498307176	11.07967658150414	\N	\N	\N	\N	Candriai SP 85 direzione Trento
75	46.486200632469576	11.799688739685564	\N	\N	\N	\N	Passo Prodoi SS 48 direzione Canazei
76	46.5162225541542	11.768422097358394	\N	\N	\N	\N	Passo Sella SS 242 direzione Canazei
77	46.377515061803	11.802126429889585	\N	\N	\N	\N	Passo San Pellegrino SS 346 direzione Moena
78	46.294675697274926	11.455392897349329	\N	\N	\N	\N	Passo Lavaze SS 620 direzione Cavalese
79	45.88976177422461	10.845635639661106	\N	\N	\N	\N	Lifano SS 240 direzione Riva del Garda
80	46.18905645321144	11.887004426180722	\N	\N	\N	\N	Passo Cereda SS 347 direzione Passo Cereda
81	46.17900362855583	11.832435168508676	\N	\N	\N	\N	Passo Rolle SS 50 direzione Passo Rolle
82	46.0779921795257	11.205900510833013	\N	\N	\N	\N	Cirè-Civezzano SS 47 direzione Pergine
83	46.2201112406206	10.821443397346194	\N	\N	\N	\N	Madonna di Campiglio SS 239 direzione Passo C.C. Magno
84	46.032384222580866	10.351084339666922	\N	\N	\N	\N	Passo Mendola SS 42 direzione Bolzano
85	45.89447727232282	10.849174226168639	\N	\N	\N	\N	Cadine SS 45 bis direzione Riva del Garda
86	45.97472976364547	10.819833227478009	\N	\N	\N	\N	Passo Ballino SS 421 direzione Fiavè
87	46.262630071101874	11.803091826183733	\N	\N	\N	\N	San Martino di Castrozza SS 50 direzione Fiera di Primiero
88	\N	\N	\N	\N	\N	\N	PMV CARRELLATO 1014 strada non specificata
89	\N	\N	\N	\N	\N	\N	PMV CARRELLATO 948 strada non specificata
90	\N	\N	\N	\N	\N	\N	PMV CARRELLATO 951 strada non specificata
91	\N	\N	\N	\N	\N	\N	PMV CARRELLATO 950 strada non specificata
92	46.068495788810225	10.96184419284206	\N	\N	\N	\N	Margone SP 18 direzione Vezzano
93	46.37750765993915	11.802115701053792	\N	\N	\N	\N	Passo San Pellegrino SS 346 direzione Passo San Pellegrino
94	46.124688435033924	11.699966768506505	\N	\N	\N	\N	Passo Broccon SP 79 direzione Passo Broccon
95	46.36147998322104	11.037463239680454	\N	\N	\N	\N	Taio Nord SS 43 direzione Cles
96	\N	\N	\N	\N	\N	\N	Andalo SP 64 direzione Andalo
97	46.03538207487806	11.022808726174363	\N	\N	\N	\N	Lagolo SP 85 direzione Lagolo
98	45.81558402644277	11.096441368493785	\N	\N	\N	\N	Pian delle Fugazze SS 46 direzione Pian delle Fugazze
99	45.782491971299216	10.90662227461767	\N	\N	\N	\N	San Valentino SP 03 direzione San Valentino
100	45.87662974056419	11.2154611973321	\N	\N	\N	\N	Passo Coe SP 143 direzione Passo Coe
101	46.3268576455932	11.140340668232273	\N	\N	\N	\N	Passo Predaia SP 13 direzione Passo Predaia
102	46.237988191856104	11.029214797346917	\N	\N	\N	\N	Sporminore SP 67 direzione Sporminore
103	46.14777711233421	11.757457205214545	\N	\N	\N	\N	Passo Gobbera SP 79 direzione Canal San Bovo
104	45.68409764361725	10.97863615797403	\N	\N	\N	\N	Sega di Ala SP 211
105	45.977755726962535	10.976531868500453	\N	\N	\N	\N	Vigo Cavedine SP 84 direzione Trento
106	45.919550325915885	11.206431468498062	\N	\N	\N	\N	Folgaria SS 350 direzione Passo Sommo
107	\N	\N	\N	\N	\N	\N	Bellaria SP 20 direzione Aldeno
108	46.1675627013716	11.004420697344042	\N	\N	\N	\N	Casa Cantoniera SS 421 direzione Andalo
109	45.75999450222535	10.877928843521678	\N	\N	\N	\N	Pra Alpesina SP 230 direzione Pra Alpesina
110	46.463496861312066	11.83167502619207	\N	\N	\N	\N	Passo Fedaia SS 641 direzione Passo Fedaia
111	45.44882366603874	11.29618792713422	\N	\N	\N	\N	Passo CostaLunga SP 241 direzione Passo CostaLunga
112	46.33342118180983	11.799999958401074	\N	\N	\N	\N	Passo Valles SP 81 direzione Passo Valles
113	46.45708643539964	11.700929210848585	\N	\N	\N	\N	Mazzin SS 48 direzione Mazzin
114	46.40791986659251	10.807870939682388	\N	\N	\N	\N	Terme di Rabbi SP 86 direzione Terme di Rabbi
115	46.30249967127666	10.807752817817446	\N	\N	\N	\N	Marileva 1400 SP 206 direzione Marileva 1400
116	46.35475947110629	10.664614126187562	\N	\N	\N	\N	Pejo fonti SP 87 direzione Pejo Fonti
117	46.43663397111012	11.029100226190977	\N	\N	\N	\N	Rumo SP 6 direzione Rumo
118	45.88967309752644	10.730430973539633	\N	\N	\N	\N	Amola SP 127 direzione Ledro
119	45.84074164434105	10.685809893549647	\N	\N	\N	\N	Tremalzo SP 127 direzione Passo Tremalzo
120	45.99472797109131	11.21720909733692	\N	\N	\N	\N	Vigolo Vattaro SS 349 direzione Vigolo Vattaro
121	46.19183852508787	10.789804668509179	\N	\N	\N	\N	Sant'Antonio di Mavignola SS 239 direzione Madonna di Campiglio
122	45.97667864691198	10.542751507849514	\N	\N	\N	\N	Pracul SP 27 direzione Val Daone
123	45.8129073271616	10.546494410822136	\N	\N	\N	\N	Bondone SP 69 direzione Bondone
124	46.03433792763168	10.749453809788612	\N	\N	\N	\N	Passo Duron SP 222 direzione Zuclo
125	45.91952793479709	11.206431468498062	\N	\N	\N	\N	Passo Sommo SS 350 direzione Folgaria
126	45.89046195244296	11.153669282866032	\N	\N	\N	\N	Serrada SP 02 direzione Serrada
127	\N	\N	\N	\N	\N	\N	PMV CARRELLATO 1122 strada non specificata
128	\N	\N	\N	\N	\N	\N	PMV CARRELLATO 1123 strada non specificata
129	46.24502761070846	10.842906839675617	\N	\N	\N	\N	Passo C.C. Magno SS 239 direzione Madonna di Campiglio
130	46.32677654871865	10.784442422215914	\N	\N	\N	\N	Ortisè SP 140 direzione Ortisè
132	46.039305833313506	11.300004028798352	\N	\N	\N	\N	Compet SP 12 direzione Panarotta
133	46.0742010785202	11.302749459766522	\N	\N	\N	\N	Kamuz SP 135 direzione Frassilongo
\.


--
-- Name: traffico_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.traffico_sequence', 1, false);


--
-- Name: immagine immagine_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.immagine
    ADD CONSTRAINT immagine_pkey PRIMARY KEY (id);


--
-- Name: webcam webcam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.webcam
    ADD CONSTRAINT webcam_pkey PRIMARY KEY (id);


--
-- Name: immagine fk5x89nadksl2yxn3tb70nool8y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.immagine
    ADD CONSTRAINT fk5x89nadksl2yxn3tb70nool8y FOREIGN KEY (webcam_id) REFERENCES public.webcam(id);


--
-- PostgreSQL database dump complete
--

