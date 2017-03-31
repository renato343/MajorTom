DROP DATABASE majorTom;
CREATE DATABASE majorTom;
USE majorTom;

CREATE TABLE user(
  id INT NOT NULL UNIQUE AUTO_INCREMENT,
  username CHAR(50) NOT NULL UNIQUE,
  password CHAR(16) NOT NULL,
  planet CHAR(40),
  score_houston int,
  score_spaceship int,
  date_score TIMESTAMP,
  PRIMARY KEY (id)
);