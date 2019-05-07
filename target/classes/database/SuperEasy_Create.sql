-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-03-18 22:41:35.144

-- tables
-- Table: Bidders
CREATE TABLE Bidders (
    Id_bidder int  NOT NULL,
    users_Id int  NOT NULL,
    id_subasta varchar(40)  NOT NULL,
    CONSTRAINT Bidders_pk PRIMARY KEY (Id_bidder)
);

-- Table: Items
CREATE TABLE Items (
    description varchar(250)  NOT NULL,
    marca varchar(20)  NOT NULL,
    modelo varchar(20)  NOT NULL,
    item_id varchar(40)  NOT NULL,
    CONSTRAINT Items_pk PRIMARY KEY (item_id)
);

-- Table: Ofertas
CREATE TABLE Ofertas (
    id_oferta int  NOT NULL,
    payMethod_id int  NOT NULL,
    bidders_Id int  NOT NULL,
    CONSTRAINT Ofertas_pk PRIMARY KEY (id_oferta)
);

-- Table: PayMethod
CREATE TABLE PayMethod (
    id_tipo int  NOT NULL,
    trueque boolean  NOT NULL,
    pago_jairitos int  NULL,
    CONSTRAINT PayMethod_pk PRIMARY KEY (id_tipo)
);

-- Table: Subastas
CREATE TABLE Subastas (
    id_subasta varchar(40)  NOT NULL,
    estado int  NOT NULL,
    hora_ini timestamp  NOT NULL,
    hora_fin timestamp  NOT NULL,
    precio_sugerido int  NOT NULL,
    precio_actual int NOT NULL,
    id_seller int  NOT NULL,
    Items_item_id varchar(40)  NOT NULL,
    CONSTRAINT Subastas_pk PRIMARY KEY (id_subasta)
);

-- Table: Truque
CREATE TABLE Truque (
    item_id varchar(40)  NOT NULL,
    tipo_id int  NOT NULL,
    CONSTRAINT Truque_pk PRIMARY KEY (item_id,tipo_id)
);

-- Table: Users
CREATE TABLE Users (
    id_users int  NOT NULL,
    name varchar(50)  NOT NULL,
    email varchar(50)  NOT NULL,
    phone int  NOT NULL,
    jairitos int  NOT NULL,
    jairitosFavor int  NOT NULL,
    jairitosCongelados int  NOT NULL,
    password varchar(50)  NOT NULL,
    CONSTRAINT Users_pk PRIMARY KEY (id_users)
);

-- foreign keys
-- Reference: Bidders_Subastas (table: Bidders)
ALTER TABLE Bidders ADD CONSTRAINT Bidders_Subastas
    FOREIGN KEY (id_subasta)
    REFERENCES Subastas (id_subasta)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Bidders_Users (table: Bidders)
ALTER TABLE Bidders ADD CONSTRAINT Bidders_Users
    FOREIGN KEY (users_Id)
    REFERENCES Users (id_users)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Ofertas_Bidders (table: Ofertas)
ALTER TABLE Ofertas ADD CONSTRAINT Ofertas_Bidders
    FOREIGN KEY (bidders_Id)
    REFERENCES Bidders (Id_bidder)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Ofertas_PayMethod (table: Ofertas)
ALTER TABLE Ofertas ADD CONSTRAINT Ofertas_PayMethod
    FOREIGN KEY (payMethod_id)
    REFERENCES PayMethod (id_tipo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Subastas_Items (table: Subastas)
ALTER TABLE Subastas ADD CONSTRAINT Subastas_Items
    FOREIGN KEY (Items_item_id)
    REFERENCES Items (item_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Subastas_Users (table: Subastas)
ALTER TABLE Subastas ADD CONSTRAINT Subastas_Users
    FOREIGN KEY (id_seller)
    REFERENCES Users (id_users)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Truque_Items (table: Truque)
ALTER TABLE Truque ADD CONSTRAINT Truque_Items
    FOREIGN KEY (item_id)
    REFERENCES Items (item_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Truque_PayMethod (table: Truque)
ALTER TABLE Truque ADD CONSTRAINT Truque_PayMethod
    FOREIGN KEY (tipo_id)
    REFERENCES PayMethod (id_tipo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

