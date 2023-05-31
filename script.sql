
CREATE TABLE bag (
  id INTEGER PRIMARY KEY,
  total_slots INTEGER NOT NULL
);

CREATE TABLE item (
  id INTEGER PRIMARY KEY,
  name VARCHAR(256) NOT NULL,
  description VARCHAR(256) NOT NULL,
  occupied_slots INTEGER,
  bag_id INTEGER,
  FOREIGN KEY (bag_id) REFERENCES bag(id)
);

CREATE TABLE player (
  id INTEGER PRIMARY KEY,
  name VARCHAR(256) NOT NULL UNIQUE,
  health INTEGER DEFAULT 20 CHECK (health >= 0 AND health <= 100),
  bag_id INTEGER,
  FOREIGN KEY (bag_id) REFERENCES bag(id)
);

CREATE TABLE animal (
  id INTEGER PRIMARY KEY,
  name VARCHAR(256) NOT NULL,
  favorite_food VARCHAR(256) NOT NULL,
  admission_date DATE NOT NULL,
  weight DECIMAL(5,2) NOT NULL,
  height DECIMAL(5,2) NOT NULL
);

CREATE TABLE tiger (
  id INTEGER PRIMARY KEY,
  tail_length DECIMAL(5,2) NOT NULL,
  animal_id INTEGER,
  FOREIGN KEY (animal_id) REFERENCES animal(id)
);

CREATE TABLE lion (
  id INTEGER PRIMARY KEY,
  tail_length DECIMAL(5,2) NOT NULL,
  animal_id INTEGER,
  FOREIGN KEY (animal_id) REFERENCES animal(id)
);

CREATE TABLE eagle (
  id INTEGER PRIMARY KEY,
  wings_span DECIMAL(5,2) NOT NULL,
  animal_id INTEGER,
  FOREIGN KEY (animal_id) REFERENCES animal(id)
);

CREATE TABLE room (
  id INTEGER PRIMARY KEY,
  name VARCHAR(256) NOT NULL,
  item_id INTEGER,
  animal_id INTEGER,
  FOREIGN KEY (item_id) REFERENCES item(id),
  FOREIGN KEY (animal_id) REFERENCES animal(id)
);

CREATE TABLE direction (
  id INTEGER PRIMARY KEY,
  name VARCHAR(256) NOT NULL
);

CREATE TABLE room_direction (
  id INTEGER PRIMARY KEY,
  room1_id INTEGER,
  room2_id INTEGER,
  direction_id INTEGER,
  FOREIGN KEY (room1_id) REFERENCES room(id),
  FOREIGN KEY (room2_id) REFERENCES room(id),
  FOREIGN KEY (direction_id) REFERENCES direction(id)
);

INSERT INTO item (id, name, description, occupied_slots)
VALUES
  (1, 'walkie talkie', 'Necessary to hear a friend in distress or to ask for help', 4),
  (2, 'banana', 'food', 1),
  (3, 'aqua', 'drink', 3),
  (4, 'Kalashnikov', 'gun', 6),
  (5, 'machete', 'cutting weapon', 4),
  (6, 'herbs', 'used to heal wounds', 1),
  (7, 'healing herb', 'Resident Evil style green herb', 3);

INSERT INTO animal (id, name, favorite_food, admission_date, weight, height)
VALUES
  (1, 'lion birichino', 'meat', '1996-08-30', 90.00, 7.50),
  (2, 'tiger wolf', 'meat', '2007-10-05', 75.00, 5.00),
  (3, 'lazialotto', 'meat', '2013-05-26', 50.00, 6.00);

INSERT INTO lion (id, tail_length, animal_id)
VALUES (1, 3.50, 1);

INSERT INTO tiger (id, tail_length, animal_id)
VALUES (2, 5.00, 2);

INSERT INTO eagle (id, wings_span, animal_id)
VALUES (3, 10.00, 3);

INSERT INTO room (id, name, item_id, animal_id)
VALUES
  (1, 'entrance', 1, 1),
  (2, 'kitchen', 2, NULL),
  (3, 'armory', 4, 2),
  (4, 'nursery', 6, 3);


INSERT INTO direction
VALUES(1, 'north'),
(2,'south'),
(3,'east'),
(4,'west');


INSERT INTO room_direction
VALUES(1, 1, 2, 1),
(2,2,3,2),
(3,3,4,4),
(4,3,2,1),
(5,4,3,3);
