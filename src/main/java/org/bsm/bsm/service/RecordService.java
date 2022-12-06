package org.bsm.bsm.service;

import org.bsm.bsm.entity.Record;

public interface RecordService {

    Integer newRecord(Integer[] Bids, Record record) throws Exception;

}
