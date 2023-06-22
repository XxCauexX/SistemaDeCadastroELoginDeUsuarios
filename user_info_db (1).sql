-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22/06/2023 às 23:00
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `user_info_db`
--
CREATE DATABASE IF NOT EXISTS `user_info_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `user_info_db`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tarefa`
--

CREATE TABLE IF NOT EXISTS `tarefa` (
  `cod_tarefas` varchar(100) NOT NULL,
  `titulo` varchar(10) NOT NULL,
  `descricao` varchar(350) DEFAULT NULL,
  `dataCriacao` timestamp NOT NULL DEFAULT current_timestamp(),
  `dataConclusao` datetime NOT NULL,
  `codUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_tarefas`),
  KEY `codUsuario` (`codUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuariocadastro`
--

CREATE TABLE IF NOT EXISTS `usuariocadastro` (
  `codUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(32) NOT NULL,
  PRIMARY KEY (`codUsuario`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `tarefa`
--
ALTER TABLE `tarefa`
  ADD CONSTRAINT `tarefa_ibfk_1` FOREIGN KEY (`codUsuario`) REFERENCES `usuariocadastro` (`codUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
