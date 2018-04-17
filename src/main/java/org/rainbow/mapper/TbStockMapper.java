package org.rainbow.mapper;

import org.rainbow.pojo.TbStock;
import org.rainbow.pojo.TbStockKey;

import java.util.List;

public interface TbStockMapper {
    int deleteByPrimaryKey(TbStockKey key);

    int insert(TbStock record);

    int insertSelective(TbStock record);

    TbStock selectByPrimaryKey(TbStockKey key);

    int updateByPrimaryKeySelective(TbStock record);

    int updateByPrimaryKey(TbStock record);

    List<TbStock> selectAll();

    List<TbStock> searchStock(String key);

    List<Long> getAllBatch();
}