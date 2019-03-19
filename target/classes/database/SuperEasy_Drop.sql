-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-03-18 22:41:35.144

-- foreign keys
ALTER TABLE Bidders
    DROP CONSTRAINT Bidders_Subastas;

ALTER TABLE Bidders
    DROP CONSTRAINT Bidders_Users;

ALTER TABLE Ofertas
    DROP CONSTRAINT Ofertas_Bidders;

ALTER TABLE Ofertas
    DROP CONSTRAINT Ofertas_PayMethod;

ALTER TABLE Subastas
    DROP CONSTRAINT Subastas_Items;

ALTER TABLE Subastas
    DROP CONSTRAINT Subastas_Users;

ALTER TABLE Truque
    DROP CONSTRAINT Truque_Items;

ALTER TABLE Truque
    DROP CONSTRAINT Truque_PayMethod;

-- tables
DROP TABLE Bidders;

DROP TABLE Items;

DROP TABLE Ofertas;

DROP TABLE PayMethod;

DROP TABLE Subastas;

DROP TABLE Truque;

DROP TABLE Users;

-- End of file.

