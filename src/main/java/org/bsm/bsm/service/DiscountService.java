package org.bsm.bsm.service;

import org.bsm.bsm.entity.Discount;

import java.util.List;

public interface DiscountService{

    Integer insertDiscount(Discount discount);
    
    public List<Discount> getAll();

    public Discount getUse();

    Integer updateDiscount(Discount discount);

    Integer deleteDiscount(Integer Did);
}