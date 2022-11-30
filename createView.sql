CREATE VIEW `book_type` AS select Bid,Bname,Bauthor,Bprice,Bcount,Bpress,Bresume,Tname from type,bsm.book  where (book.Tid = type.Tid);
