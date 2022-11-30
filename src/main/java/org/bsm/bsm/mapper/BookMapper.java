package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("Select * from bsm.book;")
    List<Book> queryAllBook();//获取所有书本数据

    @Insert("INSERT INTO `bsm`.`book` (`Bid`, `Bname`, `Bauthor`, `Bpress`, `Bprice`, `Bcount`, `Bresume`, `Tid`) VALUES (#{Bid}, #{Bname}, #{Bauthor},#{Bpress},#{Bprice},#{Bcount},#{Bresume},#{Tid});")
    Integer insertBook(Book book);//插入书本

    @Select("Select * from bsm.book order by rand() limit 6;")
    List<Book> queryHomeBook();
}
