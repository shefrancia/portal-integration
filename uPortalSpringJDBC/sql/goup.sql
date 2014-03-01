-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2014 at 05:54 PM
-- Server version: 5.5.32
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `goup`
--
CREATE DATABASE IF NOT EXISTS `goup` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `goup`;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `category_id` varchar(6) NOT NULL,
  `category_name` varchar(140) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`category_id`, `category_name`) VALUES
('AAS', 'Administration and Support'),
('CSSP', 'College of Social Sciences and Philosophy'),
('DORMS', 'Dormitories'),
('NONE', 'None');

-- --------------------------------------------------------

--
-- Table structure for table `myplace`
--

CREATE TABLE IF NOT EXISTS `myplace` (
  `user_id` varchar(11) NOT NULL,
  `place_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`place_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `myplace`
--

INSERT INTO `myplace` (`user_id`, `place_id`) VALUES
('1234', 23);

-- --------------------------------------------------------

--
-- Table structure for table `place`
--

CREATE TABLE IF NOT EXISTS `place` (
  `place_id` int(11) NOT NULL AUTO_INCREMENT,
  `place_name` varchar(300) NOT NULL,
  `place_alternate_name` varchar(200) NOT NULL,
  `place_category` varchar(6) NOT NULL DEFAULT 'NONE',
  `place_lat` decimal(20,10) NOT NULL,
  `place_long` decimal(20,10) NOT NULL,
  PRIMARY KEY (`place_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `place`
--

INSERT INTO `place` (`place_id`, `place_name`, `place_alternate_name`, `place_category`, `place_lat`, `place_long`) VALUES
(18, 'Vinzons Hall', '', 'AAS', '14.6542240000', '121.0734100000'),
(19, 'University Health Service', '', 'AAS', '14.6598450000', '121.0709850000'),
(20, 'Palma Hall', 'PH', 'CSSP', '14.6534610000', '121.0698170000'),
(22, 'Palma Hall Annex', 'PHAN', 'CSSP', '14.6536380000', '121.0711970000'),
(23, 'Kalayaan Residence Hall', 'Kalay', 'DORMS', '14.6588220000', '121.0690730000'),
(24, 'Molave Residence Hall', 'Molave', 'DORMS', '14.6578770000', '121.0678930000');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
