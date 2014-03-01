CREATE DATABASE IF NOT EXISTS `userdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `userdb`;

CREATE table 'user' (
	userid int not null auto_increment,
	firstname varchar(255) DEFAULT null,
	lastname varchar(255) DEFAULT null,
	email varchar(255) DEFAULT null,
	username varchar(255) DEFAULT null,
	password varchar(255) DEFAULT null,
	primary key (userid)
)

GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' IDENTIFIED BY 'root' WITH GRANT OPTION;
CREATE user 'java'@'localhost' identified by 'eclipseisabitch';
grant all privileges on *.* to 'java'@'localhost';
	
-- Dumping data for table userdb.user: ~14 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`userid`, `firstname`, `lastname`, `email`, `username`, `password`) VALUES
	('Sherlyne', 'Francia', 'sherlyne@francia.com', 'sherlyne', 'francia'),
	('Denise', 'Francisco', 'denise@francisco.com', 'denise', 'francisco'),
	('Erwin', 'Sanchez', 'erwin@sanchez.com', 'erwin', 'sanchex'),
	('Frank', 'Rayo', 'frank@rayo.com', 'frank', 'rayo'),
	('Mark', 'Navata', 'mark@navata.com', 'mark', 'navata')
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

