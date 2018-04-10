package org.rainbow.mapper;

import org.rainbow.pojo.TbGoods;

public interface TbGoodsMapper {
    int deleteByPrimaryKey(Long gid);

    int insert(TbGoods record);

    int insertSelective(TbGoods record);

    TbGoods selectByPrimaryKey(Long gid);

    int updateByPrimaryKeySelective(TbGoods record);

    int updateByPrimaryKey(TbGoods record);
}