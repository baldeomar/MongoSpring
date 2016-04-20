-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mer 20 Avril 2016 à 16:32
-- Version du serveur: 5.5.47-0ubuntu0.14.04.1
-- Version de PHP: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données: `test`
--

-- --------------------------------------------------------

--
-- Structure de la table `Person`
--

CREATE TABLE IF NOT EXISTS `Person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `profil_fk` int(11) NOT NULL,
  PRIMARY KEY (`person_id`),
  KEY `profil_fk` (`profil_fk`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Profil`
--

CREATE TABLE IF NOT EXISTS `Profil` (
  `profil_id` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(200) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `date_de_naissance` varchar(12) NOT NULL,
  PRIMARY KEY (`profil_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Person`
--
ALTER TABLE `Person`
  ADD CONSTRAINT `Person_ibfk_1` FOREIGN KEY (`profil_fk`) REFERENCES `Profil` (`profil_id`);
