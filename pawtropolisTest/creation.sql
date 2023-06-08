CREATE TABLE items (
  id INTEGER PRIMARY KEY,
  name VARCHAR(256) NOT NULL,
  description VARCHAR(256) NOT NULL,
  occupied_slots INTEGER
);
CREATE TABLE bags (
 id INTEGER PRIMARY KEY,
 total_slots INTEGER NOT NULL,
 items_id INTEGER,
 FOREIGN KEY (items_id) REFERENCES items(id)
);

CREATE TABLE players (
  id INTEGER PRIMARY KEY,
  name VARCHAR(256) NOT NULL UNIQUE,
  health INTEGER DEFAULT 20 CHECK (health >= 0 AND health <= 100),
  bag_id INTEGER,
  FOREIGN KEY (bag_id) REFERENCES bags(id)
);

CREATE TABLE animals (
  id INTEGER PRIMARY KEY,
  name VARCHAR(256) NOT NULL,
  favorite_food VARCHAR(256) NOT NULL,
  admission_date DATE NOT NULL,
  weight DECIMAL(5,2) NOT NULL,
  height DECIMAL(5,2) NOT NULL
);

CREATE TABLE tigers (
  id INTEGER PRIMARY KEY,
  tail_length DECIMAL(5,2) NOT NULL,
  animal_id INTEGER,
  FOREIGN KEY (animal_id) REFERENCES animals(id)
);

CREATE TABLE lions (
  id INTEGER PRIMARY KEY,
  tail_length DECIMAL(5,2) NOT NULL,
  animal_id INTEGER,
  FOREIGN KEY (animal_id) REFERENCES animals(id)
);

CREATE TABLE eagles (
  id INTEGER PRIMARY KEY,
  wings_span DECIMAL(5,2) NOT NULL,
  animal_id INTEGER,
  FOREIGN KEY (animal_id) REFERENCES animals(id)
);

CREATE TABLE rooms (
  id INTEGER PRIMARY KEY,
  name VARCHAR(256) NOT NULL,
  item_id INTEGER,
  animal_id INTEGER,
  FOREIGN KEY (item_id) REFERENCES items(id),
  FOREIGN KEY (animal_id) REFERENCES animals(id)
);

CREATE TABLE directions (
  id INTEGER PRIMARY KEY,
  name VARCHAR(256) NOT NULL
);

CREATE TABLE rooms_directions (
  id INTEGER PRIMARY KEY,
  room1_id INTEGER,
  room2_id INTEGER,
  direction_id INTEGER,
  FOREIGN KEY (room1_id) REFERENCES rooms(id),
  FOREIGN KEY (room2_id) REFERENCES rooms(id),
  FOREIGN KEY (direction_id) REFERENCES directions(id)
);
