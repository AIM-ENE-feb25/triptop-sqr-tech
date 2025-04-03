INSERT INTO FactoryBuildingBlock (type)
VALUES ('Activity'),
       ('Booking'),
       ('Transport');

INSERT INTO Activity (type, name, description)
VALUES
    ('Activity', 'Activity 1', 'Description for Activity 1'),
    ('Activity', 'Activity 2', 'Description for Activity 2'),
    ('Activity', 'Activity 3', 'Description for Activity 3');

INSERT INTO Booking (type, name, description)
VALUES
    ('Booking', 'Booking 1', 'Description for Booking 1'),
    ('Booking', 'Booking 2', 'Description for Booking 2'),
    ('Booking', 'Booking 3', 'Description for Booking 3');

INSERT INTO Transport (type, name, description)
VALUES
    ('Transport', 'Transport 1', 'Description for Transport 1'),
    ('Transport', 'Transport 2', 'Description for Transport 2'),
    ('Transport', 'Transport 3', 'Description for Transport 3');