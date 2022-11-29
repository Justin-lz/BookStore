CREATE TABLE if not exists `bsm`.`type` (
                              `Tid` INT NOT NULL AUTO_INCREMENT,
                              `Tname` VARCHAR(45) NOT NULL,
                              `Tresume` VARCHAR(1000) NULL,
                              PRIMARY KEY (`Tid`));

CREATE TABLE if not exists `bsm`.`book` (
                              `Bid` INT NOT NULL,
                              `Bname` VARCHAR(45) NOT NULL,
                              `Bauthor` VARCHAR(45) NOT NULL,
                              `Bpress` VARCHAR(45) NOT NULL,
                              `Bprice` DECIMAL(10,2) NOT NULL,
                              `Bcount` INT NOT NULL,
                              `Bresume` VARCHAR(1000) NULL,
                              `Tid` INT NOT NULL,
                              PRIMARY KEY (`Bid`),
                              INDEX `Tid_idx` (`Tid` ASC) VISIBLE,
                              CONSTRAINT `Tid`
                                  FOREIGN KEY (`Tid`)
                                      REFERENCES `bsm`.`type` (`Tid`)
                                      ON DELETE NO ACTION
                                      ON UPDATE NO ACTION);

CREATE TABLE if not exists `bsm`.`user` (
                              `Uid` INT NOT NULL,
                              `UPword` VARCHAR(20) NOT NULL,
                              `Uname` VARCHAR(45) NOT NULL,
                              `Ubirth` DATE NULL,
                              `Usex` ENUM('男', '女') NULL,
                              `Uaddress` VARCHAR(100) NULL,
                              `Uphone` VARCHAR(20) NULL,
                              PRIMARY KEY (`Uid`),
                              UNIQUE INDEX `Uname_UNIQUE` (`Uname` ASC) VISIBLE);

ALTER TABLE `bsm`.`user`
    CHANGE COLUMN `Uid` `Uid` INT NOT NULL AUTO_INCREMENT ;

CREATE TABLE if not exists `bsm`.`address` (
                                 `Aid` INT NOT NULL,
                                 `Uid` INT NOT NULL,
                                 `Aaddress` VARCHAR(100) NOT NULL,
                                 `Areceiver` VARCHAR(45) NOT NULL,
                                 `Aphone` VARCHAR(20) NOT NULL,
                                 PRIMARY KEY (`Aid`),
                                 INDEX `uid_idx` (`Uid` ASC) VISIBLE,
                                 CONSTRAINT `uid`
                                     FOREIGN KEY (`Uid`)
                                         REFERENCES `bsm`.`user` (`Uid`)
                                         ON DELETE NO ACTION
                                         ON UPDATE NO ACTION);

CREATE TABLE if not exists `bsm`.`record` (
                                `Rid` INT NOT NULL AUTO_INCREMENT,
                                `Rtime` DATETIME NOT NULL,
                                `Aid` INT NOT NULL,
                                `Uid` INT NOT NULL,
                                `Rdiscount` VARCHAR(100) NOT NULL,
                                `Rprice` DECIMAL(10,2) NOT NULL,
                                `Rcheck` ENUM('yes', 'no') NULL DEFAULT 'no',
                                `Rdeliever` ENUM('yes', 'no') NULL DEFAULT 'no',
                                `Rreceive` ENUM('yes', 'no') NULL DEFAULT 'no',
                                PRIMARY KEY (`Rid`));
ALTER TABLE `bsm`.`record`
        ADD CONSTRAINT if not exists `UidR`
            FOREIGN KEY (`Uid`)
                REFERENCES `bsm`.`user` (`Uid`)
                ON DELETE NO ACTION
                ON UPDATE NO ACTION,
        ADD CONSTRAINT  if not exists`AidR`
            FOREIGN KEY (`Aid`)
                REFERENCES `bsm`.`address` (`Aid`)
                ON DELETE NO ACTION
                ON UPDATE NO ACTION;

CREATE TABLE if not exists `bsm`.`history` (
                                 `Rid` INT NOT NULL,
                                 `Bid` INT NOT NULL,
                                 `count` INT NOT NULL,
                                 PRIMARY KEY (`Rid`, `Bid`),
                                 INDEX `BidH_idx` (`Bid` ASC) VISIBLE,
                                 CONSTRAINT `BidH`
                                     FOREIGN KEY (`Bid`)
                                         REFERENCES `bsm`.`book` (`Bid`)
                                         ON DELETE NO ACTION
                                         ON UPDATE NO ACTION,
                                 CONSTRAINT `RidH`
                                     FOREIGN KEY (`Rid`)
                                         REFERENCES `bsm`.`record` (`Rid`)
                                         ON DELETE NO ACTION
                                         ON UPDATE NO ACTION);

CREATE TABLE if not exists `bsm`.`shop` (
                              `Bid` INT NOT NULL,
                              `Uid` INT NOT NULL,
                              `Scount` INT NOT NULL,
                              PRIMARY KEY (`Bid`, `Uid`),
                              INDEX `UidS_idx` (`Uid` ASC) VISIBLE,
                              CONSTRAINT `BidS`
                                  FOREIGN KEY (`Bid`)
                                      REFERENCES `bsm`.`book` (`Bid`)
                                      ON DELETE NO ACTION
                                      ON UPDATE NO ACTION,
                              CONSTRAINT `UidS`
                                  FOREIGN KEY (`Uid`)
                                      REFERENCES `bsm`.`user` (`Uid`)
                                      ON DELETE NO ACTION
                                      ON UPDATE NO ACTION);

CREATE TABLE `bsm`.`discount` (
                                  `Did` INT NOT NULL AUTO_INCREMENT,
                                  `Dcount` INT NOT NULL DEFAULT 1,
                                  `Dprice` DECIMAL(10,2) NOT NULL DEFAULT 1.00,
                                  `Ddis` DECIMAL(3,2) NOT NULL DEFAULT 1.00,
                                  `Ddec` DECIMAL(10,2) NOT NULL DEFAULT 0,
                                  `Dstart` DATETIME NOT NULL,
                                  `Dend` DATETIME NOT NULL,
                                  PRIMARY KEY (`Did`));

CREATE TABLE `bsm`.`message` (
                                 `Mid` INT NOT NULL AUTO_INCREMENT,
                                 `Uid` INT NOT NULL,
                                 `Mword` VARCHAR(1000) NULL,
                                 `Mtime` DATETIME NULL,
                                 `Mread` ENUM("yes", "no") NULL DEFAULT 'no',
                                 PRIMARY KEY (`Mid`),
                                 INDEX `UidM_idx` (`Uid` ASC) VISIBLE,
                                 CONSTRAINT `UidM`
                                     FOREIGN KEY (`Uid`)
                                         REFERENCES `bsm`.`user` (`Uid`)
                                         ON DELETE NO ACTION
                                         ON UPDATE NO ACTION);

CREATE TABLE `bsm`.`manager` (
                                 `Mid` INT NOT NULL,
                                 `Mauthority` ENUM("common", "power") NOT NULL,
                                 `Mpassword` VARCHAR(20) NOT NULL,
                                 PRIMARY KEY (`Mid`));

CREATE
    VIEW `user_info` AS
SELECT
    `user`.`Uname` AS `Uname`,
    `user`.`Uid` AS `Uid`,
    `user`.`Ubirth` AS `Ubirth`,
    `user`.`Usex` AS `Usex`,
    `user`.`Uaddress` AS `Uaddress`,
    `user`.`Uphone` AS `Uphone`
FROM
    `user`;

CREATE  OR REPLACE VIEW `user_log_in` AS (select Uid, Uname, UPword from bsm.user );