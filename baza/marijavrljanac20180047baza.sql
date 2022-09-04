/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.21-MariaDB : Database - marijavrljanac20180047baza
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`marijavrljanac20180047baza` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `marijavrljanac20180047baza`;

/*Table structure for table `gledalac` */

DROP TABLE IF EXISTS `gledalac`;

CREATE TABLE `gledalac` (
  `GledalacID` int(20) unsigned NOT NULL,
  `ImePrezime` varchar(255) NOT NULL,
  `DatumRodjenja` date NOT NULL,
  `BrojTelefona` varchar(30) NOT NULL,
  `NalogID` int(20) unsigned NOT NULL,
  PRIMARY KEY (`GledalacID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `gledalac` */

insert  into `gledalac`(`GledalacID`,`ImePrezime`,`DatumRodjenja`,`BrojTelefona`,`NalogID`) values 
(1,'Marija Vrljanac','1999-02-24','06012345678',1),
(2,'K1','2022-08-17','123456789',2),
(3,'Jana Janic','1999-01-01','0601234567',13),
(4,'A A','1999-01-01','0601234567',14);

/*Table structure for table `karta` */

DROP TABLE IF EXISTS `karta`;

CREATE TABLE `karta` (
  `PredstavaID` int(20) unsigned NOT NULL,
  `NalogID` int(20) unsigned NOT NULL,
  `KartaID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `Red` varchar(255) NOT NULL,
  `Kolona` int(4) NOT NULL,
  `Cena` double NOT NULL,
  `Rezervisana` int(20) NOT NULL,
  PRIMARY KEY (`PredstavaID`,`NalogID`,`KartaID`,`Rezervisana`),
  KEY `KartaID` (`KartaID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `karta` */

insert  into `karta`(`PredstavaID`,`NalogID`,`KartaID`,`Red`,`Kolona`,`Cena`,`Rezervisana`) values 
(1,1,2,'I',1,1200,0),
(2,1,1,'V',6,750,1),
(2,1,2,'IV',9,750,0),
(3,1,2,'I',1,1200,1);

/*Table structure for table `nalog` */

DROP TABLE IF EXISTS `nalog`;

CREATE TABLE `nalog` (
  `NalogID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `EmailAdresa` varchar(255) NOT NULL,
  `KorisnickoIme` varchar(50) NOT NULL,
  `Sifra` varchar(50) NOT NULL,
  PRIMARY KEY (`NalogID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `nalog` */

insert  into `nalog`(`NalogID`,`EmailAdresa`,`KorisnickoIme`,`Sifra`) values 
(1,'marija@gmail.com','marijavrljanac','marija'),
(2,'k1@gmail.com','k1','k1'),
(3,'k2@gmail.com','k2','k2'),
(13,'jana@gmail.com','jana','jana'),
(14,'a@gmail.com','a','a'),
(15,'vanja@gmail.com','vanja','vanja');

/*Table structure for table `predstava` */

DROP TABLE IF EXISTS `predstava`;

CREATE TABLE `predstava` (
  `PredstavaID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `NazivPredstave` varchar(255) NOT NULL,
  `DatumIzvodjenja` datetime NOT NULL,
  `Detalji` varchar(255) NOT NULL,
  `ScenaID` int(20) NOT NULL,
  PRIMARY KEY (`PredstavaID`,`ScenaID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `predstava` */

insert  into `predstava`(`PredstavaID`,`NazivPredstave`,`DatumIzvodjenja`,`Detalji`,`ScenaID`) values 
(1,'Antigona','2022-08-25 20:00:00','Tragicni sukob zasnovan na konfliktu izmedju drzave i porodice, izmedju vlasti i coveka, izmedju prava na jednoj i etike i morala na drugoj strani. ',1),
(2,'Magbet','2022-07-03 21:00:00','Za Direk su me vezali; pobeci Ne mogu nikud, vec ko medved svezan, Moram da bijem boj s huskacima',2),
(3,'Baal','2022-03-12 19:00:00','Dosao je da udahne. Da bi pronašao hrabrost za vatru duha i snagu srca izmedju sumnje i poboznosti. Dosao je zauvek da uziva, barem sada i ovde. ',1),
(4,'Dama s kamelijama','2022-02-23 20:00:00','Umetnicka vrednost Gospodje s kamelijama ne lezi u samoj ideji koju pisac obradjuje, nego u epizodama punim zivota i u smelo skiciranim pojavama iz pariskog polusveta.',1),
(7,'Nova predstava','2022-02-22 00:00:00','Fino.',1),
(17,'fe','2022-12-20 00:00:00','Neki opis...',2),
(21,'Jako dobra predstava','2022-12-21 00:00:00','Neki opis...',2),
(22,'Kad su cvetale tikve','2022-12-25 00:00:00','Neki opis...',2);

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `PredstavaID` int(20) NOT NULL,
  `NalogID` int(20) NOT NULL,
  `RacunID` int(20) NOT NULL,
  `DatumIVreme` datetime NOT NULL,
  `Iznos` double NOT NULL,
  `ZiroRacun` varchar(255) NOT NULL,
  `KartaID` int(20) NOT NULL,
  PRIMARY KEY (`PredstavaID`,`NalogID`,`RacunID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `racun` */

insert  into `racun`(`PredstavaID`,`NalogID`,`RacunID`,`DatumIVreme`,`Iznos`,`ZiroRacun`,`KartaID`) values 
(1,1,1,'2022-09-03 00:00:00',1200,'200123456789',1),
(1,1,2,'2022-09-03 00:00:00',1200,'200123456789',2),
(2,1,1,'2022-09-03 00:00:00',3600,'200123456789',1),
(2,1,2,'2022-09-03 00:00:00',750,'200123456789',2),
(3,1,2,'2022-09-04 00:00:00',3600,'200123456789',2),
(4,1,1,'2022-09-03 00:00:00',1200,'200123456789',1),
(22,1,1,'2022-09-04 00:00:00',7200,'200123456789',1);

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `PredstavaID` int(20) unsigned NOT NULL,
  `NalogID` int(20) unsigned NOT NULL,
  `RezervacijaID` int(20) unsigned NOT NULL,
  `ImePrezime` varchar(255) NOT NULL,
  `DatumIVreme` datetime NOT NULL,
  `BrojKarata` int(20) NOT NULL,
  PRIMARY KEY (`PredstavaID`,`NalogID`,`RezervacijaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`PredstavaID`,`NalogID`,`RezervacijaID`,`ImePrezime`,`DatumIVreme`,`BrojKarata`) values 
(1,1,1,'Marija Vrljanac','2022-09-03 00:00:00',2),
(2,1,1,'Marija Vrljanac','2022-07-03 00:00:00',3),
(21,1,1,'Marija Vrljanac','2022-09-04 00:00:00',8),
(22,1,1,'Marija Vrljanac','2022-12-25 00:00:00',3);

/*Table structure for table `scena` */

DROP TABLE IF EXISTS `scena`;

CREATE TABLE `scena` (
  `ScenaID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `NazivScene` varchar(255) NOT NULL,
  `Kapacitet` int(20) NOT NULL,
  PRIMARY KEY (`ScenaID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `scena` */

insert  into `scena`(`ScenaID`,`NazivScene`,`Kapacitet`) values 
(1,'Velika scena',180),
(2,'Mala scena',60);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
