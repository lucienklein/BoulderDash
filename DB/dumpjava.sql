-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.7.26 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Listage de la structure de la base pour boulderdash
CREATE DATABASE IF NOT EXISTS `boulderdash` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `boulderdash`;

-- Listage de la structure de la procédure boulderdash. callMap
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `callMap`(IN id INT)
BEGIN
SELECT map_structure
FROM MAP
Where map_ID = id;
END//
DELIMITER ;

-- Listage de la structure de la table boulderdash. map
CREATE TABLE IF NOT EXISTS `map` (
  `map_ID` int(11) NOT NULL AUTO_INCREMENT,
  `map_structure` varchar(9999) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  PRIMARY KEY (`map_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Listage des données de la table boulderdash.map : ~5 rows (environ)
/*!40000 ALTER TABLE `map` DISABLE KEYS */;
INSERT INTO `map` (`map_ID`, `map_structure`, `width`, `height`) VALUES
	(1, '0,0,0,0,0,0,\r\n0,2,1,1,1,0,\r\n0,3,4,1,3,0,\r\n0,1,1,1,1,0,\r\n0,1,1,1,6,0,\r\n0,0,0,0,0,0,', 6, 6),
	(2, '0,0,0,0,0,0,0,0,0,0,\r\n0,1,1,2,1,1,3,1,3,0,\r\n0,0,3,1,4,4,1,3,1,0,\r\n0,1,1,1,1,1,1,1,1,0,\r\n0,0,1,1,1,1,1,1,1,0,\r\n0,1,1,0,0,0,0,1,1,0,\r\n0,3,1,3,3,3,3,1,3,0,\r\n0,1,1,1,1,1,1,1,1,0,\r\n0,1,1,1,6,1,1,1,1,0,\r\n0,0,0,0,0,0,0,0,0,0,', 10, 10),
	(3, '0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,\r\n0,1,2,1,1,1,3,3,3,1,1,1,1,1,0,\r\n0,1,3,1,1,1,1,1,1,1,4,1,1,1,0,\r\n0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,\r\n0,1,3,3,3,1,4,1,1,1,1,1,1,1,0,\r\n0,1,1,1,1,1,1,1,3,3,3,1,1,1,0,\r\n0,1,1,1,1,1,3,3,3,0,0,0,0,0,0,\r\n0,1,1,1,1,1,1,1,1,3,3,3,1,1,0,\r\n0,1,1,9,1,1,1,1,1,1,1,1,1,6,0,\r\n0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,', 15, 10),
	(4, '0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,\r\n0,1,3,1,1,1,3,2,3,1,1,1,3,3,0,\r\n0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,\r\n0,1,1,1,9,1,1,0,1,1,4,1,1,1,0,\r\n0,1,1,4,3,1,1,0,1,1,3,4,1,1,0,\r\n0,1,1,3,1,1,1,0,1,1,1,3,1,1,0,\r\n0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,\r\n0,1,1,3,3,1,1,0,1,1,3,3,1,1,0,\r\n0,1,1,1,1,1,1,0,1,1,1,1,4,1,0,\r\n0,1,1,4,4,1,1,0,1,1,4,4,1,1,0,\r\n0,1,1,3,3,1,1,1,1,1,3,3,1,1,0,\r\n0,1,1,1,1,1,1,6,1,1,1,1,1,1,0,\r\n0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,', 15, 13),
	(5, '0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,\r\n0,2,1,3,3,3,3,3,3,3,3,3,3,3,0,\r\n0,3,1,1,4,1,1,1,1,1,4,1,1,3,0,\r\n0,3,3,3,3,3,3,3,3,3,3,3,1,3,0,\r\n0,0,0,0,0,0,0,0,0,0,0,3,1,3,0,\r\n0,0,0,0,0,0,0,0,0,0,0,3,4,3,0,\r\n0,3,3,3,3,3,3,3,3,3,3,3,1,3,0,\r\n0,3,1,1,1,1,4,1,1,1,1,1,1,3,0,\r\n0,3,1,3,3,3,3,3,3,3,3,3,3,3,0,\r\n0,3,4,0,0,0,0,0,0,0,0,0,0,0,0,\r\n0,3,1,0,0,0,0,0,0,0,0,0,0,0,0,\r\n0,3,1,3,3,3,3,3,3,3,3,3,3,3,0,\r\n0,3,1,1,1,1,4,1,1,1,1,1,1,6,0,\r\n0,3,3,3,3,3,3,3,3,3,3,3,3,3,0,\r\n0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,', 15, 15);
/*!40000 ALTER TABLE `map` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
