CREATE DATABASE `iview`;

USE iview;

CREATE TABLE IF NOT EXISTS `projects` (
  `projectid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `projectname` varchar(50) DEFAULT NULL,
  `changenumber` varchar(255) DEFAULT NULL,
  `projectidentifier` varchar(255) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `shortdescription` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`projectid`)
);


INSERT INTO `projects` (`projectid`, `projectname`, `changenumber`, `status`, `shortdescription`) VALUES (1, 'Project1', 'INC001', 'Open For Edit', 'This is Project 01');
INSERT INTO `projects` (`projectid`, `projectname`, `changenumber`, `status`, `shortdescription`) VALUES (2, 'Project2', 'INC002', 'Open For Edit', 'This is Project 02\r\n');

