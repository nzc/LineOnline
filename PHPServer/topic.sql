SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `lineonline` ;
CREATE SCHEMA IF NOT EXISTS `lineonline` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `lineonline` ;

-- -----------------------------------------------------
-- Table `lineonline`.`appointment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lineonline`.`appointment` ;

CREATE TABLE IF NOT EXISTS `lineonline`.`appointment` (
  `aid` INT NOT NULL AUTO_INCREMENT,
  `uid` INT NOT NULL,
  `gid` INT NOT NULL,
  `flag` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`aid`))
ENGINE = InnoDB
COMMENT = '预约表';


-- -----------------------------------------------------
-- Table `lineonline`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lineonline`.`user` ;

CREATE TABLE IF NOT EXISTS `lineonline`.`user` (
  `uid` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `flag` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`uid`))
ENGINE = InnoDB
COMMENT = '...';


-- -----------------------------------------------------
-- Table `lineonline`.`game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lineonline`.`game` ;

CREATE TABLE IF NOT EXISTS `lineonline`.`game` (
  `gid` INT NOT NULL AUTO_INCREMENT,
  `photo` VARCHAR(45) NOT NULL DEFAULT '',
  `title` TEXT NOT NULL,
  `introduction` TEXT NOT NULL,
  `flag` INT NOT NULL DEFAULT 0,
  `rank` INT NOT NULL,
  PRIMARY KEY (`gid`));


-- -----------------------------------------------------
-- Table `lineonline`.`bubble`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lineonline`.`bubble` ;

CREATE TABLE IF NOT EXISTS `lineonline`.`bubble` (
  `bid` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `flag` INT NOT NULL DEFAULT 0,
  `uid` INT NOT NULL,
  PRIMARY KEY (`bid`))
ENGINE = InnoDB
COMMENT = '发表内容';


-- -----------------------------------------------------
-- Table `lineonline`.`comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lineonline`.`comment` ;

CREATE TABLE IF NOT EXISTS `lineonline`.`comment` (
  `cid` INT NOT NULL AUTO_INCREMENT,
  `bid` INT NOT NULL,
  `uid` INT NOT NULL,
  `content` TEXT NOT NULL,
  `flag` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`cid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lineonline`.`gameplayed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lineonline`.`gameplayed` ;

CREATE TABLE IF NOT EXISTS `lineonline`.`gameplayed` (
  `ggid` INT NOT NULL AUTO_INCREMENT,
  `uid` INT NOT NULL,
  `flag` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`ggid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lineonline`.`gamecomment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lineonline`.`gamecomment` ;

CREATE TABLE IF NOT EXISTS `lineonline`.`gamecomment` (
  `gcid` INT NOT NULL AUTO_INCREMENT,
  `uid` INT NOT NULL,
  `gid` INT NOT NULL,
  `flag` INT NOT NULL DEFAULT 0,
  `content` TEXT NOT NULL,
  `rank` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`gcid`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
