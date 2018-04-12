package org.rainbow.mapper;

import org.rainbow.pojo.TbStock;
import org.rainbow.pojo.TbStockKey;

public interface TbStockMapper {
    int deleteByPrimaryKey(TbStockKey key);

    int insert(TbStock record);

    int insertSelective(TbStock record);

    TbStock selectByPrimaryKey(TbStockKey key);

    int updateByPrimaryKeySelective(TbStock record);

    int updateByPrimaryKey(TbStock record);
}