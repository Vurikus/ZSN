DROP TABLE person;
DROP TABLE passport;
DROP TABLE address;

CREATE TABLE person (
  id_person SERIAL PRIMARY KEY not null,
  name varchar (255) not null,
  surname varchar (255) not null,
  patronymic varchar (255) not null,
  age integer not null
);

CREATE TABLE passport (
  id_passport SERIAL PRIMARY KEY not null,
  series integer not null,
  number integer not null,
  issuingDepartment varchar (255) not null,
  dateIssue date not null
);

CREATE TABLE address (
  id_address SERIAL  PRIMARY KEY not null,
  region varchar (255) not null,
  city varchar (255) not null,
  street varchar (255) not null,
  building varchar (255) not null,
  apartment integer not null
);

CREATE TABLE unemployed (
  id_unemployed SERIAL not null PRIMARY KEY,
  id_person integer,
  id_passport integer,
  id_address integer,
  regDateZSN date not null,
  amountBenefit money,
  FOREIGN KEY (id_person) REFERENCES person(id_person),
  FOREIGN KEY (id_passport) REFERENCES passport(id_passport),
  FOREIGN KEY (id_address) REFERENCES address(id_address)
);