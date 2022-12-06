package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.bsm.bsm.entity.History;

@Mapper
public interface HistoryMapper {

    @Insert("Insert into bsm.history (Rid,Bid,count) values (#{Rid},#{Bid},#{count})")
    Integer newHistory(History history);

}
