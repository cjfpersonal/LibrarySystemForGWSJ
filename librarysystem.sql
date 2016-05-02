

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aministrator_info
-- ----------------------------
DROP TABLE IF EXISTS `aministrator_info`;
CREATE TABLE `aministrator_info` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `ausername` varchar(255) NOT NULL,
  `apassword` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ausername_UNIQUE` (`ausername`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aministrator_info
-- ----------------------------

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) NOT NULL,
  `book_content` varchar(255) NOT NULL,
  `book_count` int(11) NOT NULL DEFAULT '0',
  `book_uptime` date NOT NULL,
  `book_photo` varchar(255) DEFAULT NULL,
  `book_lendcount` int(11) NOT NULL,
  `book_status` int(1) NOT NULL DEFAULT '0',
  `book_address` varchar(255) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------

-- ----------------------------
-- Table structure for student_borrow
-- ----------------------------
DROP TABLE IF EXISTS `student_borrow`;
CREATE TABLE `student_borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `borrow_time` date NOT NULL,
  `deadline` date NOT NULL,
  `return_time` date NOT NULL,
  `borrow_book_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `book_info` (`book_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_borrow
-- ----------------------------

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(255) NOT NULL,
  `student_college` varchar(255) NOT NULL,
  `student_sex` int(1) NOT NULL DEFAULT '1',
  `student_photo` varchar(255) DEFAULT NULL,
  `student_password` varchar(255) NOT NULL,
  `student_money` int(11) DEFAULT '0',
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `studentID_UNIQUE` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

