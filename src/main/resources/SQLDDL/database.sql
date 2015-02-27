SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema easygo_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `easygo_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `easygo_db` ;

-- -----------------------------------------------------
-- Table `easygo_db`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easygo_db`.`USER` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(45) NULL,
  `gender` TINYINT(1) NOT NULL,
  `login` VARCHAR(128) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `car` VARCHAR(128) NULL DEFAULT NULL,
  `phone_number` VARCHAR(20) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `easygo_db`.`TRIP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easygo_db`.`TRIP` (
  `trip_id` BIGINT(20) NOT NULL,
  `start_trip` TIMESTAMP NOT NULL,
  `driver_id` BIGINT(20) NOT NULL,
  `car_capacity` INT NOT NULL,
  `price` DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (`trip_id`),
  UNIQUE INDEX `id_UNIQUE` (`trip_id` ASC),
  INDEX `driver_id_idx` (`driver_id` ASC),
  CONSTRAINT `driver_id`
  FOREIGN KEY (`driver_id`)
  REFERENCES `easygo_db`.`USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `easygo_db`.`PNP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easygo_db`.`PNP` (
  `id` BIGINT(20) NOT NULL,
  `latitude` DOUBLE NOT NULL,
  `longitude` DOUBLE NOT NULL,
  `description` VARCHAR(255) NULL,
  `isleft` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `pnp_id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `easygo_db`.`RATIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easygo_db`.`RATIO` (
  `user_id` BIGINT(20) NOT NULL,
  `ratio` BIGINT(20) NOT NULL DEFAULT 0,
  `trip_id` BIGINT(20) NOT NULL,
  INDEX `trip_id_idx` (`trip_id` ASC),
  INDEX `person_id_idx` (`user_id` ASC),
  CONSTRAINT `trip_id`
  FOREIGN KEY (`trip_id`)
  REFERENCES `easygo_db`.`TRIP` (`trip_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `person_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `easygo_db`.`USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `easygo_db`.`TRIP_POINTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easygo_db`.`TRIP_POINTS` (
  `trip_id` BIGINT(20) NOT NULL,
  `pnp_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`trip_id`, `pnp_id`),
  INDEX `pnp_idx` (`pnp_id` ASC),
  CONSTRAINT `trip`
  FOREIGN KEY (`trip_id`)
  REFERENCES `easygo_db`.`TRIP` (`trip_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `pnp`
  FOREIGN KEY (`pnp_id`)
  REFERENCES `easygo_db`.`PNP` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

