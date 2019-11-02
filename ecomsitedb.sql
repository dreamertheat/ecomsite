-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for springboot
CREATE DATABASE IF NOT EXISTS `springboottest` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `springboottest`;

-- Dumping structure for table springboot.about
CREATE TABLE IF NOT EXISTS `about` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `description` text DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `date` text DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.about: ~5 rows (approximately)
/*!40000 ALTER TABLE `about` DISABLE KEYS */;
INSERT INTO `about` (`_id`, `name`, `description`, `sequence`, `date`) VALUES
	(1, 'location', 'San Mateo City, Philippines', 1, '10-18-2019'),
	(2, 'Vision', 'Build the best product, cause no unnecessary harm, use business to inspire and implement solutions to the environmental crisis.', 3, '10-18-2019'),
	(3, 'Mission', '"Our mission is to empower every person and every organization on the planet to achieve more.', 2, '10-18-2019'),
	(32, 'Contact us', '+639664466316', 4, 'Oct/25/2019 05:16:18'),
	(38, 'conversion', 'software version 0.o', 13, 'Oct/30/2019 03:21:58');
/*!40000 ALTER TABLE `about` ENABLE KEYS */;

-- Dumping structure for table springboot.authorities
CREATE TABLE IF NOT EXISTS `authorities` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` text NOT NULL DEFAULT '0',
  `authority` text NOT NULL DEFAULT '0',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table springboot.authorities: ~2 rows (approximately)
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` (`_id`, `username`, `authority`) VALUES
	(1, 'adminer', 'ROLE_ADMIN'),
	(2, 'admin', 'ROLE_ADMIN'),
	(3, 'boboxxx', 'ROLE_GUEST');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;

-- Dumping structure for table springboot.users
CREATE TABLE IF NOT EXISTS `users` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` text NOT NULL,
  `last_name` text NOT NULL,
  `address` text NOT NULL,
  `birthdate` text DEFAULT NULL,
  `enabled` int(11) NOT NULL DEFAULT 1,
  `notes` text DEFAULT NULL,
  `username` longtext DEFAULT NULL,
  `password` longtext DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='basic user info table';

-- Dumping data for table springboot.users: ~4 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`_id`, `first_name`, `last_name`, `address`, `birthdate`, `enabled`, `notes`, `username`, `password`) VALUES
	(1, 'Jacobo', 'Thomasian', 'Quezon City', '12-20-1988', 1, NULL, 'adminer', '1e5334caed399aed8b9abba51ee8bb94'),
	(2, 'Vernardium', 'Apostolophus', 'Veria, Greece', '12-20-1992', 1, NULL, 'Vernardium', '827ccb0eea8a706c4c34a16891f84e7b'),
	(3, 'Wingardia', 'Epistles', 'Thessoliniki, Greece', '05-20-1992', 1, NULL, 'ADMIN', '73acd9a5972130b75066c82595a1fae3'),
	(4, 'Volder', 'Morte', 'Hogwarts, Englatera', '05-20-1870', 1, NULL, 'boboxxx', '8c6464ec2666f73376599f13562c5a12');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
