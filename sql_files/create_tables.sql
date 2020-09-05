CREATE TABLE Card
(
	name VARCHAR(100) NOT NULL,
	setCode VARCHAR(4),
	rarity VARCHAR(20),
	type VARCHAR(15),
	quantity INT,
	category VARCHAR(20),
	attribute VARCHAR(10),
	atk INT,
	def INT,
	lv INT,
	monsterType VARCHAR(20),
	PRIMARY KEY (name, setCode, rarity)
);