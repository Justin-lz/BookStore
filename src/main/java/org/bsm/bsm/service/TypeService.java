package org.bsm.bsm.service;

import org.bsm.bsm.entity.Type;

import java.util.List;

public interface TypeService {

    public List<Type> getAllType();
    public String newType(Type type);

}
