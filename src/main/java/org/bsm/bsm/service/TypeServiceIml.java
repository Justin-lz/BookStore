package org.bsm.bsm.service;

import org.bsm.bsm.entity.Type;
import org.bsm.bsm.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceIml implements TypeService{

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }

    @Override
    public String newType(Type type) {
        Integer affect = typeMapper.newType(type);
        if (affect.equals(0))
            return "插入失败";
        else
            return "插入成功";
    }
}
