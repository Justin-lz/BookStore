package org.bsm.bsm.service;

import org.bsm.bsm.entity.Record;

import java.util.List;

public interface RecordService {

    Integer newRecord(Integer[] Bids, Record record) throws Exception;

    List<Record> getRecordByUid(Integer Uid);

}
