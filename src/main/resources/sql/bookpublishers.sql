-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 15, 2018 at 08:55 AM
-- Server version: 5.7.22-0ubuntu0.16.04.1
-- PHP Version: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookpublishers`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `author_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `info` varchar(5000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`author_id`, `email`, `info`, `name`) VALUES
(1, 'sommerville@gmail.com', 'I wrote my first computer program in 1970 and have been involved in software engineering research and teaching since the late-1970s. So I have lived through changes to computer generations from mainframes to minicomputers to PCs and mobile devices. I started using the Internet in the early 1980s and my first web site was published in 1995.\r\nI have worked in several areas of software engineering – software tools and environments, requirements engineering, dependable systems and large-scale complex systems. Since the early 1990s, I have taken a sociotechnical and not simply a technical view of software engineering where I looked at how human. social and organizational factors affect complex systems and systems engineering processes.\r\nI retired as a full professor of software engineering at St Andrews University, Scotland in 2014. As well as writing, I now do a range of software-related things, paid and unpaid, that I find interesting.', 'Ian Sommerville'),
(2, 'liang@gmail.com', 'Dr. Liang earned his Ph.D. in Computer Science from the University of Okalahoma in 1991, and an MS and BS in Computer Science from Fudan University in Shanghai, China, in 1986 and 1983. Prior to joining Armstrong, he was an associate professor in computer science at Purdue University in Fort Wayne, where he twice received the Excellence in Research award.\r\n\r\nDr. Liang was trained in theoretical computer science. He was active in graph algorithms from 1990 to 1995 and published more than ten papers in several established journals such as SIAM Journal on Computing, Discrete Applied Mathematics, Acta Informatics, and Information Processing Letters. Since 1996, he has devoted to writing texts and published more than thirty books with Prentice Hall. His popular computer science texts are widely adopted in the world.\r\nDr. Liang was elected a Java Champion in 2005 by Sun Microsystems. He has given lectures on Java internationally.', 'Y. Daniel Liang'),
(3, 'craig@yahoo.com', 'He is a software developer with over 12 years\' experience and coauthor\r\n\r\nof XDoclet in Action. He is a great writer and a zealous promoter of the Spring\r\n\r\nframework, speaking frequently at local user groups and conferences and\r\n\r\nwriting about Spring on his blog. When he\'s not slinging code, Craig spends as\r\n\r\nmuch time as he can with his wife, two daughters, seven birds, four dogs, two cats,\r\n\r\nand an ever-fluctuating number of tropical fish. Craig lives in Denton, Texas.\r\n\r\nAn avid supporter of open source Java technologies, Ryan Breidenbach has developed\r\n\r\nJava web applications for the past seven years. He lives in Coppell, Texas.', 'Craig Walls'),
(4, 'silberschatz@gmail.com', 'Professor Silberschatz is a Fellow of the Association of Computing Machinery (ACM), a Fellow of Institute of Electrical and Electronic Engineers (IEEE), a Fellow of the American Association for the Advancement of Science (AAAS), and a member of the Connecticut Academy of Science and Engineering. He received the 2002 IEEE Taylor L. Booth Education Award, the 1998 ACM Karl V. Karlstrom Outstanding Educator Award, and the 1997 ACM SIGMOD Contribution Award.', 'Abraham Silberschatz'),
(5, 'galvin@gmail.com', 'Peter Baer Galvin is the chief solutions architect for Pluribus Networks (www.pluribusnetworks.com). Previously he was the CTO for the systems integrator Corporate Technologies, and a lecturer at Boston University. He has also been a columnist for ;login:, SunWorld, and SysAdmin magazines, and has written articles for Byte and other magazines. Mr. Galvin blogs for anewdomain.net and byte.com. As a consultant and trainer, he has given talks and tutorials on security and system administration worldwide.', 'Peter Baer Galvin'),
(6, 'greg@yahoo.com', 'Greg Gagne is chair of the Computer Science department at Westminster College in Salt Lake City where he has been teaching since 1990. In addition to teaching operating systems, he also teaches computer networks, parallel programming, and software engineering. He has made presentations at educational conferences and also provides workshops to industry professionals. Professor Gagne was the recipient of the Shaw Faculty Publication Prize in 2007.', 'Greg Gagne'),
(7, 'forouzan85@gmail.com', 'Behrouz A. Forouzan, Iranian Computer programming educator. Served to Lieutenant Army of Iran, 1967-1969. Member Institute of Electrical and Electronics Engineers, BYTE. M C. Forouzan, Behrouz A. was born on October 15, 1944 in Arak, Iran. Came to the United States, 1981. Son of Ahmad A. Forouzan and Soror Mina. Bachelor of Science in Electrical, Tehran University, Iran, 1967. Master of Science in Electrical, University California, Irvine, 1984Chairman, Board Of Directors, Techno Frigo, Tehran, 1969-1979;project engineer, Memco, Zurich, Switzerland., 1979-1981;computer instructor, Navajo Community College, Shiprock, New Mexico, since 1984. Served to Lieutenant Army of Iran, 1967-1969. Member Institute of Electrical and Electronics Engineers, BYTE. M C.', 'Behrouz A. Forouzan'),
(8, 'forouzan85@gmail.com', 'Behrouz A. Forouzan, Iranian Computer programming educator. Served to Lieutenant Army of Iran, 1967-1969. Member Institute of Electrical and Electronics Engineers, BYTE. M C. Forouzan, Behrouz A. was born on October 15, 1944 in Arak, Iran. Came to the United States, 1981. Son of Ahmad A. Forouzan and Soror Mina. Bachelor of Science in Electrical, Tehran University, Iran, 1967. Master of Science in Electrical, University California, Irvine, 1984Chairman, Board Of Directors, Techno Frigo, Tehran, 1969-1979;project engineer, Memco, Zurich, Switzerland., 1979-1981;computer instructor, Navajo Community College, Shiprock, New Mexico, since 1984. Served to Lieutenant Army of Iran, 1967-1969. Member Institute of Electrical and Electronics Engineers, BYTE. M C.', 'Behrouz A. Forouzan'),
(9, 'anandakumar@yahoo.com', 'Anand Kumar (born 1 January 1973) is an Indian Mathematician,\r\nEducationalist and a Columnist for various national and international mathematical journals and magazines. He is best known for his Super 30 programme, which he started in Patna, Bihar in 2002, and which coaches economically backward students for IIT-JEE, the entrance examination for the Indian Institutes of Technology (IITs). By 2018, 422 out of the 480 had made it to the IITs and Discovery Channel showcased his work in a documentary. He has been invited by the prestigious Massachusetts Institute of Technology (MIT) and Harvard University to speak on his globally acclaimed effort to mentor students from the underprivileged sections for admission to IIT.', 'Anand Kumar'),
(10, 'luger123@yahoo.com', 'George Luger has been a Professor in the UNM Computer Science Department since 1979. His two master\'s degrees are in pure and applied mathematics from Gonzaga University and the University of Notre Dame. He received his PhD from the University of Pennsylvania in 1973, with a dissertation focusing on the computational modeling of human problem solving performance in the tradition of Allen Newell and Herbert Simon. \r\nGeorge Luger had a five-year postdoctoral research appointment at the Department of Artificial Intelligence of the University of Edinburgh in Scotland. In Edinburgh he worked on several early expert systems, participated in the development and testing of the Prolog computer language, and continued his research in the computational modeling of human problem solving performance.\r\nAt the University of New Mexico, George Luger, a Professor of Computer Science, has also been given a Professorship in the Psychology and Linguistics Departments, reflecting his interdisciplinary research and teaching of Cognitive Science and Computational Linguistics courses and seminars in these areas. \r\nGeorge Luger\'s AI book, Artificial Intelligence: Structures and Strategies for Complex Problem Solving (Addison-Wesley 2008) is now in its sixth edition. To get the software for any of Professor Luger\'s AI books, please select the FTP site address under the appropriate book cover below. For instructors using the fifth and sixth editions of the AI book, an Instructors Guide and sets of Power Point presentation slides are available from Addison Wesley and Pearson Education. Academic Press published his book Cognitive Science: The Science of Intelligent Systems in 1994. His edited collection of readings from the early creators of AI research is presented in his edited collection of papers, Computation and Intelligence, published by AAAI and MIT Press in 1995', 'George.f.luger');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `isbn` varchar(255) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `edition` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `book_image_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`isbn`, `category`, `description`, `edition`, `price`, `rating`, `title`, `book_image_id`) VALUES
('12345', 'Software Engineering', 'The 1st edition of Software Engineering was published in 1982 and it has been regularly revised and updated since then. The 10th edition was published in 2015 with new material on resilience engineering, systems engineering and systems of systems; many chapters have been extensively revised including ‘Agile Software Engineering’, ‘Reliability, ‘Safety’ and ‘Security’.\r\nMy book is widely used across the world as a student text, has been translated into many languages and, in different editions and languages, has sold almost a million copies.\r\nThis is the website for the 10th edition, which includes additional learning materials – case studies, presentations and videos – for students and educators.\r\nThe website for the 9th edition is still available but is not maintained.', '9th', 350, 0, 'Software Engineering', 1),
('456123', 'Java Framework', 'Spring in Action introduces you to the ideas behind Spring and then quickly launches into a hands-on exploration of the framework. Combining short code snippets and an ongoing example developed throughout the book, it shows you how to build simple and efficient J2EE applications. You will see how to solve persistence problems using the leading open-source tools, and also how to integrate your application with the most popular web frameworks. You will learn how to use Spring to manage the bulk of your infrastructure code so you can focus on what really matters your critical business needs. Spring in Action has been completely updated to cover the exciting new features of Spring 2.0. The book begins by introducing you to the core concepts of Spring and then quickly launches into a hands-on exploration of the framework.Part 1 - Spring EssentialsPart 2 - Spring in the Business LayerPart 3 - Spring in the Web Layer', '4th', 300, 0, 'Spring in Action', 3),
('5432123', 'Operating System', 'Operating System Concepts, now in its ninth edition, continues to provide a solid theoretical foundation for understanding operating systems. The ninth edition has been thoroughly updated to include contemporary examples of how operating systems function. The text includes content to bridge the gap between concepts and actual implementations. End-of-chapter problems, exercises, review questions, and programming exercises help to further reinforce important concepts. A new Virtual Machine provides interactive exercises to help engage students with the material.', '9th', 450, 0, 'Operating System Concepts', 5),
('654321', 'Programming', '""Introduction to Java Programming, Comprehensive, 10e," "features comprehensive coverage ideal for a one-, two-, or three-semester CS1 course sequence.\r\nDaniel Liang teaches concepts of problem-solving and object-oriented programming using a fundamentals-first approach. Beginning programmers learn critical problem-solving techniques then move on to grasp the key concepts of object-oriented, GUI programming, advanced GUI and Web programming using Java. 	', '10th', 250, 0, 'Introduction to java programming', 2),
('978-0321545893', 'Artificial Intelligence', 'Artificial Intelligence: Structures and Strategies for Complex Problem Solving is ideal for a one- or two-semester undergraduate course on AI.\r\n\r\nIn this accessible, comprehensive text, George Luger captures the essence of artificial intelligence–solving the complex problems that arise wherever computer technology is applied. Ideal for an undergraduate course in AI, the Sixth Edition presents the fundamental concepts of the discipline first then goes into detail with the practical information necessary to implement the algorithms and strategies discussed. Readers learn how to use a number of different software tools and techniques to address the many challenges faced by today’s computer scientists.', '6th', 480, 0, 'Artificial Intelligence Structures and Strategies for Complex Problem Solving', 9),
('9780073376226', 'Networking', 'Data Communications and Networking is designed to help students understand the basics of data communications and networking, and the protocols used in the Internet in particular by using the protocol layering of the Internet and TCP/IP protocol suite. Technologies related to data communication and networking may be the fastest growing in today\'s culture. The appearance of some new social networking applications is a testimony to this claim. In this Internet-oriented society, specialists need to be trained to run and manage the Internet, part of the Internet, or an organization\'s network that is connected to the Internet.\r\nUsing a bottom-up approach, Data Communications and Networking presents this highly technical subject matter without relying on complex formulas by using a strong pedagogical approach supported by more than 830 figures. Now in its Fifth Edition, this textbook brings the beginning student right to the forefront of the latest advances in the field, while presenting the fundamentals in a clear, straightforward manner. Students will find better coverage, improved figures and better explanations on cutting-edge material. The "bottom-up" approach allows instructors to cover the material in one course, rather than having separate courses on data communications and networking\r\n', '5th', 380, 0, 'Data Communications and Networking', 6),
('9780984755028', 'Networking', 'Cryptography and network security e/2 comprehensively covers the important topics of cryptography and network security. The authors\' writing style is simple and lucid, making it easy for readers to understand the subject matter.this edition of cryptography and network security has been updated and revised as per the latest developments that have taken place in this field. The guidebook starts off with basic techniques and gradually builds up to advanced levels. Cryptography and network security e/2 has an introduction to the fundamentals, and then the book is divided into four parts. The first two focus on symmetric and asymmetric key encipherment. The other two cover integrity, authentication and key management, and network security. This edition contains a new chapter on system security, which explains how attacks are conducted against systems and how these systems can be protected. New topics like secure electronic transaction, hash functions, message authentication codes, and biometrics have also been introduced. The authors use fictitious characters to make the content more interesting. Filled with 260 solved examples, 400 exercises, 200 review questions and 400 illustrations, this guidebook makes learning simple and easy. Furthermore, the book also uses pseudo codes to illustrate algorithm implementations. Appendixes a to q contain difficult math concepts like elementary probability, simplified des, and random number generator.any student or practicing professional who needs to learn or revise these subjects can get benefitted from this book. Cryptography and network security\'s second edition, published by mcgraw-hill education in 2010, is available in paperback', '2nd', 1200, 0, 'Cryptography & Network Security', 7),
('9788120350717 ', 'Signal Processing', 'This comprehensive text on digital signal processing is designed for undergraduate students of electronics and communication engineering, telecommunication engineering, electronics and instrumentation engineering, and electrical and electronics engineering. The book will also be useful to AMIE and IETE students.\r\n\r\nWritten with student-centred, pedagogically driven approach, the text provides a self-contained introduction to the theory of digital signal processing. It covers topics ranging from basic discrete-time signals and systems, realization of discrete-time systems, discrete-time Fourier transform and its use in the analysis of signals, discrete Fourier series to discrete Fourier transform. In addition to this, various design techniques for FIR filters, such as Fourier series method, the window method and the frequency sampling method, architectures for programmable digital signal processors (P-DSPs) and onchip peripherals are also discussed in detail. All the solved and unsolved problems in this book are designed to illustrate the topics in a clear way.', '2nd', 600, 0, 'Digital Signal Processing', 8);

-- --------------------------------------------------------

--
-- Table structure for table `book_authors`
--

CREATE TABLE `book_authors` (
  `isbn` varchar(255) NOT NULL,
  `author_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_authors`
--

INSERT INTO `book_authors` (`isbn`, `author_id`) VALUES
('12345', 1),
('456123', 3),
('5432123', 4),
('5432123', 5),
('5432123', 6),
('654321', 2),
('978-0321545893', 10),
('9780073376226', 7),
('9780984755028', 8),
('9788120350717 ', 9);

-- --------------------------------------------------------

--
-- Table structure for table `book_image`
--

CREATE TABLE `book_image` (
  `book_image_id` bigint(20) NOT NULL,
  `image_title` varchar(255) DEFAULT NULL,
  `preview_image_title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_image`
--

INSERT INTO `book_image` (`book_image_id`, `image_title`, `preview_image_title`) VALUES
(1, '12345softwareEngineering.jpg', '12345softwareEngineering.jpg'),
(2, '654321javaBook.jpeg', '654321javaBookPreview.jpeg'),
(3, '456123springInAction.jpeg', '456123springInAction.jpeg'),
(5, '5432123os.jpg', '5432123os.jpg'),
(6, '9780073376226DataCommunication.jpg', '9780073376226DataCommunication.jpg'),
(7, '9780984755028Cryptography.jpg', '9780984755028Cryptography.jpg'),
(8, '9788120350717 dsp.jpg', '9788120350717 dsp.jpg'),
(9, '978-0321545893AI.jpg', '978-0321545893AI.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `book_review`
--

CREATE TABLE `book_review` (
  `review_id` int(11) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `review` varchar(255) DEFAULT NULL,
  `reviewer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `book_reviews`
