-- removed  ENGINE=InnoDB and DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci options,
-- which are specific to MySQL and are not necessary in H2

DROP TABLE IF EXISTS designpattern;
CREATE TABLE designpattern (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  beschreibung VARCHAR(255) NOT NULL
);

INSERT INTO designpattern (name, beschreibung)
VALUES ('MVC', 'Trennung Daten und View'),
       ('Singleton', 'Nur eine Instanz'),
       ('Strategy', 'Algorithmus kapseln');