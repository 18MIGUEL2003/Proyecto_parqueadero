-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-06-2023 a las 02:26:39
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdparqueadero`
--
CREATE DATABASE IF NOT EXISTS `bdparqueadero` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bdparqueadero`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `id` int(11) NOT NULL,
  `placa` varchar(10) DEFAULT NULL,
  `propietario` varchar(100) DEFAULT NULL,
  `tipovehiculo` varchar(50) DEFAULT NULL,
  `horaentrada` datetime DEFAULT NULL,
  `horasalida` datetime DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `valorpagado` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`id`, `placa`, `propietario`, `tipovehiculo`, `horaentrada`, `horasalida`, `estado`, `valorpagado`) VALUES
(1, 'fdf235', 'CESAR PEREZ', 'Motocicleta', '2023-06-14 11:55:41', '2023-06-14 12:06:40', 'No Disponible', 166.66),
(2, 'po12', 'davd espinoza', 'Automovil', '2023-06-14 18:23:48', NULL, 'Disponible', NULL),
(3, 'ty78', 'jhon carrasco', 'Automovil', '2023-06-14 18:26:27', NULL, 'Disponible', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
