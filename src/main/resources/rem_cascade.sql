-- Table: product

-- DROP TABLE product;

CREATE TABLE product
(
  id integer NOT NULL,
  name character varying(255),
  unitcoast integer,
  unitname character varying(255),
  sale_id integer,
  CONSTRAINT product_pkey PRIMARY KEY (id),
  CONSTRAINT fk_h690fqkq3tr1ffqcass1fm0h4 FOREIGN KEY (sale_id)
      REFERENCES sale (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE product
  OWNER TO postgres;

-- Table: buyer

-- DROP TABLE buyer;

CREATE TABLE buyer
(
  id integer NOT NULL,
  birthdate date,
  firstname character varying(255),
  lastname character varying(255),
  livingaddress character varying(255),
  middlename character varying(255),
  phonenumber character varying(255),
  CONSTRAINT buyer_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE buyer
  OWNER TO postgres;


-- Table: discount

-- DROP TABLE discount;

CREATE TABLE discount
(
  id integer NOT NULL,
  actingfrom timestamp without time zone,
  actingto timestamp without time zone,
  amountdiscount integer,
  buyer_id integer,
  product_id integer,
  CONSTRAINT discount_pkey PRIMARY KEY (id),
  CONSTRAINT fk_2bfaxpmxf0iogx1e1ll3l1236 FOREIGN KEY (product_id)
  REFERENCES product (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE CASCADE ,
  CONSTRAINT fk_nh9iwin4iuflok9myaq7krr1b FOREIGN KEY (buyer_id)
  REFERENCES buyer (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
OIDS=FALSE
);
ALTER TABLE discount
  OWNER TO postgres;

-- Table: sale

-- DROP TABLE sale;

CREATE TABLE sale
(
  id integer NOT NULL,
  amountproduct integer,
  deliverydare date,
  orderdate date,
  buyer_id integer,
  CONSTRAINT sale_pkey PRIMARY KEY (id),
  CONSTRAINT fk_kaopopl8sdmxpaf4ylb3p5mbf FOREIGN KEY (buyer_id)
  REFERENCES buyer (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
OIDS=FALSE
);
ALTER TABLE sale
  OWNER TO postgres;


-- Table: seller

-- DROP TABLE seller;

CREATE TABLE seller
(
  id integer NOT NULL,
  birthdate date,
  deliveryaddress character varying(255),
  email character varying(255),
  firstname character varying(255),
  lastname character varying(255),
  middlename character varying(255),
  sale_id integer,
  CONSTRAINT seller_pkey PRIMARY KEY (id),
  CONSTRAINT fk_l107duvu1icc9m5kql557ns26 FOREIGN KEY (sale_id)
  REFERENCES sale (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
OIDS=FALSE
);
ALTER TABLE seller
  OWNER TO postgres;



