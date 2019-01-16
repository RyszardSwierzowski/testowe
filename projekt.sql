-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 16 Sty 2019, 21:04
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
-- Struktura tabeli dla tabeli `listatreningow`
--

CREATE TABLE `listatreningow` (
  `idTreningu` int(11) NOT NULL,
  `nazwa` varchar(50) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `listatreningow`
--

INSERT INTO `listatreningow` (`idTreningu`, `nazwa`) VALUES
(1, 'Aerobik'),
(2, 'Redukcja Wagi'),
(3, 'Rowerki'),
(4, 'Zajęcia Siłowe'),
(5, 'Zumba');

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
('jacus', 'q', '3'),
('admin', 'admin', '4'),
('ewqeqwe', 'Qwerty123!', '5'),
('dasdassda', 'dasdassda', '6'),
('dasdassda', '123456789', '7'),
('dasdassda', 'dasdassda', '8'),
('dasdassda', 'ewqeqweaa', '9'),
('wqerptl1', 'Qwerty123!', '10'),
('qw123', 'Qwerty123!', '11'),
('qwe123', 'Qwerty123!', '12');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `platnosci`
--

CREATE TABLE `platnosci` (
  `idUser` int(11) NOT NULL,
  `status` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `karta` int(11) NOT NULL,
  `termin` varchar(50) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `platnosci`
--

INSERT INTO `platnosci` (`idUser`, `status`, `karta`, `termin`) VALUES
(4, 'NIE_DODANO_KARTY', 0, '-'),
(13, 'NIE_DODANO_KARTY', 0, '-');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `status`
--

CREATE TABLE `status` (
  `idUser` int(11) NOT NULL,
  `Status` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `Termin` varchar(50) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `status`
--

INSERT INTO `status` (`idUser`, `Status`, `Termin`) VALUES
(4, 'ZAWIESZONE', '2019-05-10');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `terminarz`
--

CREATE TABLE `terminarz` (
  `idTerminu` int(11) NOT NULL,
  `idTrenera` int(11) NOT NULL,
  `czasTrwania` int(11) NOT NULL,
  `LimitMiejsc` int(11) NOT NULL,
  `DATA` varchar(100) COLLATE utf8_polish_ci DEFAULT NULL,
  `idTreningu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `terminarz`
--

INSERT INTO `terminarz` (`idTerminu`, `idTrenera`, `czasTrwania`, `LimitMiejsc`, `DATA`, `idTreningu`) VALUES
(1, 1, 95, 15, '01.02.2019', 5),
(2, 1, 70, 15, '04.02.2019', 4),
(3, 2, 45, 15, '05.02.2019', 3),
(4, 2, 25, 15, '09.02.2019', 2),
(5, 2, 75, 15, '15.02.2019', 1),
(6, 1, 95, 10, '22.09.2019', 2);

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
(2, 'Michał', 'Motyka'),
(3, 'Anna', 'Mucha'),
(4, 'Wiktor', 'Karp');

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
(3, 'jacus', 'Jacu?', 'Kolo', 'ewqeqw@wp.pl', '123456987'),
(4, 'admin', 'Admin', 'Admin', 'admin@admin.pl', '777777777'),
(5, 'ewqeqwe', 'LDADA', 'dsad', 'DAsda@ww', '123456789'),
(6, 'dasdassda', 'eqwew', 'eqweqw', 'eqweq@wp.pl', '123456789'),
(7, 'dasdassda', 'dasdas', 'dasda', 'dasdadasdasdas', '123456789'),
(8, 'dasdassda', 'dasdassda', 'dasdassda', 'dasdassda', '123456789'),
(9, 'dasdassda', 'ewqeqwe', 'ewqeqwe', '12345678978', '123456789'),
(10, 'wqerptl1', 'tomasz', 'nowak', 'qwer@wp.pl', '123456789'),
(11, 'qw123', 'Roman', 'Pazdzioch', 'qeqweqw@wp.pl', '789456987'),
(12, 'qwe123', 'eqweqwe', 'eqweq', 'eqweqe@wp.pl', '123456789');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zapisy`
--

CREATE TABLE `zapisy` (
  `idUser` int(11) NOT NULL,
  `idTerminu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `zapisy`
--

INSERT INTO `zapisy` (`idUser`, `idTerminu`) VALUES
(12, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
