-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 03 Sty 2019, 08:55
-- Wersja serwera: 10.1.37-MariaDB
-- Wersja PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `projekt`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dostepnetreningi`
--

CREATE TABLE `dostepnetreningi` (
  `idTreningu` int(11) NOT NULL,
  `nazwa` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `idTreneraProwadzacego` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `data` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `czasTrwania` varchar(50) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `dostepnetreningi`
--

INSERT INTO `dostepnetreningi` (`idTreningu`, `nazwa`, `idTreneraProwadzacego`, `data`, `czasTrwania`) VALUES
(1, 'Aerobik', '1', '2019-01-03T08:00', '45'),
(2, 'Zumba', '2', '2019-01-03T10:00', '65');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `logindata`
--

CREATE TABLE `logindata` (
  `login` varchar(10) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(10) COLLATE utf8_polish_ci NOT NULL,
  `idUser` varchar(10) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `logindata`
--

INSERT INTO `logindata` (`login`, `password`, `idUser`) VALUES
('JN54', 'q', '1'),
('izaIza', 'q', '2'),
('jacus', 'q', '3');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `trenerzy`
--

CREATE TABLE `trenerzy` (
  `idTrenera` int(11) NOT NULL,
  `imie` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(50) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `trenerzy`
--

INSERT INTO `trenerzy` (`idTrenera`, `imie`, `nazwisko`) VALUES
(1, 'Adam', 'Nowak'),
(2, 'Michał', 'Motyka');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `IDuser` int(50) NOT NULL,
  `login` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `imie` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `telefon` varchar(50) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`IDuser`, `login`, `imie`, `nazwisko`, `email`, `telefon`) VALUES
(1, 'JN54', 'Jacek', 'Nowak', 'Nowak@cos.com', '123456789'),
(2, 'izaIza', 'Iza', 'Kowalska', 'IK@cos.com', '789456456'),
(3, 'jacus', 'Jacu?', 'Kolo', 'ewqeqw@wp.pl', '123456987');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
