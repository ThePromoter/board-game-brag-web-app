SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `email_address` VARCHAR(60) NOT NULL,
  `name` VARCHAR(90) NOT NULL,
  `experience` INT ZEROFILL NULL,
  `password_hash` VARCHAR(45) NOT NULL,
  `password_salt` VARCHAR(45) NOT NULL,
  `zipcode` VARCHAR(10) NULL,
  `entered_by` BIGINT NOT NULL,
  `entered_date` DATETIME NOT NULL,
  `changed_by` BIGINT NULL,
  `changed_date` DATETIME NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_address_UNIQUE` (`email_address` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game` ;

CREATE TABLE IF NOT EXISTS `game` (
  `game_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(90) NOT NULL,
  `image_url` VARCHAR(90) NULL,
  `min_players` INT UNSIGNED NULL,
  `max_players` INT UNSIGNED NULL,
  `entered_by` BIGINT UNSIGNED NOT NULL,
  `entered_date` DATETIME NOT NULL,
  `changed_by` BIGINT UNSIGNED NULL,
  `changed_date` DATETIME NULL,
  PRIMARY KEY (`game_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_game_link`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_game_link` ;

CREATE TABLE IF NOT EXISTS `user_game_link` (
  `user_game_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NOT NULL,
  `game_id` BIGINT UNSIGNED NOT NULL,
  `entered_by` BIGINT UNSIGNED NOT NULL,
  `entered_date` DATETIME NOT NULL,
  `changed_by` BIGINT UNSIGNED NULL,
  `changed_date` DATETIME NULL,
  PRIMARY KEY (`user_game_id`),
  INDEX `game_idx` (`game_id` ASC),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `game_id_UNIQUE` (`game_id` ASC),
  CONSTRAINT `user_game_link-user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_game_link-game`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`game_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `event_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(90) NULL,
  `creator` BIGINT UNSIGNED NOT NULL,
  `date` DATETIME NOT NULL,
  `entered_by` BIGINT UNSIGNED NOT NULL,
  `entered_date` DATETIME NOT NULL,
  `changed_by` BIGINT UNSIGNED NULL,
  `changed_date` DATETIME NULL,
  PRIMARY KEY (`event_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_game_link`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event_game_link` ;

CREATE TABLE IF NOT EXISTS `event_game_link` (
  `event_game_link_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `event_id` BIGINT UNSIGNED NOT NULL,
  `game_id` BIGINT UNSIGNED NOT NULL,
  `entered_by` BIGINT UNSIGNED NOT NULL,
  `entered_date` DATETIME NOT NULL,
  `changed_by` BIGINT UNSIGNED NULL,
  `changed_date` DATETIME NULL,
  PRIMARY KEY (`event_game_link_id`),
  INDEX `game_idx` (`game_id` ASC),
  UNIQUE INDEX `event_id_UNIQUE` (`event_id` ASC),
  UNIQUE INDEX `game_id_UNIQUE` (`game_id` ASC),
  CONSTRAINT `event_game_link-event`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`event_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `event_game_link-game`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`game_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_user_link`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event_user_link` ;

CREATE TABLE IF NOT EXISTS `event_user_link` (
  `event_user_link_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `event_id` BIGINT UNSIGNED NOT NULL,
  `user_id` BIGINT UNSIGNED NOT NULL,
  `entered_by` BIGINT UNSIGNED NOT NULL,
  `entered_date` DATETIME NOT NULL,
  `changed_by` BIGINT UNSIGNED NULL,
  `changed_date` DATETIME NULL,
  PRIMARY KEY (`event_user_link_id`),
  INDEX `user_idx` (`user_id` ASC),
  UNIQUE INDEX `event_id_UNIQUE` (`event_id` ASC),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  CONSTRAINT `event_user_link-event`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`event_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `event_user_link-user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_result`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game_result` ;

CREATE TABLE IF NOT EXISTS `game_result` (
  `game_result_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `event_id` BIGINT UNSIGNED NOT NULL,
  `game_id` BIGINT UNSIGNED NOT NULL,
  `source_user_id` BIGINT UNSIGNED NOT NULL,
  `winning_user_id` BIGINT UNSIGNED NOT NULL,
  `entered_by` BIGINT UNSIGNED NOT NULL,
  `entered_date` DATETIME NOT NULL,
  `changed_by` BIGINT UNSIGNED NULL,
  `changed_date` DATETIME NULL,
  PRIMARY KEY (`game_result_id`),
  INDEX `game_idx` (`game_id` ASC),
  INDEX `user_source_idx` (`source_user_id` ASC),
  INDEX `game_result_winning_user-user_idx` (`winning_user_id` ASC),
  UNIQUE INDEX `event_id_UNIQUE` (`event_id` ASC),
  UNIQUE INDEX `game_id_UNIQUE` (`game_id` ASC),
  UNIQUE INDEX `source_user_id_UNIQUE` (`source_user_id` ASC),
  CONSTRAINT `game_result-event`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`event_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `game_result-game`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`game_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `game_result_source_user-user`
    FOREIGN KEY (`source_user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `game_result_winning_user-user`
    FOREIGN KEY (`winning_user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `feedback_title`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback_title` ;

CREATE TABLE IF NOT EXISTS `feedback_title` (
  `title_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `entered_by` BIGINT UNSIGNED NOT NULL,
  `entered_date` DATETIME NOT NULL,
  `changed_by` BIGINT UNSIGNED NULL,
  `changed_date` DATETIME NULL,
  PRIMARY KEY (`title_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_game_feedback`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_game_feedback` ;

CREATE TABLE IF NOT EXISTS `user_game_feedback` (
  `user_game_feedback_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `event_id` BIGINT UNSIGNED NOT NULL,
  `game_id` BIGINT UNSIGNED NOT NULL,
  `source_user_id` BIGINT UNSIGNED NOT NULL,
  `target_user_id` BIGINT UNSIGNED NOT NULL,
  `rating` INT UNSIGNED NULL,
  `title_id` INT UNSIGNED NULL,
  `entered_by` BIGINT UNSIGNED NOT NULL,
  `entered_date` DATETIME NOT NULL,
  `changed_by` BIGINT UNSIGNED NULL,
  `changed_date` DATETIME NULL,
  PRIMARY KEY (`user_game_feedback_id`),
  INDEX `game_idx` (`game_id` ASC),
  INDEX `user_idx` (`source_user_id` ASC),
  INDEX `title_idx` (`title_id` ASC),
  INDEX `game_user_feedback_target-user_idx` (`target_user_id` ASC),
  UNIQUE INDEX `event_id_UNIQUE` (`event_id` ASC),
  UNIQUE INDEX `game_id_UNIQUE` (`game_id` ASC),
  UNIQUE INDEX `source_user_id_UNIQUE` (`source_user_id` ASC),
  UNIQUE INDEX `target_user_id_UNIQUE` (`target_user_id` ASC),
  CONSTRAINT `game_user_feedback-event`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`event_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `game_user_feedback-game`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`game_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `game_user_feedback_source-user`
    FOREIGN KEY (`source_user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `game_user_feedback-title`
    FOREIGN KEY (`title_id`)
    REFERENCES `feedback_title` (`title_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `game_user_feedback_target-user`
    FOREIGN KEY (`target_user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `location_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `address_number` VARCHAR(10) NULL,
  `address_street` VARCHAR(60) NULL,
  `address_city` VARCHAR(60) NULL,
  `address_state` VARCHAR(45) NULL,
  `address_zipcode` VARCHAR(10) NULL,
  `address_apt_number` VARCHAR(10) NULL,
  `entered_by` BIGINT UNSIGNED NOT NULL,
  `entered_date` DATETIME NOT NULL,
  `changed_by` BIGINT UNSIGNED NULL,
  `changed_date` DATETIME NULL,
  PRIMARY KEY (`location_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_location_link`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_location_link` ;

CREATE TABLE IF NOT EXISTS `user_location_link` (
  `user_location_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NOT NULL,
  `location_id` BIGINT UNSIGNED NOT NULL,
  `nickname` VARCHAR(90) NULL,
  `entered_by` BIGINT UNSIGNED NOT NULL,
  `entered_date` DATETIME NOT NULL,
  `changed_by` BIGINT UNSIGNED NULL,
  `changed_date` DATETIME NULL,
  PRIMARY KEY (`user_location_id`),
  INDEX `location_idx` (`location_id` ASC),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `location_id_UNIQUE` (`location_id` ASC),
  CONSTRAINT `user_location_link-user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_location_link-location`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`location_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
