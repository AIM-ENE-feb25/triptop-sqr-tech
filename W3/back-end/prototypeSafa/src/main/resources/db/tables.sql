CREATE TABLE FactoryBuildingBlock
(
    type VARCHAR(255) PRIMARY KEY
);

CREATE TABLE BuildingBlock
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    type        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    CONSTRAINT fk_buildingblock_type FOREIGN KEY (type) REFERENCES FactoryBuildingBlock (type)
);

CREATE TABLE Activity
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    type        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    CONSTRAINT fk_activity_type FOREIGN KEY (type) REFERENCES FactoryBuildingBlock (type)
);

CREATE TABLE Booking
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    type        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    CONSTRAINT fk_booking_type FOREIGN KEY (type) REFERENCES FactoryBuildingBlock (type)
);

CREATE TABLE Transport
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    type        VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    CONSTRAINT fk_transport_type FOREIGN KEY (type) REFERENCES FactoryBuildingBlock (type)
);