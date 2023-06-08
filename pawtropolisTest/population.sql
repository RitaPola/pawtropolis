INSERT INTO items (id, name, description, occupied_slots)
VALUES
  (1, 'walkie talkie', 'Necessary to hear a friend in distress or to ask for help', 4),
  (2, 'banana', 'food', 1),
  (3, 'aqua', 'drink', 3),
  (4, 'Kalashnikov', 'gun', 6),
  (5, 'machete', 'cutting weapon', 4),
  (6, 'herbs', 'used to heal wounds', 1),
  (7, 'healing herb', 'Resident Evil style green herb', 3);

INSERT INTO animals (id, name, favorite_food, admission_date, weight, height)
VALUES
  (1, 'lion birichino', 'meat', '1996-08-30', 90.00, 7.50),
  (2, 'tiger wolf', 'meat', '2007-10-05', 75.00, 5.00),
  (3, 'lazialotto', 'meat', '2013-05-26', 50.00, 6.00);

INSERT INTO lions (id, tail_length, animal_id)
VALUES (1, 3.50, 1);

INSERT INTO tigers (id, tail_length, animal_id)
VALUES (2, 5.00, 2);

INSERT INTO eagles (id, wings_span, animal_id)
VALUES (3, 10.00, 3);

INSERT INTO rooms (id, name, item_id, animal_id)
VALUES
  (1, 'entrance', 1, 1),
  (2, 'kitchen', 2, NULL),
  (3, 'kitchen', 3, NULL),
  (4, 'armory', 4, 2),
  (5, 'armory', 5, NULL),
  (6, 'nursery', 6, 3),
  (7, 'nursery', 7, NULL);


INSERT INTO directions
VALUES(1, 'north'),
(2,'south'),
(3,'east'),
(4,'west');


INSERT INTO rooms_directions
VALUES(1, 1, 2, 1),
(2,2,3,2),
(3,3,4,4),
(4,3,2,1),
(5,4,3,3);

INSERT INTO bags
VALUES(1, 20);

INSERT INTO players
VALUES(1, 'Chris', DEFAULT, 1);