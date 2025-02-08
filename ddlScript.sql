-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Country` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Country` (
  `Country_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Country_name`),
  UNIQUE INDEX `name_UNIQUE` (`Country_name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`City`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`City` ;

CREATE TABLE IF NOT EXISTS `mydb`.`City` (
  `city_name` VARCHAR(45) NOT NULL,
  `Country_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`city_name`),
  UNIQUE INDEX `city_id_UNIQUE` (`city_name` ASC) VISIBLE,
  INDEX `fk_City_Country1_idx` (`Country_name` ASC) VISIBLE,
  CONSTRAINT `fk_City_Country1`
    FOREIGN KEY (`Country_name`)
    REFERENCES `mydb`.`Country` (`Country_name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Client` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Client` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `city_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE INDEX `client_id_UNIQUE` (`client_id` ASC) VISIBLE,
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE,
  INDEX `fk_Client_City1_idx` (`city_name` ASC) VISIBLE,
  CONSTRAINT `fk_Client_City1`
    FOREIGN KEY (`city_name`)
    REFERENCES `mydb`.`City` (`city_name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Restaurant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Restaurant` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Restaurant` (
  `restaurant_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`restaurant_id`),
  UNIQUE INDEX `restaurant_id_UNIQUE` (`restaurant_id` ASC) VISIBLE,
  UNIQUE INDEX `address_UNIQUE` (`address` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Product_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Product_type` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Product_type` (
  `product_type_id` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`product_type_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Product` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  `restaurant_id` INT NOT NULL,
  `product_type_id` INT NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC) VISIBLE,
  INDEX `fk_Product_Restaurant_idx` (`restaurant_id` ASC) VISIBLE,
  INDEX `fk_Product_Product_type1_idx` (`product_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_Product_Restaurant`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `mydb`.`Restaurant` (`restaurant_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Product_Product_type1`
    FOREIGN KEY (`product_type_id`)
    REFERENCES `mydb`.`Product_type` (`product_type_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Wallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Wallet` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Wallet` (
  `wallet_id` INT NOT NULL,
  `wallet_amount` INT UNSIGNED NULL,
  `wallet_limit` INT UNSIGNED NULL,
  PRIMARY KEY (`wallet_id`),
  UNIQUE INDEX `wallet_id_UNIQUE` (`wallet_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vehicle_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Vehicle_type` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Vehicle_type` (
  `Vehicle_type_id` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`Vehicle_type_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vehicle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Vehicle` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Vehicle` (
  `vehicle_id` INT NOT NULL,
  `Vehicle_type_id` INT NOT NULL,
  PRIMARY KEY (`vehicle_id`),
  INDEX `fk_Vehicle_Vehicle_type1_idx` (`Vehicle_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_Vehicle_Vehicle_type1`
    FOREIGN KEY (`Vehicle_type_id`)
    REFERENCES `mydb`.`Vehicle_type` (`Vehicle_type_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Courier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Courier` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Courier` (
  `courier_id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `wallet_id` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  PRIMARY KEY (`courier_id`),
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE,
  INDEX `fk_Courier_Wallet1_idx` (`wallet_id` ASC) VISIBLE,
  INDEX `fk_Courier_Vehicle1_idx` (`vehicle_id` ASC) VISIBLE,
  CONSTRAINT `fk_Courier_Wallet`
    FOREIGN KEY (`wallet_id`)
    REFERENCES `mydb`.`Wallet` (`wallet_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Courier_Vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `mydb`.`Vehicle` (`vehicle_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Payment_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Payment_type` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Payment_type` (
  `Payment_type_id` INT NOT NULL AUTO_INCREMENT,
  `type_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Payment_type_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Token` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Token` (
  `token_id` VARCHAR(20) NOT NULL,
  `validity` BINARY NOT NULL,
  `wallet_id` INT NOT NULL,
  PRIMARY KEY (`token_id`),
  UNIQUE INDEX `token_id_UNIQUE` (`token_id` ASC) VISIBLE,
  INDEX `fk_Token_Wallet1_idx` (`wallet_id` ASC) VISIBLE,
  CONSTRAINT `fk_Token_Wallet1`
    FOREIGN KEY (`wallet_id`)
    REFERENCES `mydb`.`Wallet` (`wallet_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Delivery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Delivery` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Delivery` (
  `delivery_id` INT NOT NULL AUTO_INCREMENT,
  `courier_id` INT NOT NULL,
  `restaurant_id` INT NOT NULL,
  `delivery_date` DATE NOT NULL,
  `delivery_time` TIME NOT NULL,
  PRIMARY KEY (`delivery_id`),
  INDEX `fk_Courier_has_Restaurant_Restaurant1_idx` (`restaurant_id` ASC) INVISIBLE,
  INDEX `fk_Courier_has_Restaurant_Courier1_idx` (`courier_id` ASC) VISIBLE,
  CONSTRAINT `fk_Courier_has_Restaurant_Courier`
    FOREIGN KEY (`courier_id`)
    REFERENCES `mydb`.`Courier` (`courier_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Courier_has_Restaurant_Restaurant`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `mydb`.`Restaurant` (`restaurant_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `order_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Order_date` DATE NOT NULL,
  `Order_time` TIME NOT NULL,
  `client_id` INT NOT NULL,
  `restaurant_id` INT NOT NULL,
  `delivery_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_Order_Client1_idx` (`client_id` ASC) VISIBLE,
  INDEX `fk_Order_Restaurant1_idx` (`restaurant_id` ASC) VISIBLE,
  INDEX `fk_Order_Delivery1_idx` (`delivery_id` ASC) VISIBLE,
  CONSTRAINT `fk_Order_Client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `mydb`.`Client` (`client_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Order_Restaurant1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `mydb`.`Restaurant` (`restaurant_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Order_Delivery1`
    FOREIGN KEY (`delivery_id`)
    REFERENCES `mydb`.`Delivery` (`delivery_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Review` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Review` (
  `client_id` INT NOT NULL,
  `restaurant_id` INT NOT NULL,
  `comment` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`client_id`, `restaurant_id`),
  INDEX `fk_Client_has_Restaurant_Restaurant2_idx` (`restaurant_id` ASC) VISIBLE,
  INDEX `fk_Client_has_Restaurant_Client1_idx` (`client_id` ASC) VISIBLE,
  CONSTRAINT `fk_Client_has_Restaurant_Client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `mydb`.`Client` (`client_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Client_has_Restaurant_Restaurant2`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `mydb`.`Restaurant` (`restaurant_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Payment` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Payment` (
  `order_id` INT UNSIGNED NOT NULL,
  `price` DECIMAL NOT NULL,
  `client_id` INT NOT NULL,
  `restaurant_id` INT NOT NULL,
  `Order_date` DATE NOT NULL,
  `Order_time` TIME NOT NULL,
  `Payment_type_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_Payment_Client` (`client_id` ASC) INVISIBLE,
  INDEX `fk_Payment_Restaurant` (`restaurant_id` ASC) VISIBLE,
  INDEX `fk_Payment_Order1_idx` (`order_id` ASC) VISIBLE,
  INDEX `fk_Payment_Payment_type1_idx` (`Payment_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_Payment_Client`
    FOREIGN KEY (`client_id`)
    REFERENCES `mydb`.`Client` (`client_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Payment_Restaurant`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `mydb`.`Restaurant` (`restaurant_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Payment_Order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `mydb`.`Order` (`order_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Payment_Payment_type1`
    FOREIGN KEY (`Payment_type_id`)
    REFERENCES `mydb`.`Payment_type` (`Payment_type_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Payout`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Payout` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Payout` (
  `courier_id` INT NOT NULL,
  `restaurant_id` INT NOT NULL,
  `amount` DECIMAL NOT NULL,
  PRIMARY KEY (`courier_id`, `restaurant_id`),
  INDEX `fk_Courier_has_Restaurant_Restaurant1_idx` (`restaurant_id` ASC) VISIBLE,
  INDEX `fk_Courier_has_Restaurant_Courier1_idx` (`courier_id` ASC) VISIBLE,
  CONSTRAINT `fk_Courier_has_Restaurant_Courier1`
    FOREIGN KEY (`courier_id`)
    REFERENCES `mydb`.`Courier` (`courier_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Courier_has_Restaurant_Restaurant1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `mydb`.`Restaurant` (`restaurant_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Item` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Item` (
  `order_id` INT UNSIGNED NOT NULL,
  `product_id` INT NOT NULL,
  `item_name` VARCHAR(45) NOT NULL,
  `item_quantity` INT NOT NULL,
  `item_price` DECIMAL NOT NULL,
  PRIMARY KEY (`order_id`, `product_id`),
  INDEX `fk_Item_Product1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_Item_Order1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_Item_Product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`Product` (`product_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Item_Order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `mydb`.`Order` (`order_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`City_has_Restaurant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`City_has_Restaurant` ;

CREATE TABLE IF NOT EXISTS `mydb`.`City_has_Restaurant` (
  `city_name` VARCHAR(45) NOT NULL,
  `restaurant_id` INT NOT NULL,
  PRIMARY KEY (`city_name`, `restaurant_id`),
  INDEX `fk_City_has_Restaurant_Restaurant1_idx` (`restaurant_id` ASC) VISIBLE,
  INDEX `fk_City_has_Restaurant_City1_idx` (`city_name` ASC) VISIBLE,
  CONSTRAINT `fk_City_has_Restaurant_City1`
    FOREIGN KEY (`city_name`)
    REFERENCES `mydb`.`City` (`city_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_City_has_Restaurant_Restaurant1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `mydb`.`Restaurant` (`restaurant_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
