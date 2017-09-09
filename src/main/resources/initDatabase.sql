   CREATE SEQUENCE productSequence
     INCREMENT BY 1
     NO MAXVALUE
     NO MINVALUE
     CACHE 1;

   CREATE SEQUENCE buyerSequence
     INCREMENT BY 1
     NO MAXVALUE
     NO MINVALUE
     CACHE 1;

   CREATE SEQUENCE selerSequence
     INCREMENT BY 1
     NO MAXVALUE
     NO MINVALUE
     CACHE 1;

   CREATE SEQUENCE saleSequence
     INCREMENT BY 1
     NO MAXVALUE
     NO MINVALUE
     CACHE 1;

   CREATE SEQUENCE discountSequence
     INCREMENT BY 1
     NO MAXVALUE
     NO MINVALUE
     CACHE 1;

drop table product;
drop table buyer;
drop table seller;
drop table discount;
drop table sale;

create table product(
id  integer DEFAULT nextval('productSequence') NOT NULL,
name character(50),
unitCoact numeric(10),
unitName character(5)
);
ALTER TABLE product ADD CONSTRAINT productPrimaryKey PRIMARY KEY(id);

create table buyer(
id integer  DEFAULT nextval('buyerSequence') NOT NULL,
firstName character(50),
middleName character(50),
lastName character(50),
birthDate date,
phoneNumber character(50),
livingAddress character(50)
);
alter table buyer add constraint buyerPrimaryKey primary key(id);

create table seller(
id  integer DEFAULT nextval('selerSequence') NOT NULL,
firstName character(50),
middleName character(50),
lastName character(50),
birthDate date, 
email character(50),
deliveryAddress character(50)
);
ALTER TABLE seller ADD CONSTRAINT sellerPrimaryKey PRIMARY KEY(id);

create table discount(
id  integer DEFAULT nextval('discountSequence') NOT NULL,
buyerId integer,
productId integer,
actingFrom date,
actingTo date
);
ALTER TABLE discount ADD CONSTRAINT discountPrimaryKey PRIMARY KEY(id);
 ALTER TABLE discount ADD CONSTRAINT productFK foreign key(productId) references product(id);
 ALTER TABLE discount ADD CONSTRAINT buyerFK foreign key(buyerId) references buyer(id);
 

create table sale(
  id  integer DEFAULT nextval('saleSequence') NOT NULL,
  orderDate date,
  deliveryDare date,
  productId integer,
  buyerId integer,
  sellerId integer,
  amountProduct integer
);
   ALTER TABLE sale ADD CONSTRAINT salePrimaryKey PRIMARY KEY(id);
   alter table sale add constraint productFK foreign key(productId) references  product(id);
   alter table sale add constraint buyerFK foreign key(buyerId) references  buyer(id);
    alter table sale add constraint sellerFK foreign key(sellerId) references  seller(id);
select * from ProDuct