--

CREATE TABLE `book_reviews` (
  `isbn` varchar(255) NOT NULL,
  `review_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cart_item`
--

CREATE TABLE `cart_item` (
  `cart_item_id` bigint(20) NOT NULL,
  `net_price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `isbn` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart_item`
--

INSERT INTO `cart_item` (`cart_item_id`, `net_price`, `quantity`, `isbn`) VALUES
(2, 700, 2, '12345');

-- --------------------------------------------------------

--
-- Table structure for table `cusotmer_order`
--

CREATE TABLE `cusotmer_order` (
  `order_no` bigint(20) NOT NULL,
  `customer_address` varchar(255) DEFAULT NULL,
  `customer_aternative_phone` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `order_date` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer_order_cart_items`
--

CREATE TABLE `customer_order_cart_items` (
  `order_no` bigint(20) NOT NULL,
  `cart_item_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `enabled`, `password`, `user_name`) VALUES
(1, 'mamun0589@gmail.com', b'1', '$2a$10$5MljAvFyzi34z6WprHoVhOzngYuJ.tD6UnXd9sQmpdpEIU6H8DZ.a', 'Mamun');

-- --------------------------------------------------------

--
-- Table structure for table `user_books`
--

CREATE TABLE `user_books` (
  `user_id` bigint(20) NOT NULL,
  `isbn` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_cart_items`
--

CREATE TABLE `user_cart_items` (
  `user_id` bigint(20) NOT NULL,
  `cart_item_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`author_id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `FKdphf3doharidb4du3truy3x1b` (`book_image_id`);

--
-- Indexes for table `book_authors`
--
ALTER TABLE `book_authors`
  ADD UNIQUE KEY `UK_gyer5y6t90uujy141206gana3` (`author_id`),
  ADD KEY `FK90d4kfah06yrru8c5d1bmnidd` (`isbn`);

--
-- Indexes for table `book_image`
--
ALTER TABLE `book_image`
  ADD PRIMARY KEY (`book_image_id`);

--
-- Indexes for table `book_review`
--
ALTER TABLE `book_review`
  ADD PRIMARY KEY (`review_id`);

--
-- Indexes for table `book_reviews`
--
ALTER TABLE `book_reviews`
  ADD UNIQUE KEY `UK_6r32nprfe58q4k9m496csjl9w` (`review_id`),
  ADD KEY `FK1w02wxae6eica6wvvvlji20bx` (`isbn`);

--
-- Indexes for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD PRIMARY KEY (`cart_item_id`),
  ADD KEY `FKmnbfu53f03r8j51jckvw5ej7c` (`isbn`);

--
-- Indexes for table `cusotmer_order`
--
ALTER TABLE `cusotmer_order`
  ADD PRIMARY KEY (`order_no`);

--
-- Indexes for table `customer_order_cart_items`
--
ALTER TABLE `customer_order_cart_items`
  ADD KEY `FKp9hc3bi0mymf8vcq2lkabmnd3` (`cart_item_id`),
  ADD KEY `FKj2wcjty4mv49u0xkhsfrxgh8r` (`order_no`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_books`
--
ALTER TABLE `user_books`
  ADD KEY `FK56p63hl8h858cgym2jjtmqijf` (`isbn`),
  ADD KEY `FKlsv52bc02lki4njvn4gb1ijau` (`user_id`);

--
-- Indexes for table `user_cart_items`
--
ALTER TABLE `user_cart_items`
  ADD KEY `FKffo8ycyhonnh0g5muc4ex02v9` (`cart_item_id`),
  ADD KEY `FKsuqlqll8crefouwhpaomgauoa` (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD UNIQUE KEY `UK_it77eq964jhfqtu54081ebtio` (`role_id`),
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `author_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `book_image`
--
ALTER TABLE `book_image`
  MODIFY `book_image_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `book_review`
--
ALTER TABLE `book_review`
  MODIFY `review_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cart_item`
--
ALTER TABLE `cart_item`
  MODIFY `cart_item_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `cusotmer_order`
--
ALTER TABLE `cusotmer_order`
  MODIFY `order_no` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FKdphf3doharidb4du3truy3x1b` FOREIGN KEY (`book_image_id`) REFERENCES `book_image` (`book_image_id`);

--
-- Constraints for table `book_authors`
--
ALTER TABLE `book_authors`
  ADD CONSTRAINT `FK78gu95lglhc6cs2u5jfudx6e5` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`),
  ADD CONSTRAINT `FK90d4kfah06yrru8c5d1bmnidd` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`);

--
-- Constraints for table `book_reviews`
--
ALTER TABLE `book_reviews`
  ADD CONSTRAINT `FK1w02wxae6eica6wvvvlji20bx` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`),
  ADD CONSTRAINT `FKfba36lnapptsts8garfqv73tu` FOREIGN KEY (`review_id`) REFERENCES `book_review` (`review_id`);

--
-- Constraints for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD CONSTRAINT `FKmnbfu53f03r8j51jckvw5ej7c` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`);

--
-- Constraints for table `customer_order_cart_items`
--
ALTER TABLE `customer_order_cart_items`
  ADD CONSTRAINT `FKj2wcjty4mv49u0xkhsfrxgh8r` FOREIGN KEY (`order_no`) REFERENCES `cusotmer_order` (`order_no`),
  ADD CONSTRAINT `FKp9hc3bi0mymf8vcq2lkabmnd3` FOREIGN KEY (`cart_item_id`) REFERENCES `cart_item` (`cart_item_id`);

--
-- Constraints for table `user_books`
--
ALTER TABLE `user_books`
  ADD CONSTRAINT `FK56p63hl8h858cgym2jjtmqijf` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`),
  ADD CONSTRAINT `FKlsv52bc02lki4njvn4gb1ijau` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `user_cart_items`
--
ALTER TABLE `user_cart_items`
  ADD CONSTRAINT `FKffo8ycyhonnh0g5muc4ex02v9` FOREIGN KEY (`cart_item_id`) REFERENCES `cart_item` (`cart_item_id`),
  ADD CONSTRAINT `FKsuqlqll8crefouwhpaomgauoa` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
