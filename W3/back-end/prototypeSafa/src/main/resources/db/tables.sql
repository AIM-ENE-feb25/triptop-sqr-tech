CREATE TABLE BuildingBlockType
(
    type VARCHAR(255) NOT NULL,
);

CREATE TABLE BuildingBlock
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    type        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    CONSTRAINT  fk_bb_type FOREIGN KEY (type) REFERENCES BuildingBlockType (type)
);

CREATE TABLE Activity
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    type        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    CONSTRAINT  fk_bb_type FOREIGN KEY (type) REFERENCES BuildingBlockType (type)
);

CREATE TABLE Booking
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    type        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    CONSTRAINT  fk_bb_type FOREIGN KEY (type) REFERENCES BuildingBlockType (type)
);

CREATE TABLE Transport
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    type        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    CONSTRAINT  fk_bb_type FOREIGN KEY (type) REFERENCES BuildingBlockType (type)
);