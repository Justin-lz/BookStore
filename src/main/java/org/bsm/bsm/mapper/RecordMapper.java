package org.bsm.bsm.mapper;


import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
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

    @Select("Select * from bsm.record where Rcheck = 'no' or Rdeliever ='no'")
    List<Record> getRecordNeedCheckByManager();

    @Update("Update bsm.record set Rcheck = 'yes' where Rid = #{Rid}")
    Integer checkRecordByManager(Integer Rid);

    @Update("Update bsm.record set Rdeliever = 'yes' where Rid = #{Rid}")
    Integer deliverRecordByManager(Integer Rid);

    @Delete("delete from bsm.record where Rid =#{Rid}")
    Integer deleteRecordByManager(Integer Rid);

}
