-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema shmyhin_epam_tasks_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shmyhin_epam_tasks_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shmyhin_epam_tasks_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `shmyhin_epam_tasks_db` ;

-- -----------------------------------------------------
-- Table `shmyhin_epam_tasks_db`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shmyhin_epam_tasks_db`.`users` ;

CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`users` (
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


-- -----------------------------------------------------
-- Table `shmyhin_epam_tasks_db`.`record_mediums`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shmyhin_epam_tasks_db`.`record_mediums` ;

CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`record_mediums` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL COMMENT 'CD,DVD,Blu-ray,vinil_record,cassette',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shmyhin_epam_tasks_db`.`media_types`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shmyhin_epam_tasks_db`.`media_types` ;

CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`media_types` (
  `id` INT NOT NULL,
  `type` VARCHAR(45) NULL COMMENT 'audio,video',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `type_UNIQUE` (`type` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shmyhin_epam_tasks_db`.`products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shmyhin_epam_tasks_db`.`products` ;

CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  `production_year` INT NULL,
  `Qty` INT NULL,
  `price` INT NULL,
  `rating` INT NULL,
  `record_mediums_id` INT NULL,
  `media_types_id` INT NOT NULL,
  PRIMARY KEY (`id`, `record_mediums_id`, `media_types_id`),
  INDEX `fk_products_record_mediums_idx` (`record_mediums_id` ASC),
  INDEX `fk_products_media_types1_idx` (`media_types_id` ASC),
  INDEX `products_name_idx` (`name` ASC),
  INDEX `products_price_idx` (`price` ASC),
  INDEX `products_rating_idx` (`rating` ASC),
  CONSTRAINT `fk_products_record_mediums`
    FOREIGN KEY (`record_mediums_id`)
    REFERENCES `shmyhin_epam_tasks_db`.`record_mediums` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_media_types1`
    FOREIGN KEY (`media_types_id`)
    REFERENCES `shmyhin_epam_tasks_db`.`media_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shmyhin_epam_tasks_db`.`categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shmyhin_epam_tasks_db`.`categories` ;

CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `categories_category_idx` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shmyhin_epam_tasks_db`.`categories_products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shmyhin_epam_tasks_db`.`categories_products` ;

CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`categories_products` (
  `categories_id` INT NOT NULL,
  `products_id` INT NOT NULL,
  PRIMARY KEY (`categories_id`, `products_id`),
  INDEX `fk_categories_has_products_products1_idx` (`products_id` ASC),
  INDEX `fk_categories_has_products_categories1_idx` (`categories_id` ASC),
  CONSTRAINT `fk_categories_has_products_categories1`
    FOREIGN KEY (`categories_id`)
    REFERENCES `shmyhin_epam_tasks_db`.`categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categories_has_products_products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `shmyhin_epam_tasks_db`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shmyhin_epam_tasks_db`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shmyhin_epam_tasks_db`.`orders` ;

CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `order_status` ENUM('new', 'in_progress', 'closed') NULL DEFAULT 'new',
  `total_amount` INT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orders_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `shmyhin_epam_tasks_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shmyhin_epam_tasks_db`.`orders_items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shmyhin_epam_tasks_db`.`orders_items` ;

CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`orders_items` (
  `orders_id` INT NOT NULL,
  `products_id` INT NOT NULL,
  `product_qty` INT NULL,
  PRIMARY KEY (`orders_id`, `products_id`),
  INDEX `fk_orders_has_products_products1_idx` (`products_id` ASC),
  INDEX `fk_orders_has_products_orders1_idx` (`orders_id` ASC),
  CONSTRAINT `fk_orders_has_products_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `shmyhin_epam_tasks_db`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_products_products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `shmyhin_epam_tasks_db`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shmyhin_epam_tasks_db`.`sale_procent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shmyhin_epam_tasks_db`.`sale_procent` ;

CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`sale_procent` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sale` INT NOT NULL DEFAULT 0,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sale_procent_users1_idx` (`users_id` ASC),
  INDEX `sale_proc_idx` (`sale` ASC),
  CONSTRAINT `fk_sale_procent_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `shmyhin_epam_tasks_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;