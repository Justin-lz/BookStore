package org.bsm.bsm.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.bsm.bsm.entity.Record;

import java.util.List;

public interface RecordService {

    Integer newRecord(Integer[] Bids, Record record) throws Exception;

    List<Record> getRecordByUid(Integer Uid);

    List<Record> getRecordNeedCheckByManager();

    Integer checkRecordByManager(Integer Rid);

    Integer deliverRecordByManager(Integer Rid);

    Integer deleteRecordByManager(Integer Rid);

}
