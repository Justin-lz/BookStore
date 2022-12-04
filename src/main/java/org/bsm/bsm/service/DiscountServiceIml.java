package org.bsm.bsm.service;

import org.bsm.bsm.entity.Discount;
import org.bsm.bsm.mapper.DiscountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class DiscountServiceIml{

    @Autowired
    private DiscountMapper discountMapper;

    @Override
    public List<Discount> getAll(){
        return discountMapper.getAll();
    }

    @Override
    public Integer insertDiscount(Discount discount){
        return discountMapper.insertDiscount(discount);
    }

}
