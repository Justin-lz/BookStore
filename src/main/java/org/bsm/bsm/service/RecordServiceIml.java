package org.bsm.bsm.service;


import org.bsm.bsm.entity.History;
import org.bsm.bsm.mapper.HistoryMapper;
import org.bsm.bsm.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.bsm.bsm.entity.Record;

import java.util.List;


@Service
public class RecordServiceIml implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private HistoryMapper historyMapper;


    @Override
    @Transactional
    public Integer newRecord(Integer[] Bids, Record record) throws Exception {
        recordMapper.newRecord(record);//生成record
        record = recordMapper.getRecord(record);//获取rid
        Integer rid = record.getRid();

        for (Integer Bid:Bids){//将选中的购物车条目转化成历史记录
            History history = new History();
            history.setBid(Bid);
            history.setRid(rid);
            historyMapper.newHistory(history);//删除操作交给触发器
        }

        return 1;
    }

    @Override
    public List<Record> getRecordByUid(Integer Uid) {
        List<Record> records = recordMapper.getRecordByUid(Uid);
        for (Record record:records){
            record.setHistories(historyMapper.getHistoryByRid(record.getRid()));
        }
        return records;
    }

    @Override
    public List<Record> getRecordNeedCheckByManager() {
        List<Record> records = recordMapper.getRecordNeedCheckByManager();
        for (Record record:records){
            record.setHistories(historyMapper.getHistoryByRid(record.getRid()));
        }
        return records;
    }

    @Override
    public Integer checkRecordByManager(Integer Rid) {
        return recordMapper.checkRecordByManager(Rid);
    }

    @Override
    public Integer deliverRecordByManager(Integer Rid) {
        return recordMapper.deliverRecordByManager(Rid);
    }

    @Override
    @Transactional
    public Integer deleteRecordByManager(Integer Rid) {
        Integer integer = historyMapper.deleteHistory(Rid);
        recordMapper.deleteRecordByManager(Rid);
        return integer;
    }
}
