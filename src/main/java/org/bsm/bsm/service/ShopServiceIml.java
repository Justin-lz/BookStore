package org.bsm.bsm.service;

import org.bsm.bsm.entity.Shop;
import org.bsm.bsm.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ShopServiceIml implements ShopService{

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Integer addShop(Integer Uid,Integer Bid,Integer Scount){
        Shop shop = new Shop();
        shop.setUid(Uid);
        shop.setBid(Bid);
        Shop checkUidBid = shopMapper.checkUidBid(shop);
        if (checkUidBid==null){
            shop.setScount(Scount);
            return shopMapper.newShop(shop);
        }else{
            shop.setScount(Scount+checkUidBid.getScount());
            return shopMapper.changeShop(shop);
        }  
    }

    @Override
    public List<Shop> allShopByUid(Integer Uid){
        return shopMapper.allShopByUid(Uid);
    }


}