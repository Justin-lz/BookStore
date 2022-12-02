package org.bsm.bsm.mapper;

import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("Select * from bsm.book order by Bid desc limit #{start}, 12;")
    List<Book> queryAllBook(Integer start);//获取所有书本数据

    @Select("Select * from bsm.book where tid=${type} order by Bid desc limit ${start}, 12;")
    List<Book> queryTypeBook(@Param("start") Integer start,@Param("type") String type);

    @Select("Select * from bsm.book where Bname REGEXP '${str}' order by Bid desc limit ${start}, 12;")
    List<Book> queryStrBook(@Param("start")Integer start,@Param("str")String str);

    @Select("Select * from bsm.book where tid=${type} and Bname REGEXP '${str}' order by Bid desc limit ${start}, 12;")
    List<Book> queryTypeStrBook(@Param("start")Integer start,@Param("type")String type,@Param("str")String str);

    @Insert("INSERT INTO `bsm`.`book` (`Bid`, `Bname`, `Bauthor`, `Bpress`, `Bprice`, `Bcount`, `Bresume`, `Tid`) VALUES (#{Bid}, #{Bname}, #{Bauthor},#{Bpress},#{Bprice},#{Bcount},#{Bresume},#{Tid});")
    Integer insertBook(Book book);//插入书本

    @Select("Select * from bsm.book order by rand() limit 6;")
    List<Book> queryHomeBook();

    @Select("SELECT * FROM bsm.book_type where Bid =#{Bid};")
    Book queryOneBookWithType(String Bid);
}
