CREATE VIEW `book_type` AS select Bid,Bname,Bauthor,Bprice,Bcount,Bpress,Bresume,Tname from type,bsm.book  where (book.Tid = type.Tid);


DROP TRIGGER IF EXISTS `bsm`.`address_BEFORE_INSERT`;

DELIMITER $$
USE `bsm`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `address_BEFORE_INSERT` BEFORE INSERT ON `address` FOR EACH ROW BEGIN
	set @maxget = (select max(Aid) from bsm.Address
    );
	set new.Aid = ifnull(@maxget + 1,1);
END$$
DELIMITER ;


