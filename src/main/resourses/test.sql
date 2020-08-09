DROP TABLE AUTHORITIES;
DROP TABLE person;
DROP TABLE LOG;
DROP TABLE NEWTEST;

--USER TABLE
CREATE TABLE person (
                                  ID SERIAL PRIMARY KEY,
                                  USERNAME VARCHAR(255),
                                  PASSWORD  VARCHAR(255) NOT NULL,
                                  ENABLED BOOLEAN
);

--AUTHORITIES TABLE
CREATE TABLE AUTHORITIES(
                                        IDUSER INTEGER,
                                        AUTHORITY VARCHAR(255) NOT NULL,
                                        FOREIGN KEY(IDUSER) REFERENCES person(ID)
);


--LOG TABLE
CREATE TABLE LOG (
                                 IDLOG SERIAL PRIMARY KEY,
                                 LOGSTRING VARCHAR(1000) NULL
);

--TEST TABLE
CREATE TABLE NEWTEST (
                                  IDTEST SERIAL PRIMARY KEY,
                                  TESTCOLUMN VARCHAR(1000) NULL
);