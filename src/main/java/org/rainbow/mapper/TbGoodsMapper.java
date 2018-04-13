package org.rainbow.mapper;

import org.rainbow.pojo.TbGoods;

import java.util.List;

public interface TbGoodsMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(TbGoods record);

    int insertSelective(TbGoods record);

    TbGoods selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(TbGoods record);

    int updateByPrimaryKey(TbGoods record);

    List<TbGoods> selectAll();

    List<TbGoods> searchGoods(String key);
}