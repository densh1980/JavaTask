CREATE SCHEMA IF NOT EXISTS `users_db`
DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `users_db` ;

CREATE TABLE IF NOT EXISTS `users_db`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `users_name_idx` (`last_name` ASC, `first_name` ASC),
  INDEX `users_phone_idx` (`phone` ASC),
  INDEX `users_email_idx` (`email` ASC))
ENGINE = InnoDB;

INSERT INTO `users_db`.`users` (`first_name`, `last_name`, `phone`, `email`) 
VALUES	('Мария', 'Шепель', '333-22-11', 'asd@com'),
		('Иван', 'Сидоренко', '123-34-55', 'sdf@rrr.ua'),
		('Иван', 'Калетник', '245 -22-99', 'mba@asd.com'),
		('Инна ', 'Сидоренко', '678-31-45', 'mba@dsa.ru'),
		('Дмитрий ', 'Маринин', '299-13-19', 'ghj@com'),
		('Joe', 'Black', '444-13-11', 'new@gmail.com');
