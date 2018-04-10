package org.rainbow.mapper;

import org.rainbow.pojo.TbGoodstype;

public interface TbGoodstypeMapper {
    int deleteByPrimaryKey(Long typeid);

    int insert(TbGoodstype record);

    int insertSelective(TbGoodstype record);

    TbGoodstype selectByPrimaryKey(Long typeid);

    int updateByPrimaryKeySelective(TbGoodstype record);

    int updateByPrimaryKey(TbGoodstype record);
}