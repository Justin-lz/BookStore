DROP TRIGGER IF EXISTS `bsm`.`history_BEFORE_INSERT`;

DELIMITER $$
USE `bsm`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `history_BEFORE_INSERT` BEFORE INSERT ON `history` FOR EACH ROW BEGIN
	Set @uid = (select uid from record where Rid = new.Rid);
    set @count =(select Scount from shop where Uid = @uid and Bid = new.Bid);
    set new.count = @count;
delete from shop where Uid = @uid and Bid = New.Bid;
update book set Bcount = Bcount - @count where Bid = new.Bid;
END$$
DELIMITER ;

USE `bsm`;
CREATE  OR REPLACE VIEW `history_book` AS select history.Bid, history.count, book.Bname from history left join book on history.Bid = book.Bid;

USE `bsm`;
CREATE
    OR REPLACE ALGORITHM = UNDEFINED
    DEFINER = `root`@`localhost`
    SQL SECURITY DEFINER
    VIEW `history_book` AS
SELECT
    `history`.`Bid` AS `Bid`,
    `history`.`count` AS `count`,
    `book`.`Bname` AS `Bname`,
    `history`.`Rid` AS `Rid`
FROM
    (`history`
        LEFT JOIN `book` ON ((`history`.`Bid` = `book`.`Bid`)));
