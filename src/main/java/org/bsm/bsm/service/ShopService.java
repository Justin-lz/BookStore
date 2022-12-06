package org.bsm.bsm.service;

import org.bsm.bsm.entity.Shop;

import java.util.List;

public interface ShopService{

    Integer addShop(Integer Uid,Integer Bid,Integer Scount);

    List<Shop> allShopByUid(Integer Uid);

    Integer updateShop(Integer Uid,Integer Bid,Integer Scount);

    Integer deleteShop(Integer Uid,Integer Bid);

}