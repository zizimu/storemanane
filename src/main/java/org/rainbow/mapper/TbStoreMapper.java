package org.rainbow.mapper;

import org.rainbow.pojo.TbStore;

public interface TbStoreMapper {
    int deleteByPrimaryKey(Long storeId);

    int insert(TbStore record);

    int insertSelective(TbStore record);

    TbStore selectByPrimaryKey(Long storeId);

    int updateByPrimaryKeySelective(TbStore record);

    int updateByPrimaryKey(TbStore record);
}