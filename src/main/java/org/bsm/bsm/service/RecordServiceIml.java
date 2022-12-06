package org.bsm.bsm.service;

import org.bsm.bsm.entity.History;
import org.bsm.bsm.mapper.HistoryMapper;
import org.bsm.bsm.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.bsm.bsm.entity.Record;


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
}
