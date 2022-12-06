package org.bsm.bsm.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.Record;

import java.util.List;

@Mapper
public interface RecordMapper {

    @Insert("Insert into bsm.record (Rtime,Aid,Uid,Rdiscount,Rprice) values (Now(),#{Aid},#{Uid},#{Rdiscount},#{Rprice})")
    Integer newRecord(Record record);

    @Select("Select * from bsm.record where (Uid = #{Uid}) order by Rtime desc limit 1 ")
    Record getRecord(Record record);

    @Select("Select * from bsm.record where (Rid = #{Rid})")
    List<Record> getRecordByUid(Integer Uid);

}
