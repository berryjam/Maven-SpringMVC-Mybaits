DROP TABLE IF EXISTS `days_user`;
CREATE TABLE `days_user` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `state` INT(10) NOT NULL,
  `nickname` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;