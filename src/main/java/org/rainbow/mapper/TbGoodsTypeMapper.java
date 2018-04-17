package org.rainbow.mapper;

import org.rainbow.pojo.TbGoodsType;

import java.util.List;

public interface TbGoodsTypeMapper {
    int deleteByPrimaryKey(Long typeId);

    int insert(TbGoodsType record);

    int insertSelective(TbGoodsType record);

    TbGoodsType selectByPrimaryKey(Long typeId);

    int updateByPrimaryKeySelective(TbGoodsType record);

    int updateByPrimaryKey(TbGoodsType record);

    List<TbGoodsType> selectAll();

    List<TbGoodsType> searchType(String key);

    List<TbGoodsType> getAllTypeName();
}