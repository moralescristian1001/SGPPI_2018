-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-06-2018 a las 02:22:30
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sgppi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asesorias`
--

CREATE TABLE `asesorias` (
  `id_asesoria` int(11) NOT NULL,
  `id_equipo` int(11) DEFAULT NULL,
  `id_asesor` int(11) NOT NULL,
  `dia_semana` int(11) NOT NULL,
  `hora_semana` int(11) NOT NULL,
  `id_semestre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asesorias`
--

INSERT INTO `asesorias` (`id_asesoria`, `id_equipo`, `id_asesor`, `dia_semana`, `hora_semana`, `id_semestre`) VALUES
(8, NULL, 2, 3, 7, 3),
(10, 1, 3, 3, 6, 3),
(11, 2, 3, 3, 8, 3),
(12, 0, 3, 3, 7, 3),
(13, 1, 3, 1, 6, 3),
(19, 1, 1, 3, 6, 3),
(23, 2, 1, 2, 8, 3),
(24, NULL, 1, 2, 11, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `id_asignatura` int(11) NOT NULL,
  `codigo` varchar(8) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `semestre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`id_asignatura`, `codigo`, `nombre`, `semestre`) VALUES
(1, 'ING00817', 'Desarrollo del pensamiento analítico y Sistémico 1', 1),
(2, 'ING00812', 'Identificación del Ciclo de Vida del Software', 1),
(4, 'ING00822', 'Desarrollo del pensamiento analítico y Sistémico 2', 2),
(5, 'houfd', 'Construcción de elementos de software', 1),
(6, 'ING00829', 'Construcción de Bases de Datos 1', 3),
(7, 'ING00834', 'Garantizar el cumplimiento de los requerimientos d', 4),
(8, 'ING00828', 'Procesos de Soporte a Usuarios de Aplicaciones y d', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bonificacion`
--

CREATE TABLE `bonificacion` (
  `id_bonificacion` int(11) NOT NULL,
  `id_socializacion` int(11) NOT NULL,
  `id_tipo_bonificacion` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificacion`
--

CREATE TABLE `calificacion` (
  `id_calificacion` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `id_profesor` int(11) NOT NULL,
  `id_evento` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comentarios` varchar(200) DEFAULT NULL,
  `nota` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `califxsoc`
--

CREATE TABLE `califxsoc` (
  `id_califxsoc` int(11) NOT NULL,
  `id_calificador` int(11) NOT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `id_socializacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `id_cargo` int(11) NOT NULL,
  `descripcion` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`id_cargo`, `descripcion`) VALUES
(6, 'Administrador'),
(3, 'Asesor'),
(5, 'Coordinador'),
(1, 'Estudiante'),
(4, 'Evaluador'),
(2, 'Profesor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuadrante`
--

CREATE TABLE `cuadrante` (
  `id_cuadrante` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `id_asignatura` int(11) NOT NULL,
  `id_semestre` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuadrante`
--

INSERT INTO `cuadrante` (`id_cuadrante`, `numero`, `descripcion`, `id_asignatura`, `id_semestre`, `nombre`) VALUES
(6, 2, 'hola xd', 5, 1, 'test'),
(7, 2, 'hola xd', 4, 1, 'testto');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `id_equipo` int(11) NOT NULL,
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_semestre` int(11) NOT NULL,
  `id_asignatura` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`id_equipo`, `codigo`, `nombre`, `id_semestre`, `id_asignatura`) VALUES
(1, 500, 'SGPPIxDó', 3, 4),
(2, 1, 'Sof', 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantesxequipos`
--

CREATE TABLE `estudiantesxequipos` (
  `id_estxequip` int(11) NOT NULL,
  `id_estudiante` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiantesxequipos`
--

INSERT INTO `estudiantesxequipos` (`id_estxequip`, `id_estudiante`, `id_equipo`) VALUES
(13, 32, 2),
(14, 33, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento`
--

CREATE TABLE `evento` (
  `id_evento` int(11) NOT NULL,
  `id_tipo_evento` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `duracion_horas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `evento`
--

INSERT INTO `evento` (`id_evento`, `id_tipo_evento`, `fecha`, `duracion_horas`) VALUES
(1, 1, '2018-01-20 15:20:00', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notasxcalifxsoc`
--

CREATE TABLE `notasxcalifxsoc` (
  `id_notaxsocializacion` int(11) NOT NULL,
  `id_califxsoc` int(11) NOT NULL,
  `id_rubricaxitem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesoresxasignaturas`
--

CREATE TABLE `profesoresxasignaturas` (
  `id_profxasig` int(11) NOT NULL,
  `id_profesor` int(11) NOT NULL,
  `id_asignatura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profesoresxasignaturas`
--

INSERT INTO `profesoresxasignaturas` (`id_profxasig`, `id_profesor`, `id_asignatura`) VALUES
(56, 35, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rubrica`
--

CREATE TABLE `rubrica` (
  `id_rubrica` int(11) NOT NULL,
  `id_asignatura` int(11) NOT NULL,
  `descripcion` varchar(400) NOT NULL,
  `id_tipo_rubrica` int(11) NOT NULL,
  `id_socializacion` int(11) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rubricaxitem`
--

CREATE TABLE `rubricaxitem` (
  `id_rubricaxitem` int(11) NOT NULL,
  `id_rubrica` int(11) NOT NULL,
  `calificacion` int(11) NOT NULL,
  `descripcion_item` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salon`
--

CREATE TABLE `salon` (
  `id_salon` int(11) NOT NULL,
  `descripcion` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `salon`
--

INSERT INTO `salon` (`id_salon`, `descripcion`) VALUES
(1, 'P13 - 301'),
(2, 'P13 - 302');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salonxequipo`
--

CREATE TABLE `salonxequipo` (
  `id_salonxprofesores` int(11) NOT NULL,
  `id_salon` int(11) NOT NULL,
  `id_socializacion` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `salonxequipo`
--

INSERT INTO `salonxequipo` (`id_salonxprofesores`, `id_salon`, `id_socializacion`, `id_equipo`) VALUES
(32, 1, 1, 1),
(33, 2, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salonxprofesores`
--

CREATE TABLE `salonxprofesores` (
  `id_salonxprofesores` int(11) NOT NULL,
  `id_salon` int(11) NOT NULL,
  `id_socializacion` int(11) NOT NULL,
  `id_profesor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `salonxprofesores`
--

INSERT INTO `salonxprofesores` (`id_salonxprofesores`, `id_salon`, `id_socializacion`, `id_profesor`) VALUES
(36, 1, 1, 34),
(37, 1, 1, 35),
(38, 2, 1, 37);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguimiento`
--

CREATE TABLE `seguimiento` (
  `id_seguimiento` int(11) NOT NULL,
  `id_asesoria` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `observaciones` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `seguimiento`
--

INSERT INTO `seguimiento` (`id_seguimiento`, `id_asesoria`, `fecha`, `observaciones`) VALUES
(1, 19, '2018-05-06 00:51:11', 'dsa'),
(2, 19, '2018-05-06 00:51:24', 'dsadas'),
(3, 19, '2018-05-06 00:55:45', 'sdasdas'),
(4, 19, '2018-05-06 00:55:58', 'asdasd'),
(5, 19, '2018-05-06 00:56:08', 'dasdas'),
(6, 19, '2018-05-06 01:47:52', 'sss'),
(7, 19, '2018-05-12 19:05:08', 'ddadadas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguimiento_asistencia`
--

CREATE TABLE `seguimiento_asistencia` (
  `id_seg_asistencia` int(11) NOT NULL,
  `id_seguimiento` int(11) NOT NULL,
  `id_estudiante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `seguimiento_asistencia`
--

INSERT INTO `seguimiento_asistencia` (`id_seg_asistencia`, `id_seguimiento`, `id_estudiante`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 1),
(4, 4, 1),
(5, 5, 2),
(6, 5, 1),
(7, 6, 1),
(8, 7, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semestre`
--

CREATE TABLE `semestre` (
  `id_semestre` int(11) NOT NULL,
  `ano` int(11) NOT NULL,
  `numero` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `semestre`
--

INSERT INTO `semestre` (`id_semestre`, `ano`, `numero`) VALUES
(1, 2017, 1),
(2, 2017, 2),
(3, 2018, 1),
(4, 2018, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socializacion`
--

CREATE TABLE `socializacion` (
  `id_socializacion` int(11) NOT NULL,
  `id_evento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `socializacion`
--

INSERT INTO `socializacion` (`id_socializacion`, `id_evento`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socializacion_asistencia`
--

CREATE TABLE `socializacion_asistencia` (
  `id_soc_asistencia` int(11) NOT NULL,
  `id_socializacion` int(11) NOT NULL,
  `id_estudiante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud_asesoria`
--

CREATE TABLE `solicitud_asesoria` (
  `id_solicitud` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `dia_semana` int(11) NOT NULL,
  `hora_semana` int(11) NOT NULL,
  `aceptada` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_solicitud` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `solicitud_asesoria`
--

INSERT INTO `solicitud_asesoria` (`id_solicitud`, `id_equipo`, `dia_semana`, `hora_semana`, `aceptada`, `fecha_solicitud`) VALUES
(5, 1, 3, 7, 1, '2018-04-29 19:49:47'),
(6, 2, 3, 7, 0, '2018-05-11 20:54:41'),
(7, 1, 3, 10, 1, '2018-05-12 14:04:37');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_bonificacion`
--

CREATE TABLE `tipo_bonificacion` (
  `id_tipo_bonificacion` int(11) NOT NULL,
  `descripcion` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_evento`
--

CREATE TABLE `tipo_evento` (
  `id_tipo_evento` int(11) NOT NULL,
  `nombre_evento` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_evento`
--

INSERT INTO `tipo_evento` (`id_tipo_evento`, `nombre_evento`) VALUES
(1, 'Primera Socialización'),
(2, 'Segunda Socialización'),
(3, 'Primera Socialización (Feria)'),
(4, 'Segunda Socialización (Feria)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_rubrica`
--

CREATE TABLE `tipo_rubrica` (
  `id_tipo_rubrica` int(11) NOT NULL,
  `descripcion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_rubrica`
--

INSERT INTO `tipo_rubrica` (`id_tipo_rubrica`, `descripcion`) VALUES
(1, 'Criterios Tématicos'),
(2, 'Criterios Axiológicos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `fecha_nac` date DEFAULT NULL,
  `id_cargo` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `cedula` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `usuario`, `clave`, `nombre`, `apellidos`, `fecha_nac`, `id_cargo`, `estado`, `correo`, `cedula`) VALUES
(1, 'acardona', 'sss', 'Alejandro', 'Cardona', '2017-11-20', 6, 1, 'alejandro_cardona23161@elpoli.edu.co', '1017259590'),
(2, 'cristian', '123', 'Cristian', 'Morales', '2017-08-16', 3, 1, 'Cristian', '1002005142'),
(3, 'jmorales', '123', 'Juan', 'Morales', '1996-04-02', 3, 1, 'juan_morales23151@elpoli.edu.co', '178989156'),
(32, 'juan_morales23151@elpoli.edu.co ', '1212313', 'Juan Pablo', 'Morales Gomez', '1997-06-12', 1, 1, 'juan_morales23151@elpoli.edu.co ', '1212313'),
(33, 'cristian_morales@elpoli.edu.co', '75745378', 'Cristian', 'Morales Soto', '1998-05-30', 1, 1, 'cristian_morales@elpoli.edu.co', '75745378'),
(34, 'profesor_test@elpoli.edu.co', '753753', 'Rodrigo', 'Suarez', '1976-06-12', 2, 1, 'profesor_test@elpoli.edu.co', '753753'),
(35, 'juan_quintero@elpoli.edu.co', '45464564x', 'Juanx', 'Quinterox', '1980-01-07', 2, 1, 'juan_quintero@elpoli.edu.co', '45464564x'),
(36, 'ernesto_gutierrez@elpoli.edu.co', '45456456', 'Ernesto', 'Gutierrez', '1990-06-12', 3, 1, 'ernesto_gutierrez@elpoli.edu.co', '45456456'),
(37, 'javier_zapata@elpoli.edu.co', '444446', 'Javier', 'Zapata', '1981-06-12', 4, 1, 'javier_zapata@elpoli.edu.co', '444446'),
(38, 'carosero@elpoli.edu.co', '99999999', 'Claudia', 'Rosero', '1976-06-12', 5, 1, 'carosero@elpoli.edu.co', '99999999');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asesorias`
--
ALTER TABLE `asesorias`
  ADD PRIMARY KEY (`id_asesoria`),
  ADD KEY `id_asesor` (`id_asesor`),
  ADD KEY `id_semestre` (`id_semestre`);

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`id_asignatura`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `bonificacion`
--
ALTER TABLE `bonificacion`
  ADD PRIMARY KEY (`id_bonificacion`),
  ADD KEY `id_socializacion` (`id_socializacion`),
  ADD KEY `id_tipo_bonificacion` (`id_tipo_bonificacion`),
  ADD KEY `id_equipo` (`id_equipo`);

--
-- Indices de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD PRIMARY KEY (`id_calificacion`),
  ADD KEY `id_profesor` (`id_profesor`),
  ADD KEY `id_equipo` (`id_equipo`),
  ADD KEY `id_evento` (`id_evento`);

--
-- Indices de la tabla `califxsoc`
--
ALTER TABLE `califxsoc`
  ADD PRIMARY KEY (`id_califxsoc`),
  ADD KEY `id_calificador` (`id_calificador`),
  ADD KEY `id_socializacion` (`id_socializacion`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id_cargo`),
  ADD UNIQUE KEY `descripcion` (`descripcion`);

--
-- Indices de la tabla `cuadrante`
--
ALTER TABLE `cuadrante`
  ADD PRIMARY KEY (`id_cuadrante`),
  ADD KEY `id_semestre` (`id_semestre`),
  ADD KEY `id_asignatura` (`id_asignatura`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`id_equipo`),
  ADD KEY `id_semestre` (`id_semestre`),
  ADD KEY `id_asignatura` (`id_asignatura`);

--
-- Indices de la tabla `estudiantesxequipos`
--
ALTER TABLE `estudiantesxequipos`
  ADD PRIMARY KEY (`id_estxequip`),
  ADD KEY `id_estudiante` (`id_estudiante`),
  ADD KEY `estudiantesxequipos_ibfk_2` (`id_equipo`);

--
-- Indices de la tabla `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`id_evento`),
  ADD KEY `id_tipo_evento` (`id_tipo_evento`);

--
-- Indices de la tabla `notasxcalifxsoc`
--
ALTER TABLE `notasxcalifxsoc`
  ADD PRIMARY KEY (`id_notaxsocializacion`),
  ADD KEY `id_califxsoc` (`id_califxsoc`),
  ADD KEY `id_rubricaxitem` (`id_rubricaxitem`);

--
-- Indices de la tabla `profesoresxasignaturas`
--
ALTER TABLE `profesoresxasignaturas`
  ADD PRIMARY KEY (`id_profxasig`),
  ADD KEY `id_profesor` (`id_profesor`),
  ADD KEY `id_asignatura` (`id_asignatura`);

--
-- Indices de la tabla `rubrica`
--
ALTER TABLE `rubrica`
  ADD PRIMARY KEY (`id_rubrica`),
  ADD KEY `id_tipo_rubrica` (`id_tipo_rubrica`),
  ADD KEY `id_socializacion` (`id_socializacion`),
  ADD KEY `id_asignatura` (`id_asignatura`);

--
-- Indices de la tabla `rubricaxitem`
--
ALTER TABLE `rubricaxitem`
  ADD PRIMARY KEY (`id_rubricaxitem`),
  ADD KEY `id_rubrica` (`id_rubrica`);

--
-- Indices de la tabla `salon`
--
ALTER TABLE `salon`
  ADD PRIMARY KEY (`id_salon`);

--
-- Indices de la tabla `salonxequipo`
--
ALTER TABLE `salonxequipo`
  ADD PRIMARY KEY (`id_salonxprofesores`),
  ADD KEY `id_salon` (`id_salon`),
  ADD KEY `id_socializacion` (`id_socializacion`),
  ADD KEY `id_equipo` (`id_equipo`);

--
-- Indices de la tabla `salonxprofesores`
--
ALTER TABLE `salonxprofesores`
  ADD PRIMARY KEY (`id_salonxprofesores`),
  ADD KEY `id_salon` (`id_salon`),
  ADD KEY `id_socializacion` (`id_socializacion`),
  ADD KEY `id_profesor` (`id_profesor`);

--
-- Indices de la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  ADD PRIMARY KEY (`id_seguimiento`),
  ADD KEY `id_asesoria` (`id_asesoria`);

--
-- Indices de la tabla `seguimiento_asistencia`
--
ALTER TABLE `seguimiento_asistencia`
  ADD PRIMARY KEY (`id_seg_asistencia`),
  ADD KEY `id_seguimiento` (`id_seguimiento`),
  ADD KEY `id_estudiante` (`id_estudiante`);

--
-- Indices de la tabla `semestre`
--
ALTER TABLE `semestre`
  ADD PRIMARY KEY (`id_semestre`);

--
-- Indices de la tabla `socializacion`
--
ALTER TABLE `socializacion`
  ADD PRIMARY KEY (`id_socializacion`),
  ADD KEY `id_evento` (`id_evento`);

--
-- Indices de la tabla `socializacion_asistencia`
--
ALTER TABLE `socializacion_asistencia`
  ADD PRIMARY KEY (`id_soc_asistencia`),
  ADD KEY `id_socializacion` (`id_socializacion`),
  ADD KEY `id_estudiante` (`id_estudiante`);

--
-- Indices de la tabla `solicitud_asesoria`
--
ALTER TABLE `solicitud_asesoria`
  ADD PRIMARY KEY (`id_solicitud`),
  ADD KEY `id_equipo` (`id_equipo`);

--
-- Indices de la tabla `tipo_bonificacion`
--
ALTER TABLE `tipo_bonificacion`
  ADD PRIMARY KEY (`id_tipo_bonificacion`);

--
-- Indices de la tabla `tipo_evento`
--
ALTER TABLE `tipo_evento`
  ADD PRIMARY KEY (`id_tipo_evento`);

--
-- Indices de la tabla `tipo_rubrica`
--
ALTER TABLE `tipo_rubrica`
  ADD PRIMARY KEY (`id_tipo_rubrica`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `usuario` (`usuario`),
  ADD KEY `id_cargo` (`id_cargo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asesorias`
--
ALTER TABLE `asesorias`
  MODIFY `id_asesoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  MODIFY `id_asignatura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `bonificacion`
--
ALTER TABLE `bonificacion`
  MODIFY `id_bonificacion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  MODIFY `id_calificacion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `califxsoc`
--
ALTER TABLE `califxsoc`
  MODIFY `id_califxsoc` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id_cargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `cuadrante`
--
ALTER TABLE `cuadrante`
  MODIFY `id_cuadrante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `id_equipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `estudiantesxequipos`
--
ALTER TABLE `estudiantesxequipos`
  MODIFY `id_estxequip` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de la tabla `evento`
--
ALTER TABLE `evento`
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `notasxcalifxsoc`
--
ALTER TABLE `notasxcalifxsoc`
  MODIFY `id_notaxsocializacion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `profesoresxasignaturas`
--
ALTER TABLE `profesoresxasignaturas`
  MODIFY `id_profxasig` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT de la tabla `rubrica`
--
ALTER TABLE `rubrica`
  MODIFY `id_rubrica` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `rubricaxitem`
--
ALTER TABLE `rubricaxitem`
  MODIFY `id_rubricaxitem` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `salon`
--
ALTER TABLE `salon`
  MODIFY `id_salon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `salonxequipo`
--
ALTER TABLE `salonxequipo`
  MODIFY `id_salonxprofesores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT de la tabla `salonxprofesores`
--
ALTER TABLE `salonxprofesores`
  MODIFY `id_salonxprofesores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT de la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  MODIFY `id_seguimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `seguimiento_asistencia`
--
ALTER TABLE `seguimiento_asistencia`
  MODIFY `id_seg_asistencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `semestre`
--
ALTER TABLE `semestre`
  MODIFY `id_semestre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `socializacion`
--
ALTER TABLE `socializacion`
  MODIFY `id_socializacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `socializacion_asistencia`
--
ALTER TABLE `socializacion_asistencia`
  MODIFY `id_soc_asistencia` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `solicitud_asesoria`
--
ALTER TABLE `solicitud_asesoria`
  MODIFY `id_solicitud` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `tipo_bonificacion`
--
ALTER TABLE `tipo_bonificacion`
  MODIFY `id_tipo_bonificacion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tipo_evento`
--
ALTER TABLE `tipo_evento`
  MODIFY `id_tipo_evento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tipo_rubrica`
--
ALTER TABLE `tipo_rubrica`
  MODIFY `id_tipo_rubrica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asesorias`
--
ALTER TABLE `asesorias`
  ADD CONSTRAINT `asesorias_ibfk_1` FOREIGN KEY (`id_asesor`) REFERENCES `usuarios` (`id_usuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `asesorias_ibfk_2` FOREIGN KEY (`id_semestre`) REFERENCES `semestre` (`id_semestre`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `bonificacion`
--
ALTER TABLE `bonificacion`
  ADD CONSTRAINT `bonificacion_ibfk_1` FOREIGN KEY (`id_socializacion`) REFERENCES `socializacion` (`id_socializacion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `bonificacion_ibfk_2` FOREIGN KEY (`id_tipo_bonificacion`) REFERENCES `tipo_bonificacion` (`id_tipo_bonificacion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `bonificacion_ibfk_3` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD CONSTRAINT `calificacion_ibfk_1` FOREIGN KEY (`id_profesor`) REFERENCES `usuarios` (`id_usuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `calificacion_ibfk_2` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `calificacion_ibfk_3` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`id_evento`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `califxsoc`
--
ALTER TABLE `califxsoc`
  ADD CONSTRAINT `califxsoc_ibfk_1` FOREIGN KEY (`id_calificador`) REFERENCES `usuarios` (`id_usuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `califxsoc_ibfk_2` FOREIGN KEY (`id_socializacion`) REFERENCES `socializacion` (`id_socializacion`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `cuadrante`
--
ALTER TABLE `cuadrante`
  ADD CONSTRAINT `cuadrante_ibfk_1` FOREIGN KEY (`id_semestre`) REFERENCES `semestre` (`id_semestre`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cuadrante_ibfk_2` FOREIGN KEY (`id_asignatura`) REFERENCES `asignatura` (`id_asignatura`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`id_semestre`) REFERENCES `semestre` (`id_semestre`) ON UPDATE CASCADE,
  ADD CONSTRAINT `equipo_ibfk_2` FOREIGN KEY (`id_asignatura`) REFERENCES `asignatura` (`id_asignatura`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `estudiantesxequipos`
--
ALTER TABLE `estudiantesxequipos`
  ADD CONSTRAINT `estudiantesxequipos_ibfk_1` FOREIGN KEY (`id_estudiante`) REFERENCES `usuarios` (`id_usuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `estudiantesxequipos_ibfk_2` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `evento_ibfk_1` FOREIGN KEY (`id_tipo_evento`) REFERENCES `tipo_evento` (`id_tipo_evento`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `notasxcalifxsoc`
--
ALTER TABLE `notasxcalifxsoc`
  ADD CONSTRAINT `notasxcalifxsoc_ibfk_1` FOREIGN KEY (`id_califxsoc`) REFERENCES `califxsoc` (`id_califxsoc`) ON UPDATE CASCADE,
  ADD CONSTRAINT `notasxcalifxsoc_ibfk_2` FOREIGN KEY (`id_rubricaxitem`) REFERENCES `rubricaxitem` (`id_rubricaxitem`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `profesoresxasignaturas`
--
ALTER TABLE `profesoresxasignaturas`
  ADD CONSTRAINT `profesoresxasignaturas_ibfk_1` FOREIGN KEY (`id_profesor`) REFERENCES `usuarios` (`id_usuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `profesoresxasignaturas_ibfk_2` FOREIGN KEY (`id_asignatura`) REFERENCES `asignatura` (`id_asignatura`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `rubrica`
--
ALTER TABLE `rubrica`
  ADD CONSTRAINT `rubrica_ibfk_1` FOREIGN KEY (`id_tipo_rubrica`) REFERENCES `tipo_rubrica` (`id_tipo_rubrica`) ON UPDATE CASCADE,
  ADD CONSTRAINT `rubrica_ibfk_2` FOREIGN KEY (`id_socializacion`) REFERENCES `socializacion` (`id_socializacion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `rubrica_ibfk_3` FOREIGN KEY (`id_asignatura`) REFERENCES `asignatura` (`id_asignatura`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `rubricaxitem`
--
ALTER TABLE `rubricaxitem`
  ADD CONSTRAINT `rubricaxitem_ibfk_1` FOREIGN KEY (`id_rubrica`) REFERENCES `rubrica` (`id_rubrica`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `salonxequipo`
--
ALTER TABLE `salonxequipo`
  ADD CONSTRAINT `salonxequipo_ibfk_1` FOREIGN KEY (`id_salon`) REFERENCES `salon` (`id_salon`) ON UPDATE CASCADE,
  ADD CONSTRAINT `salonxequipo_ibfk_2` FOREIGN KEY (`id_socializacion`) REFERENCES `socializacion` (`id_socializacion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `salonxequipo_ibfk_3` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `salonxprofesores`
--
ALTER TABLE `salonxprofesores`
  ADD CONSTRAINT `salonxprofesores_ibfk_1` FOREIGN KEY (`id_salon`) REFERENCES `salon` (`id_salon`) ON UPDATE CASCADE,
  ADD CONSTRAINT `salonxprofesores_ibfk_2` FOREIGN KEY (`id_socializacion`) REFERENCES `socializacion` (`id_socializacion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `salonxprofesores_ibfk_3` FOREIGN KEY (`id_profesor`) REFERENCES `usuarios` (`id_usuario`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  ADD CONSTRAINT `seguimiento_ibfk_1` FOREIGN KEY (`id_asesoria`) REFERENCES `asesorias` (`id_asesoria`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `seguimiento_asistencia`
--
ALTER TABLE `seguimiento_asistencia`
  ADD CONSTRAINT `seguimiento_asistencia_ibfk_1` FOREIGN KEY (`id_seguimiento`) REFERENCES `seguimiento` (`id_seguimiento`) ON UPDATE CASCADE,
  ADD CONSTRAINT `seguimiento_asistencia_ibfk_2` FOREIGN KEY (`id_estudiante`) REFERENCES `usuarios` (`id_usuario`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `socializacion`
--
ALTER TABLE `socializacion`
  ADD CONSTRAINT `socializacion_ibfk_2` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`id_evento`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `socializacion_asistencia`
--
ALTER TABLE `socializacion_asistencia`
  ADD CONSTRAINT `socializacion_asistencia_ibfk_1` FOREIGN KEY (`id_socializacion`) REFERENCES `socializacion` (`id_socializacion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `socializacion_asistencia_ibfk_2` FOREIGN KEY (`id_estudiante`) REFERENCES `usuarios` (`id_usuario`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `solicitud_asesoria`
--
ALTER TABLE `solicitud_asesoria`
  ADD CONSTRAINT `solicitud_asesoria_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
