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
