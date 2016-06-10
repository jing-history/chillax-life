CREATE TABLE `love` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `first_time` datetime DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remarks` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  status tinyint default 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;