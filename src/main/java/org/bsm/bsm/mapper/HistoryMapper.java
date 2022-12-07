package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.History;

import java.util.List;

@Mapper
public interface HistoryMapper {

    @Insert("Insert into bsm.history (Rid,Bid,count) values (#{Rid},#{Bid},#{count})")
    Integer newHistory(History history);

    @Select("Select * from bsm.history_book where Rid = #{Rid}")
    List<History> getHistoryByRid(Integer Rid);

    @Delete("Delete from bsm.history where Rid = #{Rid}")
    Integer deleteHistory(Integer Rid);

}
