-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-03-2026 a las 18:58:27
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `umg`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `AluCodigo` int(11) NOT NULL,
  `AluNombre` varchar(100) NOT NULL,
  `AluDireccion` varchar(150) DEFAULT NULL,
  `AluEstatus` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacióncursosalumnos`
--

CREATE TABLE `asignacióncursosalumnos` (
  `CarCodigo` int(11) NOT NULL,
  `CurCodigo` int(11) NOT NULL,
  `MaeCodigo` int(11) NOT NULL,
  `AluCodigo` int(11) NOT NULL,
  `AcaNota` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `CarCodigo` int(11) NOT NULL,
  `CarNombre` varchar(100) NOT NULL,
  `CarEstatus` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `CurCodigo` int(11) NOT NULL,
  `CurNombre` varchar(100) NOT NULL,
  `CurEstatus` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestros`
--

CREATE TABLE `maestros` (
  `MaeCodigo` int(11) NOT NULL,
  `MaeNombre` varchar(100) NOT NULL,
  `MaeDireccion` varchar(150) DEFAULT NULL,
  `MaeEstatus` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`AluCodigo`);

--
-- Indices de la tabla `asignacióncursosalumnos`
--
ALTER TABLE `asignacióncursosalumnos`
  ADD PRIMARY KEY (`CarCodigo`,`CurCodigo`,`MaeCodigo`,`AluCodigo`),
  ADD KEY `CurCodigo` (`CurCodigo`),
  ADD KEY `MaeCodigo` (`MaeCodigo`),
  ADD KEY `AluCodigo` (`AluCodigo`);

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`CarCodigo`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`CurCodigo`);

--
-- Indices de la tabla `maestros`
--
ALTER TABLE `maestros`
  ADD PRIMARY KEY (`MaeCodigo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignacióncursosalumnos`
--
ALTER TABLE `asignacióncursosalumnos`
  ADD CONSTRAINT `asignacióncursosalumnos_ibfk_1` FOREIGN KEY (`CarCodigo`) REFERENCES `carreras` (`CarCodigo`),
  ADD CONSTRAINT `asignacióncursosalumnos_ibfk_2` FOREIGN KEY (`CurCodigo`) REFERENCES `cursos` (`CurCodigo`),
  ADD CONSTRAINT `asignacióncursosalumnos_ibfk_3` FOREIGN KEY (`MaeCodigo`) REFERENCES `maestros` (`MaeCodigo`),
  ADD CONSTRAINT `asignacióncursosalumnos_ibfk_4` FOREIGN KEY (`AluCodigo`) REFERENCES `alumnos` (`AluCodigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
