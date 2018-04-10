package org.rainbow.mapper;

import org.rainbow.pojo.TbOrder;

public interface TbOrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);

    TbOrder selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(TbOrder record);

    int updateByPrimaryKey(TbOrder record);
}